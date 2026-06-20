//TruongAnhTuan220616
package demoswing;

import javax.swing.*;

public class VD2_Frame extends JFrame {
    private JButton jbt1;
    public VD2_Frame() {
        super();
        this.initComponents();
    }
    private void initComponents() {
    	ImageIcon icon  = new ImageIcon(this.getClass().getResource("images/T.png"));
        this.setIconImage(icon.getImage());
        //JFrame
        this.setTitle("Ví dụ 2");       
         this.setSize(550,300);
        this.setExtendedState(JFrame.NORMAL);
        //Button
        this.jbt1=new JButton();        
        this.jbt1.setText("Button 1");
        this.add(this.jbt1);    
        }

}
