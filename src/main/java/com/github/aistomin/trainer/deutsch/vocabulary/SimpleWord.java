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
import java.util.List;

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
     * The word in the student's language.
     */
    private final String translation;

    /**
     * Examples of the word usages.
     */
    private final List<Sentence> usages;

    /**
     * Ctor.
     * @param their The word in original language.
     * @param mine The word in the student's language.
     * @param examples Examples of the word usages.
     */
    public SimpleWord(
        final String their,
        final String mine,
        final List<Sentence> examples
    ) {
        this.original = their;
        this.translation = mine;
        this.usages = examples;
    }

    @Override
    public List<Question> questions() {
        final ArrayList<Question> questions = new ArrayList<>(2);
        questions.add(
            new SimpleQuestion(
                new SimpleText(this.original),
                new SimpleAnswer(this.translation)
            )
        );
        questions.add(
            new SimpleQuestion(
                new SimpleText(this.translation),
                new SimpleAnswer(this.original)
            )
        );
        for (final Sentence sent : this.usages) {
            questions.addAll(sent.questions());
        }
        return questions;
    }

    @Override
    public Question primaryQuestion() {
        return this.questions().stream().findFirst().get();
    }
}
