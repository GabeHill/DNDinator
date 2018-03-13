package logic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import iMenu.IMenu;
import models.GameData;

public class DungeonMasterUIController extends PlayerUIController implements IMenu {
	private static GameData options = new GameData("Game");

	private void createGame(String name) {
		options = new GameData(name);
	}

	public static GameData loadRules(String path, String encryptKey) {
		GameData d = null;
		try {
			String p = path + ".json";
			ObjectInputStream iin = new ObjectInputStream(new FileInputStream(p));
			d = (GameData) iin.readObject();
			System.out.println(d);
			iin.close();
		} catch (IOException e) {
			System.out.println("fff");
			return new GameData("Fail");
		} catch (ClassNotFoundException e) {
			return null;
		}
		return d;
		// try {
		// // d = (GameData) Writer.read(path + options.gameName() + ".json",
		// encryptKey,
		// // GameData.class);
		// } catch (IOException e) {
		// return new GameData("Failed");
		// }
		// return d;
	}


	public static String saveRules(String path, String encryptKey) {
		try {
			ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream(path + options.gameName() + ".json"));
			oot.writeObject(options);
			oot.close();
			// Writer.write(c, path + c.getCharacterName() + ".json", encryptKey);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("fail");
			return "Save unsuccessful. Check your path and try again.";
		}
		System.out.println("success");
		return "Save successful.";
		// try {
		// Writer.write(options, path + options.gameName() + ".json", encryptKey);
		// } catch (IOException e) {
		// return "Save unsuccessful. Check your path and try again.";
		// }
		// return "Save successful.";
	}

	private void setRules() {
		options.addRule("");
		options.addRule(null);
	}

	public static  void methodSave(String name) {
		methodReturn = name;
	}
	public static String showTurn() {
		return methodReturn;
	}

	@Override
	public void menu() {
		

		switch (0) {
		case 1:
			setRules();
			break;
		case 2:
			createGame(null);
			break;
		case 3:
			saveRules(null, null);
			break;
		case 4:
			loadRules(null, null);
			break;
		default:
			break;
		}

	}
}
