/*
 * Copyright (c) 2021-2022, Istomin Andrei
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
 * User interface.
 *
 * @since 1.0
 */
public interface User {

    /**
     * User's identifier.
     *
     * @return Identifier.
     */
    Long identifier();

    /**
     * Username.
     *
     * @return Username.
     */
    String username();

    /**
     * Password.
     *
     * @return Password.
     */
    String password();

    /**
     * Change username.
     *
     * @param username New username.
     * @return Updated user entity.
     */
    User changeUsername(String username);

    /**
     * Change password.
     *
     * @param password New password.
     * @return Updated user entity.
     */
    User changePassword(String password);

    /**
     * Validate user's password.
     *
     * @param password The password string that needs to be validated.
     * @return True - the password is valid; False - the password is invalid.
     */
    Boolean isPasswordValid(String password);
}
