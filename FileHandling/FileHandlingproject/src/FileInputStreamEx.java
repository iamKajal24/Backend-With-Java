import java.io.FileInputStream;

public class FileInputStreamEx {

    public static void main(String[] args) {
        String  filePath = "c:\\Users\\intel\\Downloads\\rose.jpeg";

        try{
            FileInputStream fis = new FileInputStream(filePath);
            int i;
            while((i = fis.read()) != -1){
                System.out.println("Byte : " + i);
            }
            fis.close();
            System.out.println("Image file read successfully.");
        }
        catch(Exception e){
            System.out.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
}
