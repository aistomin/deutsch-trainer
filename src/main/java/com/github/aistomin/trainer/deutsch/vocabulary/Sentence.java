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

import com.github.aistomin.testist.Question;
import java.util.List;

/**
 * A sentence in the language.
 *
 * @since 1.0
 * @todo Issue-4. Let's implement the class and remove this todo.
 */
public final class Sentence implements LexicalUnit {

    @Override
    public List<Question> questions() {
        return null;
    }
}
