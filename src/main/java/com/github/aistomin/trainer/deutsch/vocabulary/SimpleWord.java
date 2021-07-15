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
     * @checkstyle ParameterNumberCheck (10 lines)
     */
    public SimpleWord(
        final String id,
        final String their,
        final String mine,
        final List<Sentence> examples
    ) {
        this(id, their, Collections.singletonList(mine), examples);
    }

    /**
     * Ctor.
     *
     * @param id Unique unit's identifier.
     * @param their The word in original language.
     * @param mine The correct translations in the student's language.
     * @param examples Examples of the word usages.
     * @checkstyle ParameterNumberCheck (10 lines)
     */
    public SimpleWord(
        final String id,
        final String their,
        final List<String> mine,
        final List<Sentence> examples
    ) {
        super(id);
        this.original = their;
        this.translations = mine;
        this.usages = examples;
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
}
