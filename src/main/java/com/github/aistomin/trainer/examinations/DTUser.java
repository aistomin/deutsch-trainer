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
 * User implementation that takes data from the database.
 *
 * @since 1.0
 */
public final class DTUser implements User {

    /**
     * Users entity.
     */
    private final Users storage;

    /**
     * User ID.
     */
    private final Long id;

    /**
     * Username.
     */
    private final String user;

    /**
     * Password.
     */
    private final String pass;

    /**
     * Ctor.
     *
     * @param identifier User ID.
     * @param users Users entity.
     * @param username Username.
     * @param password Password.
     */
    public DTUser(final Users users, final Long identifier,
        final String username, final String password
    ) {
        this.storage = users;
        this.id = identifier;
        this.user = username;
        this.pass = password;
    }

    @Override
    public Long identifier() {
        return this.id;
    }

    @Override
    public String username() {
        return this.user;
    }

    @Override
    public String password() {
        return this.pass;
    }

    @Override
    public User changeUsername(final String username) {
        return this.storage.save(
            new DTUser(this.storage, this.id, username, this.pass)
        );
    }
}
