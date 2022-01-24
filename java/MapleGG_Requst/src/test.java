import javax.swing.*; //JTable
import java.awt.*;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class test extends JPanel {
	public static void main(String[] args) throws IOException {
		// ---------------- 화면 (창) ----------------//
		test bookCustomer = new test();
		JFrame frame = new JFrame("고객 창");
		frame.getContentPane().add(bookCustomer);// JFrame+JPanel(화면디자인)
		frame.setBounds(800,100,430,750); //x,y,w,h
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// X버튼 클릭시 종료		
	}
	
	public test() throws IOException {
//		try {
			design();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	// 고객정보 대화상자의 화면 디자인을 해주는 메서드
	public void design() throws IOException {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		// 고객정보 패널
		JPanel customerPn = new JPanel(new GridLayout(4, 4)); // import java.awt.*; -> 해야 GridLayout(4,1) 에러가 없어짐

//		customerPn.setBorder(
//				new TitledBorder(new TitledBorder("인게임 정보"), "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.LEFT));
		JPanel cPn1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel cPn2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel cPn3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel cPn4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		String user_na = "진동아델";
		
		String maple_url = "https://maple.gg/u/" + user_na; // 크롤링할 url지정
		Document doc = Jsoup.connect(maple_url).get();

		Element user_pic = doc.select("img").get(11);
		
		// 정보
		Elements user_information1 = doc.select("ul.character-card-summary > li.character-card-summary-item");
		Elements user_information2 = doc.select("ul.user-summary-list");
		Elements user_information3 = doc.select("div.character-card-popular");
		Elements user_information4 = doc.select("ul.character-card-additional");
		
		Elements user_name = doc.select("div[class=\"character-card-name\"]");
		
		Elements information1 = user_information1;
		
		System.out.println("서버 :" + information1.select("span").get(0).text());
		String String_server = information1.select("span").get(0).text();
		
		System.out.println("레벨 :" + information1.select("span").get(1).text());
		String String_Lv = information1.select("span").get(1).text();
		System.out.println("직업 :" + information1.select("span").get(2).text());

		Elements information2 = user_information2;
		System.out.println("인기도 : " + information2.select("span").get(1).text());

		Elements information3 = user_information3;
		System.out.println("길드 : " + information3.select("span").get(0).text());

		Elements information4 = user_information4;
		System.out.println("무릉 : " + information4.select("span").get(0).text());
		System.out.println("시간 : " + information4.select("small").get(1).text());

		System.out.println("유니온 : " + information4.select("span").get(1).text());
		System.out.println(information4.select("small").get(2).text());
		
		Font f1 = new Font("메이플스토리", Font.PLAIN, 20);
		
		Image image = null;
		
		try {
			URL url = new URL(user_pic.attr("src"));
			image = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JLabel label = new JLabel(new ImageIcon(image));
		JLabel view = new JLabel("<html><p>"+user_na+"</span><br><p style= 'padding = 10px'>"+String_server+"</p></html>");
		JLabel view_server = new JLabel(String_server);
		
//		JLabel t = new JLabel("<html>"+user_na+"<br>bbb</html>");
		
		
		cPn1.add(label);
		cPn1.add(view).setFont(f1);
//		cPn1.add(view_server).setFont(f1);
//		cPn1.add(new JLabel(String_Lv)).setFont(f1);
		

		
//		cPn1.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 0 , 0));
		 
		customerPn.add(cPn1);
		customerPn.add(cPn2);
		customerPn.add(cPn3);
		customerPn.add(cPn4);
		this.add(customerPn);

	}

}