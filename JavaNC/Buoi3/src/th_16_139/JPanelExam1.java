//TruongAnhTuan 220616
package th_16_139;

import java.awt.Color; 
import java.awt.FlowLayout; 
import java.awt.GridLayout; 

import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JPanel; 
import javax.swing.WindowConstants; 
  
public class JPanelExam1 {     
	private JFrame mainFrame;     
	private JLabel headerLabel;      
	private JLabel statusLabel;     
	private JPanel controlPanel;     
	private JLabel msglabel; 
  
    public JPanelExam1() {         
    	prepareGUI(); 
    } 
  
    public static void main(String[] args) {         
    	JPanelExam1 demo = new JPanelExam1();         
    	demo.showJPanelDemo(); 
    } 
  
    private void prepareGUI() { 
        mainFrame = new JFrame("Vi du JPanel trong Java Swing");         
        mainFrame.setSize(400, 200); 
        mainFrame.setLayout(new GridLayout(3, 1));         
        headerLabel = new JLabel("", JLabel.CENTER);         
        statusLabel = new JLabel("", JLabel.CENTER);         
        statusLabel.setSize(350, 100); 
        msglabel = new JLabel("Chao mung ban den voi Plpsoft.Vn", JLabel.CENTER); 
        controlPanel = new JPanel();         
        controlPanel.setLayout(new FlowLayout());         
        mainFrame.add(headerLabel);         
        mainFrame.add(controlPanel);         
        mainFrame.add(statusLabel);         
        mainFrame.setVisible(true); 
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
    } 
  
    private void showJPanelDemo() { 
        headerLabel.setText("Container in action: JPanel");         
        JPanel panel = new JPanel();         
        panel.setBackground(Color.magenta);         
        panel.setLayout(new FlowLayout());         
        panel.add(msglabel);         
        controlPanel.add(panel);         
        mainFrame.setVisible(true); 
    } 
} 
