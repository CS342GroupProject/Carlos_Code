import java.util.ArrayList;

public abstract class Player {
	protected String guess;
	protected String mySecret;
	protected ArrayList<String> previousGuesses;
	protected ArrayList<Result> previousResults;
	
	 /*
	  * Human and Computer implement differently 
	  * Human should be asked for input
	  * Computer chooses a number based on AI
	  * In both cases, append to previousGuesses
	  */
	abstract String makeGuess();
	
	/* 
	 * Adds to our array list of pair values, representing previous results
	 */
	public void addToResults(Result p) {
		previousResults.add(p);
	}
	
	/* 
	 * Adds to our array list of string values, representing previous guesses
	 */
	public void addToGuesses(String s) {
		previousGuesses.add(s);
	}
	
	
	/*
	 * Setters and getters for most fields
	 */
	
	public String getMySecret() {
		return mySecret;
	}
	
	public ArrayList<String> getPreviousGuesses() {
		return previousGuesses;
	}
	
	public ArrayList<Result> getPreviousResults() {
		return previousResults;
	}
	
	// method that will evaluate a pair of numbers as indicated above and return
		// a pair
	public Result evaluate(String guess, String answer) {

		/*
		 * pair that will be returned with correct number of digits in the right
		 * place along with the correct number of digits but in the wrong place
		 */
		Result retPair = new Result();
		// array the will hold the player's guess
		char[] guessArr = guess.toCharArray();
		// array that will hold the answer that player is attempting to guess
		char[] answerArr = answer.toCharArray();

		// first check to see which digits are in the correct place
		if (guessArr[0] == answerArr[0]) {
			retPair.incrementCorrecPlaces();
		}
		if (guessArr[1] == answerArr[1]) {
			retPair.incrementCorrecPlaces();
		}
		if (guessArr[2] == answerArr[2]) {
			retPair.incrementCorrecPlaces();
		}
		if (guessArr[3] == answerArr[3]) {
			retPair.incrementCorrecPlaces();
		}

		// then check which ones are correct but in the wrong place
		if (guessArr[0] == answerArr[1] || guessArr[0] == answerArr[2]
				|| guessArr[0] == answerArr[3]) {
			retPair.incrementWrongPlaces();
		}
		if (guessArr[1] == answerArr[0] || guessArr[1] == answerArr[2]
				|| guessArr[1] == answerArr[3]) {
			retPair.incrementWrongPlaces();
		}
		if (guessArr[2] == answerArr[0] || guessArr[2] == answerArr[1]
				|| guessArr[2] == answerArr[3]) {
			retPair.incrementWrongPlaces();
		}
		if (guessArr[3] == answerArr[0] || guessArr[3] == answerArr[1]
				|| guessArr[3] == answerArr[2]) {
			retPair.incrementWrongPlaces();
		}

		// return the pair of numbers in the form (# of correct digits in right
		// place, # of right digits in wrong place)
		return retPair;

	}// end of evaluate(...)

}
