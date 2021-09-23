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

import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test for {@link Translation}.
 *
 * @since 1.0
 */
final class TranslationTest {

    /**
     * Check that we can correctly create translation and retrieve data from it.
     */
    @Test
    void testTranslation() {
        final String original = UUID.randomUUID().toString();
        final String target = UUID.randomUUID().toString();
        final Translation translation = new Translation(original, target);
        Assertions.assertEquals(original, translation.originalText());
        Assertions.assertEquals(target, translation.translationText());
    }
}
