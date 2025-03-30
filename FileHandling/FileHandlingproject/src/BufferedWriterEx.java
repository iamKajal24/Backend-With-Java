import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class BufferedWriterEx {

    public static void main(String[] args) {
        String filePath ="example.txt";
        File file = new File(filePath);  
       
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            writer.write("Hello, this is a test file");
            writer.newLine(); // Add a new line
            writer.write("This is the second line of the file");
            writer.close();
            System.out.println("File created successfully");
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("File occurred: " + e.getMessage());
        }
    }
    
}
