package application;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class SortByName implements Sort {

    @Override
    public void sortFile(File[] files) {
        Arrays.sort(files, new Comparator<File>() {
            @Override
            public int compare(File f1, File f2) {
                return f1.getName().compareTo(f2.getName());
            }

        });
    }
}
