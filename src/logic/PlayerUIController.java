package logic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import enums.Currency;
import enums.PrimaryStat;
import iMenu.IMenu;
import javafx.stage.Stage;
import models.CharSheet;
import view.Show;

public class PlayerUIController implements IMenu {
	static Show show = new Show();
	public String methodReturn = "";

	public void run() {

	}

	public static CharSheet createCharacter(Stage primaryStage) {

		CharSheet steve = new CharSheet();

		steve.setItems(show.getItems());

		steve.setMilestoneLeveling(show.getMilestone());

		steve.setOccupation(show.getCharClass());

		steve.setPlayerName(show.getPlayerName());

		steve.setRace(show.getCharacterRaceField());

		steve.setBackground(show.getCharBG());

		steve.setCharacterName(show.getCharacterNameField());

		steve.changeAlignment(show.getCharAlign());

		steve.addOtherData("Hit Die", show.getHd() + "");

		int[] muns = show.getCurrency();
		steve.setMoney(Currency.CP, muns[0]);
		steve.setMoney(Currency.EP, muns[1]);
		steve.setMoney(Currency.GP, muns[2]);
		steve.setMoney(Currency.PP, muns[3]);
		steve.setMoney(Currency.SP, muns[4]);

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

		return steve;
	}

	static void updateLevel(CharSheet steve, int a) {

		if (steve.isMilestoneLeveling()) {
			steve.levelUp(a);
		} else {
			steve.addXp(a);
		}
	}

	public static String saveCharSheet(CharSheet c, String path, String encryptKey) {
		try {
			String nam = c.getCharacterName();
			System.out.println(nam);
			String out = path + nam + ".json";
			ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream(out));
			oot.writeObject(c);
			oot.close();
			// Writer.write(c, path + c.getCharacterName() + ".json", encryptKey);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("fail");
			return "Save unsuccessful. Check your path and try again.";
		}
		System.out.println("success");
		return "Save successful.";
	}

	public static  CharSheet loadCharSheet(String path, String charName, String encryptKey) {
		CharSheet d = null;
		try {
			String p = path + charName + ".json";
			ObjectInputStream iin = new ObjectInputStream(new FileInputStream(p));
			d = (CharSheet) iin.readObject();
			System.out.println(d);
			iin.close();
			// d = (CharSheet) Writer.read(path + charName + ".json", encryptKey,
			// CharSheet.class);
		} catch (IOException e) {
			System.out.println("fff");
			return new CharSheet();
		} catch (ClassNotFoundException e) {
			return null;
		}
		return d;
	}

	@Override
	public void menu() {

	}
}
