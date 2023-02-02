package model;

public class LeHoi implements LichSu {
	private String ten, thongtin, loaihinh, diadiem;

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
	
	public String getLoaihinh() {
		return loaihinh;
	}

	public void setLoaihinh(String loaihinh) {
		this.loaihinh = loaihinh;
	}

	public String getDiadiem() {
		return diadiem;
	}

	public void setDiadiem(String diadiem) {
		this.diadiem = diadiem;
	}

	@Override
	public String toString() {
		return ten;
	}

	@Override
	public String chiTiet() {
		// TODO Auto-generated method stub
		return ten + "\n" + 
				"Loại Hình: " + loaihinh + "\n" +
				"Địa Điểm: " + diadiem + "\n" +
				"Thông tin thêm: " + thongtin;
	}

}
