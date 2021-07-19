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

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
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
     * JSON file.
     */
    private final File source;

    /**
     * Ctor.
     *
     * @param file JSON file.
     */
    public JsonUser(final File file) {
        this.source = file;
    }

    @Override
    public Long identifier() {
        return this.json().getLong("id", 0L);
    }

    @Override
    public String username() {
        return this.json().getString("username", "");
    }

    /**
     * Parse JSON content of the file.
     *
     * @return JSON Object.
     */
    private JsonObject json() {
        try {
            return Json.parse(
                Files.newBufferedReader(this.source.toPath())
            ).asObject();
        } catch (final IOException exception) {
            throw new IllegalStateException(exception);
        }
    }
}
