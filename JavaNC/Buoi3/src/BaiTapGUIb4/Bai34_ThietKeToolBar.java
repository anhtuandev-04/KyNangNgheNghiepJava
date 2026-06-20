package BaiTapGUIb4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bai34_ThietKeToolBar extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    public Bai34_ThietKeToolBar() {
        setTitle("Giả lập JToolBar Foxit Reader - Bài 34");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JToolBar toolBar = new JToolBar("Foxit Reader Toolbar");

        toolBar.setFloatable(true); 


        
        addButton(toolBar, "Mở file", "home.png");
        addButton(toolBar, "Lưu file", "save.png");
        toolBar.addSeparator(); 
        
        addButton(toolBar, "In ấn", "setting.png"); 
        addButton(toolBar, "Chia sẻ Facebook", "image.png");
        toolBar.addSeparator();

        JButton btnHand = new JButton("Hand Tool");
        btnHand.addActionListener(this);
        toolBar.add(btnHand);

        JButton btnSelect = new JButton("Select Text");
        btnSelect.addActionListener(this);
        toolBar.add(btnSelect);

        JButton btnSnapshot = new JButton("Snapshot");
        btnSnapshot.addActionListener(this);
        toolBar.add(btnSnapshot);

        add(toolBar, BorderLayout.NORTH);

        JTextArea txtContent = new JTextArea("Nội dung tài liệu PDF giả lập ở đây...");
        txtContent.setFont(new Font("Arial", Font.PLAIN, 16));
        add(new JScrollPane(txtContent), BorderLayout.CENTER);
    }

    private void addButton(JToolBar parent, String tooltip, String iconName) {
        JButton btn = new JButton();

        String path = "src/BaiTapGUI/Buoi4/images/" + iconName;
        
        try {
            ImageIcon icon = new ImageIcon(path);
            Image img = icon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
            btn.setIcon(new ImageIcon(img));
        } catch (Exception e) {
            btn.setText(tooltip); 
        }

        btn.setToolTipText(tooltip); 
        btn.setActionCommand(tooltip); 
        btn.addActionListener(this);
        
        parent.add(btn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command == null || command.isEmpty()) {
            command = ((JButton)e.getSource()).getText();
        }
        
        JOptionPane.showMessageDialog(this, "Bạn đang sử dụng chức năng: " + command);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Bai34_ThietKeToolBar().setVisible(true);
        });
    }
}