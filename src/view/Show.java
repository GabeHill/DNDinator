package view;

import java.util.LinkedList;

import enums.Alignment;
import enums.Currency;
import enums.DiceSides;
import enums.PrimaryStat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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
import models.GameData;

public class Show {
	private BorderPane bPane = new BorderPane();
	// private BorderPane bPane2 = new BorderPane();
	private Pane thePane = new Pane();
	private int[] windowSize = { 800, 1200 };
	// private int[] windowSize2 = { 200, 415 };
	private Scene theScene = new Scene(bPane, windowSize[1], windowSize[0]);
	// private Scene smallScene = new Scene(bPane2, windowSize2[1], windowSize2[0]);
	private Text diceFace = new Text();
	private CheckBox isMilestoneCheck = new CheckBox("Milestone Levelling");
	private TextField characterNameField = new TextField();
	private TextField characterRaceField = new TextField();
	private ComboBox<String> charAlign = new ComboBox<>();
	private TextField charEXP = new TextField();
	private TextField charClass = new TextField();
	private TextField charLevel = new TextField();
	private TextField charBG = new TextField();
	private TextField playerName = new TextField();
	private TextArea perTraits = new TextArea();
	private TextArea perIdeals = new TextArea();
	private TextArea perBonds = new TextArea();
	private TextArea perFlaws = new TextArea();
	private TextArea additionalTraits = new TextArea();
	private TextField profBns = new TextField();
	private TextField str = new TextField();
	private TextField dex = new TextField();
	private TextField con = new TextField();
	private TextField intel = new TextField();
	private TextField wis = new TextField();
	private TextField chr = new TextField();
	private TextArea otherPnL = new TextArea();
	private TextArea equipment = new TextArea();
	private TextField armClass = new TextField();
	private TextField spd = new TextField();
	private TextField initiative = new TextField();
	private TextField hp = new TextField();
	private TextField tempHp = new TextField();
	private TextField hd = new TextField();
	private TextField[] currency = new TextField[] { new TextField(), new TextField(), new TextField(), new TextField(),
			new TextField() };
	private TextField[] attackNames = new TextField[] { new TextField(), new TextField(), new TextField(),
			new TextField(), new TextField(), new TextField(), new TextField() };
	private TextField[] attackBonus = new TextField[] { new TextField(), new TextField(), new TextField(),
			new TextField(), new TextField(), new TextField(), new TextField() };
	private TextField[] attackDamage = new TextField[] { new TextField(), new TextField(), new TextField(),
			new TextField(), new TextField(), new TextField(), new TextField() };
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

		// characterNameField = new TextField();
		characterNameField.setPromptText("Name");
		characterNameField.setLayoutY(59);
		characterNameField.setLayoutX(50);

		// characterRaceField = new TextField();
		characterRaceField.setPromptText("Race");
		characterRaceField.setLayoutX(270);
		characterRaceField.setLayoutY(72);
		characterRaceField.setPrefWidth(100);

		// charAlign = new ComboBox<>();
		charAlign.setItems(alignlist);
		charAlign.setPromptText("Alignment");
		charAlign.setLayoutX(370);
		charAlign.setLayoutY(72);
		charAlign.setPrefWidth(120);

		// charEXP = new TextField();
		charEXP.setPromptText("Exp");
		charEXP.setLayoutX(490);
		charEXP.setLayoutY(72);
		charEXP.setPrefWidth(80);

		// isMilestoneCheck = new CheckBox("Milestone Levelling");
		isMilestoneCheck.setLayoutY(105);
		isMilestoneCheck.setLayoutX(475);

		// charClass = new TextField();
		charClass.setPromptText("Class");
		charClass.setLayoutX(270);
		charClass.setLayoutY(47);
		charClass.setPrefWidth(60);

		// charLevel = new TextField();
		charLevel.setPromptText("Level");
		charLevel.setLayoutX(330);
		charLevel.setLayoutY(47);
		charLevel.setPrefWidth(40);

		// charBG = new TextField();
		charBG.setPromptText("Background");
		charBG.setLayoutX(370);
		charBG.setLayoutY(47);
		charBG.setPrefWidth(100);

		// playerName = new TextField();
		playerName.setPromptText("Player Name");
		playerName.setLayoutX(470);
		playerName.setLayoutY(47);
		playerName.setPrefWidth(100);

		// perTraits = new TextField();
		perTraits.setPromptText("Personality Traits");
		perTraits.setWrapText(true);
		perTraits.setMaxWidth(148);
		perTraits.setLayoutX(420);
		perTraits.setLayoutY(140);
		perTraits.setPrefHeight(55);

		// perIdeals = new TextField();
		perIdeals.setPromptText("Ideals");
		perIdeals.setWrapText(true);
		perIdeals.setMaxWidth(148);
		perIdeals.setLayoutX(420);
		perIdeals.setLayoutY(207);
		perIdeals.setPrefHeight(45);

		// perBonds = new TextField();
		perBonds.setPromptText("Bonds");
		perBonds.setWrapText(true);
		perBonds.setMaxWidth(148);
		perBonds.setLayoutX(420);
		perBonds.setLayoutY(264);
		perBonds.setPrefHeight(45);

		// perFlaws = new TextField();
		perFlaws.setPromptText("Flaws");
		perFlaws.setWrapText(true);
		perFlaws.setMaxWidth(148);
		perFlaws.setLayoutX(420);
		perFlaws.setLayoutY(321);
		perFlaws.setPrefHeight(45);

		// additionalTraits = new TextField();
		additionalTraits.setPromptText("Additional Traits");
		additionalTraits.setWrapText(true);
		additionalTraits.setMaxWidth(165);
		additionalTraits.setLayoutX(410);
		additionalTraits.setLayoutY(380);
		additionalTraits.setPrefHeight(382);
		additionalTraits.setPrefWidth(170);

		// profBns = new TextField();
		profBns.setPromptText("Prof");
		profBns.setLayoutX(90);
		profBns.setLayoutY(165);
		profBns.setPrefWidth(35);

		// str = new TextField();
		
		//** here
		str.setPromptText("Str");
		str.setLayoutX(40);
		str.setLayoutY(155);
		str.setPrefWidth(35);

		// dex = new TextField();
		dex.setPromptText("Dex");
		dex.setLayoutX(40);
		dex.setLayoutY(226);
		dex.setPrefWidth(35);

		// con = new TextField();
		con.setPromptText("Con");
		con.setLayoutX(40);
		con.setLayoutY(298);
		con.setPrefWidth(35);

		// intel = new TextField();
		intel.setPromptText("Int");
		intel.setLayoutX(40);
		intel.setLayoutY(370);
		intel.setPrefWidth(35);

		// wis = new TextField();
		wis.setPromptText("Wis");
		wis.setLayoutX(40);
		wis.setLayoutY(442);
		wis.setPrefWidth(35);

		// chr = new TextField();
		chr.setPromptText("Cha");
		chr.setLayoutX(40);
		chr.setLayoutY(514);
		chr.setPrefWidth(35);

		// otherPnL = new TextField();
		otherPnL.setPromptText("Other Profficiencies and Languages");
		otherPnL.setWrapText(true);
		otherPnL.setLayoutX(35);
		otherPnL.setLayoutY(625);
		otherPnL.setPrefHeight(138);
		otherPnL.setPrefWidth(165);

		// equipment = new TextField();
		equipment.setPromptText("Equipment");
		equipment.setWrapText(true);
		equipment.setLayoutX(268);
		equipment.setLayoutY(590);
		equipment.setPrefHeight(173);
		equipment.setPrefWidth(115);

		// armClass = new TextField();
		armClass.setPromptText("AC");
		armClass.setLayoutX(232);
		armClass.setLayoutY(142);
		armClass.setPrefWidth(30);

		// spd = new TextField();
		spd.setPromptText("Spd");
		spd.setLayoutX(345);
		spd.setLayoutY(142);
		spd.setPrefWidth(35);

		// initiative = new TextField();
		initiative.setPromptText("Init");
		initiative.setLayoutX(285);
		initiative.setLayoutY(142);
		initiative.setPrefWidth(35);

		// hp = new TextField();
		hp.setPromptText("Hp");
		hp.setLayoutX(230);
		hp.setLayoutY(200);

		// tempHp = new TextField();
		tempHp.setPromptText("Temporary HP");
		tempHp.setLayoutX(230);
		tempHp.setLayoutY(270);

		// hd = new TextField();
		hd.setPromptText("Hit Dice");
		hd.setLayoutX(230);
		hd.setLayoutY(320);
		hd.setPrefWidth(65);

		// Sets an array for creating textfields within the equipment box for "currency"
		// column
		// 230 x, 590y (+30 for each iteration), 25 prefWidth
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
		// attackNames = new TextField[7];
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
		// attackBonus = new TextField[7];
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
		// attackDamage = new TextField[7];
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

		Button saveBut = new Button();
		saveBut.setText("Save Character");
		saveBut.setLayoutX(650);
		saveBut.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				CharSheet cs = PlayerUIController.createCharacter(primaryStage);
				PlayerUIController.saveCharSheet(cs, "./", "dad");
			}
		});

		thePane.getChildren().addAll(viewSheet, characterNameField, characterRaceField, charClass, charLevel, charAlign,
				charEXP, isMilestoneCheck, charBG, playerName, str, dex, con, intel, wis, chr, armClass, spd,
				initiative, hp, hd, profBns, tempHp, perTraits, perIdeals, perBonds, perFlaws, additionalTraits,
				otherPnL, equipment, saveBut);

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

	public void displayDice(DiceSides ds, Stage primaryStage) {
		Circle c = new Circle(900, 400, 75, Paint.valueOf("Purple"));
		thePane.getChildren().remove(diceFace);
		diceFace.setText("" + RollDie.roll(ds));
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
		thePane.getChildren().clear();
		ImageView viewSheet = new ImageView();
		viewSheet.setImage(new Image("file:Character Sheet (Official) - Copy_Page_1.png", 790, 790, true, true));

		// characterNameField = new TextField(c.getCharacterName());

		characterNameField.setPromptText("Name");
		characterNameField.setText(c.getCharacterName());
		characterNameField.setEditable(canEdit);
		characterNameField.setLayoutY(59);
		characterNameField.setLayoutX(50);

		// characterRaceField = new TextField(c.getRace());
		characterRaceField.setPromptText("Race");
		characterRaceField.setText(c.getRace());
		characterRaceField.setEditable(canEdit);
		characterRaceField.setLayoutX(270);
		characterRaceField.setLayoutY(72);
		characterRaceField.setPrefWidth(100);

		// charAlign = new ComboBox<>();
		charAlign.setPromptText("Alignment");
		charAlign.setValue(getCharAlign().toString());
		charAlign.setEditable(canEdit);
		charAlign.setLayoutX(370);
		charAlign.setLayoutY(72);
		charAlign.setPrefWidth(100);

		// charEXP = new TextField("" + c.getXp());

		charEXP.setPromptText("Exp");
		charEXP.setText("" + c.getXp());
		charEXP.setEditable(canEdit);
		charEXP.setLayoutX(470);
		charEXP.setLayoutY(72);
		charEXP.setPrefWidth(100);

		isMilestoneCheck.setSelected(c.isMilestoneLeveling());
		isMilestoneCheck.setLayoutY(105);
		isMilestoneCheck.setLayoutX(475);

		// charClass = new TextField(c.getOccupation());

		charClass.setPromptText("Class");
		charClass.setText(c.getOccupation());
		charClass.setEditable(canEdit);
		charClass.setLayoutX(270);
		charClass.setLayoutY(47);
		charClass.setPrefWidth(60);

		// charLevel = new TextField("" + c.getLevel());

		charLevel.setPromptText("Level");
		charLevel.setText("" + c.getLevel());
		charLevel.setEditable(canEdit);
		charLevel.setLayoutX(330);
		charLevel.setLayoutY(47);
		charLevel.setPrefWidth(40);

		// charBG = new TextField("" + c.getBackground());

		charBG.setPromptText("Background");
		charBG.setText("" + c.getBackground());
		charBG.setEditable(canEdit);
		charBG.setLayoutX(370);
		charBG.setLayoutY(47);
		charBG.setPrefWidth(100);
		

		playerName.setPromptText("Player Name");
		playerName.setText(c.getPlayerName());
		playerName.setEditable(canEdit);
		playerName.setLayoutX(470);
		playerName.setLayoutY(47);
		playerName.setPrefWidth(100);

		// perTraits = new TextField(c.getOtherData("Personality Traits"));

		perTraits.setPromptText("Personality Traits");
		perTraits.setText(c.getOtherData("Traits"));
		perTraits.setWrapText(true);
		perTraits.setPrefWidth(148);
		perTraits.setEditable(canEdit);
		perTraits.setLayoutX(420);
		perTraits.setLayoutY(140);
		perTraits.setPrefHeight(55);

		// perIdeals = new TextField(c.getOtherData("Ideals"));
		perIdeals.setPromptText("Ideals");
		perIdeals.setText(c.getOtherData("Ideals"));
		perIdeals.setWrapText(true);
		perIdeals.setPrefWidth(148);
		perIdeals.setEditable(canEdit);
		perIdeals.setLayoutX(420);
		perIdeals.setLayoutY(207);
		perIdeals.setPrefHeight(45);

		// perBonds = new TextField(c.getOtherData("Bonds"));

		perBonds.setPromptText("Bonds");
		perBonds.setText(c.getOtherData("Bonds"));
		perBonds.setWrapText(true);
		perBonds.setPrefWidth(148);
		perBonds.setEditable(canEdit);
		perBonds.setLayoutX(420);
		perBonds.setLayoutY(264);
		perBonds.setPrefHeight(45);

		// perFlaws = new TextField(c.getOtherData("Flaws"));

		perFlaws.setPromptText("Flaws");
		perFlaws.setText(c.getOtherData("Flaws"));
		perFlaws.setWrapText(true);
		perFlaws.setPrefWidth(148);
		perFlaws.setEditable(canEdit);
		perFlaws.setLayoutX(420);
		perFlaws.setLayoutY(321);
		perFlaws.setPrefHeight(45);
		
		additionalTraits.setPromptText("Additional Traits");
		additionalTraits.setText(c.getOtherData("Add"));
		additionalTraits.setWrapText(true);
		additionalTraits.setEditable(canEdit);
		additionalTraits.setLayoutX(410);
		additionalTraits.setLayoutY(380);
		additionalTraits.setPrefHeight(382);
		additionalTraits.setPrefWidth(170);

		// profBns = new TextField();

		profBns.setPromptText("Prof");
		profBns.setText("" + c.getStats(PrimaryStat.PROFICIENCY));
		profBns.setEditable(canEdit);
		profBns.setLayoutX(90);
		profBns.setLayoutY(165);
		profBns.setPrefWidth(35);

	
		str.setText("" + c.getStats(PrimaryStat.STRENGTH));
		str.setPromptText("Str");
		str.setEditable(canEdit);
		str.setLayoutX(40);
		str.setLayoutY(155);
		str.setPrefWidth(35);

		dex.setText("" + c.getStats(PrimaryStat.DEXTERITY));
		dex.setPromptText("Dex");
		dex.setEditable(canEdit);
		dex.setLayoutX(40);
		dex.setLayoutY(226);
		dex.setPrefWidth(35);

		con.setText("" + c.getStats(PrimaryStat.CONSTITUTION));
		con.setPromptText("Con");
		con.setEditable(canEdit);
		con.setLayoutX(40);
		con.setLayoutY(298);
		con.setPrefWidth(35);

		intel.setText("" + c.getStats(PrimaryStat.INTELLIGENCE));
		intel.setPromptText("Int");
		intel.setEditable(canEdit);
		intel.setLayoutX(40);
		intel.setLayoutY(370);
		intel.setPrefWidth(35);

		wis.setText("" + c.getStats(PrimaryStat.WISDOM));
		wis.setPromptText("Wis");
		wis.setEditable(canEdit);
		wis.setLayoutX(40);
		wis.setLayoutY(442);
		wis.setPrefWidth(35);

		chr.setText("" + c.getStats(PrimaryStat.CHARISMA));
		chr.setPromptText("Cha");
		chr.setEditable(canEdit);
		chr.setLayoutX(40);
		chr.setLayoutY(514);
		chr.setPrefWidth(35);

		otherPnL.setText(c.getOtherData("Other"));
		otherPnL.setPromptText("Other Profficiencies and Languages");
		otherPnL.setWrapText(true);
		otherPnL.setEditable(canEdit);
		otherPnL.setLayoutX(35);
		otherPnL.setLayoutY(625);
		otherPnL.setPrefHeight(138);
		otherPnL.setPrefWidth(165);

		// equipment = new TextArea();
		equipment.setText("" + c.getItems());
		equipment.setPromptText("Equipment");
		equipment.setWrapText(true);
		equipment.setEditable(canEdit);
		equipment.setLayoutX(268);
		equipment.setLayoutY(590);
		equipment.setPrefHeight(173);
		equipment.setPrefWidth(115);

		armClass.setText("" + c.getStats(PrimaryStat.ARMOR_CLASS));
		armClass.setPromptText("AC");
		armClass.setEditable(canEdit);
		armClass.setLayoutX(232);
		armClass.setLayoutY(142);
		armClass.setPrefWidth(30);

		spd.setText("" + c.getStats(PrimaryStat.SPEED));
		spd.setPromptText("Spd");
		spd.setEditable(canEdit);
		spd.setLayoutX(345);
		spd.setLayoutY(142);
		spd.setPrefWidth(35);

		// initiative = new TextField();
		initiative.setEditable(canEdit);
		initiative.setPromptText("Init");
		initiative.setLayoutX(285);
		initiative.setLayoutY(142);
		initiative.setPrefWidth(35);

		hp.setText("" + c.getStats(PrimaryStat.MAX_HEALTH));
		hp.setPromptText("Hp");
		hp.setEditable(canEdit);
		hp.setLayoutX(230);
		hp.setLayoutY(200);

		// tempHp = new TextField();
		tempHp.setPromptText("Temporary HP");
		tempHp.setEditable(canEdit);
		tempHp.setLayoutX(230);
		tempHp.setLayoutY(270);

		// hd = new TextField();
		hd.setPromptText("Hit Dice");
		hd.setEditable(canEdit);
		hd.setLayoutX(230);
		hd.setLayoutY(320);
		hd.setPrefWidth(65);

		// Sets an array for creating textfields within the equipment box for "currency"
		// column
		// 230 x, 590y (+30 for each iteration), 25 prefWidth
		// currency = new TextField[5];
		int currencyY = 590;
		for (int i = 0; i < currency.length; i++) {
			int x = 0;
			switch (i) {
			case 0:
				x = c.getMoney(Currency.CP);
				break;
			case 1:
				x = c.getMoney(Currency.SP);
				break;
			case 2:
				x = c.getMoney(Currency.GP);
				break;
			case 3:
				x = c.getMoney(Currency.PP);
				break;
			case 4:
				x = c.getMoney(Currency.EP);
				break;
			}
			currency[i].setText(x + "");
			currency[i].setEditable(canEdit);
			currency[i].setLayoutX(220);
			currency[i].setLayoutY(currencyY);
			currency[i].setPrefWidth(47);
			currencyY += 26;
		}

		// Sets an array for creating textfields within the attack box for "attack
		// names" column
		// 220 x, 385 y (+25 for each iteration), 70 prefWidth
		// attackNames = new TextField[7];
		int atkNamesY = 385;
		for (TextField attackName : attackNames) {
			// attackNames[i] = new TextField();
			attackName.setEditable(canEdit);
			attackName.setLayoutX(220);
			attackName.setPrefWidth(70);
			attackName.setLayoutY(atkNamesY);
			atkNamesY += 25;
		}

		// Sets an array for creating textfields within the attack box for "attack
		// bonus" column
		// 290 x, 385 y (+25 for each iteration), 32 prefWidth
		// attackBonus = new TextField[7];
		int atkBnsY = 385;
		for (TextField attackBonu : attackBonus) {
			// attackBonus[i] = new TextField();
			attackBonu.setEditable(canEdit);
			attackBonu.setLayoutX(290);
			attackBonu.setPrefWidth(32);
			attackBonu.setLayoutY(atkBnsY);
			atkBnsY += 25;
		}

		// Sets an array for creating textfields within the attack box for "attack
		// damage" column
		// 322 x, 385 y (+25 for each iteration), 70 prefWidth
		// attackDamage = new TextField[7];
		int atkDmgY = 385;
		for (TextField element : attackDamage) {
			// attackDamage[i] = new TextField();
			element.setEditable(canEdit);
			element.setLayoutX(322);
			element.setPrefWidth(70);
			element.setLayoutY(atkDmgY);
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
		Button saveBut = new Button();
		saveBut.setText("Save Character");
		saveBut.setLayoutX(650);
		saveBut.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				CharSheet cs = PlayerUIController.createCharacter(primaryStage);
				PlayerUIController.saveCharSheet(cs, "./", "dad");
			}
		});
		thePane.getChildren().addAll(viewSheet, characterNameField, characterRaceField, charClass, charLevel, charAlign,
				charEXP, charBG, playerName, str, dex, con, intel, wis, chr, armClass, spd, initiative, hp, hd, profBns,
				tempHp, perTraits, perIdeals, perBonds, perFlaws, additionalTraits, otherPnL, equipment, saveBut);

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

	public Parent displayMainMenu(Stage primaryStage) {
		// bPane2.setCenter(thePane);
		Button pm = new Button();
		pm.setScaleX(3);
		pm.setScaleY(3);
		pm.minWidth(400);
		Button dm = new Button();
		dm.setScaleX(3);
		dm.setScaleY(3);
		dm.minWidth(400);

		pm.setLayoutX(575);
		dm.setLayoutX(525);

		pm.setLayoutY(100);
		dm.setLayoutY(200);

		pm.setText("Player Menu");
		dm.setText("Dungeon Master Menu");

		pm.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				thePane.getChildren().clear();
				displayPlayerMenu(primaryStage);
			}
		});
		dm.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				thePane.getChildren().clear();
				displayDMMenu(primaryStage);
			}
		});

		thePane.getChildren().addAll(pm, dm);
		primaryStage.setScene(theScene);
		primaryStage.sizeToScene();
		primaryStage.setResizable(false);
		primaryStage.show();
		return pm;
	}

	public void displayPlayerMenu(Stage primaryStage) {
		// bPane2.setCenter(thePane);

		Button newChar = new Button();
		newChar.setScaleX(3);
		newChar.setScaleY(3);
		Button editChar = new Button();
		editChar.setScaleX(3);
		editChar.setScaleY(3);

		newChar.setLayoutX(575);
		editChar.setLayoutX(525);

		newChar.setLayoutY(100);
		editChar.setLayoutY(200);

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
			}
		});
		editChar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				thePane.getChildren().clear();
				TextField theChar = new TextField();
				theChar.setPromptText("Enter name of the character you wish to load");
				theChar.setLayoutX(450);
				theChar.setLayoutY(400);
				theChar.setPrefWidth(300);
				Button enterForLoad = new Button();
				enterForLoad.setText("Load");
				enterForLoad.setLayoutX(575);
				enterForLoad.setLayoutY(425);
				enterForLoad.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {
						displayFilledCharacterSheet(primaryStage,
								PlayerUIController.loadCharSheet("./", theChar.getText(), "dad"), true);
					}
				});
				thePane.getChildren().addAll(theChar, enterForLoad);
			}
		});

		thePane.getChildren().addAll(newChar, editChar);
		primaryStage.setScene(theScene);
		primaryStage.sizeToScene();
		primaryStage.show();
		exitButton(primaryStage);
	}

	public void displayDMMenu(Stage primaryStage) {

		new VBox();
		new HBox();
		new GameData("auto");

		// new GameData("auto");
		// FXCollections.observableArrayList();
		TableView playerList = new TableView();
		TableColumn playerName = new TableColumn("Players");
		playerList.setEditable(true);
		playerList.getColumns().clear();
		playerList.getColumns().addAll(playerName);
		// playerName.setCellFactory(new PropertyValueFactory<CharSheet,
		// String>("playerName"));
		playerList.setPlaceholder(new Label("No Players to Display"));
		playerList.setLayoutX(50);
		playerList.setLayoutY(160);

		Button saveRule = new Button();
		Button loadRule = new Button();
		new Button();
		new Button();
		new Button();
		TextArea ruleText = new TextArea();

		ruleText.setPromptText("Enter Rules and Notes here");
		ruleText.setWrapText(true);
		// ruleText.setScaleX(3);
		// ruleText.setScaleY(3);
		ruleText.setLayoutX(550);
		ruleText.setLayoutY(160);
		ruleText.setPrefHeight(138);
		ruleText.setPrefWidth(165);

		saveRule.setLayoutX(600);
		loadRule.setLayoutX(600);

		// saveRule.setScaleX(2);
		// saveRule.setScaleY(2);
		// loadRule.setScaleX(2);
		// loadRule.setScaleY(2);

		saveRule.setLayoutY(500);
		loadRule.setLayoutY(625);

		saveRule.setText("Save Rules");
		loadRule.setText("Load Rules");

		saveRule.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				DungeonMasterUIController.saveRules("./", "encryptKey");
			}
		});
		loadRule.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				TextField path = new TextField();
				path.setPromptText("Enter the File Path");
				// path.setScaleX(2);
				// path.setScaleY(2);
				path.setLayoutX(565);
				path.setLayoutY(680);

				Button submitPathBttn = new Button("Submit Path");
				// submitPathBttn.setScaleX(2);
				// submitPathBttn.setScaleY(2);
				submitPathBttn.setLayoutX(595);
				submitPathBttn.setLayoutY(735);
				submitPathBttn.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {
						GameData loadData = DungeonMasterUIController.loadRules(path.getText(), "encryptKey");
						ruleText.setText(loadData.getRules());
					}
				});
				thePane.getChildren().addAll(path, submitPathBttn);
			}
		});

		thePane.getChildren().addAll(saveRule, loadRule, ruleText, playerList);
		primaryStage.setScene(theScene);
		primaryStage.sizeToScene();
		primaryStage.show();
		exitButton(primaryStage);
	}

	public boolean getMilestone() {
		return isMilestoneCheck.selectedProperty() != null;
	}

	public String getCharacterNameField() {
		return nullCheck(characterNameField.getText());
	}

	public String getCharacterRaceField() {
		return nullCheck(characterRaceField.getText());
	}

	public Alignment getCharAlign() {
		for (Alignment a : Alignment.values()) {
			if (a.toString().equalsIgnoreCase(charAlign.getSelectionModel().toString())) {
				return a;
			}
		}
		return Alignment.TRUE_NEUTRAL;
	}

	// ahhh
	public int getCharEXP() {
		return emptyCheck(charEXP.getText());
	}

	public String getCharClass() {
		return nullCheck(charClass.getText());
	}

	public int getCharLevel() {
		return emptyCheck(charLevel.getText());
	}

	public String getCharBG() {
		return nullCheck(charBG.getText());
	}

	public int[] getCurrency() {
		LinkedList<Integer> charCurrency = new LinkedList<>();

		for (TextField i : currency) {
			if (i == null || i.getText().isEmpty()) {
				charCurrency.add(0);
			} else {
				charCurrency.add(Integer.parseInt(i.getText()));
				// System.out.println(i);
			}
		}
		Object[] o = charCurrency.toArray();
		int[] is = new int[o.length];
		for (int i = 0; i < o.length; i++) {
			is[i] = (int) o[i];
		}
		
		return is;
	}

	public String[] getAtkName() {
		LinkedList<String> charCurrency = new LinkedList<>();

		for (TextField i : attackNames) {
			if (i == null || i.getText().isEmpty()) {
				charCurrency.add("Atk Name");
			} else {
				charCurrency.add(i.getText());
				// System.out.println(i);
			}
		}
		Object[] o = charCurrency.toArray();
		String[] is = new String[o.length];
		for (int i = 0; i < o.length; i++) {
			is[i] = (String) o[i];
		}
		return is;
	}

	public String[] getAtkBns() {
		LinkedList<String> charCurrency = new LinkedList<>();

		for (TextField i : attackBonus) {
			if (i == null || i.getText().isEmpty()) {
				charCurrency.add("Atk Name");
			} else {
				charCurrency.add(i.getText());
				// System.out.println(i);
			}
		}
		Object[] o = charCurrency.toArray();
		String[] is = new String[o.length];
		for (int i = 0; i < o.length; i++) {
			is[i] = (String) o[i];
		}
		return is;
	}

	public String[] getAtkDmg() {
		LinkedList<String> charCurrency = new LinkedList<>();

		for (TextField i : attackDamage) {
			if (i == null || i.getText().isEmpty()) {
				charCurrency.add("Atk Name");
			} else {
				charCurrency.add(i.getText());
				// System.out.println(i);
			}
		}
		Object[] o = charCurrency.toArray();
		String[] is = new String[o.length];
		for (int i = 0; i < o.length; i++) {
			is[i] = (String) o[i];
		}
		return is;
	}

	public String getAdditionalTraits() {
		return nullCheck(additionalTraits.getText());
	}

	public int getChr() {
		return emptyCheck(chr.getText());
	}

	public int getCon() {
		return emptyCheck(con.getText());
	}

	public int getDex() {
		return emptyCheck(dex.getText());
	}

	public String getEquipment() {
		return nullCheck(equipment.getText());
	}

	public int getArmClass() {
		return emptyCheck(armClass.getText());
	}

	public String getHd() {
		return hd.getText();
	}

	public int getMaxHp() {
		return emptyCheck(hp.getText());

	}

	public int getInitiative() {
		return emptyCheck(initiative.getText());
	}

	public int getIntel() {
		return emptyCheck(intel.getText());
	}

	public String getOtherPnL() {
		return nullCheck(otherPnL.getText());
	}

	public String getPerBonds() {
		return nullCheck(perBonds.getText());
	}

	public String getPerFlaws() {
		return nullCheck(perFlaws.getText());
	}

	public String getPerIdeals() {
		return nullCheck(perIdeals.getText());
	}

	public String getPerTraits() {
		return nullCheck(perTraits.getText());
	}

	public String getPlayerName() {
		return nullCheck(playerName.getText());
	}

	public int getProfBns() {
		return emptyCheck(profBns.getText());

	}

	public int getSpd() {
		return emptyCheck(spd.getText());

	}

	public int getStr() {
		return emptyCheck(str.getText());
	}

	public int getTempHp() {
		return emptyCheck(tempHp.getText());
	}

	public int getWis() {
		return emptyCheck(wis.getText());
	}

	public String getItems() {
		String item = nullCheck(equipment.getText());
		return item;
	}

	private String nullCheck(String s) {
		if (s != null) {
			return s;
		}
		return "Empty";
	}

	private int emptyCheck(String s) {
		String y = nullCheck(s);
		int ret = 0;
		if (y.equals("Empty")) {
			return 0;
		} else {
			try {
				ret = Integer.parseInt(y);
			} catch (NumberFormatException e) {
				return 0;
			}
			return ret;
		}
	}

	public void exitButton(Stage primaryStage) {

		Button exit = new Button();
		exit.setLayoutX(1100);
		exit.setText("Back to Main");
		exit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				thePane.getChildren().clear();
				setIsDone(true);
				exit.getScene().setRoot(displayMainMenu(primaryStage)); 
			 
			}
		});
		thePane.getChildren().add(exit);
		primaryStage.setScene(theScene);
		primaryStage.sizeToScene();
		primaryStage.show();
	}

	public void setIsDone(boolean bah) {
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
