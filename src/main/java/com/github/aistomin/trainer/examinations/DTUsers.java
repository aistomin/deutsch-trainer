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
package com.github.aistomin.trainer.examinations;

import com.github.aistomin.trainer.deutsch.utils.Configurations;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.codegen.maven.example.tables.DtUser;
import org.jooq.impl.DSL;

/**
 * Class that encapsulates logic of using "dt_user" table.
 *
 * @since 1.0
 */
public final class DTUsers implements Users {

    /**
     * Database configuration.
     */
    private final Configurations.Db db;

    /**
     * Ctor.
     *
     * @param database Database configuration.
     */
    public DTUsers(final Configurations.Db database) {
        this.db = database;
    }

    /**
     * Load current user record from the database.
     *
     * @return User's record.
     */
    public User currentUser() {
        final Record record;
        try (
            Connection conn = DriverManager.getConnection(
                this.db.url(), this.db.username(), this.db.password()
            )
        ) {
            record = DSL.using(conn, SQLDialect.POSTGRES)
                .select()
                .from(DtUser.DT_USER)
                .fetch().get(0);
        } catch (final SQLException error) {
            throw new RuntimeException(error);
        }
        return new DTUser(record);
    }
}
