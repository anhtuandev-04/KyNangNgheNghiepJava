package BaiTapGUIb4;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

public class Bai31_ImageAnimation extends JFrame {
    private static final long serialVersionUID = 1L;
    private Timer timer;
    private int pos = 0; 
    private JPanel pnCenter;
    private CardLayout cardLayout;

    private String[] imageNames = {
        "home.png", "book-80.png", "home1.png", "lock.png", 
        "save.png", "setup.png", "test.png", "Vietnam-Flagicon.png"
    };

    public Bai31_ImageAnimation(String title) {
        super(title);
        cardLayout = new CardLayout();
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pos++;
                if (pos >= imageNames.length) pos = 0; 
                cardLayout.show(pnCenter, "card" + pos);
            }
        });
        
        doShow();
    }

    public void doShow() {
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addControl();
        setVisible(true);
    }

    public void addControl() {
        JPanel pnBorder = new JPanel(new BorderLayout());
        
        JPanel pnNorth = new JPanel();
        JButton btnStart = new JButton("Start");
        JButton btnStop = new JButton("Stop");
        pnNorth.add(btnStart);
        pnNorth.add(btnStop);
        pnBorder.add(pnNorth, BorderLayout.NORTH);

        pnCenter = new JPanel(cardLayout);
        pnBorder.add(pnCenter, BorderLayout.CENTER);
        
        addImage(pnCenter);

        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (!timer.isRunning()) timer.start();
            }
        });

        btnStop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                timer.stop();
            }
        });

        getContentPane().add(pnBorder);
    }

    private void addImage(JPanel pnCenter) {
        String folderPath = "src/BaiTapGUIb4/images/";

        for (int i = 0; i < imageNames.length; i++) {
            JPanel p = new JPanel(new BorderLayout());
            String fullPath = folderPath + imageNames[i];
            
            JLabel lblImg = new JLabel();
            lblImg.setHorizontalAlignment(JLabel.CENTER);
            
            File file = new File(fullPath);
            if (file.exists()) {
                ImageIcon icon = new ImageIcon(fullPath);
                Image img = icon.getImage().getScaledInstance(500, 400, Image.SCALE_SMOOTH);
                lblImg.setIcon(new ImageIcon(img));
            } else {
                lblImg.setText("Lỗi: Không tìm thấy " + fullPath);
                lblImg.setForeground(Color.RED);
            }
            
            p.add(lblImg, BorderLayout.CENTER);
            pnCenter.add(p, "card" + i);
        }
    }

    public static void main(String[] args) {
        new Bai31_ImageAnimation("Image Animation - Bài 31");
    }
}