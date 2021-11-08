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

/**
 * Users interface.
 *
 * @since 1.0
 */
public interface Users {

    /**
     * Load current user record from the database.
     *
     * @return User's record.
     */
    User currentUser();

    /**
     * Create user with username.
     *
     * @param username Username.
     * @param password Password.
     * @return Created user.
     */
    User createUser(String username, String password);
}
