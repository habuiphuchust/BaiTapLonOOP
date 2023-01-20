package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class LuuTru {
	public static String nhanvat = "data//nhanvat.json";
	public static String trieudai = "data//trieudai.json";
	public static String sukien = "data//sukien.json";
	public static String ditich = "data//ditich.json";
	public static String lehoi = "data//lehoi.json";
	public static String vua = "data//vua.json";

	public static List<LichSu> getTrieuDai() {
	    Gson gson = new Gson();
	    try {
			String data = Files.readString(Path.of(trieudai));
			data = "[" + data.substring(0, data.length()-1) + "]";
			Type collectionType = new TypeToken<List<TrieuDai>>(){}.getType();
			List<LichSu> listTrieuDai = gson.fromJson(data, collectionType);	    
		  	return listTrieuDai;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	  
	}
	public static List<LichSu> getVua() {
	    Gson gson = new Gson();
	    try {
			String data = Files.readString(Path.of(vua));
			data = "[" + data.substring(0, data.length()-1) + "]";
			Type collectionType = new TypeToken<List<VuaVN>>(){}.getType();
			List<LichSu> listVua = gson.fromJson(data, collectionType);	    
		  	return listVua;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	  
	}
	
	public static <E> void save(List<E> list) {
		Gson gson = new Gson();
		String json;
		json = gson.toJson(list);
		json = json.substring(1, json.length()-1) + ",";
		String path = null;
		E check = list.get(0);
		if (check instanceof TrieuDai)
			path = trieudai;
		if (check instanceof VuaVN)
			path = vua;
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
