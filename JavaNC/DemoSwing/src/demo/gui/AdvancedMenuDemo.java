//TruongAnhTuan 220616
package demo.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdvancedMenuDemo extends JFrame {
    public AdvancedMenuDemo() {
        setTitle("Menu Example");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        JMenu editMenu = new JMenu("Edit");
        editMenu.add(new JCheckBoxMenuItem("Read Only"));
        editMenu.add(new JMenuItem("Format text"));

        JMenu subMenu = new JMenu("Mode");
        subMenu.add(new JRadioButtonMenuItem("Insert", true));
        subMenu.add(new JRadioButtonMenuItem("Overtype"));

        editMenu.add(subMenu);
        menuBar.add(editMenu);

        setJMenuBar(menuBar);

        JPopupMenu popup = new JPopupMenu();
        popup.add(new JMenuItem("Cut"));
        popup.add(new JMenuItem("Copy"));
        popup.add(new JMenuItem("Paste"));

        JTextArea area = new JTextArea("Right-click to see popup menu");
        area.setComponentPopupMenu(popup);
        add(new JScrollPane(area));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AdvancedMenuDemo().setVisible(true));
    }
}