package BaiTapGUI;

import java.awt.*; 
import java.io.*; 
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*; 
public class Bai28 extends JFrame implements ActionListener, MouseListener{
	private static final long serialVersionUID = 1L; 
	 private JTextField tfMaso; 
	 private JComboBox<String> cboMalop; 
	 private JTextField tfDiemLT; 
	 private JTextField tfDiemTH; 
	 private JTextField tfDiemTB; 
	 private JTextField tfKQ; 
	 private JButton bttKQ; 
	 private JButton bttThem; 
	 private DefaultTableModel dfModel; 
	 private JTable table; 
	 private JTextField tfHoTen; 
	 private DanhSachSinhVien ds; 
	 private JButton bttClear; 
	 private JButton bttLuu; 
	 private JButton bttXoa; 
	 private JButton bttSua; 
	 private JButton bttTim; 
	 private final String FILENAME="DATA_SINHVIEN.DAT"; 
	 
	 public Bai28() { 
		  setTitle("Chương trình quản lý sinh viên"); 
		  setSize(1000, 600); 
		  setDefaultCloseOperation(EXIT_ON_CLOSE); 
		  setLocationRelativeTo(null); 
		  buildGUI(); 
		  napDanhSachSinhVien(FILENAME); 
		 } 
		 
		 private void napDanhSachSinhVien(String file) { 
		  if(new File(file).exists())//Nếu tồn tại file chứa danh sách sinh viên 
		  { 
		    
		   try{ 
		    FileInputStream in=new FileInputStream(FILENAME); 
		    ObjectInputStream oos=new ObjectInputStream(in); 
		    ds=(DanhSachSinhVien)oos.readObject();  
		       //Đọc từ file và gán vào danh sách 
		    napVaoBang(); 
		    oos.close(); 
		   }catch(Exception ex){ 
		    JOptionPane.showMessageDialog(null, "IO Error!"); 
		    return; 
		   } 
		  } 
		  else 
		   ds=new DanhSachSinhVien(); 
		 } 
		 
		 private void napVaoBang() { 
		  dfModel.setRowCount(0); 
		  for (int i = 0; i < ds.tongSinhVien(); i++) { 
		   SinhVien sv=ds.getSinhVien(i); 
		   String[] dataRow={sv.getMasv(),sv.getHoten(), 
		     sv.getMalop(), 
		     sv.getDiemLT()+"",sv.getDiemTH()+"", 
		     sv.diemTB()+"",sv.ketQua()}; 
		   dfModel.addRow(dataRow); 
		  } 
		 } 
		 
		 private void buildGUI() { 
		  JPanel pnlLeft=new JPanel(new GridLayout(0,1)); 
		 
		  pnlLeft.add(new JLabel("THÔNG TIN SINH VIÊN", JLabel.CENTER)); 
		 
		  pnlLeft.add(new JLabel("Mã sinh viên: ")); 
		  pnlLeft.add(tfMaso=new JTextField(20)); 
		 
		  pnlLeft.add(new JLabel("Họ và Tên")); 
		  pnlLeft.add(tfHoTen=new JTextField(20)); 
		 
		  pnlLeft.add(new JLabel("Mã lớp")); 
		  pnlLeft.add(cboMalop=new JComboBox<String>()); 
		  String[] dslop={"DHTHA","DHTHB","DHTHC","DHTHD","DHTHK"}; 
		  for (int i = 0; i < dslop.length; i++) { 
		   cboMalop.addItem(dslop[i]); 
		  } 
		 
		  pnlLeft.add(new JLabel("Điểm lý thuyết ")); 
		  pnlLeft.add(tfDiemLT=new JTextField(20)); 
		 
		  pnlLeft.add(new JLabel("Điểm thực hành ")); 
		  pnlLeft.add(tfDiemTH=new JTextField(20)); 
		 
		  pnlLeft.add(new JLabel("Điểm trung bình ")); 
		  pnlLeft.add(tfDiemTB=new JTextField(20)); 
		  tfDiemTB.setEditable(false); 
		 
		  pnlLeft.add(new JLabel("Kết quả ")); 
		  pnlLeft.add(tfKQ=new JTextField(20)); 
		  tfKQ.setEditable(false); 
		 
		  JPanel pnlLeftBottom; 
		  pnlLeft.add(pnlLeftBottom=new JPanel()); 
		  pnlLeftBottom.add(bttKQ=new JButton("Kết quả")); 
		  pnlLeftBottom.add(bttThem=new JButton("Thêm")); 
		  pnlLeftBottom.add(bttClear=new JButton("Clear")); 
		 
		  JPanel pnlLeftBottom2; 
		  pnlLeft.add(pnlLeftBottom2=new JPanel()); 
		  pnlLeftBottom2.add(bttLuu=new JButton("Lưu")); 
		  pnlLeftBottom2.add(bttXoa=new JButton("Xóa")); 
		  pnlLeftBottom2.add(bttSua=new JButton("Sửa")); 
		  pnlLeftBottom2.add(bttTim=new JButton("Tìm")); 
		 
		  JPanel pnlRight=new JPanel(new GridLayout(1,1)); 
		  String[] headers={"Mã SV","Họ tên","Lớp","Lý thuyết", 
		    "Thực hành","Trung bình","Kết quả"}; 
		  pnlRight.add(new JScrollPane(table=new JTable( 
		    dfModel=new DefaultTableModel(headers,0)))); 
		 
		  add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnlLeft,pnlRight)); 
		 
		  bttClear.addActionListener(this); 
		  bttKQ.addActionListener(this); 
		  bttThem.addActionListener(this); 
		  bttLuu.addActionListener(this); 
		  bttSua.addActionListener(this); 
		  bttTim.addActionListener(this); 
		  bttXoa.addActionListener(this); 
		 
		  table.addMouseListener(this); 
		 } 
		 public static void main(String[] args) { 
		  new Bai28().setVisible(true); 
		 } 
		 
		 @Override 
		 public void mouseClicked(MouseEvent e) { 
		 
		  int vitri=table.getSelectedRow();//Lấy vị trí được chọn trong table 
		  SinhVien sv=ds.getSinhVien(vitri); 
		   //Lấy thông tin sinh viên tại vitri trong danh sách SV 
		 
		  //Nạp thông tin của sinh viên vào các components tương ứng 
		  napLaiThongTin(sv); 
		 } 
		 private void napLaiThongTin(SinhVien sv) { 
		  tfMaso.setText(sv.getMasv()); 
		  tfHoTen.setText(sv.getHoten()); 
		  cboMalop.setSelectedItem(sv.getMalop()); 
		  tfDiemLT.setText(sv.getDiemLT()+""); 
		  tfDiemTH.setText(sv.getDiemTH()+""); 
		  tfDiemTB.setText(sv.diemTB()+""); 
		  tfKQ.setText(sv.ketQua()); 
		  tfMaso.requestFocus(); 
		 } 
		 
		 @Override 
		 public void mousePressed(MouseEvent e) { 
		 } 
		 @Override 
		 public void mouseReleased(MouseEvent e) { 
		 } 
		 @Override 
		 public void mouseEntered(MouseEvent e) { 
		 } 
		 @Override 
		 public void mouseExited(MouseEvent e) { 
		 } 
		 
		 @Override 
		 public void actionPerformed(ActionEvent e){ 
		  if(e.getSource().equals(bttSua)){ 
		   try{ 
		    SinhVien svVersion2=new SinhVien(tfMaso.getText(),  
		      tfHoTen.getText(),  
		      cboMalop.getSelectedItem().toString(), 
		      Double.parseDouble(tfDiemLT.getText()), 
		      Double.parseDouble(tfDiemTH.getText()));
		  
		    if(!ds.suaThongTinSinhVien(tfMaso.getText(), svVersion2)) 
		    { 
		     JOptionPane.showMessageDialog(null,  
		      "Không tồn tại sinh viên có mã số : "+ 
		      tfMaso.getText()); 
		     return; 
		    }else 
		     napVaoBang(); 
		   }catch(Exception ex){ 
		    JOptionPane.showMessageDialog(null, "Lỗi"); 
		    return; 
		   } 
		  }else if(e.getSource().equals(bttTim)){ 
		   try{ 
		    String masv=JOptionPane.showInputDialog( 
		       "Nhập mã số sinh viên cần tìm: "); 
		    if(masv!=null && masv.trim().equals("")){ 
		     SinhVien sv=ds.timKiem(masv); 
		     if(sv!=null) 
		      napLaiThongTin(sv); 
		     else 
		     { 
		      JOptionPane.showMessageDialog(null,  
		      "Không tồn tại sinh viên có mã số : "+masv); 
		      return; 
		     } 
		    } 
		   }catch(Exception ex){ 
		    JOptionPane.showMessageDialog(null, "Lỗi"); 
		    return; 
		   } 
		  }else if(e.getSource().equals(bttXoa)){ 
		   try{ 
		    String masv=JOptionPane.showInputDialog( 
		       "Nhập mã số sinh viên cần xóa: "); 
		    if(masv!=null && masv.trim().equals("")){ 
		     SinhVien sv=ds.timKiem(masv); 
		     if(sv!=null){ 
		      if(JOptionPane.showConfirmDialog(null,  
		       "Có chắn chắn muốn xóa không? ", 
		       "Thông báo", 
		       JOptionPane.YES_NO_OPTION)== 
		         JOptionPane.YES_OPTION){ 
		       ds.xoaSinhVien(masv); 
		       napVaoBang(); 
		      } 
		     } 
		     else{ 
		      JOptionPane.showMessageDialog(null,  
		       "Không tồn tại mã sinh viên "+masv); 
		      return; 
		     } 
		    } 
		   }catch(Exception ex){ 
		    JOptionPane.showMessageDialog(null, "Lỗi"); 
		    return; 
		   } 
		  }else if(e.getSource().equals(bttLuu)){ 
		   try{ 
		    FileOutputStream out=new FileOutputStream(FILENAME); 
		    ObjectOutputStream oos=new ObjectOutputStream(out); 
		    oos.writeObject(ds); 
		    oos.close(); 
		   }catch(Exception ex){ 
		    JOptionPane.showMessageDialog(null, "IO Error!"); 
		    return; 
		   } 
		  } 
		  else if(e.getSource().equals(bttClear)){ 
		   tfMaso.setText(""); 
		   tfHoTen.setText(""); 
		   tfDiemLT.setText(""); 
		   tfDiemTB.setText(""); 
		   tfDiemTH.setText(""); 
		   tfKQ.setText(""); 
		   tfMaso.requestFocus(); 
		 
		  } else{ 
		   String masv="", hoten="",malop=""; 
		   double diemLT=0.0, diemTH=0.0; 
		   SinhVien sv=null; 
		 
		   try{ 
		    masv=tfMaso.getText(); 
		    hoten=tfHoTen.getText(); 
		    malop=cboMalop.getSelectedItem().toString(); 
		    diemLT=Double.parseDouble(tfDiemLT.getText()); 
		    diemTH=Double.parseDouble(tfDiemTH.getText()); 
		    sv=new SinhVien(masv, hoten, malop, diemLT, diemTH); 
		   }catch(Exception ex){ 
		    JOptionPane.showMessageDialog(null, "Lỗi! "+ex.getMessage()); 
		    return; 
		   } 
		   if(e.getSource().equals(bttThem)){ 
		    if(!ds.themsinhvien(sv)) 
		    { 
		     JOptionPane.showMessageDialog(null, "Trùng mã số"); 
		     return; 
		    } 
		    String[] dataRow={sv.getMasv(), 
		      sv.getHoten(),sv.getMalop(), 
		      Double.toString(sv.getDiemLT()), 
		      sv.getDiemTH()+"", 
		      sv.diemTB()+"", 
		      sv.ketQua()}; 
		    dfModel.addRow(dataRow); 
		   }else if(e.getSource().equals(bttKQ)){ 
		    tfDiemTB.setText(sv.diemTB()+""); 
		    tfKQ.setText(sv.ketQua()); 
		   } 
		  } 
		 } 
}