//TruongAnhTuan 220616
package th_16_139;

import javax.swing.JFrame; 
import javax.swing.JProgressBar; 
import javax.swing.WindowConstants; 


public class JProgressBarExam1 extends JFrame {     
	JProgressBar jb;     
	int i = 0, num = 0; 
  
    JProgressBarExam1() { 
        jb = new JProgressBar(0, 2000);         
        jb.setBounds(40, 40, 200, 30); 
  
        jb.setValue(0);         
        jb.setStringPainted(true); 
  
        add(jb); 
        this.setTitle("Ví dụ JProgressBar trong Java Swing");         
        this.setSize(400, 200);         
        this.setLayout(null); 
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
    } 
  
    public void iterate() {         
    	while (i <= 2000) {             
    		jb.setValue(i);             
    		i = i + 20;             
    		try { 
                Thread.sleep(150); 
            } catch (Exception e) { 
            } 
        } 
    } 
  
    public static void main(String[] args) { 
        JProgressBarExam1 m = new JProgressBarExam1(); 
        m.setVisible(true); 
        m.iterate(); 
    } 
} 
