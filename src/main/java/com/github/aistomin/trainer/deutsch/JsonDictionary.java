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

import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import com.eclipsesource.json.PrettyPrint;
import com.github.aistomin.trainer.deutsch.utils.JsonFile;
import com.github.aistomin.trainer.deutsch.vocabulary.LexicalUnit;
import com.github.aistomin.trainer.deutsch.vocabulary.Sentence;
import com.github.aistomin.trainer.deutsch.vocabulary.german.GermanVerb;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

/**
 * Dictionary that uses JSON file as a data provider.
 *
 * @since 1.0
 */
public final class JsonDictionary implements Dictionary {

    /**
     * Version JSON field.
     */
    public static final String VER = "version";

    /**
     * Vocabulary JSON field.
     */
    public static final String VOC = "vocabulary";

    /**
     * JSON file.
     */
    private final File source;

    /**
     * Dictionary itself.
     */
    private final JsonObject dict;

    /**
     * Ctor.
     *
     * @param source JSON file.
     */
    @SuppressWarnings("PMD.ConstructorOnlyInitializesOrCallOtherConstructors")
    public JsonDictionary(final File source) {
        this.source = source;
        if (source.exists()) {
            this.dict = this.originalJson();
        } else {
            final JsonObject obj = new JsonObject();
            obj.set(JsonDictionary.VER, "v1.0");
            obj.set(JsonDictionary.VOC, new JsonArray());
            this.dict = obj;
        }
    }

    @Override
    public String version() {
        return this.dict.get(JsonDictionary.VER).asString();
    }

    @Override
    public List<LexicalUnit> words(final WordsFilter filter) {
        final JsonArray vocabulary = this.vocabulary();
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
                        res = new GermanVerb(obj);
                        break;
                    case "i":
                        res = new Sentence(obj);
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

    @Override
    public void validate() throws InvalidDictionaryException {
        final List<Long> ids = new ArrayList<>(0);
        final List<LexicalUnit> words = this.words(WordsFilter.ALL);
        for (final LexicalUnit unit : words) {
            ids.add(unit.identifier());
            ids.addAll(
                unit.relatedLexicalUnits()
                    .stream()
                    .map(LexicalUnit::identifier)
                    .collect(Collectors.toList())
            );
        }
        final Set<Long> unique = new HashSet<>(ids);
        if (ids.size() != unique.size()) {
            final List<Long> duplicates = unique.stream()
                .filter(id -> Collections.frequency(ids, id) > 1)
                .collect(Collectors.toList());
            throw new InvalidDictionaryException(
                String.format(
                    "The dictionary contains non-unique ID(s): %s",
                    duplicates.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(", "))
                )
            );
        }
    }

    @Override
    public Long generateNextId() {
        final List<LexicalUnit> units = new ArrayList<>(0);
        for (final LexicalUnit unit : this.words(WordsFilter.ALL)) {
            units.add(unit);
            units.addAll(unit.relatedLexicalUnits());
        }
        return units.stream()
            .map(LexicalUnit::identifier)
            .max(Long::compareTo)
            .orElse(1L);
    }

    @Override
    public Dictionary dump(final File file) throws IOException {
        final String json = this.dict.toString(PrettyPrint.PRETTY_PRINT);
        final BufferedWriter writer = Files.newBufferedWriter(file.toPath());
        writer.write(json);
        writer.close();
        return new JsonDictionary(file);
    }

    @Override
    public void add(final LexicalUnit unit)
        throws InvalidDictionaryException, IOException {
        this.vocabulary().add(unit.toJson());
        this.save();
    }

    @Override
    public void delete(
        final LexicalUnit unit
    ) throws InvalidDictionaryException, IOException {
        final JsonArray vocabulary = this.vocabulary();
        final Set<Integer> toremove = new HashSet<>();
        IntStream.range(0, vocabulary.size()).forEach(
            idx -> {
                final JsonValue val = vocabulary.get(idx);
                if (val.asObject().getLong("id", 0L) == unit.identifier()) {
                    toremove.add(idx);
                }
            }
        );
        for (final Integer idx : toremove) {
            vocabulary.remove(idx);
        }
        this.save();
    }

    /**
     * Save the dictionary.
     *
     * @throws IOException If read/write error occurs.
     * @throws InvalidDictionaryException If the dictionary became inconsistent
     *  after the modification.
     */
    public void save() throws IOException, InvalidDictionaryException {
        final File backup = new File(
            this.source.getParent(),
            String.format("%s_bk", this.source.getName())
        );
        this.validate();
        final BufferedWriter writer = Files.newBufferedWriter(backup.toPath());
        writer.write(this.originalJson().toString(PrettyPrint.PRETTY_PRINT));
        writer.close();
        this.dump(this.source);
    }

    /**
     * Parse JSON content of the file.
     *
     * @return JSON Object.
     */
    private JsonObject originalJson() {
        return new JsonFile(this.source).json();
    }

    /**
     * Get vocabulary array.
     *
     * @return Array.
     */
    private JsonArray vocabulary() {
        return this.dict.get(JsonDictionary.VOC).asArray();
    }
}
