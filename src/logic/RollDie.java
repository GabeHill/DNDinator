package logic;

import java.util.Random;

import enums.DiceSides;

public class RollDie {

	public static int roll(DiceSides sides) {
		Random gen = new Random();
		int luck = gen.nextInt(sides.numOfSides);
		return luck;
	}

	public static int rollAdvantage(DiceSides sides) {
		int a = roll(sides);
		int b = roll(sides);
		return a > b ? a : b;
	}

	public static int rollDisadvantage(DiceSides sides) {
		int a = roll(sides);
		int b = roll(sides);
		return a < b ? a : b;
	}
}
