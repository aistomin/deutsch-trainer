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

import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.PrettyPrint;
import com.github.aistomin.trainer.deutsch.utils.Resources;
import com.github.aistomin.trainer.deutsch.vocabulary.LexicalUnit;
import com.github.aistomin.trainer.deutsch.vocabulary.Sentence;
import com.github.aistomin.trainer.deutsch.vocabulary.SimpleWord;
import com.github.aistomin.trainer.deutsch.vocabulary.german.GermanVerb;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test for {@link JsonDictionary}.
 *
 * @since 1.0
 * @checkstyle ClassDataAbstractionCouplingCheck (1000 lines)
 */
@SuppressWarnings("PMD.TooManyMethods")
final class JsonDictionaryTest {

    /**
     * Check that we correctly read the dictionary version.
     *
     * @throws URISyntaxException If something goes wrong.
     */
    @Test
    void testVersion() throws URISyntaxException {
        Assertions.assertEquals(
            "v1.0-test",
            JsonDictionaryTest.dictionary().version()
        );
    }

    /**
     * Check that we correctly parse the vocabulary from JSON.
     *
     * @throws URISyntaxException If something goes wrong.
     */
    @Test
    void testVocabulary() throws URISyntaxException {
        Assertions.assertEquals(
            Constant.THREE,
            JsonDictionaryTest.dictionary().words(WordsFilter.ALL).size()
        );
    }

    /**
     * Check that we correctly filter the records if necessary.
     *
     * @throws URISyntaxException If something goes wrong.
     */
    @Test
    void testFiltering() throws URISyntaxException {
        final Dictionary dict = JsonDictionaryTest.dictionary();
        Assertions.assertEquals(
            Constant.THREE, dict.words(WordsFilter.ALL).size()
        );
        Assertions.assertEquals(1, dict.words(WordsFilter.ONLY_NEW).size());
    }

    /**
     * Check that we correctly validate the dictionary consistency.
     *
     * @throws URISyntaxException If something goes wrong.
     * @throws InvalidDictionaryException If something goes wrong.
     */
    @Test
    void testValidation() throws URISyntaxException, InvalidDictionaryException {
        JsonDictionaryTest.dictionary().validate();
        new JsonDictionary(Resources.find("dict.json")).validate();
        Assertions.assertThrows(
            InvalidDictionaryException.class,
            () ->
                new JsonDictionary(
                    Resources.find("corrupted_dict_sample.json")
                ).validate()
        );
    }

    /**
     * Check that we correctly generate new ID.
     *
     * @throws URISyntaxException If something goes wrong.
     */
    @Test
    void testGenerateNextId() throws URISyntaxException {
        Assertions.assertEquals(
            Constant.TWO_HUNDRED_TWELVE,
            JsonDictionaryTest.dictionary().generateNextId()
        );
    }

    /**
     * Check that we correctly dump the dictionary.
     *
     * @throws URISyntaxException If something goes wrong.
     * @throws IOException If something goes wrong.
     */
    @Test
    void testDump() throws URISyntaxException, IOException {
        final Dictionary original = JsonDictionaryTest.dictionary();
        final File file = new File("target/test_dump.json");
        original.dump(file);
        final Dictionary restored = new JsonDictionary(file);
        Assertions.assertEquals(original.version(), restored.version());
        Assertions.assertEquals(
            original.words(WordsFilter.ALL).size(),
            restored.words(WordsFilter.ALL).size()
        );
    }

    /**
     * Check that we correctly save the dictionary.
     *
     * @throws URISyntaxException If something goes wrong.
     * @throws IOException If something goes wrong.
     * @throws InvalidDictionaryException If something goes wrong.
     */
    @Test
    void testSave()
        throws URISyntaxException, IOException, InvalidDictionaryException {
        final JsonDictionary original = JsonDictionaryTest.dictionary();
        original.save();
        final JsonDictionary saved = JsonDictionaryTest.dictionary();
        final Dictionary backup = new JsonDictionary(
            Resources.find("dict_sample.json_bk")
        );
        Assertions.assertEquals(original.version(), saved.version());
        Assertions.assertEquals(
            original.words(WordsFilter.ALL).size(),
            saved.words(WordsFilter.ALL).size()
        );
        Assertions.assertEquals(original.version(), backup.version());
        Assertions.assertEquals(
            original.words(WordsFilter.ALL).size(),
            backup.words(WordsFilter.ALL).size()
        );
    }

    /**
     * Check that we can correctly delete a word from the dictionary.
     *
     * @throws URISyntaxException If something goes wrong.
     * @throws InvalidDictionaryException If something goes wrong.
     * @throws IOException If something goes wrong.
     */
    @Test
    void testDelete()
        throws URISyntaxException, InvalidDictionaryException, IOException {
        final JsonDictionary dict = dictionary();
        final List<LexicalUnit> words = dict.words(WordsFilter.ALL);
        final LexicalUnit del = words.get(new Random().nextInt(words.size()));
        dict.delete(del);
        Assertions.assertFalse(dict.words(WordsFilter.ALL).contains(del));
        dict.add(del);
    }

    /**
     * Check that we can correctly add a lexical unit to the dictionary.
     *
     * @throws URISyntaxException If something goes wrong.
     * @throws InvalidDictionaryException If something goes wrong.
     * @throws IOException If something goes wrong.
     */
    @Test
    void testAdd()
        throws URISyntaxException, InvalidDictionaryException, IOException {
        final JsonDictionary dict = dictionary();
        final int before = dict.words(WordsFilter.ALL).size();
        final String info = "";
        final AtomicLong id = new AtomicLong(dict.generateNextId());
        final GermanVerb verb = new GermanVerb(
            id.incrementAndGet(),
            new SimpleWord(
                id.incrementAndGet(),
                "nehmen",
                "to take",
                new ArrayList<>(0),
                info, false
            ),
            new SimpleWord(
                id.incrementAndGet(),
                "nahm",
                "took",
                new ArrayList<>(0),
                info, false
            ),
            new SimpleWord(
                id.incrementAndGet(),
                "genommen",
                "taken",
                new ArrayList<>(0),
                info, false
            ),
            info, false
        );
        dict.add(verb);
        Assertions.assertEquals(before + 1, dict.words(WordsFilter.ALL).size());
        dict.delete(verb);
    }

    /**
     * Check that we can correctly create an empty dictionary.
     */
    @Test
    void testCreateNewDictionary() {
        final JsonDictionary dict = new JsonDictionary(
            new File(String.format("target/%s.json", UUID.randomUUID()))
        );
        Assertions.assertEquals(0, dict.words(WordsFilter.ALL).size());
        Assertions.assertEquals("v1.0", dict.version());
    }

    /**
     * Check that we can correctly replace the unit in the dictionary.
     *
     * @throws Exception If something goes wrong.
     */
    @Test
    void testReplaceUnit()
        throws Exception {
        final File file = new File(String.format("target/%s-1.json", UUID.randomUUID()));
        file.createNewFile();
        final BufferedWriter writer = Files.newBufferedWriter(file.toPath());
        final JsonObject obj = new JsonObject();
        obj.set(JsonDictionary.VER, "v0.1-test");
        obj.set(JsonDictionary.VOC, new JsonArray());
        writer.write(obj.toString(PrettyPrint.PRETTY_PRINT));
        writer.close();
        final Dictionary dict = new JsonDictionary(file);
        dict.add(
            new Sentence(
                1L,
                "die Kuh",
                "the cow",
                "", false
            )
        );
        final long id = 2L;
        dict.add(
            new Sentence(
                id,
                "die Duo",
                "the Duo",
                "", false
            )
        );
        final String their = "die Eule";
        final String mine = "the owl";
        dict.replace(
            new Sentence(
                id,
                their,
                mine,
                "", false
            )
        );
        final List<LexicalUnit> words = dict.words(WordsFilter.ALL);
        Assertions.assertEquals(2, words.size());
        Assertions.assertTrue(words.get(1).toJson().toString().contains(their));
        Assertions.assertTrue(words.get(1).toJson().toString().contains(mine));
    }

    /**
     * Load the test dictionary.
     *
     * @return Test dictionary.
     * @throws URISyntaxException If something goes wrong.
     */
    private static JsonDictionary dictionary() throws URISyntaxException {
        return new JsonDictionary(Resources.find("dict_sample.json"));
    }
}
