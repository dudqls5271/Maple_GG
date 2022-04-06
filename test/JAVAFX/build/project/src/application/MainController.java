package application;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.image.Image;
import javafx.scene.text.Text;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MainController implements Initializable{

	@FXML 
    private Button btn, nav2, swpage;
    
    @FXML 
    private TextField txtField;
    
    @FXML
    private Text notfound, text_event1, text_event2, text_event3, text_event4, text_event5, text_event6, text_event7, text_event8, text_event9, text_event10,
    			 date_1, date_2, date_3, date_4, date_5, date_6, date_7, date_8, date_9, date_10, eventGG, updateText;
    
    @FXML
    private Label resultLabel; 

    @FXML
    private ImageView event1, event2, event3, event4, event5, event6, event7, event8, event9, event10;

    
    @FXML
    private Hyperlink hyperlink, updatelink ;
    
    public void updateBut() throws IOException {
    	Stage stage = (Stage)nav2.getScene().getWindow();
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("updateList.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
    	stage.setScene(scene);
    }
    
    
    public void swpage() throws IOException {
    	Stage stage = (Stage)nav2.getScene().getWindow();
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("SWpage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
    	stage.setScene(scene);
    }
    
    public void muto() throws IOException {

    	Alert alert = new Alert(AlertType.WARNING);
		ImageView icon = new ImageView("/img/notfind.png");
		icon.setFitHeight(60);
        icon.setFitWidth(60);
        alert.getDialogPane().setGraphic(icon);
		alert.setTitle("잠깐!"); 
		alert.setHeaderText("아직 준비 중입니다"); 
		alert.showAndWait();
    }
    
    public void linkButton() throws IOException {
    	
    	
    	Alert alert = new Alert(AlertType.WARNING);
		ImageView icon = new ImageView("/img/notfind.png");
		icon.setFitHeight(60);
        icon.setFitWidth(60);
        alert.getDialogPane().setGraphic(icon);
		alert.setTitle("잠깐!"); 
		alert.setHeaderText("아직 준비 중입니다"); 
		alert.showAndWait();
    	
    	
//    	Stage stage = (Stage)nav2.getScene().getWindow();
//    	
//    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../linkUnion/link_01.fxml"));
//        Parent root = loader.load();
//        Scene scene = new Scene(root);
//    	stage.setScene(scene);
    }
    
    
	public void handleButtonActoin() throws IOException {

        // 새 스테이지 추가
        Stage stage = (Stage)btn.getScene().getWindow();
        

        try {
        	System.out.println("set : " + txtField.getText());
            System.out.println("MainController : " + txtField.getText());
            ver1 = txtField.getText();
            System.out.println("ver1" + ver1);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("testFxml.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
        	stage.setScene(scene);
        	stage.show();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

			
			Alert alert = new Alert(AlertType.WARNING);
			ImageView icon = new ImageView("/img/notfind.png");
			icon.setFitHeight(60);
	        icon.setFitWidth(60);
	        alert.getDialogPane().setGraphic(icon);
			alert.setTitle("오류!"); 
			alert.setHeaderText("검색결과가 없습니다."); 
			alert.showAndWait();

		}
    }
	
	public static String ver1;
	String updateTextJ;
	public String initData() {
		return txtField.getText();
	}
	
	public void openlink(ActionEvent event) throws URISyntaxException, IOException {
		System.out.println("link clicked!");
		java.awt.Desktop.getDesktop().browse(new URI("https://maple.gg/event"));
	}
	
	
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	try {    		
    		String url = "https://maple.gg/"; // 크롤링할 url지정
		  	System.out.println("==================>" + url);
			Document doc = Jsoup.connect(url).get();
						
			int eventCount = doc.select("div[class=\"d-inline-block\"]").size();
			
			System.out.println(eventCount);
			
			if(eventCount == 4) {
				Element eventURL = doc.select("div[class=\"d-inline-block\"]").get(0).select("a").get(0);
				String eventURL2 = eventURL.attr("href");
				System.out.println(eventURL2);
				Element event1_img = doc.select("div[class=\"d-inline-block\"]").get(0).select("img").get(0);
				String text_event_1 = doc.select("div[class=\"d-inline-block\"]").get(0).select("div").get(0).text();
				text_event1.setText(text_event_1);
				String date_event_1 = doc.select("small[class=\"text-secondary\"]").get(0).text();
				date_1.setText(date_event_1);
				String event1_img_str = event1_img.attr("src");
				Image event1_img_url = new Image(event1_img_str);
				event1.setImage(event1_img_url);
				
				Element event2_img = doc.select("div[class=\"d-inline-block\"]").get(1).select("img").get(0);
				String text_event_2 = doc.select("div[class=\"d-inline-block\"]").get(1).select("div").get(0).text();
				text_event2.setText(text_event_2);
				String date_event_2 = doc.select("small[class=\"text-secondary\"]").get(1).text();
				date_2.setText(date_event_2);
				String event2_img_str = event2_img.attr("src");
				Image event2_img_url = new Image(event2_img_str);
				event2.setImage(event2_img_url);
	
				Element event3_img = doc.select("div[class=\"d-inline-block\"]").get(2).select("img").get(0);
				String text_event_3 = doc.select("div[class=\"d-inline-block\"]").get(2).select("div").get(0).text(); 
				String date_event_3 = doc.select("small[class=\"text-secondary\"]").get(2).text();
				date_3.setText(date_event_3); text_event3.setText(text_event_3); String
				event3_img_str = event3_img.attr("src"); Image event3_img_url = new
				Image(event3_img_str); event3.setImage(event3_img_url);
				 
				Element event4_img = doc.select("div[class=\"d-inline-block\"]").get(3).select("img").get(0);
				String text_event_4 = doc.select("div[class=\"d-inline-block\"]").get(3).select("div").get(0).text(); 
				String date_event_4 = doc.select("small[class=\"text-secondary\"]").get(3).text();
				date_4.setText(date_event_4); text_event4.setText(text_event_4); String
				event4_img_str = event4_img.attr("src"); Image event4_img_url = new
				Image(event4_img_str); event4.setImage(event4_img_url);
			}
			if (eventCount == 3) {
				Element event5_img = doc.select("div[class=\"d-inline-block\"]").get(0).select("img").get(0);
				String text_event_5 = doc.select("div[class=\"d-inline-block\"]").get(0).select("div").get(0).text();
				text_event5.setText(text_event_5);
				String date_event_5 = doc.select("small[class=\"text-secondary\"]").get(0).text();
				date_5.setText(date_event_5);
				String event5_img_str = event5_img.attr("src");
				Image event5_img_url = new Image(event5_img_str);
				event5.setImage(event5_img_url);
				
				Element event6_img = doc.select("div[class=\"d-inline-block\"]").get(1).select("img").get(0);
				String text_event_6 = doc.select("div[class=\"d-inline-block\"]").get(1).select("div").get(0).text();
				text_event6.setText(text_event_6);
				String date_event_6 = doc.select("small[class=\"text-secondary\"]").get(1).text();
				date_6.setText(date_event_6);
				String event6_img_str = event6_img.attr("src");
				Image event6_img_url = new Image(event6_img_str);
				event6.setImage(event6_img_url);
				
				Element event7_img = doc.select("div[class=\"d-inline-block\"]").get(2).select("img").get(0);
				String text_event_7 = doc.select("div[class=\"d-inline-block\"]").get(2).select("div").get(0).text(); 
				String date_event_7 = doc.select("small[class=\"text-secondary\"]").get(2).text();
				date_7.setText(date_event_7); text_event7.setText(text_event_7); String
				event7_img_str = event7_img.attr("src"); 
				Image event7_img_url = new Image(event7_img_str); 
				event7.setImage(event7_img_url);
				
			} 
			if (eventCount == 2) {
				Element event8_img = doc.select("div[class=\"d-inline-block\"]").get(0).select("img").get(0);
				String text_event_8 = doc.select("div[class=\"d-inline-block\"]").get(0).select("div").get(0).text();
				text_event8.setText(text_event_8);
				String date_event_8 = doc.select("small[class=\"text-secondary\"]").get(0).text();
				date_8.setText(date_event_8);
				String event8_img_str = event8_img.attr("src");
				Image event8_img_url = new Image(event8_img_str);
				event8.setImage(event8_img_url);
				
				Element event9_img = doc.select("div[class=\"d-inline-block\"]").get(1).select("img").get(0);
				String text_event_9 = doc.select("div[class=\"d-inline-block\"]").get(1).select("div").get(0).text();
				text_event9.setText(text_event_9);
				String date_event_9 = doc.select("small[class=\"text-secondary\"]").get(1).text();
				date_9.setText(date_event_9);
				String event9_img_str = event9_img.attr("src");
				Image event9_img_url = new Image(event9_img_str);
				event9.setImage(event9_img_url);
				
			} 
			if (eventCount == 1) {
				Element event10_img = doc.select("div[class=\"d-inline-block\"]").get(0).select("img").get(0);
				String text_event_10 = doc.select("div[class=\"d-inline-block\"]").get(0).select("div").get(0).text();
				text_event10.setText(text_event_10);
				String date_event_10 = doc.select("small[class=\"text-secondary\"]").get(0).text();
				date_10.setText(date_event_10);
				String event10_img_str = event10_img.attr("src");
				Image event10_img_url = new Image(event10_img_str);
				event10.setImage(event10_img_url);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}


    	try {
    		
    		// 업데이트 확인 문구
    		String url = "https://github.com/dudqls5271/Maple_GG"; // 크롤링할 url지정
		  	System.out.println("==================>" + url);
			Document doc = Jsoup.connect(url).get();
			
			updateTextJ = doc.select("h1[dir=\"auto\"]").get(0).text();
			System.out.println(updateTextJ);
			
			if(updateTextJ.indexOf("Update 2.0") != -1) {
				System.out.println(updateTextJ.indexOf("Update"));
				updateText.setText("업데이트가 있습니다. 아래 링크를 통해 업데이트 해주세요.");
				updatelink.setText("https://github.com/dudqls5271/Maple_GG");
			} else {
				updatelink.setStyle("-fx-cursor: Default;");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    }   

	public void updatelink(ActionEvent event) throws URISyntaxException, IOException {
		if(updateTextJ.indexOf("Update") != -1) {
			java.awt.Desktop.getDesktop().browse(new URI("https://github.com/dudqls5271/Maple_GG"));
		}
		
	}
}