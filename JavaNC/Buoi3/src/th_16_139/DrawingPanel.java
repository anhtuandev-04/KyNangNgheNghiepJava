//TruongAnhTuan 220616
package th_16_139;

import java.awt.Container; 
import java.awt.Dimension; 
import java.awt.EventQueue; 
import java.awt.Graphics; 
  
import javax.swing.GroupLayout; 
import javax.swing.ImageIcon; 
import javax.swing.JComponent; 
import javax.swing.JFrame; 
import javax.swing.JPanel; 
  
public class DrawingPanel extends JPanel {     
	private ImageIcon icon; 
  
    public DrawingPanel() { 
  
        loadImage();  	        
        initPanel(); 
    } 
  
    private void loadImage() { 
  
        icon = new ImageIcon("D:\\usr\\book-80.png"); 
    } 
  
    private void initPanel() { 
  
        int w = icon.getIconWidth();         
        int h = icon.getIconHeight();         
        setPreferredSize(new Dimension(w, h)); 
    } 
  
    @Override 
    public void paintComponent(Graphics g) {         
    	super.paintComponent(g);         
    	icon.paintIcon(this, g, 0, 0); 
    } 
} 
  
