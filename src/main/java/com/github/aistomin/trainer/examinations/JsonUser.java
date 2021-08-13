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
import com.github.aistomin.trainer.deutsch.utils.JsonFile;
import java.io.File;

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
     * JSON.
     */
    private final JsonObject json;

    /**
     * Ctor.
     *
     * @param file JSON file.
     */
    public JsonUser(final File file) {
        this(JsonUser.parseJson(file));
    }

    /**
     * Ctor.
     *
     * @param obj JSON object.
     */
    public JsonUser(final JsonObject obj) {
        this.json = obj;
    }

    /**
     * Ctor.
     *
     * @param id User ID.
     * @param username Username.
     */
    public JsonUser(final Long id, final String username) {
        this(JsonUser.createUser(id, username));
    }

    @Override
    public Long identifier() {
        return this.json.getLong(JsonUser.ID, 0L);
    }

    @Override
    public String username() {
        return this.json.getString(JsonUser.NAME, "");
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
