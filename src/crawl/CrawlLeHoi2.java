package crawl;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import model.LeHoi;
import model.LuuTru;

public class CrawlLeHoi2 implements Crawl{

	@Override
	public boolean crawl() {
		// TODO Auto-generated method stub
		List<LeHoi> dslehoi = new ArrayList<>();
		Document doc = null;
		Elements eles = null;
		Element ele = null;
		String link = "http://dsvh.gov.vn/danh-muc-di-san-van-hoa-phi-vat-the-quoc-gia-1789?fbclid=IwAR3CExrJaI1MGz7rr2YUm5qUjf0En-yc_3DpucSk3-jMBAx5ADBs07PgDaQ";
		try {
			doc = Jsoup.connect(link).get();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		ele = doc.selectFirst("#main-page > div.page-content > table > tbody");
		eles = ele.getElementsByTag("tr");
		eles.remove(0);
		

		for (Element element : eles) {
			LeHoi lehoi = new LeHoi();
			String diadiem = "";
			lehoi.setTen(element.child(1).text());
			lehoi.setLoaihinh(element.child(3).text());
			Elements elements = element.child(4).getElementsByTag("p");
			for (Element elm : elements) {
				diadiem = diadiem + elm.text() + ", ";
			}
			Elements thongtin = element.child(1).getElementsByTag("a");
			if (!thongtin.isEmpty()) {
				String sublink = "http://dsvh.gov.vn" + thongtin.first().attr("href");
				// dong duoi de lay thong tin
//				try {
//					doc = Jsoup.connect(sublink).get();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				ele =doc.getElementsByClass("page-content").first();
				lehoi.setThongtin(sublink);
			}
			
			lehoi.setDiadiem(diadiem);
			dslehoi.add(lehoi);
		}
		LuuTru.save(dslehoi, true);
		return true;
	}
	@Override
	public String toString() {
		return "Class CrawlLeHoi2: ";
	}

}
