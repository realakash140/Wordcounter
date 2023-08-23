import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class wordcounter {

    public static void main(String[] args) {
        System.out.println("Welcome to Word Counter!");


        System.out.println("Enter '1' to input text directly, or '2' to provide a file path:");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
        String inputText;
        if (choice == 1) {
            System.out.println("Enter the text:");
            inputText = scanner.nextLine();
        } else if (choice == 2) {
            System.out.println("Enter the file path:");
            String filePath = scanner.nextLine();
            try {
                inputText = readFromFile(filePath);
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
                return;
            }
        } else {
            System.err.println("Invalid choice! Please enter either '1' or '2'.");
            return;
        }

        int wordCount = countWords(inputText);
        System.out.println("Word count: " + wordCount);
    }

    private static String readFromFile(String filePath) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        }
        return stringBuilder.toString();
    }

    private static int countWords(String text) {
        String[] words = splitIntoWords(text);
        int wordCount = 0;
        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount++;
            }
        }
        return wordCount;
    }

    private static String[] splitIntoWords(String text) {

        return text.split("[\\s\\p{Punct}]+");
    }
}
