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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class that run's application UI.
 *
 * @since 1.0
 */
public final class Trainer {

    /**
     * Window's width.
     */
    private static final int WIDTH = 800;

    /**
     * Windows height.
     */
    private static final int HEIGHT = 400;

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
            () -> {
                final JFrame frame = new JFrame(
                    new TextMessages().message("app.title")
                );
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new MenuPane(new MainMenuActions(frame)).init());
                frame.pack();
                frame.setSize(Trainer.WIDTH, Trainer.HEIGHT);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        );
    }

    /**
     * Main menu actions.
     *
     * @since 1.0
     */
    private static class MainMenuActions implements MenuController {

        /**
         * Parent frame.
         */
        private final JFrame frame;

        /**
         * Ctor.
         *
         * @param parent Parent frame.
         */
        MainMenuActions(final JFrame parent) {
            this.frame = parent;
        }

        @Override
        public void learnNewWords() {
            JOptionPane.showMessageDialog(this.frame, "TODO: Learn new words.");
        }

        @Override
        public void testNewWords() {
            JOptionPane.showMessageDialog(
                this.frame, "TODO: Test new words."
            );
        }

        @Override
        public void testOldWords() {
            JOptionPane.showMessageDialog(
                this.frame, "TODO: Test old words."
            );
        }

        @Override
        public void editDictionary() {
            final JFrame dictionary = new JFrame(
                new TextMessages().message("menu.edit.dictionary")
            );
            dictionary.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            dictionary.pack();
            dictionary.setSize(Trainer.WIDTH, Trainer.HEIGHT);
            dictionary.setLocationRelativeTo(null);
            dictionary.setVisible(true);
        }
    }
}
