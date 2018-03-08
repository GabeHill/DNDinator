package view;

import java.util.HashMap;

import enums.Currency;
import enums.DiceSides;
import enums.PrimaryStat;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import logic.RollDie;
import models.CharSheet;

public class Show
{
	private BorderPane bPane = new BorderPane();
	private Pane thePane = new Pane();
	private int[] windowSize = {800,1200};
	private Scene theScene = new Scene(bPane,windowSize[1],windowSize[0]);
	
	private TextField characterNameField;
	private TextField characterRaceField;
	private TextField charAlign;
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
	private TextField dmRulesName;
	private TextField dmRulesDescription;
	
	public String getCharacterNameField() 
	{
		return characterNameField.getText();
	}

	public String getCharacterRaceField() 
	{
		return characterRaceField.getText();
	}

	public String getCharAlign() 
	{
		return charAlign.getText();
	}

	public int getCharEXP() 
	{
		int returnXP = Integer.parseInt(charEXP.getText());
		return returnXP;
	}

	public String getdmRulesName()
	{
		return dmRulesName.getText();
	}
	
	public String getdmRulesDesrciption()
	{
		return dmRulesDescription.getText();
	}
	
	public String getCharBG() 
	{
		return charBG.getText();
	}

	public String getPlayerName() 
	{
		return playerName.getText();
	}

	public String getPerTraits() 
	{
		return perTraits.getText();
	}

	public String getPerIdeals() 
	{
		return perIdeals.getText();
	}

	public String getPerBonds() 
	{
		return perBonds.getText();
	}

	public String getPerFlaws() 
	{
		return perFlaws.getText();
	}

	public int getProfBns() 
	{
		int ProfBns = Integer.parseInt(profBns.getText());
		return ProfBns;
	}

	public int getStr() 
	{
		int Str = Integer.parseInt(str.getText());
		return Str;
	}

	public int getDex() 
	{
		int Dex = Integer.parseInt(dex.getText());
		return Dex;
	}

	public int getCon() 
	{
		int Con = Integer.parseInt(con.getText());
		return Con;
	}

	public int getIntel() 
	{
		int Intelligence = Integer.parseInt(intel.getText());
		return Intelligence;
	}

	public int getWis() 
	{
		int Wis = Integer.parseInt(wis.getText());
		return Wis;
	}

	public int getChr() 
	{
		int Chr = Integer.parseInt(chr.getText());
		return Chr;
	}

	public String getOtherPnL() 
	{
		return otherPnL.getText();
	}

	public String getEquipment() 
	{
		return equipment.getText();
	}
	
	public String getArmClass()
	{
		return armClass.getText();
	}

	public int getSpd() 
	{
		int Spd = Integer.parseInt(spd.getText());
		return Spd;
	}

	public int getInitiative() 
	{
		int Init = Integer.parseInt(initiative.getText());
		return Init;
	}

	public int getHp() 
	{
		int MaxHealth = Integer.parseInt(hp.getText());
		return MaxHealth;
	}

	public int getTempHp() 
	{
		int TempHp = Integer.parseInt(tempHp.getText());
		return TempHp;
	}

	public int getHd() 
	{
		int MaxHp = Integer.parseInt(hd.getText());
		return MaxHp;
	}

	//Initializes the GUI Display by setting up window and adds buttons
	//that call the Logic methods for Player menu and DM Menu
	public void initDnDinatorDisplay(Stage primaryStage)
	{
		bPane.setCenter(thePane);
		primaryStage.setTitle("DnDinator");
		primaryStage.setScene(theScene);
		primaryStage.show();
	}
	
	//Initializes the Display of a fresh character sheet for new Character entry;
	// returns the character created by the field
	//(TextFields are defaulted at 150 length and 25 height)
	public void displayCleanCharacterSheet(Stage primaryStage)
	{
		ImageView viewSheet = new ImageView();
		viewSheet.setImage(new Image("file:Character Sheet (Official) - Copy_Page_1.png",790,790,true,true));
		
		characterNameField = new TextField();
		characterNameField.setPromptText("Name");
		characterNameField.setLayoutY(59);
		characterNameField.setLayoutX(50);
		
		characterRaceField = new TextField();
		characterRaceField.setPromptText("Race");
		characterRaceField.setLayoutX(270);
		characterRaceField.setLayoutY(72);
		characterRaceField.setPrefWidth(100);
		
		charAlign = new TextField();
		charAlign.setPromptText("Alignment");
		charAlign.setLayoutX(370);
		charAlign.setLayoutY(72);
		charAlign.setPrefWidth(100);
		
		charEXP = new TextField();
		charEXP.setPromptText("Exp/Milestone");
		charEXP.setLayoutX(470);
		charEXP.setLayoutY(72);
		charEXP.setPrefWidth(100);
		
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
		
		Button rollD4 = new Button();
		Button rollD6 = new Button();
		Button rollD8 = new Button();
		Button rollD10 = new Button();
		Button rollD12 = new Button();
		Button rollD20 = new Button();
		Button rollD100 = new Button();
		
		rollD4.setText("Roll D4");
		rollD6.setText("Roll D6");
		rollD8.setText("Roll D8");
		rollD10.setText("Roll D10");
		rollD12.setText("Roll D12");
		rollD20.setText("Roll D20");
		rollD100.setText("Roll Percentage Die");
		
		rollD4.setLayoutX(625);
		rollD6.setLayoutX(625);
		rollD8.setLayoutX(625);
		rollD10.setLayoutX(625);
		rollD12.setLayoutX(625);
		rollD20.setLayoutX(625);
		rollD100.setLayoutX(625);
		
		rollD4.setLayoutY(100);
		rollD6.setLayoutY(125);
		rollD8.setLayoutY(150);
		rollD10.setLayoutY(175);
		rollD12.setLayoutY(200);
		rollD20.setLayoutY(225);
		rollD100.setLayoutY(250);
		
		rollD4.setOnAction(new EventHandler<ActionEvent>()
				{
					@Override
					public void handle(ActionEvent arg0) 
					{
						displayDice(DiceSides.FOUR,primaryStage);
					}
				});
		rollD6.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent arg0) 
			{
				displayDice(DiceSides.SIX,primaryStage);
			}
		});
		rollD8.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent arg0) 
			{
				displayDice(DiceSides.EIGHT,primaryStage);
			}
		});
		rollD10.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent arg0) 
			{
				displayDice(DiceSides.TEN,primaryStage);
			}
		});
		rollD12.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent arg0) 
			{
				displayDice(DiceSides.TWELVE,primaryStage);
			}
		});
		rollD20.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent arg0) 
			{
				displayDice(DiceSides.TWENTY,primaryStage);
			}
		});
		rollD100.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent arg0) 
			{
				displayDice(DiceSides.HUNDRED,primaryStage);
			}
		});
		//Sets an array for creating textfields within the equipment box for "currency" column
		//230 x, 590y (+30 for each iteration), 25 prefWidth 
		currency = new TextField[5];
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
		attackNames = new TextField[7];
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
		attackBonus = new TextField[7];
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
		attackDamage = new TextField[7];
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
		
		thePane.getChildren().addAll(viewSheet,characterNameField,characterRaceField,charClass,charLevel,charAlign,charEXP,charBG,playerName,str,dex,con,intel,wis,chr,armClass,spd, initiative,hp,hd,profBns,tempHp,perTraits,perIdeals,perBonds,perFlaws,additionalTraits, otherPnL,equipment,rollD4,rollD6,rollD8,rollD10,rollD12,rollD20,rollD100);
		
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
	
	//Takes in a character and displays available data based on that character
	//the boolean that is passed in affects whether the text boxes can be edited or note
	public void displayFilledCharacterSheet(Stage primaryStage, CharSheet c, boolean canEdit)
	{
		ImageView viewSheet = new ImageView();
		viewSheet.setImage(new Image("file:Character Sheet (Official) - Copy_Page_1.png",790,790,true,true));
		
		characterNameField = new TextField(c.getCharacterName());
		characterNameField.setEditable(canEdit);
		characterNameField.setLayoutY(59);
		characterNameField.setLayoutX(50);
		
		characterRaceField = new TextField(c.getRace());
		characterRaceField.setEditable(canEdit);
		characterRaceField.setLayoutX(270);
		characterRaceField.setLayoutY(72);
		characterRaceField.setPrefWidth(100);
		
		charAlign = new TextField(c.getAlignment().toString());
		charAlign.setEditable(canEdit);
		charAlign.setLayoutX(370);
		charAlign.setLayoutY(72);
		charAlign.setPrefWidth(100);
		
		charEXP = new TextField(""+c.getXp());
		charEXP.setEditable(canEdit);
		charEXP.setLayoutX(470);
		charEXP.setLayoutY(72);
		charEXP.setPrefWidth(100);
		
		charClass = new TextField(c.getOccupation());
		charClass.setEditable(canEdit);
		charClass.setLayoutX(270);
		charClass.setLayoutY(47);
		charClass.setPrefWidth(60);
		
		charLevel = new TextField(""+c.getLevel());
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
		
		
		//Sets an array for creating textfields within the equipment box for "currency" column
		//230 x, 590y (+30 for each iteration), 25 prefWidth 
		currency = new TextField[5];
		int currencyY = 590;
		for(int i = 0; i < currency.length; i++)
		{
			int x = 0;
			String xType;
			if(i == 0) 
			{
				x = c.getMoney(Currency.CP);
				xType = Currency.CP.toString();
			}
			else if(i == 1)
			{
				x = c.getMoney(Currency.SP);
				xType = Currency.SP.toString();
			}
			else if(i == 2)
			{
				x = c.getMoney(Currency.GP);
				xType = Currency.GP.toString();
			}
			else if(i == 3)
			{
				x = c.getMoney(Currency.PP);
				xType = Currency.PP.toString();
			}
			else
			{
				x = c.getMoney(Currency.EP);
				xType = Currency.EP.toString();
			}
			currency[i] = new TextField(x+" "+xType);
			currency[i].setEditable(canEdit);
			currency[i].setLayoutX(220);
			currency[i].setLayoutY(currencyY);
			currency[i].setPrefWidth(47);
			currencyY += 26;
		}
		
		//Sets an array for creating textfields within the attack box for "attack names" column
		//220 x, 385 y (+25 for each iteration), 70 prefWidth 
		attackNames = new TextField[7];
		int atkNamesY = 385;
		for(int i = 0; i < attackNames.length; i++)
		{
			attackNames[i] = new TextField();
			attackNames[i].setEditable(canEdit);
			attackNames[i].setLayoutX(220);
			attackNames[i].setPrefWidth(70);
			attackNames[i].setLayoutY(atkNamesY);
			atkNamesY += 25;
		}
		
		//Sets an array for creating textfields within the attack box for "attack bonus" column
		//290 x, 385 y (+25 for each iteration), 32 prefWidth 
		attackBonus = new TextField[7];
		int atkBnsY = 385;
		for(int i = 0; i < attackBonus.length; i++)
		{
			attackBonus[i] = new TextField();
			attackBonus[i].setEditable(canEdit);
			attackBonus[i].setLayoutX(290);
			attackBonus[i].setPrefWidth(32);
			attackBonus[i].setLayoutY(atkBnsY);
			atkBnsY += 25;
		}
		
		//Sets an array for creating textfields within the attack box for "attack damage" column
		//322 x, 385 y (+25 for each iteration), 70 prefWidth 
		attackDamage = new TextField[7];
		int atkDmgY = 385;
		for(int i = 0; i < attackDamage.length; i++)
		{
			attackDamage[i] = new TextField();
			attackDamage[i].setEditable(canEdit);
			attackDamage[i].setLayoutX(322);
			attackDamage[i].setPrefWidth(70);
			attackDamage[i].setLayoutY(atkDmgY);
			atkDmgY += 25;
		}
		
		thePane.getChildren().addAll(viewSheet,characterNameField,characterRaceField,charClass,charLevel,charAlign,charEXP,charBG,playerName,str,dex,con,intel,wis,chr,armClass,spd, initiative,hp,hd,profBns,tempHp,perTraits,perIdeals,perBonds,perFlaws,additionalTraits, otherPnL,equipment);
		
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
	
	public void displayDice(DiceSides ds, Stage primaryStage)
	{
		Circle c = new Circle(900,400,50,Paint.valueOf("Purple"));
		RollDie rd = new RollDie();
		
		TextField diceFace = new TextField(""+rd.roll(ds));
		diceFace.setEditable(false);
		diceFace.setLayoutX(875);
		diceFace.setLayoutY(389.5);
		diceFace.setPrefWidth(50);
		thePane.getChildren().addAll(c,diceFace);
		primaryStage.setScene(theScene);
		primaryStage.sizeToScene();
		primaryStage.show();
	}
	
	
	public void displayMainMenu(Stage primaryStage)
	{
		Button playerMenu = new Button();
		Button dmMenu = new Button();
		
		playerMenu.setText("Player Menu");
		playerMenu.setLayoutX(525);
		playerMenu.setLayoutY(375);
		playerMenu.setOnAction(new EventHandler<ActionEvent>()
				{
					@Override
					public void handle(ActionEvent arg0) 
					{
						displayPlayerMenu(primaryStage);
					}
				});
		
		dmMenu.setText("Dungeon Master Menu");
		dmMenu.setLayoutX(675);
		dmMenu.setLayoutY(375);
		dmMenu.setOnAction(new EventHandler<ActionEvent>()
				{
					@Override
					public void handle(ActionEvent arg0) 
					{
						
					}
				});
		
		thePane.getChildren().addAll(playerMenu,dmMenu);
		primaryStage.setScene(theScene);
		primaryStage.sizeToScene();
		primaryStage.show();
	}
	
	public void displayDMRulesAndNotes(Stage primaryStage,HashMap<String,String> rules)
	{
		dmRulesName = new TextField();
		dmRulesDescription = new TextField();
		
		dmRulesName.setText("Rule Name");
		dmRulesDescription.setText("Rule Description");
		
		dmRulesName.setLayoutX(150);
		dmRulesDescription.setLayoutX(300);
		
		dmRulesDescription.setPrefHeight(800);
		dmRulesDescription.setPrefWidth(800);
		
		int location = 0;
		for(String key : rules.keySet())
		{
			Button theRule = new Button();
			theRule.setText(key);
			theRule.setLayoutY(location);
			theRule.setOnAction(new EventHandler<ActionEvent>()
					{

						@Override
						public void handle(ActionEvent arg0) 
						{
							dmRulesName = new TextField(key);
							dmRulesDescription = new TextField(rules.get(key));
							dmRulesName.setLayoutX(150);
							dmRulesDescription.setLayoutX(300);
							
							dmRulesDescription.setPrefHeight(800);
							dmRulesDescription.setPrefWidth(800);
							thePane.getChildren().addAll(dmRulesName,dmRulesDescription);
							primaryStage.setScene(theScene);
							primaryStage.sizeToScene();
							primaryStage.show();
						}
						
					});
			thePane.getChildren().add(theRule);
			location += 25;
		}
		primaryStage.setScene(theScene);
		primaryStage.sizeToScene();
		primaryStage.show();
	}
	
	
	public void displayPlayerMenu(Stage primaryStage)
	{
		Button newCharSheet = new Button();
		Button editExistingCharSheet = new Button();
		
		newCharSheet.setText("Create new Character");
		newCharSheet.setLayoutX(600);
		newCharSheet.setLayoutY(375);
		newCharSheet.setOnAction(new EventHandler<ActionEvent>()
				{
					@Override
					public void handle(ActionEvent arg0) 
					{
						displayCleanCharacterSheet(primaryStage);
					}
				});
		
		editExistingCharSheet.setText("Edit Existing Character");
		editExistingCharSheet.setLayoutX(600);
		editExistingCharSheet.setLayoutY(400);
		editExistingCharSheet.setOnAction(new EventHandler<ActionEvent>()
				{
					@Override
					public void handle(ActionEvent arg0) 
					{
						
					}
				});
		
		thePane.getChildren().addAll(newCharSheet,editExistingCharSheet);
		primaryStage.setScene(theScene);
		primaryStage.sizeToScene();
		primaryStage.show();
	}
	
	public void displayDungeonMaster(Stage primaryStage)
	{
		Button newCharSheet = new Button();
		Button editExistingCharSheet = new Button();
		
		newCharSheet.setText("Create new Character");
		newCharSheet.setLayoutX(600);
		newCharSheet.setLayoutY(375);
		newCharSheet.setOnAction(new EventHandler<ActionEvent>()
				{
					@Override
					public void handle(ActionEvent arg0) 
					{
						displayCleanCharacterSheet(primaryStage);
					}
				});
		
		editExistingCharSheet.setText("Edit Existing Character");
		editExistingCharSheet.setLayoutX(600);
		editExistingCharSheet.setLayoutY(400);
		editExistingCharSheet.setOnAction(new EventHandler<ActionEvent>()
				{
					@Override
					public void handle(ActionEvent arg0) 
					{
						
					}
				});
		
		thePane.getChildren().addAll(newCharSheet,editExistingCharSheet);
		primaryStage.setScene(theScene);
		primaryStage.sizeToScene();
		primaryStage.show();
	}
}
