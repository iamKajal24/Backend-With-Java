import java.io.File;

public class CreateFile {

    public static void main(String[] args) {
        
        // Create a file named "example.txt" in the current directory
        String fileName = "Demo.txt";
       try{
            File file = new File(fileName);
            if(file.createNewFile()){
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
       }
        catch(Exception e){
            System.out.println("An error occurred while creating the file: " + e.getMessage());
        }
        
    }
    
}
