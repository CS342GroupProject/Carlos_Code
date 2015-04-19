
public class GameController {
	public int currentRound;
	public Human human;
	public Computer computer;
	private boolean humanTurn;
	private static GameController instance;
	
	/* Class constructor
	 * Let human go first and set currentRound = 1
	 * @param humanActualNumber - the number set by the human for the computer to guess
	 * @param difficulty - Difficulty of the computer, set by the human.
	 */
	private GameController(String humanActualNumber) {
		currentRound = 1;
		humanTurn = true;
		human = Human.getInstance(humanActualNumber);
		computer = Computer.getInstance();//difficulty);
	}
	
	/* 
	 * Creates and returns instance if it doesn't already exist, and returns instance otherwise.
	 */
	public static GameController getInstance(String humanActualNumber) {
		if (instance == null)
			instance = new GameController(humanActualNumber);
		return instance;
	}
	
	/* Decides whether it is the human's turn, or the computer's
	 * @return - Returns an array in the format: 
	 * 			[currentRound, numberCorrentInCorrectPosition, numberCorrectInWrongPosition]
	 * Note: If either player guesses the correct number, -1 is returned in the first index of the array returned.
	 */
	public int[] decideTurn() {
		int array_of_info[] = new int[3];
		if (humanTurn) {
			humanTurn = false;
			array_of_info = humanTurn();
		}
		else {
			humanTurn = true;
			array_of_info = computerTurn();
		}
		
		currentRound++;
		return array_of_info;
	}
	
	/*
	 * It is the human's turn to make a guess.
	 * Retrieve human's guess
	 * human calls evaluate() to return a Pair of format: 
	 * 		<numberCorrentInCorrectPosition, numberCorrectInWrongPosition>
	 */
	private int[] humanTurn() {
		int array[] = new int[3];
		String s = null;
		Result p;
		
		while (s == null) {
			s = human.makeGuess(); // should either return a *correct* string or null
		}
		
		p = human.evaluate(s, computer.getMySecret());
		
		// If 4 are in the right place, the human has won.
		if (p.getCorrectPlaces() == 4) 
			array[0] = -1;
		else 
			array[0] = currentRound;
		
		array[1] = p.getCorrectPlaces();
		array[2] = p.getWrongPlaces();
		
		return array;
	}
	
	/*
	 * It is the computer's turn to make a guess.
	 * Retrieve computer's guess
	 * computer calls evaluate() to return a Pair of format: 
	 * 		<numberCorrentInCorrectPosition, numberCorrectInWrongPosition>
	 */
	private int[]  computerTurn() {
		int array[] = new int[3];
		String s;
		Result p;
		
		s = computer.makeGuess();
		
		p = computer.evaluate(s, human.getMySecret());
		
		// If 4 are in the right place, the computer has won.
		if (p.getCorrectPlaces() == 4) 
			array[0] = -1;
		else 
			array[0] = currentRound;
		
		array[1] = p.getCorrectPlaces();
		array[2] = p.getWrongPlaces();
		
		return array;
	}
}
