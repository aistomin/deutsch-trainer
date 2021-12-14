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
package com.github.aistomin.trainer.deutsch.vocabulary;

/**
 * Class that represents a simple language A to language B translation.
 *
 * @since 1.0
 */
public final class Translation {

    /**
     * Original text.
     */
    private final String org;

    /**
     * Translation text.
     */
    private final String trg;

    /**
     * Ctor.
     *
     * @param original Original text.
     * @param target Translation text.
     */
    public Translation(final String original, final String target) {
        this.org = original;
        this.trg = target;
    }

    /**
     * Get the original text.
     *
     * @return The original text.
     */
    public String originalText() {
        return this.org;
    }

    /**
     * Get the translation text.
     *
     * @return The translation text.
     */
    public String translationText() {
        return this.trg;
    }
}
