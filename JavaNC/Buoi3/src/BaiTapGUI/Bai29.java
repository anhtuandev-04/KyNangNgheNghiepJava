package BaiTapGUI;

import java.awt.GridLayout; 
import java.io.FileInputStream; 
import java.util.Scanner; 
import javax.swing.*; 
import javax.swing.table.DefaultTableModel; 
public class Bai29  extends JFrame{
	private JTable table; 
	private DefaultTableModel dfmodel; 
	public Bai29() throws Exception{ 
	setTitle("Table&IO"); 
	setSize(600, 350); 
	setDefaultCloseOperation(EXIT_ON_CLOSE); 
	setResizable(false); 
	setLocationRelativeTo(null); 
	taobang(); 
	} 
	private void taobang() throws Exception{ 
	JPanel pnl=new JPanel(new GridLayout(1, 1)); 
	String [] headers={"Country", "Capital","Population", "Democracy"}; 
	pnl.add(new JScrollPane( 
	table=new JTable( 
	dfmodel=new DefaultTableModel(headers, 0)))); 
	add(pnl); 
	FileInputStream fis=new FileInputStream("src/BaiTapGUI/data6.txt"); 
	Scanner sc=new Scanner(fis); 
	while(sc.hasNextLine()){ 
	String line=sc.nextLine(); 
	String[] row=line.split(","); 
	dfmodel.addRow(row); 
	} 
	sc.close(); 
	} 
	public static void main(String[] args) throws Exception { 
	new Bai29().setVisible(true); 
	} 
}