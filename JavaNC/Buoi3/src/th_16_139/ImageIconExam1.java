//TruongAnhTuan 220616
package th_16_139;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class ImageIconExam1 extends JFrame {

    public ImageIconExam1() {
        initUI();
    }

    private void initUI() {
        DrawingPanel dpnl = new DrawingPanel();

        createLayout(dpnl);

        setTitle("Image");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createLayout(JComponent... arg) {
        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setHorizontalGroup(gl.createSequentialGroup()
            .addComponent(arg[0])
        );

        gl.setVerticalGroup(gl.createParallelGroup()
            .addComponent(arg[0])
        );

        pack();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame f = new ImageIconExam1();
            f.setSize(400, 200);
            f.setVisible(true);
        });
    }
}