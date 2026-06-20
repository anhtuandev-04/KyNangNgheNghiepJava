//TruongAnhTuan 220616
package th_16_139;

import java.awt.Color; 
import java.awt.FlowLayout;  	
import java.awt.GridLayout; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.awt.event.WindowAdapter; 
import java.awt.event.WindowEvent; 
  
import javax.swing.JButton; 
import javax.swing.JColorChooser; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JPanel; 
  
public class JColorChooserExam2 { 
  
    private JFrame mainFrame;     
    private JLabel headerLabel;     
    private JLabel statusLabel;     
    private JPanel controlPanel; 
  
    public JColorChooserExam2() {         
    	prepareGUI(); 
    } 
  
    public static void main(String[] args) {         
    	JColorChooserExam2 swingControlDemo = new JColorChooserExam2();         
    	swingControlDemo.showColorChooserDemo(); 
    } 
  
    private void prepareGUI() { 
        mainFrame = new JFrame("Vi du Java Swing");         
        mainFrame.setSize(400, 300);         
        mainFrame.setLayout(new GridLayout(3, 1));         
        mainFrame.addWindowListener(new WindowAdapter() {             
        	public void windowClosing(WindowEvent windowEvent) { 
                System.exit(0); 
            }         }); 
        headerLabel = new JLabel("", JLabel.CENTER);         
        statusLabel = new JLabel("", JLabel.CENTER);         
        statusLabel.setSize(350, 100);         
        controlPanel = new JPanel();         
        controlPanel.setLayout(new FlowLayout());         
        mainFrame.add(headerLabel);         
        mainFrame.add(controlPanel);         
        mainFrame.add(statusLabel);         
        mainFrame.setVisible(true); 
    } 
  
    private void showColorChooserDemo() { 
        headerLabel.setText("Control in action: JColorChooser");         
        JButton chooseButton = new JButton("Choose Background");         
        chooseButton.addActionListener(new ActionListener() {             
        	public void actionPerformed(ActionEvent e) { 
                Color backgroundColor = JColorChooser.showDialog(mainFrame,"Choose background color", Color.white);                 
                if (backgroundColor != null) { 
                    controlPanel.setBackground(backgroundColor);                     
                    mainFrame.getContentPane().setBackground(backgroundColor); 
                } 
            }         
        	}); 
        controlPanel.add(chooseButton); 
        mainFrame.setTitle("Vi du JColorChooser trong Java Swing");         
        mainFrame.setVisible(true); 
    } 
}
