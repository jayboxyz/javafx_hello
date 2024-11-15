package com.example;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class Main3 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 创建数据
        ObservableList<Person> data = FXCollections.observableArrayList(
                new Person("John", "Doe"),
                new Person("Jane", "Smith"),
                new Person("Mike", "Johnson")
        );

        // 创建TableView
        TableView<Person> tableView = new TableView<>(data);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        // 创建列
        TableColumn<Person, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        firstNameCol.setCellFactory(createStyledCellFactory());

        TableColumn<Person, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        // 假设我们只为FirstName列添加样式

        // 将列添加到TableView
        tableView.getColumns().addAll(firstNameCol, lastNameCol);

        // 设置样式类（在CSS中定义）
        tableView.getStyleClass().add("my-table-view");

        // 创建场景和舞台
        StackPane root = new StackPane();
        root.getChildren().add(tableView);
        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("TableView Row Selection Style Example");
        primaryStage.setScene(scene);
        primaryStage.show();

        // 这里通常不需要额外的代码来监听行选择并更新样式，
        // 因为自定义单元格工厂已经处理了这一点。
        // 但是，如果你需要在其他地方响应行选择的变化，
        // 你可以使用tableView.getSelectionModel().selectedItemProperty().addListener(...)来监听。

        tableView.setRowFactory(tv -> {
            TableRow row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1 && (!row.isEmpty())) {
                    Object item = row.getItem();

                    System.out.println("111" + item);
                }
            });

            return row;
        });
    }

    private Callback<TableColumn<Person, String>, TableCell<Person, String>> createStyledCellFactory() {
        return col -> new TableCell<Person, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setStyle(""); // 清除样式
                } else {
                    setText(item);
                    // 检查当前行是否被选中
                    if (getTableView().getSelectionModel().getSelectedIndex() == getIndex()) {
                        setStyle("-fx-background-color: lightblue;"); // 应用样式
                    } else {
                        setStyle(""); // 清除样式（如果需要的话）
                    }
                }
            }
        };
    }

    // Person类（包含firstName和lastName属性）
    public static class Person {
        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;

        public Person(String firstName, String lastName) {
            this.firstName = new SimpleStringProperty(firstName);
            this.lastName = new SimpleStringProperty(lastName);
        }

        public SimpleStringProperty firstNameProperty() {
            return firstName;
        }

        public SimpleStringProperty lastNameProperty() {
            return lastName;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}