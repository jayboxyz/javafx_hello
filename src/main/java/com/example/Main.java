package com.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author huzhibo
 * @Date 2024-10-09 14:51
 * @desc
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        StackPane stackPane = new StackPane();

        Label label = new Label();
        label.setText("Hello, StackPane!");
        label.setStyle("-fx-font-size: 24px; -fx-text-fill: blue;");

        HBox hBox = new HBox();

        Button button = new Button("Click Me");
        button.setStyle("-fx-background-color: green; -fx-text-fill: white;-fx-alignment: center-right");

//        hBox.setStyle("-fx-background-color: aqua;-fx-alignment: center-right");
//        hBox.setMinWidth(100);
//        hBox.setMaxWidth(100);
//        hBox.setMinHeight(100);
//        hBox.setMaxHeight(100);
//        hBox.getChildren().add(button);
//
//        // 将矩形向右平移100个单位
//        hBox.setTranslateY(30);

        javafx.scene.image.ImageView imageView = new ImageView(new Image("/icons/click2.png"));
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);


        button.setTranslateY(-(stackPane.getHeight() * 0.2));

        stackPane.getChildren().addAll(label, button);
        stackPane.setAlignment(Pos.CENTER_RIGHT);
        stackPane.setStyle("-fx-background-color: red");
        stackPane.setPadding(new javafx.geometry.Insets(20));

        Scene scene = new Scene(stackPane, 300, 200);

        primaryStage.setTitle("StackPane Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
