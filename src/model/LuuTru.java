package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import com.google.gson.Gson;


public class LuuTru {
	final public static String nhanvat = "data//nhanvat.json";
	final public static String trieudai = "data//trieudai.json";
	final public static String sukien = "data//sukien.json";
	final public static String ditich = "data//ditich.json";
	final public static String lehoi = "data//lehoi.json";
	final public static String vua = "data//vua.json";
	
	public static <E> void save(List<E> list, boolean oldData) {
		Gson gson = new Gson();
		String json;
		json = gson.toJson(list);
		json = json.substring(1, json.length()-1) + ",";
		String path = null;
		E check = list.get(0);
		//kiem tra list thuoc loai nao
		if (check instanceof TrieuDai)
			path = trieudai;
		else if (check instanceof VuaVN)
			path = vua;
		else if (check instanceof LeHoi)
			path = lehoi;
		else if (check instanceof SuKien)
			path = sukien;
		else if (check instanceof DiTich)
			path = ditich;
		
		try {
			FileWriter fw = new FileWriter(path, oldData);
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
