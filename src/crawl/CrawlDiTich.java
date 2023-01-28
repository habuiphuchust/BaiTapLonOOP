package crawl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import model.DiTich;
import model.LuuTru;

public class CrawlDiTich implements Crawl{

	
	
	@Override
	public boolean crawl() {
		// TODO Auto-generated method stub
		List<DiTich> listDiTich = new ArrayList<>();		
		String link = "http://dsvh.gov.vn/danh-muc-di-tich-quoc-gia-dac-biet-1752?fbclid=IwAR31LL_97Cr8kZbgWc7q9wM43BuoKW6lP8JPoSuf0i4U0S7P1UQRQ52RILk";
		Document doc = null;
		Document docpage = null;
		try {
			doc =Jsoup.connect(link).get();
		} catch (IOException e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
			return false;
		}
		Elements tables = doc.getElementsByTag("table");
		Element table = tables.get(0);
		Elements rows = table.getElementsByTag("tr");
		rows.remove(0);
		for (Element row : rows) {
			DiTich dt = new DiTich();
			Elements colums = row.getElementsByTag("td");
			dt.setTen(colums.get(1).text());
			dt.setDiaDiem(colums.get(3).text());
			Elements thongtin = row.child(1).getElementsByTag("a");
			if(!thongtin.isEmpty()) {
				String url = "http://dsvh.gov.vn" + thongtin.first().attr("href");
				try {
					docpage = Jsoup.connect(url).timeout(500).get();
					Element strong = docpage.select("strong").first();
					dt.setThongTin(strong.text());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			listDiTich.add(dt);
		}

		LuuTru.save(listDiTich, false);
		return true;
	}
	@Override
	public String toString() {
		return "class CrawlDiTich: ";
	}

}
