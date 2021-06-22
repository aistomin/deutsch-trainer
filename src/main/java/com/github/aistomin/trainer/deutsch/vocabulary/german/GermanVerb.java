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
package com.github.aistomin.trainer.deutsch.vocabulary.german;

import com.github.aistomin.testist.Question;
import com.github.aistomin.trainer.deutsch.vocabulary.SimpleWord;
import com.github.aistomin.trainer.deutsch.vocabulary.Word;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents a verb in a language.
 *
 * @since 1.0
 */
public final class GermanVerb extends Word {

    /**
     * Infinitive form of the verb.
     */
    private final SimpleWord infinitive;

    /**
     * Preterite form of the verb.
     */
    private final SimpleWord preterite;

    /**
     * Perfect form of the verb.
     */
    private final SimpleWord perfect;

    /**
     * Ctor.
     *
     * @param infinitive Infinitive form of the verb.
     * @param preterite Preterite form of the verb.
     * @param perfect Perfect form of the verb.
     */
    public GermanVerb(
        final SimpleWord infinitive,
        final SimpleWord preterite,
        final SimpleWord perfect
    ) {
        this.infinitive = infinitive;
        this.preterite = preterite;
        this.perfect = perfect;
    }

    @Override
    public List<Question> questions() {
        final List<Question> inf = this.infinitive.questions();
        final List<Question> pret = this.preterite.questions();
        final List<Question> perf = this.perfect.questions();
        final List<Question> result =
            new ArrayList<>(inf.size() + pret.size() + perf.size());
        result.addAll(inf);
        result.addAll(pret);
        result.addAll(perf);
        return result;
    }

    @Override
    public Question primaryQuestion() {
        return this.infinitive.primaryQuestion();
    }
}
