//Trương Anh Tuấn 220616
package demoswing;

import java.awt.*;
import javax.swing.*;

public class VD8_GridLayoutFrame extends JFrame {
	private JButton[] jbts;
    public VD8_GridLayoutFrame() {
    	initComponents();     
    }
    private void initComponents() {
    	ImageIcon icon  = new ImageIcon(this.getClass().getResource("images/T.png"));
        this.setIconImage(icon.getImage());
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        GridLayout layout = new GridLayout(7, 3, 10, 10); 
        this.setLayout(layout);
        
        this.jbts = new JButton[21];
        for (int i = 0; i < 21; i++) {
            this.jbts[i] = new JButton();            
            this.jbts[i].setText(String.valueOf(i + 1));
            this.getContentPane().add(this.jbts[i]);
        }
        this.setSize(500,400);
        setLocationRelativeTo(null);

     }
}