//TruongAnhTuan 220616
package demoswingcomponents;

import javax.swing.DefaultComboBoxModel;

public class VD14_DemoComboBox extends javax.swing.JFrame {

    private javax.swing.JComboBox<String> jComboBox1;

    public VD14_DemoComboBox() {
        initComponents();
    }

    private void initComponents() {
        jComboBox1 = new javax.swing.JComboBox();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 300));
        getContentPane().setLayout(new java.awt.FlowLayout());
        jComboBox1.setPreferredSize(new java.awt.Dimension(100, 20));
        getContentPane().add(jComboBox1);

        String[] items = new String[] {"Item 1", "Item 2", "Item 3"};
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel(items);
        jComboBox1.setModel(model);
        pack();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VD14_DemoComboBox().setVisible(true);
            }
        });
    }
}