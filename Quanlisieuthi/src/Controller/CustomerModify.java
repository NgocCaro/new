/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import database.databaseUtils;
import model.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Customer;

/**
 *
 * @author Admin
 */
public class CustomerModify {
     
    // thêm mới
    public int add(Customer pr){
        Connection conn=null;
       PreparedStatement sttm =null;
        try {
           String query="insert khach_hang(ten_khach,sdt_khach,diem) values(?,?,?)";
           conn= databaseUtils.getDBConnect();
            sttm=conn.prepareStatement(query);
            sttm.setString(1,pr.getTen_khach());
            sttm.setString(2, pr.getSdt_khach());
            
            sttm.setInt(3, 0);
            if(sttm.executeUpdate()>0)
            {
                System.out.println("Thêm mới thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }finally{
            try {
                conn.close();
                sttm.close();
                       
            } catch (Exception e) {
            }
        }
        return -1;   //nếu thêm k thành công
    }
    public String getsl(int makh){
         Connection conn=null;
       PreparedStatement ps =null;
          
         try {
             String sql="select sdt_khach from khach_hang where ma_khach='"+makh+"'";
             conn= databaseUtils.getDBConnect();
              ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                return rs.getString("sdt_khach");
            }
        } catch (Exception e) {
             System.out.println("nhoc 1: "+e);
        }
          
         return "";
     }
    //  sửa
     public int update(Customer pr){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
           String query="update khach_hang set ten_khach=?,sdt_khach=? where ma_khach=?";
           conn= databaseUtils.getDBConnect();
            sttm=conn.prepareStatement(query);
            sttm.setString(1,pr.getTen_khach());
            sttm.setString(2, pr.getSdt_khach());
            sttm.setInt(3, pr.getMa_khach());
            if(sttm.executeUpdate()>0)
            {
                System.out.println("sửa thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.toString());
        }finally{
            try {
                conn.close();
                sttm.close();
                       
            } catch (Exception e) {
            }
        }
        return -1;   
    }
     //xóa theo id
     public int delete(int ma_khach){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
           String query="delete from khach_hang where ma_khach = ?";
          conn= databaseUtils.getDBConnect();
           sttm=conn.prepareStatement(query);
            sttm.setInt(1,ma_khach);
            
            if(sttm.executeUpdate()>0)
            {
                System.out.println("Xóa thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }
        return -1;   
    }
      
      public void congdiem(int k, int mak){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
           String query="update khach_hang set diem=? where ma_khach=?";
           conn= databaseUtils.getDBConnect();
            sttm=conn.prepareStatement(query);
           
            sttm.setInt(1, k);
            sttm.setInt(2, mak);
            if(sttm.executeUpdate()>0)
            {
                System.out.println("sửa thành công");
                
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.toString());
        }finally{
            try {
                conn.close();
                sttm.close();
                       
            } catch (Exception e) {
                 System.out.println("co bien "+e);
            }
        }
         
    }
     //xóa theo id
   public void congcdiem(int k){
       Connection conn=null;
       PreparedStatement sttm =null;

         try {
             String sql="update khach_hang set diem=? where ma_khach=?";
             conn= databaseUtils.getDBConnect();
             sttm= conn.prepareStatement(sql);
              
              sttm.setInt(1, k);
             
            if(sttm.executeUpdate()>0)
            {
                System.out.println("cong diem thành công");
                
            }
        } catch (Exception e) {
             System.out.println("co bien "+e);
        }
              
   }
     public int getdiem(int ma_khach){
          Connection conn=null;
       PreparedStatement sttm =null;
       
         
         try {
             String sql="select diem from khach_hang where ma_khach='"+ma_khach+"'";
             conn= databaseUtils.getDBConnect();
             sttm= conn.prepareStatement(sql);
              
            ResultSet rs=sttm.executeQuery();
            if(rs.next()){
                return rs.getInt("diem");
            }
        } catch (Exception e) {
        }
          
         return 0;
     }
     //show tất cả
     public List<Customer> getAllCustomer(){
         List<Customer>ls=new ArrayList<>();
        Connection conn=null;
        Statement sttm=null;
        try {
            String query="select ma_khach,ten_khach,sdt_khach from khach_hang";
           conn= databaseUtils.getDBConnect();
            sttm=conn.createStatement();
            ResultSet rs=sttm.executeQuery(query);
            while(rs.next()){
                Customer pr=new Customer();
                pr.setMa_khach(rs.getInt(1));
                pr.setTen_khach(rs.getString(2));
                pr.setSdt_khach(rs.getString(3));
                ls.add(pr);                  
            }
        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }finally{
            try {
                sttm.close();conn.close();
            } catch (Exception e) {
            }
        }
         return ls;
     }
     // tìm theo id 
     public Customer getCustomerById(int ma_khach) {
         Customer pr=new Customer();
         Connection conn = null;
        PreparedStatement sttm = null;
         try {
             String query="select ma_khach,ten_khach,sdt_khach from khach_hang where ma_khach=?";
             conn= databaseUtils.getDBConnect();
           sttm=conn.prepareStatement(query); 
            sttm.setInt(1,ma_khach);
            ResultSet rs=sttm.executeQuery();
            while(rs.next()){
                pr.setMa_khach(rs.getInt(1));
                pr.setTen_khach(rs.getString(2));
                pr.setSdt_khach(rs.getString(3));
                return pr;
            }
                
         } catch (Exception e) {
                 System.out.println("Error"+e.toString());      
         }finally{
            try {
                sttm.close();
                conn.close();
            } catch (Exception e) {
            }
         }
         return null;
     }
     // tìm kiếm theo sdt
     public Customer getCustomerByName(String sdt) {
         Customer pr=new Customer();
         Connection conn = null;
        PreparedStatement sttm = null;
         try {
             String query="select ma_khach,ten_khach,sdt_khach from khach_hang where sdt_khach=?";
             conn= databaseUtils.getDBConnect();
           sttm=conn.prepareStatement(query); 
            sttm.setString(1,sdt);
            ResultSet rs=sttm.executeQuery();
            while(rs.next()){
                pr.setMa_khach(rs.getInt(1));
                pr.setTen_khach(rs.getString(2));
                pr.setSdt_khach(rs.getString(3));
                return pr;
            }
                
         } catch (Exception e) {
                 System.out.println("Error"+e.toString());      
         }finally{
            try {
                sttm.close();
                conn.close();
            } catch (Exception e) {
            }
         }
         return null;// nếu k tìm thấy thì trả về null
     }
     public static void main(String[] args) {
        int h= (int) Math.ceil(21000/10000);
        System.out.println("chao nha: "+  h);
    }
}
