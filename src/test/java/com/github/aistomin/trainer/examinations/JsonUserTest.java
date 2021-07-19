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
package com.github.aistomin.trainer.examinations;

import java.io.File;
import java.net.URISyntaxException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test for {@link JsonUser}.
 *
 * @since 1.0
 */
final class JsonUserTest {

    /**
     * Check that we correctly load the data from JSON file.
     *
     * @throws URISyntaxException If something goes wrong.
     */
    @Test
    void testReadFromJson() throws URISyntaxException {
        final User usr = new JsonUser(
            new File(
                Thread
                    .currentThread()
                    .getContextClassLoader()
                    .getResource("user.json").toURI()
            )
        );
        Assertions.assertEquals(1L, usr.identifier());
        Assertions.assertEquals("andrej", usr.username());
    }
}
