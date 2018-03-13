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
import main.Main;
import models.CharSheet;


public class PlayerUIController implements IMenu {
	public static String methodReturn = "";
 
	public void run() {

	}

	public static CharSheet createCharacter(Stage primaryStage) {

		CharSheet steve = new CharSheet();

		steve.setItems(Main.primaryShow.getItems());

		steve.setMilestoneLeveling(Main.primaryShow.getMilestone());

		steve.setOccupation(Main.primaryShow.getCharClass());

		steve.setPlayerName(Main.primaryShow.getPlayerName());

		steve.setRace(Main.primaryShow.getCharacterRaceField());

		steve.setBackground(Main.primaryShow.getCharBG());

		steve.setCharacterName(Main.primaryShow.getCharacterNameField());

		steve.changeAlignment(Main.primaryShow.getCharAlign());
		
		for (int i = 0; i<Main.primaryShow.getAtkName().length;i++) {	
			steve.addOtherData("AttackName"+i, Main.primaryShow.getAtkName()[i]);
		}
		for (int i = 0; i<Main.primaryShow.getAtkBns().length;i++) {	
			steve.addOtherData("AttackBns"+i, Main.primaryShow.getAtkBns()[i]);
		}
		for (int i = 0; i<Main.primaryShow.getAtkDmg().length;i++) {	
			steve.addOtherData("AttackDmg"+i, Main.primaryShow.getAtkDmg()[i]);
		}
		//ahh

		steve.addOtherData("Hit Die", Main.primaryShow.getHd() + "");
		steve.addOtherData("Traits", Main.primaryShow.getPerTraits());
		steve.addOtherData("Ideals", Main.primaryShow.getPerIdeals());
		steve.addOtherData("Bonds", Main.primaryShow.getPerBonds());
		steve.addOtherData("Flaws", Main.primaryShow.getPerFlaws());
		steve.addOtherData("Other", Main.primaryShow.getOtherPnL());
		steve.addOtherData("Add", Main.primaryShow.getAdditionalTraits());
		
		int[] muns = Main.primaryShow.getCurrency();
		steve.setMoney(Currency.CP, muns[0]);
		steve.setMoney(Currency.EP, muns[1]);
		steve.setMoney(Currency.GP, muns[2]);
		steve.setMoney(Currency.PP, muns[3]);
		steve.setMoney(Currency.SP, muns[4]);

		steve.setStat(PrimaryStat.CHARISMA, Main.primaryShow.getChr());
		steve.setStat(PrimaryStat.CONSTITUTION, Main.primaryShow.getCon());
		steve.setStat(PrimaryStat.MAX_HEALTH, Main.primaryShow.getMaxHp());
		steve.setStat(PrimaryStat.INITIATIVE, Main.primaryShow.getInitiative());
		steve.setStat(PrimaryStat.INTELLIGENCE, Main.primaryShow.getIntel());
		steve.setStat(PrimaryStat.PROFICIENCY, Main.primaryShow.getProfBns());
		steve.setStat(PrimaryStat.SPEED, Main.primaryShow.getSpd());
		steve.setStat(PrimaryStat.STRENGTH, Main.primaryShow.getStr());
		steve.setStat(PrimaryStat.TEMPORARY_HEALTH, Main.primaryShow.getTempHp());
		steve.setStat(PrimaryStat.WISDOM, Main.primaryShow.getWis());
		steve.setStat(PrimaryStat.ARMOR_CLASS, Main.primaryShow.getArmClass());

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
			System.out.println(d + "Loaded");
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
