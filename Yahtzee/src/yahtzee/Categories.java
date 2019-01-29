package yahtzee;

public class Categories {
	
	static int[] usedCategories = new int[13];
	
	static protected int aces;
	static protected int twos;
	static protected int threes;
	static protected int fours;
	static protected int fives;
	static protected int sixes;
	static protected int upTotal1;
	static protected int bonus;
	static protected int upTotal2;

	static protected int threeOfaKind;
	static protected int fourOfaKind;
	static protected int fullHouse;
	static protected int smStraight;
	static protected int lgStraight;
	static protected int yahtzee;
	static protected int chance;
	static protected int lowTotal;

	static int grandTotal;

	public static void aces(int[] dice) {
		for (int i = 0; i < 5; i++) {
			if (dice[i] == 1) {
				aces += 1;
			}
		}
	}

	public static void twos(int[] dice) {
		for (int i = 0; i < 5; i++) {
			if (dice[i] == 2) {
				twos += 2;
			}
		}
	}

	public static void threes(int[] dice) {
		for (int i = 0; i < 5; i++) {
			if (dice[i] == 3) {
				threes += 3;
			}
		}
	}

	public static void fours(int[] dice) {
		for (int i = 0; i < 5; i++) {
			if (dice[i] == 4) {
				fours += 4;
			}
		}
	}

	public static void fives(int[] dice) {
		for (int i = 0; i < 5; i++) {
			if (dice[i] == 5) {
				fives += 5;
			}
		}
	}

	public static void sixes(int[] dice) {
		for (int i = 0; i < 5; i++) {
			if (dice[i] == 6) {
				sixes += 6;
			}
		}
	}

	public static void threeOfaKind(int[] dice) {
		int d;
		int numSame = 0;
		for (int i = 0; i < 5; i++) {
			numSame = 0;
			d = dice[i];
			for (int j = 0; j < 5; j++) {
				if (dice[j] == d) {
					numSame++;
				}
			}
			if (numSame >= 3) {
				i = 6;
			} 
		}
		if (numSame >= 3) {
			for (int i = 0; i < 5; i++) {
				threeOfaKind += dice[i];
			}
		}
	}
	
	public static void fourOfaKind(int[] dice) {
		int d;
		int numSame = 0;
		for (int i = 0; i < 5; i++) {
			numSame = 0;
			d = dice[i];
			for (int j = 0; j < 5; j++) {
				if (dice[j] == d) {
					numSame++;
				}
			}
			if (numSame >= 4) {
				i = 6;
			}
		}
		if (numSame >= 4) {
			for (int i = 0; i < 5; i++) {
				fourOfaKind += dice[i];
			}
		} 
	}
	
	public static void fullHouse(int[] dice) {
		int d1 = 0;
		int d2;
		int numSame = 0;
		boolean three = false;
		boolean two = false;
		for (int i = 0; i < 5; i++) {
			numSame = 0;
			d1 = dice[i];
			for (int j = 0; j < 5; j++) {
				if (dice[j] == d1) {
					numSame++;
				}
			}
			if (numSame >= 3) {
				three = true;
				numSame = 0;
				i = 6;
			}
		}
		if(three) {
			for (int i = 0; i < 5; i++) {
				numSame = 0;
				d2 = dice[i];
				if (d2 != d1) {
					for (int j = 0; j < 5; j++) {
						if (dice[j] == d2) {
							numSame++;
						}
					}
				}
				if (numSame >= 2) {
					two = true;
					i = 6;
				} 
			}
		}
		if (three && two) {
			fullHouse = 25;
		}
	}
	
	public static int smStraight(int[] dice) {
		boolean one = false;
		boolean two = false;
		boolean three = false;
		boolean four = false;
		boolean five  = false;
		boolean six  = false;
		for(int i = 0; i < 5; i++) {
			if (dice[i] == 1) {
				one = true;
			}
			if (dice[i] == 2) {
				two = true;
			}
			if (dice[i] == 3) {
				three = true;
			}
			if (dice[i] == 4) {
				four = true;
			}
			if (dice[i] == 5) {
				five = true;
			}
			if (dice[i] == 6) {
				six = true;
			}
			if (three && four) {
				if ((one && two) || (two && five) || (five && six)) {
					smStraight = 30;
				}
			}
		}
		
		return smStraight;
	}
	
	public static void lgStraight(int[] dice) {
		boolean one = false;
		boolean two = false;
		boolean three = false;
		boolean four = false;
		boolean five  = false;
		boolean six  = false;
		for(int i = 0; i < 5; i++) {
			if (dice[i] == 1) {
				one = true;
			}
			if (dice[i] == 2) {
				two = true;
			}
			if (dice[i] == 3) {
				three = true;
			}
			if (dice[i] == 4) {
				four = true;
			}
			if (dice[i] == 5) {
				five = true;
			}
			if (dice[i] == 6) {
				six = true;
			}
			if (two && three && four && five) {
				if (one || six) {
					lgStraight = 40;
				}
			}
		}		
	}
	
	public static void yahtzee(int[] dice) {
		int d;
		int numSame = 0;
		for (int i = 0; i < 5; i++) {
			numSame = 0;
			d = dice[i];
			for (int j = 0; j < 5; j++) {
				if (dice[j] == d) {
					numSame++;
				}
			}
			if (numSame == 5) {
				i = 6;
			}
		}
		if (numSame == 5) {
			yahtzee = 50;
		} 
	}
	
	public static void chance(int[] dice) {
		for (int i = 0; i < 5; i++) {
			chance += dice[i];
		}
	}
}
