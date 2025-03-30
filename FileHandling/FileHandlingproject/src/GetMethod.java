import java.io.File;

public class GetMethod {

    public static void main(String[] args) {
        
        try {
            File file = new File("D:\\All jars");
            String name = file.getName();
             
            System.out.println("File name: " + name);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred while listing files in the directory.");
        } 
    }
    
}
