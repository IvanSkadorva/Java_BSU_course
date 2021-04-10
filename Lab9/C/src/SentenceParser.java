import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SentenceParser {
    private static int maxStringLength;
    private final Vocabulary vocabulary;
    private final List<Sentence> text;

    public SentenceParser() {
        vocabulary = new Vocabulary();
        text = new ArrayList<>();
    }

    public static void setMaxStringLength(int length) {
        maxStringLength = length;
    }


    public void parse(Scanner scanner) {
        Sentence temp;
        while (scanner.hasNext()) {
            temp = new Sentence();
            temp.readUntil(maxStringLength, scanner);
            text.add(temp);
        }
    }

    public Vocabulary createVocabulary() {
        int currentLength = 0;
        for (Sentence s : text) {
            for (SentenceObject token : s) {
                System.out.println(token);

                if (token instanceof Word) {
                    vocabulary.addWord((Word) token);
                }
            }
        }
        return vocabulary;
    }

    public Vocabulary getVocabulary() {
        return vocabulary;
    }


    public static void main(String[] args) {
        SentenceParser parser = new SentenceParser();
        setMaxStringLength(90);

        try {
            parser.parse(new Scanner(new File("input.txt")));
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open the file input.txt");
        }
        parser.createVocabulary().printToHTML("output.html");
        System.out.println("Check the output in output.html");
    }
}

