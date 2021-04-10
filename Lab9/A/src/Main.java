import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static ArrayList<String> splitBySentences(String text) {
        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
        ArrayList<String> splitTextBySentences = new ArrayList<>();
        iterator.setText(text);
        int start = iterator.first();
        for (int end = iterator.next();
             end != BreakIterator.DONE;
             start = end, end = iterator.next()) {
            splitTextBySentences.add(text.substring(start, end));
            System.out.println(text.substring(start, end));
        }
        return splitTextBySentences;
    }

    public static int countVowels(String sentence) {
        int count = 0;
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == ' ') {
                count++;
            }
        }
        return count;
    }

    public static int countConsonants(String sentence) {
        int count = 0;
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                System.out.print("");
            } else if (ch != ' ') {
                count++;
            }
        }
        return count;
    }

    public static void countVowelsAndConsonants(String[] text) {
        for (String sentence : text) {
            System.out.println("There are " + countVowels(sentence) + " vowels and " + countConsonants(sentence) + " consonants in the sentence ");
        }
    }
    public static String[] getStringArray(ArrayList<String> arr) {
        String str[] = new String[arr.size()];
        for (int j = 0; j < arr.size(); j++) {
            str[j] = arr.get(j);
        }
        return str;
    }

    public static void main(String[] args) {

        String textAboutText = "In academic terms, a text is anything that conveys a set of meanings to the " +
                "person who examines it. You might have thought that texts were limited to written materials," +
                " such as books, magazines, newspapers, and ‘zines (an informal term for magazine that refers " +
                "especially to fanzines and webzines). Those items are indeed texts—but so are movies, paintings," +
                " television shows, songs, political cartoons, online materials, advertisements, maps, works of art," +
                " and even rooms full of people. " +
                "If we can look at something, explore it, find layers of meaning in it," +
                " and draw information and conclusions from it, we’re looking at a text.";
        ArrayList<String> splitTextBySentences = splitBySentences(textAboutText);
        countVowelsAndConsonants(getStringArray(splitTextBySentences));

    }
}
