//Trương Anh Tuấn 220616
package BT_139_174;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
	public class BorderLayoutExam2 {
		private JFrame frame;
		private JLabel headerLabel;
		private JLabel statusLabel;
		private JPanel controlPanel;
		public BorderLayoutExam2(){
			prepareGUI();
		}
	public static void main(String[] args) {
		BorderLayoutExam2 demo = new BorderLayoutExam2();
		demo.showBorderLayoutDemo();
	}
	private void prepareGUI() {
		frame = new JFrame();
		frame.setSize(400, 400);
		frame.setLayout(new GridLayout(3, 1));
		headerLabel = new JLabel("", JLabel.CENTER);
		statusLabel = new JLabel("", JLabel.CENTER);
		statusLabel.setSize(350, 100);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		frame.add(headerLabel);
		frame.add(controlPanel);
		frame.add(statusLabel);
		frame.setVisible(true);
		frame.setTitle("Ví dụ BorderLayout trong Java Swing");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	private void showBorderLayoutDemo() {
		headerLabel.setText("Layout in action: BorderLayout");
		JPanel panel = new JPanel();
		panel.setBackground(Color.darkGray);
		panel.setSize(300, 300);
		BorderLayout layout = new BorderLayout();
		layout.setHgap(10);
		layout.setVgap(10);
		panel.setLayout(layout);
		panel.add(new JButton("Center"), BorderLayout.CENTER);
		panel.add(new JButton("Line Start"), BorderLayout.LINE_START);
		panel.add(new JButton("Line End"), BorderLayout.LINE_END);
		panel.add(new JButton("East"), BorderLayout.EAST);
		panel.add(new JButton("West"), BorderLayout.WEST);
		panel.add(new JButton("North"), BorderLayout.NORTH);
		panel.add(new JButton("South"), BorderLayout.SOUTH);
		controlPanel.add(panel);
		frame.setVisible(true);
	}
}