package view;

import com.google.gson.Gson;

import model.TrieuDai;

import crawl.Crawl;
import crawl.CrawlTD;

public class testrun {
	public static void main (String[] args) {
		Crawl td = new CrawlTD();
		if (!td.crawl())
			System.out.println("that bai");

		
	}

}
