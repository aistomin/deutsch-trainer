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
package com.github.aistomin.trainer.deutsch.vocabulary;

import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import com.github.aistomin.testist.Question;
import com.github.aistomin.testist.simple.SimpleAnswer;
import com.github.aistomin.testist.simple.SimpleQuestion;
import com.github.aistomin.testist.simple.SimpleText;
import com.github.aistomin.trainer.deutsch.Dictionary;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * A sentence in the language.
 *
 * @since 1.0
 */
public final class Sentence extends LexicalUnit {

    /**
     * The sentence in original language.
     */
    private final String original;

    /**
     * The correct translations in the student's language.
     */
    private final List<String> translations;

    /**
     * Ctor.
     *
     * @param id Unique unit's identifier.
     * @param their The sentence in original language.
     * @param mine The sentence in the student's language.
     * @param info Some additional free-text information.
     * @param nword Is the unit a new word?
     * @checkstyle ParameterNumberCheck (10 lines)
     */
    public Sentence(
        final Long id, final String their, final String mine, final String info,
        final Boolean nword
    ) {
        this(id, their, Collections.singletonList(mine), info, nword);
    }

    /**
     * Ctor.
     *
     * @param id Unique unit's identifier.
     * @param their The sentence in original language.
     * @param mine The correct translations in the student's language.
     * @param info Some additional free-text information.
     * @param nword Is the unit a new word?
     * @checkstyle ParameterNumberCheck (10 lines)
     */
    public Sentence(
        final Long id, final String their, final List<String> mine,
        final String info, final Boolean nword
    ) {
        super(id, info, nword);
        this.original = their;
        this.translations = mine;
    }

    /**
     * Ctor.
     *
     * @param obj JSON object.
     */
    public Sentence(final JsonObject obj) {
        this(
            obj.get("id").asLong(),
            obj.get("o").asString(),
            StreamSupport.stream(obj.get("t").asArray().spliterator(), false)
                .map(JsonValue::toString).collect(Collectors.toList()),
            Sentence.parseInfo(obj), obj.getBoolean(LexicalUnit.IS_NEW_FIELD, false)
        );
    }

    @Override
    public List<Question> questions() {
        final ArrayList<Question> questions =
            new ArrayList<>(1 + this.translations.size());
        questions.add(
            new SimpleQuestion(
                new SimpleText(this.original),
                this.translations
                    .stream()
                    .map(SimpleAnswer::new)
                    .collect(Collectors.toList())
            )
        );
        for (final String trans : this.translations) {
            questions.add(
                new SimpleQuestion(
                    new SimpleText(trans),
                    new SimpleAnswer(this.original)
                )
            );
        }
        return questions;
    }

    @Override
    public Set<LexicalUnit> relatedLexicalUnits() {
        return new HashSet<>(0);
    }

    @Override
    public LexicalUnit clone(final Dictionary dict) {
        return new Sentence(
            dict.generateNextId(),
            this.original,
            this.translations,
            this.info(),
            this.isNew()
        );
    }

    @Override
    public JsonObject toJson() {
        final JsonObject json = super.toJson();
        json.set("ps", "i");
        json.set("o", this.original);
        final JsonArray trans = new JsonArray();
        for (final String translation : this.translations) {
            trans.add(translation);
        }
        json.set("t", trans);
        return json;
    }
}
