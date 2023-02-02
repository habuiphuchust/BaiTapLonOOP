package crawl;

import java.util.ArrayList;
import java.util.List;

import model.LayDuLieu;
import model.LichSu;
import model.LuuTru;
import model.TrieuDai;
import model.VuaVN;

public class TaoLienKet {

	public static void vua_trieudai() {
		// TODO Auto-generated method stub
		List<LichSu> lsTrieuDai = LayDuLieu.getTrieuDai();
		List<LichSu> lsVua = LayDuLieu.getVua();
		List<VuaVN> lsvuavn = new ArrayList<>();
		for (LichSu vua : lsVua) {
			int i = 0;
			for (LichSu trieudai : lsTrieuDai) {
				i++;
				VuaVN vuavn = (VuaVN)vua;
				if (trieudai.chiTiet().toUpperCase().contains(vua.toString().toUpperCase()) || vua.chiTiet().toUpperCase().contains(trieudai.toString().toUpperCase())) {			
					vuavn.setTrieuDai((TrieuDai)trieudai);
					lsvuavn.add(vuavn);
					break;
				}
				if (i == lsTrieuDai.size())
					lsvuavn.add(vuavn);
			}
		}
		LuuTru.save(lsvuavn, false);

	}

}
