package crawl;

import javafx.concurrent.Task;

public class CrawlTask extends Task<Void> {

	@Override
	protected Void call() throws Exception {
		// TODO Auto-generated method stub
		int all = 2;
		Crawl trieudai = new CrawlTD();
		Crawl vuavn = new CrawlVuaVN();
		if(trieudai.crawl()) {
			Thread.sleep(2000);
			this.updateMessage("CrawlTD thành công");
			System.out.println("CrawlTD thành công\n");
		} else {
			this.updateMessage("CrawlTD thất bại");
			System.out.println("CrawlTD thất bại\n");
		}
		this.updateProgress(1, all);
		if(vuavn.crawl()) {
			Thread.sleep(2000);
			this.updateMessage("CrawlTD thành công");
			System.out.println("CrawlTD thành công\n");
		} else {
			this.updateMessage("CrawlTD thất bại");
			System.out.println("CrawlTD thất bại\n");
		}
		Thread.sleep(2000);
		this.updateProgress(2, all);;
		this.updateMessage("thành công");
		
		return null;
	}
	

}
