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
import com.github.aistomin.trainer.deutsch.vocabulary.LexicalUnit;
import com.github.aistomin.trainer.deutsch.vocabulary.Word;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class that represents a verb in a language.
 *
 * @since 1.0
 */
public final class GermanVerb extends Word {

    /**
     * Infinitive form of the verb.
     */
    private final Word infinitive;

    /**
     * Preterite form of the verb.
     */
    private final Word preterite;

    /**
     * Perfect form of the verb.
     */
    private final Word perfect;

    /**
     * Ctor.
     * @param id Unique unit's identifier.
     * @param infinitive Infinitive form of the verb.
     * @param preterite Preterite form of the verb.
     * @param perfect Perfect form of the verb.
     * @checkstyle ParameterNumberCheck (10 lines)
     */
    public GermanVerb(
        final Long id,
        final Word infinitive,
        final Word preterite,
        final Word perfect
    ) {
        super(id);
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
    public Set<LexicalUnit> relatedLexicalUnits() {
        final Set<LexicalUnit> result = new HashSet<>(0);
        result.add(this.infinitive);
        result.addAll(this.infinitive.relatedLexicalUnits());
        result.add(this.preterite);
        result.addAll(this.preterite.relatedLexicalUnits());
        result.add(this.perfect);
        result.addAll(this.perfect.relatedLexicalUnits());
        return result;
    }

    @Override
    public Question primaryQuestion() {
        return this.infinitive.primaryQuestion();
    }
}
