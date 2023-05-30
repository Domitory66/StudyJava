package csvHandler;

import dao.MonitorDao;
import dao.ProductCategoryDao;
import dao.TelevisionDao;
import domain.Monitor;
import domain.ProductCategory;
import domain.Television;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvHandler {

    public static List<String[]> readCsvFile(String fileName, String regex) {
        List<String[]> strings = new ArrayList<>();
        File file = new File(fileName);
        try {
            InputStreamReader streamReader = new InputStreamReader(new FileInputStream(file), "windows-1251");
            BufferedReader bufferedReader = new BufferedReader(streamReader);
            String fileLine;
            while ((fileLine = bufferedReader.readLine()) != null) {
                String[] splitString = fileLine.split(regex);
                strings.add(splitString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }

    public List<String[]> inputStrings;

    public CsvHandler() {
    }

    private final MonitorDao monitorDao = new MonitorDao();
    private final ProductCategoryDao productCategoryDao = new ProductCategoryDao();
    private final TelevisionDao televisionDao = new TelevisionDao();

    public CsvHandler(String fileName) {
        this.inputStrings = CsvHandler.readCsvFile(fileName, ";");
    }

    public void GetDataFromCsvFile() {
        for (String[] line : inputStrings) {
            switch (line[0]) {
                case "1" -> monitorDao.save(new Monitor(line));
                case "0" -> televisionDao.save(new Television(line));
                default -> productCategoryDao.save(new ProductCategory(line));
            }
        }
    }
}
