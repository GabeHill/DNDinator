package main;

import controller.ShowController;
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
		Show primaryShow = new Show();
		primaryShow.initDnDinatorDisplay(primaryStage);
		primaryShow.displayCleanCharacterSheet(primaryStage);
		ShowController primarySController = new ShowController();
	}


}
