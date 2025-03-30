import java.io.File;

public class DeleteFile {

    public static void main(String[] args) {
        
        try {
            File obj = new File("demo.txt");
            if(obj.delete()){
                System.out.println("File deleted successfully");
            }
            else{
                System.out.println("Failed to delete the file");
            }
            
        } catch (Exception e) {
           e.printStackTrace();
            System.out.println("An error occurred while deleting the file: " + e.getMessage());
        
        }
        
    }
    
}
