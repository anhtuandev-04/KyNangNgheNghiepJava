//TruongAnhTuan 220616
package th_16_139;

import java.awt.FlowLayout; 
import java.awt.GridLayout; 
import java.awt.event.WindowAdapter; 
import java.awt.event.WindowEvent; 
  
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JPanel; 
import javax.swing.JSlider; 
import javax.swing.WindowConstants; 
import javax.swing.event.ChangeEvent; 
import javax.swing.event.ChangeListener; 
  
public class JSliderExam3 { 
  
     private JFrame mainFrame;     
     private JLabel headerLabel;     
     private JLabel statusLabel;     
     private JPanel controlPanel; 
  
    public JSliderExam3() {         
    	prepareGUI(); 
    } 
  
    public static void main(String[] args) {         
    	JSliderExam3 demo = new JSliderExam3();         
    	demo.showSliderDemo(); 
    } 
  
    private void prepareGUI() { 
        mainFrame = new JFrame("Vi du JSlider trong Java Swing");         
        mainFrame.setSize(400, 200); 
        mainFrame.setLayout(new GridLayout(3, 1));         
        headerLabel = new JLabel("", JLabel.CENTER);         
        statusLabel = new JLabel("", JLabel.CENTER);         
        statusLabel.setSize(350, 100);         
        controlPanel = new JPanel();         
        controlPanel.setLayout(new FlowLayout());         
        mainFrame.add(headerLabel);         
        mainFrame.add(controlPanel);         
        mainFrame.add(statusLabel);         
        mainFrame.setVisible(true); 
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
    } 
    private void showSliderDemo() { 
        headerLabel.setText("Control in action: JSlider"); 
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 10);         
        slider.addChangeListener(new ChangeListener() {         
        	public void stateChanged(ChangeEvent e) {           
        		statusLabel.setText("Value : " + ((JSlider) e.getSource()).getValue()); 
            }         }); 
        controlPanel.add(slider);         
        mainFrame.setVisible(true); 
    } 
}
