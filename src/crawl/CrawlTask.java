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
		
		for (int i = 0; i <listCrawl.size(); i++) {
			if (listCrawl.get(i).crawl()) {
				this.updateMessage(listCrawl.get(i).information() + "thành công \n");
				System.out.println(listCrawl.get(i).information() + "thành công \n");
			} else {
				this.updateMessage(listCrawl.get(i).information() + "thất bại \n");
				System.out.println(listCrawl.get(i).information() + "thất bại \n");
			}
			this.updateProgress(i + 1, listCrawl.size() );
			Thread.sleep(2000);

		}
		
		return null;
	}
	

}
