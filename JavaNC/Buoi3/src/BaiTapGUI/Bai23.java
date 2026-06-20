package BaiTapGUI;

import java.awt.*;
import java.util.Arrays;
import javax.swing.*;
import java.awt.event.*;

public class Bai23 extends JFrame implements ActionListener {
    private JButton bttLogin;
    private JButton bttExit;
    private JTextField tfUser;
    private JPasswordField tfPass;

    public Bai23() {
        setTitle("Login program");
        setSize(700, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        buildGUI();
    }

    private void buildGUI() {
        JPanel pnlNorth = new JPanel();
        pnlNorth.setBorder(BorderFactory.createLineBorder(Color.red));
        JLabel labelLogon;
        pnlNorth.add(labelLogon = new JLabel("Login"));
        labelLogon.setFont(new Font("Arial", Font.BOLD, 30));
        labelLogon.setForeground(Color.red);
        add(pnlNorth, BorderLayout.NORTH);

        JPanel pnlWest = new JPanel();
        pnlWest.setBorder(BorderFactory.createLineBorder(Color.red));
        ImageIcon myImage = new ImageIcon(getClass().getResource("images/Vietnam-Flagicon.png"));
        pnlWest.add(new JLabel(myImage));
        add(pnlWest, BorderLayout.WEST);

        JPanel pnlSouth = new JPanel();
        pnlSouth.setBorder(BorderFactory.createLineBorder(Color.red));
        pnlSouth.add(bttLogin = new JButton("Login"));
        pnlSouth.add(bttExit = new JButton("Exit"));

        add(pnlSouth, BorderLayout.SOUTH);

        JPanel pnlCenter = new JPanel();
        pnlCenter.setBorder(BorderFactory.createLineBorder(Color.red));
        Box b = Box.createVerticalBox();
        Box b1 = Box.createHorizontalBox();
        Box b2 = Box.createHorizontalBox();
        JLabel lblUser, lblPass;
        b1.add(lblUser = new JLabel("User name: "));
        lblUser.setFont(new Font("Arial", Font.PLAIN, 15));
        b1.add(tfUser = new JTextField(20));
        b2.add(lblPass = new JLabel("Password: "));
        lblPass.setFont(new Font("Arial", Font.PLAIN, 15));
        b2.add(tfPass = new JPasswordField(20));
        lblPass.setPreferredSize(lblUser.getPreferredSize());
        b.add(Box.createVerticalStrut(50));
        b.add(b1);
        b.add(Box.createVerticalStrut(10));
        b.add(b2);
        pnlCenter.add(b);
        add(pnlCenter, BorderLayout.CENTER);

        tfUser.addActionListener(this);
        tfPass.addActionListener(this);
        bttLogin.addActionListener(this);
        bttExit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        char[] correctPass = {'1', '2', '3', '4', '5', '6'};
        if (e.getSource().equals(bttLogin) || e.getSource().equals(tfUser) || e.getSource().equals(tfPass)) {
            if (tfUser.getText().equalsIgnoreCase("AnhTuan") && Arrays.equals(tfPass.getPassword(), correctPass)) {
                dispose();
                JFrame nextFrame = new JFrame("Success");
                nextFrame.setSize(300, 200);
                nextFrame.setLocationRelativeTo(null);
                nextFrame.add(new JLabel("Đăng nhập thành công!", SwingConstants.CENTER));
                nextFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Sai user name hoặc password khi đăng nhập!");
                tfUser.requestFocus();
            }
        } else {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Bai23().setVisible(true);
    }
}