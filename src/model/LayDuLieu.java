package model;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LayDuLieu {
	
	public static List<LichSu> getTrieuDai() {
	    Gson gson = new Gson();
	    try {
			String data = Files.readString(Path.of(LuuTru.trieudai));
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
			String data = Files.readString(Path.of(LuuTru.vua));
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
	
	public static List<LichSu> getLeHoi() {
	    Gson gson = new Gson();
	    try {
			String data = Files.readString(Path.of(LuuTru.lehoi));
			data = "[" + data.substring(0, data.length()-1) + "]";
			Type collectionType = new TypeToken<List<LeHoi>>(){}.getType();
			List<LichSu> listlehoi = gson.fromJson(data, collectionType);	    
		  	return listlehoi;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	  
	}
	public static List<LichSu> getSuKien() {
	    Gson gson = new Gson();
	    try {
			String data = Files.readString(Path.of(LuuTru.sukien));
			data = "[" + data.substring(0, data.length()-1) + "]";
			Type collectionType = new TypeToken<List<SuKien>>(){}.getType();
			List<LichSu> listSuKien = gson.fromJson(data, collectionType);	    
		  	return listSuKien;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	  
	}

}
