package BaiTapGUIb4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DanhMucSanPham implements Serializable {
    private static final long serialVersionUID = 1L;
    private String maDM;
    private String tenDM;
    private List<SanPham> dsSP;

    public DanhMucSanPham(String maDM, String tenDM) {
        this.maDM = maDM;
        this.tenDM = tenDM;
        this.dsSP = new ArrayList<>();
    }

    public void themSanPham(SanPham sp) {
        if (!dsSP.contains(sp)) dsSP.add(sp);
    }

    public boolean xoaSanPham(String maSP) {
        return dsSP.removeIf(sp -> sp.getMaSP().equalsIgnoreCase(maSP));
    }

    public String getMaDM() { return maDM; }
    public String getTenDM() { return tenDM; }
    public void setTenDM(String tenDM) { this.tenDM = tenDM; }
    public List<SanPham> getDsSP() { return dsSP; }

    @Override
    public String toString() {
        return this.tenDM; 
    }
}
