//TruongAnhTuan 220616
package demo.gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class BorderDemo extends JFrame {
    public BorderDemo() {
        setTitle("Border Demo");
        setSize(600, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 4, 10, 10));

        add(createButton("Line Border", new LineBorder(Color.RED, 2)));
        add(createButton("Etched Border", BorderFactory.createEtchedBorder()));
        add(createButton("Raised Bevel", BorderFactory.createBevelBorder(BevelBorder.RAISED)));
        add(createButton("Lowered Bevel", BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
        add(createButton("Titled Border", BorderFactory.createTitledBorder("Title")));
        add(createButton("Titled Border (Right)", BorderFactory.createTitledBorder(null, "Title", TitledBorder.RIGHT, TitledBorder.TOP)));
        add(createButton("Compound Border", BorderFactory.createCompoundBorder(new LineBorder(Color.BLUE, 2), new EmptyBorder(5, 5, 5, 5))));
        add(createButton("Matte Border", BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED)));
    }

    private JButton createButton(String text, Border border) {
        JButton button = new JButton(text);
        button.setBorder(border);
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BorderDemo().setVisible(true));
    }
}