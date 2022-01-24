package application;

import java.net.URL;
import java.util.ResourceBundle;
 
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;

import java.io.IOException;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 

public class controller  implements Initializable { 
	
    @FXML
    private Text view_name, view_lv, view_gil, view_pop, view_mr, view_mr_hr, view_un, view_un_lv;
    
    @FXML
    private ImageView view_img, view_um_img;

    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	
    	String url = "https://maple.gg/u/�絨��"; // ũ�Ѹ��� url����
		Document doc;
		try {
			doc = Jsoup.connect(url).get();

			//����
			Elements user_information1 = doc.select("ul.character-card-summary > li.character-card-summary-item");
			Elements user_information2 = doc.select("ul.user-summary-list");
			Elements user_information3 = doc.select("div.character-card-popular");
			Elements user_information4 = doc.select("ul.character-card-additional");
			Elements user_name = doc.select("div[class=\"character-card-name\"]");
			Elements user_mr_the_grad = doc.select("footer.user-summary-box-footer");
			
			
			Element user_pic = doc.select("img").get(11);
			System.out.println("URL : " + user_pic.attr("src"));
			String img = user_pic.attr("src");
			
			Image img_url = new Image(img);
			
			Elements user_na = user_name;
			System.out.println("�г��� : " + user_na.select("div").text());
			String name = user_na.select("div").text();


			Elements information1 = user_information1;
			System.out.println("���� :" + information1.select("span").get(0).text());
			
			System.out.println("���� :" + information1.select("span").get(1).text());
			String lv = information1.select("span").get(1).text();
			
			System.out.println("���� :" + information1.select("span").get(2).text());
			
			Elements information2 = user_information2;
			System.out.println("�α⵵ : " + information2.select("span").get(1).text());
			String pop = information2.select("span").get(1).text();
				
			Elements information3 = user_information3;
			System.out.println("��� : " + information3.select("span").get(0).text());
			String gil = information3.select("span").get(0).text();
				
			Elements information4 = user_information4;
			Elements user_mr1 = user_mr_the_grad;
			try {
				System.out.println("���� (�ֱ� ����/����) :" + user_mr1.select("span").get(0).text());
				System.out.println("���巩ŷ :" + user_mr1.select("span").get(1).text());
				System.out.println("��ŷ :" + user_mr1.select("span").get(2).text());
				System.out.println("���� : " + information4.select("span").get(0).text());
				String user_mr_f = information4.select("span").get(0).text();
				
				System.out.println("�ð� : " + information4.select("small").get(1).text());
				String user_mr_hr = information4.select("small").get(1).text();
				
				System.out.println(user_mr1.select("span").get(3).text());
				System.out.println("===================================================");
				
				view_mr.setText(user_mr_f);
				view_mr_hr.setText(user_mr_hr);
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("���� : (��Ͼ���)");
				System.out.println("===================================================");
			}
			if(information4.select("span").get(1).text().equals("��Ͼ���")) {
				System.out.println("���Ͽ� :(��Ͼ���)");
			}else {
				System.out.println("���Ͽ� : " + information4.select("span").get(1).text());
				String user_un = information4.select("span").get(1).text();
				
				System.out.println(information4.select("small").get(2).text());
				String user_un_lv = information4.select("small").get(2).text();
				
				System.out.println("������ :" + user_mr1.select("span").get(8).text());
				System.out.println("���巩ŷ :" + user_mr1.select("span").get(9).text());
				System.out.println("��ŷ :" + user_mr1.select("span").get(10).text());
				System.out.println(user_mr1.select("span").get(11).text());
				

					Element user_un_img = doc.select("img").get(19);
					System.out.println("���Ͽ�_URL : " + user_un_img.attr("src"));
					String img_un = user_un_img.attr("src");
					Image img_un_url = new Image(img_un);
					view_um_img.setImage(img_un_url);
					
				
				view_un.setText(user_un);
				view_un_lv.setText(user_un_lv);
			}
			
			if (information4.select("span").get(2).text().equals("��Ͼ���")) {
				System.out.println("���õ� : (��Ͼ���)");
			} else {
				System.out.println("���õ� : " + information4.select("span").get(2).text());
				System.out.println("���õ� �ð� : " + information4.select("small").get(4).text());
				System.out.println("���õ� (ĳ����/����) :" + user_mr1.select("span").get(4).text());
				System.out.println("���� ��ŷ :" + user_mr1.select("span").get(5).text());
				System.out.println("��ŷ :" + user_mr1.select("span").get(6).text());
				System.out.println(user_mr1.select("span").get(7).text());
			}
			

//			view_mr_hr
			view_name.setText(name);
			view_lv.setText(lv);
			view_pop.setText(pop);
			view_gil.setText(gil);
			view_img.setImage(img_url);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
 
}
