package crawl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;

import model.LuuTru;
import model.TrieuDai;

public class CrawlTD implements Crawl {

	@Override
	public boolean crawl() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				List <TrieuDai> listTrieuDai = new ArrayList<>();
				TrieuDai td;
//				File f = new File("data//vuavietnam.html");
				Document doc;
				try {
//					doc = Jsoup.parse(f, "UTF-8");
				doc = Jsoup.connect("https://vi.wikipedia.org/wiki/Vua_Vi%E1%BB%87t_Nam").get();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					return false;
				}
				Elements tables = doc.getElementsByTag("table");
				Element table = tables.get(43); // lấy bảng cần crawl
				Elements rows = table.getElementsByTag("tr"); // lấy hết dòng
				rows.remove(0);  // xóa dòng đầu
				for (Element row : rows) {
					td = new TrieuDai();
					Elements colums = row.getElementsByTag("td");   // từng cột trong dòng
					td.setTen(LocString.locSup(colums.get(0).text()));
					td.setNguoiSangLap(LocString.locSup(colums.get(1).text()));
					td.setQueHuong(LocString.locSup(colums.get(2).text()));
					td.setKinhDo(LocString.locSup(colums.get(3).text()));
					listTrieuDai.add(td);
							
					
				}
				
				List <String> listNam = new ArrayList<>();
				Element table2 = tables.get(44);  // lấy bảng cuối
				Elements ths = table2.getElementsByTag("th"); // lấy hết thuộc tính th
				ths.remove(0);
				for (Element th: ths) {
					listNam.add(th.ownText());
				}
				listNam.add(4, "(544-602)");     //sửa năm
				listNam.remove(6);
				listNam.add(6, "(713–723)");
				listNam.add(7, "(779–791)");
				listNam.remove(8);
				listNam.add(8, "(905–930)");
				listNam.add(9, "(931–938)");
				listNam.add(10, "(931–938)");
				listNam.remove(20);
				listNam.add(20, "(1545–1787)");
				listNam.add(21, "(1558-1777;1780–1802)");
				listNam.remove(17);
				listNam.add(17, "(1407–1414; 1426–1427)");
				
				int i = 0;
				for (TrieuDai v : listTrieuDai) {
					v.setThoiGian(listNam.get(i++));
				}
				
//				Gson gson = new Gson();
////				String json = gson.toJson(listTrieuDai);
////				System.out.println(json);
//				String json;
//				try {
//					FileWriter fw = new FileWriter(LuuTru.trieudai, false);
//					BufferedWriter bw = new BufferedWriter(fw);
//					json = gson.toJson(listTrieuDai);
//					bw.write(json);
////					for (TrieuDai v : listTrieuDai) {
////						json = gson.toJson(v);
////						bw.write(json);
////						bw.write('\n');
////					}
//					bw.close();
//					fw.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//					return false;
//				}
				LuuTru.save(listTrieuDai);

		return true;
	}

}
