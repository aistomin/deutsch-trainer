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
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test for {@link Sentence}.
 *
 * @since 1.0
 */
final class SentenceTest {

    /**
     * Check that we correctly return a list of questions related to the
     * sentence.
     */
    @Test
    void testQuestions() {
        final String original = "Wie heißt du?";
        final String translation = "What is your name?";
        final LexicalUnit sentence = new Sentence(original, translation);
        final List<Question> questions = sentence.questions();
        final Question direct = questions.get(0);
        Assertions.assertTrue(direct.toDisplayableString().contains(original));
        direct.answer(new SimpleAnswer(translation));
        Assertions.assertTrue(direct.isCorrect());
        final Question reversed = questions.get(1);
        Assertions.assertTrue(reversed.toDisplayableString().contains(translation));
        reversed.answer(new SimpleAnswer(original));
        Assertions.assertTrue(reversed.isCorrect());
    }

    /**
     * Check that we properly treat questions with the several correct answers.
     */
    @Test
    void testQuestionWithSeveralCorrectAnswers() {
        final List<String> correct =
            Arrays.asList("I'm Andrej.", "My name is Andrej.");
        final Sentence sentence = new Sentence(
            "Ich bin Andrej.", correct
        );
        final Question question = sentence.questions().get(0);
        question.answer(new SimpleAnswer("My name is John."));
        Assertions.assertFalse(question.isCorrect());
        for (final String ans : correct) {
            final Question quest = sentence.questions().get(0);
            quest.answer(new SimpleAnswer(ans));
            Assertions.assertTrue(quest.isCorrect());
        }
    }
}
