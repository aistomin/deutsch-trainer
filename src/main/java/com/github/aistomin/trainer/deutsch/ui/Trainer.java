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

import com.github.aistomin.trainer.deutsch.Dictionary;
import com.github.aistomin.trainer.deutsch.JsonDictionary;
import com.github.aistomin.trainer.deutsch.utils.Resources;
import com.github.aistomin.trainer.examinations.DTUser;
import com.github.aistomin.trainer.examinations.JsonUser;
import com.github.aistomin.trainer.examinations.User;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.JButton;
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
        final Dictionary dictionary;
        final User user;
        if (args.length > 0) {
            dictionary = new JsonDictionary(
                new File(String.format("%s/dict.json", new File(args[0])))
            );
            user = new JsonUser(
                new File(String.format("%s/user.json", new File(args[0])))
            );
        } else {
            dictionary = new JsonDictionary(Resources.find("dict.json"));
            user = new CurrentUser();
        }
        javax.swing.SwingUtilities.invokeLater(
            () -> new TrainerFrame(
                "app.title", JFrame.EXIT_ON_CLOSE,
                new MenuPane(new MainMenuActions(dictionary), user).init(),
                false
            ).setVisible(true)
        );
    }

    /**
     * Main menu actions.
     *
     * @since 1.0
     */
    private static final class MainMenuActions implements MenuController {

        /**
         * Dictionary.
         */
        private final Dictionary dict;

        /**
         * Ctor.
         *
         * @param dictionary Dictionary.
         */
        private MainMenuActions(final Dictionary dictionary) {
            this.dict = dictionary;
        }

        @Override
        public void learnNewWords(final ActionEvent event) {
            new TrainerFrame(
                "menu.learn.new.words", JFrame.HIDE_ON_CLOSE, new JPanel(), true
            ).setVisible(true);
        }

        @Override
        public void testNewWords(final ActionEvent event) {
            JOptionPane.showMessageDialog(
                null, "TODO: Test new words."
            );
        }

        @Override
        public void testOldWords(final ActionEvent event) {
            JOptionPane.showMessageDialog(
                null, "TODO: Test old words."
            );
        }

        @Override
        public void editDictionary(final ActionEvent event) {
            final JButton btn = (JButton) event.getSource();
            btn.setEnabled(false);
            final TrainerFrame frame = new TrainerFrame(
                "menu.edit.dictionary", JFrame.HIDE_ON_CLOSE,
                new EditDictionaryPane(this.dict).init(), true
            );
            frame.addWindowListener(new TrainerWindowAdapter(btn));
            frame.setVisible(true);
        }

        /**
         * The trainer windows adapter. The mission of the class is to enable
         * the button after window is displayed.
         *
         * @since 1.0
         */
        private static class TrainerWindowAdapter extends WindowAdapter {

            /**
             * Button that opened the window.
             */
            private final JButton btn;

            /**
             * Ctor.
             *
             * @param button Button that opened the window.
             */
            TrainerWindowAdapter(final JButton button) {
                this.btn = button;
            }

            @Override
            public void windowClosing(final WindowEvent wev) {
                super.windowClosing(wev);
                this.btn.setEnabled(true);
            }
        }
    }
}
