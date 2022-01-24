package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;


public class Main extends Application {	
	
	Stage window;
    Scene scene;

	@Override
	public void start(Stage primaryStage) {
		try {
	        System.setProperty("prism.lcdtext", "false"); // 폰트파일 로드전에 실행
	        
	        Font.loadFont(getClass().getResourceAsStream("MAPLESTORY LIGHT.TTF"), 14);
	        
	        
	        Parent root = FXMLLoader.load(getClass().getResource("SearchUser.fxml"));
	       
	        Scene scene = new Scene(root);
	        primaryStage.setScene(scene);
	        primaryStage.show();

	        primaryStage.setTitle("AppMain");

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
