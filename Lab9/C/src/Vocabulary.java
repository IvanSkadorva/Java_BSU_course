import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

public class Vocabulary {
	private final TreeSet<Word> words;
	
	public Vocabulary() {
		words = new TreeSet<>();
	}

	public boolean addWord(Word word) {
		return words.add(word);
	}

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
				out.write(" ");
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