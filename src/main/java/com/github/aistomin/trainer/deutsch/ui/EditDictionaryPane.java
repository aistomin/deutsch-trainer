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
import com.github.aistomin.trainer.deutsch.WordsFilter;
import com.github.aistomin.trainer.deutsch.vocabulary.LexicalUnit;
import java.util.Arrays;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

/**
 * Main menu UI.
 *
 * @since 1.0
 * @checkstyle ClassDataAbstractionCouplingCheck (1000 lines)
 */
public final class EditDictionaryPane extends JPanel {

    /**
     * Menu's border size.
     */
    private static final int BORDER = 10;

    /**
     * Dictionary.
     */
    private final Dictionary dict;

    /**
     * Ctor.
     *
     * @param dictionary Dictionary.
     */
    public EditDictionaryPane(
        final Dictionary dictionary
    ) {
        this.dict = dictionary;
    }

    /**
     * Initialise the pane.
     *
     * @return Fully stuffed pane.
     */
    public EditDictionaryPane init() {
        this.setBorder(
            new EmptyBorder(
                EditDictionaryPane.BORDER,
                EditDictionaryPane.BORDER,
                EditDictionaryPane.BORDER,
                EditDictionaryPane.BORDER
            )
        );
        final List<String> columns = Arrays.asList("ID", "German", "English");
        final List<LexicalUnit> words = this.dict.words(WordsFilter.ALL);
        final JTable table = new JTable(
            new DictionaryTableModel(words, columns)
        );
        final JScrollPane content = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        this.add(content);
        return this;
    }

    /**
     * Dictionary's table model.
     *
     * @since 1.0
     */
    private static final class DictionaryTableModel extends AbstractTableModel {

        /**
         * Words.
         */
        private final List<LexicalUnit> words;

        /**
         * Columns.
         */
        private final List<String> columns;

        /**
         * Ctor.
         *
         * @param words Words.
         * @param columns Columns.
         */
        DictionaryTableModel(
            final List<LexicalUnit> words,
            final List<String> columns
        ) {
            this.words = words;
            this.columns = columns;
        }

        @Override
        public int getRowCount() {
            return this.words.size();
        }

        @Override
        public int getColumnCount() {
            return this.columns.size();
        }

        @Override
        public Object getValueAt(final int row, final int column) {
            final LexicalUnit word = this.words.get(row);
            final String id = word.identifier().toString();
            final List<String> values = Arrays.asList(
                id,
                String.format("German %s", id),
                String.format("English %s", id)
            );
            return values.get(column);
        }

        @Override
        public String getColumnName(final int column) {
            return this.columns.get(column);
        }
    }
}
