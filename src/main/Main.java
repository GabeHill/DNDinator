package main;

import javafx.application.Application;
import javafx.stage.Stage;
import view.Show;

public class Main extends Application
{
	
	public static void main(String[] args) 
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		Show.initDnDinatorDisplay(primaryStage);
		Show.displayCleanCharacterSheet(primaryStage);
	}


}
