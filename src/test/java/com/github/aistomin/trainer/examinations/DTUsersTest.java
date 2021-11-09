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

import com.github.aistomin.trainer.deutsch.utils.Configurations;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test for {@link DTUsers}.
 *
 * @since 1.0
 */
final class DTUsersTest {

    /**
     * Check that we can correctly perform CRUD operation.
     */
    @Test
    void testCrud() {
        final Users users = this.users();
        final int before = users.all().size();
        final String username = UUID.randomUUID().toString();
        final User user = users.create(username, UUID.randomUUID().toString());
        Assertions.assertEquals(username, user.username());
        Assertions.assertEquals(before + 1, users.all().size());
        Assertions.assertEquals(
            user.identifier(), users.currentUser().identifier()
        );
        users.delete(user);
        Assertions.assertEquals(before, users.all().size());
    }

    /**
     * Check that we correctly get the current user.
     */
    @Test
    void testCurrentUser() {
        final Users users = this.users();
        for (final User user : users.all()) {
            users.delete(user);
        }
        Assertions.assertThrows(
            IllegalStateException.class, users::currentUser,
            "Current user not found."
        );
        final User first = users.create(
            UUID.randomUUID().toString(), UUID.randomUUID().toString()
        );
        Assertions.assertEquals(
            first.identifier(), users.currentUser().identifier()
        );
        final User second = users.create(
            UUID.randomUUID().toString(), UUID.randomUUID().toString()
        );
        Assertions.assertEquals(
            second.identifier(), users.currentUser().identifier()
        );
        users.delete(first);
        users.delete(second);
    }

    /**
     * Create test Users instance.
     *
     * @return Users.
     */
    private Users users() {
        return new DTUsers(new Configurations().database());
    }
}
