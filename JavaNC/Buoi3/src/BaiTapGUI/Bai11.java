//TruongAnhTuan 220616
package BaiTapGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.*;

public class Bai11 extends JFrame {
	private JButton jb = new JButton("JButton");  
	 private BasicArrowButton  
	 up = new BasicArrowButton(BasicArrowButton.NORTH),  
	 down = new BasicArrowButton(BasicArrowButton.SOUTH),  
	 right = new BasicArrowButton(BasicArrowButton.EAST),  
	 left = new BasicArrowButton(BasicArrowButton.WEST);  
	 public Bai11() {  
	  setTitle("Types of buttons"); 
	  setSize(350, 200); 
	  setDefaultCloseOperation(EXIT_ON_CLOSE); 
	  setLayout(new FlowLayout()); 
	  setLocationRelativeTo(null); 
	  add(jb);  
	  add(new JToggleButton("JToggleButton"));  
	  add(new JCheckBox("JCheckBox"));  
	  add(new JRadioButton("JRadioButton"));  
	  JPanel jp = new JPanel();  
	  jp.setBorder(new TitledBorder("Directions"));  
	  jp.add(up);  
	  jp.add(down);  
	  jp.add(left);  
	  jp.add(right);  
	  add(jp);  
	 }  
	 public static void main(String[] args) {  
	  new Bai11().setVisible(true);  
	 } 
	
}
