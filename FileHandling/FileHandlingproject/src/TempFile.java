import java.io.File;

public class TempFile {

    public static void main(String[] args) {
        try{

            File file = File.createTempFile("Hello",null);
            if(file.exists()){
                System.out.println("Temporary file created: " + file.getAbsolutePath());
                System.out.println("File name: " + file.getName());
            }
            else{
                System.out.println("Temporary file not created.");
            }
        }
        catch(Exception e){
            System.out.println("Error creating temporary file: " + e.getMessage());
        }
    }
    
}
