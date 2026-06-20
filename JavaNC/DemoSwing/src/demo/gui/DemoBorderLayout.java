//Trương Anh Tuấn 220616
package demo.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;

public class DemoBorderLayout extends JFrame {

    private JButton
        bn = new JButton("North"),
        bs = new JButton("South"),
        be = new JButton("East"),
        bw = new JButton("West"),
        bc = new JButton("Center");

    public DemoBorderLayout() {
        setTitle("BorderLayout");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Layout mặc định của JFrame là BorderLayout
        add(bn, BorderLayout.NORTH);
        add(bs, BorderLayout.SOUTH);
        add(be, BorderLayout.EAST);
        add(bw, BorderLayout.WEST);
        add(bc, BorderLayout.CENTER);

        // Font chữ
        Font f = new Font("Arial", Font.BOLD | Font.ITALIC, 16);
        bn.setFont(f);
        bs.setFont(f);
        be.setFont(f);
        bw.setFont(f);
        bc.setFont(f);

        // Màu sắc giống hình
        bn.setBackground(Color.RED);
        bn.setForeground(Color.WHITE);

        bs.setBackground(Color.RED);
        bs.setForeground(Color.WHITE);

        be.setBackground(Color.BLUE);
        be.setForeground(Color.WHITE);

        bw.setBackground(Color.BLUE);
        bw.setForeground(Color.WHITE);

        bc.setBackground(Color.YELLOW);
        bc.setForeground(Color.BLACK);
    }

    public static void main(String[] args) {
        new DemoBorderLayout().setVisible(true);
    }
}
