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
import java.io.IOException;

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
     * @throws IOException If read/write error occurs.
     */
    void changeUsername(String username) throws IOException;

    /**
     * Clone the user to new file.
     *
     * @param file File.
     * @return Cloned user.
     */
    User clone(File file);

    /**
     * Clone the user to new file with new ID.
     *
     * @param file File.
     * @param id New user identifier.
     * @return Cloned user.
     */
    User clone(File file, Long id);

    /**
     * Dump user to the new file.
     *
     * @param file Destination file.
     * @return New user associated with the file.
     * @throws IOException If read/write error occurs.
     */
    User dump(File file) throws IOException;
}
