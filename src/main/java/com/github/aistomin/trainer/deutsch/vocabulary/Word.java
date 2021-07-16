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

/**
 * Just an abstract word.
 *
 * @since 1.0
 */
public abstract class Word extends LexicalUnit {

    /**
     * Ctor.
     *
     * @param id Unique unit's identifier.
     * @param info Some additional free-text information.
     */
    public Word(final Long id, final String info) {
        super(id, info);
    }

    /**
     * The primary question. Normally it's the initial form of the word
     * (e.g. infinitive form for verb) and it's translation to the student's
     * language.
     * @return Primary question.
     */
    public abstract Question primaryQuestion();
}
