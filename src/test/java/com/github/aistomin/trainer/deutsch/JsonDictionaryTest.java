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

import java.io.File;
import java.net.URISyntaxException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test for {@link JsonDictionary}.
 *
 * @since 1.0
 */
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
            2, JsonDictionaryTest.dictionary().words().size()
        );
    }

    /**
     * Load the test dictionary.
     *
     * @return Test dictionary.
     * @throws URISyntaxException If something goes wrong.
     */
    private static Dictionary dictionary() throws URISyntaxException {
        return new JsonDictionary(
            new File(
                Thread
                    .currentThread()
                    .getContextClassLoader()
                    .getResource("dict_sample.json").toURI()
            )
        );
    }
}
