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
package com.github.aistomin.trainer.deutsch.utils;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * JSON file representation.
 *
 * @since 1.0
 */
public final class JsonFile {

    /**
     * JSON file.
     */
    private final File source;

    /**
     * Ctor.
     *
     * @param file JSON file.
     */
    public JsonFile(final File file) {
        this.source = file;
    }

    /**
     * Load JSON object from file.
     *
     * @return JSON object.
     */
    public JsonObject json() {
        return Json.parse(this.content()).asObject();
    }

    /**
     * Load string content of the file.
     *
     * @return String content.
     */
    public String content() {
        final StringBuilder result = new StringBuilder();
        try {
            Files.lines(this.source.toPath(), StandardCharsets.UTF_8)
                .forEach(line -> result.append(line).append("\n"));
        } catch (final IOException exception) {
            throw new IllegalStateException(exception);
        }
        return result.toString();
    }
}
