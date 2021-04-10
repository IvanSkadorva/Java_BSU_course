import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word implements Comparable<Word>, SentenceObject {
	private String word;
	
	public Word(String word) {
		this.word = word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public String getWord() {
		return word;
	}
	public String getSyllables() {
		StringBuilder result = new StringBuilder();
		Matcher m = Pattern.compile("(ng|ny|sy|kh|[^aeiou])?[aeiou]((ng|ny|sy|kh|([^aeiou](?![gyh]))(?![aeiou])))?",
				Pattern.CASE_INSENSITIVE).matcher(word);
		int s = 0;
		while (m.find()) {
			 result.append('-').append(word.substring(s, m.end()).trim());
			s = m.end();
		}
		return result.toString();
	}


	@Override
	public int compareTo(Word anotherWord) {
		return word.compareToIgnoreCase(anotherWord.getWord());
	}

	public boolean startsWith(char letter) {
		return word.startsWith(String.valueOf(letter));
	}
	public boolean endsWith(char letter) {
		return word.endsWith(String.valueOf(letter));
	}
}