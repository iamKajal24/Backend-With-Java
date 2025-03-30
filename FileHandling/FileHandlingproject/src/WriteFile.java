import java.io.FileWriter;
import java.io.IOException;
public class WriteFile {

    public static void main(String[] args) {
        
        try{
            FileWriter fw = new FileWriter("example.txt");
            fw.write("Hello, this is a test file");
            fw.close();
            System.out.println("File created successfully");
        }
        catch(IOException e){
            System.out.println("Error in creating file");
            e.printStackTrace();
        }
    }
    
}
