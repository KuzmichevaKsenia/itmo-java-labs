import java.io.*;
import java.util.Arrays;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.APPEND;

public class OsiSort {
    public static String sort(String lineToSort) {
        String[] lines = lineToSort.split("\n");
        Arrays.sort(lines);
        lineToSort = "";
        for (String i : lines) lineToSort += i + "\n";
        return lineToSort;
    }

    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + "/src/";
        String line;
        String lineToSort = "";

        try {
            FileInputStream in = new FileInputStream(path + "osi.txt");
            FileOutputStream out = new FileOutputStream(path + "osiReverso.txt");
            int c;
            while ((c = in.read()) != -1) {
                lineToSort += (char) c;
            }
            line = "File sorted and copied with FileInputStream-FileOutputStream:\n";
            line += sort(lineToSort);
            byte[] bytesToWrite = line.getBytes();
            out.write(bytesToWrite);
        } catch (IOException e) {
            System.out.println("Exception caught:");
            e.printStackTrace();
        }

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path + "osi.txt"), Charset.defaultCharset()))
        {
            line = null;
            lineToSort = "";
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(path + "osiReverso.txt"), Charset.defaultCharset(), APPEND)) {
                while ((line = reader.readLine()) != null) {
                    lineToSort += line + "\n";
                }
                line = "File sorted and copied with BufferedReader:\n";
                line += sort(lineToSort);
                writer.write(line);
            } catch (IOException e) {
                System.out.println("Exception caught (write):");
                System.err.format("IOException: %s%n", e);
            }
        }
        catch (IOException e) {
            System.out.println("Exception caught:");
            e.printStackTrace();
        }
    }
}
