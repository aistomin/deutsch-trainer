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

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Locale;
import java.util.ResourceBundle;
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
            ResourceBundle.getBundle(
                "messages",
                Locale.getDefault()
            ).getString("app.title")
        );
        label.setName("lblTitle");
        add(label, gbc);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        final JPanel buttons = new JPanel(new GridBagLayout());
        buttons.add(
            MenuPane.createButton("btnLearnNewWords", "menu.learn.new.words"),
            gbc
        );
        buttons.add(
            MenuPane.createButton("btnTestNewWords", "menu.test.new.words"),
            gbc
        );
        buttons.add(
            MenuPane.createButton("btnTestOldWords", "menu.test.old.words"),
            gbc
        );
        buttons.add(
            MenuPane.createButton("btnEditDictionary", "menu.edit.dictionary"),
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
     * @return The button.
     */
    private static JButton createButton(
        final String name, final String caption
    ) {
        final ResourceBundle bundle = ResourceBundle.getBundle(
            "messages",
            Locale.getDefault()
        );
        final JButton learn = new JButton(
            bundle.getString(caption)
        );
        learn.setName(name);
        return learn;
    }
}
