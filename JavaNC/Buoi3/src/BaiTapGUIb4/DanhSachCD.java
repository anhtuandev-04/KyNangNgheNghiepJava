package BaiTapGUIb4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DanhSachCD implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<CD> ds;

    public DanhSachCD() {
        ds = new ArrayList<>();
    }

    public boolean themCD(CD cd) {
        if (ds.contains(cd)) return false;
        return ds.add(cd);
    }

    public CD getCD(int i) {
        if (i >= 0 && i < ds.size()) return ds.get(i);
        return null;
    }

    public boolean xoaCD(String maCD) {
        CD cd = new CD(maCD);
        return ds.remove(cd);
    }

    public CD timKiem(String maCD) {
        CD cd = new CD(maCD);
        int index = ds.indexOf(cd);
        if (index != -1) return ds.get(index);
        return null;
    }

    public boolean capNhat(String maCD, String tuaCD, String caSy, int soBaiHat, double giaThanh) {
        CD cd = timKiem(maCD);
        if (cd != null) {
            cd.setTuaCD(tuaCD);
            cd.setCaSy(caSy);
            cd.setSoBaiHat(soBaiHat);
            cd.setGiaThanh(giaThanh);
            return true;
        }
        return false;
    }

    public int tongCD() {
        return ds.size();
    }
}
