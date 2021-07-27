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
import com.github.aistomin.testist.Question;
import com.github.aistomin.testist.simple.SimpleAnswer;
import com.github.aistomin.trainer.deutsch.Constant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test for {@link SimpleWord}.
 *
 * @since 1.0
 */
final class SimpleWordTest {

    /**
     * Check that we correctly return the list of questions related to the
     * simple word.
     */
    @Test
    void testQuestions() {
        final List<Question> questions = SimpleWordTest
            .createTestWord()
            .questions();
        Assertions.assertEquals(Constant.FOUR, questions.size());
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
            1L, "glatt", correct, new ArrayList<>(0), "information", false
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
     * Check that we correctly convert the entity to JSON.
     */
    @Test
    void testToJson() {
        final long id = 1L;
        final String info = UUID.randomUUID().toString();
        final List<Sentence> examples = Arrays.asList(
            new Sentence(
                Constant.TWO,
                "Hallo, ich bin Andrej!", "Hello, my name is Andrej",
                UUID.randomUUID().toString(), false
            ), new Sentence(
                Constant.THREE,
                "Hallo, wie geht's?", "Hello, how are you?",
                UUID.randomUUID().toString(), false
            )
        );
        final List<String> translations = Arrays.asList("Hello", "Hi");
        final String hallo = "Hallo";
        final Word word = new SimpleWord(
            id, hallo, translations, examples, info, false
        );
        final JsonObject obj = word.toJson();
        Assertions.assertEquals(id, obj.getLong("id", 0L));
        final String empty = "";
        Assertions.assertEquals(hallo, obj.getString("o", empty));
        final JsonArray trans = obj.get("t").asArray();
        Assertions.assertEquals(translations.size(), trans.size());
        Assertions.assertEquals(translations.get(0), trans.get(0).asString());
        Assertions.assertEquals(translations.get(1), trans.get(1).asString());
        Assertions.assertEquals(
            examples.size(), obj.get("ex").asArray().size()
        );
        Assertions.assertEquals(info, obj.getString("info", empty));
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
        final Random rnd = new Random();
        examples.add(
            new Sentence(rnd.nextLong(), eoriginal, etranslation, "", false)
        );
        return new SimpleWord(
            rnd.nextLong(), woriginal, wtranslation, examples, "hello", false
        );
    }
}
