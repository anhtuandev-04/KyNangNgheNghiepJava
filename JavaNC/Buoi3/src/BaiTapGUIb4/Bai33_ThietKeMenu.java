package BaiTapGUIb4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bai33_ThietKeMenu extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    public Bai33_ThietKeMenu() {
        setTitle("Giả lập Menu Foxit Reader - Bài 33");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();

        JMenu menuFile = new JMenu("File");
        menuFile.setMnemonic('F');

        addMenuItem(menuFile, "Open...", KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK);
        
        JMenu subRights = new JMenu("Rights Management Service");
        addMenuItem(subRights, "Credential Management...", 0, 0);
        addMenuItem(subRights, "Server Settings...", 0, 0);
        addMenuItem(subRights, "Restricted Access", 0, 0);
        menuFile.add(subRights);

        menuFile.addSeparator();
        addMenuItem(menuFile, "Close", KeyEvent.VK_W, InputEvent.CTRL_DOWN_MASK);
        addMenuItem(menuFile, "Close All", 0, 0);
        
        menuFile.addSeparator();
        addMenuItem(menuFile, "Save", KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK);
        addMenuItem(menuFile, "Save As...", KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK);
        
        menuFile.addSeparator();
        addMenuItem(menuFile, "Email...", 0, 0);
        addMenuItem(menuFile, "Share", 0, 0);
        
        menuFile.addSeparator();
        addMenuItem(menuFile, "Print...", KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK);
        
        menuFile.addSeparator();
        addMenuItem(menuFile, "Properties...", KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK);
        
        menuFile.addSeparator();
        JMenu subRecent = new JMenu("Recent Files");
        addMenuItem(subRecent, "File_1.pdf", 0, 0);
        menuFile.add(subRecent);
        
        menuFile.addSeparator();
        addMenuItem(menuFile, "Exit", KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK);

        JMenu menuEdit = new JMenu("Edit");
        menuEdit.setMnemonic('E');

        addMenuItem(menuEdit, "Undo", KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK);
        addMenuItem(menuEdit, "Redo", KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK);
        
        menuEdit.addSeparator();
        addMenuItem(menuEdit, "Cut", KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK);
        addMenuItem(menuEdit, "Copy", KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK);
        addMenuItem(menuEdit, "Paste", KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK);
        addMenuItem(menuEdit, "Delete", 0, 0);
        
        menuEdit.addSeparator();
        addMenuItem(menuEdit, "Select All", KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK);
        addMenuItem(menuEdit, "Deselect All", KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK);
        
        menuEdit.addSeparator();
        addMenuItem(menuEdit, "Add Bookmark", KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK);

        JMenu subLinks = new JMenu("Links");
        addMenuItem(subLinks, "Rectangle Link", 0, 0);
        addMenuItem(subLinks, "Polygon Link", 0, 0);
        menuEdit.add(subLinks);
        
        menuEdit.addSeparator();
        addMenuItem(menuEdit, "Attach a file", 0, 0);
        addMenuItem(menuEdit, "Add Image", 0, 0);
        addMenuItem(menuEdit, "Add Multimedia", 0, 0);

        menuBar.add(menuFile);
        menuBar.add(menuEdit);

        setJMenuBar(menuBar);

        add(new JLabel("Vui lòng chọn một mục trên Menu để kiểm tra", JLabel.CENTER));
    }

    private void addMenuItem(Object parent, String text, int keyCode, int modifiers) {
        JMenuItem item = new JMenuItem(text);

        if (keyCode != 0) {
            item.setAccelerator(KeyStroke.getKeyStroke(keyCode, modifiers));
        }
        
        item.addActionListener(this);
        
        if (parent instanceof JMenu) {
            ((JMenu) parent).add(item);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        JOptionPane.showMessageDialog(this, "Bạn vừa chọn Menu: " + cmd);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Bai33_ThietKeMenu().setVisible(true);
        });
    }
}