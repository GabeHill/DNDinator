package View;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Show
{
	private static BorderPane bPane = new BorderPane();
	private static Pane thePane = new Pane();
	private static int[] windowSize = {800,800};
	private static Scene theScene = new Scene(bPane,windowSize[1],windowSize[0]);
	
	//Initializes the GUI Display by setting up window and adds buttons
	//that call the Logic methods for Player menu and DM Menu
	public static void initDnDinatorDisplay(Stage primaryStage)
	{
		bPane.setCenter(thePane);
		primaryStage.setTitle("DnDinator");
		primaryStage.setScene(theScene);
		primaryStage.show();
	}
	
	//Initializes the Display of a fresh character sheet for new Character entry;
	// returns the character created by the field
	//(TextFields are defaulted at 150 length and 25 height)
	public static void displayCleanCharacterSheet(Stage primaryStage)
	{
		ImageView viewSheet = new ImageView();
		viewSheet.setImage(new Image("file:Character Sheet (Official) - Copy_Page_1.png",790,790,true,true));
		
		TextField characterNameField = new TextField();
		characterNameField.setPromptText("Name");
		characterNameField.setLayoutY(59);
		characterNameField.setLayoutX(50);
		
		TextField characterRaceField = new TextField();
		characterRaceField.setPromptText("Race");
		characterRaceField.setLayoutX(270);
		characterRaceField.setLayoutY(72);
		characterRaceField.setPrefWidth(100);
		
		TextField charAlign = new TextField();
		charAlign.setPromptText("Alignment");
		charAlign.setLayoutX(370);
		charAlign.setLayoutY(72);
		charAlign.setPrefWidth(100);
		
		TextField charEXP = new TextField();
		charEXP.setPromptText("Exp/Milestone");
		charEXP.setLayoutX(470);
		charEXP.setLayoutY(72);
		charEXP.setPrefWidth(100);
		
		TextField charClassLevel = new TextField();
		charClassLevel.setPromptText("Class & Level");
		charClassLevel.setLayoutX(270);
		charClassLevel.setLayoutY(47);
		charClassLevel.setPrefWidth(100);
		
		TextField charBG = new TextField();
		charBG.setPromptText("Background");
		charBG.setLayoutX(370);
		charBG.setLayoutY(47);
		charBG.setPrefWidth(100);
		
		TextField playerName = new TextField();
		playerName.setPromptText("Player Name");
		playerName.setLayoutX(470);
		playerName.setLayoutY(47);
		playerName.setPrefWidth(100);
		
		TextField str = new TextField();
		str.setPromptText("Str");
		str.setLayoutX(40);
		str.setLayoutY(155);
		str.setPrefWidth(35);
		
		TextField dex = new TextField();
		dex.setPromptText("Dex");
		dex.setLayoutX(40);
		dex.setLayoutY(226);
		dex.setPrefWidth(35);
		
		TextField con = new TextField();
		con.setPromptText("Con");
		con.setLayoutX(40);
		con.setLayoutY(298);
		con.setPrefWidth(35);
		
		TextField intel = new TextField();
		intel.setPromptText("Int");
		intel.setLayoutX(40);
		intel.setLayoutY(370);
		intel.setPrefWidth(35);
		
		TextField wis = new TextField();
		wis.setPromptText("Wis");
		wis.setLayoutX(40);
		wis.setLayoutY(442);
		wis.setPrefWidth(35);
		
		TextField chr = new TextField();
		chr.setPromptText("Cha");
		chr.setLayoutX(40);
		chr.setLayoutY(514);
		chr.setPrefWidth(35);
		
		TextField armClass = new TextField();
		armClass.setPromptText("AC");
		armClass.setLayoutX(232);
		armClass.setLayoutY(142);
		armClass.setPrefWidth(30);
		
		
		thePane.getChildren().addAll(viewSheet,characterNameField,characterRaceField,charClassLevel,charAlign,charEXP,charBG,playerName,str,dex,con,intel,wis,chr,armClass);
		primaryStage.setScene(theScene);
		primaryStage.sizeToScene();
		primaryStage.show();
	}
}
