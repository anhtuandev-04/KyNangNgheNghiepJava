package Interface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import Proccess.BookDAL;

public class frmSearch extends JFrame {
    BookDAL bookDAL = new BookDAL();
    JTextField txtSearch;
    JTable tblResult;
    DefaultTableModel model;

    public frmSearch() {
        setTitle("Tìm kiếm Sách theo Mã NXB");
        setSize(600, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); 

        JLabel lbl = new JLabel("Nhập mã NXB (Tương đối):");
        lbl.setBounds(30, 20, 200, 25); add(lbl);

        txtSearch = new JTextField();
        txtSearch.setBounds(200, 20, 200, 25); add(txtSearch);

        JButton btnFind = new JButton("Tìm Kiếm");
        btnFind.setBounds(420, 20, 100, 25); add(btnFind);

        // Bảng kết quả tìm kiếm 
        model = new DefaultTableModel(new String[]{"Mã Sách", "Tên Sách", "Mã NXB"}, 0);
        tblResult = new JTable(model);
        JScrollPane sc = new JScrollPane(tblResult);
        sc.setBounds(20, 60, 540, 280); add(sc);

        // Sự kiện Tìm kiếm
        btnFind.addActionListener(e -> {
            String key = txtSearch.getText().trim();
            if(key.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập từ khóa!");
                return;
            }
            searchData(key);
        });
    }

    private void searchData(String keyword) {
        try {
            model.setRowCount(0);
            ResultSet rs = bookDAL.searchByPublisher(keyword);
            boolean found = false;
            while(rs != null && rs.next()) {
                found = true;
                model.addRow(new Object[]{
                    rs.getString("BookCode"), 
                    rs.getString("BookName"), 
                    rs.getString("PublisherCode")
                });
            }
            if(!found) JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả nào!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}