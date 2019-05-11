package application;

import javafx.concurrent.Task;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderFile {

    private final String PATH = "./src/data/";
    private static ReaderFile instance;
    private String contain;

    public static synchronized ReaderFile getInstance(){
        if(instance == null)
            instance = new ReaderFile();
        return instance;
    }

    public List<String> getFileName(){
        File folder = new File(PATH);
        File[] listOfFiles = folder.listFiles();
        List<String> listName = new ArrayList<>();
        for(File f : listOfFiles){
            listName.add(f.getName());
        }
        return listName;
    }

    public void reader(String fileName){

        try (FileReader reader = new FileReader(PATH+fileName);
             BufferedReader br = new BufferedReader(reader)) {

            // read line by line
            String line;
            while ((line = br.readLine()) != null) {
                contain += line;
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public void clear(){
        contain = "";
    }

    public String getContain(){
        return contain;
    }

}
