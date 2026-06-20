//TruongAnhTuan 220616
package th_16_139;

import java.awt.FlowLayout; 
import java.awt.Graphics; 
import java.awt.GridLayout; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.awt.event.WindowAdapter; 
import java.awt.event.WindowEvent; 
  
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JPanel; 
import javax.swing.JWindow; 
 
  
public class JWindowExam1 {     
	private JFrame mainFrame;     
	private JLabel headerLabel;     
	private JLabel statusLabel;     
	private JPanel controlPanel; 
  
    public JWindowExam1() {         
    	prepareGUI(); 
    } 
  
    public static void main(String[] args) {         
    	JWindowExam1 demo = new JWindowExam1();         
    	demo.showJWindowDemo(); 
    } 
  
    private void prepareGUI() { 
        mainFrame = new JFrame("Vi du JWindow trong Java Swing");         
        mainFrame.setSize(400, 250);         
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
  
    private void showJWindowDemo() { 
        headerLabel.setText("Container in action: JWindow");         
        final MessageWindow window = new MessageWindow(mainFrame,  
                "Chao mung ban den voi Plpsoft.Vn.");         
        JButton okButton = new JButton("Open a Window");         
        okButton.addActionListener(new ActionListener() {             
        	public void actionPerformed(ActionEvent e) {                 
        		window.setVisible(true); 
   statusLabel.setText("Mot Window duoc hien thi toi nguoi dung."); 
            }         }); 
        controlPanel.add(okButton);         
        mainFrame.setVisible(true); 
    } 
  
    class MessageWindow extends JWindow {         
    	private String message; 
  
        public MessageWindow(JFrame parent, String message) {             
        	super(parent);             
        	this.message = message;             
        	setSize(300, 300);             
        	setLocationRelativeTo(parent); 
        } 
  
        public void paint(Graphics g) {             
        	super.paint(g); 
        g.drawRect(0, 0, getSize().width - 1, 
        		getSize().height - 1); 
            g.drawString(message, 50, 150); 
        } 
    } 
} 
