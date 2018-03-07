package enums;

public enum DiceSides {
	EIGHT(8), FOUR(4), HUNDRED(100), SIX(6), TEN(10), TWELVE(12), TWENTY(20);

	public final int numOfSides;

	private DiceSides(int sides) {
		numOfSides = sides;
	}
}
