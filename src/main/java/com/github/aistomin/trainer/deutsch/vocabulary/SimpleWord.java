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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Class that represents a verb in a language.
 *
 * @since 1.0
 */
public final class SimpleWord extends Word {

    /**
     * The word in original language.
     */
    private final String original;

    /**
     * The correct translations in the student's language.
     */
    private final List<String> translations;

    /**
     * Examples of the word usages.
     */
    private final List<Sentence> usages;

    /**
     * Ctor.
     * @param id Unique unit's identifier.
     * @param their The word in original language.
     * @param mine The word in the student's language.
     * @param examples Examples of the word usages.
     * @param info Some additional free-text information.
     * @param nword Is the unit a new word?
     * @checkstyle ParameterNumberCheck (10 lines)
     */
    public SimpleWord(
        final Long id,
        final String their,
        final String mine,
        final List<Sentence> examples,
        final String info,
        final Boolean nword
    ) {
        this(id, their, Collections.singletonList(mine), examples, info, nword);
    }

    /**
     * Ctor.
     *
     * @param id Unique unit's identifier.
     * @param their The word in original language.
     * @param mine The correct translations in the student's language.
     * @param examples Examples of the word usages.
     * @param info Some additional free-text information.
     * @param nword Is the unit a new word?
     * @checkstyle ParameterNumberCheck (10 lines)
     */
    public SimpleWord(
        final Long id,
        final String their,
        final List<String> mine,
        final List<Sentence> examples,
        final String info,
        final Boolean nword
    ) {
        super(id, info, nword);
        this.original = their;
        this.translations = mine;
        this.usages = examples;
    }

    /**
     * Ctor.
     *
     * @param obj JSON object.
     */
    public SimpleWord(final JsonObject obj) {
        this(
            obj.get("id").asLong(),
            obj.get("o").asString(),
            StreamSupport.stream(obj.get("t").asArray().spliterator(), false)
                .map(JsonValue::toString)
                .collect(Collectors.toList()),
            StreamSupport.stream(obj.get("ex").asArray().spliterator(), false)
                .map(item -> new Sentence(item.asObject()))
                .collect(Collectors.toList()),
            SimpleWord.parseInfo(obj), obj.getBoolean("is_new", false)
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
        for (final String str : this.translations) {
            questions.add(
                new SimpleQuestion(
                    new SimpleText(str),
                    new SimpleAnswer(this.original)
                )
            );
        }
        for (final Sentence sent : this.usages) {
            questions.addAll(sent.questions());
        }
        return questions;
    }

    @Override
    public Set<LexicalUnit> relatedLexicalUnits() {
        return new HashSet<>(this.usages);
    }

    @Override
    public Question primaryQuestion() {
        return this.questions().stream().findFirst().get();
    }

    @Override
    public JsonObject toJson() {
        final JsonObject json = super.toJson();
        json.set("o", this.original);
        final JsonArray trans = new JsonArray();
        for (final String translation : this.translations) {
            trans.add(translation);
        }
        json.set("t", trans);
        final JsonArray examples = new JsonArray();
        for (final Sentence usage : this.usages) {
            examples.add(usage.toJson());
        }
        json.set("ex", examples);
        return json;
    }
}
