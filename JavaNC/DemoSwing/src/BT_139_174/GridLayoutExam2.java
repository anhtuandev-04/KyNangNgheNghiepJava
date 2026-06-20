//Trương Anh Tuấn 220616
package BT_139_174;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

	public class GridLayoutExam2 {
		private JFrame mainFrame;
		private JLabel headerLabel;
		private JLabel statusLabel;
		private JPanel controlPanel;
		private JLabel msglabel;
		public GridLayoutExam2() {
			prepareGUI();
		}
		public static void main(String[] args) {
			GridLayoutExam2 swingLayoutDemo = new GridLayoutExam2();
			swingLayoutDemo.showGridLayoutDemo();
		}
		private void prepareGUI() {
			mainFrame = new JFrame();
			mainFrame.setSize(400, 400);
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
			mainFrame.setTitle("Ví dụ GridLayout trong Java Swing");
			mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		}
		private void showGridLayoutDemo() {
			headerLabel.setText("Layout in action: GridLayout");
			JPanel panel = new JPanel();
			panel.setBackground(Color.darkGray);
			panel.setSize(300, 300);
			GridLayout layout = new GridLayout(0, 3);
			layout.setHgap(10);
			layout.setVgap(10);
			panel.setLayout(layout);
			panel.add(new JButton("Button 1"));
			panel.add(new JButton("Button 2"));
			panel.add(new JButton("Button 3"));
			panel.add(new JButton("Button 4"));
			panel.add(new JButton("Button 5"));
			controlPanel.add(panel);
			mainFrame.setVisible(true);
		}
	}	