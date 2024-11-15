package com.example;


import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 文本型、图片型普通按钮、开关按钮、开关按钮组
 */
//public class Main2 extends Application {
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage primaryStage) {
//        VBox vBox = new VBox(10);
//        // 文本型普通按钮
//        Button button = new Button("Button");
//        vBox.getChildren().add(button);
//        button.setOnAction(event -> {
//            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Click Button", ButtonType.FINISH);
//            alert.show();
//        });
//
//        // 文本型开关按钮
//        ToggleButton toggleButton = new ToggleButton("ToggleButton");
//        vBox.getChildren().add(toggleButton);
//        toggleButton.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
//            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Click ToggleButton", ButtonType.FINISH);
//            alert.show();
//        });
//
//        // 文本型开关按钮组合
//        ToggleGroup styleToggleGroup = new ToggleGroup();
//        Group group = new Group();
//        ToggleButton AToggleButton = new ToggleButton("ToggleButton 1 in ToggleGroup");
//        AToggleButton.setSelected(true);
//        AToggleButton.setTranslateX(0);
//        ToggleButton BToggleButton = new ToggleButton("ToggleButton 2 in ToggleGroup");
//        BToggleButton.setTranslateX(150);
//        ToggleButton CToggleButton = new ToggleButton("ToggleButton 3 in ToggleGroup");
//        CToggleButton.setTranslateX(300);
//        AToggleButton.setToggleGroup(styleToggleGroup);
//        BToggleButton.setToggleGroup(styleToggleGroup);
//        CToggleButton.setToggleGroup(styleToggleGroup);
//        AToggleButton.setLayoutX(0.0);
//        AToggleButton.setLayoutY(0.0);
//        BToggleButton.setLayoutX(50.0);
//        BToggleButton.setLayoutY(0.0);
//        CToggleButton.setLayoutX(100.0);
//        CToggleButton.setLayoutY(0.0);
//        group.getChildren().addAll(AToggleButton, BToggleButton, CToggleButton);
//        vBox.getChildren().addAll(group);
//
//        // 一个ImageView只能被一个控件绑定setGraphic，被多个绑定只能最后一个用
//        ImageView imageView1 = new ImageView(new Image("/image/auto1.png", 192, 168, true, true));
//        ImageView imageView2 = new ImageView(new Image("/image/auto2.png", 192, 168, true, true));
//
//        // 图片型普通按钮
//        Button button1 = new Button();
//        button1.setGraphic(imageView1);
//        vBox.getChildren().add(button1);
//
//        // 图片型开关按钮
//        ToggleButton toggleButton1 = new ToggleButton();
//        toggleButton1.setGraphic(imageView2);
//        vBox.getChildren().add(toggleButton1);
//
//        primaryStage.setScene(new Scene(vBox, 600, 400));
//        primaryStage.show();
//    }
//}

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 创建一个 ToggleButton
        ToggleButton toggleButton = new ToggleButton("●自动执行关闭");
        toggleButton.setStyle("-fx-text-fill: red;-fx-border-color: red");
        toggleButton.setSelected(false);

        // 创建一个 Label 来显示状态
        Label statusLabel = new Label("Switch is off");

        // 为 ToggleButton 添加事件处理器
        toggleButton.setOnAction(event -> {
            boolean isSelected = toggleButton.isSelected();
            if (isSelected) {
                toggleButton.setText("自动执行  ●");
                toggleButton.setStyle("-fx-text-fill: green;-fx-border-radius: 50;-fx-border-width: 1");
            } else {
                toggleButton.setText("●自动执行关闭");
                toggleButton.setStyle("-fx-text-fill: red;-fx-border-radius: 50;-fx-border-width: 1");
            }
            statusLabel.setText("Switch is " + (isSelected ? "on" : "off"));
        });

        // 创建布局并添加控件
        VBox root = new VBox(toggleButton, statusLabel);
        Scene scene = new Scene(root, 200, 100);

        primaryStage.setTitle("ToggleButton Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}