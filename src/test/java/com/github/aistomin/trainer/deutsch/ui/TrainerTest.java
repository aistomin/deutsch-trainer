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
import org.assertj.swing.finder.JOptionPaneFinder;
import org.assertj.swing.finder.WindowFinder;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JButtonFixture;
import org.assertj.swing.fixture.JLabelFixture;
import org.assertj.swing.fixture.JOptionPaneFixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test for {@link Trainer}.
 *
 * @since 1.0
 */
final class TrainerTest extends UITest {

    /**
     * Name of the "Learn new words" button.
     */
    public static final String LEARN_NEW = "btnLearnNewWords";

    /**
     * Check that we correctly start the application.
     */
    @Test
    void testMainWindow() {
        final FrameFixture frame = this.createFixture();
        final JLabelFixture title = frame.label("lblTitle");
        Assertions.assertNotNull(title);
        Assertions.assertEquals("Hello andrej!", title.text());
        final JButtonFixture learn = frame.button(
            TrainerTest.LEARN_NEW
        );
        Assertions.assertNotNull(learn);
        Assertions.assertEquals("Learn new words", learn.text());
        final JButtonFixture ntest = frame.button("btnTestNewWords");
        Assertions.assertNotNull(ntest);
        Assertions.assertEquals("Test new words", ntest.text());
        final JButtonFixture otest = frame.button("btnTestOldWords");
        Assertions.assertNotNull(otest);
        Assertions.assertEquals("Test old words", otest.text());
        final JButtonFixture edit = frame.button("btnEditDictionary");
        Assertions.assertNotNull(edit);
        Assertions.assertEquals("Edit dictionary", edit.text());
        this.robot().cleanUpWithoutDisposingWindows();
    }

    /**
     * Check that "Learn new words" menu action works properly.
     */
    @Test
    void testLearnNewWords() {
        final FrameFixture frame = this.createFixture();
        frame.button(TrainerTest.LEARN_NEW).target().doClick();
        final JOptionPaneFixture fixture = JOptionPaneFinder.findOptionPane()
            .using(this.robot());
        fixture.requireMessage("TODO: Learn new words.");
        this.robot().cleanUpWithoutDisposingWindows();
    }

    /**
     * Create test frame fixture.
     *
     * @return Created fixture.
     */
    private FrameFixture createFixture() {
        final Robot robot = this.robot();
        Assertions.assertNotNull(robot);
        return WindowFinder.findFrame(
            new GenericTypeMatcher<Frame>(Frame.class) {
                protected boolean isMatching(final Frame frame) {
                    return "Deutsch Trainer".equals(frame.getTitle())
                        && frame.isShowing();
                }
            }
        ).using(robot);
    }
}
