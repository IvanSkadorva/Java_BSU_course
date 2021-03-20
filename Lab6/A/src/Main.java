import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public void findWordsStartingWithVowels(String[] arr) {
        String str;
        for (String s : arr) {
            str = n(s);
            System.out.println("Result of n(" + s + "): '" + str + "'");
        }
    }

    static char[] vowels = "aeiou".toCharArray();

    static String n(String s) {
        StringBuilder sb = new StringBuilder();
        boolean start = true, word = false;
        char[] stringChars = s.toCharArray();
        char c;
        for (int i = 0; i <= stringChars.length; i++) {

            c = i < stringChars.length ? Character.toLowerCase(stringChars[i]) : ' ';
            if (Character.isWhitespace(c)) {
                if (word) {
                    sb.append(' ');
                    word = false;
                }
                start = true;
            } else if (start) {
                start = false;
                for (char ch : vowels) {
                    if (c == ch) {
                        word = true;
                        break;
                    }
                }
            }
            if (word) {
                sb.append(stringChars[i]);
            }
        }
        return sb.toString().trim();
    }

    public static ArrayList<String> readFromFile(String filePath) {
        ArrayList<String> wordsStartingWithVowels = new ArrayList<>();

        try {
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            String[] words;
            String s;
            if (file.length() == 0) {
                System.out.println("File is empty ...");
                throw new RuntimeException("cannot take in an empty String or null value for the constructor");
            }
            while (sc.hasNext()) {
                s = sc.next();
                words = s.split(" ");
                for (String word : words) {

                    char ch = word.charAt(0);
                    if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                        wordsStartingWithVowels.add(word);
                    }
                }
            }
        } catch (OutOfMemoryError | IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return wordsStartingWithVowels;
    }


    public static void main(String[] args) {
        ArrayList<String> result = readFromFile("input.txt");
        System.out.println(result);
    }
}
