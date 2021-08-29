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

import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.assertj.swing.launcher.ApplicationLauncher;
import org.junit.jupiter.api.BeforeEach;

/**
 * Base UI tests class.
 *
 * @since 1.0
 * @checkstyle AbbreviationAsWordInNameCheck (2 lines)
 */
public abstract class UITest extends AssertJSwingJUnitTestCase {

    /**
     * Set up method where we start the app.
     */
    protected void onSetUp() {
        ApplicationLauncher.application(Trainer.class).start();
    }

    /**
     * This method is important for the AssertJSwing to work with JUnit5.
     *
     * @throws Exception If something goes wrong.
     */
    @BeforeEach
    void startApp() throws Exception {
        this.setUp();
    }
}
