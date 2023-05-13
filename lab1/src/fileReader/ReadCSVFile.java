package fileReader;

import java.util.ArrayList;

public interface ReadCSVFile {
    ArrayList<String[]> readFile(String args);

    default String getMessage() {
        return null;
    }
}
