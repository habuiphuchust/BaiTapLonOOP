package crawl;

import java.util.ArrayList;
import java.util.List;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


import org.jsoup.nodes.Element;

import model.LuuTru;
import model.VuaVN;

public class CrawlVuaVN2{
	private static String link;
	

	public static String locSup (String s) {
		int star, end;
		while (s.indexOf('[') != -1) {
			star = s.indexOf('[');
			end = s.indexOf(']');
			s = s.substring(0, star) + s.substring(end+1);
		}
		return s;
	}


	public static boolean crawl() {
		// TODO Auto-generated method stub
		List<VuaVN> dsVua = new ArrayList<>();
		Document doc = null;
		link = "https://vi.wikipedia.org/wiki/Vua_Vi%E1%BB%87t_Nam";
		try {
			doc = Jsoup.connect(link).get();;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		Elements tables = doc.getElementsByTag("table");
		tables.remove(0);
		tables.remove(0);
		tables.remove(0);
		tables.remove(10);
		tables.remove(10);
		tables.remove(11);
		tables.remove(12);
		tables.remove(13);
		tables.remove(14);
		tables.remove(15);
		tables.remove(16);
		tables.remove(17);
		tables.remove(17);
		tables.remove(18);
		tables.remove(19);
		tables.remove(20);
		tables.remove(21);
		tables.remove(22);
		tables.remove(23);
		tables.remove(24);
		tables.remove(24);
		tables.remove(24);

		for (Element table : tables) {
			Elements rows = table.getElementsByTag("tr");
			rows.remove(0);
			for (Element row : rows) {
				VuaVN vua = new VuaVN();
				Elements colums = row.getElementsByTag("td");
				vua.setTen(locSup(colums.get(1).text()));
				vua.setNamTriVi(locSup(colums.get(7).text()));
				vua.setKhac(locSup(colums.get(6).text()));
				dsVua.add(vua);
			}
		}	
		System.out.println(dsVua);;
		return true;
	}
	public static void main (String arg[]) {
		crawl();
	}

}
