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
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class updatworldecontroller implements Initializable{
	
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
	
	 public void handleButtonActoin() throws IOException {
    	Stage stage = (Stage)nav1.getScene().getWindow();
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchUser.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
    	stage.setScene(scene);
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
			String url = "https://maple.gg/info/update/world"; // 크롤링할 url지정
			Document doc = Jsoup.connect(url).get();
			System.out.println("updateList 접속");
			
			String eventNav = doc.select("ul[id=\"seed-tab\"]").select("li").get(0).text();
			int eventNavSize = doc.select("ul[id=\"seed-tab\"]").select("li").size();
			System.out.println("test : "+ eventNav);
			System.out.println("size : " + eventNavSize);
			
			
			//업데이트 list 불러오기 text-center d-none d-sm-table-cell
			
			String eventText1 = doc.select("section[class=\"container mt-4\"]").select("a[class=\"text-black\"]").get(0).text();
			String eventDate1 = doc.select("td[class=\"text-center d-none d-sm-table-cell\"]").get(1).text();
			eventUrl1 = doc.select("section[class=\"container mt-4\"]").select("a[class=\"text-black\"]").get(0).attr("href");
			eventList1.setText(eventText1);
			eventdate1.setText(eventDate1);
			
			String eventText2 = doc.select("section[class=\"container mt-4\"]").select("a[class=\"text-black\"]").get(1).text();
			String eventDate2 = doc.select("td[class=\"text-center d-none d-sm-table-cell\"]").get(3).text();
			eventUrl2 = doc.select("section[class=\"container mt-4\"]").select("a[class=\"text-black\"]").get(1).attr("href");
			eventList2.setText(eventText2);
			eventdate2.setText(eventDate2);
			
			String eventText3 = doc.select("section[class=\"container mt-4\"]").select("a[class=\"text-black\"]").get(2).text();
			String eventDate3 = doc.select("td[class=\"text-center d-none d-sm-table-cell\"]").get(5).text();
			eventUrl3 = doc.select("section[class=\"container mt-4\"]").select("a[class=\"text-black\"]").get(2).attr("href");
			eventList3.setText(eventText3);
			eventdate3.setText(eventDate3);
			
			String eventText4 = doc.select("section[class=\"container mt-4\"]").select("a[class=\"text-black\"]").get(3).text();
			String eventDate4 = doc.select("td[class=\"text-center d-none d-sm-table-cell\"]").get(7).text();
			eventUrl4 = doc.select("section[class=\"container mt-4\"]").select("a[class=\"text-black\"]").get(3).attr("href");
			eventList4.setText(eventText4);
			eventdate4.setText(eventDate4);
			
			String eventText5 = doc.select("section[class=\"container mt-4\"]").select("a[class=\"text-black\"]").get(3).text();
			String eventDate5 = doc.select("td[class=\"text-center d-none d-sm-table-cell\"]").get(9).text();
			eventUrl5 = doc.select("section[class=\"container mt-4\"]").select("a[class=\"text-black\"]").get(3).attr("href");
			eventList5.setText(eventText5);
			eventdate5.setText(eventDate5);
			
			String eventText6 = doc.select("section[class=\"container mt-4\"]").select("a[class=\"text-black\"]").get(4).text();
			String eventDate6 = doc.select("td[class=\"text-center d-none d-sm-table-cell\"]").get(11).text();
			eventUrl6 = doc.select("section[class=\"container mt-4\"]").select("a[class=\"text-black\"]").get(4).attr("href");
			eventList6.setText(eventText6);
			eventdate6.setText(eventDate6);
			
			String eventText7 = doc.select("section[class=\"container mt-4\"]").select("a[class=\"text-black\"]").get(5).text();
			String eventDate7 = doc.select("td[class=\"text-center d-none d-sm-table-cell\"]").get(13).text();
			eventUrl7 = doc.select("section[class=\"container mt-4\"]").select("a[class=\"text-black\"]").get(4).attr("href");
			eventList7.setText(eventText7);
			eventdate7.setText(eventDate7);
			
			String eventText8 = doc.select("section[class=\"container mt-4\"]").select("a[class=\"text-black\"]").get(6).text();
			String eventDate8 = doc.select("td[class=\"text-center d-none d-sm-table-cell\"]").get(15).text();
			eventUrl8 = doc.select("section[class=\"container mt-4\"]").select("a[class=\"text-black\"]").get(6).attr("href");
			eventList8.setText(eventText8);
			eventdate8.setText(eventDate8);
			
			String eventText9 = doc.select("section[class=\"container mt-4\"]").select("a[class=\"text-black\"]").get(7).text();
			String eventDate9 = doc.select("td[class=\"text-center d-none d-sm-table-cell\"]").get(17).text();
			eventUrl9 = doc.select("section[class=\"container mt-4\"]").select("a[class=\"text-black\"]").get(7).attr("href");
			eventList9.setText(eventText9);
			eventdate9.setText(eventDate9);
			
			String eventText10 = doc.select("section[class=\"container mt-4\"]").select("a[class=\"text-black\"]").get(8).text();
			String eventDate10 = doc.select("td[class=\"text-center d-none d-sm-table-cell\"]").get(19).text();
			eventUrl10 = doc.select("section[class=\"container mt-4\"]").select("a[class=\"text-black\"]").get(8).attr("href");
			eventList10.setText(eventText10);
			eventdate10.setText(eventDate10);
			
			String eventText11 = doc.select("section[class=\"container mt-4\"]").select("a[class=\"text-black\"]").get(9).text();
			String eventDate11 = doc.select("td[class=\"text-center d-none d-sm-table-cell\"]").get(21).text();
			eventUrl11 = doc.select("section[class=\"container mt-4\"]").select("a[class=\"text-black\"]").get(9).attr("href");
			eventList11.setText(eventText11);
			eventdate11.setText(eventDate11);
			
			String eventText12 = doc.select("section[class=\"container mt-4\"]").select("a[class=\"text-black\"]").get(10).text();
			String eventDate12 = doc.select("td[class=\"text-center d-none d-sm-table-cell\"]").get(23).text();
			eventUrl12 = doc.select("section[class=\"container mt-4\"]").select("a[class=\"text-black\"]").get(10).attr("href");
			eventList12.setText(eventText12);
			eventdate12.setText(eventDate12);
			
			String eventText13 = doc.select("section[class=\"container mt-4\"]").select("a[class=\"text-black\"]").get(11).text();
			String eventDate13 = doc.select("td[class=\"text-center d-none d-sm-table-cell\"]").get(25).text();
			eventUrl13 = doc.select("section[class=\"container mt-4\"]").select("a[class=\"text-black\"]").get(11).attr("href");
			eventList13.setText(eventText13);
			eventdate13.setText(eventDate13);
			
			String eventText14 = doc.select("section[class=\"container mt-4\"]").select("a[class=\"text-black\"]").get(12).text();
			String eventDate14 = doc.select("td[class=\"text-center d-none d-sm-table-cell\"]").get(27).text();
			eventUrl14 = doc.select("section[class=\"container mt-4\"]").select("a[class=\"text-black\"]").get(12).attr("href");
			eventList14.setText(eventText14);
			eventdate14.setText(eventDate14);
			
			String eventText15 = doc.select("section[class=\"container mt-4\"]").select("a[class=\"text-black\"]").get(13).text();
			String eventDate15 = doc.select("td[class=\"text-center d-none d-sm-table-cell\"]").get(29).text();
			eventUrl15 = doc.select("section[class=\"container mt-4\"]").select("a[class=\"text-black\"]").get(13).attr("href");
			eventList15.setText(eventText15);
			eventdate15.setText(eventDate15);
			
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
