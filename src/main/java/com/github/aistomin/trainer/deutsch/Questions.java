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
import com.github.aistomin.trainer.deutsch.vocabulary.LexicalUnit;
import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * The application entry point.
 *
 * @since 1.0
 */
public final class Questions implements QuestionsProvider {

    /**
     * Amount of questions.
     */
    private final Integer amount;

    /**
     * Ctor.
     *
     * @param count Amount of questions.
     */
    public Questions(final Integer count) {
        this.amount = count;
    }

    @Override
    public List<Question> questions() {
        final List<Question> result = new ArrayList<>(this.amount);
        try {
            final Dictionary dict = new JsonDictionary(
                new File(
                    Thread
                        .currentThread()
                        .getContextClassLoader()
                        .getResource("dict_sample.json").toURI()
                )
            );
            final Random rand = new Random();
            IntStream.rangeClosed(1, this.amount).forEach(
                value -> {
                    final List<LexicalUnit> words = dict.words();
                    final List<Question> questions =
                        words.get(rand.nextInt(words.size())).questions();
                    result.add(questions.get(rand.nextInt(questions.size())));
                }
            );
            return result;
        } catch (final URISyntaxException exception) {
            throw new IllegalStateException("File not found", exception);
        }
    }
}
