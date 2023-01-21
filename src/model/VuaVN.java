package model;

public class VuaVN implements LichSu {
	String ten, namTriVi, khac;
	TrieuDai trieuDai;
	public TrieuDai getTrieuDai() {
		return trieuDai;
	}
	public void setTrieuDai(TrieuDai trieuDai) {
		this.trieuDai = trieuDai;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getNamTriVi() {
		return namTriVi;
	}
	public void setNamTriVi(String namTriVi) {
		this.namTriVi = namTriVi;
	}
	public String getKhac() {
		return khac;
	}
	public void setKhac(String khac) {
		this.khac = khac;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ten;
	}
	@Override
	public String chiTiet() {
		// TODO Auto-generated method stub
		return "+ Tên: " + ten +
				"\n+ Năm cai trị: " + namTriVi +
				"\n+ Thông tin thêm: " + khac;
	}

}
