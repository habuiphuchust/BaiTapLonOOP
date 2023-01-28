package crawl;

import java.util.ArrayList;

import javafx.concurrent.Task;

public class CrawlTask extends Task<Void> {

	@Override
	protected Void call() throws Exception {
		// TODO Auto-generated method stub
		//them lop crawl
		ArrayList<Crawl> listCrawl = new ArrayList<>();
		listCrawl.add(new CrawlTD());
		listCrawl.add(new CrawlVuaVN());
		listCrawl.add(new CrawlLeHoi());
		listCrawl.add(new CrawlSK());
		listCrawl.add(new CrawlLeHoi2());
//		listCrawl.add(new CrawlDiTich());
		
		int solienket = 1;
		int sonhiemvu = listCrawl.size() + solienket;
		for (int i = 0; i <listCrawl.size(); i++) {
			if (listCrawl.get(i).crawl()) {
				this.updateMessage(listCrawl.get(i).toString() + "thành công \n");
				System.out.println(listCrawl.get(i).toString() + "thành công \n");
			} else {
				this.updateMessage(listCrawl.get(i).toString() + "thất bại \n");
				System.out.println(listCrawl.get(i).toString() + "thất bại \n");
			}
			this.updateProgress(i + 1, sonhiemvu );
			Thread.sleep(500);

		}
		//tao lien ket
		TaoLienKet.vua_trieudai();
		this.updateProgress(sonhiemvu, sonhiemvu);
		
		return null;
	}
	

}
