//TruongAnhTuan 220616
package BaiTapGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bai18c extends JFrame {
    private JPopupMenu popup;

    public Bai18c() {
        setTitle("Menu Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar mb = new JMenuBar();
        mb.add(new JMenu("File"));
        mb.add(new JMenu("Edit"));
        mb.add(new JMenu("Help"));
        setJMenuBar(mb);

        popup = new JPopupMenu();
        popup.add(new JMenuItem("Read Only"));
        
        JMenu formatSubMenu = new JMenu("Format text");
        formatSubMenu.add(new JCheckBoxMenuItem("Insert", true));
        formatSubMenu.add(new JMenuItem("Overtype"));
        
        popup.add(formatSubMenu);

        addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) showMenu(e);
            }
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) showMenu(e);
            }
            private void showMenu(MouseEvent e) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        });

        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new Bai18c().setVisible(true);
    }
}