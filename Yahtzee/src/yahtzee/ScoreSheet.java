package yahtzee;
import java.util.Scanner;

public class ScoreSheet extends Categories{
	
	static Scanner scan = new Scanner(System.in);
	
	public static void upperTotal() {
		upTotal1 = aces + twos + threes + fours + fives + sixes;
		if (upTotal1 >= 63) {
			bonus = 35;
		}
		upTotal2 = upTotal1 + bonus;
	}
	
	public static void lowerTotal() {
		lowTotal = threeOfaKind + fourOfaKind + fullHouse + smStraight + lgStraight + yahtzee + chance;
	}
	
	public static void grandTotal() {
		upperTotal();
		lowerTotal();
		grandTotal = upTotal2 + lowTotal;
		printScoreSheet();
	}
	
	public static void pickCategory(int[] dice) {
		printScoreSheet();
		
		int category = 0;
		boolean numCategory = false;
		boolean useCategory = true;
		
		while (!numCategory) {
			useCategory = true;
			System.out.println("Which category would you like to put your dice in? 1-13?");
			category = scan.nextInt();
			if (category <= 13 && category >= 1) {
				for (int i = 0; i < 13; i++) {
					if (usedCategories[i] == category) {
						System.out.println("Sorry, that category has already been used. Please try again.");
						useCategory = false;
					} 
				}
				if (useCategory) {
					numCategory = true;
				}
			} else {
				System.out.println("Sorry, that is not a valid category. Please try again.");
			}
		}
		
		switch(category) {
		case 1:
			aces(dice);
			break;
		case 2:
			twos(dice);
			break;
		case 3:
			threes(dice);
			break;
		case 4:
			fours(dice);
			break;
		case 5:
			fives(dice);
			break;
		case 6:
			sixes(dice);
			break;
		case 7:
			threeOfaKind(dice);
			break;
		case 8:
			fourOfaKind(dice);
			break;
		case 9:
			fullHouse(dice);
			break;
		case 10:
			smStraight(dice);
			break;
		case 11:
			lgStraight(dice);
			break;
		case 12:
			yahtzee(dice);
			break;
		case 13:
			chance(dice);
			break;
		}
		usedCategories[category - 1] = category;
	}

	public static void printScoreSheet() {

		upperTotal();
		lowerTotal();
		
		String stAces = "  ";
		String stTwos = "  ";
		String stThrees = "  ";
		String stFours = "  ";
		String stFives = "  ";
		String stSixes = "  ";
		String stUpTotal1 = "   ";
		String stBonus = "  ";
		String stUpTotal2 = "   ";

		String stThreeOfaKind = "  ";
		String stFourOfaKind = "  ";
		String stFullHouse = "  ";
		String stSmStraight = "  ";
		String stLgStraight = "  ";
		String stYahtzee = "  ";
		String stChance = "  ";
		String stLowTotal = "   ";

		String stGrandTotal = "   ";
		
		if (usedCategories[0] == 1) {
			stAces = String.format("%02d", aces);
		}
		if (usedCategories[1] == 2) {
			stTwos = String.format("%02d", twos);
		}
		if (usedCategories[2] == 3) {
			stThrees = String.format("%02d", threes);
		}
		if (usedCategories[3] == 4) {
			stFours = String.format("%02d", fours);
		}
		if (usedCategories[4] == 5) {
			stFives = String.format("%02d", fives);
		}
		if (usedCategories[5] == 6) {
			stSixes = String.format("%02d", sixes);
		}
		if (upTotal1 > 0) {
			stUpTotal1 = String.format("%03d", upTotal1);
		}
		if (bonus > 0) {
			stBonus = String.format("%02d", bonus);
		}
		if (upTotal2 > 0) {
			stUpTotal2 = String.format("%03d", upTotal2);
		}
		
		if (usedCategories[6] == 7) {
			stThreeOfaKind = String.format("%02d", threeOfaKind);
		}
		if (usedCategories[7] == 8) {
			stFourOfaKind = String.format("%02d", fourOfaKind);
		}
		if (usedCategories[8] == 9) {
			stFullHouse = String.format("%02d", fullHouse);
		}
		if (usedCategories[9] == 10) {
			stSmStraight = String.format("%02d", smStraight);
		}
		if (usedCategories[10] == 11) {
			stLgStraight = String.format("%02d", lgStraight);
		}
		if (usedCategories[11] == 12) {
			stYahtzee = String.format("%02d", yahtzee);
		}
		if (usedCategories[12] == 13) {
			stChance = String.format("%02d", chance);
		}
		if (lowTotal > 0) {
			stLowTotal = String.format("%03d", lowTotal);
		}
		
		if (grandTotal > 0) {
			stGrandTotal = String.format("%03d", grandTotal);
		}

		StringBuilder sb = new StringBuilder();
		sb.append("___________________________");
		sb.append("\n");
		sb.append("|Upper:___________________|");
		sb.append("\n");
		sb.append("| 1  |         Aces |  " + stAces + " |");
		sb.append("\n");
		sb.append("| 2  |         Twos |  " + stTwos + " |");
		sb.append("\n");
		sb.append("| 3  |       Threes |  " + stThrees + " |");
		sb.append("\n");
		sb.append("| 4  |        Fours |  " + stFours + " |");
		sb.append("\n");
		sb.append("| 5  |        Fives |  " + stFives + " |");
		sb.append("\n");
		sb.append("| 6  |        Sixes |  " + stSixes + " |");
		sb.append("\n");
		sb.append("|    |        Total | " + stUpTotal1 + " |");
		sb.append("\n");
		sb.append("|    |        Bonus |  " + stBonus + " |");
		sb.append("\n");
		sb.append("|    |        Total | " + stUpTotal2 + " |");
		sb.append("\n");
		sb.append("|____|______________|_____|");
		sb.append("\n");
		sb.append("|Lower:___________________|");
		sb.append("\n");
		sb.append("| 7  |  3 of a kind |  " + stThreeOfaKind + " |");
		sb.append("\n");
		sb.append("| 8  |  4 of a kind |  " + stFourOfaKind + " |");
		sb.append("\n");
		sb.append("| 9  |   Full house |  " + stFullHouse + " |");
		sb.append("\n");
		sb.append("| 10 | Sm. Straight |  " + stSmStraight + " |");
		sb.append("\n");
		sb.append("| 11 | Lg. Straight |  " + stLgStraight + " |");
		sb.append("\n");
		sb.append("| 12 |      YAHTZEE |  " + stYahtzee + " |");
		sb.append("\n");
		sb.append("| 13 |       Chance |  " + stChance + " |");
		sb.append("\n");
		sb.append("|    |        Total | " + stLowTotal + " |");
		sb.append("\n");
		sb.append("|    |  Grand Total | " + stGrandTotal + " |");
		sb.append("\n");
		sb.append("|____|______________|_____|");

		System.out.println(sb.toString());
	}
}
