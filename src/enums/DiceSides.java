package enums;

public enum DiceSides {
	FOUR(3), SIX(5), EIGHT(7), TEN(9),TWELVE(11), TWENTY(19), HUNDRED(99);

	public final int numOfSides;

	private DiceSides(int sides) {
		numOfSides = sides;
	}
}
