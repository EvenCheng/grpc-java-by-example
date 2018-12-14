/*
 * Copyright 2016 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.grpc.chat;/**
 * Created by rayt on 5/16/16.
 */

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ChatClient extends Application {
  private ObservableList<String> messages = FXCollections.observableArrayList();
  private ListView<String> messagesView = new ListView<>();
  private TextField name = new TextField("name");
  private TextField message = new TextField();
  private Button send = new Button("Send");

  public static void main(String[] args) {
    launch(args);
  }

  protected void init(Stage primaryStage) {
    messagesView.setItems(messages);

    BorderPane pane = new BorderPane();
    pane.setLeft(name);
    pane.setCenter(message);
    pane.setRight(send);

    BorderPane root = new BorderPane();
    root.setCenter(messagesView);
    root.setBottom(pane);

    primaryStage.setTitle("gRPC Chat");
    primaryStage.setScene(new Scene(root, 480, 320));

    primaryStage.show();
  }

  @Override
  public void start(Stage primaryStage) {
    init(primaryStage);

    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext(true).build();
    ChatServiceGrpc.ChatServiceStub chatService = ChatServiceGrpc.newStub(channel);

    // 1. Implement primaryStage.setOnCloseRequest: shutdown!

    // 2. Make the call

    // 3. Implement send.setOnAction: send the message

    // 4. Make the messages show up with Platform.runLater, don't forget to scroll to the end

  }
}