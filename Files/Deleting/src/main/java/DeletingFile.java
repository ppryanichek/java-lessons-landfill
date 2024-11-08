package main.java;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class DeletingFile {
    public static void main(String[] args) {
        String fileName = "/Users/eugene/Git-Repos/java-lessons-landfill/Files/Deleting/src/main/resources/txt/text.txt";
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Path path = Path.of(fileName);

        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write("Hey,skoobibibi!");

            if (Files.exists(path)) {
                System.out.println("Executable: " + Files.isExecutable(path) + "\nReadable: " + Files.isReadable(path)
                        + "\nWritable: " + Files.isWritable(path));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.print("Delete file? Y/n: ");
        try (Scanner scanner = new Scanner(System.in)) {
            String key = scanner.nextLine();
            if ("y".equals(key) || "Y".equals(key)) {
                try {
                    Files.deleteIfExists(path);
                    System.out.println("File has been deleted");
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("File has not been deleted");
            }
        }
    }

}
