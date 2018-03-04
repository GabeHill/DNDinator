package View;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Show
{
	private static BorderPane bPane = new BorderPane();
	private static Pane thePane = new Pane();
	private static int[] windowSize = {800,800};
	private static Scene theScene = new Scene(bPane,windowSize[1],windowSize[0]);
	
	//Initializes the GUI Display by setting up window and adding buttons
	//that lead to the Player Menu and Dungeon Master Menu
	public static void initDnDinatorDisplay(Stage primaryStage)
	{
		bPane.setCenter(thePane);
		primaryStage.setTitle("DnDinator");
		primaryStage.setScene(theScene);
		primaryStage.show();
	}
	
	//Initializes the Display of a fresh character sheet for new Character entry;
	// returns the character created by the field
	public static void displayCleanCharacterSheet(Stage primaryStage)
	{
		TextField characterNameField = new TextField();
		characterNameField.setPromptText("Character Name");
		characterNameField.setLayoutY(10);
		
		TextField characterRaceField = new TextField();
		characterRaceField.setPromptText("Character Race");
		characterRaceField.setLayoutX(150);
		characterRaceField.setLayoutY(10);
		
		thePane.getChildren().addAll(characterNameField,characterRaceField);
		primaryStage.setScene(theScene);
		primaryStage.show();
	}
}
