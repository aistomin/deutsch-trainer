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

/**
 * Controller that contains all the main menu actions.
 *
 * @since 1.0
 */
public interface MenuController {

    /**
     * The "Learn new words" menu action.
     */
    void learnNewWords();

    /**
     * The "Test new words" menu action.
     */
    void testNewWords();

    /**
     * The "Test old words" menu action.
     */
    void testOldWords();

    /**
     * The "Edit dictionary" menu action.
     */
    void editDictionary();
}
