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
package com.github.aistomin.trainer.deutsch;

import com.github.aistomin.trainer.deutsch.vocabulary.LexicalUnit;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * General dictionary interface.
 *
 * @since 1.0
 */
public interface Dictionary {

    /**
     * The version of the dictionary.
     *
     * @return String version.
     */
    String version();

    /**
     * Load all the words from the dictionary.
     *
     * @param filter Word's filter.
     * @return List of the words contained in the dictionary.
     */
    List<LexicalUnit> words(WordsFilter filter);

    /**
     * Validate the consistency of the dictionary.
     *
     * @throws InvalidDictionaryException If dictionary is not consistent.
     */
    void validate() throws InvalidDictionaryException;

    /**
     * Generate ID for the next lexical unit in the dictionary.
     *
     * @return ID.
     */
    Long generateNextId();

    /**
     * Dump dictionary to the new file.
     *
     * @param file Destination file.
     * @return New dictionary associated with the file.
     * @throws IOException If read/write error occurs.
     */
    Dictionary dump(File file) throws IOException;

    /**
     * Clone the dictionary.
     *
     * @param file Destination file.
     * @return New dictionary associated with the file.
     * @throws InvalidDictionaryException If the dictionary became inconsistent
     *  after the modification.
     * @throws IOException If read/write error occurs.
     */
    Dictionary clone(File file) throws InvalidDictionaryException, IOException;

    /**
     * Clone the dictionary.
     *
     * @param file Destination file.
     * @param version New dictionary version.
     * @return New dictionary associated with the file.
     * @throws InvalidDictionaryException If the dictionary became inconsistent
     *  after the modification.
     * @throws IOException If read/write error occurs.
     */
    Dictionary clone(
        File file, String version
    ) throws InvalidDictionaryException, IOException;

    /**
     * Add a lexical unit to the dictionary.
     *
     * @param unit A lexical unit to add.
     * @throws InvalidDictionaryException If the dictionary became inconsistent
     *  after the modification.
     * @throws IOException If read/write error occurs.
     */
    void add(LexicalUnit unit) throws InvalidDictionaryException, IOException;

    /**
     * Replace the unit with the same ID. Note: the unit with the same ID must
     * already be in the dictionary, otherwise you will get the
     * {@link IllegalStateException}.
     *
     * @param replacement The unit that needs to be added to the dictionary
     *  instead the old one.
     * @throws InvalidDictionaryException If the dictionary became inconsistent
     *  after the modification.
     * @throws IOException If read/write error occurs.
     */
    void replace(
        LexicalUnit replacement
    ) throws InvalidDictionaryException, IOException;

    /**
     * Delete a lexical unit from the dictionary.
     *
     * @param unit A lexical unit to be deleted.
     * @throws InvalidDictionaryException If the dictionary became inconsistent
     *  after the modification.
     * @throws IOException If read/write error occurs.
     */
    void delete(
        LexicalUnit unit
    ) throws InvalidDictionaryException, IOException;
}
