package BaiTapGUIb4;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

public class Bai35_QuanLySanPham extends JFrame {
    private static final long serialVersionUID = 1L;
    
    // Components
    private DefaultListModel<DanhMucSanPham> listModel;
    private JList<DanhMucSanPham> listDanhMuc;
    private DefaultTableModel tableModel;
    private JTable tableSP;
    private JComboBox<DanhMucSanPham> cboDanhMuc;
    private JTextField txtID, txtName, txtPrice, txtQty, txtDesc;
    private JButton btnNewSP, btnSaveSP, btnRemoveSP;
    
    // Data
    private ArrayList<DanhMucSanPham> dsDanhMuc = new ArrayList<>();

    public Bai35_QuanLySanPham() {
        setTitle("Chương trình quản lý sản phẩm");
        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initMenu();
        initGUI();
    }

    private void initMenu() {
        JMenuBar mb = new JMenuBar();
        JMenu mFile = new JMenu("File");
        JMenuItem miWrite = new JMenuItem("Write Data to disk");
        JMenuItem miOpen = new JMenuItem("Open Data from disk");
        JMenuItem miExit = new JMenuItem("Exit");

        miWrite.addActionListener(e -> {
            MyFile.luuDoiTuong(dsDanhMuc, "luuluu.data");
            JOptionPane.showMessageDialog(null, "Đã lưu dữ liệu xuống ổ cứng!");
        });

        miOpen.addActionListener(e -> {
            Object data = MyFile.docDoiTuong("luuluu.data");
            if (data != null) {
                dsDanhMuc = (ArrayList<DanhMucSanPham>) data;
                refreshData();
                JOptionPane.showMessageDialog(null, "Đã nạp dữ liệu thành công!");
            }
        });

        miExit.addActionListener(e -> System.exit(0));
        mFile.add(miWrite); mFile.add(miOpen); mFile.addSeparator(); mFile.add(miExit);
        mb.add(mFile); setJMenuBar(mb);
    }

    private void initGUI() {
        JPanel pnMain = new JPanel(new BorderLayout());
        
        // --- PHẦN BÊN TRÁI: DANH MỤC ---
        JPanel pnlLeft = new JPanel(new BorderLayout());
        pnlLeft.setBorder(new TitledBorder(new LineBorder(Color.RED), "Danh mục sản phẩm"));
        
        listModel = new DefaultListModel<>();
        listDanhMuc = new JList<>(listModel);
        pnlLeft.add(new JScrollPane(listDanhMuc), BorderLayout.CENTER);
        
        JPanel pnlLeftBtns = new JPanel();
        JButton btnNewDM = new JButton("New");
        JButton btnUpdateDM = new JButton("Update");
        JButton btnRemoveDM = new JButton("Remove");
        pnlLeftBtns.add(btnNewDM); pnlLeftBtns.add(btnUpdateDM); pnlLeftBtns.add(btnRemoveDM);
        pnlLeft.add(pnlLeftBtns, BorderLayout.SOUTH);

        // --- PHẦN BÊN PHẢI: CHI TIẾT ---
        JPanel pnlRight = new JPanel(new BorderLayout());
        JLabel lblTitle = new JLabel("Quản lý sản phẩm", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
        lblTitle.setForeground(Color.BLUE);
        pnlRight.add(lblTitle, BorderLayout.NORTH);

        // Chia đôi phần bên phải: Trên là Table, Dưới là Nhập liệu
        JPanel pnlRightContent = new JPanel(new GridLayout(2, 1));
        
        // Table
        tableModel = new DefaultTableModel(new String[]{"Mã SP", "Tên SP", "Đơn giá", "Số lượng", "Mô tả"}, 0);
        tableSP = new JTable(tableModel);
        pnlRightContent.add(new JScrollPane(tableSP));

        // Form nhập liệu
        JPanel pnlForm = new JPanel(new BorderLayout());
        JPanel pnlFields = new JPanel(new GridBagLayout());
        pnlFields.setBorder(new TitledBorder("Thông tin chi tiết"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; gbc.insets = new Insets(5, 5, 5, 5);

        // Các hàng trong form
        String[] labels = {"Category:", "Product ID:", "Product Name:", "Unit Price:", "Quantity:", "Description:"};
        cboDanhMuc = new JComboBox<>();
        txtID = new JTextField(); txtName = new JTextField(); 
        txtPrice = new JTextField(); txtQty = new JTextField(); txtDesc = new JTextField();
        JComponent[] comps = {cboDanhMuc, txtID, txtName, txtPrice, txtQty, txtDesc};

        for(int i = 0; i < labels.length; i++) {
            gbc.gridx = 0; gbc.gridy = i; gbc.weightx = 0;
            pnlFields.add(new JLabel(labels[i]), gbc);
            gbc.gridx = 1; gbc.weightx = 1.0;
            pnlFields.add(comps[i], gbc);
        }
        pnlForm.add(pnlFields, BorderLayout.CENTER);

        // Nút bấm phần sản phẩm
        JPanel pnlRightBtns = new JPanel();
        btnNewSP = new JButton("New");
        btnSaveSP = new JButton("Save");
        btnRemoveSP = new JButton("Remove");
        pnlRightBtns.add(btnNewSP); pnlRightBtns.add(btnSaveSP); pnlRightBtns.add(btnRemoveSP);
        pnlForm.add(pnlRightBtns, BorderLayout.SOUTH);
        
        pnlRightContent.add(pnlForm);
        pnlRight.add(pnlRightContent, BorderLayout.CENTER);

        // Ghép 2 phần
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnlLeft, pnlRight);
        split.setDividerLocation(300);
        add(split);

        // --- XỬ LÝ SỰ KIỆN ---
        
        // Click JList hiển thị Table
        listDanhMuc.addListSelectionListener(e -> {
            DanhMucSanPham selected = listDanhMuc.getSelectedValue();
            if (selected != null) {
                loadTable(selected);
                cboDanhMuc.setSelectedItem(selected);
            }
        });

        // Click Table hiển thị TextFields
        tableSP.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = tableSP.getSelectedRow();
                if(row != -1) {
                    txtID.setText(tableModel.getValueAt(row, 0).toString());
                    txtName.setText(tableModel.getValueAt(row, 1).toString());
                    txtPrice.setText(tableModel.getValueAt(row, 2).toString());
                    txtQty.setText(tableModel.getValueAt(row, 3).toString());
                    txtDesc.setText(tableModel.getValueAt(row, 4).toString());
                }
            }
        });

        // Nút New SP
        btnNewSP.addActionListener(e -> {
            txtID.setText(""); txtName.setText(""); txtPrice.setText("");
            txtQty.setText(""); txtDesc.setText(""); txtID.requestFocus();
        });

        // Nút Save SP
        btnSaveSP.addActionListener(e -> {
            DanhMucSanPham dm = (DanhMucSanPham) cboDanhMuc.getSelectedItem();
            if (dm == null) return;
            
            SanPham sp = new SanPham(txtID.getText(), txtName.getText(), 
                        Double.parseDouble(txtPrice.getText()), 
                        Integer.parseInt(txtQty.getText()), txtDesc.getText());
            
            dm.themSanPham(sp); // Logic đã có trong class DanhMucSanPham (tự update nếu trùng ID)
            loadTable(dm);
        });
        
        // Nút New Danh Mục
        btnNewDM.addActionListener(e -> {
            String ma = JOptionPane.showInputDialog("Nhập mã danh mục:");
            String ten = JOptionPane.showInputDialog("Nhập tên danh mục:");
            if (ma != null && !ma.isEmpty()) {
                DanhMucSanPham dm = new DanhMucSanPham(ma, ten);
                dsDanhMuc.add(dm);
                refreshData();
            }
        });
    }

    private void refreshData() {
        listModel.clear();
        cboDanhMuc.removeAllItems();
        for (DanhMucSanPham dm : dsDanhMuc) {
            listModel.addElement(dm);
            cboDanhMuc.addItem(dm);
        }
    }

    private void loadTable(DanhMucSanPham dm) {
        tableModel.setRowCount(0);
        for (SanPham sp : dm.getDsSP()) {
            tableModel.addRow(new Object[]{sp.getMaSP(), sp.getTenSP(), sp.getDonGia(), sp.getSoLuong(), sp.getMoTa()});
        }
    }

    public static void main(String[] args) {
        new Bai35_QuanLySanPham().setVisible(true);
    }
}