package crawl;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import model.LeHoi;
import model.LuuTru;

public class CrawlLeHoi implements Crawl {
	private String link;
	private String locten(String ten) {
		int i = ten.indexOf('.');
		if (i == -1) return "";
		return ten.substring(i+1).trim();
	}

	@Override
	public boolean crawl() {
		// TODO Auto-generated method stub
		List<LeHoi> dslehoi = new ArrayList<>();
		Document doc = null;
		Elements eles = null;
		Element ele = null;
		link = "https://sites.google.com/site/vietnamvanhoavaconnguoi/cac-phong-tuc-tap-quan-va-le-hoi";
		try {
			doc = Jsoup.connect(link).get();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		ele = doc.selectFirst("#sites-canvas-main-content > table > tbody > tr > td > div > div:nth-child(2) > div");
		eles = ele.children();
		for (int i = 0; i < 49; i++) 
			eles.remove(0);
		eles.remove(88);
		eles.remove(55);
		eles.remove(54);
		eles.remove(7);
		
		LeHoi lehoi = new LeHoi();
		for (int j=0; j < eles.size(); j++) {
			if (eles.get(j).tagName() == "h3") {
				lehoi = new LeHoi();
				lehoi.setTen(locten(eles.get(j).text()));
			}
			if (eles.get(j).tagName() == "p") {
				lehoi.setThongtin(eles.get(j).text() + "<br>");
			}
			if (j == eles.size()-1) 
				dslehoi.add(lehoi);
			else if (eles.get(j+1).tagName() == "h3")
				dslehoi.add(lehoi);
		}

		LuuTru.save(dslehoi, false);
		return true;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "class CrawlLeHoi: ";
	}

}
