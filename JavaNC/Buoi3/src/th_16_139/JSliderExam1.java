//TruongAnhTuan 220616
package th_16_139;

import javax.swing.JFrame; 
import javax.swing.JPanel; 
import javax.swing.JSlider; 
import javax.swing.WindowConstants; 

public class JSliderExam1 extends JFrame { 
  
    public JSliderExam1() { 
     JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 50, 25);         
     JPanel panel = new JPanel();         
     panel.add(slider); 
 	  
        add(panel); 
        setTitle("JSlider trong Java Swing"); 
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
    } 
  
    public static void main(String s[]) {         
    	JSliderExam1 frame = new JSliderExam1();         
    	frame.pack();         
    	frame.setVisible(true); 
    } 
}
