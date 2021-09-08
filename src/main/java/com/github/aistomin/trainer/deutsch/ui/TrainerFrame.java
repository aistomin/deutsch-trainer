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

import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 * Standard frame of the application.
 *
 * @since 1.0
 */
public final class TrainerFrame extends JFrame {

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
     *
     * @param key The frame's title's localisation key.
     * @param close Default close operation.
     * @throws HeadlessException If the graphical UI is not available.
     */
    @SuppressWarnings("PMD.ConstructorOnlyInitializesOrCallOtherConstructors")
    public TrainerFrame(
        final String key,
        final int close
    ) throws HeadlessException {
        super(new TextMessages().message(key));
        this.setDefaultCloseOperation(close);
        this.setSize(TrainerFrame.WIDTH, TrainerFrame.HEIGHT);
        this.setLocationRelativeTo(null);
    }
}
