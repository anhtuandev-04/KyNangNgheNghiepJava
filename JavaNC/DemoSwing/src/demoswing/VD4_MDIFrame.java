//TruongAnhTuan220616
package demoswing;

import javax.swing.*;

public class VD4_MDIFrame extends JFrame {
private JDesktopPane jDesktopPane1;

    public VD4_MDIFrame() {
        initComponents();                             
        this.setSize(500, 500);
        JInternalFrame f1 = new JInternalFrame();
        f1.setTitle("Form 1");                       
        f1.setSize(200, 200);
        this.jDesktopPane1.add(f1);        
        f1.setVisible(true);        
        JInternalFrame f2 = new JInternalFrame();
        f2.setTitle("Form 2");                       
        f2.setSize(300, 300);
        this.jDesktopPane1.add(f2);        
        f2.setVisible(true);
    }
    private void initComponents() {
    	ImageIcon icon  = new ImageIcon(this.getClass().getResource("images/T.png"));
        this.setIconImage(icon.getImage());
        jDesktopPane1 = new JDesktopPane();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(jDesktopPane1, java.awt.BorderLayout.CENTER);
        pack();    }
}