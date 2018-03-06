package logic;

import models.GameData;

public class DungeonMasterUIController extends PlayerUIController implements iMenu.IMenu {
	private GameData options;

	private void createGame(String name) {
		options = new GameData(name);
	}

	@Override
	public void menu() {
		// TODO Auto-generated method stub

		switch (0) {
		case 1:
			setRules();
			break;
		case 2:
			createGame(null);
			break;
		default:
			break;
		}

	}

	private void setRules() {
		options.addRule(null, null);
	}

}
