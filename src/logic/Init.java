package logic;

public class Init {
	public void run() {
		PlayerUIController.updateLevel(initializeData(true));
	}

	

	private PlayerUIController initializeData(boolean player) {
		PlayerUIController steve = null;
		if (player) {
			steve = new PlayerUIController();

		} else if (!player) {
			steve = new DungeonMasterUIController();
		}
		return steve;
	}

}
