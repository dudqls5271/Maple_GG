package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainController implements Initializable{

	@FXML 
    private Button btn;
    
    @FXML 
    private TextField txtField;
    
    @FXML
    private Text notfound;
    
    @FXML
    private Label resultLabel; 

	public void handleButtonActoin() throws IOException {

        // 새 스테이지 추가
        Stage stage = (Stage)btn.getScene().getWindow();
//      inputValue.setInputValue(txtField.getText());
//		txtField.setText(""); 
//		System.out.println(inputValue.getInputValue());
//
//		stage.close();
//		Parent second = FXMLLoader.load(getClass().getResource("testFxml.fxml"));
//      Scene sc = new Scene(second);
//      stage.setScene(sc);
//      stage.show();
        
        


        System.out.println("set : " + txtField.getText());
        System.out.println("MainController : " + txtField.getText());
        ver1 = txtField.getText();
        System.out.println("ver1" + ver1);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("testFxml.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
    	stage.setScene(scene);

    	
    	stage.show();

    }
	
	public static String ver1;
	
	public String initData() {
		return txtField.getText();
	}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }   

    
}