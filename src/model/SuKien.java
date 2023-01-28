package model;

public class SuKien implements LichSu {
	private String thoiGian, suKien;
	
	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}
	
	public void setSuKien(String suKien) {
		this.suKien = suKien; 
	}
	
	@Override
	public String toString() {
		return suKien;
	}
	
	@Override
	public String chiTiet() {
		return "thời gian:" + thoiGian + "\n" + 
	     		"sự kiện: " + suKien;
	}
}
