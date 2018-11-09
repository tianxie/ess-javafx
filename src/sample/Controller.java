package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

import java.io.File;

public class Controller {

    @FXML
    private TextField selectedFile;

    @FXML
    private TextArea textArea;

    @FXML
    private TextField url;

    @FXML
    GridPane pane;

    @FXML
    ComboBox httpMethod;

    public void sendRequest(ActionEvent actionEvent) {
        if (url.getText().isEmpty()) {
            textArea.setText("shit");
        } else if (("PUT".equals(httpMethod.getSelectionModel().getSelectedItem())) && selectedFile.getText().isEmpty()) {
            textArea.setText("Please select a file");
        }
    }

    public void openFileChooser(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        fileChooser.getExtensionFilters().addAll(
//                new ExtensionFilter("Text Files", "*.txt"),
//                new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
//                new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                new ExtensionFilter("All Files", "*.*"));

        File file = fileChooser.showOpenDialog(pane.getScene().getWindow());
        if (file != null) {
            selectedFile.setText(file.getAbsolutePath());
        }
    }
}
