package crawl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlLeHoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Document doc = null;
		Elements eles = null;
		Element ele = null;
		try {
			doc = Jsoup.connect("https://sites.google.com/site/vietnamvanhoavaconnguoi/cac-phong-tuc-tap-quan-va-le-hoi").get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ele = doc.selectFirst("#sites-canvas-main-content > table > tbody > tr > td > div > div:nth-child(2) > div");
		eles = ele.children();
		int i = 0;
		for (Element e : eles) {
			System.out.println(i++);
			System.out.println(" "+e.text() + "\n" + e.tagName() + "\n");
		}
		

	}

}
