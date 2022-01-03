package com.example.newdatabaseexample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TableColumn<Person, Integer> ageColumn;

    @FXML
    private TextField ageTextBox;

    @FXML
    private TableColumn<Person, String> firstNameColumn;

    @FXML
    private TextField firstNameTextBox;

    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private TextField lastNameTextBox;

    @FXML
    private TableView<Person> tableView;

    ObservableList<Person> People = FXCollections.observableArrayList(
            new Person("Ian", "Malloy", 50),
            new Person("Doug", "Malloy", 27)
    );


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        tableView.setItems(People);
    }

    @FXML
    void add(ActionEvent event) {

    }

}
