package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableCell;
import javafx.scene.control.TablePosition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Main4 extends Application {

    @Override
    public void start(Stage primaryStage) {
        TableView<Person> table = new TableView<>();
        TableColumn<Person, String> nameCol = new TableColumn<>("Name");
        TableColumn<Person, Integer> ageCol = new TableColumn<>("Age");
        TableColumn<Person, String> emailCol = new TableColumn<>("Email");

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        table.getColumns().addAll(nameCol, ageCol, emailCol);


        // 添加示例数据
        ObservableList<Person> data = FXCollections.observableArrayList(
                new Person("Jacob", 23, "jacob@example.com"),
                new Person("Isabella", 22, "isabella@example.com"),
                new Person("Ethan", 24, "ethan@example.com"),
                new Person("Emma", 23, "emma@example.com")
        );
        table.setItems(data);

        // 监听选中行的变化，并更新特定列的样式
        table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Person>() {
            @Override
            public void changed(ObservableValue<? extends Person> observable, Person oldValue, Person newValue) {
                if (newValue != null) {
                    int selectedIndex = table.getSelectionModel().getSelectedIndex();
                    for (TableColumn<Person, ?> column : table.getColumns()) {
//                        for (TableCell<Person, ?> cell : column.getCells()) {
//                            if (cell.getRow() == selectedIndex) {
//                                if (column == nameCol || column == emailCol) {
//                                    cell.setStyle("-fx-background-color: #A9E4E9;");
//                                } else {
//                                    cell.setStyle("");
//                                }
//                            }
//                        }

                        System.out.println("111");
                    }
                }
            }
        });

        VBox vbox = new VBox(table);
        Scene scene = new Scene(vbox, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Table View Highlight Selected Row Columns");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static class Person {
        private String name;
        private Integer age;
        private String email;

        public Person(String name, Integer age, String email) {
            this.name = name;
            this.age = age;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public String getEmail() {
            return email;
        }
    }
}
