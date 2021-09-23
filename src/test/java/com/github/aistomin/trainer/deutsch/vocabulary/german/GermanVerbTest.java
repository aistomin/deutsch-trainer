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

import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.github.aistomin.testist.Question;
import com.github.aistomin.testist.simple.SimpleAnswer;
import com.github.aistomin.trainer.deutsch.Constant;
import com.github.aistomin.trainer.deutsch.JsonDictionary;
import com.github.aistomin.trainer.deutsch.TestJsonFile;
import com.github.aistomin.trainer.deutsch.vocabulary.LexicalUnit;
import com.github.aistomin.trainer.deutsch.vocabulary.Sentence;
import com.github.aistomin.trainer.deutsch.vocabulary.SimpleWord;
import com.github.aistomin.trainer.deutsch.vocabulary.Translation;
import com.github.aistomin.trainer.deutsch.vocabulary.Word;
import java.util.Collections;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test for {@link GermanVerb}.
 *
 * @since 1.0
 */
final class GermanVerbTest {

    /**
     * The German word "gehen" -> "to go".
     */
    public static final String GEHEN = "gehen";

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
     * Check that we can correctly create translation and retrieve data from it.
     */
    @Test
    void testTranslation() {
        final Translation translation = GermanVerbTest
            .createTestVerb()
            .translation();
        Assertions.assertEquals(
            GermanVerbTest.GEHEN, translation.originalText()
        );
        Assertions.assertEquals("go", translation.translationText());
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
        Assertions.assertNotNull(json.get(GermanVerb.INFINITIVE).asObject());
        Assertions.assertNotNull(json.get(GermanVerb.PRETERITE).asObject());
        Assertions.assertNotNull(json.get(GermanVerb.PERFECT).asObject());
    }

    /**
     * Check that we can correctly clone a word.
     */
    @Test
    void testClone() {
        final Word verb = GermanVerbTest.createTestVerb();
        final LexicalUnit clone = verb.clone(
            new JsonDictionary(new TestJsonFile())
        );
        final JsonObject original = verb.toJson();
        final JsonObject target = clone.toJson();
        Assertions.assertEquals(
            clone.identifier(), target.getLong("id", -1L)
        );
        Assertions.assertEquals(
            original.get(LexicalUnit.IS_NEW_FIELD), target.get(LexicalUnit.IS_NEW_FIELD)
        );
        final String part = "ps";
        Assertions.assertEquals(original.get(part), target.get(part));
        GermanVerbTest.assertWordsEquals(
            original.get(GermanVerb.INFINITIVE).asObject(),
            target.get(GermanVerb.INFINITIVE).asObject()
        );
        GermanVerbTest.assertWordsEquals(
            original.get(GermanVerb.PRETERITE).asObject(),
            target.get(GermanVerb.PRETERITE).asObject()
        );
        GermanVerbTest.assertWordsEquals(
            original.get(GermanVerb.PERFECT).asObject(),
            target.get(GermanVerb.PERFECT).asObject()
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
                GermanVerbTest.GEHEN, "go",
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

    /**
     * Compare that two words serialised to JSON are the same.
     *
     * @param original Word one.
     * @param target Word two.
     */
    private static void assertWordsEquals(
        final JsonObject original, final JsonObject target
    ) {
        Assertions.assertEquals(
            original.get(LexicalUnit.INFO_FIELD), target.get(LexicalUnit.INFO_FIELD)
        );
        Assertions.assertEquals(
            original.get(LexicalUnit.IS_NEW_FIELD), target.get(LexicalUnit.IS_NEW_FIELD)
        );
        final String part = "ps";
        Assertions.assertEquals(original.get(part), target.get(part));
        final String origin = "o";
        Assertions.assertEquals(original.get(origin), target.get(origin));
        final String trans = "t";
        Assertions.assertEquals(original.get(trans), target.get(trans));
        final String examples = "ex";
        final JsonArray oex = original.get(examples).asArray();
        final JsonArray cex = target.get(examples).asArray();
        IntStream.range(0, oex.size()).forEach(
            idx ->
                oex.get(idx).asObject().remove("id").forEach(
                    member ->
                        Assertions.assertEquals(
                            member.getValue(),
                            cex.get(idx).asObject().get(member.getName())
                        )
                )
        );
    }
}
