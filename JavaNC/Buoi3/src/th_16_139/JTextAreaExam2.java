//TruongAnhTuan 220616
package th_16_139;

import java.awt.FlowLayout; 
import java.awt.GridLayout; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.awt.event.WindowAdapter; 
import java.awt.event.WindowEvent; 
  
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JPanel; 
import javax.swing.JScrollPane; 
import javax.swing.JTextArea; 
  
public class JTextAreaExam2 { 
  
    private JFrame mainFrame;     
    private JLabel headerLabel;     
    private JLabel statusLabel;     
    private JPanel controlPanel; 
  
    public JTextAreaExam2(){        
    	prepareGUI(); 
    } 
  
    public static void main(String[] args) { 
        JTextAreaExam2 swingDemo = new JTextAreaExam2();         
        swingDemo.showTextAreaDemo(); 
    } 
  
    private void prepareGUI() { 
        mainFrame = new JFrame("Vi du JTextAreaExam - Java Swing");         
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
  
    private void showTextAreaDemo() { 
        headerLabel.setText("Control in action: JTextArea");         
        JLabel commentlabel = new JLabel("Comments: ", JLabel.RIGHT); 
        final JTextArea commentTextArea = new JTextArea( 
          "Huong da su dung JTextArea\n" + "Java Swing.", 5, 20); 
        JScrollPane scrollPane = new JScrollPane(commentTextArea);         
        JButton showButton = new JButton("Show");         
        showButton.addActionListener(new ActionListener() {             
        	public void actionPerformed(ActionEvent e) {                 
        		statusLabel.setText(commentTextArea.getText()); 
            }         }); 
        controlPanel.add(commentlabel);         
        controlPanel.add(scrollPane);         
        controlPanel.add(showButton);         
        mainFrame.setVisible(true); 
    } 
}
