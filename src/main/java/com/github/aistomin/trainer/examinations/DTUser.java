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
 * User implementation that takes data from the database.
 *
 * @since 1.0
 * @todo: Let's solve issue #255 and remove this TODO.
 * @todo: Let's solve issue #256 and remove this TODO.
 * @todo: Let's solve issue #257 and remove this TODO.
 */
public final class DTUser implements User {

    @Override
    public Long identifier() {
        return null;
    }

    @Override
    public String username() {
        return null;
    }

    @Override
    public void changeUsername(final String username) throws IOException {
    }

    @Override
    public User clone(final File file) {
        return null;
    }

    @Override
    public User clone(final File file, final Long id) {
        return null;
    }

    @Override
    public User dump(final File file) throws IOException {
        return null;
    }
}
