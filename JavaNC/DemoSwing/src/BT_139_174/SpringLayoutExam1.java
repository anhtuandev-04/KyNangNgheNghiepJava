//Trương Anh Tuấn 220616
package BT_139_174;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;

public class SpringLayoutExam1 {
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
		public SpringLayoutExam1() {
			prepareGUI();
	}
		public static void main(String[] args) {
			SpringLayoutExam1 demo = new SpringLayoutExam1();
			demo.showSpringLayoutDemo();
		}
		private void prepareGUI() {
			mainFrame = new JFrame();
			mainFrame.setSize(400, 250);
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
			mainFrame.setTitle("Ví dụ SpringLayout trong Java Swing");
			mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		}
		private void showSpringLayoutDemo() {
			headerLabel.setText("Layout in action: SpringLayout");
			SpringLayout layout = new SpringLayout();
			JPanel panel = new JPanel();
			panel.setLayout(layout);
			JLabel label = new JLabel("Enter Name: ");
			JTextField textField = new JTextField("", 15);
			panel.add(label);
			panel.add(textField);
			layout.putConstraint(SpringLayout.WEST, label, 5,
			SpringLayout.WEST, controlPanel);
			layout.putConstraint(SpringLayout.NORTH, label, 5,
			SpringLayout.NORTH, controlPanel);
			layout.putConstraint(SpringLayout.WEST, textField, 5,
			SpringLayout.EAST, label);
			layout.putConstraint(SpringLayout.NORTH, textField, 5,
			SpringLayout.NORTH, controlPanel);
			layout.putConstraint(SpringLayout.EAST, panel, 5,
			SpringLayout.EAST, textField);
			layout.putConstraint(SpringLayout.SOUTH, panel, 5,
			SpringLayout.SOUTH, textField);
			controlPanel.add(panel);
			mainFrame.setVisible(true);
		}
	}