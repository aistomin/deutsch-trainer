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
 * Test for {@link DTUser}.
 *
 * @since 1.0
 */
class DTUserTest {

    /**
     * Check that we can correctly change the username.
     */
    @Test
    void testChangeUsername() {
        final Users users = this.users();
        final User user = users.create(
            UUID.randomUUID().toString(),
            UUID.randomUUID().toString()
        );
        final String changed = UUID.randomUUID().toString();
        Assertions.assertEquals(
            changed, user.changeUsername(changed).username()
        );
    }

    /**
     * Check that we can correctly get the username.
     */
    @Test
    void testUsername() {
        final Users users = this.users();
        final String username = UUID.randomUUID().toString();
        final User user = users.create(username, UUID.randomUUID().toString());
        Assertions.assertEquals(username, user.username());
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
