import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        File sourceFile = new File("E:\\los1\\uechebnoe\\итип\\projects\\Lab_5\\src\\source.txt");
        File destFile = new File("E:\\los1\\uechebnoe\\итип\\projects\\Lab_5\\src\\destination.txt");

        try (FileReader fileReader = new FileReader(sourceFile);
             FileWriter fileWriter = new FileWriter(destFile)) {

            char[] buffer = new char[1024];
            int length;
            while ((length = fileReader.read(buffer)) > 0) {
                fileWriter.write(buffer, 0, length);
            }

            System.out.println("File copied successfully!");

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error copying file: " + e.getMessage());
        }
    }
}
