import java.io.File;

public class GetAbsoutePath {

    public static void main(String[] args) {
        
        try{
            File file = new File("example.txt");
            String absolutePath = file.getAbsolutePath();
            System.out.println("file Original path : " + file.getPath());
            System.out.println("Absolute path: " + absolutePath);

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
