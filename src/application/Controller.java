package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    TextArea areaText;

    @FXML
    TextField topicText;

    @FXML
    TextField serachText;

    @FXML
    Button save;

    @FXML
    Button delete;

    @FXML
    ListView<String> view;

    @FXML
    ComboBox<String> sortBox;

    @FXML
    Label status;


    private WriteFile writer;
    private ReaderFile reader;

    @FXML
    public void initialize(){
        reader = ReaderFile.getInstance();
        view.getItems().addAll(reader.getFileName());

        sortBox.getItems().addAll("Sort by Name","Sort by Last Modified","Sort by Size");
        sortBox.setValue("Sort by Last Modified");
        status.setText("waiting");
    }

    public void handelSave(ActionEvent e){
        writer = WriteFile.getInstance();
        writer.writeToFile(areaText.getText(),topicText.getText());
        view.getItems().clear();
        view.getItems().addAll(reader.getFileName());

        status.setText("save file");
    }

    public void handelDelete(ActionEvent e){
        DeleteFile d = new DeleteFile();
        d.deleteSelectFile(topicText.getText());

        view.getItems().clear();
        view.getItems().addAll(reader.getFileName());

        status.setText("delete file");


    }

    public void handelSelectFile(MouseEvent e){
        status.setText("select file");
        String topic = view.getSelectionModel().getSelectedItem();
        reader.readerFile(topic);
        topicText.setText(topic);
        areaText.setText(reader.getContain());
        reader.clear();
    }

    public void handelSort(ActionEvent e){
        status.setText("sorting");
        switch (sortBox.getSelectionModel().getSelectedItem()) {
            case "Sort by Name":
                reader.setSortByName();
                break;
            case "Sort by Last Modified":
                reader.setSortByLastModified();
                break;
            case "Sort by Size":
                reader.setSortBySize();
                break;
        }
        view.getItems().clear();
        view.getItems().addAll(reader.getFileName());
    }

    public void handelSearch(KeyEvent e){
        status.setText("search file");
        List<String> name = new ArrayList<>();
        for(String x : reader.getListName()){
            if(x.contains(serachText.getText())){
                name.add(x);
            }
        }
        view.getItems().clear();
        view.getItems().addAll(name);
    }

    public void handelType(KeyEvent e){
        status.setText("typing");

    }
}
