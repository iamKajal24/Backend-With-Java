import java.io.File;

public class FileListMethodEx {

    public static void main(String[] args) {
        try {
            File file = new File("D:\\All jars");
            File[] files = file.listFiles();
            System.out.println("Files are :");

            if (files != null) {
                for (File f : files) {
                    System.out.println(f.getName());
                }
            } else {
                System.out.println("The directory is empty or does not exist.");
            }       
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred while listing files in the directory.");
        }
    }
}
