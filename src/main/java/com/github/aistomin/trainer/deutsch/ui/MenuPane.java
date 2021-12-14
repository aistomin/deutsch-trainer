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

import com.github.aistomin.trainer.examinations.User;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Main menu UI.
 *
 * @since 1.0
 */
public final class MenuPane extends JPanel {

    /**
     * Menu's border size.
     */
    private static final int BORDER = 10;

    /**
     * Main menu controller.
     */
    private final MenuController actions;

    /**
     * Current user.
     */
    private final User usr;

    /**
     * Ctor.
     *
     * @param controller Main menu controller.
     * @param user Current user.
     */
    public MenuPane(final MenuController controller, final User user) {
        this.actions = controller;
        this.usr = user;
    }

    /**
     * Initialise the pane.
     *
     * @return Fully stuffed pane.
     */
    public MenuPane init() {
        this.setBorder(
            new EmptyBorder(
                MenuPane.BORDER,
                MenuPane.BORDER,
                MenuPane.BORDER,
                MenuPane.BORDER
            )
        );
        this.setLayout(new GridBagLayout());
        final GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        final JLabel label = new JLabel(
            String.format(
                new TextMessages().message("app.greeting"),
                this.usr.username()
            )
        );
        label.setName("lblTitle");
        add(label, gbc);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        final JPanel buttons = new JPanel(new GridBagLayout());
        buttons.add(
            MenuPane.createButton(
                "btnLearnNewWords",
                "menu.learn.new.words",
                this.actions::learnNewWords
            ),
            gbc
        );
        buttons.add(
            MenuPane.createButton(
                "btnTestNewWords",
                "menu.test.new.words",
                this.actions::testNewWords
            ),
            gbc
        );
        buttons.add(
            MenuPane.createButton(
                "btnTestOldWords",
                "menu.test.old.words",
                this.actions::testOldWords
                ),
            gbc
        );
        buttons.add(
            MenuPane.createButton(
                "btnEditDictionary",
                "menu.edit.dictionary",
                this.actions::editDictionary
            ),
            gbc
        );
        gbc.weighty = 1;
        this.add(buttons, gbc);
        return this;
    }

    /**
     * Create a button.
     *
     * @param name Button's name.
     * @param caption Button's caption's localisation key.
     * @param onclick On click event.
     * @return The button.
     */
    private static JButton createButton(
        final String name, final String caption, final ActionListener onclick
    ) {
        final JButton btn = new JButton(
            new TextMessages().message(caption)
        );
        btn.setName(name);
        btn.addActionListener(onclick);
        return btn;
    }
}
