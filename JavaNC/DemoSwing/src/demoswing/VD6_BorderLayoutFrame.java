//Trương Anh Tuấn 220616
package demoswing;

import java.awt.*;
import javax.swing.*;

public class VD6_BorderLayoutFrame extends JFrame {
    JButton btnCenter;    JButton btnWest;    JButton btnEast;
    JButton btnNorth;    JButton btnSouth;
    public VD6_BorderLayoutFrame() {  	
    	initComponents();
        btnCenter = new JButton("CENTER");    
        btnWest = new JButton("WEST");
        btnEast = new JButton("EAST");               
        btnNorth = new JButton("NORTH");
        btnSouth = new JButton("SOUTH");        
        btnCenter.setText("CENTER");
        this.setSize(400, 300);         
        BorderLayout layout = new BorderLayout(10, 20);
        this.getContentPane().setLayout(layout);
        this.getContentPane().add(btnCenter, BorderLayout.CENTER);
        this.getContentPane().add(btnNorth, BorderLayout.NORTH);
        this.getContentPane().add(btnSouth, BorderLayout.SOUTH);
        this.getContentPane().add(btnWest, BorderLayout.WEST);
        this.getContentPane().add(btnEast, BorderLayout.EAST);
        
    }
    private void initComponents() {
    	ImageIcon icon  = new ImageIcon(this.getClass().getResource("images/T.png"));
        this.setIconImage(icon.getImage());
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        pack();
    }


}
