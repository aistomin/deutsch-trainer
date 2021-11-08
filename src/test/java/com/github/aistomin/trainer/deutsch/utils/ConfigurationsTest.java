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
package com.github.aistomin.trainer.deutsch.utils;

import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test for {@link Configurations}.
 *
 * @since 1.0
 */
final class ConfigurationsTest {

    /**
     * Check that we can correctly get the database configuration.
     */
    @Test
    void testDatabase() {
        final Configurations conf = new Configurations();
        Assertions.assertEquals(
            "jdbc:postgresql://localhost:5432/deutsch_trainer",
            conf.database().url()
        );
        Assertions.assertEquals("root", conf.database().username());
        Assertions.assertEquals("", conf.database().password());
        final String url = UUID.randomUUID().toString();
        System.setProperty("dt.db.url", url);
        final String username = UUID.randomUUID().toString();
        System.setProperty("dt.db.user", username);
        final String pass = UUID.randomUUID().toString();
        System.setProperty("dt.db.password", pass);
        Assertions.assertEquals(url, conf.database().url());
        Assertions.assertEquals(username, conf.database().username());
        Assertions.assertEquals(pass, conf.database().password());
    }
}