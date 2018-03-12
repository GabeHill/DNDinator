package logic;

import java.io.IOException;

import files.Writer;
import iMenu.IMenu;
import javafx.stage.Stage;
import models.GameData;

public class DungeonMasterUIController extends PlayerUIController implements IMenu {
	private GameData options;

	private void createGame(String name) {
		options = new GameData(name);
	}

	public GameData loadRules(String path, String encryptKey) {
		GameData d = null;
		try {
			d = (GameData) Writer.read(path + options.gameName() + ".json", encryptKey, GameData.class);
		} catch (IOException e) {
			return new GameData("Failed");
		}
		return d;
	}


	public void methodSave(String name) {
		methodReturn = name;
	}

	public String saveRules(String path, String encryptKey) {
		try {
			Writer.write(options, path + options.gameName() + ".json", encryptKey);
		} catch (IOException e) {
			return "Save unsuccessful. Check your path and try again.";
		}
		return "Save successful.";
	}

	private void setRules() 
	{
		options.addRule("");
		options.addRule(null);
	}

	public String showTurn() {
		return methodReturn;
	}

	@Override
	public void menu(Stage primaryStage) 
	{
		
	}
}
