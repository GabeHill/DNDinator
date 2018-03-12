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

public class PlayerUIController implements IMenu 
{
	public static String methodReturn = "";

	public static void run() 
	{

	}

	public static CharSheet createCharacter(Stage primaryStage) 
	{
		Show.displayCleanCharacterSheet(primaryStage);

		CharSheet steve = new CharSheet();

		steve.setItems(Show.getItems());

		steve.setMilestoneLeveling(Show.getMilestone());

		steve.setOccupation(Show.getCharClass());

		steve.setPlayerName(Show.getPlayerName());

		steve.setRace(Show.getCharacterRaceField());

		steve.setBackground(Show.getCharBG());

		steve.setCharacterName(Show.getCharacterNameField());

		steve.changeAlignment(Show.getCharAlign());

		steve.addOtherData("Hit Die", Show.getHd() + "");

		int[] muns = Show.getCurrency();
		steve.setMoney(Currency.CP, muns[0]);
		steve.setMoney(Currency.EP, muns[1]);
		steve.setMoney(Currency.GP, muns[2]);
		steve.setMoney(Currency.PP, muns[3]);
		steve.setMoney(Currency.SP, muns[4]);

		steve.setStat(PrimaryStat.CHARISMA, Show.getChr());
		steve.setStat(PrimaryStat.CONSTITUTION, Show.getCon());
		steve.setStat(PrimaryStat.MAX_HEALTH, Show.getMaxHp());
		steve.setStat(PrimaryStat.INITIATIVE, Show.getInitiative());
		steve.setStat(PrimaryStat.INTELLIGENCE, Show.getIntel());
		steve.setStat(PrimaryStat.PROFICIENCY, Show.getProfBns());
		steve.setStat(PrimaryStat.SPEED, Show.getSpd());
		steve.setStat(PrimaryStat.STRENGTH, Show.getStr());
		steve.setStat(PrimaryStat.TEMPORARY_HEALTH, Show.getTempHp());
		steve.setStat(PrimaryStat.WISDOM, Show.getWis());
		steve.setStat(PrimaryStat.ARMOR_CLASS, Show.getArmClass());

		return steve;
	}

	public static void updateLevel(CharSheet steve, int a) 
	{

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

	public static CharSheet loadCharSheet(String path, String charName, String encryptKey) {
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
	public void menu() 
	{
		
	}
}
