package application;

import java.io.File;

import java.util.Arrays;
import java.util.Comparator;

public class SortBySize implements Sort {

    @Override
    public void sortFile(File[] files) {

        Arrays.sort(files, new Comparator<File>() {
            @Override
            public int compare(File f1, File f2) {
                return new Long(f2.length()).compareTo(new Long(f1.length()));
            }

        });
    }


}
