package view;

import enums.Alignment;
import enums.Currency;
import enums.DiceSides;
import enums.PrimaryStat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.DungeonMasterUIController;
import logic.PlayerUIController;
import logic.RollDie;
import models.CharSheet;

public class Show {
	private BorderPane bPane = new BorderPane();
	private BorderPane bPane2 = new BorderPane();
	private Pane thePane = new Pane();
	private int[] windowSize = { 800, 1200 };
	private int[] windowSize2 = { 200, 415 };
	private Scene theScene = new Scene(bPane, windowSize[1], windowSize[0]);
	private Scene smallScene = new Scene(bPane2, windowSize2[1], windowSize2[0]);
	private static PlayerUIController pui;
	private static DungeonMasterUIController dui;

	private boolean isDone;
	private boolean isMilestone = false;
	private TextField characterNameField;
	private TextField characterRaceField;
	private ComboBox<String> charAlign;
	private TextField charEXP;
	private TextField charClass;
	private TextField charLevel;
	private TextField charBG;
	private TextField playerName;
	private TextField perTraits;
	private TextField perIdeals;
	private TextField perBonds;
	private TextField perFlaws;
	private TextField additionalTraits;
	private TextField profBns;
	private TextField str;
	private TextField dex;
	private TextField con;
	private TextField intel;
	private TextField wis;
	private TextField chr;
	private TextField otherPnL;
	private TextField equipment;
	private TextField armClass;
	private TextField spd;
	private TextField initiative;
	private TextField hp;
	private TextField tempHp;
	private TextField hd;
	private TextField[] currency;
	private TextField[] attackNames;
	private TextField[] attackBonus;
	private TextField[] attackDamage;
	private Button[] dcButtons;

	private ObservableList<String> alignlist = FXCollections.observableArrayList("Chaotic Evil", "Neutral Evil",
			"Lawful Evil", "Chaotic Neutral", "True Neutral", "Lawful Neutral", "Chaotic Good", "Neutral Good",
			"Lawful Good");

	// Initializes the Display of a fresh character sheet for new Character entry;
	// returns the character created by the field
	// (TextFields are defaulted at 150 length and 25 height)
	public void displayCleanCharacterSheet(Stage primaryStage) {
		bPane.setCenter(thePane);
		ImageView viewSheet = new ImageView();
		viewSheet.setImage(new Image("file:Character Sheet (Official) - Copy_Page_1.png", 790, 790, true, true));

		characterNameField = new TextField();
		characterNameField.setPromptText("Name");
		characterNameField.setLayoutY(59);
		characterNameField.setLayoutX(50);

		characterRaceField = new TextField();
		characterRaceField.setPromptText("Race");
		characterRaceField.setLayoutX(270);
		characterRaceField.setLayoutY(72);
		characterRaceField.setPrefWidth(100);

		charAlign = new ComboBox<String>();
		charAlign.setItems(alignlist);
		charAlign.setPromptText("Alignment");
		charAlign.setLayoutX(370);
		charAlign.setLayoutY(72);
		charAlign.setPrefWidth(120);

		charEXP = new TextField();
		charEXP.setPromptText("Exp/Milestone");
		charEXP.setLayoutX(490);
		charEXP.setLayoutY(72);
		charEXP.setPrefWidth(80);

		charClass = new TextField();
		charClass.setPromptText("Class");
		charClass.setLayoutX(270);
		charClass.setLayoutY(47);
		charClass.setPrefWidth(60);

		charLevel = new TextField();
		charLevel.setPromptText("Level");
		charLevel.setLayoutX(330);
		charLevel.setLayoutY(47);
		charLevel.setPrefWidth(40);

		charBG = new TextField();
		charBG.setPromptText("Background");
		charBG.setLayoutX(370);
		charBG.setLayoutY(47);
		charBG.setPrefWidth(100);

		playerName = new TextField();
		playerName.setPromptText("Player Name");
		playerName.setLayoutX(470);
		playerName.setLayoutY(47);
		playerName.setPrefWidth(100);

		perTraits = new TextField();
		perTraits.setPromptText("Personality Traits");
		perTraits.setLayoutX(420);
		perTraits.setLayoutY(140);
		perTraits.setPrefHeight(55);

		perIdeals = new TextField();
		perIdeals.setPromptText("Ideals");
		perIdeals.setLayoutX(420);
		perIdeals.setLayoutY(207);
		perIdeals.setPrefHeight(45);

		perBonds = new TextField();
		perBonds.setPromptText("Bonds");
		perBonds.setLayoutX(420);
		perBonds.setLayoutY(264);
		perBonds.setPrefHeight(45);

		perFlaws = new TextField();
		perFlaws.setPromptText("Flaws");
		perFlaws.setLayoutX(420);
		perFlaws.setLayoutY(321);
		perFlaws.setPrefHeight(45);

		additionalTraits = new TextField();
		additionalTraits.setPromptText("Additional Traits");
		additionalTraits.setLayoutX(410);
		additionalTraits.setLayoutY(380);
		additionalTraits.setPrefHeight(382);
		additionalTraits.setPrefWidth(170);

		profBns = new TextField();
		profBns.setPromptText("Prof");
		profBns.setLayoutX(90);
		profBns.setLayoutY(165);
		profBns.setPrefWidth(35);

		str = new TextField();
		str.setPromptText("Str");
		str.setLayoutX(40);
		str.setLayoutY(155);
		str.setPrefWidth(35);

		dex = new TextField();
		dex.setPromptText("Dex");
		dex.setLayoutX(40);
		dex.setLayoutY(226);
		dex.setPrefWidth(35);

		con = new TextField();
		con.setPromptText("Con");
		con.setLayoutX(40);
		con.setLayoutY(298);
		con.setPrefWidth(35);

		intel = new TextField();
		intel.setPromptText("Int");
		intel.setLayoutX(40);
		intel.setLayoutY(370);
		intel.setPrefWidth(35);

		wis = new TextField();
		wis.setPromptText("Wis");
		wis.setLayoutX(40);
		wis.setLayoutY(442);
		wis.setPrefWidth(35);

		chr = new TextField();
		chr.setPromptText("Cha");
		chr.setLayoutX(40);
		chr.setLayoutY(514);
		chr.setPrefWidth(35);

		otherPnL = new TextField();
		otherPnL.setPromptText("Other Profficiencies and Languages");
		otherPnL.setLayoutX(35);
		otherPnL.setLayoutY(625);
		otherPnL.setPrefHeight(138);
		otherPnL.setPrefWidth(165);

		equipment = new TextField();
		equipment.setPromptText("Equipment");
		equipment.setLayoutX(268);
		equipment.setLayoutY(590);
		equipment.setPrefHeight(173);
		equipment.setPrefWidth(115);

		armClass = new TextField();
		armClass.setPromptText("AC");
		armClass.setLayoutX(232);
		armClass.setLayoutY(142);
		armClass.setPrefWidth(30);

		spd = new TextField();
		spd.setPromptText("Spd");
		spd.setLayoutX(345);
		spd.setLayoutY(142);
		spd.setPrefWidth(35);

		initiative = new TextField();
		initiative.setPromptText("Init");
		initiative.setLayoutX(285);
		initiative.setLayoutY(142);
		initiative.setPrefWidth(35);

		hp = new TextField();
		hp.setPromptText("Hp");
		hp.setLayoutX(230);
		hp.setLayoutY(200);

		tempHp = new TextField();
		tempHp.setPromptText("Temporary HP");
		tempHp.setLayoutX(230);
		tempHp.setLayoutY(270);

		hd = new TextField();
		hd.setPromptText("Hit Dice");
		hd.setLayoutX(230);
		hd.setLayoutY(320);
		hd.setPrefWidth(65);

		// Sets an array for creating textfields within the equipment box for "currency"
		// column
		// 230 x, 590y (+30 for each iteration), 25 prefWidth
		currency = new TextField[5];
		int currencyY = 590;
		for (int i = 0; i < currency.length; i++) {
			currency[i] = new TextField();
			currency[i].setLayoutX(220);
			currency[i].setLayoutY(currencyY);
			currency[i].setPrefWidth(47);
			currencyY += 26;
		}

		// Sets an array for creating textfields within the attack box for "attack
		// names" column
		// 220 x, 385 y (+25 for each iteration), 70 prefWidth
		attackNames = new TextField[7];
		int atkNamesY = 385;
		for (int i = 0; i < attackNames.length; i++) {
			attackNames[i] = new TextField();
			attackNames[i].setPromptText("Atk Name");
			attackNames[i].setLayoutX(220);
			attackNames[i].setPrefWidth(70);
			attackNames[i].setLayoutY(atkNamesY);
			atkNamesY += 25;
		}

		// Sets an array for creating textfields within the attack box for "attack
		// bonus" column
		// 290 x, 385 y (+25 for each iteration), 32 prefWidth
		attackBonus = new TextField[7];
		int atkBnsY = 385;
		for (int i = 0; i < attackBonus.length; i++) {
			attackBonus[i] = new TextField();
			attackBonus[i].setPromptText("BNS");
			attackBonus[i].setLayoutX(290);
			attackBonus[i].setPrefWidth(32);
			attackBonus[i].setLayoutY(atkBnsY);
			atkBnsY += 25;
		}

		// Sets an array for creating textfields within the attack box for "attack
		// damage" column
		// 322 x, 385 y (+25 for each iteration), 70 prefWidth
		attackDamage = new TextField[7];
		int atkDmgY = 385;
		for (int i = 0; i < attackDamage.length; i++) {
			attackDamage[i] = new TextField();
			attackDamage[i].setPromptText("Atk Damage");
			attackDamage[i].setLayoutX(322);
			attackDamage[i].setPrefWidth(70);
			attackDamage[i].setLayoutY(atkDmgY);
			atkDmgY += 25;
		}

		DiceSides[] sides = DiceSides.values();
		int sidesY = 300;
		boolean left = true;
		dcButtons = new Button[sides.length];
		for (int i = 0; i < dcButtons.length; i++) {
			dcButtons[i] = new Button();
			dcButtons[i].setText(sides[i].toString());
			if (left) {
				dcButtons[i].setLayoutX(615);
				sidesY += 25;
				dcButtons[i].setLayoutY(sidesY);
				dcButtons[i].setMinWidth(75);
			} else {
				dcButtons[i].setLayoutX(690);
				dcButtons[i].setLayoutY(sidesY);
				dcButtons[i].setMinWidth(75);
			}
			DiceSides s = sides[i];
			dcButtons[i].setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					displayDice(s, primaryStage);
				}
			});
			left = !left;
			thePane.getChildren().add(dcButtons[i]);
		}

		thePane.getChildren().addAll(viewSheet, characterNameField, characterRaceField, charClass, charLevel, charAlign,
				charEXP, charBG, playerName, str, dex, con, intel, wis, chr, armClass, spd, initiative, hp, hd, profBns,
				tempHp, perTraits, perIdeals, perBonds, perFlaws, additionalTraits, otherPnL, equipment);

		// adds each individual TextField[] inside of attack box to screen, as the
		// arrays are all the same size as each other
		for (int i = 0; i < attackNames.length; i++) {
			thePane.getChildren().addAll(attackNames[i], attackBonus[i], attackDamage[i]);
		}

		// adds TextField[] currency to screen as it is smaller than the other arrays
		for (TextField element : currency) {
			thePane.getChildren().add(element);
		}
		primaryStage.setScene(theScene);
		primaryStage.sizeToScene();
		primaryStage.show();
		exitButton(primaryStage);
	}

	Text diceFace = new Text();

	public void displayDice(DiceSides ds, Stage primaryStage) {
		Circle c = new Circle(900, 400, 75, Paint.valueOf("Purple"));
		RollDie rd = new RollDie();

		thePane.getChildren().remove(diceFace);
		diceFace.setText("" + rd.roll(ds));
		diceFace.setLayoutX(845);
		diceFace.setLayoutY(430);
		diceFace.setFont(Font.font("Verdana", 90));
		// diceFace.setScaleX(4);
		// diceFace.setScaleY(4);
		diceFace.setFill(Color.WHITESMOKE);
		diceFace.setStroke(Color.BLACK);
		thePane.getChildren().addAll(c, diceFace);
		primaryStage.setScene(theScene);
		primaryStage.sizeToScene();
		primaryStage.show();
	}

	// Takes in a character and displays available data based on that character
	// the boolean that is passed in affects whether the text boxes can be edited or
	// note
	public void displayFilledCharacterSheet(Stage primaryStage, CharSheet c, boolean canEdit) {
		ImageView viewSheet = new ImageView();
		viewSheet.setImage(new Image("file:Character Sheet (Official) - Copy_Page_1.png", 790, 790, true, true));

		characterNameField = new TextField(c.getCharacterName());
		characterNameField.setEditable(canEdit);
		characterNameField.setLayoutY(59);
		characterNameField.setLayoutX(50);

		characterRaceField = new TextField(c.getRace());
		characterRaceField.setEditable(canEdit);
		characterRaceField.setLayoutX(270);
		characterRaceField.setLayoutY(72);
		characterRaceField.setPrefWidth(100);

		charAlign = new ComboBox<String>();
		charAlign.setValue(getCharAlign().toString());
		charAlign.setEditable(canEdit);
		charAlign.setLayoutX(370);
		charAlign.setLayoutY(72);
		charAlign.setPrefWidth(100);

		charEXP = new TextField("" + c.getXp());
		charEXP.setEditable(canEdit);
		charEXP.setLayoutX(470);
		charEXP.setLayoutY(72);
		charEXP.setPrefWidth(100);

		charClass = new TextField(c.getOccupation());
		charClass.setEditable(canEdit);
		charClass.setLayoutX(270);
		charClass.setLayoutY(47);
		charClass.setPrefWidth(60);

		charLevel = new TextField("" + c.getLevel());
		charLevel.setEditable(canEdit);
		charLevel.setLayoutX(330);
		charLevel.setLayoutY(47);
		charLevel.setPrefWidth(40);

		charBG = new TextField(c.getBackground());
		charBG.setEditable(canEdit);
		charBG.setLayoutX(370);
		charBG.setLayoutY(47);
		charBG.setPrefWidth(100);

		playerName = new TextField(c.getPlayerName());
		playerName.setEditable(canEdit);
		playerName.setLayoutX(470);
		playerName.setLayoutY(47);
		playerName.setPrefWidth(100);

		perTraits = new TextField(c.getOtherData("Personality Traits"));
		perTraits.setEditable(canEdit);
		perTraits.setLayoutX(420);
		perTraits.setLayoutY(140);
		perTraits.setPrefHeight(55);

		perIdeals = new TextField(c.getOtherData("Ideals"));
		perIdeals.setEditable(canEdit);
		perIdeals.setLayoutX(420);
		perIdeals.setLayoutY(207);
		perIdeals.setPrefHeight(45);

		perBonds = new TextField(c.getOtherData("Bonds"));
		perBonds.setEditable(canEdit);
		perBonds.setLayoutX(420);
		perBonds.setLayoutY(264);
		perBonds.setPrefHeight(45);

		perFlaws = new TextField(c.getOtherData("Flaws"));
		perFlaws.setEditable(canEdit);
		perFlaws.setLayoutX(420);
		perFlaws.setLayoutY(321);
		perFlaws.setPrefHeight(45);

		additionalTraits = new TextField(c.getOtherData("Additional Traits"));
		additionalTraits.setEditable(canEdit);
		additionalTraits.setLayoutX(410);
		additionalTraits.setLayoutY(380);
		additionalTraits.setPrefHeight(382);
		additionalTraits.setPrefWidth(170);

		profBns = new TextField();
		profBns.setEditable(canEdit);
		profBns.setLayoutX(90);
		profBns.setLayoutY(165);
		profBns.setPrefWidth(35);

		str = new TextField("" + c.getStats(PrimaryStat.STRENGTH));
		characterNameField.setEditable(canEdit);

		str = new TextField("" + c.getStats(PrimaryStat.STRENGTH));
		str.setEditable(canEdit);
		str.setLayoutX(40);
		str.setLayoutY(155);
		str.setPrefWidth(35);

		dex = new TextField("" + c.getStats(PrimaryStat.DEXTERITY));
		characterNameField.setEditable(canEdit);
		dex = new TextField("" + c.getStats(PrimaryStat.DEXTERITY));
		dex.setEditable(canEdit);
		dex.setLayoutX(40);
		dex.setLayoutY(226);
		dex.setPrefWidth(35);

		con = new TextField("" + c.getStats(PrimaryStat.CONSTITUTION));
		characterNameField.setEditable(canEdit);
		con = new TextField("" + c.getStats(PrimaryStat.CONSTITUTION));
		con.setEditable(canEdit);

		con.setLayoutX(40);
		con.setLayoutY(298);
		con.setPrefWidth(35);

		intel = new TextField("" + c.getStats(PrimaryStat.INTELLIGENCE));
		characterNameField.setEditable(canEdit);
		intel = new TextField("" + c.getStats(PrimaryStat.INTELLIGENCE));
		intel.setEditable(canEdit);
		intel.setLayoutX(40);
		intel.setLayoutY(370);
		intel.setPrefWidth(35);

		wis = new TextField("" + c.getStats(PrimaryStat.WISDOM));
		characterNameField.setEditable(canEdit);
		wis = new TextField("" + c.getStats(PrimaryStat.WISDOM));
		wis.setEditable(canEdit);
		wis.setLayoutX(40);
		wis.setLayoutY(442);
		wis.setPrefWidth(35);

		chr = new TextField("" + c.getStats(PrimaryStat.CHARISMA));
		characterNameField.setEditable(canEdit);
		chr = new TextField("" + c.getStats(PrimaryStat.CHARISMA));
		chr.setEditable(canEdit);
		chr.setLayoutX(40);
		chr.setLayoutY(514);
		chr.setPrefWidth(35);

		otherPnL = new TextField(c.getOtherData("Other Profficiencies and Languages"));
		otherPnL.setEditable(canEdit);
		otherPnL.setLayoutX(35);
		otherPnL.setLayoutY(625);
		otherPnL.setPrefHeight(138);
		otherPnL.setPrefWidth(165);

		equipment = new TextField();
		equipment.setEditable(canEdit);
		equipment.setLayoutX(268);
		equipment.setLayoutY(590);
		equipment.setPrefHeight(173);
		equipment.setPrefWidth(115);

		armClass = new TextField("" + c.getStats(PrimaryStat.ARMOR_CLASS));
		characterNameField.setEditable(canEdit);
		armClass = new TextField("" + c.getStats(PrimaryStat.ARMOR_CLASS));
		armClass.setEditable(canEdit);
		armClass.setLayoutX(232);
		armClass.setLayoutY(142);
		armClass.setPrefWidth(30);

		spd = new TextField("" + c.getStats(PrimaryStat.SPEED));
		characterNameField.setEditable(canEdit);
		spd = new TextField("" + c.getStats(PrimaryStat.SPEED));
		spd.setEditable(canEdit);
		spd.setLayoutX(345);
		spd.setLayoutY(142);
		spd.setPrefWidth(35);

		initiative = new TextField();
		initiative.setEditable(canEdit);
		initiative.setLayoutX(285);
		initiative.setLayoutY(142);
		initiative.setPrefWidth(35);

		hp = new TextField("" + c.getStats(PrimaryStat.MAX_HEALTH));
		characterNameField.setEditable(canEdit);
		hp = new TextField("" + c.getStats(PrimaryStat.MAX_HEALTH));
		hp.setEditable(canEdit);
		hp.setLayoutX(230);
		hp.setLayoutY(200);

		tempHp = new TextField();
		tempHp.setEditable(canEdit);
		tempHp.setLayoutX(230);
		tempHp.setLayoutY(270);

		hd = new TextField();
		hd.setEditable(canEdit);
		hd.setLayoutX(230);
		hd.setLayoutY(320);
		hd.setPrefWidth(65);

		// Sets an array for creating textfields within the equipment box for "currency"
		// column
		// 230 x, 590y (+30 for each iteration), 25 prefWidth
		currency = new TextField[5];
		int currencyY = 590;
		for (int i = 0; i < currency.length; i++) {
			int x = 0;
			String xType;
			if (i == 0) {
				x = c.getMoney(Currency.CP);
				xType = Currency.CP.toString();
			} else if (i == 1) {
				x = c.getMoney(Currency.SP);
				xType = Currency.SP.toString();
			} else if (i == 2) {
				x = c.getMoney(Currency.GP);
				xType = Currency.GP.toString();
			} else if (i == 3) {
				x = c.getMoney(Currency.PP);
				xType = Currency.PP.toString();
			} else {
				x = c.getMoney(Currency.EP);
				xType = Currency.EP.toString();
			}
			currency[i] = new TextField(x + " " + xType);
			currency[i].setEditable(canEdit);
			currency[i].setLayoutX(220);
			currency[i].setLayoutY(currencyY);
			currency[i].setPrefWidth(47);
			currencyY += 26;
		}

		// Sets an array for creating textfields within the attack box for "attack
		// names" column
		// 220 x, 385 y (+25 for each iteration), 70 prefWidth
		attackNames = new TextField[7];
		int atkNamesY = 385;
		for (int i = 0; i < attackNames.length; i++) {
			attackNames[i] = new TextField();
			attackNames[i].setEditable(canEdit);
			attackNames[i].setLayoutX(220);
			attackNames[i].setPrefWidth(70);
			attackNames[i].setLayoutY(atkNamesY);
			atkNamesY += 25;
		}

		// Sets an array for creating textfields within the attack box for "attack
		// bonus" column
		// 290 x, 385 y (+25 for each iteration), 32 prefWidth
		attackBonus = new TextField[7];
		int atkBnsY = 385;
		for (int i = 0; i < attackBonus.length; i++) {
			attackBonus[i] = new TextField();
			attackBonus[i].setEditable(canEdit);
			attackBonus[i].setLayoutX(290);
			attackBonus[i].setPrefWidth(32);
			attackBonus[i].setLayoutY(atkBnsY);
			atkBnsY += 25;
		}

		// Sets an array for creating textfields within the attack box for "attack
		// damage" column
		// 322 x, 385 y (+25 for each iteration), 70 prefWidth
		attackDamage = new TextField[7];
		int atkDmgY = 385;
		for (int i = 0; i < attackDamage.length; i++) {
			attackDamage[i] = new TextField();
			attackDamage[i].setEditable(canEdit);
			attackDamage[i].setLayoutX(322);
			attackDamage[i].setPrefWidth(70);
			attackDamage[i].setLayoutY(atkDmgY);
			atkDmgY += 25;
		}

		DiceSides[] sides = DiceSides.values();
		int sidesY = 0;
		dcButtons = new Button[sides.length];
		for (int i = 0; i < dcButtons.length; i++) {
			dcButtons[i] = new Button();
			dcButtons[i].setText(sides[i].toString());
			dcButtons[i].setLayoutX(615);
			dcButtons[i].setLayoutY(sidesY);
			DiceSides s = sides[i];
			dcButtons[i].setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					displayDice(s, primaryStage);
				}
			});
			sidesY += 25;
			thePane.getChildren().add(dcButtons[i]);
		}

		thePane.getChildren().addAll(viewSheet, characterNameField, characterRaceField, charClass, charLevel, charAlign,
				charEXP, charBG, playerName, str, dex, con, intel, wis, chr, armClass, spd, initiative, hp, hd, profBns,
				tempHp, perTraits, perIdeals, perBonds, perFlaws, additionalTraits, otherPnL, equipment);

		// adds each individual TextField[] inside of attack box to screen, as the
		// arrays are all the same size as each other
		for (int i = 0; i < attackNames.length; i++) {
			thePane.getChildren().addAll(attackNames[i], attackBonus[i], attackDamage[i]);
		}

		// adds TextField[] currency to screen as it is smaller than the other arrays
		for (TextField element : currency) {
			thePane.getChildren().add(element);
		}
		primaryStage.setScene(theScene);
		primaryStage.sizeToScene();
		primaryStage.show();
		exitButton(primaryStage);
	}

	public void displayMainMenu(Stage primaryStage) {
		bPane2.setCenter(thePane);
		Button pm = new Button();
		pm.setScaleX(3);
		pm.setScaleY(3);
		Button dm = new Button();
		dm.setScaleX(3);
		dm.setScaleY(3);

		pm.setLayoutX(175);
		dm.setLayoutX(142);

		pm.setLayoutY(50);
		dm.setLayoutY(130);

		pm.setText("Player Menu");
		dm.setText("Dungeon Master Menu");

		pm.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				displayPlayerMenu(primaryStage);
			}
		});
		dm.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				thePane.getChildren().clear();
			}
		});

		thePane.getChildren().addAll(pm, dm);
		primaryStage.setScene(smallScene);
		primaryStage.sizeToScene();
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public void displayPlayerMenu(Stage primaryStage) {
		bPane2.setCenter(thePane);
		Button newChar = new Button();
		newChar.setScaleX(3);
		newChar.setScaleY(3);
		Button editChar = new Button();
		editChar.setScaleX(3);
		editChar.setScaleY(3);

		newChar.setLayoutX(175);
		editChar.setLayoutX(142);

		newChar.setLayoutY(50);
		editChar.setLayoutY(130);

		// newChar.setLayoutX(600);
		// editChar.setLayoutX(600);
		//
		// newChar.setLayoutY(400);
		// editChar.setLayoutY(425);

		newChar.setText("Create Character");
		editChar.setText("Edit Existing Character");

		newChar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				thePane.getChildren().clear();
				displayCleanCharacterSheet(primaryStage);
				Button saveBut = new Button();
				saveBut.setText("Save Character");
				saveBut.setLayoutX(650);
				saveBut.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {
						CharSheet cs = pui.createCharacter(primaryStage);
						pui.saveCharSheet(cs, "./", "dad");
					}
				});
			}
		});
		editChar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				TextField theChar = new TextField();
				theChar.setPromptText("Enter name of the character you wish to load");
				theChar.setLayoutX(600);
				theChar.setLayoutY(400);
				theChar.setPrefWidth(300);
				displayFilledCharacterSheet(primaryStage, pui.loadCharSheet("./", theChar.getText(), "dad"), true);
			}
		});

		thePane.getChildren().addAll(newChar, editChar);
		primaryStage.setScene(smallScene);
		primaryStage.sizeToScene();
		primaryStage.show();
		exitButton(primaryStage);
	}

	public void displayDMMenu(Stage primaryStage) {

		Button saveRule = new Button();
		Button loadRule = new Button();
		TextField ruleText = new TextField();

		ruleText.setPromptText("Enter Rules and Notes here");
		ruleText.setLayoutX(35);
		ruleText.setLayoutY(625);
		ruleText.setPrefHeight(138);
		ruleText.setPrefWidth(165);

		saveRule.setLayoutX(600);
		loadRule.setLayoutX(600);

		saveRule.setLayoutY(400);
		loadRule.setLayoutY(425);

		saveRule.setText("Save Rules");
		loadRule.setText("Load Rules");

		saveRule.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				dui.saveRules("./", "encryptKey");
			}
		});
		loadRule.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {

			}
		});

		thePane.getChildren().addAll(saveRule, loadRule, ruleText);
		primaryStage.setScene(smallScene);
		primaryStage.sizeToScene();
		primaryStage.show();
		exitButton(primaryStage);
	}

	public boolean getMilestone() {
		return true;
	}

	public String getCharacterNameField() {
		return characterNameField.getText();
	}

	public String getCharacterRaceField() {
		return characterRaceField.getText();
	}

	public Alignment getCharAlign() {
		for (Alignment a : Alignment.values()) {
			if (a.toString().equalsIgnoreCase(charAlign.getValue().toString())) {
				return a;
			}
		}
		return null;
	}

	public int getCharEXP() {
		int returnXP = Integer.parseInt(charEXP.getText());
		return returnXP;
	}

	public String getCharClass() {
		return charClass.getText();
	}

	public int getCharLevel() {
		return Integer.parseInt(charLevel.getText());
	}

	public String getCharBG() {
		return charBG.getText();
	}

	public int[] getCurrency() {
		int[] charCurrency = new int[currency.length];
		for (int i = 0; i < charCurrency.length; i++) {
			charCurrency[i] = Integer.parseInt(currency.toString());
		}
		return charCurrency;
	}

	public int getChr() {
		int Chr = Integer.parseInt(chr.getText());
		return Chr;
	}

	public int getCon() {
		int Con = Integer.parseInt(con.getText());
		return Con;
	}

	public int getDex() {
		int Dex = Integer.parseInt(dex.getText());
		return Dex;
	}

	public String getEquipment() {
		return equipment.getText();
	}

	public int getArmClass() {
		int armorClass = Integer.parseInt(armClass.getText());
		return armorClass;
	}

	public int getHd() {
		int MaxHp = Integer.parseInt(hd.getText());
		return MaxHp;
	}

	public int getMaxHp() {
		int MaxHealth = Integer.parseInt(hp.getText());
		return MaxHealth;
	}

	public int getInitiative() {
		int Init = Integer.parseInt(initiative.getText());
		return Init;
	}

	public int getIntel() {
		int Intelligence = Integer.parseInt(intel.getText());
		return Intelligence;
	}

	public String getOtherPnL() {
		return otherPnL.getText();
	}

	public String getPerBonds() {
		return perBonds.getText();
	}

	public String getPerFlaws() {
		return perFlaws.getText();
	}

	public String getPerIdeals() {
		return perIdeals.getText();
	}

	public String getPerTraits() {
		return perTraits.getText();
	}

	public String getPlayerName() {
		return playerName.getText();
	}

	public int getProfBns() {
		int ProfBns = Integer.parseInt(profBns.getText());
		return ProfBns;
	}

	public int getSpd() {
		int Spd = Integer.parseInt(spd.getText());
		return Spd;
	}

	public int getStr() {
		int Str = Integer.parseInt(str.getText());
		return Str;
	}

	public int getTempHp() {
		int TempHp = Integer.parseInt(tempHp.getText());
		return TempHp;
	}

	public int getWis() {
		int Wis = Integer.parseInt(wis.getText());
		return Wis;
	}

	public String getItems() {
		return equipment.getText();
	}

	public void exitButton(Stage primaryStage) {

		Button exit = new Button();
		exit.setLayoutX(1100);
		exit.setText("Exit");
		exit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				thePane.getChildren().clear();
				setIsDone(true);
			}
		});
		thePane.getChildren().add(exit);
		primaryStage.setScene(theScene);
		primaryStage.sizeToScene();
		primaryStage.show();
	}

	public void setIsDone(boolean bah) {
		isDone = bah;
	}

	// Initializes the GUI Display by setting up window and adds buttons
	// that call the Logic methods for Player menu and DM Menu
	public void initDnDinatorDisplay(Stage primaryStage) {
		bPane.setCenter(thePane);
		primaryStage.setTitle("DnDinator");
		primaryStage.setScene(theScene);
		primaryStage.show();
	}
}
