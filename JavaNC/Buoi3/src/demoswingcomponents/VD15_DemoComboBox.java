//TruongAnhTuan 220616
package demoswingcomponents;

import javax.swing.*;

public class VD15_DemoComboBox extends javax.swing.JFrame {
    private javax.swing.JComboBox jComboBox1;

    public VD15_DemoComboBox() {
        initComponents();      

        person p1 = new person(1, "A");
        person p2 = new person(2, "B");
        person p3 = new person(3, "C");

        person[] items = new person[] {p1, p2, p3};
        DefaultComboBoxModel model = new DefaultComboBoxModel(items);
        model.setSelectedItem(p2);
        jComboBox1.setModel(model);
    }

    private void initComponents() {
        jComboBox1 = new javax.swing.JComboBox();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());
        getContentPane().add(jComboBox1);
        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VD15_DemoComboBox().setVisible(true));
   }
}
