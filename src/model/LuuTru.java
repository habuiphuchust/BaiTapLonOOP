package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;


public class LuuTru {
	public static String nhanvat = "data//nhanvat.json";
	public static String trieudai = "data//trieudai.json";
	public static String sukien = "data//sukien.json";
	public static String ditich = "data//ditich.json";
	public static String lehoi = "data//lehoi.json";

	public static List<LichSu> getData(String path) {
		// TODO Auto-generated method stub
		List<LichSu> listTrieuDai = new ArrayList<>();
	    TrieuDai td;
	    Gson gson = new Gson();
		try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while (line != null) {
				td = gson.fromJson(line, TrieuDai.class);
				listTrieuDai.add(td);
				line = br.readLine();
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listTrieuDai;

	}
}
