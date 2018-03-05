package logic;

import java.util.Random;


public class RollDie {

	public static int roll(enums.DiceSides sides) {
		int rollSize = 0;
		if (sides == enums.DiceSides.FOUR) {
			rollSize = 4;
		}
		if (sides == enums.DiceSides.SIX) {
			rollSize = 6;
		}
		if (sides == enums.DiceSides.EIGHT) {
			rollSize = 8;
		}
		if (sides == enums.DiceSides.TEN) {
			rollSize = 10;
		}
		if (sides == enums.DiceSides.TWELVE) {
			rollSize = 12;
		}
		if (sides == enums.DiceSides.TWENTY) {
			rollSize = 20;
		}
		if (sides == enums.DiceSides.HUNDRED) {
			rollSize = 100;
		}
		Random gen = new Random();
		int luck = gen.nextInt(rollSize);
		return luck;

	}
}
