package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    ObservableList<Task> list;

    @FXML
    private TextField titleTextField;

    @FXML
    private Label alertLabel;
    @FXML
    DatePicker datePicker;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private TableColumn titleCol,dateCol,descriptionCol,priorityCol,statusCol;

    @FXML
    private TableView table;

    @FXML
    private ComboBox priorityComboBox,statusComboBox;




    @FXML
    private void closeAction(ActionEvent event){
        Platform.exit();
    }

    @FXML
    private void resetButton(ActionEvent event){
        titleTextField.setText("");
        descriptionTextArea.setText("");
        datePicker.setValue(null);
        priorityComboBox.getSelectionModel().select(-1);
        statusComboBox.getSelectionModel().select(-1);
    }

    @FXML
    private void addAction(ActionEvent event){
        if(!titleTextField.getText().isEmpty()){
            Task task = new Task();
            task.setTitle(titleTextField.getText());
            task.setDescription(descriptionTextArea.getText());
            task.setDate(datePicker.getValue().toString());
            task.setPriority(priorityComboBox.getSelectionModel().getSelectedItem().toString());
            task.setStatus(statusComboBox.getSelectionModel().getSelectedItem().toString());
            list.add(task);
            alertLabel.setText("");
            //Remove the Existing Data After press Add Button
            titleTextField.setText("");
            descriptionTextArea.setText("");
            datePicker.setValue(null);
            priorityComboBox.getSelectionModel().select(-1);
            statusComboBox.getSelectionModel().select(-1);
        }
        else{
            alertLabel.setText("Title Required !");
            alertLabel.setTextFill(Color.RED);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        list = FXCollections.observableArrayList();
        datePicker.setValue(LocalDate.now());
        priorityComboBox.setItems(FXCollections.observableArrayList("Urgent","High","Low"));
        priorityComboBox.getSelectionModel().select(0);
        statusComboBox.setItems(FXCollections.observableArrayList("New","In-Progress","Done"));
        statusComboBox.getSelectionModel().select(0);
        titleCol.setCellValueFactory(new PropertyValueFactory("title"));
        dateCol.setCellValueFactory(new PropertyValueFactory("date"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory("description"));
        priorityCol.setCellValueFactory(new PropertyValueFactory("priority"));
        statusCol.setCellValueFactory(new PropertyValueFactory("status"));
        table.setItems(list);
    }
}
