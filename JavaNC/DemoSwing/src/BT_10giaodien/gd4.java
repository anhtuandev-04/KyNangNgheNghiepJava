//Trương Anh Tuấn 220616
package BT_10giaodien;

import javax.swing.*;
import java.awt.*;

public class gd4 extends JFrame {
    public gd4() {
        initUI();
    }

    private void initUI() {
    	setTitle("200 x 200");
        setSize(310, 240);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); 
        
        JButton red1 = createBlock("Red 1", Color.RED);
      	JButton green1 = createBlock("Green 1", Color.GREEN);
      	JButton orange1 = createBlock("Orange 1", Color.ORANGE);		
      	JButton yellow1 = createBlock("Yellow 1", Color.YELLOW);
      	JButton blue1 = createBlock("Blue 1", new Color(173, 216, 230));	
      		
      	red1.setBounds(0, 0, 150, 50);
      	green1.setBounds(150, 0, 150, 50);
      	orange1.setBounds(0, 100, 150, 50);
      	yellow1.setBounds(150, 50, 150, 50);
      	blue1.setBounds(0, 50, 150, 50);
      		
		add(red1);
		add(green1);
		add(orange1);
		add(yellow1);
		add(blue1);

      	setVisible(true);
      }
      	
      private JButton createBlock(String text, Color color) {
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
     	SwingUtilities.invokeLater(gd4::new);
      }
}
