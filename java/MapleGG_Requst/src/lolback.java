import java.io.IOException;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Scanner;


public class lolback {
//ũ�ѷ�
	public static void main(String[] args) throws IOException {



		String url = "https://maple.gg/u/�Ͼϲ��� "; // ũ�Ѹ��� url����
		Document doc = Jsoup.connect(url).get();
		
		//����
		Elements user_mr_the_grad = doc.select("footer.user-summary-box-footer");
		
		Elements user_mr1 = user_mr_the_grad;
		
		
		

//==========================���� ���õ� ===================================
		
//		Element user_un_img = doc.select("img").get(19);	
//		System.out.println("���Ͽ� URL : " + user_un_img.attr("src"));
		
		try {
			Element user_h1_1 = doc.select("h1").get(1);
			Element user_mr_hour = doc.select("small.user-summary-duration").get(0);
			
			System.out.println("����RE : "+user_h1_1.text());
			System.out.println("���� �ð� : " + user_mr_hour.text());
			System.out.println("���� (�ֱ� ����/����) :" + user_mr1.select("span").get(0).text());
			System.out.println("���巩ŷ :" + user_mr1.select("span").get(1).text());
			System.out.println("��ŷ :" + user_mr1.select("span").get(2).text());
			System.out.println(user_mr1.select("span").get(3).text());
			System.out.println("===================================================");

			try {
				Element user_the_hour = doc.select("small.user-summary-duration").get(1);
				Element user_h1_3 = doc.select("h1").get(2);
				System.out.println("���õ�RE : " +user_h1_3.text());
				System.out.println("���õ� �ð� : " + user_the_hour.text());
				System.out.println("���õ� (ĳ����/����) :" + user_mr1.select("span").get(4).text());
				System.out.println("���� ��ŷ :" + user_mr1.select("span").get(5).text());
				System.out.println("��ŷ :" + user_mr1.select("span").get(6).text());
				System.out.println(user_mr1.select("span").get(7).text());
				System.out.println("===================================================");
				
				try {
					Element user_un_img = doc.select("img").get(19);
					Element user_un_Lv = doc.select("span.user-summary-level").get(0);

					System.out.println("���Ͽ� URL : " + user_un_img.attr("src"));
					System.out.println("���Ͽ� ��� : " + user_un_img.attr("alt"));
					System.out.println("Lv : " + user_un_Lv.text());
					System.out.println(user_mr1.select("span").get(8).text());
					System.out.println("���巩ŷ :" + user_mr1.select("span").get(9).text());
					System.out.println("��ŷ :" + user_mr1.select("span").get(10).text());
					System.out.println(user_mr1.select("span").get(11).text());
				} catch (Exception e) {
					System.out.println("1 : " + e);
					System.out.println("���Ͽ�RE ��� ����");
				}
			} catch (Exception e) {
				System.out.println("2 : " + e);
				System.out.println("���õ�RE ��� ����");

				Element user_un_img = doc.select("img").get(20);	
				String test_url = user_un_img.attr("src");
				
				if (test_url.equals("https://kr-cdn.maple.gg/images/images/img-placeholder.svg")) {
					System.out.println("���Ͽ� : ���� ����");
				} else {
					Element user_un_Lv = doc.select("span.user-summary-level").get(0);
					System.out.println("���Ͽ� URL : " + user_un_img.attr("src"));
					System.out.println("���Ͽ� ��� : " + user_un_img.attr("alt"));
					System.out.println("Lv : " + user_un_Lv.text());
					System.out.println(user_mr1.select("span").get(8).text());
					System.out.println("���巩ŷ :" + user_mr1.select("span").get(9).text());
					System.out.println("��ŷ :" + user_mr1.select("span").get(10).text());
				}
				
			}
		} catch (Exception e) {
			System.out.println("3 : " + e);
			System.out.println("����RE : ��������");

			try {
				Element user_the_hour = doc.select("small").get(2);
				
				Element user_h1_3 = doc.select("h1.user-summary-floor font-weight-bold").get(0);
				System.out.println("���õ�RE : " +user_h1_3.text());
				System.out.println("���õ� �ð� : " + user_the_hour.text());
				System.out.println("���õ� (ĳ����/����) :" + user_mr1.select("span").get(4).text());
				System.out.println("���� ��ŷ :" + user_mr1.select("span").get(5).text());
				System.out.println("��ŷ :" + user_mr1.select("span").get(6).text());
				System.out.println(user_mr1.select("span").get(7).text());
				System.out.println("===================================================");
//				
//				Element user_un_img = doc.select("img").get(20);	
//				System.out.println("���Ͽ� URL : " + user_un_img.attr("src"));
			} catch (Exception e2) {
				System.out.println("4 : " + e2);
				System.out.println("���õ�RE ��� ����");
				try {
					Element user_un_img = doc.select("img").get(20);
					Element user_un_Lv = doc.select("span.user-summary-level").get(0);
					
					String test_url = user_un_img.attr("src");
					
					if (test_url.equals("https://kr-cdn.maple.gg/images/images/img-placeholder.svg")) {
						
						System.out.println("���Ͽ� RE ����� �����ϴ�.");
						
					} else {	
						
						System.out.println("���Ͽ� URL : " + user_un_img.attr("src"));
						System.out.println("���Ͽ� ��� : " + user_un_img.attr("alt"));
						System.out.println("Lv : " + user_un_Lv.text());
						System.out.println(user_mr1.select("span").get(0).text());
						System.out.println("���巩ŷ :" + user_mr1.select("span").get(1).text());
						System.out.println("��ŷ :" + user_mr1.select("span").get(2).text());
					}
				} catch (Exception e3) {
					// TODO: handle exception
					System.out.println("5 : " + e3);
					System.out.println("���� ū�ϳ� ");
				}
			}
		}
		
		
//=====================================> RE START<===================================
		
		System.out.println("=======================RE START====================");
		
		
//		row text-center
		
//		for (Element information : user_name.select("div")) {
//			System.out.println("�г��� : " + information.text());
//		}
//		
//		Element user_pic = doc.select("img").get(11);
//			System.out.println("URL : " + user_pic.attr("src"));
//			
//			System.out.println("===================================================");
//		Elements information1 = user_information1;
//			System.out.println("���� :" + information1.select("span").get(0).text());
//			System.out.println("���� :" + information1.select("span").get(1).text());
//			System.out.println("���� :" + information1.select("span").get(2).text());
//			System.out.println("===================================================");
//		Elements information2 = user_information2;
//			System.out.println("�α⵵ : " + information2.select("span").get(1).text());
//			System.out.println("===================================================");
//		Elements information3 = user_information3;
//			System.out.println("��� : " + information3.select("span").get(0).text());
//			System.out.println("===================================================");
//			
	}
}
