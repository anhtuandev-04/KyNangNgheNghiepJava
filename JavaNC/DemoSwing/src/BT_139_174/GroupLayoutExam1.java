//Trương Anh Tuấn 220616
package BT_139_174;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

	public class GroupLayoutExam1 {
		private JFrame mainFrame;
		private JLabel headerLabel;
		private JLabel statusLabel;
		private JPanel controlPanel;
		public GroupLayoutExam1() {
			prepareGUI();
		}
		public static void main(String[] args) {
			GroupLayoutExam1 demo = new GroupLayoutExam1();
			demo.showGroupLayoutDemo();
	}
		private void prepareGUI() {
			mainFrame = new JFrame();
			mainFrame.setSize(400, 350);
			mainFrame.setLayout(new GridLayout(3, 1));
			headerLabel = new JLabel("", JLabel.CENTER);
			statusLabel = new JLabel("", JLabel.CENTER);
			statusLabel.setSize(350, 100);
			controlPanel = new JPanel();
			controlPanel.setLayout(new FlowLayout());
			mainFrame.add(headerLabel);
			mainFrame.add(controlPanel);
			mainFrame.add(statusLabel);
			mainFrame.setVisible(true);
			mainFrame.setTitle("Ví dụ GroupLayout trong Java Swing");
			mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		}
		private void showGroupLayoutDemo() {
			headerLabel.setText("Layout in action: GroupLayout");
			JPanel panel = new JPanel();
			panel.setBackground(Color.darkGray);
			panel.setSize(200, 200);
			GroupLayout layout = new GroupLayout(panel);
			layout.setAutoCreateGaps(true);
			layout.setAutoCreateContainerGaps(true);
			JButton btn1 = new JButton("Button 1");
			JButton btn2 = new JButton("Button 2");
			JButton btn3 = new JButton("Button 3");
			layout.setHorizontalGroup(layout.createSequentialGroup().addComponent(btn1).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(btn2).addComponent(btn3))));
			layout.setVerticalGroup(layout.createSequentialGroup().addComponent(btn1).addComponent(btn2).addComponent(btn3));panel.setLayout(layout);
			controlPanel.add(panel);
			mainFrame.setVisible(true);
	}
}