package BaiTapGUIb4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai25 extends JFrame implements ActionListener {
    private JMenuItem quitItem, eraseItem;
    private JMenuItem redItem, greenItem, blueItem, pinkItem, blackItem, moreColorItem;

    public Bai25() {
        setTitle("MyMenuFrame");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        quitItem = new JMenuItem("Quit");
        quitItem.addActionListener(this);
        fileMenu.add(quitItem);

        JMenu editMenu = new JMenu("Edit");
        eraseItem = new JMenuItem("Erase");
        eraseItem.addActionListener(this);
        editMenu.add(eraseItem);

        JMenu colorMenu = new JMenu("Color");
        redItem = new JMenuItem("Red");
        greenItem = new JMenuItem("Green");
        blueItem = new JMenuItem("Blue");
        pinkItem = new JMenuItem("Pink");
        blackItem = new JMenuItem("Black");
        moreColorItem = new JMenuItem("More Color");

        redItem.addActionListener(this);
        greenItem.addActionListener(this);
        blueItem.addActionListener(this);
        pinkItem.addActionListener(this);
        blackItem.addActionListener(this);
        moreColorItem.addActionListener(this);

        colorMenu.add(redItem);
        colorMenu.add(greenItem);
        colorMenu.add(blueItem);
        colorMenu.add(pinkItem);
        colorMenu.add(blackItem);
        colorMenu.addSeparator();
        colorMenu.add(moreColorItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(colorMenu);

        setJMenuBar(menuBar);
        getContentPane().setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == quitItem) {
            System.exit(0);
        } else if (src == eraseItem) {
            getContentPane().setBackground(Color.WHITE);
        } else if (src == redItem) {
            getContentPane().setBackground(Color.RED);
        } else if (src == greenItem) {
            getContentPane().setBackground(Color.GREEN);
        } else if (src == blueItem) {
            getContentPane().setBackground(Color.BLUE);
        } else if (src == pinkItem) {
            getContentPane().setBackground(Color.PINK);
        } else if (src == blackItem) {
            getContentPane().setBackground(Color.BLACK);
        } else if (src == moreColorItem) {
            Color chosenColor = JColorChooser.showDialog(this, "Select Color", getContentPane().getBackground());
            if (chosenColor != null) {
                getContentPane().setBackground(chosenColor);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai25().setVisible(true));
    }
}