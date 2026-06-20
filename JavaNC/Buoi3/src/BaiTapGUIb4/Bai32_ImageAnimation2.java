package BaiTapGUIb4;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

public class Bai32_ImageAnimation2 extends JFrame {
    private static final long serialVersionUID = 1L;
    private Timer timer;
    private int pos = 0;
    private JPanel pnCenter;
    private CardLayout cardLayout;

    public Bai32_ImageAnimation2(String title) {
        super(title);
        cardLayout = new CardLayout();
        
        timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int count = pnCenter.getComponentCount();
                if (count > 0) {
                    cardLayout.show(pnCenter, "card" + pos);
                    pos++;
                    if (pos >= count) pos = 0;
                }
            }
        });
    }

    public void doShow() {
        setSize(700, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addControl();
        setVisible(true);
    }

    public void addControl() {
        JPanel pnBorder = new JPanel(new BorderLayout());
        
        JPanel pnNorth = new JPanel();
        JButton btnBrowser = new JButton("Browser");
        JButton btnStart = new JButton("Start");
        JButton btnStop = new JButton("Stop");
        pnNorth.add(btnBrowser);
        pnNorth.add(btnStart);
        pnNorth.add(btnStop);
        pnBorder.add(pnNorth, BorderLayout.NORTH);

        pnCenter = new JPanel(cardLayout);
        pnCenter.setBackground(Color.BLACK);
        pnBorder.add(pnCenter, BorderLayout.CENTER);

        btnBrowser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JFileChooser jfc = new JFileChooser();
                jfc.setMultiSelectionEnabled(true); 
                jfc.setDialogTitle("Chọn các file ảnh để tạo hiệu ứng");

                if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    timer.stop(); 
                    pnCenter.removeAll(); 
                    pos = 0; 

                    File[] files = jfc.getSelectedFiles();
                    for (int i = 0; i < files.length; i++) {
                        File f = files[i];
                       
                        ImageIcon icon = new ImageIcon(f.getPath());
                        Image img = icon.getImage().getScaledInstance(600, 450, Image.SCALE_SMOOTH);
                        
                        JLabel lbl = new JLabel(new ImageIcon(img));
                        lbl.setHorizontalAlignment(JLabel.CENTER);
                        
                        JPanel pn = new JPanel(new BorderLayout());
                        pn.add(lbl, BorderLayout.CENTER);
                        
                        pnCenter.add(pn, "card" + i);
                    }
                    
                    pnCenter.revalidate();
                    pnCenter.repaint();
                    if (files.length > 0) {
                        cardLayout.show(pnCenter, "card0");
                    }
                }
            }
        });

        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (pnCenter.getComponentCount() > 0) {
                    timer.start();
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng bấm Browser để chọn ảnh trước!");
                }
            }
        });

        btnStop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                timer.stop();
            }
        });

        getContentPane().add(pnBorder);
    }

    public static void main(String[] args) {
        new Bai32_ImageAnimation2("Chương trình duyệt ảnh tự động - Bài 32").doShow();
    }
}