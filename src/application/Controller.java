package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    TextArea areaText;

    @FXML
    TextField topicText;

    @FXML
    Button save;

    @FXML
    ListView<String> view;

    private WriteFile writer;
    private ReaderFile reader;

    @FXML
    public void initialize(){
        reader = ReaderFile.getInstance();
        view.getItems().addAll(reader.getFileName());
    }

    public void handelSave(ActionEvent e){
        writer = WriteFile.getInstance();
        writer.writeToFile(areaText.getText(),topicText.getText());
        view.refresh();
    }

    public void handelSelectTopic(ActionEvent e){
        //reader.reader(view.getSelectionModel().getSelectedItem());
        reader.setFileName(view.getSelectionModel().getSelectedItem());
        areaText.setText(reader.getContain());
    }

}
