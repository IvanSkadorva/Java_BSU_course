import java.io.*;
import java.util.*;

public class Main {
    private static int maxStringLength;
    private static Map<String, String[]> dict = new Hashtable<>();

    public static String[] searchWord(String word) {
        for (int i = 0; i < dict.size(); i++) {
            if (dict.containsKey(word)) {
                return dict.get(word);
            }
        }
        return null;
    }
    public static boolean doesContain(String word) {
        return dict.containsKey(word);
    }

    public static String[] readFile() throws FileNotFoundException {
        int currentLength = 0;
        List<String> lines = new ArrayList<>();
        StringBuilder currentLine = new StringBuilder();
        String[] syllables = new String[2];
        Scanner sc2 = null;
        try {
            sc2 = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (true) {
            assert sc2 != null;
            if (!sc2.hasNextLine()) break;
            Scanner s2 = new Scanner(sc2.nextLine());
            while (s2.hasNext()) {
                String s = s2.next();
                currentLength += s.length();
                if (currentLength > maxStringLength) {
                    if(doesContain(s)){
                        syllables = searchWord(s);
                        currentLine.append(' ');
                        currentLine.append(syllables[0]);
                        lines.add(currentLine.toString());
                        currentLine = new StringBuilder(syllables[1]);
                    } else {
                        lines.add(currentLine.toString());
                        currentLine = new StringBuilder(s);
                    }
                    currentLength = 0;

                } else {
                    currentLine.append(' ');
                    currentLine.append(s);
                }
                System.out.println(s);
            }
        }
        return lines.toArray(new String[0]);
    }

    public static void writeFile(String[] lines) throws IOException {
        FileOutputStream fos = new FileOutputStream("out.txt");

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        for (String line : lines) {
            bw.write(line);
            bw.newLine();
        }

        bw.close();
    }

    public static void main(String[] args) throws IOException {
        dict.put("wonderful", new String[]{"won-", "-derful"});
        dict.put("amazing", new String[]{"a-", "-mazing"});
        dict.put("well", new String[]{"we-", "-ll"});
        dict.put("sweet", new String[]{"swe-", "-et"});
        dict.put("awesome", new String[]{"a-", "-wesome"});

        maxStringLength = 90;
        String[] lines = readFile();
        writeFile(lines);
    }
}
