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

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class that run's application UI.
 *
 * @since 1.0
 */
public final class Trainer {

    /**
     * Ctor.
     */
    private Trainer() {
    }

    /**
     * Program's entry point.
     *
     * @param args Arguments.
     */
    public static void main(final String... args) {
        final Logger logger = LoggerFactory.getLogger(Trainer.class);
        logger.info(
            String.format(
                "Application started with parameters: %s",
                String.join("; ", args)
            )
        );
        javax.swing.SwingUtilities.invokeLater(
            () -> new TrainerFrame(
                "app.title", JFrame.EXIT_ON_CLOSE,
                new MenuPane(new MainMenuActions()).init()
            ).setVisible(true)
        );
    }

    /**
     * Main menu actions.
     *
     * @since 1.0
     */
    private static class MainMenuActions implements MenuController {

        @Override
        public void learnNewWords() {
            new TrainerFrame(
                "menu.learn.new.words", JFrame.HIDE_ON_CLOSE, new JPanel()
            ).setVisible(true);
        }

        @Override
        public void testNewWords() {
            JOptionPane.showMessageDialog(
                null, "TODO: Test new words."
            );
        }

        @Override
        public void testOldWords() {
            JOptionPane.showMessageDialog(
                null, "TODO: Test old words."
            );
        }

        @Override
        public void editDictionary() {
            new TrainerFrame(
                "menu.edit.dictionary", JFrame.HIDE_ON_CLOSE, new JPanel()
            ).setVisible(true);
        }
    }
}
