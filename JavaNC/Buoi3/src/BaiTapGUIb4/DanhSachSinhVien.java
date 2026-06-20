package BaiTapGUIb4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DanhSachSinhVien implements Serializable {
    private List<SinhVien> ds;

    public DanhSachSinhVien() {
        ds = new ArrayList<SinhVien>();
    }

    public boolean themsinhvien(SinhVien sv) {
        if (ds.contains(sv)) return false;
        ds.add(sv);
        return true;
    }

    public SinhVien getSinhVien(int i) {
        if (i >= 0 && i < ds.size()) return ds.get(i);
        return null;
    }

    public int tongSinhVien() { return ds.size(); }

    public SinhVien timKiem(String masv) throws Exception {
        SinhVien temp = new SinhVien(masv);
        int index = ds.indexOf(temp);
        return (index >= 0) ? ds.get(index) : null;
    }

    public boolean xoaSinhVien(String masv) throws Exception {
        SinhVien temp = new SinhVien(masv);
        return ds.remove(temp);
    }

    public boolean suaThongTinSinhVien(String masv, SinhVien svMoi) throws Exception {
        SinhVien svCu = timKiem(masv);
        if (svCu != null) {
            svCu.setHoten(svMoi.getHoten());
            svCu.setMalop(svMoi.getMalop());
            svCu.setDiemLT(svMoi.getDiemLT());
            svCu.setDiemTH(svMoi.getDiemTH());
            return true;
        }
        return false;
    }
}