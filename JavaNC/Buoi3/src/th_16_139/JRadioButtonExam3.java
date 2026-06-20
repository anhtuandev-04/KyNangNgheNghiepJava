//TruongAnhTuan 220616
package th_16_139;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
  
import javax.swing.ButtonGroup; 
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JOptionPane; 
import javax.swing.JRadioButton; 
  
public class JRadioButtonExam3 extends JFrame implements  ActionListener { 
    JRadioButton rb1, rb2; 
    JButton b; 
  
    JRadioButtonExam3() { 
  
        rb1 = new JRadioButton("Green");         
        rb1.setBounds(100, 50, 100, 30); 
  
        rb2 = new JRadioButton("Red");         
        rb2.setBounds(100, 100, 100, 30); 
        ButtonGroup bg = new ButtonGroup();         
        bg.add(rb1);         
        bg.add(rb2); 
  
        b = new JButton("click"); 
        b.setBounds(100, 150, 80, 30); 
        b.addActionListener(this); 
  
        add(rb1);         
        add(rb2);         
        add(b); 
  
        setTitle("Vi du JRadioButton trong Java Swing");         
        setSize(400, 250);         
        setLayout(null);         
        setVisible(true); 
    } 
  
    public void actionPerformed(ActionEvent e) {         
    	if (rb1.isSelected()) { 
            JOptionPane.showMessageDialog(this, "Ban la Green"); 
        } 
        if (rb2.isSelected()) { 
            JOptionPane.showMessageDialog(this, "Ban la Red"); 
        } 
    } 
  
    public static void main(String args[]) {         
    	new JRadioButtonExam3(); 
    } 
}
