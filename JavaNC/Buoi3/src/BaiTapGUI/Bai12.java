//TruongAnhTuan 220616
package BaiTapGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bai12 extends JFrame {

	 private int count = 0;      
	    private JButton button;     
	    private JLabel label;      
	    public Bai12() {
	        setTitle("Push Counter");           
	        setSize(300, 150);                  
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	        setLocationRelativeTo(null);         
	        
	        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

	        button = new JButton("Push Me!");
	        label = new JLabel("Pushes: 0");

	        button.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                count++; 
	                label.setText("Pushes: " + count); 
	            }
	        });

	        add(button);
	        add(label);
	        
	        getContentPane().setBackground(new Color(173, 216, 230)); 
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            Bai12 frame = new Bai12();
	            frame.setVisible(true); 
	        });
	    }

}
