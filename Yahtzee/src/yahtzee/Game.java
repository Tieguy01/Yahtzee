package yahtzee;

public class Game {

	static int[] dice = new int[5];
	static boolean noZeros = false;
	static int gameDone = 0;
	
	public enum Rolls {
		FIRST_ROLL, SECOND_ROLL, THIRD_ROLL, PICK_CATAGORY, FINAL_SCORE
	}
	static Rolls currentRoll = Rolls.FIRST_ROLL;
	
	public static void firstRoll() {
		dice[0] = (int) (Math.random() * 7);
		dice[1] = (int) (Math.random() * 7);
		dice[2] = (int) (Math.random() * 7);
		dice[3] = (int) (Math.random() * 7);
		dice[4] = (int) (Math.random() * 7);

		for (int i = 0; i < 5; i++) {
			noZeros = false;
			while (!noZeros) {
				if (dice[i] == 0) {
					dice[i] = (int) (Math.random() * 7);
					noZeros = false;
				} else {
					noZeros = true;
				}
			}
		}

		System.out.println("Positions: 1 2 3 4 5");
		System.out.println("     Dice: " + dice[0] + " " + dice[1] + " " + dice[2] + " " + dice[3] + " " + dice[4]);
	}
	
	public static void game() {
		switch(currentRoll) {
		case FIRST_ROLL:
			System.out.println("\n");
			firstRoll();
			currentRoll = Rolls.SECOND_ROLL;
			break;
		case SECOND_ROLL:
			HoldDice.holdDice(HoldDice.findHoldDice(), dice);
			currentRoll = Rolls.THIRD_ROLL;
			break;
		case THIRD_ROLL:
			HoldDice.holdDice(HoldDice.findHoldDice(), dice);
			currentRoll = Rolls.PICK_CATAGORY;
			break;
		case PICK_CATAGORY:
			ScoreSheet.pickCategory(dice);
			gameDone++;
			if (gameDone < 13) {
				ScoreSheet.printScoreSheet();
				currentRoll = Rolls.FIRST_ROLL;
			} else {
				currentRoll = Rolls.FINAL_SCORE;
			}
			break;
		case FINAL_SCORE:
			gameDone++;
			System.out.println("\n");
			System.out.println("Final Score Sheet:");
			ScoreSheet.grandTotal();
			break;
		}
	}

	public static void main(String[] args) {
		while (gameDone <= 13) {
			game();
		}
	}
}
