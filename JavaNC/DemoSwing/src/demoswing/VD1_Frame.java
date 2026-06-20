//TruongAnhTuan220616
package demoswing;

import java.awt.Color;

import javax.swing.*;
public class VD1_Frame extends JFrame {
    public VD1_Frame() {
        this.initComponents();    
        }
    
    private void initComponents(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ImageIcon icon  = new ImageIcon(this.getClass().getResource("images/T.png"));
        this.setIconImage(icon.getImage());
        this.setTitle("Ví dụ 1");        
        this.setLocation(0, 0);
        this.setSize(300, 400);        
        this.setExtendedState(JFrame.NORMAL);
        this.getContentPane().setBackground(Color.WHITE);
    }
}