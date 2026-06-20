//Trương Anh Tuấn 220616
package BT_10giaodien;

import javax.swing.*;
import java.awt.*;

public class gd7 extends JFrame {
    public gd7() {
        setTitle("400 x 350");
        setSize(550, 430);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); 
        
        JButton red1 = createBlock("Red 1", Color.RED);
        JButton green1 = createBlock("Green 1", Color.GREEN);
        JButton blue1 = createBlock("Blue 1", new Color(173, 216, 230)); 
        JButton blue2 = createBlock("Blue 2", new Color(173, 216, 230));
        JButton yellow1 = createBlock("Yellow 1", Color.YELLOW);
        JButton orange1 = createBlock("Orange 1", Color.ORANGE);

        red1.setBounds(0, 0, 60, 30);      
        green1.setBounds(390, 0, 70, 30);   
        blue1.setBounds(150, 80, 60, 30);   
        blue2.setBounds(170, 125, 60, 30);  
        yellow1.setBounds(70, 300, 70, 30);  
        orange1.setBounds(370, 300, 75, 30); 

		add(red1);
		add(green1);
		add(blue1);
		add(blue2);
		add(yellow1);
		add(orange1);

        setVisible(true);
    }

    private JButton createBlock(String text, Color color) {
        JButton btn = new JButton(text);
        btn.setBackground(color);
        btn.setOpaque(true);
        btn.setBorderPainted(false);
        btn.setMargin(new Insets(5, 10, 5, 5)); 

        return btn;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(gd7::new);
    }
}
