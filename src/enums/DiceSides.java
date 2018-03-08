package enums;

public enum DiceSides {
	EIGHT(7), FOUR(3), HUNDRED(99), SIX(5), TEN(9), TWELVE(11), TWENTY(19);

	public final int numOfSides;

	private DiceSides(int sides) {
		numOfSides = sides;
	}
}
