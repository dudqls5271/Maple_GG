import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Scanner;

public class Crawler {
//ũ�ѷ�
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("�г��� �Է����ּ���!");
			String user_na = sc.nextLine();

			String url = "https://maple.gg/u/" + user_na; // ũ�Ѹ��� url����
			Document doc = Jsoup.connect(url).get();

			Element user_pic = doc.select("img").get(11);

			if (user_pic.attr("src").equals("https://kr-cdn.maple.gg/images/images/img-noresult.svg")) {
				System.out.println("���� �Դϴ� �ٽ� �Է����ּ���");
			} else {
				System.out.println("URL : " + user_pic.attr("src"));
				// ����
				Elements user_information1 = doc.select("ul.character-card-summary > li.character-card-summary-item");
				Elements user_information2 = doc.select("ul.user-summary-list");
				Elements user_information3 = doc.select("div.character-card-popular");
				Elements user_information4 = doc.select("ul.character-card-additional");
				Elements user_name = doc.select("div[class=\"character-card-name\"]");

				for (Element information : user_name.select("div")) {
					System.out.println("�г��� : " + information.text());
				}

				Elements information1 = user_information1;
				System.out.println("���� :" + information1.select("span").get(0).text());
				System.out.println("���� :" + information1.select("span").get(1).text());
				System.out.println("���� :" + information1.select("span").get(2).text());

				Elements information2 = user_information2;
				System.out.println("�α⵵ : " + information2.select("span").get(1).text());

				Elements information3 = user_information3;
				System.out.println("��� : " + information3.select("span").get(0).text());

				Elements information4 = user_information4;
				System.out.println("���� : " + information4.select("span").get(0).text());
				System.out.println("�ð� : " + information4.select("small").get(1).text());

				System.out.println("���Ͽ� : " + information4.select("span").get(1).text());
				System.out.println(information4.select("small").get(2).text());
				
				break;
			}
		}
	}

}
