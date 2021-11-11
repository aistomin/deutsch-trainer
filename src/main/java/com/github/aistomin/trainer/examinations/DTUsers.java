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
import java.util.List;
import java.util.stream.Collectors;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.codegen.maven.example.tables.DtUser;
import org.jooq.codegen.maven.example.tables.records.DtUserRecord;
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

    @Override
    public User currentUser() {
        final List<User> users = this.all();
        if (users.size() == 0) {
            throw new IllegalStateException("Current user not found.");
        }
        return users.get(users.size() - 1);
    }

    @Override
    public User create(final String username, final String password) {
        try (
            Connection conn = DriverManager.getConnection(
                this.db.url(), this.db.username(), this.db.password()
            )
        ) {
            final DtUserRecord record = DSL.using(conn, SQLDialect.POSTGRES)
                .newRecord(DtUser.DT_USER);
            record.setUsername(username);
            record.setPassword(password);
            record.store();
            return new DTUser(record);
        } catch (final SQLException error) {
            throw new RuntimeException(error);
        }
    }

    @Override
    public User save(final User user) {
        try (
            Connection conn = DriverManager.getConnection(
                this.db.url(), this.db.username(), this.db.password()
            )
        ) {
            final Result<DtUserRecord> records = DSL.using(
                conn, SQLDialect.POSTGRES
                )
                .selectFrom(DtUser.DT_USER)
                .where(DtUser.DT_USER.ID.eq(user.identifier()))
                .fetch();
            if (records.size() != 1) {
                throw new IllegalStateException("User not found.");
            }
            final DtUserRecord record = records.get(0);
            record.setUsername(user.username());
            record.setPassword(user.password());
            record.store();
            return new DTUser(record);
        } catch (final SQLException error) {
            throw new RuntimeException(error);
        }
    }

    @Override
    public void delete(final List<User> users) {
        try (
            Connection conn = DriverManager.getConnection(
                this.db.url(), this.db.username(), this.db.password()
            )
        ) {
            final DSLContext dsl = DSL.using(conn, SQLDialect.POSTGRES);
            for (final User user : users) {
                dsl.deleteFrom(DtUser.DT_USER)
                    .where(DtUser.DT_USER.ID.eq(user.identifier()))
                    .execute();
            }
        } catch (final SQLException error) {
            throw new RuntimeException(error);
        }
    }

    @Override
    public List<User> all() {
        try (
            Connection conn = DriverManager.getConnection(
                this.db.url(), this.db.username(), this.db.password()
            )
        ) {
            return DSL.using(conn, SQLDialect.POSTGRES)
                .select()
                .from(DtUser.DT_USER)
                .orderBy(DtUser.DT_USER.ID)
                .fetch()
                .stream()
                .map(DTUser::new)
                .collect(Collectors.toList());
        } catch (final SQLException error) {
            throw new RuntimeException(error);
        }
    }
}
