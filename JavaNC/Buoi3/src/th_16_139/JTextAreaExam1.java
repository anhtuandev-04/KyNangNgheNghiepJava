//TruongAnhTuan 220616
package th_16_139;

import java.awt.Color; 

import javax.swing.JFrame; 
import javax.swing.JTextArea; 
  
public class JTextAreaExam1 { 
    JTextArea area; 
    JFrame f; 
  
    JTextAreaExam1() { 
        f = new JFrame("Vi du JTextAreaExam - Java Swing"); 
  
        area = new JTextArea(300, 300); 
 	        area.setBounds(10, 30, 300, 300); 
  
        area.setBackground(Color.gray);         
        area.setForeground(Color.white); 
  
        f.add(area); 
  
        f.setSize(400, 400); 
        f.setLayout(null); 
        f.setVisible(true); 
    } 
  
    public static void main(String[] args) {         
    	new JTextAreaExam1(); 
    } 
}
