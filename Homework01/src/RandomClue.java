/**
 * RandomClue.java : Solver for the Clue problem in 20 guesses or less
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */

import java.util.Scanner;

public class RandomClue {

	/**
	 * Tester for assistant theory checker that solves in 20 guesses or less
	 * 
	 * Algorithm:
	 * 1. Declare all necessary variables
	 * 2. Ask user which scenario they would like to test
	 * 3. Initialize jack with the answer set and the weapon, location, murder variables to 1
	 * 4. Enter a do while loop where either weapon, location, or murder is incremented
	 * 		based on jack's feedback and don't stop until his feedback is 0, meaning "solved"
	 * 5. Display to the user the times asked and the correct solution.
	 * 6. Display one of two messages depending on if the answer was found within 20 guesses
	 * 
	 * @param args
	 *            command line arguments (unused)
	 */
	public static void main(String[] args) {
		int answerSet, help, weapon, location, murder;
		Scanner keyboard = new Scanner(System.in);
		Theory answer = null;
		AssistantJack jack;

		System.out.print("Which theory would like you like to test? (1, 2, 3[random]): ");
		answerSet = keyboard.nextInt();
		keyboard.close();

		jack = new AssistantJack(answerSet);
		weapon = 1;
		location = 1;
		murder = 1;
		do{
			help = jack.checkAnswer(weapon, location, murder);
			switch (help) {
				case 1: weapon++;
						break;
				case 2: location++;
						break;
				case 3: murder++;
						break;
			}
		} while (help != 0);
		answer = new Theory(weapon, location, murder);
		System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution = " + answer);

		if (jack.getTimesAsked() > 20) {
			System.out.println("FAILED!! You're a horrible Detective...");
		} else {
			System.out.println("WOW! You might as well be called Batman!");
		}

	}

}