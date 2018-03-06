package logic;

import java.util.Map;

import iMenu.IMenu;
import models.CharSheet;
import models.StatsMap;

public class PlayerUIController implements iMenu.IMenu {
	static void updateLevel(PlayerUIController charr) {
		createCharacter();
	}

	private static CharSheet createCharacter() {
		CharSheet steve = new CharSheet();
		steve.changeAlignment(enums.Alignment.CHAOTIC_EVIL);
		steve.changeMoney("PP", 9001);
		steve.setBackground(null);

		steve.setBonuses(null);

		steve.setCharacterName(null);

		steve.setCounters(null, 0);

		steve.setItems(null, null);

		steve.setMilestoneLeveling(true);

		steve.setOccupation(null);
		steve.setPlayerName(null);

		steve.setRace(null);

		steve.setStats(null, 0);
		return steve;
	}

	@Override
	public void menu() {

	}

}
