package view;

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
	private static int[] windowSize = {800,1200};
	private static Scene theScene = new Scene(bPane,windowSize[1],windowSize[0]);
	
	private static TextField characterNameField;
	
	public static String charNameGetter() {
		return characterNameField.getText();
	}
	
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
		
		characterNameField = new TextField();
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
		
		TextField perTraits = new TextField();
		perTraits.setPromptText("Personality Traits");
		perTraits.setLayoutX(420);
		perTraits.setLayoutY(140);
		perTraits.setPrefHeight(55);
		
		TextField perIdeals = new TextField();
		perIdeals.setPromptText("Ideals");
		perIdeals.setLayoutX(420);
		perIdeals.setLayoutY(207);
		perIdeals.setPrefHeight(45);
		
		TextField perBonds = new TextField();
		perBonds.setPromptText("Bonds");
		perBonds.setLayoutX(420);
		perBonds.setLayoutY(264);
		perBonds.setPrefHeight(45);
		
		TextField perFlaws = new TextField();
		perFlaws.setPromptText("Flaws");
		perFlaws.setLayoutX(420);
		perFlaws.setLayoutY(321);
		perFlaws.setPrefHeight(45);
		
		TextField additionalTraits = new TextField();
		additionalTraits.setPromptText("Additional Traits");
		additionalTraits.setLayoutX(410);
		additionalTraits.setLayoutY(380);
		additionalTraits.setPrefHeight(382);
		additionalTraits.setPrefWidth(170);
		
		TextField profBns = new TextField();
		profBns.setPromptText("Prof");
		profBns.setLayoutX(90);
		profBns.setLayoutY(165);
		profBns.setPrefWidth(35);
		
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
		
		TextField otherPnL = new TextField();
		otherPnL.setPromptText("Other Profficiencies and Languages");
		otherPnL.setLayoutX(35);
		otherPnL.setLayoutY(625);
		otherPnL.setPrefHeight(138);
		otherPnL.setPrefWidth(165);
		
		TextField equipment = new TextField();
		equipment.setPromptText("Equipment");
		equipment.setLayoutX(268);
		equipment.setLayoutY(590);
		equipment.setPrefHeight(173);
		equipment.setPrefWidth(115);
		
		
		TextField armClass = new TextField();
		armClass.setPromptText("AC");
		armClass.setLayoutX(232);
		armClass.setLayoutY(142);
		armClass.setPrefWidth(30);
		
		TextField spd = new TextField();
		spd.setPromptText("Spd");
		spd.setLayoutX(345);
		spd.setLayoutY(142);
		spd.setPrefWidth(35);
		
		TextField initiative = new TextField();
		initiative.setPromptText("Init");
		initiative.setLayoutX(285);
		initiative.setLayoutY(142);
		initiative.setPrefWidth(35);
		
		TextField hp = new TextField();
		hp.setPromptText("Hp");
		hp.setLayoutX(230);
		hp.setLayoutY(200);
		
		TextField tempHp = new TextField();
		tempHp.setPromptText("Temporary HP");
		tempHp.setLayoutX(230);
		tempHp.setLayoutY(270);
		
		TextField hd = new TextField();
		hd.setPromptText("Hit Dice");
		hd.setLayoutX(230);
		hd.setLayoutY(320);
		hd.setPrefWidth(65);
		
		
		//Sets an array for creating textfields within the equipment box for "currency" column
		//230 x, 590y (+30 for each iteration), 25 prefWidth 
		TextField[] currency = new TextField[5];
		int currencyY = 590;
		for(int i = 0; i < currency.length; i++)
		{
			currency[i] = new TextField();
			currency[i].setLayoutX(220);
			currency[i].setLayoutY(currencyY);
			currency[i].setPrefWidth(47);
			currencyY += 26;
		}
		
		//Sets an array for creating textfields within the attack box for "attack names" column
		//220 x, 385 y (+25 for each iteration), 70 prefWidth 
		TextField[] attackNames = new TextField[7];
		int atkNamesY = 385;
		for(int i = 0; i < attackNames.length; i++)
		{
			attackNames[i] = new TextField();
			attackNames[i].setPromptText("Atk Name");
			attackNames[i].setLayoutX(220);
			attackNames[i].setPrefWidth(70);
			attackNames[i].setLayoutY(atkNamesY);
			atkNamesY += 25;
		}
		
		//Sets an array for creating textfields within the attack box for "attack bonus" column
		//290 x, 385 y (+25 for each iteration), 32 prefWidth 
		TextField[] attackBonus = new TextField[7];
		int atkBnsY = 385;
		for(int i = 0; i < attackBonus.length; i++)
		{
			attackBonus[i] = new TextField();
			attackBonus[i].setPromptText("BNS");
			attackBonus[i].setLayoutX(290);
			attackBonus[i].setPrefWidth(32);
			attackBonus[i].setLayoutY(atkBnsY);
			atkBnsY += 25;
		}
		
		//Sets an array for creating textfields within the attack box for "attack damage" column
		//322 x, 385 y (+25 for each iteration), 70 prefWidth 
		TextField[] attackDamage = new TextField[7];
		int atkDmgY = 385;
		for(int i = 0; i < attackDamage.length; i++)
		{
			attackDamage[i] = new TextField();
			attackDamage[i].setPromptText("Atk Damage");
			attackDamage[i].setLayoutX(322);
			attackDamage[i].setPrefWidth(70);
			attackDamage[i].setLayoutY(atkDmgY);
			atkDmgY += 25;
		}
		
		thePane.getChildren().addAll(viewSheet,characterNameField,characterRaceField,charClassLevel,charAlign,charEXP,charBG,playerName,str,dex,con,intel,wis,chr,armClass,spd, initiative,hp,hd,profBns,tempHp,perTraits,perIdeals,perBonds,perFlaws,additionalTraits, otherPnL,equipment);
		
		//adds each individual TextField[] inside of attack box to screen, as the arrays are all the same size as each other
		for(int i = 0; i < attackNames.length; i++)
		{
			thePane.getChildren().addAll(attackNames[i],attackBonus[i],attackDamage[i]);
		}
		
		//adds TextField[] currency to screen as it is smaller than the other arrays
		for(int i = 0; i < currency.length; i++)
		{
			thePane.getChildren().add(currency[i]);
		}
		primaryStage.setScene(theScene);
		primaryStage.sizeToScene();
		primaryStage.show();
		
		
	}
}