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
 * A sentence in the language.
 *
 * @since 1.0
 */
public final class Sentence implements LexicalUnit {

    /**
     * The sentence in original language.
     */
    private final String original;

    /**
     * The sentence in the student's language.
     */
    private final String translation;

    /**
     * Ctor.
     * @param their The sentence in original language.
     * @param mine The sentence in the student's language.
     */
    public Sentence(final String their, final String mine) {
        this.original = their;
        this.translation = mine;
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
        return questions;
    }
}
