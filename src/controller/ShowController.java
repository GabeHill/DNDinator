package controller;

import models.*;
import view.*;

public class ShowController {
	public void test() {
		CharSheet char1 = new models.CharSheet();
		char1.setCharacterName(view.Show.charNameGetter());
	}
}
