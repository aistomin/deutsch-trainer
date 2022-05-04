/*
 * Copyright (c) 2021-2022, Istomin Andrei
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
package com.github.aistomin.trainer.deutsch.utils;

import com.github.aistomin.trainer.deutsch.ui.Trainer;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application configurations.
 *
 * @since 1.0
 */
public final class Configurations {

    /**
     * Application properties file.
     */
    private final String file;

    /**
     * Ctor.
     */
    public Configurations() {
        this.file = "application.properties";
    }

    /**
     * Get database configuration.
     *
     * @return Database configuration.
     */
    public Db database() {
        return new Db(
            this.property("db_url"),
            this.property("db_user"),
            this.property("db_password")
        );
    }

    /**
     * Load application property.
     *
     * @param name Property key.
     * @return Value.
     */
    private String property(final String name) {
        final String key = String.format("dt_%s", name);
        final String env = System.getenv(key);
        if (env == null) {
            final String sys = System.getProperty(key);
            if (sys == null) {
                try {
                    final Properties props = new Properties();
                    props.load(new FileReader(Resources.find(this.file)));
                    return props.getProperty(name);
                } catch (final IOException error) {
                    throw new RuntimeException(error);
                }
            } else {
                return sys;
            }
        } else {
            return env;
        }
    }

    public static class Db {

        /**
         * Database URL.
         */
        private final String link;

        /**
         * Database user.
         */
        private final String user;

        /**
         * Database password.
         */
        private final String pass;

        /**
         * Ctor.
         *
         * @param url      Database URL.
         * @param username Database user.
         * @param password Database password.
         */
        public Db(
            final String url,
            final String username,
            final String password
        ) {
            this.link = url;
            this.user = username;
            this.pass = password;
        }

        /**
         * Get database URL.
         *
         * @return Database URL.
         */
        public String url() {
            return link;
        }

        /**
         * Get database user.
         *
         * @return Database user.
         */
        public String username() {
            return user;
        }

        /**
         * Get database password.
         *
         * @return Password.
         */
        public String password() {
            return pass;
        }
    }
}
