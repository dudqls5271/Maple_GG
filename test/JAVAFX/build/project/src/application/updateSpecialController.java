package application;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class updateSpecialController implements Initializable{
	
	@FXML 
    private Button nav1, nav6;
	
	@FXML
	private ListView<String> updateListview;
	
	@FXML 
    private Hyperlink eventList1, eventList2, eventList3, eventList4, eventList5, 
    				  eventList6, eventList7, eventList8, eventList9, eventList10,
    				  eventList11, eventList12, eventList13, eventList14, eventList15;
	
	@FXML
	private Text eventdate1, eventdate2, eventdate3, eventdate4, eventdate5,
	  			 eventdate6, eventdate7, eventdate8, eventdate9, eventdate10,
	  			 eventdate11, eventdate12, eventdate13, eventdate14, eventdate15;
	
	@FXML
	private ImageView eventImg1;
	
	
	
	
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
		
	    	
//	    	Stage stage = (Stage)nav2.getScene().getWindow();
//	    	
//	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../linkUnion/link_01.fxml"));
//	        Parent root = loader.load();
//	        Scene scene = new Scene(root);
//	    	stage.setScene(scene);
	    }
	 public void swpage() throws IOException {
    	Stage stage = (Stage)nav6.getScene().getWindow();
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("SWpage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
    	stage.setScene(scene);
    }
	
	 public void handleButtonActoin() throws IOException {
    	Stage stage = (Stage)nav1.getScene().getWindow();
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchUser.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
    	stage.setScene(scene);
    }

	 public void eventNav1() throws IOException {
    	Stage stage = (Stage)nav1.getScene().getWindow();
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("updateList.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
    	stage.setScene(scene);
    }
		
	public void eventNav2() throws IOException {
    	Stage stage = (Stage)nav1.getScene().getWindow();
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("updateListworld.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
    	stage.setScene(scene);
	 }
	
	public void eventNav3() throws IOException {
    	Stage stage = (Stage)nav1.getScene().getWindow();
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("tespiaupdateList.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
    	stage.setScene(scene);
    }
		
	public void eventNav4() throws IOException {
    	Stage stage = (Stage)nav1.getScene().getWindow();
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("updateListCash.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
    	stage.setScene(scene);
    }
	
	public void eventNav5() throws IOException {
    	Stage stage = (Stage)nav1.getScene().getWindow();
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("updateListSpecial.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
    	stage.setScene(scene);
    }
	
	public void eventNav6() throws IOException {
    	Stage stage = (Stage)nav1.getScene().getWindow();
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("updateListMaster.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
    	stage.setScene(scene);
    }

	String eventUrl1, eventUrl2, eventUrl3, eventUrl4, eventUrl5, 
			eventUrl6, eventUrl7, eventUrl8, eventUrl9, eventUrl10,
			eventUrl11, eventUrl12, eventUrl13, eventUrl14, eventUrl15;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		try {
			String url = "https://maple.gg/info/update/cash/special"; // 크롤링할 url지정
			Document doc = Jsoup.connect(url).get();
			System.out.println("updateList 접속");
			
			String eventNav = doc.select("ul[id=\"seed-tab\"]").select("li").get(0).text();
			int eventNavSize = doc.select("ul[id=\"seed-tab\"]").select("li").size();
			System.out.println("test : "+ eventNav);
			System.out.println("size : " + eventNavSize);
			
			String eventText1 = doc.select("table[class=\"table table-sm\"]").select("tr").get(0).select("a").text(); 
			String eventDate1 = doc.select("table[class=\"table table-sm\"]").select("tr").get(0).select("p").text(); 
			eventUrl1 = doc.select("table[class=\"table table-sm\"]").select("a").get(0).attr("href");
			eventList1.setText("[캐시] "+eventText1);
			eventdate1.setText(eventDate1.substring(7));

			
			String eventText2 = doc.select("table[class=\"table table-sm\"]").select("tr").get(1).select("a").text(); 
			String eventDate2 = doc.select("table[class=\"table table-sm\"]").select("tr").get(1).select("p").text(); 
			eventUrl2 = doc.select("table[class=\"table table-sm\"]").select("a").get(1).attr("href");
			eventList2.setText("[캐시] "+eventText2);
			eventdate2.setText(eventDate2.substring(7));
			
			String eventText3 = doc.select("table[class=\"table table-sm\"]").select("tr").get(2).select("a").text(); 
			String eventDate3 = doc.select("table[class=\"table table-sm\"]").select("tr").get(2).select("p").text(); 
			eventUrl3 = doc.select("table[class=\"table table-sm\"]").select("a").get(2).attr("href");
			eventList3.setText("[캐시] "+eventText3);
			eventdate3.setText(eventDate3.substring(7));
			
			String eventText4 = doc.select("table[class=\"table table-sm\"]").select("tr").get(3).select("a").text(); 
			String eventDate4 = doc.select("table[class=\"table table-sm\"]").select("tr").get(3).select("p").text(); 
			eventUrl4 = doc.select("table[class=\"table table-sm\"]").select("a").get(3).attr("href");
			eventList4.setText("[캐시] "+eventText4);
			eventdate4.setText(eventDate4.substring(7));
			
			
			String eventText5 = doc.select("table[class=\"table table-sm\"]").select("tr").get(4).select("a").text(); 
			String eventDate5 = doc.select("table[class=\"table table-sm\"]").select("tr").get(4).select("p").text(); 
			eventUrl5 = doc.select("table[class=\"table table-sm\"]").select("a").get(4).attr("href");
			eventList5.setText("[캐시] "+eventText5);
			eventdate5.setText(eventDate5.substring(7));
			
			String eventText6 = doc.select("table[class=\"table table-sm\"]").select("tr").get(5).select("a").text(); 
			String eventDate6 = doc.select("table[class=\"table table-sm\"]").select("tr").get(5).select("p").text(); 
			eventUrl6 = doc.select("table[class=\"table table-sm\"]").select("a").get(5).attr("href");
			eventList6.setText("[캐시] "+eventText6);
			eventdate6.setText(eventDate6.substring(7));
			
			String eventText7 = doc.select("table[class=\"table table-sm\"]").select("tr").get(6).select("a").text(); 
			String eventDate7 = doc.select("table[class=\"table table-sm\"]").select("tr").get(6).select("p").text(); 
			eventUrl7 = doc.select("table[class=\"table table-sm\"]").select("a").get(6).attr("href");
			eventList7.setText("[캐시] "+eventText7);
			eventdate7.setText(eventDate7.substring(7));
			
			String eventText8 = doc.select("table[class=\"table table-sm\"]").select("tr").get(7).select("a").text(); 
			String eventDate8 = doc.select("table[class=\"table table-sm\"]").select("tr").get(7).select("p").text(); 
			eventUrl8 = doc.select("table[class=\"table table-sm\"]").select("a").get(7).attr("href");
			eventList8.setText("[캐시] "+eventText8);
			eventdate8.setText(eventDate8.substring(7));
			
			String eventText9 = doc.select("table[class=\"table table-sm\"]").select("tr").get(8).select("a").text(); 
			String eventDate9 = doc.select("table[class=\"table table-sm\"]").select("tr").get(8).select("p").text(); 
			eventUrl9 = doc.select("table[class=\"table table-sm\"]").select("a").get(8).attr("href");
			eventList9.setText("[캐시] "+eventText9);
			eventdate9.setText(eventDate9.substring(7));
			
			String eventText10 = doc.select("table[class=\"table table-sm\"]").select("tr").get(9).select("a").text(); 
			String eventDate10 = doc.select("table[class=\"table table-sm\"]").select("tr").get(9).select("p").text(); 
			eventUrl10 = doc.select("table[class=\"table table-sm\"]").select("a").get(9).attr("href");
			eventList10.setText("[캐시] "+eventText10);
			eventdate10.setText(eventDate10.substring(7));

			String eventText11 = doc.select("table[class=\"table table-sm\"]").select("tr").get(10).select("a").text(); 
			String eventDate11 = doc.select("table[class=\"table table-sm\"]").select("tr").get(10).select("p").text(); 
			eventUrl11 = doc.select("table[class=\"table table-sm\"]").select("a").get(10).attr("href");
			eventList11.setText("[캐시] "+eventText11);
			eventdate11.setText(eventDate11.substring(7));
			
			String eventText12 = doc.select("table[class=\"table table-sm\"]").select("tr").get(11).select("a").text(); 
			String eventDate12 = doc.select("table[class=\"table table-sm\"]").select("tr").get(11).select("p").text(); 
			eventUrl12 = doc.select("table[class=\"table table-sm\"]").select("a").get(11).attr("href");
			eventList12.setText("[캐시] "+eventText12);
			eventdate12.setText(eventDate12.substring(7));
			
			String eventText13 = doc.select("table[class=\"table table-sm\"]").select("tr").get(12).select("a").text(); 
			String eventDate13 = doc.select("table[class=\"table table-sm\"]").select("tr").get(12).select("p").text(); 
			eventUrl13 = doc.select("table[class=\"table table-sm\"]").select("a").get(12).attr("href");
			eventList13.setText("[캐시] "+eventText13);
			eventdate13.setText(eventDate13.substring(7));
			
			String eventText14 = doc.select("table[class=\"table table-sm\"]").select("tr").get(13).select("a").text(); 
			String eventDate14 = doc.select("table[class=\"table table-sm\"]").select("tr").get(13).select("p").text(); 
			eventUrl14 = doc.select("table[class=\"table table-sm\"]").select("a").get(13).attr("href");
			eventList14.setText("[캐시] "+eventText14);
			eventdate14.setText(eventDate14.substring(7));
			
			String eventText15 = doc.select("table[class=\"table table-sm\"]").select("tr").get(14).select("a").text(); 
			String eventDate15 = doc.select("table[class=\"table table-sm\"]").select("tr").get(14).select("p").text(); 
			eventUrl15 = doc.select("table[class=\"table table-sm\"]").select("a").get(14).attr("href");
			eventList15.setText("[캐시] "+eventText15);
			eventdate15.setText(eventDate15.substring(7));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	} 
	
	public void eventList1(ActionEvent event) throws URISyntaxException, IOException {
		System.out.println("link clicked!");
		java.awt.Desktop.getDesktop().browse(new URI(eventUrl1));
	}
	
	public void eventList2(ActionEvent event) throws URISyntaxException, IOException {
		System.out.println("link clicked!");
		java.awt.Desktop.getDesktop().browse(new URI(eventUrl2));
	}
	
	public void eventList3(ActionEvent event) throws URISyntaxException, IOException {
		System.out.println("link clicked!");
		java.awt.Desktop.getDesktop().browse(new URI(eventUrl3));
	}
	
	public void eventList4(ActionEvent event) throws URISyntaxException, IOException {
		System.out.println("link clicked!");
		java.awt.Desktop.getDesktop().browse(new URI(eventUrl4));
	}
	
	public void eventList5(ActionEvent event) throws URISyntaxException, IOException {
		System.out.println("link clicked!");
		java.awt.Desktop.getDesktop().browse(new URI(eventUrl5));
	}
	
	public void eventList6(ActionEvent event) throws URISyntaxException, IOException {
		System.out.println("link clicked!");
		java.awt.Desktop.getDesktop().browse(new URI(eventUrl6));
	}
	
	public void eventList7(ActionEvent event) throws URISyntaxException, IOException {
		System.out.println("link clicked!");
		java.awt.Desktop.getDesktop().browse(new URI(eventUrl7));
	}
	
	public void eventList8(ActionEvent event) throws URISyntaxException, IOException {
		System.out.println("link clicked!");
		java.awt.Desktop.getDesktop().browse(new URI(eventUrl8));
	}
	
	public void eventList9(ActionEvent event) throws URISyntaxException, IOException {
		System.out.println("link clicked!");
		java.awt.Desktop.getDesktop().browse(new URI(eventUrl9));
	}
	
	public void eventList10(ActionEvent event) throws URISyntaxException, IOException {
		System.out.println("link clicked!");
		java.awt.Desktop.getDesktop().browse(new URI(eventUrl10));
	}
	
	public void eventList11(ActionEvent event) throws URISyntaxException, IOException {
		System.out.println("link clicked!");
		java.awt.Desktop.getDesktop().browse(new URI(eventUrl11));
	}
	
	public void eventList12(ActionEvent event) throws URISyntaxException, IOException {
		System.out.println("link clicked!");
		java.awt.Desktop.getDesktop().browse(new URI(eventUrl12));
	}
	
	public void eventList13(ActionEvent event) throws URISyntaxException, IOException {
		System.out.println("link clicked!");
		java.awt.Desktop.getDesktop().browse(new URI(eventUrl13));
	}
	
	public void eventList14(ActionEvent event) throws URISyntaxException, IOException {
		System.out.println("link clicked!");
		java.awt.Desktop.getDesktop().browse(new URI(eventUrl14));
	}
	
	public void eventList15(ActionEvent event) throws URISyntaxException, IOException {
		System.out.println("link clicked!");
		java.awt.Desktop.getDesktop().browse(new URI(eventUrl15));
	}

}
