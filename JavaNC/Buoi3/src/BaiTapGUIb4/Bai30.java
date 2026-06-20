package BaiTapGUIb4;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class Bai30 extends JFrame implements ActionListener, ListSelectionListener {
    private static final long serialVersionUID = 1L;
    private JTextField tfMaSo, tfTua, tfCaSy, tfSoBaiHat, tfGiaThanh;
    private JButton btThem, btLuu, btXoa, btSua, btTim, btClear;
    
    private JList<CD> list;
    private DefaultListModel<CD> dfModel;
    
    private DanhSachCD ds;
    private final String FILENAME = "DSCD.DAT";

    public Bai30() {
        setTitle("Chương trình quản lý CD - Sử dụng JList");
        setSize(800, 600);
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
                napVaoList();
            } catch (Exception e) {
                ds = new DanhSachCD();
            }
        } else {
            ds = new DanhSachCD();
        }
    }

    private void buildGUI() {
        Box b = Box.createVerticalBox();
        b.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        Box b1 = Box.createHorizontalBox();
        b1.add(new JLabel("THÔNG TIN CD", JLabel.CENTER));
        b.add(b1); b.add(Box.createVerticalStrut(10));

        tfMaSo = new JTextField(); tfTua = new JTextField(); tfCaSy = new JTextField();
        tfSoBaiHat = new JTextField(); tfGiaThanh = new JTextField();

        b.add(createInputBox("Mã số:", tfMaSo)); b.add(Box.createVerticalStrut(5));
        b.add(createInputBox("Tựa đề:", tfTua)); b.add(Box.createVerticalStrut(5));
        b.add(createInputBox("Ca sỹ:", tfCaSy)); b.add(Box.createVerticalStrut(5));
        b.add(createInputBox("Số bài hát:", tfSoBaiHat)); b.add(Box.createVerticalStrut(5));
        b.add(createInputBox("Giá thành:", tfGiaThanh)); b.add(Box.createVerticalStrut(10));

        JPanel pnlBtns = new JPanel();
        pnlBtns.add(btThem = new JButton("Thêm"));
        pnlBtns.add(btClear = new JButton("Clear"));
        pnlBtns.add(btLuu = new JButton("Lưu"));
        pnlBtns.add(btXoa = new JButton("Xóa"));
        pnlBtns.add(btSua = new JButton("Sửa"));
        pnlBtns.add(btTim = new JButton("Tìm"));
        b.add(pnlBtns); b.add(Box.createVerticalStrut(10));

        dfModel = new DefaultListModel<>();
        list = new JList<>(dfModel);

        list.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.red), "Danh sách CD"));
        
        JScrollPane scroll = new JScrollPane(list);
        scroll.setPreferredSize(new Dimension(0, 250));
        b.add(scroll);

        add(b);

        btThem.addActionListener(this);
        btClear.addActionListener(this);
        btLuu.addActionListener(this);
        btXoa.addActionListener(this);
        btSua.addActionListener(this);
        btTim.addActionListener(this);
        
        list.addListSelectionListener(this);
    }

    private Box createInputBox(String label, JTextField textField) {
        Box box = Box.createHorizontalBox();
        JLabel lb = new JLabel(label);
        lb.setPreferredSize(new Dimension(100, 20));
        box.add(lb);
        box.add(textField);
        return box;
    }

    private void napVaoList() {
        dfModel.removeAllElements(); 
        for (int i = 0; i < ds.tongCD(); i++) {
            dfModel.addElement(ds.getCD(i)); 
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            CD cd = list.getSelectedValue(); 
            if (cd != null) {
                tfMaSo.setText(cd.getMaCD());
                tfTua.setText(cd.getTuaCD());
                tfCaSy.setText(cd.getCaSy());
                tfSoBaiHat.setText(cd.getSoBaiHat() + "");
                tfGiaThanh.setText(cd.getGiaThanh() + "");
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(btClear)) {
            tfMaSo.setText(""); tfTua.setText(""); tfCaSy.setText("");
            tfSoBaiHat.setText(""); tfGiaThanh.setText(""); tfMaSo.requestFocus();
        } 
        else if (o.equals(btThem)) {
            try {
                CD cd = new CD(tfMaSo.getText(), tfTua.getText(), tfCaSy.getText(),Integer.parseInt(tfSoBaiHat.getText()), Double.parseDouble(tfGiaThanh.getText()));
                if (ds.themCD(cd)) napVaoList();
                else JOptionPane.showMessageDialog(this, "Trùng mã CD!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ!");
            }
        }
        else if (o.equals(btLuu)) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
                oos.writeObject(ds);
                JOptionPane.showMessageDialog(this, "Lưu thành công!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lỗi lưu file!");
            }
        }
        else if (o.equals(btXoa)) {
            String ma = JOptionPane.showInputDialog("Nhập mã CD cần xóa:");
            if (ma != null && ds.timKiem(ma) != null) {
                if (JOptionPane.showConfirmDialog(this, "Xóa CD mã " + ma + "?", "Xác nhận", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    ds.xoaCD(ma); napVaoList();
                    btClear.doClick();
                }
            } else if (ma != null) JOptionPane.showMessageDialog(this, "Mã không tồn tại!");
        }
        else if (o.equals(btSua)) {
            try {
                if (ds.capNhat(tfMaSo.getText(), tfTua.getText(), tfCaSy.getText(),
                        Integer.parseInt(tfSoBaiHat.getText()), Double.parseDouble(tfGiaThanh.getText()))) {
                    napVaoList();
                } else JOptionPane.showMessageDialog(this, "Không tìm thấy mã!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lỗi dữ liệu!");
            }
        }
        else if (o.equals(btTim)) {
            String ma = JOptionPane.showInputDialog("Nhập mã CD cần tìm:");
            CD cd = ds.timKiem(ma);
            if (cd != null) {
                list.setSelectedValue(cd, true);
            } else if (ma != null) JOptionPane.showMessageDialog(this, "Không tìm thấy!");
        }
    }

    public static void main(String[] args) {
        new Bai30().setVisible(true);
    }
}