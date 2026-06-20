package BaiTapGUIb4;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class Bai28_GiaoDienSinhVien extends JFrame implements ActionListener, MouseListener {
    private static final long serialVersionUID = 1L;
    private JTextField tfMaso, tfHoTen, tfDiemLT, tfDiemTH, tfDiemTB, tfKQ;
    private JComboBox<String> cboMalop;
    private JButton bttKQ, bttThem, bttClear, bttLuu, bttXoa, bttSua, bttTim;
    private DefaultTableModel dfModel;
    private JTable table;
    private DanhSachSinhVien ds;
    private final String FILENAME = "DATA_SINHVIEN.DAT";

    public Bai28_GiaoDienSinhVien() {
        setTitle("Chương trình quản lý sinh viên");
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        buildGUI();
        napDanhSachSinhVien(FILENAME); 
    }

    private void buildGUI() {
        JPanel pnlLeft = new JPanel(new GridLayout(0, 1, 5, 5));
        pnlLeft.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        pnlLeft.add(new JLabel("THÔNG TIN SINH VIÊN", JLabel.CENTER));
        pnlLeft.add(new JLabel("Mã sinh viên: "));
        pnlLeft.add(tfMaso = new JTextField(20));
        pnlLeft.add(new JLabel("Họ và Tên: "));
        pnlLeft.add(tfHoTen = new JTextField(20));
        
        pnlLeft.add(new JLabel("Mã lớp: "));
        String[] dslop = {"NCTH6A", "DHTHA", "DHTHB", "DHTHC", "DHTHD", "DHTHK"};
        pnlLeft.add(cboMalop = new JComboBox<>(dslop));

        pnlLeft.add(new JLabel("Điểm lý thuyết: "));
        pnlLeft.add(tfDiemLT = new JTextField(20));
        pnlLeft.add(new JLabel("Điểm thực hành: "));
        pnlLeft.add(tfDiemTH = new JTextField(20));
        pnlLeft.add(new JLabel("Điểm trung bình: "));
        pnlLeft.add(tfDiemTB = new JTextField(20));
        tfDiemTB.setEditable(false); 
        
        pnlLeft.add(new JLabel("Kết quả: "));
        pnlLeft.add(tfKQ = new JTextField(20));
        tfKQ.setEditable(false);

        JPanel pnlBtn1 = new JPanel();
        pnlBtn1.add(bttKQ = new JButton("Kết quả"));
        pnlBtn1.add(bttThem = new JButton("Thêm"));
        pnlBtn1.add(bttClear = new JButton("Clear"));
        pnlLeft.add(pnlBtn1);

        JPanel pnlBtn2 = new JPanel();
        pnlBtn2.add(bttLuu = new JButton("Lưu"));
        pnlBtn2.add(bttXoa = new JButton("Xóa"));
        pnlBtn2.add(bttSua = new JButton("Sửa"));
        pnlBtn2.add(bttTim = new JButton("Tìm"));
        pnlLeft.add(pnlBtn2);

        String[] headers = {"Mã SV", "Họ tên", "Lớp", "Lý thuyết", "Thực hành", "Trung bình", "Kết quả"};
        dfModel = new DefaultTableModel(headers, 0);
        table = new JTable(dfModel);
        JScrollPane pnlRight = new JScrollPane(table);

        add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnlLeft, pnlRight));

        bttClear.addActionListener(this);
        bttKQ.addActionListener(this);
        bttThem.addActionListener(this);
        bttLuu.addActionListener(this);
        bttSua.addActionListener(this);
        bttTim.addActionListener(this);
        bttXoa.addActionListener(this);
        table.addMouseListener(this);
    }

    private void napDanhSachSinhVien(String file) {
        if (new File(file).exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                ds = (DanhSachSinhVien) ois.readObject();
                napVaoBang();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lỗi nạp dữ liệu!");
                ds = new DanhSachSinhVien();
            }
        } else {
            ds = new DanhSachSinhVien();
        }
    }

    private void napVaoBang() {
        dfModel.setRowCount(0);
        for (int i = 0; i < ds.tongSinhVien(); i++) {
            SinhVien sv = ds.getSinhVien(i);
            dfModel.addRow(new Object[]{sv.getMasv(), sv.getHoten(), sv.getMalop(), 
                           sv.getDiemLT(), sv.getDiemTH(), sv.diemTB(), sv.ketQua()});
        }
    }

    private void napLaiThongTin(SinhVien sv) {
        tfMaso.setText(sv.getMasv());
        tfHoTen.setText(sv.getHoten());
        cboMalop.setSelectedItem(sv.getMalop());
        tfDiemLT.setText(sv.getDiemLT() + "");
        tfDiemTH.setText(sv.getDiemTH() + "");
        tfDiemTB.setText(sv.diemTB() + "");
        tfKQ.setText(sv.ketQua());
    }

    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        
        if (o.equals(bttClear)) {
            tfMaso.setText(""); tfHoTen.setText("");
            tfDiemLT.setText(""); tfDiemTH.setText("");
            tfDiemTB.setText(""); tfKQ.setText("");
            cboMalop.setSelectedItem("NCTH6A");
            tfMaso.requestFocus();
        } 
        else if (o.equals(bttLuu)) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
                oos.writeObject(ds);
                JOptionPane.showMessageDialog(this, "Đã lưu vào file!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lỗi lưu file!");
            }
        }
        else if (o.equals(bttTim)) {
            String ma = JOptionPane.showInputDialog("Nhập mã sinh viên cần tìm:");
            if (ma != null && !ma.trim().isEmpty()) {
                try {
                    SinhVien sv = ds.timKiem(ma);
                    if (sv != null) napLaiThongTin(sv);
                    else JOptionPane.showMessageDialog(this, "Không tìm thấy!");
                } catch (Exception ex) { }
            }
        }
        else if (o.equals(bttXoa)) {
            String ma = JOptionPane.showInputDialog("Nhập mã sinh viên cần xóa:");
            if (ma != null && !ma.trim().isEmpty()) {
                try {
                    SinhVien sv = ds.timKiem(ma);
                    if (sv != null) {
                        int confirm = JOptionPane.showConfirmDialog(this, "Xác nhận xóa SV: " + ma + "?", "Xóa", JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.YES_OPTION) {
                            ds.xoaSinhVien(ma);
                            napVaoBang();
                        }
                    } else JOptionPane.showMessageDialog(this, "Không tồn tại!");
                } catch (Exception ex) { }
            }
        }
        else {
            try {
                String ma = tfMaso.getText().trim();
                String ten = tfHoTen.getText().trim();
                String lop = cboMalop.getSelectedItem().toString();
                double lt = Double.parseDouble(tfDiemLT.getText());
                double th = Double.parseDouble(tfDiemTH.getText());
                SinhVien sv = new SinhVien(ma, ten, lop, lt, th);

                if (o.equals(bttKQ)) {
                    tfDiemTB.setText(sv.diemTB() + "");
                    tfKQ.setText(sv.ketQua());
                } else if (o.equals(bttThem)) {
                    if (ma.isEmpty() || ten.isEmpty()) throw new Exception("Vui lòng nhập đủ dữ liệu!");
                    if (ds.themsinhvien(sv)) napVaoBang();
                    else JOptionPane.showMessageDialog(this, "Trùng mã sinh viên!");
                } else if (o.equals(bttSua)) {
                    if (ds.suaThongTinSinhVien(ma, sv)) napVaoBang();
                    else JOptionPane.showMessageDialog(this, "Không tìm thấy mã để sửa!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Điểm phải là số!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }

    public void mouseClicked(MouseEvent e) {
        int row = table.getSelectedRow();
        if (row != -1) napLaiThongTin(ds.getSinhVien(row));
    }
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        new Bai28_GiaoDienSinhVien().setVisible(true);
    }
}