package BaiTapGUIb4;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.*;

public class Bai36_ThucHanhJTree extends JFrame {
    private JTextField txtPath;
    private JButton btnGo;
    private JTree tree;
    private DefaultTreeModel treeModel;
    private JTable tableDetails;
    private DefaultTableModel tableModel;
    private JTextArea txtFileContent;
    private CardLayout cardLayout;
    private JPanel pnlRightContainer;

    public Bai36_ThucHanhJTree() {
        setTitle("Chương trình duyệt File với JTree - Bài 36");
        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
    }

    private void initGUI() {
        JPanel pnlNorth = new JPanel(new BorderLayout(5, 5));
        pnlNorth.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnlNorth.add(new JLabel("Nhập đường dẫn: "), BorderLayout.WEST);
        txtPath = new JTextField("C:\\"); 
        btnGo = new JButton("Go");
        pnlNorth.add(txtPath, BorderLayout.CENTER);
        pnlNorth.add(btnGo, BorderLayout.EAST);
        add(pnlNorth, BorderLayout.NORTH);

        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Chưa có dữ liệu");
        treeModel = new DefaultTreeModel(rootNode);
        tree = new JTree(treeModel);
        JScrollPane scrollTree = new JScrollPane(tree);
        scrollTree.setPreferredSize(new Dimension(300, 0));

        cardLayout = new CardLayout();
        pnlRightContainer = new JPanel(cardLayout);

        tableModel = new DefaultTableModel(new String[]{"Tên", "Loại", "Kích thước (Bytes)", "Ngày sửa đổi"}, 0);
        tableDetails = new JTable(tableModel);
        pnlRightContainer.add(new JScrollPane(tableDetails), "TableCard");

        txtFileContent = new JTextArea();
        txtFileContent.setEditable(false);
        pnlRightContainer.add(new JScrollPane(txtFileContent), "TextCard");

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollTree, pnlRightContainer);
        add(splitPane, BorderLayout.CENTER);

        btnGo.addActionListener(e -> {
            String path = txtPath.getText();
            File file = new File(path);
            if (file.exists() && file.isDirectory()) {
                DefaultMutableTreeNode root = new DefaultMutableTreeNode(file);
                createNodes(root, file);
                treeModel.setRoot(root);
            } else {
                JOptionPane.showMessageDialog(this, "Đường dẫn không tồn tại hoặc không phải thư mục!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });

        tree.addTreeSelectionListener(e -> {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
            if (selectedNode == null) return;

            Object userObject = selectedNode.getUserObject();
            if (userObject instanceof File) {
                File f = (File) userObject;
                if (f.isDirectory()) {
                    showFolderDetails(f);
                } else {
                    showFileContent(f);
                }
            }
        });
    }

    private void createNodes(DefaultMutableTreeNode node, File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                DefaultMutableTreeNode child = new DefaultMutableTreeNode(f);
                node.add(child);
            }
        }
    }

    private void showFolderDetails(File folder) {
        cardLayout.show(pnlRightContainer, "TableCard");
        tableModel.setRowCount(0);
        File[] files = folder.listFiles();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        if (files != null) {
            for (File f : files) {
                String type = f.isDirectory() ? "Folder" : "File";
                String size = f.isDirectory() ? "" : String.valueOf(f.length());
                String date = sdf.format(new Date(f.lastModified()));
                tableModel.addRow(new Object[]{f.getName(), type, size, date});
            }
        }
    }

    private void showFileContent(File file) {
        cardLayout.show(pnlRightContainer, "TextCard");
        txtFileContent.setText("");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null && count < 100) { // Giới hạn 100 dòng để tránh treo
                txtFileContent.append(line + "\n");
                count++;
            }
            if (count == 100) txtFileContent.append("... (Nội dung quá dài, chỉ hiển thị 100 dòng đầu)");
        } catch (Exception ex) {
            txtFileContent.setText("Không thể đọc nội dung file này (Có thể là file nhị phân hoặc không có quyền truy cập).");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai36_ThucHanhJTree().setVisible(true));
    }
}