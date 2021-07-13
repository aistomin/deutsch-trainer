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
package com.github.aistomin.trainer.deutsch;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import com.github.aistomin.trainer.deutsch.vocabulary.LexicalUnit;
import com.github.aistomin.trainer.deutsch.vocabulary.Sentence;
import com.github.aistomin.trainer.deutsch.vocabulary.SimpleWord;
import com.github.aistomin.trainer.deutsch.vocabulary.Word;
import com.github.aistomin.trainer.deutsch.vocabulary.german.GermanVerb;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Dictionary that uses JSON file as a data provider.
 *
 * @since 1.0
 */
public final class JsonDictionary implements Dictionary {

    /**
     * JSON file.
     */
    private final File source;

    /**
     * Ctor.
     *
     * @param source JSON file.
     */
    public JsonDictionary(final File source) {
        this.source = source;
    }

    @Override
    public String version() {
        return this.json().get("version").asString();
    }

    @Override
    public List<LexicalUnit> words(final WordsFilter filter) {
        final JsonArray vocabulary = this.json().get("vocabulary").asArray();
        return StreamSupport.stream(
            vocabulary.spliterator(), false
        ).filter(
            value -> {
                final boolean res;
                switch (filter) {
                    case ONLY_NEW:
                        res = value.asObject().getBoolean("is_new", false);
                        break;
                    case ALL:
                        res = true;
                        break;
                    default:
                        throw new IllegalStateException("Unknown filter.");
                }
                return res;
            }
        ).map(
            value -> {
                final JsonObject obj = value.asObject();
                final LexicalUnit res;
                switch (obj.get("ps").asString()) {
                    case "v":
                        res = JsonDictionary.createVerb(obj);
                        break;
                    case "n":
                        throw new IllegalStateException(
                            "We do not support nouns for now."
                        );
                    default:
                        throw new IllegalStateException("Wrong file format.");
                }
                return res;
            }
        ).collect(Collectors.toList());
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

    /**
     * Create German verb using JSON data.
     *
     * @param obj JSON object.
     * @return German verb.
     */
    private static GermanVerb createVerb(final JsonObject obj) {
        return new GermanVerb(
            JsonDictionary.createWord(obj.get("infinitive").asObject()),
            JsonDictionary.createWord(obj.get("preterite").asObject()),
            JsonDictionary.createWord(obj.get("perfect").asObject())
        );
    }

    /**
     * Create a word using JSON data.
     *
     * @param obj JSON object.
     * @return Word.
     */
    private static Word createWord(final JsonObject obj) {
        final JsonArray examples = obj.get("ex").asArray();
        final List<Sentence> usages = new ArrayList<>(examples.size());
        for (final JsonValue item : examples) {
            usages.add(JsonDictionary.createSentence(item.asObject()));
        }
        return new SimpleWord(
            obj.get("o").asString(),
            StreamSupport.stream(obj.get("t").asArray().spliterator(), false)
                .map(JsonValue::toString).collect(Collectors.toList()),
            usages
        );
    }

    /**
     * Create a sentence using JSON data.
     *
     * @param obj JSON object.
     * @return Word.
     */
    private static Sentence createSentence(final JsonObject obj) {
        return new Sentence(
            obj.get("o").asString(),
            StreamSupport.stream(obj.get("t").asArray().spliterator(), false)
                .map(JsonValue::toString).collect(Collectors.toList())
        );
    }
}
