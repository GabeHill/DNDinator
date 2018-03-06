package logic;

import models.GameData;

public class DungeonMasterUIController extends PlayerUIController implements iMenu.IMenu {
	private GameData options = new GameData();

	@Override
	public void menu() {
		// TODO Auto-generated method stub

	}

	private void setRules() {
		options.addRule(null,null);
	}

}
