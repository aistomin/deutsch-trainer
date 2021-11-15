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
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
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
        final List<User> result = new ArrayList<>(0);
        this.withDatabase(
            dsl -> {
                final DtUserRecord record = dsl.newRecord(DtUser.DT_USER);
                record.setUsername(username);
                record.setPassword(password);
                record.store();
                result.add(
                    new DTUser(
                        this,
                        record.getId(),
                        record.getUsername(),
                        record.getPassword()
                    )
                );
            }
        );
        return result.get(0);
    }

    @Override
    public User save(final User user) {
        final List<User> result = new ArrayList<>(0);
        this.withDatabase(
            dsl -> {
                final Result<DtUserRecord> records = dsl
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
                result.add(
                    new DTUser(
                        this,
                        record.getId(),
                        record.getUsername(),
                        record.getPassword()
                    )
                );
            }
        );
        return result.get(0);
    }

    @Override
    public void delete(final List<User> users) {
        this.withDatabase(
            dsl -> {
                for (final User user : users) {
                    dsl.deleteFrom(DtUser.DT_USER)
                        .where(DtUser.DT_USER.ID.eq(user.identifier()))
                        .execute();
                }
            }
        );
    }

    @Override
    public List<User> all() {
        final List<User> users = new ArrayList<>(0);
        this.withDatabase(
            dsl -> users.addAll(dsl.select()
                .from(DtUser.DT_USER)
                .orderBy(DtUser.DT_USER.ID)
                .fetch()
                .stream()
                .map(
                    record -> new DTUser(
                        this,
                        record.getValue(DtUser.DT_USER.ID),
                        record.getValue(DtUser.DT_USER.USERNAME),
                        record.getValue(DtUser.DT_USER.PASSWORD)
                    )
                )
                .collect(Collectors.toList()))
        );
        return users;
    }

    /**
     * Execute some logic within database context.
     *
     * @param consumer The logic that needs to be executed.
     */
    private void withDatabase(final Consumer<DSLContext> consumer) {
        try (
            Connection conn = DriverManager.getConnection(
                this.db.url(), this.db.username(), this.db.password()
            )
        ) {
            consumer.accept(DSL.using(conn, SQLDialect.POSTGRES));
        } catch (final SQLException error) {
            throw new RuntimeException(error);
        }
    }
}
