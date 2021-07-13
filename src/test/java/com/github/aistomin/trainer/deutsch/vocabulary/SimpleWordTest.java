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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test for {@link SimpleWord}.
 *
 * @since 1.0
 */
final class SimpleWordTest {

    /**
     * Constant 4.
     */
    public static final int FOUR = 4;

    /**
     * Check that we correctly return the list of questions related to the
     * simple word.
     */
    @Test
    void testQuestions() {
        final List<Question> questions = SimpleWordTest
            .createTestWord()
            .questions();
        Assertions.assertEquals(SimpleWordTest.FOUR, questions.size());
    }

    /**
     * Check that we correctly return the primary question.
     */
    @Test
    void testPrimaryQuestion() {
        final Word word = SimpleWordTest.createTestWord();
        final Question question = word.primaryQuestion();
        question.answer(new SimpleAnswer("I"));
        Assertions.assertTrue(question.isCorrect());
    }

    /**
     * Check that we properly treat questions with the several correct answers.
     */
    @Test
    void testQuestionWithSeveralCorrectAnswers() {
        final List<String> correct = Arrays.asList("smooth", "slippery");
        final Word word = new SimpleWord(
            "glatt", correct, new ArrayList<>(0)
        );
        final Question question = word.primaryQuestion();
        question.answer(new SimpleAnswer("white"));
        Assertions.assertFalse(question.isCorrect());
        for (final String ans : correct) {
            final Question quest = word.primaryQuestion();
            quest.answer(new SimpleAnswer(ans));
            Assertions.assertTrue(quest.isCorrect());
        }
    }

    /**
     * Create a word instance for testing.
     *
     * @return Test instance.
     */
    private static Word createTestWord() {
        final String woriginal = "ich";
        final String wtranslation = "I";
        final String eoriginal = "Ich heiße Andrej.";
        final String etranslation = "My name is Andrej.";
        final ArrayList<Sentence> examples = new ArrayList<>(1);
        examples.add(
            new Sentence(eoriginal, etranslation)
        );
        return new SimpleWord(woriginal, wtranslation, examples);
    }
}
