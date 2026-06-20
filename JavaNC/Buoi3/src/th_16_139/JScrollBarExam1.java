//TruongAnhTuan 220616
package th_16_139;

import java.awt.FlowLayout; 
import java.awt.GridLayout; 
import java.awt.event.AdjustmentEvent; 
import java.awt.event.AdjustmentListener; 
import java.awt.event.WindowAdapter; 
import java.awt.event.WindowEvent; 
  
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JPanel; 
import javax.swing.JScrollBar; 
 	  public class JScrollBarExam1 { 
  
    private JFrame mainFrame;     
    private JLabel headerLabel;     
    private JLabel statusLabel;     
    private JPanel controlPanel; 
  
    public JScrollBarExam1() {         
    	prepareGUI(); 
    } 
  
    public static void main(String[] args) { 
        JScrollBarExam1 demo = new JScrollBarExam1();         
        demo.showScrollbarDemo(); 
    } 
  
    private void prepareGUI() { 
        mainFrame = new JFrame("Vi du Java Swing");         
        mainFrame.setSize(400, 400); 
        mainFrame.setLayout(new GridLayout(3, 1));         
        mainFrame.addWindowListener(new WindowAdapter() {             
        	public void windowClosing(WindowEvent windowEvent) { 
                System.exit(0); 
            }         
        }); 
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
  
    private void showScrollbarDemo() { 
        headerLabel.setText("Control in action: JScrollbar");         
        final JScrollBar horizontalScroller = new JScrollBar(JScrollBar.HORIZONTAL); 
        final JScrollBar verticalScroller = new JScrollBar();         
        verticalScroller.setOrientation(JScrollBar.VERTICAL);         
        horizontalScroller.setMaximum(150);         
        horizontalScroller.setMinimum(1);         
        verticalScroller.setMaximum(150);         
        verticalScroller.setMinimum(1); 
        horizontalScroller.addAdjustmentListener(new AdjustmentListener() {             
        	@Override 
            public void adjustmentValueChanged(AdjustmentEvent e) {                 
        		statusLabel.setText( "Horozontal: " + horizontalScroller.getValue() +" ,Vertical: " + verticalScroller.getValue()); 
            }         
        }); 
        verticalScroller.addAdjustmentListener(new AdjustmentListener() 
{ 
            @Override 
            public void adjustmentValueChanged(AdjustmentEvent e) {                 
            	statusLabel.setText("Horozontal: " + horizontalScroller.getValue() + " ,Vertical: " + verticalScroller.getValue()); 
            }         
            }); 
        controlPanel.add(horizontalScroller);         
        controlPanel.add(verticalScroller);         
        mainFrame.setVisible(true); 
    } 
}
