package BaiTapGUIb4;

import java.awt.*;
import java.io.*;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class Bai29_GiaoDienCD extends JFrame implements ActionListener, MouseListener {
    private static final String FILENAME = "DSCD.DAT";
    private JTextField tfMaSo, tfTua, tfCaSy, tfSoBaiHat, tfGiaThanh;
    private JButton btThem, btLuu, btXoa, btSua, btTim, btClear;
    private JTable table;
    private DefaultTableModel dfModel;
    private DanhSachCD ds;

    public Bai29_GiaoDienCD() {
        setTitle("Chương trình quản lý CD");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        buildGUI();
        createDB();
    }

    private void createDB() {
        File file = new File(FILENAME);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                ds = (DanhSachCD) ois.readObject();
                napVaoBang();
            } catch (Exception e) {
                ds = new DanhSachCD();
            }
        } else {
            ds = new DanhSachCD();
        }
    }

    private void buildGUI() {
        Box b = Box.createVerticalBox();
        Box b1 = Box.createHorizontalBox();
        Box b2 = Box.createHorizontalBox();
        Box b3 = Box.createHorizontalBox();
        Box b4 = Box.createHorizontalBox();
        Box b5 = Box.createHorizontalBox();
        Box b6 = Box.createHorizontalBox();
        Box b7 = Box.createHorizontalBox();

        b1.add(new JLabel("THÔNG TIN CD", JLabel.CENTER));
        
        JLabel lbMaSo, lbTuaDe, lbCaSy, lbSoBaiHat, lbGia;
        b2.add(lbMaSo = new JLabel("Mã số: ")); b2.add(tfMaSo = new JTextField());
        b3.add(lbTuaDe = new JLabel("Tựa đề: ")); b3.add(tfTua = new JTextField());
        b4.add(lbCaSy = new JLabel("Ca sỹ: ")); b4.add(tfCaSy = new JTextField());
        b5.add(lbSoBaiHat = new JLabel("Số bài hát: ")); b5.add(tfSoBaiHat = new JTextField());
        b6.add(lbGia = new JLabel("Giá thành: ")); b6.add(tfGiaThanh = new JTextField());

        Dimension lbSize = new Dimension(80, 20);
        lbMaSo.setPreferredSize(lbSize); lbTuaDe.setPreferredSize(lbSize);
        lbCaSy.setPreferredSize(lbSize); lbSoBaiHat.setPreferredSize(lbSize);
        lbGia.setPreferredSize(lbSize);

        b7.add(btThem = new JButton("Thêm"));
        b7.add(btClear = new JButton("Clear"));
        b7.add(btLuu = new JButton("Lưu"));
        b7.add(btXoa = new JButton("Xóa"));
        b7.add(btSua = new JButton("Sửa"));
        b7.add(btTim = new JButton("Tìm"));

        b.add(b1); b.add(Box.createVerticalStrut(5));
        b.add(b2); b.add(Box.createVerticalStrut(5));
        b.add(b3); b.add(Box.createVerticalStrut(5));
        b.add(b4); b.add(Box.createVerticalStrut(5));
        b.add(b5); b.add(Box.createVerticalStrut(5));
        b.add(b6); b.add(Box.createVerticalStrut(5));
        b.add(b7); b.add(Box.createVerticalStrut(10));

        String[] headers = {"STT", "Mã CD", "Tựa CD", "Ca sỹ", "Số bài hát", "Đơn giá"};
        dfModel = new DefaultTableModel(headers, 0);
        table = new JTable(dfModel);
        b.add(new JScrollPane(table));

        add(b, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);

        btThem.addActionListener(this); btLuu.addActionListener(this);
        btXoa.addActionListener(this); btSua.addActionListener(this);
        btTim.addActionListener(this); btClear.addActionListener(this);
        table.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src.equals(btThem)) {
            try {
                String ma = tfMaSo.getText();
                String tua = tfTua.getText();
                String caSy = tfCaSy.getText();
                if (ma.isEmpty() || tua.isEmpty() || caSy.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ dữ liệu!");
                    return;
                }
                int soBai = Integer.parseInt(tfSoBaiHat.getText());
                double gia = Double.parseDouble(tfGiaThanh.getText());
                CD cd = new CD(ma, tua, caSy, soBai, gia);
                if (ds.themCD(cd)) napVaoBang();
                else JOptionPane.showMessageDialog(this, "Trùng mã CD!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Số bài hát và giá phải là số!");
            }
        } else if (src.equals(btClear)) {
            tfMaSo.setText(""); tfTua.setText(""); tfCaSy.setText("");
            tfSoBaiHat.setText(""); tfGiaThanh.setText(""); tfMaSo.requestFocus();
        } else if (src.equals(btLuu)) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
                oos.writeObject(ds);
                JOptionPane.showMessageDialog(this, "Đã lưu vào file!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lỗi lưu file!");
            }
        } else if (src.equals(btXoa)) {
            String ma = JOptionPane.showInputDialog("Nhập mã CD cần xóa:");
            if (ma != null && ds.timKiem(ma) != null) {
                if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa?", "Xác nhận", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    ds.xoaCD(ma); napVaoBang();
                }
            } else if (ma != null) JOptionPane.showMessageDialog(this, "Mã CD không tồn tại!");
        } else if (src.equals(btTim)) {
            String ma = JOptionPane.showInputDialog("Nhập mã CD cần tìm:");
            CD cd = ds.timKiem(ma);
            if (cd != null) napVaoCacONhapLieu(cd);
            else if (ma != null) JOptionPane.showMessageDialog(this, "Không tìm thấy!");
        } else if (src.equals(btSua)) {
            try {
                if (ds.capNhat(tfMaSo.getText(), tfTua.getText(), tfCaSy.getText(), Integer.parseInt(tfSoBaiHat.getText()), Double.parseDouble(tfGiaThanh.getText())))
                    napVaoBang();
                else JOptionPane.showMessageDialog(this, "Không tìm thấy mã CD để sửa!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lỗi định dạng dữ liệu!");
            }
        }
    }

    private void napVaoBang() {
        dfModel.setRowCount(0);
        DecimalFormat df = new DecimalFormat("#,##0.00");
        for (int i = 0; i < ds.tongCD(); i++) {
            CD cd = ds.getCD(i);
            dfModel.addRow(new Object[]{i + 1, cd.getMaCD(), cd.getTuaCD(), cd.getCaSy(), cd.getSoBaiHat(), df.format(cd.getGiaThanh())});
        }
    }

    private void napVaoCacONhapLieu(CD cd) {
        tfMaSo.setText(cd.getMaCD());
        tfTua.setText(cd.getTuaCD());
        tfCaSy.setText(cd.getCaSy());
        tfSoBaiHat.setText(cd.getSoBaiHat() + "");
        tfGiaThanh.setText(cd.getGiaThanh() + "");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = table.getSelectedRow();
        if (row != -1) napVaoCacONhapLieu(ds.getCD(row));
    }

    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        new Bai29_GiaoDienCD().setVisible(true);
    }
}
