//Trương Anh Tuấn 220616
package BT_10giaodien;

import javax.swing.*;
import java.awt.*;

public class gd2 extends JFrame {
    public gd2() {
        setTitle("300 x 300");
        setSize(320, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(1, 5, 0, 0));

        JPanel col1 = createColumn();
        col1.add(createBlock("Red 1", Color.RED, 140));
        col1.add(createBlock("Green 1", new Color(144, 238, 144), 110));
        col1.add(Box.createVerticalGlue());
        add(col1);

        JPanel col2 = createColumn();
        col2.add(createBlock("Blue 1", new Color(173, 216, 230), 140));
        col2.add(createBlock("Yellow 1", Color.YELLOW, 60));
        col2.add(Box.createVerticalGlue());
        add(col2);

        JPanel col3 = createColumn();
        col3.add(createBlock("Orange 1", Color.ORANGE, 170));
        col3.add(createBlock("Red 2", Color.RED, 130));
        col3.add(Box.createVerticalGlue());
        add(col3);

        JPanel col4 = createColumn();
        col4.add(createBlock("Green 2", new Color(144, 238, 144), 170));
        col4.add(createBlock("Blue 2", new Color(173, 216, 230), 80));
        col4.add(Box.createVerticalGlue());
        add(col4);

        JPanel col5 = createColumn();
        col5.add(createBlock("Yellow 2", Color.YELLOW, 50));
        col5.add(createBlock("Orange 2", Color.ORANGE, 200));
        col5.add(Box.createVerticalGlue());
        add(col5);
    }

    private JPanel createColumn() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        return panel;
    }
    private JPanel createBlock(String text, Color color, int height) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panel.setBackground(color);
        
        panel.setPreferredSize(new Dimension(100, height));
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, height));
        panel.setMinimumSize(new Dimension(100, height));

        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(label);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new gd2().setVisible(true);
        });
    }
}
