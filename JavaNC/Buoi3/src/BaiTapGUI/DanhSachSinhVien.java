package BaiTapGUI;

import java.io.Serializable; 
import java.util.ArrayList; 
import java.util.List;
public class DanhSachSinhVien implements Serializable{ 
	 private List<SinhVien> ds; 
	 
	 // Khởi tạo danh sách sinh viên 
	 public DanhSachSinhVien() { 
	  ds=new ArrayList<SinhVien>(); 
	 } 
	 
	 /*Thêm sinh viên vào danh sách. 
	  *@param: sv là sinh viên cần thêm 
	  *@return true nếu thêm thành công 
	  *@return false nếu bị trùng mã số sinh viên   
	  */ 
	 public boolean themsinhvien(SinhVien sv) { 
	  if (ds.contains(sv)) { 
	   return false; 
	  } 
	  ds.add(sv); 
	  return true; 
	 }
	 /*Lấy thông tin sinh viên tại vị trí i trong danh sách 
	  *@param: i là thứ tự sinh viên trong danh sách 
	  *@return null nếu vị trí i không hợp lệ 
	  *@return 1 sinh viên trong trường hợp ngược lại 
	  */
	 public SinhVien getSinhVien(int i) { 
		  if(i>=0 && i<ds.size()) 
		   return ds.get(i); 
		  return null; 
		 } 
		 
		 //Tổng số sinh viên có trong danh sách 
		 public int tongSinhVien() { 
		  return ds.size(); 
		 } 
		 
		 /* Tìm kiếm sinh viên khi biết mã số sinh viên 
		  * @param: masv là mã số sinh viên cần tìm 
		  * @return sinh viên nếu tìm thấy 
		  * @return null null nếu không tìm thấy 
		  */  
		 public SinhVien timKiem(String masv) throws Exception { 
		  SinhVien sv=new SinhVien(masv); 
		  if(ds.contains(sv)) 
		   return ds.get(ds.indexOf(sv)); 
		  return null; 
		 } 
		 /* Xóa một sinh viên khi biết mã số sinh viên 
		  * @param: masv là mã số sinh viên cần xóa 
		  * @return true nếu tồn tại sinh viên này 
		  * @return false nếu ngược lại  
		  */ 
		 public boolean xoaSinhVien(String masv) throws Exception{ 
		  SinhVien sv=new SinhVien(masv); 
		  if(ds.contains(sv)) 
		  { 
		   ds.remove(sv); 
		   return true; 
		  } 
		  return false; 
		 } 
		  
		 /* 
		  * Sửa thông tin sinh viên 
		  * @param: masv là mã số sinh viên cần sửa thông tin 
		  * @svVersion2 là thông tin mới của sinh viên này 
		  * @return false nếu không tồn tại sinh viên có masv 
		  *  
		  */ 
		 public boolean suaThongTinSinhVien(String masv,  
			      SinhVien svVersion2) throws Exception{ 
			  SinhVien sv=new SinhVien(masv); 
			  if(ds.contains(sv)){ 
			   sv=ds.get(ds.indexOf(sv)); 
			   sv.setHoten(svVersion2.getHoten()); 
			   sv.setDiemLT(svVersion2.getDiemLT()); 
			   sv.setDiemTH(svVersion2.getDiemTH()); 
			   return true; 
			  } 
			  return false; 
			 } 
}