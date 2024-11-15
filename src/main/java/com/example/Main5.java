package com.example;

/**
 * @author huzhibo
 * @Date 2024-10-18 10:16
 * @desc
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main5 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Hello, JavaFX!");

        // 设置字体大小为18
        label.setStyle("-fx-font-size: 2em");

        HBox hBox = new HBox();
        hBox.setStyle("-fx-background-color: aqua;-fx-border-radius: 50;-fx-background-radius: 50;-fx-min-width: 120;-fx-max-width:120;-fx-min-height: 50;-fx-max-height: 50");
        hBox.getChildren().addAll(label);

        StackPane root = new StackPane();
        root.getChildren().add(hBox);

        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Label Font Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}