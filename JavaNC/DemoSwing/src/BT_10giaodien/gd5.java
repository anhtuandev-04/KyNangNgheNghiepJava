//Trương Anh Tuấn 220616
package BT_10giaodien;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;

public class gd5 extends JFrame {
    public gd5() {
        initUI();
    }

    private void initUI() {
        setTitle("400 x 350");
        setSize(420, 390);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        add(createPanel("Red 1", Color.RED, 0, 80), BorderLayout.NORTH);

        JPanel mainBodyPanel = new JPanel(new BorderLayout());
        add(mainBodyPanel, BorderLayout.CENTER);

        mainBodyPanel.add(createPanel("Green 1", new Color(144, 238, 144), 60, 0), BorderLayout.WEST);

        mainBodyPanel.add(createPanel("Blue 1", new Color(173, 216, 230), 60, 0), BorderLayout.EAST);

        JPanel centerContentPanel = new JPanel(new BorderLayout());
        mainBodyPanel.add(centerContentPanel, BorderLayout.CENTER);

        JPanel topInnerPanel = new JPanel(new BorderLayout());
        topInnerPanel.add(createPanel("Orange 1", Color.ORANGE, 100, 0), BorderLayout.WEST);
        topInnerPanel.add(createPanel("Green 2", new Color(144, 238, 144), 0, 0), BorderLayout.CENTER);
        
        centerContentPanel.add(topInnerPanel, BorderLayout.CENTER);

        JPanel bottomInnerPanel = new JPanel();
        bottomInnerPanel.setLayout(new BoxLayout(bottomInnerPanel, BoxLayout.Y_AXIS));
        
        bottomInnerPanel.add(createPanel("Yellow 1", Color.YELLOW, Integer.MAX_VALUE, 50));
        bottomInnerPanel.add(createPanel("Blue 2", new Color(173, 216, 230), Integer.MAX_VALUE, 40));

        centerContentPanel.add(bottomInnerPanel, BorderLayout.SOUTH);
    }

    private JPanel createPanel(String text, Color color, int width, int height) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panel.setBackground(color);
        
        Dimension size = new Dimension(
            width > 0 ? width : 10, 
            height > 0 ? height : 10 
        );
        
        panel.setPreferredSize(size);
        
        if (width == Integer.MAX_VALUE) {
            panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, height));
        }

        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(label);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new gd5().setVisible(true);
        });
    }
}