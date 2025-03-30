import java.io.File;
import java.io.PrintWriter;

public class PrintWriterEx {

    public static void main(String[] args) {
        String filePath ="example.txt";
        File file = new File(filePath);
        try (PrintWriter pw = new PrintWriter(file)) {
            pw.println("Hello, World!");
            pw.println("This is a test file.");
            pw.println("Goodbye, World!");
            System.out.println("File written successfully.");
            pw.close();
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }  
}
