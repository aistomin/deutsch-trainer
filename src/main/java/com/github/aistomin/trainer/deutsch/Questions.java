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

import com.github.aistomin.testist.Question;
import com.github.aistomin.testist.QuestionsProvider;
import com.github.aistomin.trainer.deutsch.utils.Resources;
import com.github.aistomin.trainer.deutsch.vocabulary.LexicalUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Questions provider.
 *
 * @since 1.0
 */
public final class Questions implements QuestionsProvider {

    /**
     * Amount of questions.
     */
    private final Integer amount;

    /**
     * Word's filter.
     */
    private final WordsFilter filter;

    /**
     * Ctor.
     *
     * @param count Amount of questions.
     */
    public Questions(final Integer count) {
        this(count, WordsFilter.ALL);
    }

    /**
     * Ctor.
     *
     * @param count Amount of questions.
     * @param advanced Question's filter.
     */
    public Questions(final Integer count, final WordsFilter advanced) {
        this.amount = count;
        this.filter = advanced;
    }

    @Override
    public List<Question> questions() {
        final List<Question> result = new ArrayList<>(this.amount);
        final Dictionary dict =
            new JsonDictionary(Resources.find("dict.json"));
        final Random rand = new Random();
        final AtomicInteger index = new AtomicInteger();
        while (index.get() < this.amount) {
            final List<LexicalUnit> words = dict.words(this.filter);
            final List<Question> questions =
                words.get(rand.nextInt(words.size())).questions();
            final Question question = questions.get(rand.nextInt(questions.size()));
            if (!result.contains(question)) {
                result.add(question);
                index.set(index.get() + 1);
            }
        }
        return result;
    }
}
