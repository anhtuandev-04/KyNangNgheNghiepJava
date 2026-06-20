//TruongAnhTuan 220616
package demoswingcomponents;

import javax.swing.DefaultListModel;

public class VD16_DemoList extends javax.swing.JFrame {
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;

    public VD16_DemoList() {
        initComponents();   
        DefaultListModel model = new DefaultListModel() {
            String[] items = new String[] {"Item 1", "Item 2", "Item 3"};

            @Override
            public int getSize() { 
                return items.length; 
            }

            @Override
            public Object getElementAt(int i) { 
                return items[i]; 
            }
        };
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
        javax.swing.SwingUtilities.invokeLater(() -> new VD16_DemoList().setVisible(true));
    }
}