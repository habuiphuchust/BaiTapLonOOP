package crawl;

import java.util.ArrayList;
import java.util.List;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

import model.LuuTru;
import model.VuaVN;

public class CrawlVuaVN implements Crawl{
	private String link;
	
	public String tachTen (String s) {
		return s.replaceFirst("\\(.*\\)", "").trim();
	}
	public String tachNam (String s) {
		int i = s.indexOf('(');
		if (i == -1) return "";
		return s.substring(i);
	}

	@Override
	public boolean crawl() {
		// TODO Auto-generated method stub
		List<VuaVN> dsVua = new ArrayList<>();
		Document doc = null;
		Elements eles = null;
		link = "https://sites.google.com/site/vietnamvanhoavaconnguoi/lich-su-va-cac-nhan-vat-lich-su-tieu-bieu?fbclid=IwAR3rBPavBYFJlzBxogRkSEyQi54w-N79w1HnfRyP3yTc51Nloc6fsMVLrDs";
		try {
			doc = Jsoup.connect(link).get();;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		eles = doc.getElementsByTag("font");
		for (Element e : eles) {
			Elements e1 = e.getElementsByTag("strong");
			for (Element e2 : e1) {
				VuaVN vua = new VuaVN();
				vua.setTen(tachTen(e2.text()));
				vua.setNamTriVi(tachNam(e2.text()));
				vua.setKhac(e2.parent().ownText());
				dsVua.add(vua);
				
			}
			
		}
		while (dsVua.size() >= 124) 
			dsVua.remove(dsVua.size() - 1);
		dsVua.remove(0);
		dsVua.remove(0);
		dsVua.remove(0);	
		LuuTru.save(dsVua);
		return true;
	}
	@Override
	public String information() {
		// TODO Auto-generated method stub
		return "class CrawlVuaVN: ";
	}

}
