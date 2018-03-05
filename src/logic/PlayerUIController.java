package logic;

import java.util.Map;

import iMenu.IMenu;
import models.CharSheet;
import models.StatsMap;

public class PlayerUIController implements Imenu.IMenu {
	static void updateLevel(PlayerUIController charr) {
		createCharacter();
	}

	private static CharSheet createCharacter() {
		CharSheet kirito = new CharSheet();
		kirito.changeAlignment(enums.Alignment.CHAOTIC_EVIL);
		kirito.changeMoney("PP", 9001);
		kirito.setBackground(null);

		kirito.setBonuses(null);

		kirito.setCharacterName(null);

		kirito.setCounters(null, 0);

		kirito.setItems(null, null);

		kirito.setMilestoneLeveling(true);

		kirito.setOccupation(null);
		kirito.setPlayerName(null);

		kirito.setRace(null);

		kirito.setStats(null, 0);
		return kirito;
	}

	@Override
	public void menu() {

	}

}
