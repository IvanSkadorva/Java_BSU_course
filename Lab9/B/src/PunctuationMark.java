
public class PunctuationMark extends Symbol implements SentenceObject {
	private boolean endOfSentence;

	private PunctuationMark(char symbol) {
		super(symbol);
		
		if (symbol == '.' || symbol == '?' || symbol == '!') {
			endOfSentence = true;
		}
	}

 	public static boolean isPunctuation(char symbol) {
		return (symbol < 'a' || symbol > 'z') && (symbol < 'A' || symbol > 'Z') &&
				symbol != '\'';
 	}

 	public static PunctuationMark create(char symbol) {
 		if (isPunctuation(symbol)) {
 			return new PunctuationMark(symbol);
 		} else {
 			return null;
 		}
 	}

 	public boolean isEndOfSentence() {
 		return endOfSentence;
 	}
}