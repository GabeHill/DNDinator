package models;

public class Die {
	private final int numSides;

	public Die(int numSides) {
		this.numSides = numSides;
	}

	public int roll() {
		return (int) (Math.random() * numSides) + 1;
	}

}
