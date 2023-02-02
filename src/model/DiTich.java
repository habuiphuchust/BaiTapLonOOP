package model;

public class DiTich implements LichSu{
	private String ten, diaDiem, thongTin;

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getDiaDiem() {
		return diaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}

	public String getThongTin() {
		return thongTin;
	}

	public void setThongTin(String thongTin) {
		this.thongTin = thongTin;
	}
	@Override
	public String toString() {
		return ten;
	}
	@Override
	public String chiTiet() {
		return "+ tên di tích:" + ten + "\n" + 
	     		"+ địa điểm: " + diaDiem + "\n" + 
				"+ thông tin chi tiết: " +thongTin;
	}
}
