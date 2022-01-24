import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Scanner;

public class Crawler {
//크롤러
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("닉네임 입력해주세요!");
			String user_na = sc.nextLine();

			String url = "https://maple.gg/u/" + user_na; // 크롤링할 url지정
			Document doc = Jsoup.connect(url).get();

			Element user_pic = doc.select("img").get(11);

			if (user_pic.attr("src").equals("https://kr-cdn.maple.gg/images/images/img-noresult.svg")) {
				System.out.println("오류 입니다 다시 입력해주세요");
			} else {
				System.out.println("URL : " + user_pic.attr("src"));
				// 정보
				Elements user_information1 = doc.select("ul.character-card-summary > li.character-card-summary-item");
				Elements user_information2 = doc.select("ul.user-summary-list");
				Elements user_information3 = doc.select("div.character-card-popular");
				Elements user_information4 = doc.select("ul.character-card-additional");
				Elements user_name = doc.select("div[class=\"character-card-name\"]");

				for (Element information : user_name.select("div")) {
					System.out.println("닉네임 : " + information.text());
				}

				Elements information1 = user_information1;
				System.out.println("서버 :" + information1.select("span").get(0).text());
				System.out.println("레벨 :" + information1.select("span").get(1).text());
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
				
				break;
			}
		}
	}

}
