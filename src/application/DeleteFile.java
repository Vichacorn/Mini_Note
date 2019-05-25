package application;

import java.io.File;
public class DeleteFile {
    private static DeleteFile instance ;
    private final String PATH = "./src/data/";

    public static DeleteFile getInstance() {
        if(instance == null)
            instance = new DeleteFile();
        return instance;
    }

    public void deleteSelectFile(String name){
        File file = new File(PATH+name+".txt");
        file.delete();
    }

}
