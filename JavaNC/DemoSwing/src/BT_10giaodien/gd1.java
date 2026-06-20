//Trương Anh Tuấn 220616
package BT_10giaodien;

import javax.swing.*;
import java.awt.*;

public class gd1 extends JFrame {
    public gd1() {
        setTitle("400 x 200");
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainContainer = new JPanel();
        mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.Y_AXIS));
        mainContainer.setBackground(Color.WHITE);

        mainContainer.add(createStripPanel("Red 1", Color.RED));
        mainContainer.add(createStripPanel("Green 1", new Color(144, 238, 144)));

        mainContainer.add(createMixedRow());

        mainContainer.add(createStripPanel("Blue 1", new Color(173, 216, 230)));
        mainContainer.add(createStripPanel("Yellow 1", Color.YELLOW));
        mainContainer.add(createStripPanel("Orange 1", Color.ORANGE));

        add(mainContainer);
    }

    private JPanel createStripPanel(String text, Color bgColor) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        panel.setBackground(bgColor);
        
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
        panel.setPreferredSize(new Dimension(400, 25));

        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(label);

        return panel;
    }

    private JPanel createMixedRow() {
        JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        rowPanel.setBackground(Color.WHITE);
        rowPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));

        rowPanel.add(createSmallBlock("Red 2", Color.RED));
        rowPanel.add(createSmallBlock("Green 2", new Color(144, 238, 144)));
        rowPanel.add(createSmallBlock("Blue 2", new Color(173, 216, 230)));
        rowPanel.add(createSmallBlock("Yellow 2", Color.YELLOW));
        rowPanel.add(createSmallBlock("Orange 2", Color.ORANGE));

        return rowPanel;
    }

    private JPanel createSmallBlock(String text, Color color) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 8));
        panel.setBackground(color);
        panel.setPreferredSize(new Dimension(65, 35));
        
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 11));
        panel.add(label);
        
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new gd1().setVisible(true);
        });
    }
}