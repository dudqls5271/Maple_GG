package linkUnion;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class linkUnion implements Initializable{
	
	@FXML 
    private Button nav1;
	
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
	private AnchorPane exp;
	 public void handleButtonActoin() throws IOException {
    	Stage stage = (Stage)nav1.getScene().getWindow();
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchUser.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
    	stage.setScene(scene);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		try {
			String url = "https://maple.gg/info/update/world"; // 크롤링할 url지정
			Document doc = Jsoup.connect(url).get();
			exp

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	} 
	
	

}
