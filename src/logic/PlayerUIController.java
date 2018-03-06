package logic;

import enums.Currency;
import models.CharSheet;

public class PlayerUIController implements iMenu.IMenu {
	private static CharSheet createCharacter() {
		CharSheet steve = new CharSheet();
		steve.changeAlignment(enums.Alignment.CHAOTIC_EVIL);
		steve.changeMoney(Currency.PP, 9001);
		steve.setBackground(null);

		steve.setBonus(null, 0);

		steve.setCharacterName(null);

		steve.changeCounter(null, 0);

		steve.addItem(null, null);

		steve.setMilestoneLeveling(true);

		steve.setOccupation(null);
		steve.setPlayerName(null);

		steve.setRace(null);

		steve.setStats(null, 0);
		return steve;
	}

	static void updateLevel(PlayerUIController charr) {
		createCharacter();
	}

	@Override
	public void menu() {

	}

}
