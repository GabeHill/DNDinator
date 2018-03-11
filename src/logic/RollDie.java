package logic;

import enums.DiceSides;

public class RollDie {

	public static int roll(DiceSides sides) {
		int luck = (int) (Math.random() * (sides.numOfSides + 1));

		return luck + 1;
	}

	public static int rollAdvantage(DiceSides sides) {
		int a = roll(sides);
		int b = roll(sides);
		return (a > b ? a : b) + 1;
	}

	public static int rollDisadvantage(DiceSides sides) {
		int a = roll(sides);
		int b = roll(sides);
		return (a < b ? a : b) + 1;
	}
}
