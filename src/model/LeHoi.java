package model;

public class LeHoi implements LichSu {
	private String ten, thongtin;

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getThongtin() {
		return thongtin;
	}

	public void setThongtin(String thongtin) {
		this.thongtin = thongtin;
	}
	@Override
	public String toString() {
		return ten;
	}

	@Override
	public String chiTiet() {
		// TODO Auto-generated method stub
		return thongtin;
	}

}
