//Trương Anh Tuấn 220616
package demoswing;

import java.awt.*;
import javax.swing.*;

public class VD5_FlowLayoutFrame extends JFrame {
	public VD5_FlowLayoutFrame() {
        initComponents();    
        this.setSize(400, 600);
        FlowLayout layout = new FlowLayout(
                FlowLayout.CENTER, 10, 10);
        for (int i = 0; i < 20; i ++) {
            JButton btn = new JButton();
            btn.setPreferredSize(new Dimension(80, 30));
            btn.setText("Text" + i);        
            this.getContentPane().add(btn);
        }        
        layout.setAlignment(FlowLayout.LEFT);
        this.getContentPane().setLayout(layout);
        setLocationRelativeTo(null);

    }
    private void initComponents() {
    	ImageIcon icon  = new ImageIcon(this.getClass().getResource("images/T.png"));
        this.setIconImage(icon.getImage());
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        pack();   
        }
}
