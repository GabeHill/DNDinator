package View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Show extends Application
{
	
	private  BorderPane thePane = new BorderPane();
	private int[] windowSize = {800,800};
	private Image characterSheet = new Image("file:DnDinatorSheetOne.jpg",300,300,false,false);
	private Scene theScene = new Scene(thePane,windowSize[1],windowSize[0]);
	public static void run(String[] args)
	{
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		initDnDinatorDisplay(primaryStage);
		
	}
	public void initDnDinatorDisplay(Stage primaryStage)
	{
		primaryStage.setTitle("DnDinator");
		primaryStage.setScene(theScene);
		primaryStage.show();
	}
	
	
	public void updateDisplay(Stage primaryStage)
	{
	}
	public void displayCleanCharacterSheet(Stage primaryStage)
	{
		ImageView showSheet = new ImageView();
		showSheet.setImage(characterSheet);
		thePane.setCenter(showSheet);
		primaryStage.setScene(theScene);
		primaryStage.sizeToScene();
		primaryStage.show();
	}
}
