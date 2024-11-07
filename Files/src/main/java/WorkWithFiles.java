package main.java;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class WorkWithFiles {
    public static void main(String[] args) {
        String fileName = "/Users/eugene/Git-Repos/java-lessons-landfill/Files/src/main/resources/txt/file.txt";
        Path path = Path.of(fileName);
        File file = new File(fileName);

        try {
            if (!file.exists()) {
                writeWithFileWriter(fileName, "Hey,");

                writeWith_writeString(path, " are you scared?");

                writeWithBufferedWriter(fileName, " Don't be scared!");

                writeWithFileOutputStream(fileName, " I'm friend!");
            } else {
                writeWithFileWriter(fileName, "\nHey,");

                writeWith_writeString(path, " are you scared?");

                writeWithBufferedWriter(fileName, " Don't be scared!");

                writeWithFileOutputStream(fileName, " I'm friend!");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nReading File ...\n");

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName))) {
            int ch;
            while ((ch = bis.read()) != -1) {
                Thread.sleep(10);
                System.out.print((char) ch);
            }
        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for (int i = 0; i < 49; i++) {
            System.out.print("\b \b");

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String[] frames = { "|", "/", "-", "\\" };
        System.out.println("");
        for (int ctr = 0; ctr < 50; ctr++) {
            try {
                System.out.print(frames[ctr % frames.length]);
                Thread.sleep(250);
                System.out.print("\b");
            } catch (InterruptedException ex) {
            }
        }

    }

    // writig to the file with writeString()
    public static void writeWith_writeString(Path filePath, String text) throws IOException {
        Files.write(filePath, text.getBytes(), StandardOpenOption.APPEND);
        System.out.println("Text: " + text + " added to the file using writeString().");
    }

    // writing to the file with FileWriter
    public static void writeWithFileWriter(String fileName, String text) throws IOException {
        try (FileWriter fw = new FileWriter(fileName, true)) {
            fw.append(text);
        }
        System.out.println("Text: " + text + " added to the file using FileWriter.");
    }

    public static void writeWithBufferedWriter(String fileName, String text) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            bw.append(text);
        }
        System.out.println("Text: " + text + " added to the file using BufferedWriter.");
    }

    public static void writeWithFileOutputStream(String fileName, String text) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fileName, true)) {
            fos.write(text.getBytes());
        }
        System.out.println("Text: " + text + " added to the file using FileOutputStream.");
    }

}