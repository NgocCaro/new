/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import database.databaseUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.quanlyhoadon;

/**
 *
 * @author Admin
 */
public class HoaDonModify {
   
    private Connection conn;
    String ma="";
    public HoaDonModify(){
        try {
            String url="jdbc:mysql://localhost/minimarket";
            String user="root";
            String password="";
            conn=DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
        }
    }
    public int getmakh(String k){
        String sql="select ma_khach from khach_hang where sdt_khach='"+k+"'";
         try {
             PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                return rs.getInt("ma_khach");
            }
        } catch (Exception e) {
             System.out.println(" xin chao ;;"+e);
        }
          
         return 0;
    } 
    public void date(String k){
         ArrayList<quanlyhoadon> list=new ArrayList<>();
        Connection conn= null;
       Statement sttm= null;
       ResultSet rs=null;
        try {
           
            
        String sql="select * from hoa_don where ngay_tao ='"+k+"'";
        conn= databaseUtils.getDBConnect();
           sttm= conn.createStatement();
           rs= sttm.executeQuery(sql);
            
            while(rs.next()){
                quanlyhoadon s=new quanlyhoadon();
                s.setMahd(rs.getInt("ma_hd"));
                
                s.setDate_Buy(rs.getString("ngay_tao"));
               // s.setManv(rs.getInt("manv_hd"));
                s.setThanhTien(rs.getInt("thanh_toan"));
                 
               // s.setSdt(kh.getsl(rs.getInt("ma_khach")));
                list.add(s); 
            }
            System.out.println(list);
        } catch (Exception e) {
            System.out.println("loi gi k biet: "+e.toString());
        }
    }
    //Tim kiem hoa don theo ngay ở form doanh thu
    public ArrayList<quanlyhoadon> findbyDate(String Date){
       ArrayList<quanlyhoadon> list = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {

            String sql = "select ma_hd,ngay_tao,thanh_toan from hoa_don where ngay_tao like '%" + Date +"%'" ;
            conn = databaseUtils.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sql);

            while (rs.next()) {
                quanlyhoadon s = new quanlyhoadon();
                s.setMahd(rs.getInt(1));

                s.setDate_Buy(rs.getString(2));
                
                s.setThanhTien(rs.getInt(3));

                
                list.add(s);
            }
            System.out.println(list);
        } catch (Exception e) {
            System.out.println("fail: " + e.toString());
        }
        return list;
    }
    //Tim kiem hoa don theo tháng ở form doanh thu
    public ArrayList<quanlyhoadon> findbyMonth(String month){
       ArrayList<quanlyhoadon> list = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {

            String sql = "select ma_hd,ngay_tao,thanh_toan from hoa_don where ngay_tao like '%-" + month +"-%'" ;
            conn = databaseUtils.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sql);

            while (rs.next()) {
                quanlyhoadon s = new quanlyhoadon();
                s.setMahd(rs.getInt(1));

                s.setDate_Buy(rs.getString(2));
                
                s.setThanhTien(rs.getInt(3));

                
                list.add(s);
            }
            System.out.println(list);
        } catch (Exception e) {
            System.out.println("fail: " + e.toString());
        }
        return list;
    }
//Tim kiem hoa don theo ngay mà hd chua có sdt (ở form tìm kiếm hóa đơn)
    public ArrayList<quanlyhoadon> findbyDate2(String Date){
       ArrayList<quanlyhoadon> list = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {

            String sql = "select hoa_don.ma_hd,nhanvien.ten_nv,hoa_don.ngay_tao,hoa_don.thanh_toan FROM hoa_don,nhanvien WHERE hoa_don.manv_hd=nhanvien.ma_nv AND ma_khach IS NULL AND ngay_tao like '%" + Date +"%'" ;
            conn = databaseUtils.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sql);
            
            while (rs.next()) {
                quanlyhoadon s = new quanlyhoadon();
                s.setMahd(rs.getInt(1));
               
                s.setTennv(rs.getString(2));
                s.setDate_Buy(rs.getString(3));
                s.setThanhTien(rs.getInt(4));
                list.add(s);
            }
            System.out.println(list);
        } catch (Exception e) {
            System.out.println("fail: " + e.toString());
        }
        return list;
    }    
    //Tim kiem hoa don theo ngay mà hóa đơn có  sdt (ở form tìm kiếm hóa đơn)
    public ArrayList<quanlyhoadon> findbyDate3(String Date){
       ArrayList<quanlyhoadon> list = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {

            String sql = "select hoa_don.ma_hd,khach_hang.sdt_khach,nhanvien.ten_nv,hoa_don.ngay_tao,hoa_don.thanh_toan FROM hoa_don,khach_hang,nhanvien WHERE hoa_don.ma_khach=khach_hang.ma_khach AND hoa_don.manv_hd=nhanvien.ma_nv AND ngay_tao like '%" + Date +"%'" ;
            conn = databaseUtils.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sql);
            
            while (rs.next()) {
                quanlyhoadon s = new quanlyhoadon();
                s.setMahd(rs.getInt(1));
               s.setSdt(rs.getString(2));
                s.setTennv(rs.getString(3));
                s.setDate_Buy(rs.getString(4));
                s.setThanhTien(rs.getInt(5));
                list.add(s);
            }
            System.out.println(list);
        } catch (Exception e) {
            System.out.println("fail: " + e.toString());
        }
        return list;
    }
//Tim kiem hoa don theo sdt khách
    public ArrayList<quanlyhoadon> findbySDT(String sdt){
       ArrayList<quanlyhoadon> list = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {

            String sql = "SELECT hoa_don.ma_hd,khach_hang.sdt_khach,nhanvien.ten_nv,hoa_don.ngay_tao,hoa_don.thanh_toan FROM hoa_don,khach_hang,nhanvien WHERE hoa_don.ma_khach=khach_hang.ma_khach AND hoa_don.manv_hd=nhanvien.ma_nv AND sdt_khach="+sdt;
            conn = databaseUtils.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sql);
            
            while (rs.next()) {
                quanlyhoadon s = new quanlyhoadon();
                s.setMahd(rs.getInt(1));
                s.setSdt(rs.getString(2));
                s.setTennv(rs.getString(3));
                s.setDate_Buy(rs.getString(4));
                s.setThanhTien(rs.getInt(5));
                list.add(s);
            }
            System.out.println(list);
        } catch (Exception e) {
            System.out.println("fail: " + e.toString());
        }
        return list;
    }
// tìm kiếm hóa đơn theo tên nhân viên khi trong hóa đơn có sdt
    public ArrayList<quanlyhoadon> findbyName1(String ten){
       ArrayList<quanlyhoadon> list = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {

            String sql = "SELECT hoa_don.ma_hd,khach_hang.sdt_khach,nhanvien.ten_nv,hoa_don.ngay_tao,hoa_don.thanh_toan FROM hoa_don,khach_hang,nhanvien WHERE hoa_don.ma_khach=khach_hang.ma_khach AND hoa_don.manv_hd=nhanvien.ma_nv AND ten_nv='"+ten+"'";
            conn = databaseUtils.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sql);
            
            while (rs.next()) {
                quanlyhoadon s = new quanlyhoadon();
                s.setMahd(rs.getInt(1));
                s.setSdt(rs.getString(2));
                s.setTennv(rs.getString(3));
                s.setDate_Buy(rs.getString(4));
                s.setThanhTien(rs.getInt(5));
                list.add(s);
            }
            System.out.println(list);
        } catch (Exception e) {
            System.out.println("fail: " + e.toString());
        }
        return list;
    }
    // tìm kiếm hóa đơn theo tên nhân viên khi trong hóa đơn k có sdt
    public ArrayList<quanlyhoadon> findbyName2(String ten){
       ArrayList<quanlyhoadon> list = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {

            String sql = "SELECT hoa_don.ma_hd,nhanvien.ten_nv,hoa_don.ngay_tao,hoa_don.thanh_toan FROM hoa_don,nhanvien WHERE hoa_don.ma_khach IS NULL AND hoa_don.manv_hd=nhanvien.ma_nv AND ten_nv='"+ten+"'";
            conn = databaseUtils.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sql);
            
            while (rs.next()) {
                quanlyhoadon s = new quanlyhoadon();
                s.setMahd(rs.getInt(1));
                //s.setSdt(rs.getString(2));
                s.setTennv(rs.getString(2));
                s.setDate_Buy(rs.getString(3));
                s.setThanhTien(rs.getInt(4));
                list.add(s);
            }
            System.out.println(list);
        } catch (Exception e) {
            System.out.println("fail: " + e.toString());
        }
        return list;
    }
  // lấy ra toàn bộ hóa đơn  
    public ArrayList<quanlyhoadon> getListHD(){     
    ArrayList<quanlyhoadon> list=new ArrayList<>();
      Connection conn= null;
       Statement sttm= null;
       ResultSet rs=null;
     CustomerModify kh = new CustomerModify();
        try {    
        String sql="SELECT hoa_don.ma_hd,nhanvien.ten_nv,hoa_don.ma_khach,hoa_don.ngay_tao,hoa_don.thanh_toan FROM hoa_don,nhanvien WHERE hoa_don.manv_hd=nhanvien.ma_nv";
        conn= databaseUtils.getDBConnect();
           sttm= conn.createStatement();
           rs= sttm.executeQuery(sql);
            
            while(rs.next()){
                quanlyhoadon s=new quanlyhoadon();
                s.setMahd(rs.getInt("ma_hd"));
                
                s.setSdt(kh.getsl(rs.getInt("ma_khach")));
                s.setTennv(rs.getString("ten_nv"));
                s.setDate_Buy(rs.getString("ngay_tao"));
                
                s.setThanhTien(rs.getInt("thanh_toan"));
                 
                
                list.add(s);
            }
        } catch (Exception e) {
            System.out.println("loi gi k biet: "+e.toString());
        }
        return list;
    }
   /* public ArrayList<quanlyhoadon> getListHD(){
    
           
    ArrayList<quanlyhoadon> list=new ArrayList<>();
      Connection conn= null;
       Statement sttm= null;
       ResultSet rs=null;
     
        try {
           
            
        String sql="select hoa_don.ma_hd, hoa_don.ngay_tao, hoa_don.manv_hd, hoa_don.thanh_toan, khach_hang.sdt_khach from hoa_don, khach_hang where hoa_don.ma_khach=khach_hang.ma_khach";
        conn= databaseUtils.getDBConnect();
           sttm= conn.createStatement();
           rs= sttm.executeQuery(sql);
            
            while(rs.next()){
                quanlyhoadon s=new quanlyhoadon();
                s.setMahd(rs.getInt("ma_hd"));
                
                s.setDate_Buy(rs.getString("ngay_tao"));
                s.setManv(rs.getInt("manv_hd"));
                s.setThanhTien(rs.getInt("thanh_toan"));
                s.setSdt(rs.getInt("sdt_khach"));
                list.add(s);
            }
        } catch (Exception e) {
            System.out.println("loi gi k biet: "+e.toString());
        }
        return list;
    }*/
    public int getmahd(){
         String sql="select ma_hd from hoa_don where ngay_tao='"+ma+"'";
         try {
             PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                return rs.getInt("ma_hd");
            }
        } catch (Exception e) {
        }
          
         return 0;
    }
    public int AddHD(quanlyhoadon hd){
         CustomerModify cr= new CustomerModify();
        try {
            String sql="insert hoa_don(ngay_tao,thanh_toan,manv_hd,ma_khach) values(?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, hd.getDate_Buy());
            ps.setInt(2, hd.getThanhTien());
            ps.setInt(3, hd.getManv());
             
            ps.setInt(4, getmakh(hd.getSdt()));
            System.out.println("adas: "+getmakh(hd.getSdt()));
            ma= hd.getDate_Buy();
             if(ps.executeUpdate()>0){
               System.out.println(ma);
                 
               return 1;
           }
        } catch (Exception e) {
            System.out.println("loi ne---------"+ e);
        }
        
       return -1; 
       
    }
    public int Addhdno(quanlyhoadon hd){
         
        try {
            String sql="insert hoa_don(ngay_tao,thanh_toan,manv_hd) values(?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, hd.getDate_Buy());
            ps.setInt(2, hd.getThanhTien());
            ps.setInt(3, hd.getManv());
            
            ma= hd.getDate_Buy();
             if(ps.executeUpdate()>0){
              System.out.println("tinh yeu mau nang: "+hd.getManv()+"d "+hd.getThanhTien());
            
                 System.out.println("da in duoc dau");
               return 1;
           }
        } catch (Exception e) {
            System.out.println("loi ne 2"+ e);
        }
        
       return -1; 
       
    }
     public void DeleteHD(int id ){
        String sql="delete from hoa_don where ma_hd=?";
        try {
            PreparedStatement ps=conn.prepareCall(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        HoaDonModify d= new HoaDonModify();
       d.date("2021/12/7");
    }
    
}