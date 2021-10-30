/*
 * Copyright (c) 2021, Istomin Andrei
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.aistomin.trainer.examinations;

import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.PrettyPrint;
import com.github.aistomin.trainer.deutsch.utils.JsonFile;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * User implementation that takes data from JSON file.
 *
 * @since 1.0
 */
public final class JsonUser implements User {

    /**
     * User ID field in JSON file.
     */
    public static final String ID = "id";

    /**
     * Username field in JSON file.
     */
    public static final String NAME = "username";

    /**
     * The synchronisation object.
     */
    private static final Object MUTEX = new Object();

    /**
     * File.
     */
    private final File storage;

    /**
     * JSON.
     */
    private final JsonObject json;

    /**
     * Ctor.
     *
     * @param file JSON file.
     */
    public JsonUser(final File file) {
        this(file, JsonUser.parseJson(file));
    }

    /**
     * Ctor.
     *
     * @param file File.
     * @param obj JSON object.
     */
    public JsonUser(final File file, final JsonObject obj) {
        this.storage = file;
        this.json = obj;
    }

    /**
     * Ctor.
     *
     * @param file File.
     * @param id User ID.
     * @param username Username.
     */
    public JsonUser(final File file, final Long id, final String username) {
        this(file, JsonUser.createUser(id, username));
    }

    @Override
    public Long identifier() {
        synchronized (JsonUser.MUTEX) {
            return this.json.getLong(JsonUser.ID, 0L);
        }
    }

    @Override
    public String username() {
        synchronized (JsonUser.MUTEX) {
            return this.json.getString(JsonUser.NAME, "");
        }
    }

    @Override
    public void changeUsername(final String username) throws IOException {
        synchronized (JsonUser.MUTEX) {
            this.json.set(JsonUser.NAME, username);
            this.save();
        }
    }

    @Override
    public User clone(final File file) {
        return this.clone(file, this.identifier());
    }

    @Override
    public User clone(final File file, final Long id) {
        return new JsonUser(file, id, this.username());
    }

    @Override
    public User dump(final File file) throws IOException {
        synchronized (JsonUser.MUTEX) {
            final String content = this.json.toString(PrettyPrint.PRETTY_PRINT);
            final BufferedWriter writer =
                Files.newBufferedWriter(file.toPath());
            writer.write(content);
            writer.close();
            return new JsonUser(file);
        }
    }

    /**
     * Get JSON file where user is stored.
     *
     * @return File.
     */
    public File file() {
        return this.storage;
    }

    /**
     * Save user to the associated file.
     *
     * @throws IOException If read/write error occurs.
     */
    private void save() throws IOException {
        this.dump(this.storage);
    }

    /**
     * Parse JSON content of the file.
     *
     * @param file JSON file.
     * @return JSON Object.
     */
    private static JsonObject parseJson(final File file) {
        return new JsonFile(file).json();
    }

    /**
     * Create JSON object with user's data.
     *
     * @param id User ID.
     * @param username Username.
     * @return JSON object.
     */
    private static JsonObject createUser(final Long id, final String username) {
        final JsonObject obj = new JsonObject();
        obj.set(JsonUser.ID, id);
        obj.set(JsonUser.NAME, username);
        return obj;
    }
}
