package fileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVFileReader implements ReadCSVFile {
    private String message;
    @Override
    public ArrayList<String[]> readFile(String args) {
        System.out.println(args.toCharArray());
        ArrayList<String[]> records = new ArrayList<String[]>();
        File csvFile = new File(args.toString());
        if(csvFile.isFile()) {
            try(BufferedReader csvReader = new BufferedReader(new FileReader(csvFile))) {
                String strrow;
                while ((strrow = csvReader.readLine()) != null) {
                    String[] data = strrow.split(";");
                    records.add(data);
                }
                message = "Succesfull read " + args.toString();
                return  records;
            } catch (IOException ex){
                message = "Can't open" + args.toString();
                ex.printStackTrace();
            }
        }
        else
            message = "Not file " + args.toString();
        return records;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
