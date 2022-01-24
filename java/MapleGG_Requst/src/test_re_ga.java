import java.io.IOException;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Scanner;


public class test_re_ga {
//크롤러
	public static void main(String[] args) throws IOException {



		String url = "https://maple.gg/u/hyunpaladin"; // 크롤링할 url지정
		Document doc = Jsoup.connect(url).get();
		
		//정보
		Elements user_information1 = doc.select("ul.character-card-summary > li.character-card-summary-item");
		Elements user_information2 = doc.select("ul.user-summary-list");
		Elements user_information3 = doc.select("div.character-card-popular");
		Elements user_information4 = doc.select("ul.character-card-additional");
		Elements user_name = doc.select("div[class=\"character-card-name\"]");
		Elements user_mr_the_grad = doc.select("footer.user-summary-box-footer");
		Element user_gread = doc.select("section.box user-summary-box").get(3);
		
		for (Element information : user_name.select("div")) {
			System.out.println("닉네임 : " + information.text());
		}
		
		Element user_pic = doc.select("img").get(11);
			System.out.println("URL : " + user_pic.attr("src"));
			
			System.out.println("===================================================");
		Elements information1 = user_information1;
			System.out.println("서버 :" + information1.select("span").get(0).text());
			System.out.println("레벨 :" + information1.select("span").get(1).text());
			System.out.println("직업 :" + information1.select("span").get(2).text());
			System.out.println("===================================================");
		Elements information2 = user_information2;
			System.out.println("인기도 : " + information2.select("span").get(1).text());
			System.out.println("===================================================");
		Elements information3 = user_information3;
			System.out.println("길드 : " + information3.select("span").get(0).text());
			System.out.println("===================================================");
			
		Elements information4 = user_information4;
		Elements user_mr1 = user_mr_the_grad;
		try {
			System.out.println("무릉 (최근 레벨/직업) :" + user_mr1.select("span").get(0).text());
			System.out.println("월드랭킹 :" + user_mr1.select("span").get(1).text());
			System.out.println("랭킹 :" + user_mr1.select("span").get(2).text());
			System.out.println("무릉 : " + information4.select("span").get(0).text());
			System.out.println("시간 : " + information4.select("small").get(1).text());
			System.out.println(user_mr1.select("span").get(3).text());
			System.out.println("===================================================");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("무릉 : (기록없음)");
			System.out.println("===================================================");
		}
			
			if(information4.select("span").get(1).text().equals("기록없음")) {
				System.out.println("유니온 :(기록없음)");
			}else {
				System.out.println("유니온 : " + information4.select("span").get(1).text());
				System.out.println(information4.select("small").get(2).text());
				System.out.println("전투력 :" + user_mr1.select("span").get(8).text());
				System.out.println("월드랭킹 :" + user_mr1.select("span").get(9).text());
				System.out.println("랭킹 :" + user_mr1.select("span").get(10).text());
				System.out.println(user_mr1.select("span").get(11).text());
			}
			
			System.out.println("===================================================");
			
			if (information4.select("span").get(2).text().equals("기록없음")) {
				System.out.println("더시드 : (기록없음)");
			} else {
				System.out.println("더시드 : " + information4.select("span").get(2).text());
				System.out.println("더시드 시간 : " + information4.select("small").get(4).text());
				System.out.println("더시드 (캐릭터/래벨) :" + user_mr1.select("span").get(4).text());
				System.out.println("월드 랭킹 :" + user_mr1.select("span").get(5).text());
				System.out.println("랭킹 :" + user_mr1.select("span").get(6).text());
				System.out.println(user_mr1.select("span").get(7).text());
			}
			
			System.out.println("===================================================");
	}
}
