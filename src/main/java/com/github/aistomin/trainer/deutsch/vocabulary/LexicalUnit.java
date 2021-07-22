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
package com.github.aistomin.trainer.deutsch.vocabulary;

import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import com.github.aistomin.testist.Question;
import java.util.List;
import java.util.Set;

/**
 * A lexical unit interface. Possible implementations: word, sentence etc.
 *
 * @since 1.0
 */
public abstract class LexicalUnit {

    /**
     * Unique unit's identifier.
     */
    private final Long code;

    /**
     * Some additional free-text information.
     */
    private final String description;

    /**
     * Ctor.
     *
     * @param id Unique unit's identifier.
     * @param info Some additional free-text information.
     */
    protected LexicalUnit(final Long id, final String info) {
        this.code = id;
        this.description = info;
    }

    /**
     * All the possible questions related to this lexical unit.
     *
     * @return List of questions.
     */
    public abstract List<Question> questions();

    /**
     * Get all the related lexical units.
     *
     * @return Related units.
     */
    public abstract Set<LexicalUnit> relatedLexicalUnits();

    /**
     * Unique lexical unit's identifier.
     *
     * @return Identifier.
     */
    public Long identifier() {
        return this.code;
    }

    /**
     * Get some additional free-text information.
     *
     * @return Some additional free-text information.
     */
    public String info() {
        return this.description;
    }

    /**
     * Get lexical unit info if it is present.
     *
     * @param obj JSON object.
     * @return Value.
     */
    protected static String parseInfo(final JsonObject obj) {
        final JsonValue val = obj.get("info");
        final String res;
        if (val == null) {
            res = null;
        } else {
            res = val.asString();
        }
        return res;
    }
}
