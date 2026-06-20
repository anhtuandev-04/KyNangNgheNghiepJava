//Trương Anh Tuấn 220616
package BT_139_174;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

	public class GridLayoutExam1 {
		JFrame frame;
		GridLayoutExam1() {
			frame = new JFrame();
			JButton b1 = new JButton("1");
			JButton b2 = new JButton("2");
			JButton b3 = new JButton("3");
			JButton b4 = new JButton("4");
			JButton b5 = new JButton("5");
			JButton b6 = new JButton("6");
			JButton b7 = new JButton("7");
			JButton b8 = new JButton("8");
			JButton b9 = new JButton("9");
			frame.add(b1);
			frame.add(b2);
			frame.add(b3);
			frame.add(b4);
			frame.add(b5);
			frame.add(b6);
			frame.add(b7);
			frame.add(b8);
			frame.add(b9);
	// thiet lap 3 hang va 3 cot cho grid layout
			frame.setLayout(new GridLayout(3, 3));
			frame.setSize(400, 400);
			frame.setVisible(true);
			frame.setTitle("Ví dụ GridLayout trong Java Swing");
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		}
		public static void main(String[] args) {
			new GridLayoutExam1();
		}
	}