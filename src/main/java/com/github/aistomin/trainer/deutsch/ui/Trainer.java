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

/**
 * Main class that run's application UI.
 *
 * @since 1.0
 */
public final class Trainer {

    /**
     * Window's width.
     */
    private static final int WIDTH = 400;

    /**
     * Windows height.
     */
    private static final int HEIGHT = 200;

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
        javax.swing.SwingUtilities.invokeLater(
            () -> {
                final JFrame frame = new JFrame("Deutsch Trainer");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new MenuPane().init());
                frame.pack();
                frame.setSize(Trainer.WIDTH, Trainer.HEIGHT);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        );
    }
}
