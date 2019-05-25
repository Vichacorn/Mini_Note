package application;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderFile {

    private final String PATH = "./src/data/";
    private static ReaderFile instance;
    private List<String> listName;
    private String contain;
    private Sort sort;

    public static synchronized ReaderFile getInstance(){
        if(instance == null) {
            instance = new ReaderFile();
        }
        return instance;
    }

    public ReaderFile(){
        contain = "";
        sort = new SortByLastModified();
    }

    public List<String> getFileName(){
        File folder = new File(PATH);
        folder.mkdir();
        File[] listOfFiles = folder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File file, String filename) {
                return filename.endsWith(".txt");
            }
        });

        listName = new ArrayList<>();
        sort.sortFile(listOfFiles);
        for(File f : listOfFiles){
            listName.add(f.getName().substring(0,f.getName().length()-4));
        }
        return listName;
    }

    public void readerFile(String fileName){

        try (FileReader reader = new FileReader(PATH+fileName+".txt");
             BufferedReader br = new BufferedReader(reader)) {

            // read line by line
            int line;
            while ((line = br.read()) != -1) {
                contain += (char)line;
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public void setSortBySize(){
        this.sort = new SortBySize();
    }

    public void setSortByLastModified(){
        this.sort = new SortByLastModified();
    }

    public void setSortByName(){
        this.sort = new SortByName();
    }

    public void clear(){
        contain = "";
    }

    public String getContain(){
        return contain;
    }

    public List<String> getListName(){
        return listName;
    }

}
