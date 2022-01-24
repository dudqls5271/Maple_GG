import java.io.IOException;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Scanner;


public class test_re_ga {
//ũ�ѷ�
	public static void main(String[] args) throws IOException {



		String url = "https://maple.gg/u/hyunpaladin"; // ũ�Ѹ��� url����
		Document doc = Jsoup.connect(url).get();
		
		//����
		Elements user_information1 = doc.select("ul.character-card-summary > li.character-card-summary-item");
		Elements user_information2 = doc.select("ul.user-summary-list");
		Elements user_information3 = doc.select("div.character-card-popular");
		Elements user_information4 = doc.select("ul.character-card-additional");
		Elements user_name = doc.select("div[class=\"character-card-name\"]");
		Elements user_mr_the_grad = doc.select("footer.user-summary-box-footer");
		Element user_gread = doc.select("section.box user-summary-box").get(3);
		
		for (Element information : user_name.select("div")) {
			System.out.println("�г��� : " + information.text());
		}
		
		Element user_pic = doc.select("img").get(11);
			System.out.println("URL : " + user_pic.attr("src"));
			
			System.out.println("===================================================");
		Elements information1 = user_information1;
			System.out.println("���� :" + information1.select("span").get(0).text());
			System.out.println("���� :" + information1.select("span").get(1).text());
			System.out.println("���� :" + information1.select("span").get(2).text());
			System.out.println("===================================================");
		Elements information2 = user_information2;
			System.out.println("�α⵵ : " + information2.select("span").get(1).text());
			System.out.println("===================================================");
		Elements information3 = user_information3;
			System.out.println("��� : " + information3.select("span").get(0).text());
			System.out.println("===================================================");
			
		Elements information4 = user_information4;
		Elements user_mr1 = user_mr_the_grad;
		try {
			System.out.println("���� (�ֱ� ����/����) :" + user_mr1.select("span").get(0).text());
			System.out.println("���巩ŷ :" + user_mr1.select("span").get(1).text());
			System.out.println("��ŷ :" + user_mr1.select("span").get(2).text());
			System.out.println("���� : " + information4.select("span").get(0).text());
			System.out.println("�ð� : " + information4.select("small").get(1).text());
			System.out.println(user_mr1.select("span").get(3).text());
			System.out.println("===================================================");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("���� : (��Ͼ���)");
			System.out.println("===================================================");
		}
			
			if(information4.select("span").get(1).text().equals("��Ͼ���")) {
				System.out.println("���Ͽ� :(��Ͼ���)");
			}else {
				System.out.println("���Ͽ� : " + information4.select("span").get(1).text());
				System.out.println(information4.select("small").get(2).text());
				System.out.println("������ :" + user_mr1.select("span").get(8).text());
				System.out.println("���巩ŷ :" + user_mr1.select("span").get(9).text());
				System.out.println("��ŷ :" + user_mr1.select("span").get(10).text());
				System.out.println(user_mr1.select("span").get(11).text());
			}
			
			System.out.println("===================================================");
			
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
			
			System.out.println("===================================================");
	}
}
