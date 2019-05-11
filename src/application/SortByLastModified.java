package application;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Comparator;

public class SortByLastModified implements Sort {

    @Override
    public void sortFile(File[] files) {
        Arrays.sort(files, new Comparator<File>() {
            @Override
            public int compare(File f1, File f2) {
                try {
                    BasicFileAttributes attr1 = Files.readAttributes(f1.toPath(), BasicFileAttributes.class);
                    BasicFileAttributes attr2 = Files.readAttributes(f2.toPath(), BasicFileAttributes.class);
                    return attr2.lastModifiedTime().compareTo(attr1.lastModifiedTime());
                }
                catch (IOException ioe){
                    ioe.printStackTrace();
                }
                return 0;
            }

        });
    }
}
