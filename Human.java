
public class Human extends Player {
	private static Human instance;

	/*
	 * Class constructor
	 * Assign actualNumber to the value that human set for the computer to guess.
	 */
	private Human(String actualNum) {
		this.actualNumber = actualNum;
	}
	
	/* 
	 * Creates and returns instance if it doesn't already exist, and returns instance otherwise.
	 */
	public static Human getInstance(String actualNum) {
		if (instance == null) {
			instance = new Human(actualNum);
		}
		return instance;
	}

	/*
	 * Delegate the printing of instructions and retrieving input to Client
	 */
	String makeGuess() {
		guess = Client.getGuess();
		return guess;
	}
	
	
	
}
