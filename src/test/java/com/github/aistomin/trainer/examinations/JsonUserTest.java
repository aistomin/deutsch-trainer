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

import com.github.aistomin.trainer.deutsch.TestJsonFile;
import com.github.aistomin.trainer.deutsch.utils.Resources;
import java.io.File;
import java.util.Random;
import java.util.UUID;
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
     * @throws Exception If something goes wrong.
     */
    @Test
    void testReadFromJson() throws Exception {
        final User usr = new JsonUser(Resources.find("user.json"));
        Assertions.assertEquals(1L, usr.identifier());
        Assertions.assertEquals("andrej", usr.username());
    }

    /**
     * Check that we can correctly create user with ID and username.
     */
    @Test
    void testCreateWithIdAndUsername() {
        final Long id = new Random().nextLong();
        final String username = UUID.randomUUID().toString();
        final User usr = new JsonUser(new TestJsonFile(), id, username);
        Assertions.assertEquals(id, usr.identifier());
        Assertions.assertEquals(username, usr.username());
    }

    /**
     * Check that we can correctly change username.
     *
     * @throws Exception If something goes wrong.
     */
    @Test
    void testChangeUsername() throws Exception {
        final User usr = new JsonUser(
            new TestJsonFile(), 1L, UUID.randomUUID().toString()
        );
        final String username = UUID.randomUUID().toString();
        usr.changeUsername(username);
        Assertions.assertEquals(username, usr.username());
    }

    /**
     * Check that we correctly clone the user.
     */
    @Test
    void testClone() {
        final User usr = new JsonUser(
            new TestJsonFile(), 1L, UUID.randomUUID().toString()
        );
        final File file = new TestJsonFile();
        final JsonUser clone = (JsonUser) usr.clone(file);
        Assertions.assertEquals(
            file.getAbsolutePath(), clone.file().getAbsolutePath()
        );
        Assertions.assertEquals(usr.identifier(), clone.identifier());
        Assertions.assertEquals(usr.username(), clone.username());
        final Long id = new Random().nextLong();
        final JsonUser nclone = (JsonUser) usr.clone(file, id);
        Assertions.assertEquals(
            file.getAbsolutePath(), nclone.file().getAbsolutePath()
        );
        Assertions.assertEquals(id, nclone.identifier());
        Assertions.assertEquals(usr.username(), nclone.username());
    }

    /**
     * Check that we correctly dump the user.
     *
     * @throws Exception If something goes wrong.
     */
    @Test
    void testDump() throws Exception {
        final User original = new JsonUser(
            new TestJsonFile(), 1L, UUID.randomUUID().toString()
        );
        final File file = new File("target/test_user_dump.json");
        original.dump(file);
        final User restored = new JsonUser(file);
        Assertions.assertEquals(original.identifier(), restored.identifier());
        Assertions.assertEquals(original.username(), restored.username());
    }
}
