package crawl;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import model.LuuTru;
import model.SuKien;

public class CrawlSK implements Crawl {
	@Override
	public boolean crawl() {
		// TODO Auto-generated method stub
		List <SuKien> listSuKien = new ArrayList<>();
		SuKien sk; 
		Document doc = null;
		try {
			doc = Jsoup.connect("https://vi.wikipedia.org/wiki/Ni%C3%AAn_bi%E1%BB%83u_l%E1%BB%8Bch_s%E1%BB%AD_Vi%E1%BB%87t_Nam").get();
		} catch (Exception e1) {
			e1.printStackTrace();
			return false;
		}
			
			
		Elements elements = doc.getElementsByTag("div");	//chọn các thẻ div, một trong số chúng chứa dữ liệu
		Element area = elements.get(117);	                //chọn thẻ div chứa dữ liệu cần crawl
		Elements data = area.getElementsByTag("p");	        //lấy dữ liệu (được chứa trong các thẻ p)
		
		for (int i=0; i<=5; i++) {		
			data.remove(0);
		}
		data.remove(30);		
		data.remove(40);
		data.remove(51);
		data.remove(51);
		data.remove(55);
		data.remove(55);
		data.remove(62);
		data.remove(67);
		data.remove(87);
		data.remove(89);
		data.remove(95);
		data.remove(100);
		data.remove(101);
		data.remove(101);
		data.remove(101);
		data.remove(106);
		data.remove(106);
		data.remove(108);
		data.remove(108);
		data.remove(108);
		data.remove(108);
		data.remove(108);
		data.remove(108);
		data.remove(108);
		data.remove(108);
		data.remove(108);
		data.remove(110);
		data.remove(110);
		data.remove(112);
		data.remove(114);
		data.remove(114);
		data.remove(114);
		data.remove(114);
		data.remove(114);
		data.remove(114);
		data.remove(117);
		data.remove(117);
		data.remove(117);
		data.remove(117);
			
		for (Element d : data) {
			sk = new SuKien();
			Elements event = d.getElementsByTag("a");
			Elements time = d.getElementsByTag("b");
			sk.setSuKien(event.text());
			sk.setThoiGian(time.text());
			listSuKien.add(sk);	
		}
		LuuTru.save(listSuKien, false);
		return true;
	}
	@Override
	public String toString() {
		return "class CrawlSK: ";
	}
}
