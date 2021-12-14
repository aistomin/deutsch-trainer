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

import java.awt.event.ActionEvent;

/**
 * Controller that contains all the main menu actions.
 *
 * @since 1.0
 */
public interface MenuController {

    /**
     * The "Learn new words" menu action.
     *
     * @param event Action event.
     */
    void learnNewWords(ActionEvent event);

    /**
     * The "Test new words" menu action.
     *
     * @param event Action event.
     */
    void testNewWords(ActionEvent event);

    /**
     * The "Test old words" menu action.
     *
     * @param event Action event.
     */
    void testOldWords(ActionEvent event);

    /**
     * The "Edit dictionary" menu action.
     *
     * @param event Action event.
     */
    void editDictionary(ActionEvent event);
}
