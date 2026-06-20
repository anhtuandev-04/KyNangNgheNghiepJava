//TruongAnhTuan 220616
package th_16_139;

import java.awt.Container; 
import java.awt.EventQueue; 
import java.awt.Image; 
  
import javax.swing.GroupLayout; 
import javax.swing.ImageIcon; 
import javax.swing.JComponent; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
  
public class ImageIconExam2 extends JFrame { 
  
    public ImageIconExam2() {         
    	initUI(); 
    } 
  
    private void initUI() { 
  
        ImageIcon originalIcon = new ImageIcon("D:\\usr\\Vietnam-Flagicon.png"); 
        JLabel originalLabel = new JLabel(originalIcon); 
  
        int width = originalIcon.getIconWidth() / 2;         
        int height = originalIcon.getIconHeight() / 2; 
  
        Image scaled = scaleImage(originalIcon.getImage(), width, height); 
  
        ImageIcon scaledIcon = new ImageIcon(scaled); 
  
        JLabel newLabel = new JLabel(scaledIcon); 
  
        createLayout(originalLabel, newLabel); 
  
        setTitle("Thay doi kich thuoc icon");         
        setLocationRelativeTo(null);         
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
    } 
  
    private Image scaleImage(Image image, int w, int h) {         
    	Image scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);         
    	return scaled; 
    } 
  
    private void createLayout(JComponent... arg) {         
    	Container pane = getContentPane();         
    	GroupLayout gl = new GroupLayout(pane);         
    	pane.setLayout(gl); 
  
        gl.setAutoCreateContainerGaps(true);         
        gl.setAutoCreateGaps(true); 
  
        gl.setHorizontalGroup(gl.createSequentialGroup() 
                .addComponent(arg[0]).addComponent(arg[1])); 
  
        gl.setVerticalGroup(gl.createParallelGroup() 
                .addComponent(arg[0]).addComponent(arg[1]));         
        pack(); 
    } 
  
    public static void main(String[] args) { 
        EventQueue.invokeLater(() -> { 
            ImageIconExam2 f = new ImageIconExam2(); 
            f.setSize(500, 400); 
            f.setVisible(true); 
        }); 
    } 
}
