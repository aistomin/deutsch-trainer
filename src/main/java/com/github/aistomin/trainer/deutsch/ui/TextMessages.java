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
package com.github.aistomin.trainer.deutsch.ui;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * String bundle wrapper.
 *
 * @since 1.0
 */
public final class TextMessages {

    /**
     * Bundle.
     */
    private final ResourceBundle bundle;

    /**
     * Ctor.
     */
    public TextMessages() {
        this.bundle = ResourceBundle.getBundle(
            "messages",
            Locale.getDefault()
        );
    }

    /**
     * Get string message from the bundle.
     *
     * @param key Key.
     * @return Value.
     */
    public String message(final String key) {
        return this.bundle.getString(key);
    }
}
