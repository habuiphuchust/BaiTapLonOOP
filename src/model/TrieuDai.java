package model;

public class TrieuDai implements LichSu {
	private String ten, nguoiSangLap, queHuong, kinhDo, thoiGian, khac;
	
	
	public void setTen(String ten) {
		this.ten = ten;
	}
	public void setNguoiSangLap(String nguoiSangLap) {
		this.nguoiSangLap = nguoiSangLap;
	}
	public void setQueHuong(String queHuong) {
		this.queHuong = queHuong;
	}
	public void setKinhDo(String kinhDo) {
		this.kinhDo = kinhDo;
	}
	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}
	@Override
	public String toString() {
		return ten;
	}
	@Override
	public String chiTiet() {
		return "tên triều đại:" + ten + "\n" + 
	     		"người sáng lập: " + nguoiSangLap + "\n" + 
				"quê hương :" + queHuong + "\n" + 
	     		"kinh đô:" + kinhDo + "\n" + 
				"thời gian: " +thoiGian+"\n\n";
	}
	public String getKhac() {
		return khac;
	}
	public void setKhac(String khac) {
		this.khac = khac;
	}

}
