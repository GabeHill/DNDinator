package main;

import javafx.application.Application;
import javafx.stage.Stage;
import models.CharSheet;
import view.Show;

public class Main extends Application
{
	public static Show primaryShow = new Show();
	public static void main(String[] args) 
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
	
		primaryShow.initDnDinatorDisplay(primaryStage);
		primaryShow.displayMainMenu(primaryStage);
//		primaryShow.displayCleanCharacterSheet(primaryStage);
//		primaryShow.displayFilledCharacterSheet(primaryStage, new CharSheet(), false);
//		primaryShow.displayDMMenu(primaryStage);
	}


}
