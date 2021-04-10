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