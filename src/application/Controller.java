package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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
        view.getItems().clear();
        view.getItems().addAll(reader.getFileName());
    }

    @FXML
    public void handelSelectTopic(MouseEvent e){
        //reader.reader(view.getSelectionModel().getSelectedItem());
        reader.reader(view.getSelectionModel().getSelectedItem());
        areaText.setText(reader.getContain());
        reader.clear();
        System.out.println();
    }



}
