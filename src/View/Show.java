package View;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Show extends Application
{
	private Scene theScene;
	private Pane thePane = new Pane();
	private int[] windowSize = {800,800};
	Image characterSheet = new Image("./Character Sheet (Official) - Copy.pdf");
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
		theScene = new Scene(thePane,windowSize[1],windowSize[0]);
		primaryStage.setTitle("DnDinator");
		primaryStage.setScene(theScene);
		primaryStage.show();
	}
	
	
	public static void updateDisplay(Stage st, Pane p, Scene sc, Node theObject)
	{
		
	}
	public static void displayCleanCharacterSheet()
	{
		
	}
}
