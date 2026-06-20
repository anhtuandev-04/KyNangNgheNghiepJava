//TruongAnhTuan 220616
package th_16_139;

import java.awt.Color; 
import java.awt.Container; 
import java.awt.FlowLayout; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
  
import javax.swing.JButton; 
import javax.swing.JColorChooser; 
import javax.swing.JFrame; 
  
 public class JColorChooserExam1 extends JFrame implements ActionListener { 
    JButton b; 
    Container c; 
  
    JColorChooserExam1() {         
    	c = getContentPane(); 
        c.setLayout(new FlowLayout()); 
  
        b = new JButton("color"); 
        b.addActionListener(this); 
  
        c.add(b); 
    } 
  
    public void actionPerformed(ActionEvent e) { 
        Color initialcolor = Color.RED; 
        Color color = JColorChooser.showDialog(this,"Select a color", initialcolor); 
        c.setBackground(color); 
    } 
  
    public static void main(String[] args) { 
        JColorChooserExam1 ch = new JColorChooserExam1();         
        ch.setSize(400, 200);         
        ch.setVisible(true); 
        ch.setTitle("Vi du JColorChooser trong Java Swing");         
        ch.setDefaultCloseOperation(EXIT_ON_CLOSE); 
    } 
}
