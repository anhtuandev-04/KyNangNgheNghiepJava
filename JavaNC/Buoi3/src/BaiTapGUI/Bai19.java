//TruongAnhTuan 220616
package BaiTapGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bai19 extends JFrame implements ActionListener {
	private JDesktopPane desktopPane; 
	private JMenuBar menubar; 
	private JMenu mnuFile; 
	private JMenuItem itemNew,itemExit; 
	private int i=1; 
	
	public Bai19() { 
		  super("MDI Example"); 
		  setDefaultCloseOperation(EXIT_ON_CLOSE); 
		  setSize(700,500); 
		  setLocationRelativeTo(null);
		 
		  desktopPane=new JDesktopPane(); 
		  desktopPane.setAutoscrolls(true); 
		  this.setContentPane(desktopPane); 
		  CreateMENU(); 
		 } 
	private void CreateMENU() { 
		  this.setJMenuBar(menubar=new JMenuBar()); 
		  menubar.add(mnuFile=new JMenu("File")); 
		  mnuFile.add(itemNew=new JMenuItem("New",'N')); 
		 
		 itemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK)); 
		  mnuFile.addSeparator(); 
		  mnuFile.add(itemExit=new JMenuItem("Exit",'x')); 
		  itemNew.addActionListener(this); 
		  itemExit.addActionListener(this); 
		 }
	@Override 
	 public void actionPerformed(ActionEvent e) { 
	  Object o=e.getSource(); 
	  if(o.equals(itemNew)) { 
	   JInternalFrame frm= 
	    new JInternalFrame("Document "+i++,true,true,true,true); 
	   desktopPane.add(frm); 
	   frm.setSize(250, 250); 
	   frm.setVisible(true);    
	  } 
	  else if(o.equals(itemExit)) { 
	   System.exit(0); 
	  } 
	 } 
	public static void main(String[] args) {
		new Bai19().setVisible(true);

	}

}
