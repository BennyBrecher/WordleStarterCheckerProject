import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        cleanWordList();
    }

    public static void cleanWordList() {
        String inputFileName = "src/PastWordles.txt";
        String outputFileName = "src/CleanWordList.txt";
        try (Scanner fileScanner = new Scanner(new FileReader(inputFileName));
             PrintWriter writer = new PrintWriter(outputFileName)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(" #"); // Assumes that the word and number are separated by a space.
                writer.println(parts[0]); // Write only the word part to the new file.
            }
            System.out.println("Word list cleaned and written to " + outputFileName);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}