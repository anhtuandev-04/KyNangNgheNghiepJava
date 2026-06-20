//TruongAnhTuan 220616
package demoswingcomponents;

import javax.swing.DefaultListModel;

public class VD17_DemoListObject extends javax.swing.JFrame {
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;

    public VD17_DemoListObject() {
        initComponents();        
        person p1 = new person(1, "A"); 
        person p2 = new person(2, "B");
        person p3 = new person(3, "C");

        DefaultListModel model = new DefaultListModel();
        model.addElement(p1); 
        model.addElement(p2); 
        model.addElement(p3);        
        jList1.setModel(model);
    }

    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());
        jScrollPane1.setViewportView(jList1);
        getContentPane().add(jScrollPane1);
        pack();
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new VD17_DemoListObject().setVisible(true));
    }
}