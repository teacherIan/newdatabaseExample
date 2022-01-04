package com.example.newdatabaseexample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Label errorMessage;

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

    );


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        tableView.setItems(People);
    }

    @FXML
    void add() {

        String firstName = firstNameTextBox.getText();
        String lastName = lastNameTextBox.getText();

        try {
            int age = Integer.parseInt(ageTextBox.getText());
            addToDatabase(firstName,lastName,age);
        } catch (NumberFormatException e) {
            errorMessage.setOpacity(1);
        }

    }

    public void addToDatabase(String firstName, String lastName, int age) {
        People.add(new Person(firstName,lastName,age));
        tableView.setItems(People);
        errorMessage.setOpacity(0);
        firstNameTextBox.setText("");
        lastNameTextBox.setText("");
        ageTextBox.setText("");
    }
}
