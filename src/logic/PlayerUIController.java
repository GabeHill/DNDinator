package logic;

import java.io.IOException;

import enums.Currency;
import files.Writer;
import models.CharSheet;

public class PlayerUIController implements iMenu.IMenu {
	private static CharSheet createCharacter() {
		CharSheet steve = new CharSheet();
		steve.changeAlignment(enums.Alignment.CHAOTIC_EVIL);
		steve.setMoney(Currency.PP, 9001);
		steve.setBackground(null);

		steve.setBonus(null, 0);

		steve.setCharacterName(null);

		steve.setCounter(null, 0);

		steve.addItem(null, null);

		steve.setMilestoneLeveling(true);

		steve.setOccupation(null);
		steve.setPlayerName(null);

		steve.setRace(null);

		steve.setStat(null, 0);
		return steve;
	}

	static void updateLevel(PlayerUIController charr) {
		createCharacter();
	}

	@Override
	public void menu() {

	}

	private String saveCharSheet(CharSheet c,String path, String encryptKey) {
		try {
			Writer.write(c, path + c.getCharacterName()+ ".json", encryptKey);
		} catch (IOException e) {
			return "Save unsuccessful. Check your path and try again.";
		}
		return "Save successful.";
	}

	private CharSheet loadCharSheet(String path,String charName, String encryptKey) {
		CharSheet d = null;
		try {
			d = (CharSheet) Writer.read(path + charName + ".json", encryptKey, CharSheet.class);
		} catch (IOException e) {
			return new CharSheet();
		}
		return d;
	}
}
