import java.util.ArrayList;

public abstract class Player {
	protected String guess;
	protected String actualNumber;
	protected ArrayList<String> previousGuesses;
	protected ArrayList<Pair> previousResults;
	
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
	public void addToResults(Pair p) {
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
	
	public void setGuess(String g) {
		guess = g;
	}
	
	public void setActualNumber(String s) {
		actualNumber = s;
	}
	
	public ArrayList<String> getPreviousGuesses() {
		return previousGuesses;
	}
	
	public ArrayList<Pair> getPreviousResults() {
		return previousResults;
	}
}
