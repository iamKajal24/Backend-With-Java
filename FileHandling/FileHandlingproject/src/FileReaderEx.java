import java.io.BufferedReader;
import java.io.FileReader;

public class FileReaderEx {

    public static void main(String[] args) {

        String filePath ="example.txt";
        
        try (FileReader reader = new FileReader(filePath)) {
            BufferedReader br = new BufferedReader(reader);
            String line;
            System.out.println("Reading file content");
            while ((line = br.readLine())!= null) {
                System.out.println(line);
            }
            System.out.println("File read successfully."); 
            
        } catch (Exception e) {
          e.printStackTrace();
        }
    }
    
}
