import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //cleanWordList();
        HashSet<String> usedWords = new HashSet<>();
        try{
            Scanner fileScanner = new Scanner(new FileReader("src/CleanWordList.txt"));
            while(fileScanner.hasNext()){
                usedWords.add(fileScanner.nextLine().toUpperCase());
            }
        }catch(IOException e) {
            System.err.println("Error occurred while reading the file: " + e.getMessage());
            return;
        }
        Scanner userInput = new Scanner(System.in);
        System.out.print("What Is Your Starter Word? ");
        String starterWord = userInput.nextLine().toUpperCase();
        if(usedWords.contains(starterWord)){
            System.out.print("Sorry, It Appears That " + starterWord + " Has Already Been Used As A Wordle");
        }else{
            System.out.print("You're Good To Go, " + starterWord + " Has Not Yet Been Used As A Wordle");
        }
        userInput.close();
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