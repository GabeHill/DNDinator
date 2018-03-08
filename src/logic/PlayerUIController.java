package logic;

import java.io.IOException;

import enums.Currency;
import enums.PrimaryStat;
import files.Writer;
import models.CharSheet;
import view.Show;

public class PlayerUIController implements iMenu.IMenu {

	public void run() {

	}

	private static CharSheet createCharacter() {
		Show show = new Show();
		CharSheet steve = new CharSheet();
		steve.changeAlignment(show.getCharAlign());
		steve.setMoney(Currency.PP, 9001);
		steve.setBackground(show.getCharBG());

		steve.setStat(PrimaryStat.CHARISMA, show.getChr());
		steve.setStat(PrimaryStat.CONSTITUTION, show.getCon());
		steve.setStat(PrimaryStat.MAX_HEALTH, show.getMaxHp());
		steve.setStat(PrimaryStat.INITIATIVE, show.getInitiative());
		steve.setStat(PrimaryStat.INTELLIGENCE, show.getIntel());
		steve.setStat(PrimaryStat.PROFICIENCY, show.getProfBns());
		steve.setStat(PrimaryStat.SPEED, show.getSpd());
		steve.setStat(PrimaryStat.STRENGTH, show.getStr());
		steve.setStat(PrimaryStat.TEMPORARY_HEALTH, show.getTempHp());
		steve.setStat(PrimaryStat.WISDOM, show.getWis());
		steve.setStat(PrimaryStat.ARMOR_CLASS, show.getArmClass());

		steve.setCharacterName(show.getCharacterNameField());

		steve.addItem(null, null);

		steve.setMilestoneLeveling(show.getMilestone());

		steve.setOccupation(show.getCharClass());
		
		steve.setPlayerName(show.getPlayerName());

		steve.setRace(show.getCharacterRaceField());

		return steve;
	}

	static void updateLevel(PlayerUIController charr) {
		createCharacter();
	}

	@Override
	public void menu() {

	}

	private String saveCharSheet(CharSheet c, String path, String encryptKey) {
		try {
			Writer.write(c, path + c.getCharacterName() + ".json", encryptKey);
		} catch (IOException e) {
			return "Save unsuccessful. Check your path and try again.";
		}
		return "Save successful.";
	}

	private CharSheet loadCharSheet(String path, String charName, String encryptKey) {
		CharSheet d = null;
		try {
			d = (CharSheet) Writer.read(path + charName + ".json", encryptKey, CharSheet.class);
		} catch (IOException e) {
			return new CharSheet();
		}
		return d;
	}
}
