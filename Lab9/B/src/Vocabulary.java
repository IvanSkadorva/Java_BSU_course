import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

/**
 * This class holds distinct words in lexicographical order, provides methods to
 * add new words and print the content to a given html file.
 */
public class Vocabulary {
	private final TreeSet<Word> words;
	
	public Vocabulary() {
		words = new TreeSet<>();
	}

	public boolean addWord(Word word) {
		return words.add(word);
	}
	
	/**
	 * Prints the content of the vocabulary in lexicographical order to the
	 * html file. For each first letter in the word highlights the first word
	 * in the list with red color.
	 * @param filename the name of the html file to be created (including extension)
	 */
	public void printToHTML(String filename) {
		BufferedWriter out;

		try {
			out = new BufferedWriter(new FileWriter(filename));
			
			out.write("<html>");
			out.newLine();
			out.write("<body>");
			out.newLine();
			
			for (Word w : words) {
				out.write(w.getWord());
				out.write("<br/>");
				out.newLine();
			}
			out.write("</body>");
			out.newLine();
			out.write("</html>");
			out.newLine();
			
			out.close();
		} catch (IOException e) {
			System.out.println("Cannot write to the file " + filename);
		}
	}
}