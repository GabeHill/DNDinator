package logic;

import java.io.IOException;

import enums.Currency;
import files.Writer;
import models.CharSheet;
import view.Show;

public class PlayerUIController implements iMenu.IMenu {
	
	public void run() {
		
	}

	
	private static CharSheet createCharacter() {
		Show show = new Show();
		CharSheet steve = new CharSheet();
		steve.changeAlignment(enums.Alignment.CHAOTIC_EVIL);
		steve.setMoney(Currency.PP, 9001);
		steve.setBackground(null);

		steve.setStat(null, show.getChr());
		steve.setStat(null, show.getCon());
		steve.setStat(null, show.getHp());
		steve.setStat(null, show.getInitiative());
		steve.setStat(null, show.getIntel());
		steve.setStat(null, show.getProfBns());
		steve.setStat(null, show.getSpd());
		steve.setStat(null, show.getStr());
		steve.setStat(null, show.getTempHp());
		steve.setStat(null, show.getWis());
		steve.setStat(null, show.getArmClass());
		steve.setStat(null, show.getHd());
		


		steve.setCharacterName(null);

		steve.setCounter(null, 0);

		steve.addItem(null, null);

		steve.setMilestoneLeveling(true);

		steve.setOccupation(null);
		steve.setPlayerName(null);

		steve.setRace(null);

		
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
