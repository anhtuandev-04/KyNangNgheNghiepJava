//TruongAnhTuan 220616
package th_16_139;

import javax.swing.JFrame; 
import javax.swing.JPanel; 
import javax.swing.JSlider; 
import javax.swing.WindowConstants; 

public class JSliderExam2 extends JFrame {     public JSliderExam2() { 
      JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 50, 25);         
      slider.setMinorTickSpacing(2);         
      slider.setMajorTickSpacing(10); 
  
      slider.setPaintTicks(true);         
      slider.setPaintLabels(true); 
 
  
        JPanel panel = new JPanel();         
        panel.add(slider);         
        add(panel); 
        setTitle("JSlider trong Java Swing"); 
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
    } 
  
    public static void main(String s[]) {         
    	JSliderExam2 frame = new JSliderExam2();         
    	frame.pack();         
    	frame.setVisible(true); 
    } 
}
