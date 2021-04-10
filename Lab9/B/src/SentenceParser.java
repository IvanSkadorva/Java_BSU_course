import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class holds a text as a list of sentences, provides methods to read the
 * text and create a vocabulary of the words met in the text.
 */
public class SentenceParser {
    private static char startLetter;
    private static char endLetter;
    private final Vocabulary vocabulary;
    private final List<Sentence> text;

    public SentenceParser() {
        vocabulary = new Vocabulary();
        text = new ArrayList<>();
    }
    public static void setSearchTerm(char start, char end){
        startLetter = start;
        endLetter = end;
    }


    public void parse(Scanner scanner) {
        Sentence temp;
        while (scanner.hasNext()) {
            temp = new Sentence();
            temp.read(scanner);
            text.add(temp);
        }
    }

    public Vocabulary createVocabulary() {
        String matchedWord = "";
        for (Sentence s : text) {
            for (SentenceObject token : s) {
                if (token instanceof Word) {
                    Word word = (Word) token;
                    if (word.startsWith(startLetter) && word.endsWith(endLetter) && matchedWord.length() < word.getWord().length()) {
                        matchedWord = word.getWord();
                    }
                }
            }
            for (SentenceObject token : s) {
                if (token instanceof Word) {
                    Word word = (Word) token;
                    if (!word.getWord().equals(matchedWord)) {
                        vocabulary.addWord((Word) token);
                    }
                }
            }
            if(matchedWord.length() > 1)
                System.out.println("matched word is: " + matchedWord);

        }
        return vocabulary;
    }

    public Vocabulary getVocabulary() {
        return vocabulary;
    }


    public static void main(String[] args) {
        SentenceParser parser = new SentenceParser();

        try {
            parser.parse(new Scanner(new File("input.txt")));
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open the file input.txt");
        }
        setSearchTerm('c', 'l');
        parser.createVocabulary().printToHTML("output.html");
        System.out.println("Check the output in output.html");
    }
}

