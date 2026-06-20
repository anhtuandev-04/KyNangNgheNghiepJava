//Trương Anh Tuấn 220616
package BT_10giaodien;

import javax.swing.*;
import java.awt.*;

public class DockPanelLayout extends JFrame {
  public DockPanelLayout() {
      setTitle("DockPanelLayout");
      setSize(600, 400);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);

      JPanel buttonPanel = new JPanel(null);
      buttonPanel.setBounds(30, 30, 520, 300);
      buttonPanel.setBorder(BorderFactory.createTitledBorder(""));

      JButton btnTop1 = new JButton("Top 1");
      JButton btnTop2 = new JButton("Top 2");
      JButton btnLeft = new JButton("Left, VAlign=\"Top\"");
      JButton btnRight = new JButton("Right 1");
      JButton btnBottom2 = new JButton("Bottom 2, HAlign=\"Left\"");
      JButton btnBottom1 = new JButton("Bottom 1");
      JButton btnCenter = new JButton("Add more controls here");

      btnTop1.setBounds(0, 0, 520, 30);         
      btnTop2.setBounds(0, 30, 440, 30);        
      btnLeft.setBounds(0, 60, 150, 80);        
      btnRight.setBounds(440, 30, 80, 270);    
      btnBottom2.setBounds(150, 230, 180, 40);  
      btnBottom1.setBounds(0, 270, 440, 30);    
      btnCenter.setBounds(150, 60, 290, 170); 

      buttonPanel.add(btnTop1);
      buttonPanel.add(btnTop2);
      buttonPanel.add(btnLeft);
      buttonPanel.add(btnRight);
      buttonPanel.add(btnBottom2);
      buttonPanel.add(btnBottom1);
      buttonPanel.add(btnCenter);

      setLayout(null);
      add(buttonPanel);

      setVisible(true);
  }

  public static void main(String[] args) {
  	SwingUtilities.invokeLater(DockPanelLayout::new);
  }
}