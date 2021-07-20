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

import java.io.File;
import java.net.URISyntaxException;

/**
 * Reources representation.
 *
 * @since 1.0
 */
@SuppressWarnings("PMD.ProhibitPublicStaticMethods")
public final class Resources {

    /**
     * Ctor.
     */
    private Resources() {
    }

    /**
     * Search for the file in resources.
     *
     * @param filename Filename.
     * @return Found file.
     * @throws URISyntaxException If something goes wrong.
     */
    public static File find(final String filename) throws URISyntaxException {
        return new File(
            Thread
                .currentThread()
                .getContextClassLoader()
                .getResource(filename).toURI()
        );
    }
}
