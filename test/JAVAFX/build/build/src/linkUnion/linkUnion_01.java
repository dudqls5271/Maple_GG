package linkUnion;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class linkUnion_01 implements Initializable{
	
	@FXML 
    private Button nav1, eventNav1, eventNav2, eventNav3;
	
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
	 
	 public void eventNav1() throws IOException {
	    	Stage stage = (Stage)eventNav1.getScene().getWindow();
	    	
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../linkUnion/link_01.fxml"));
	        Parent root = loader.load();
	        Scene scene = new Scene(root);
	    	stage.setScene(scene);
	    }
	 
	 public void eventNav2() throws IOException {
	    	Stage stage = (Stage)eventNav2.getScene().getWindow();
	    	
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../linkUnion/link_02.fxml"));
	        Parent root = loader.load();
	        Scene scene = new Scene(root);
	    	stage.setScene(scene);
	    }
	 public void eventNav3() throws IOException {
	    	Stage stage = (Stage)eventNav3.getScene().getWindow();
	    	
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../linkUnion/link_01.fxml"));
	        Parent root = loader.load();
	        Scene scene = new Scene(root);
	    	stage.setScene(scene);
	    }
	 
	@FXML
    private TableView<linkVO> myTableView;
    
    @FXML
    private TableColumn<linkVO, String> job;
    
    @FXML
    private TableColumn<linkVO, String> skill;
    
    @FXML
    private TableColumn<linkVO, String> effect;


    
	@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
		try {
			String url = "https://maple.gg/info/link"; // 크롤링할 url지정
			Document doc = Jsoup.connect(url).get();
			
			Element linkTr;
			Elements linkTd = null;
			Elements linkTh;
			Elements linkImg;
			
			List<Integer> tableNum = new ArrayList<>();
			
			List<String> category = new ArrayList<>();
			
	        Map<String, Object> jobMap = new HashMap<String, Object>();
	        Map<String, Object> skillMap = new HashMap<String, Object>();
	        Map<String, Object> effectMap = new HashMap<String, Object>();
	        Map<String, Object> imgMap = new HashMap<String, Object>();

	        Elements categoryElement = doc.select("h3[class=\"mb-4\"]");

	        for(int i = 0; i < categoryElement.size(); i++) {
	        	category.add(categoryElement.get(i).text());
	        }
	        
	        System.out.println(category);
	        
			for (int i = 0; i <= 2; i++) {
				List<String> jobList = new ArrayList<>();
				List<String> skillList = new ArrayList<>();
				List<String> effectList = new ArrayList<>();
				List<String> imgList = new ArrayList<>();
				
				Element linkTable = doc.select("table[class=\"table table-sm\"]").get(i); // +1
				int linkTrSize = linkTable.select("tr").size();
				tableNum.add(linkTrSize);
				
				if(tableNum.get(i) == linkTrSize) {
					for(int j = 0; j <= linkTrSize-2; j++) {
						
						if (j % 2 == 0) {
							linkTr = linkTable.select("tbody").select("tr").get(j); // +2
							linkTd = linkTr.select("th");
							linkTh = linkTr.select("td");
							linkImg = linkTr.select("img");
							
							
							
							jobList.add(linkTd.text());
							skillList.add(linkTh.get(0).text());
							effectList.add(linkTh.get(1).text());
							imgList.add(linkImg.attr("src"));
						}
					}
				}
				
				jobMap.put(category.get(i), jobList);
				skillMap.put(category.get(i), skillList);
				effectMap.put(category.get(i), effectList);
				imgMap.put(category.get(i), imgList);
			}			

			for(int i = 0; i < categoryElement.size(); i++) {
				
				job.setCellValueFactory(cellData -> cellData.getValue().jobProperty());
				skill.setCellValueFactory(cellData -> cellData.getValue().skillProperty());
				effect.setCellValueFactory(cellData -> cellData.getValue().effectProperty());
				
				myTableView.getItems().add(new linkVO(
					new SimpleStringProperty(((ArrayList<String>) jobMap.get(category.get(0))).get(i)), 
					new SimpleStringProperty(((ArrayList<String>) skillMap.get(category.get(0))).get(i)), 
					new SimpleStringProperty(((ArrayList<String>) effectMap.get(category.get(0))).get(i)))
					);
			}
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	} 
	
	

}
