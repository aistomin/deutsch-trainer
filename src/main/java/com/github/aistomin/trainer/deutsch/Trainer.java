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
package com.github.aistomin.trainer.deutsch;

import com.github.aistomin.testist.demo.SimpleTestConsole;
import com.github.aistomin.testist.simple.SimpleTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The application entry point.
 *
 * @since 1.0
 */
public final class Trainer {

    /**
     * Logger.
     */
    private static final Logger LOG =
        LoggerFactory.getLogger(Trainer.class);

    /**
     * Default amount of questions.
     */
    private static final int AMOUNT = 10;

    /**
     * Ctor.
     */
    private Trainer() {
    }

    /**
     * Runnable method.
     *
     * @param args Arguments.
     */
    public static void main(final String... args) {
        final WordsFilter filter;
        if (args.length > 0) {
            filter = WordsFilter.valueOf(args[0]);
        } else {
            filter = WordsFilter.ALL;
        }
        new SimpleTestConsole(
            new SimpleTest(new Questions(Trainer.AMOUNT, filter)),
            Trainer.LOG::info
        ).runTest();
    }
}
