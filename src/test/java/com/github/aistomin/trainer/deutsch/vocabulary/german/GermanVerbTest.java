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

import com.eclipsesource.json.JsonObject;
import com.github.aistomin.testist.Question;
import com.github.aistomin.testist.simple.SimpleAnswer;
import com.github.aistomin.trainer.deutsch.Constant;
import com.github.aistomin.trainer.deutsch.JsonDictionary;
import com.github.aistomin.trainer.deutsch.vocabulary.LexicalUnit;
import com.github.aistomin.trainer.deutsch.vocabulary.Sentence;
import com.github.aistomin.trainer.deutsch.vocabulary.SimpleWord;
import com.github.aistomin.trainer.deutsch.vocabulary.Word;
import java.io.File;
import java.util.Collections;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test for {@link GermanVerb}.
 *
 * @since 1.0
 */
final class GermanVerbTest {

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
            Constant.TWELVE,
            GermanVerbTest.createTestVerb().questions().size()
        );
    }

    /**
     * Check that we correctly convert the verb to JSON.
     */
    @Test
    void testToJson() {
        final JsonObject json = GermanVerbTest.createTestVerb().toJson();
        Assertions.assertNotNull(json.get("infinitive").asObject());
        Assertions.assertNotNull(json.get("preterite").asObject());
        Assertions.assertNotNull(json.get("perfect").asObject());
    }

    /**
     * Check that we can correctly clone a word.
     */
    @Test
    void testClone() {
        final Word verb = GermanVerbTest.createTestVerb();
        final LexicalUnit clone = verb.clone(
            new JsonDictionary(
                new File(String.format("target/%s.json", UUID.randomUUID()))
            )
        );
        final JsonObject json = clone.toJson();
        Assertions.assertEquals(
            clone.identifier(), json.getLong("id", -1L)
        );
        verb.toJson().remove("id").forEach(
            member -> Assertions.assertEquals(
                member.getValue(), json.get(member.getName())
            )
        );
    }

    /**
     * Create a verb for testing.
     *
     * @return Test verb.
     */
    private static GermanVerb createTestVerb() {
        return new GermanVerb(
            0L,
            new SimpleWord(
                1L,
                "gehen", "go",
                Collections.singletonList(
                    new Sentence(Constant.TWO, "Ich gehe.", "I go.", "test1", false)
                ), "test", false
            ),
            new SimpleWord(
                Constant.THREE,
                "ging", "went",
                Collections.singletonList(
                    new Sentence(Constant.FOUR, "Ich ging.", "I went.", "test2", false)
                ), "test3", false
            ),
            new SimpleWord(
                Constant.FIVE,
                "gegangen", "gone",
                Collections.singletonList(
                    new Sentence(
                        Constant.SIX, "Ich bin gegangen.", "I have gone.", "test4", false
                    )
                ), "test5", false
            ), "information", false
        );
    }
}
