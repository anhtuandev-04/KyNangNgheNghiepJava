//Trương Anh Tuấn 220616
package BT_10giaodien;

import javax.swing.*;
import java.awt.*;

public class gd6 extends JFrame {
	public gd6() {
		setTitle("200 x 200");
		setSize(314, 277);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
		JButton red1 = createBlock("Red 1", Color.RED);
		JButton green1 = createBlock("Green 1", Color.GREEN);
		JButton blue1 = createBlock("Blue 1", new Color(173, 216, 230));
		
		red1.setBounds(0, 0, 150, 120);
		green1.setBounds(150, 0, 150, 120);
		blue1.setBounds(0, 120, 150, 120);
		
		add(red1);
		add(green1);
		add(blue1);
		
		setVisible(true);
	}
	
	private JButton createBlock(String text, Color color){
		JButton btn = new JButton(text);
		btn.setBackground(color);
		btn.setOpaque(true);
		btn.setBorderPainted(false);
		
		btn.setHorizontalAlignment(SwingConstants.LEFT);
		btn.setVerticalAlignment(SwingConstants.TOP);
		btn.setMargin(new Insets(5, 10, 5, 5));
		
		return btn;
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(gd6::new);
	}
}
