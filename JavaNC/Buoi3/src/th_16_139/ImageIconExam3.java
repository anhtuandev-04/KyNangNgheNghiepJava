//TruongAnhTuan 220616
package th_16_139;

import java.awt.Container; 
import java.awt.EventQueue; 
  
import javax.swing.GroupLayout; 
import javax.swing.ImageIcon; 
 import javax.swing.JButton; 
 import javax.swing.JComponent; 
import javax.swing.JFrame; 
  
public class ImageIconExam3 extends JFrame {     
	public ImageIconExam3() { 
        initUI(); 
    } 
  
    private void initUI() { 
  
        ImageIcon quitIcon = new ImageIcon("D:\\usr\\setup.png"); 
        ImageIcon saveIcon = new ImageIcon("D:\\usr\\save.png"); 
        ImageIcon homeIcon = new ImageIcon("D:\\usr\\home.png"); 
  
        JButton quitBtn = new JButton(quitIcon);         
        JButton saveBtn = new JButton(saveIcon); 
        JButton homeBtn = new JButton(homeIcon); 
  
        createLayout(quitBtn, saveBtn, homeBtn); 
  
        setTitle("Vi du icon trong JButtons");         
        setLocationRelativeTo(null);         
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
    } 
  
    private void createLayout(JComponent... arg) { 
  
        Container pane = getContentPane();         
        GroupLayout gl = new GroupLayout(pane);         
        pane.setLayout(gl); 
  
        gl.setAutoCreateContainerGaps(true);         
        gl.setAutoCreateGaps(true); 
  
        gl.setHorizontalGroup(gl.createSequentialGroup() 
                .addComponent(arg[0]) 
                .addComponent(arg[1])                 
                .addComponent(arg[2]) 
        ); 
  
        gl.setVerticalGroup(gl.createParallelGroup() 
                .addComponent(arg[0])                 
                .addComponent(arg[1])                 
                .addComponent(arg[2])         
        ); 
  
        gl.linkSize(arg[0], arg[1], arg[2]); 
  
        pack(); 
    } 
  
    public static void main(String[] args) { 
        EventQueue.invokeLater(() -> { 
            ImageIconExam3 f = new ImageIconExam3(); 
            f.setVisible(true); 
        }); 
    } 
}
