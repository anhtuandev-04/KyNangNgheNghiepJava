//Trương Anh Tuấn 220616
package BT_10giaodien;

import javax.swing.*;
import java.awt.*;

public class Window1 extends JFrame {
  public Window1() {
      setTitle("Window 1");
      setSize(600, 400);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);

      JLayeredPane layeredPane = new JLayeredPane();
      layeredPane.setLayout(null);

      JPanel buttonPanel = new JPanel(null); 
      buttonPanel.setBounds(50, 30, 500, 300); 
      buttonPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2)); 

      JButton btn1 = new JButton("Nút 1");
      JButton btn2 = new JButton("Nút 2");
      JButton btn3 = new JButton("Nút 3");
      JButton btn4 = new JButton("Nút 4");
      JButton btn5 = new JButton("Nút 5");

      btn1.setBounds(0, 0, 90, 300);           
      btn2.setBounds(90, 0, 410, 60);         
      btn3.setBounds(410, 60, 90, 240);        
      btn4.setBounds(90, 240, 320, 60);        
      btn5.setBounds(90, 60, 320, 180);        

      buttonPanel.add(btn1);
      buttonPanel.add(btn2);
      buttonPanel.add(btn3);
      buttonPanel.add(btn4);
      buttonPanel.add(btn5);

      layeredPane.add(buttonPanel, JLayeredPane.DEFAULT_LAYER);

      setContentPane(layeredPane);
      setVisible(true);
  }

  public static void main(String[] args) {
      new Window1();
  }
}