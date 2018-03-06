package logic;


import models.GameData;
public class DungeonMasterUIController extends PlayerUIController implements iMenu.IMenu{
	private GameData options = new GameData();

	private void setRules() {
		options.ruleSet();
	}
	@Override
	public void menu() {
		// TODO Auto-generated method stub
		
	} 	
	
}
