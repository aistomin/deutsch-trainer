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
package com.github.aistomin.trainer.deutsch.ui;

import com.github.aistomin.trainer.deutsch.utils.Resources;
import com.github.aistomin.trainer.examinations.JsonUser;
import com.github.aistomin.trainer.examinations.User;
import java.io.File;
import java.io.IOException;

/**
 * Current application user.
 *
 * @since 1.0
 */
public final class CurrentUser implements User {

    /**
     * Current user.
     */
    private final User usr;

    /**
     * Ctor.
     */
    public CurrentUser() {
        this(new JsonUser(Resources.find("user.json")));
    }

    /**
     * Ctor.
     *
     * @param user Current user.
     */
    public CurrentUser(final User user) {
        this.usr = user;
    }

    @Override
    public Long identifier() {
        return this.usr.identifier();
    }

    @Override
    public String username() {
        return this.usr.username();
    }

    @Override
    public String password() {
        return this.usr.password();
    }

    @Override
    public User changeUsername(final String username) throws IOException {
        return this.usr.changeUsername(username);
    }

    @Override
    public User clone(final File file) {
        return new CurrentUser(this.usr.clone(file));
    }

    @Override
    public User clone(final File file, final Long id) {
        return new CurrentUser(this.usr.clone(file, id));
    }

    @Override
    public User dump(final File file) throws IOException {
        return this.usr.dump(file);
    }
}
