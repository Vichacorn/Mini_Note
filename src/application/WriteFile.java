package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;

public class WriteFile {

    private static WriteFile instance ;

    public static WriteFile getInstance() {
        if(instance == null)
            instance = new WriteFile();
        return instance;
    }

    public void writeToFile(String text, String topic){
        BufferedWriter bw = null;
        if(topic.isEmpty()){
            topic = ""+currentDate();
        }
        File file = new File("./src/data/"+topic+".txt");

        try {
            if (!file.exists())
                file.createNewFile();

            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write(text);
            bw.close();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public String currentDate(){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
