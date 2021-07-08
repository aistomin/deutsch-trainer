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

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * JavaFX application.
 *
 * @since 1.0
 */
public final class TrainerFX extends Application {

    /**
     * Window's width.
     */
    public static final int WIDTH = 300;

    /**
     * Window's hight.
     */
    public static final int HEIGHT = 200;

    @Override
    public void start(final Stage stage) throws Exception {
        stage.setTitle("Deutsch Trainer");
        stage.setWidth(TrainerFX.WIDTH);
        stage.setHeight(TrainerFX.HEIGHT);
        final Label label = new Label("Hello world!");
        label.setAlignment(Pos.CENTER);
        final Scene scene = new Scene(label);
        stage.setScene(scene);
        stage.show();
    }
}
