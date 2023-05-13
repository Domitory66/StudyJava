package journal;
import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;  // Import the IOException class to handle errors
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Journal {
    private DateFormat dateFormat;
    private String name = "log.txt";
    private File file;
    private void createFile(String name)
    {
        try {
            this.file = new File("./" + name);
            dateFormat = new SimpleDateFormat("yyyy:MM:dd:hh:mm:ss");
            if (this.file.createNewFile()) {
                System.out.println("File created: " + this.file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
   public Journal()
    {
        this.createFile(this.name);
    }

   public void  write(String message)
           throws IOException {
       FileWriter fw = new FileWriter(this.file, true);
       BufferedWriter bw = new BufferedWriter(fw);
       bw.write(dateFormat.format(new Date())+ " " + message);
       bw.newLine();
       bw.close();
   }
}
