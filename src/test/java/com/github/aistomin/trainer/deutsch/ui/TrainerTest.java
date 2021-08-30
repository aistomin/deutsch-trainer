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

import java.awt.Frame;
import org.assertj.swing.core.GenericTypeMatcher;
import org.assertj.swing.core.Robot;
import org.assertj.swing.finder.WindowFinder;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test for {@link Trainer}.
 *
 * @since 1.0
 */
final class TrainerTest extends UITest {

    /**
     * Check that we correctly start the application.
     */
    @Test
    void testMainWindow() {
        final Robot robot = robot();
        Assertions.assertNotNull(robot);
        final FrameFixture frame = WindowFinder.findFrame(
            new GenericTypeMatcher<Frame>(Frame.class) {
                protected boolean isMatching(final Frame frame) {
                    return "Deutsch Trainer".equals(frame.getTitle())
                        && frame.isShowing();
                }
            }
        ).using(robot);
        Assertions.assertNotNull(frame.button("btnLearnNewWords"));
        Assertions.assertEquals(0, 1);
    }
}
