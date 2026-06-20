//Trương Anh Tuấn 220616
package BT_139_174;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

	public class GridBagLayoutExam1 {
		private JFrame mainFrame;
		private JLabel headerLabel;
		private JLabel statusLabel;
		private JPanel controlPanel;
		public GridBagLayoutExam1() {
			prepareGUI();
		}
		public static void main(String[] args) {
			GridBagLayoutExam1 demo = new GridBagLayoutExam1();
			demo.showGridBagLayoutDemo();
		}
		private void prepareGUI() {
			mainFrame = new JFrame();
			mainFrame.setSize(400, 400);
			mainFrame.setLayout(new GridLayout(3, 1));
			headerLabel = new JLabel("", JLabel.CENTER);
			statusLabel = new JLabel("", JLabel.CENTER);
			statusLabel.setSize(350, 100);
			mainFrame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent windowEvent) {
					System.exit(0);
				}
			});
			controlPanel = new JPanel();
			controlPanel.setLayout(new FlowLayout());
			mainFrame.add(headerLabel);
			mainFrame.add(controlPanel);
			mainFrame.add(statusLabel);
			mainFrame.setVisible(true);
			mainFrame.setTitle("Ví dụ GridBagLayout trong JavaSwing");
			mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		}
		private void showGridBagLayoutDemo() {
			headerLabel.setText("Layout in action: GridBagLayout");
			JPanel panel = new JPanel();
			panel.setBackground(Color.darkGray);
			panel.setSize(300, 300);
			GridBagLayout layout = new GridBagLayout();
			panel.setLayout(layout);
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 0;
			gbc.gridy = 0;
			panel.add(new JButton("Button 1"), gbc);
			gbc.gridx = 1;
			gbc.gridy = 0;
			panel.add(new JButton("Button 2"), gbc);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.ipady = 20;
			gbc.gridx = 0;
			gbc.gridy = 1;
			panel.add(new JButton("Button 3"), gbc);
			gbc.gridx = 1;
			gbc.gridy = 1;
			panel.add(new JButton("Button 4"), gbc);
			gbc.gridx = 0;
			gbc.gridy = 2;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridwidth = 2;
			panel.add(new JButton("Button 5"), gbc);
			controlPanel.add(panel);
			mainFrame.setVisible(true);
		}
}