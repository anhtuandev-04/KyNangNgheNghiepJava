//TruongAnhTuan 220616
package BaiTapGUI;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Bai16 extends JFrame {

    public Bai16() {
        setTitle("Border Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        JPanel mainPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        
        mainPanel.add(createBorderPanel("Line Border", 
                BorderFactory.createLineBorder(Color.RED, 3)));

        
        mainPanel.add(createBorderPanel("Etched Border", 
                BorderFactory.createEtchedBorder()));

        
        mainPanel.add(createBorderPanel("Raised Bevel Border", 
                BorderFactory.createRaisedBevelBorder()));

        
        mainPanel.add(createBorderPanel("Lowered Bevel Border", 
                BorderFactory.createLoweredBevelBorder()));

        
        mainPanel.add(createBorderPanel("Titled Border", 
                BorderFactory.createTitledBorder("Title")));

       
        TitledBorder titledRight = BorderFactory.createTitledBorder("Title");
        titledRight.setTitleJustification(TitledBorder.RIGHT);
        mainPanel.add(createBorderPanel("Titled Border (right)", titledRight));

        
        Border blueLine = BorderFactory.createLineBorder(Color.BLUE, 3);
        Border emptyPadding = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        mainPanel.add(createBorderPanel("Compound Border", 
                BorderFactory.createCompoundBorder(blueLine, emptyPadding)));

        
        mainPanel.add(createBorderPanel("Matte Border", 
                BorderFactory.createMatteBorder(1, 10, 1, 1, Color.RED)));

        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
    }

    
    private JPanel createBorderPanel(String text, Border border) {
        JPanel p = new JPanel(new BorderLayout());
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(180, 60));
        p.add(label);
        p.setBorder(border);
        return p;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai16().setVisible(true));
    }
}