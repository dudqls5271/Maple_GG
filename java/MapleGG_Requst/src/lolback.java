import java.io.IOException;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Scanner;


public class lolback {
//크롤러
	public static void main(String[] args) throws IOException {



		String url = "https://maple.gg/u/하암꺼억 "; // 크롤링할 url지정
		Document doc = Jsoup.connect(url).get();
		
		//정보
		Elements user_mr_the_grad = doc.select("footer.user-summary-box-footer");
		
		Elements user_mr1 = user_mr_the_grad;
		
		
		

//==========================무릉 더시드 ===================================
		
//		Element user_un_img = doc.select("img").get(19);	
//		System.out.println("유니온 URL : " + user_un_img.attr("src"));
		
		try {
			Element user_h1_1 = doc.select("h1").get(1);
			Element user_mr_hour = doc.select("small.user-summary-duration").get(0);
			
			System.out.println("무릉RE : "+user_h1_1.text());
			System.out.println("무릉 시간 : " + user_mr_hour.text());
			System.out.println("무릉 (최근 레벨/직업) :" + user_mr1.select("span").get(0).text());
			System.out.println("월드랭킹 :" + user_mr1.select("span").get(1).text());
			System.out.println("랭킹 :" + user_mr1.select("span").get(2).text());
			System.out.println(user_mr1.select("span").get(3).text());
			System.out.println("===================================================");

			try {
				Element user_the_hour = doc.select("small.user-summary-duration").get(1);
				Element user_h1_3 = doc.select("h1").get(2);
				System.out.println("더시드RE : " +user_h1_3.text());
				System.out.println("더시드 시간 : " + user_the_hour.text());
				System.out.println("더시드 (캐릭터/래벨) :" + user_mr1.select("span").get(4).text());
				System.out.println("월드 랭킹 :" + user_mr1.select("span").get(5).text());
				System.out.println("랭킹 :" + user_mr1.select("span").get(6).text());
				System.out.println(user_mr1.select("span").get(7).text());
				System.out.println("===================================================");
				
				try {
					Element user_un_img = doc.select("img").get(19);
					Element user_un_Lv = doc.select("span.user-summary-level").get(0);

					System.out.println("유니온 URL : " + user_un_img.attr("src"));
					System.out.println("유니온 등급 : " + user_un_img.attr("alt"));
					System.out.println("Lv : " + user_un_Lv.text());
					System.out.println(user_mr1.select("span").get(8).text());
					System.out.println("월드랭킹 :" + user_mr1.select("span").get(9).text());
					System.out.println("랭킹 :" + user_mr1.select("span").get(10).text());
					System.out.println(user_mr1.select("span").get(11).text());
				} catch (Exception e) {
					System.out.println("1 : " + e);
					System.out.println("유니온RE 기록 없음");
				}
			} catch (Exception e) {
				System.out.println("2 : " + e);
				System.out.println("더시드RE 기록 없음");

				Element user_un_img = doc.select("img").get(20);	
				String test_url = user_un_img.attr("src");
				
				if (test_url.equals("https://kr-cdn.maple.gg/images/images/img-placeholder.svg")) {
					System.out.println("유니온 : 정보 없음");
				} else {
					Element user_un_Lv = doc.select("span.user-summary-level").get(0);
					System.out.println("유니온 URL : " + user_un_img.attr("src"));
					System.out.println("유니온 등급 : " + user_un_img.attr("alt"));
					System.out.println("Lv : " + user_un_Lv.text());
					System.out.println(user_mr1.select("span").get(8).text());
					System.out.println("월드랭킹 :" + user_mr1.select("span").get(9).text());
					System.out.println("랭킹 :" + user_mr1.select("span").get(10).text());
				}
				
			}
		} catch (Exception e) {
			System.out.println("3 : " + e);
			System.out.println("무릉RE : 전적없음");

			try {
				Element user_the_hour = doc.select("small").get(2);
				
				Element user_h1_3 = doc.select("h1.user-summary-floor font-weight-bold").get(0);
				System.out.println("더시드RE : " +user_h1_3.text());
				System.out.println("더시드 시간 : " + user_the_hour.text());
				System.out.println("더시드 (캐릭터/래벨) :" + user_mr1.select("span").get(4).text());
				System.out.println("월드 랭킹 :" + user_mr1.select("span").get(5).text());
				System.out.println("랭킹 :" + user_mr1.select("span").get(6).text());
				System.out.println(user_mr1.select("span").get(7).text());
				System.out.println("===================================================");
//				
//				Element user_un_img = doc.select("img").get(20);	
//				System.out.println("유니온 URL : " + user_un_img.attr("src"));
			} catch (Exception e2) {
				System.out.println("4 : " + e2);
				System.out.println("더시드RE 기록 없음");
				try {
					Element user_un_img = doc.select("img").get(20);
					Element user_un_Lv = doc.select("span.user-summary-level").get(0);
					
					String test_url = user_un_img.attr("src");
					
					if (test_url.equals("https://kr-cdn.maple.gg/images/images/img-placeholder.svg")) {
						
						System.out.println("유니온 RE 기록이 없습니다.");
						
					} else {	
						
						System.out.println("유니온 URL : " + user_un_img.attr("src"));
						System.out.println("유니온 등급 : " + user_un_img.attr("alt"));
						System.out.println("Lv : " + user_un_Lv.text());
						System.out.println(user_mr1.select("span").get(0).text());
						System.out.println("월드랭킹 :" + user_mr1.select("span").get(1).text());
						System.out.println("랭킹 :" + user_mr1.select("span").get(2).text());
					}
				} catch (Exception e3) {
					// TODO: handle exception
					System.out.println("5 : " + e3);
					System.out.println("오류 큰일남 ");
				}
			}
		}
		
		
//=====================================> RE START<===================================
		
		System.out.println("=======================RE START====================");
		
		
//		row text-center
		
//		for (Element information : user_name.select("div")) {
//			System.out.println("닉네임 : " + information.text());
//		}
//		
//		Element user_pic = doc.select("img").get(11);
//			System.out.println("URL : " + user_pic.attr("src"));
//			
//			System.out.println("===================================================");
//		Elements information1 = user_information1;
//			System.out.println("서버 :" + information1.select("span").get(0).text());
//			System.out.println("레벨 :" + information1.select("span").get(1).text());
//			System.out.println("직업 :" + information1.select("span").get(2).text());
//			System.out.println("===================================================");
//		Elements information2 = user_information2;
//			System.out.println("인기도 : " + information2.select("span").get(1).text());
//			System.out.println("===================================================");
//		Elements information3 = user_information3;
//			System.out.println("길드 : " + information3.select("span").get(0).text());
//			System.out.println("===================================================");
//			
	}
}
