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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.IOException;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class swpage implements Initializable{ 
	public static String not;
	@FXML
    private Text name_v, level_v, mr_v, un_v, pop_v, gild_v, server_v ;
	@FXML
	private ImageView img_v;
    
    @FXML
    private Hyperlink userLink;
    
    @FXML 
    private Button nav1, nav2, refresh;
    @FXML 
    private Hyperlink github;
    
    
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
		 
		 System.out.println("test");
	    	
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
	 String userLinkJ;
	 Document doc;
	@Override
    public void initialize(URL arg0, ResourceBundle arg1) {
		
		System.out.println("arg0 : " + arg0);
		System.out.println("arg1 : " + arg1);
		
    	VBox vBox1 = new VBox();
    	SplitPane.setResizableWithParent(vBox1, false);
    	
		try {
		  	String url = "https://maple.gg/u/진동아델";
		  	System.out.println("==================>" + url);
		  	
			doc = Jsoup.connect(url).get();
			userLinkJ = url;
			
			//정보
			Element user_pic = doc.select("img[class=\"character-image\"]").get(0);
			System.out.println("URL : " + user_pic.attr("src"));
			
			Elements gg_name = doc.select("b[class=\"align-middle\"]");
			String name = null;
			name = gg_name.select("b[class=\"align-middle\"]").text();
			System.out.println("닉네임 : " + name);
			
			
			
			Elements gg_sever = doc.select("img[class=\"align-middle\"]");
			System.out.println("sever_url : " + gg_sever.attr("alt"));
			
			Elements gg_Lv_op_pop = doc.select("li[class=\"user-summary-item\"]");
			String user_Lv = gg_Lv_op_pop.select("li[class=\"user-summary-item\"]").get(0).text();
			String user_op = gg_Lv_op_pop.select("li[class=\"user-summary-item\"]").get(1).text();
			String user_pop = gg_Lv_op_pop.select("li[class=\"user-summary-item\"]").get(2).text();
			System.out.println("직업 : " + user_op);
			System.out.println("Lv : " + user_Lv);
			System.out.println("인기도 : " + user_pop);
			
			Elements gg_guild = doc.select("a[class=\"text-yellow text-underline\"]");
			
			String user_guild;
			if(gg_guild.select("a[class=\"text-yellow text-underline\"]").text() == "") {
				user_guild = "길드 : 없음";
			} else {
				user_guild = ("길드 : " + gg_guild.select("a[class=\"text-yellow text-underline\"]").text());
			}
			
			System.out.println(user_guild);


			Elements gg_synthesis = doc.select("h1[class=\"user-summary-floor font-weight-bold\"]");
			Elements gg_synthesis_hr = doc.select("small[class=\"user-summary-duration\"]");
			Elements gg_synthesis_div = doc.select("div[class=\"col-lg-3 col-6 mt-3 px-1\"]");
			String img = user_pic.attr("src");
			Image img_url = new Image(img);
			
			name_v.setText("닉네임 : " + name);
			level_v.setText(user_Lv);
			pop_v.setText(user_pop);
			gild_v.setText(user_guild);
			img_v.setImage(img_url);
			server_v.setText("서버 : " + gg_sever.attr("alt"));
			
			// 마지막 업데이트
			String lastUpateJ = doc.select("span[class=\"d-block font-weight-light\"]").text();
			
			System.out.println(lastUpateJ);

			//=============================무릉==================================
			try {
				Element gg_synthesis_mr_div = gg_synthesis_div.select("div[class=\"col-lg-3 col-6 mt-3 px-1\"]").get(0);
				Element gg_synthesis_mr_div_footer = gg_synthesis_mr_div.select("footer[class=\"user-summary-box-footer\"]").get(0);
				Element user_mr_img = doc.select("img[class=\"d-inline-block mr-1\"]").get(0);
				
				String user_mr = gg_synthesis.get(0).text();
				String user_mr_hr = gg_synthesis_hr.get(0).text();
				String user_mr_info = gg_synthesis_mr_div_footer.select("span").get(0).text();
				String user_mr_world_ranking = ("월드랭킹 " + gg_synthesis_mr_div_footer.select("span").get(1).text());
				String user_mr_ranking = ("랭킹 " + gg_synthesis_mr_div_footer.select("span").get(2).text());
				System.out.println("user_mr_img : " + user_mr_img.attr("src"));
				
				System.err.print(user_mr_info + ", ");
				System.err.print(user_mr_world_ranking + ", ");
				System.err.println(user_mr_ranking);
				
				System.out.println("무릉 : " + user_mr);
				System.out.println("무릉 시간 : " + user_mr_hr);
				
				mr_v.setText("무릉 : " + user_mr + " / " + user_mr_hr);
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("무릉 : (정보없음)");
			}
			//=============================더시드==================================	
			try {
				Element gg_synthesis_the_div = gg_synthesis_div.select("div[class=\"col-lg-3 col-6 mt-3 px-1\"]").get(1);
				Element gg_synthesis_the_div_footer = gg_synthesis_the_div.select("footer[class=\"user-summary-box-footer\"]").get(0);
				
				String user_the = gg_synthesis.get(1).text();
				String user_the_hr = gg_synthesis_hr.get(1).text();
				
				String user_the_info = gg_synthesis_the_div_footer.select("span").get(0).text();
				String user_the_world_ranking = ("월드랭킹 " + gg_synthesis_the_div_footer.select("span").get(1).text());
				String user_the_ranking = ("랭킹 " + gg_synthesis_the_div_footer.select("span").get(2).text());
				
				System.out.println("==============================================================");
				System.out.print(user_the_info + ", ");
				System.out.print(user_the_world_ranking + ", ");
				System.out.println(user_the_ranking);
				System.out.println("더시드 : " + user_the);
				System.out.println("더시드 시간 : " + user_the_hr);
				System.out.println("==============================================================");
				

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("더시드 : (정보없음)");
				
			}
			//=============================유니온===================================
			try {
				Element gg_synthesis_un_div = gg_synthesis_div.select("div[class=\"col-lg-3 col-6 mt-3 px-1\"]").get(2);
				Element gg_synthesis_un_div_footer = gg_synthesis_un_div.select("footer[class=\"user-summary-box-footer\"]").get(0);
				Element gg_synthesis_un_img = gg_synthesis_un_div.selectFirst("img[class=\"user-summary-tier\"]");
				
				String user_un_info = gg_synthesis_un_div_footer.select("span").get(0).text();
				String user_un_world_ranking = ("월드랭킹 " + gg_synthesis_un_div_footer.select("span").get(1).text());
				String user_un_ranking = ("랭킹 " + gg_synthesis_un_div_footer.select("span").get(2).text());
				String user_un_img = gg_synthesis_un_img.attr("src");
				
				System.out.println("유니온 URL : " + user_un_img);
				System.out.print(user_un_info + ", ");
				System.out.print(user_un_world_ranking + ", ");
				System.out.println(user_un_ranking);
				
				Elements gg_synthesis_un = doc.select("div[class=\"user-summary-tier-string font-weight-bold\"]");
				Element gg_synthesis_un_lv = doc.select("span[class=\"user-summary-level\"]").get(0);
				String user_un_lv = gg_synthesis_un_lv.text();
				String user_un = gg_synthesis_un.get(0).text();
				System.out.println("유니온 레벨 : "  + user_un_lv);
				System.out.println("유니온 : " + user_un);				
				
				un_v.setText("유니온 : " + user_un + " / " + user_un_lv);

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("유니온 : (정보없음)");

			}
			//=============================업적===================================
			try {
				Element gg_synthesis_gread_div = gg_synthesis_div.select("div[class=\"col-lg-3 col-6 mt-3 px-1\"]").get(3);
				Element gg_synthesis_gread_div_footer = gg_synthesis_gread_div.select("footer[class=\"user-summary-box-footer\"]").get(0);
				Element gg_synthesis_gread_img = gg_synthesis_gread_div.selectFirst("img[class=\"user-summary-tier\"]");
				
				String user_gread_score = gg_synthesis_gread_div.select("span").get(0).text();
				String user_gread_info = gg_synthesis_gread_div_footer.select("span").get(0).text();
				String user_gread_world_ranking = ("월드랭킹 " + gg_synthesis_gread_div_footer.select("span").get(1).text());
				String user_gread_ranking = ("랭킹 " + gg_synthesis_gread_div_footer.select("span").get(2).text());
				String user_gread_img = gg_synthesis_gread_img.attr("src");
				

				
				System.out.println(user_gread_score);
				System.out.print(user_gread_info + ", ");
				System.out.print(user_gread_world_ranking + ", ");
				System.out.println(user_gread_ranking);
				System.out.println("업적 URL : " + user_gread_img);
				

				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("업적 : (정보없음)");

			}
			

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}

	public void github(ActionEvent event) throws URISyntaxException, IOException {
		System.out.println("link clicked!");
		java.awt.Desktop.getDesktop().browse(new URI("https://github.com/dudqls5271/Maple_GG"));
	}
	
	public void githubio(ActionEvent event) throws URISyntaxException, IOException {
		System.out.println("link clicked!");
		java.awt.Desktop.getDesktop().browse(new URI("https://dudqls5271.github.io/"));
	}
	
	public void ggpage(ActionEvent event) throws URISyntaxException, IOException {
		System.out.println("link clicked!");
		java.awt.Desktop.getDesktop().browse(new URI("https://maple.gg"));
	}
	
	public void twitter(ActionEvent event) throws URISyntaxException, IOException {
		System.out.println("link clicked!");
		java.awt.Desktop.getDesktop().browse(new URI("https://twitter.com/maple_Dkepf"));
	}

}
