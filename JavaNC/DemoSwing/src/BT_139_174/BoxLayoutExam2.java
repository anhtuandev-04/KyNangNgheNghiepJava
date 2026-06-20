//Trương Anh Tuấn 220616
package BT_139_174;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BoxLayout;

	public class BoxLayoutExam2 extends Frame {
		Button buttons[];
		public BoxLayoutExam2() {
			buttons = new Button[5];
			for (int i = 0; i < 5; i++) {
				buttons[i] = new Button("Button " + (i + 1));
				add(buttons[i]);
			}
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setSize(400, 400);
			setVisible(true);
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent we) {
					System.exit(0);
				}
			});
		}
		public static void main(String args[]) {
			BoxLayoutExam2 boxLayout = new BoxLayoutExam2();
		}
}