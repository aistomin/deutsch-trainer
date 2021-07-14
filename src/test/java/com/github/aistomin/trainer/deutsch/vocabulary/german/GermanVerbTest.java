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
package com.github.aistomin.trainer.deutsch.vocabulary.german;

import com.github.aistomin.testist.Question;
import com.github.aistomin.testist.simple.SimpleAnswer;
import com.github.aistomin.trainer.deutsch.vocabulary.Sentence;
import com.github.aistomin.trainer.deutsch.vocabulary.SimpleWord;
import com.github.aistomin.trainer.deutsch.vocabulary.Word;
import java.util.Collections;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test for {@link GermanVerb}.
 *
 * @since 1.0
 */
final class GermanVerbTest {

    /**
     * Constant 12.
     */
    public static final int TWELVE = 12;

    /**
     * Check that we correctly get the primary question for the verb.
     */
    @Test
    void testPrimaryQuestion() {
        final Question question = GermanVerbTest
            .createTestVerb()
            .primaryQuestion();
        question.answer(new SimpleAnswer("go"));
        Assertions.assertTrue(question.isCorrect());
    }

    /**
     * Check that we get correct list of questions for the verb.
     */
    @Test
    void testQuestions() {
        Assertions.assertEquals(
            GermanVerbTest.TWELVE,
            GermanVerbTest.createTestVerb().questions().size()
        );
    }

    /**
     * Create a verb for testing.
     *
     * @return Test verb.
     */
    private static Word createTestVerb() {
        return new GermanVerb(
            "0",
            new SimpleWord(
                "1",
                "gehen", "go",
                Collections.singletonList(
                    new Sentence("2", "Ich gehe.", "I go.")
                )
            ),
            new SimpleWord(
                "3",
                "ging", "went",
                Collections.singletonList(
                    new Sentence("4", "Ich ging.", "I went.")
                )
            ),
            new SimpleWord(
                "5",
                "gegangen", "gone",
                Collections.singletonList(
                    new Sentence("6", "Ich bin gegangen.", "I have gone.")
                )
            )
        );
    }
}
