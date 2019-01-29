package yahtzee;

import java.util.Scanner;

public class HoldDice {
	
	static Scanner holdScan = new Scanner(System.in);
	
	public static int[] findHoldDice(){
		
		int [] holdDice = new int[0];
		boolean holdDiceNum = false;
		int numHoldDice = 0;
		int diceNumInput;
		int lastDiceNum = 0;
		
		while (!holdDiceNum) {
			System.out.println("How many dice would you like to hold?");
			numHoldDice = holdScan.nextInt();
			if (numHoldDice <= 5 && numHoldDice >= 0) {
				holdDiceNum = true;
			} else {
				System.out.println("Sorry, that is not a valid number. Please try again.");
			}
		}
		if (numHoldDice > 0) {
			holdDice = new int[numHoldDice];
			if (numHoldDice == 5) {
				for (int i = 0; i < 5; i++) {
					holdDice[i] = i + 1;
				}
			} else {
				for (int i = 0; i < numHoldDice; i++) {
					holdDiceNum = false;
					while (!holdDiceNum) {
						System.out.println("What is one position of a die you would like to hold?");
						diceNumInput = holdScan.nextInt();
						if (diceNumInput <= 5 && diceNumInput > 0 && diceNumInput != lastDiceNum) {
							holdDice[i] = diceNumInput;
							lastDiceNum = diceNumInput;
							holdDiceNum = true;
						} else {
							System.out.println("Sorry that is not a valid number. Please try again.");
						}
					}
				}
			}
		}
		return holdDice;
	}
	
	public static int rollDie() {
		int die;
		boolean noZeros = false;
		die = (int) (Math.random() * 7);
		while (!noZeros) {
			if (die == 0) {
				die = (int) (Math.random() * 7);
				noZeros = false;
			} else {
				noZeros = true;
			}
		}
		return die;
	}
	
	public static void holdDice(int[] holdDice, int[] dice) {
		int shouldRoll;
		if (holdDice.length < 5) {
			for (int i = 1; i < 6; i++) {
				shouldRoll = 0;
				for (int j = 0; j < holdDice.length; j++) {
					if (i != holdDice[j]) {
						shouldRoll++;
					} 
				}
				if (shouldRoll == holdDice.length) {
					dice[i - 1] = rollDie(); 
				}
			}
		}	
		System.out.println(dice[0] + " " + dice[1] + " " + dice[2] + " " + dice[3] + " " + dice[4]);
	}
	
}
