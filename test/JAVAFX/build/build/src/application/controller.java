package application;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.IOException;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class controller implements Initializable{ 
	public static String not;
	@FXML
    private Text view_name, view_lv, view_gil, 
    			 view_pop, view_mr, view_mr_hr, view_un, view_un_lv, view_the,
    			 hidden_mr_text, hidden_the_text, hidden_un_text, hidden_gread_text, view_mr_info1, view_mr_info2, view_mr_info3,
    			 view_un_info1,view_un_info2,view_un_info3,
    			 view_the_hr,
    			 view_the_info1, view_the_info2, view_the_info3,
    			 view_gread_lv,
    			 view_gread_info1, view_gread_info2, view_gread_info3,
    			 view_the_notfound,
    			 lastUpate;
    
    @FXML
    private ImageView view_img, view_um_img, view_mr_img, view_gread_img, view_server, view_the_img;
    
    @FXML
    private Hyperlink userLink;
    
    @FXML 
    private Button nav1, nav2, refresh, nav6;
    
    public void updateBut() throws IOException {
    	Stage stage = (Stage)nav2.getScene().getWindow();
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("updateList.fxml"));
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
		alert.setTitle("????!"); 
		alert.setHeaderText("???? ???? ????????"); 
		alert.showAndWait();
    }
    
    public void handleButtonActoin() throws IOException {
    	Stage stage = (Stage)nav1.getScene().getWindow();
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchUser.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
    	stage.setScene(scene);
    }
    
  
    public void swpage() throws IOException {
    	Stage stage = (Stage)nav6.getScene().getWindow();
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("SWpage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
    	stage.setScene(scene);
    }
    
	 public void linkButton() throws IOException {
		 
		 System.out.println("test");
	    	
		Alert alert = new Alert(AlertType.WARNING);
		ImageView icon = new ImageView("/img/notfind.png");
		icon.setFitHeight(60);
		icon.setFitWidth(60);
		alert.getDialogPane().setGraphic(icon);
		alert.setTitle("????!"); 
		alert.setHeaderText("???? ???? ????????"); 
		alert.showAndWait();
		
	    	
	//    	Stage stage = (Stage)nav2.getScene().getWindow();
	//    	
	//    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../linkUnion/link_01.fxml"));
	//        Parent root = loader.load();
	//        Scene scene = new Scene(root);
	//    	stage.setScene(scene);
	    }
	 String userLinkJ;
	 Document doc;
	@Override
    public void initialize(URL arg0, ResourceBundle arg1) {
		
		System.out.println("arg0 : " + arg0);
		System.out.println("arg1 : " + arg1);
		
    	VBox vBox1 = new VBox();
    	SplitPane.setResizableWithParent(vBox1, false);
    	
		try {
			System.out.println("=========> controller_Ver1" + MainController.ver1);
			
//			Scanner scan = new Scanner(System.in);
//
//	        System.out.println("???????? ??????????.");
//	        String nickname = scan.next();

		  	String url = "https://maple.gg/u/"+MainController.ver1; // ???????? url????
		  	System.out.println("==================>" + url);
		  	
			doc = Jsoup.connect(url).get();
			userLinkJ = url;
			
			//????
			Element user_pic = doc.select("img[class=\"character-image\"]").get(0);
			System.out.println("URL : " + user_pic.attr("src"));
			String img = user_pic.attr("src");
			Image img_url = new Image(img);
			
			Elements gg_name = doc.select("b[class=\"align-middle\"]");
			String name = null;
			name = gg_name.select("b[class=\"align-middle\"]").text();
			System.out.println("?????? : " + name);
		
			Elements gg_sever = doc.select("img[class=\"align-middle\"]");
			String gg_view_server= gg_sever.attr("src");
			System.out.println("sever_url : " + gg_sever.attr("src"));
			Image img_server = new Image(gg_view_server);
			
			Elements gg_Lv_op_pop = doc.select("li[class=\"user-summary-item\"]");
			String user_Lv = gg_Lv_op_pop.select("li[class=\"user-summary-item\"]").get(0).text();
			String user_op = gg_Lv_op_pop.select("li[class=\"user-summary-item\"]").get(1).text();
			String user_pop = gg_Lv_op_pop.select("li[class=\"user-summary-item\"]").get(2).text();
			System.out.println("???? : " + user_op);
			System.out.println("Lv : " + user_Lv);
			System.out.println("?????? : " + user_pop);
			
			Elements gg_guild = doc.select("a[class=\"text-yellow text-underline\"]");
			
			String user_guild;
			if(gg_guild.select("a[class=\"text-yellow text-underline\"]").text() == "") {
				user_guild = "???? : ????";
			} else {
				user_guild = ("???? : " + gg_guild.select("a[class=\"text-yellow text-underline\"]").text());
			}
			
			System.out.println(user_guild);


			Elements gg_synthesis = doc.select("h1[class=\"user-summary-floor font-weight-bold\"]");
			Elements gg_synthesis_hr = doc.select("small[class=\"user-summary-duration\"]");
			Elements gg_synthesis_div = doc.select("div[class=\"col-lg-3 col-6 mt-3 px-1\"]");
			
			// ?????? ????????
			String lastUpateJ = doc.select("span[class=\"d-block font-weight-light\"]").text();
			
			System.out.println(lastUpateJ);

			//=============================????==================================
			try {
				Element gg_synthesis_mr_div = gg_synthesis_div.select("div[class=\"col-lg-3 col-6 mt-3 px-1\"]").get(0);
				Element gg_synthesis_mr_div_footer = gg_synthesis_mr_div.select("footer[class=\"user-summary-box-footer\"]").get(0);
				Element user_mr_img = doc.select("img[class=\"d-inline-block mr-1\"]").get(0);
				
				String img_mr = user_mr_img.attr("src");
				String user_mr = gg_synthesis.get(0).text();
				String user_mr_hr = gg_synthesis_hr.get(0).text();
				String user_mr_info = gg_synthesis_mr_div_footer.select("span").get(0).text();
				String user_mr_world_ranking = ("???????? " + gg_synthesis_mr_div_footer.select("span").get(1).text());
				String user_mr_ranking = ("???? " + gg_synthesis_mr_div_footer.select("span").get(2).text());
				System.out.println("user_mr_img : " + user_mr_img.attr("src"));
				
				System.err.print(user_mr_info + ", ");
				System.err.print(user_mr_world_ranking + ", ");
				System.err.println(user_mr_ranking);
				
				Image img_mr_url = new Image(img_mr);
				System.out.println("???? : " + user_mr);
				System.out.println("???? ???? : " + user_mr_hr);
				
				view_mr_img.setImage(img_mr_url);
				view_mr.setText(user_mr);
				view_mr_hr.setText(user_mr_hr);
				view_mr_info1.setText(user_mr_info);
				view_mr_info2.setText(user_mr_world_ranking);
				view_mr_info3.setText(user_mr_ranking);
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("???? : (????????)");
				view_mr.setText("");
				view_mr_hr.setText("?????? ????????.");
				view_mr_info1.setText("");
				view_mr_info2.setText("");
				view_mr_info3.setText("");
			}
			//=============================??????==================================	
			try {
				Element gg_synthesis_the_div = gg_synthesis_div.select("div[class=\"col-lg-3 col-6 mt-3 px-1\"]").get(1);
				Element gg_synthesis_the_div_footer = gg_synthesis_the_div.select("footer[class=\"user-summary-box-footer\"]").get(0);
				
				String user_the = gg_synthesis.get(1).text();
				String user_the_hr = gg_synthesis_hr.get(1).text();
				
				String user_the_info = gg_synthesis_the_div_footer.select("span").get(0).text();
				String user_the_world_ranking = ("???????? " + gg_synthesis_the_div_footer.select("span").get(1).text());
				String user_the_ranking = ("???? " + gg_synthesis_the_div_footer.select("span").get(2).text());
				
				System.out.println("==============================================================");
				System.out.print(user_the_info + ", ");
				System.out.print(user_the_world_ranking + ", ");
				System.out.println(user_the_ranking);
				System.out.println("?????? : " + user_the);
				System.out.println("?????? ???? : " + user_the_hr);
				System.out.println("==============================================================");
				
				view_the.setText(user_the);
				view_the_hr.setText(user_the_hr);
				view_the_info1.setText(user_the_info);
				view_the_info2.setText(user_the_world_ranking);
				view_the_info3.setText(user_the_ranking);

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("?????? : (????????)");
				view_the_hr.setText("?????? ????????.");
				view_the.setText("");
				view_the_notfound.setText("");
				view_the_info1.setText("");
				view_the_info2.setText("");
				view_the_info3.setText("");
				
			}
			//=============================??????===================================
			try {
				Element gg_synthesis_un_div = gg_synthesis_div.select("div[class=\"col-lg-3 col-6 mt-3 px-1\"]").get(2);
				Element gg_synthesis_un_div_footer = gg_synthesis_un_div.select("footer[class=\"user-summary-box-footer\"]").get(0);
				Element gg_synthesis_un_img = gg_synthesis_un_div.selectFirst("img[class=\"user-summary-tier\"]");
				
				String user_un_info = gg_synthesis_un_div_footer.select("span").get(0).text();
				String user_un_world_ranking = ("???????? " + gg_synthesis_un_div_footer.select("span").get(1).text());
				String user_un_ranking = ("???? " + gg_synthesis_un_div_footer.select("span").get(2).text());
				String user_un_img = gg_synthesis_un_img.attr("src");
				
				System.out.println("?????? URL : " + user_un_img);
				System.out.print(user_un_info + ", ");
				System.out.print(user_un_world_ranking + ", ");
				System.out.println(user_un_ranking);
				
				Elements gg_synthesis_un = doc.select("div[class=\"user-summary-tier-string font-weight-bold\"]");
				Element gg_synthesis_un_lv = doc.select("span[class=\"user-summary-level\"]").get(0);
				String user_un_lv = gg_synthesis_un_lv.text();
				String user_un = gg_synthesis_un.get(0).text();
				System.out.println("?????? ???? : "  + user_un_lv);
				System.out.println("?????? : " + user_un);
	
				Image img_un = new Image(user_un_img);
				
				view_um_img.setImage(img_un);
				view_un.setText(user_un);
				view_un_lv.setText(user_un_lv);
				view_un_info1.setText(user_un_info);
				view_un_info2.setText(user_un_world_ranking);
				view_un_info3.setText(user_un_ranking);

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("?????? : (????????)");
				
				view_un.setText("");
				view_un_lv.setText("?????? ????????.");
				view_un_info1.setText("");
				view_un_info2.setText("");
				view_un_info3.setText("");
			}
			//=============================????===================================
			try {
				Element gg_synthesis_gread_div = gg_synthesis_div.select("div[class=\"col-lg-3 col-6 mt-3 px-1\"]").get(3);
				Element gg_synthesis_gread_div_footer = gg_synthesis_gread_div.select("footer[class=\"user-summary-box-footer\"]").get(0);
				Element gg_synthesis_gread_img = gg_synthesis_gread_div.selectFirst("img[class=\"user-summary-tier\"]");
				
				String user_gread_score = gg_synthesis_gread_div.select("span").get(0).text();
				String user_gread_info = gg_synthesis_gread_div_footer.select("span").get(0).text();
				String user_gread_world_ranking = ("???????? " + gg_synthesis_gread_div_footer.select("span").get(1).text());
				String user_gread_ranking = ("???? " + gg_synthesis_gread_div_footer.select("span").get(2).text());
				String user_gread_img = gg_synthesis_gread_img.attr("src");
				
				Image img_gread = new Image(user_gread_img);
				
				System.out.println(user_gread_score);
				System.out.print(user_gread_info + ", ");
				System.out.print(user_gread_world_ranking + ", ");
				System.out.println(user_gread_ranking);
				System.out.println("???? URL : " + user_gread_img);
				
				view_gread_img.setImage(img_gread);
				view_gread_lv.setText(user_gread_score);
				view_gread_info1.setText(user_gread_info);
				view_gread_info2.setText(user_gread_world_ranking);
				view_gread_info3.setText(user_gread_ranking);
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("???? : (????????)");
				view_gread_lv.setText("");
				view_gread_info1.setText("?????? ????????.");
				view_gread_info2.setText("");
				view_gread_info3.setText("");
			}
			

			userLink.setText(userLinkJ);
			view_name.setText(name);
			view_lv.setText(user_Lv + " | " + user_pop + " | " + user_guild);
			lastUpate.setText(lastUpateJ);
			//view_pop.setText(user_pop);
			//view_gil.setText(user_guild);
			view_img.setImage(img_url);
			view_server.setImage(img_server);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        
	}
	
	public void refresh() throws IOException {
		initialize(null, null);
		refresh.setText("???????? ????");
		refresh.setStyle("-fx-background-color:  #4287f5;");
	}
	
	public void userLink(ActionEvent event) throws URISyntaxException, IOException {
		System.out.println("link clicked!");
		java.awt.Desktop.getDesktop().browse(new URI(userLinkJ));
	}

}
