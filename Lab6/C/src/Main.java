import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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

    public static ArrayList<String> readFromFile(String filePath, int lastLines, int lastWords) {
        ArrayList<String[]> allLines = new ArrayList<>();
        ArrayList<String> output = new ArrayList<>();

        try {
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            String[] wordsInLine;

            String s;
            if (file.length() == 0) {
                System.out.println("File is empty ...");
                throw new RuntimeException("cannot take in an empty String or null value for the constructor");
            }
            while (sc.hasNextLine()) {
                s = sc.nextLine();
                wordsInLine = s.split(" ");
                allLines.add(wordsInLine);
            }
            int listLength = allLines.size();
            if (lastLines > listLength) {
                throw new IllegalStateException("Out of bonds");
            } else {
                String[][] stringAllLines = allLines.toArray(new String[0][0]);
                for (int i = (listLength - lastLines); i < listLength; i++) {
                    int lineLength = stringAllLines[i].length;
                    if(lineLength > 1){
                        for (int j = (lineLength - lastWords); j < lineLength; j++) {
                            output.add(stringAllLines[i][j]);
                        }
                    }

                }
            }
        } catch (OutOfMemoryError | IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return output;
    }


    public static void main(String[] args) {
        ArrayList<String> result = readFromFile("input.txt", 3, 2);
        System.out.println(result);
    }
}
