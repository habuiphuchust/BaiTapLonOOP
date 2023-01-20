package crawl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

import model.ThoiKy;

public class CrawlTK implements Crawl{
	
	public static void main (String[] args) {
		List<ThoiKy> dsThoiKy = new ArrayList<>();
		Document doc = null;
		Elements eles = null;
		Element ele = null;
		try {
			doc = Jsoup.connect("https://sites.google.com/site/vietnamvanhoavaconnguoi/lich-su-va-cac-nhan-vat-lich-su-tieu-bieu?fbclid=IwAR3rBPavBYFJlzBxogRkSEyQi54w-N79w1HnfRyP3yTc51Nloc6fsMVLrDs").get();;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		ele = doc.selectFirst("#sites-canvas-main-content > table > tbody > tr > td > div > div:nth-child(2)");
		eles = ele.getElementsByTag("font");
		int i = 0;
		for (Element e : eles) {
			System.out.println("\n" + e.text());
			System.out.println(i++);
		}

//		System.out.println(eles.get(1));
		
	}

	@Override
	public boolean crawl() {
		// TODO Auto-generated method stub
		return false;
	}

}
