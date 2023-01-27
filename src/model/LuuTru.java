package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import com.google.gson.Gson;


public class LuuTru {
	public static String nhanvat = "data//nhanvat.json";
	public static String trieudai = "data//trieudai.json";
	public static String sukien = "data//sukien.json";
	public static String ditich = "data//ditich.json";
	public static String lehoi = "data//lehoi.json";
	public static String vua = "data//vua.json";
	
	public static <E> void save(List<E> list) {
		Gson gson = new Gson();
		String json;
		json = gson.toJson(list);
		json = json.substring(1, json.length()-1) + ",";
		String path = null;
		E check = list.get(0);
		if (check instanceof TrieuDai)
			path = trieudai;
		else if (check instanceof VuaVN)
			path = vua;
		else if (check instanceof LeHoi)
			path = lehoi;
		try {
			FileWriter fw = new FileWriter(path, false);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(json);
			bw.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(path);
		}
	}
}
