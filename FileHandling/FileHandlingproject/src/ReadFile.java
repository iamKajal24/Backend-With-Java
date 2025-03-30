import java.io.File;
import java.util.Scanner;

public class ReadFile {

    public static void main(String[] args) {
        
        try{
            File obj = new File("example.txt");
            Scanner Reader = new Scanner(obj);
            while(Reader.hasNextLine()){
                String data = Reader.nextLine();
                System.out.println(data);
            }
            Reader.close();
            System.out.println("File read successfully.");
        }
        catch(Exception e){
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
    
}
