//TruongAnhTuan 220616
package th_16_139;

import javax.swing.ButtonGroup; import javax.swing.JFrame; 
import javax.swing.JRadioButton; 
  
public class JRadioButtonExam1 { 
    JFrame frame; 
  
    JRadioButtonExam1() {  	        
    	frame = new JFrame(); 
  
        JRadioButton radioBtn1 = new JRadioButton("A) Male");         
        JRadioButton radioBtn2 = new JRadioButton("B) FeMale");         
        radioBtn1.setBounds(50, 60, 170, 30);         
        radioBtn2.setBounds(50, 100, 170, 30); 
  
        ButtonGroup bg = new ButtonGroup();         
        bg.add(radioBtn1); bg.add(radioBtn2); 
  
        frame.add(radioBtn1);         
        frame.add(radioBtn2); 
        frame.setTitle("Vi du JRadioButton trong Java Swing");         
        frame.setSize(400, 250);         
        frame.setLayout(null);         
        frame.setVisible(true); 
    } 
  
    public static void main(String[] args) {         
    	new JRadioButtonExam1(); 
    } 
}