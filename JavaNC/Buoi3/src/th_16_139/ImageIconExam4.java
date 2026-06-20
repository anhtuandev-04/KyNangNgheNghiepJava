//TruongAnhTuan 220616
package th_16_139;

import java.awt.EventQueue; 

import javax.swing.ImageIcon; 
import javax.swing.JFrame; 
  
 	public class ImageIconExam4 extends JFrame { 
  
    public ImageIconExam4() {         
    	initUI(); 
    } 
  
    private void initUI() { 
  
        ImageIcon webIcon = new ImageIcon("D:\\usr\\home1.png"); 
  
        setIconImage(webIcon.getImage()); 
  
        setTitle("Vi du ImageIcon trong tieu de");         
        setSize(300, 200);         
        setLocationRelativeTo(null);         
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
    } 
  
    public static void main(String[] args) { 
  
        EventQueue.invokeLater(() -> { 
            ImageIconExam4 f = new ImageIconExam4(); 
            f.setVisible(true); 
        }); 
    } 
} 
