/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import database.databaseUtils;
import model.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Product;
import model.loai_hang;

/**
 *
 * @author Admin
 */
public class ProductModify {
       public int delete(int ma_hang){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
           String query="delete from hang_hoa where ma_hang = ?";
           conn=DriverManager.getConnection("jdbc:mysql://localhost/minimarket", "root", "");
           sttm=conn.prepareStatement(query);
            sttm.setInt(1,ma_hang);
            
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
      public int addloai(String k){
        Connection conn=null;
        PreparedStatement sttm=null;
        try {
           String query="insert phan_loai(ten_loai) values(?)";
            conn=DriverManager.getConnection("jdbc:mysql://localhost/minimarket", "root", "");
            sttm=conn.prepareStatement(query);
            sttm.setString(1,k);
  
            if(sttm.executeUpdate()>0)
            {
                System.out.println("Thêm mới thành công");
                JOptionPane.showMessageDialog(null, "Thêm mới thành công");
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
     
    
     public int getmaloai(String tenloai){
        Connection conn=null;
       PreparedStatement ps =null;
          
         try {
             String sql="select id from phan_loai where ten_loai='"+tenloai+"'";
             conn= databaseUtils.getDBConnect();
              ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                return rs.getInt("id");
            }
        } catch (Exception e) {
        } 
         return 0;
    }
      public String gettenloai(int maloai){
        Connection conn=null;
       PreparedStatement ps =null;
          
         try {
             String sql="select ten_loai from phan_loai where id='"+maloai+"'";
             conn= databaseUtils.getDBConnect();
              ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                return rs.getString("ten_loai");
            }
        } catch (Exception e) {
        } 
         return "";
    }
      public int uploai(int maloai, String k){
         Connection conn = null;
        PreparedStatement sttm = null;
         try {
              String query="update phan_loai set ten_loai=? where id=?";
             conn=DriverManager.getConnection("jdbc:mysql://localhost/minimarket", "root", "");
             sttm=conn.prepareStatement(query);
             sttm.setString(1, k);
             
               sttm.setInt(2,maloai);
                if(sttm.executeUpdate()>0)
                    {
                        System.out.println("sửa thành công");
                         JOptionPane.showMessageDialog(null, "Sửa thành công");
                        return 1;
                    }
         } catch (Exception e) {
             System.out.println("nhoc 2: "+e);
         }
         return -1;
     }
     
     public List<loai_hang> getloaihang(){
         List<loai_hang>ls=new ArrayList<>();
        Connection conn=null;
        Statement sttm=null;
         try {
            String sql="select ten_loai from phan_loai";
             conn = DriverManager.getConnection("jdbc:mysql://localhost/minimarket", "root", "");
            sttm=conn.createStatement();
            ResultSet rs=sttm.executeQuery(sql);
            while(rs.next()){
                loai_hang loai= new loai_hang();
                 loai.setLoaihang(rs.getString("ten_loai"));
               
                ls.add(loai);                  
            }
             System.out.println(ls);
            return ls;
         } catch (Exception e) {
             System.out.println(e);
         }
         return ls;
     }
     //show tất cả
     
   
     public int add(Product pr){
        Connection conn=null;
        PreparedStatement sttm=null;
        try {
           String query="insert hang_hoa(ten_hang,gia_ban,so_luong,id) values(?,?,?,?)";
            conn=DriverManager.getConnection("jdbc:mysql://localhost/minimarket", "root", "");
            sttm=conn.prepareStatement(query);
            sttm.setString(1,pr.getTen_sp());
 
            sttm.setInt(2, pr.getGia_ban());
            sttm.setInt(3, pr.getSo_luong());
            sttm.setInt(4, pr.getMaloai());
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
     
     public int getsl(int masp){
         Connection conn=null;
       PreparedStatement ps =null;
          
         try {
             String sql="select so_luong from hang_hoa where ma_hang='"+masp+"'";
             conn= databaseUtils.getDBConnect();
              ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                return rs.getInt("so_luong");
            }
        } catch (Exception e) {
             System.out.println("nhoc 1: "+e);
        }
          
         return 0;
     }
      public int getmasp1(int masp){
         Connection conn=null;
       PreparedStatement ps =null;
          
         try {
             String sql="select * from hang_hoa where ma_hang='"+masp+"'";
             conn= databaseUtils.getDBConnect();
              ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                return 1;
            }
        } catch (Exception e) {
             System.out.println("nhoc 1: "+e);
        }
          
         return 0;
     }
     public int trusl(int masp,int k){
         Connection conn = null;
        PreparedStatement sttm = null;
         try {
              String query="update hang_hoa set so_luong=? where ma_hang=?";
             conn=DriverManager.getConnection("jdbc:mysql://localhost/minimarket", "root", "");
             sttm=conn.prepareStatement(query);
              sttm.setInt(1, k);
               sttm.setInt(2,masp);
                if(sttm.executeUpdate()>0)
                    {
                        System.out.println("sửa thành công");
                        return 1;
                    }
         } catch (Exception e) {
             System.out.println("nhoc 2: "+e);
         }
         return -1;
     }
     public int upsl(int masp,int sl){
         Connection conn = null;
        PreparedStatement sttm = null;
         try {
              String query="update hang_hoa set so_luong=? where ma_hang=?";
             conn=DriverManager.getConnection("jdbc:mysql://localhost/minimarket", "root", "");
             sttm=conn.prepareStatement(query);
              sttm.setInt(1, sl);
               sttm.setInt(2,masp);
                if(sttm.executeUpdate()>0)
                    {
                        System.out.println("sửa thành công");
                        return 1;
                    }
         } catch (Exception e) {
             System.out.println("nhoc 2: "+e);
         }
         return -1;
     }
     
    //  sửa
     public int update(Product pr){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
           String query="update hang_hoa set ten_hang=? ,gia_ban=?,so_luong=?,id=? where ma_hang=?";
            conn=DriverManager.getConnection("jdbc:mysql://localhost/minimarket", "root", "");
            sttm=conn.prepareStatement(query);
             
            sttm.setString(1,pr.getTen_sp());
           
            sttm.setInt(2, pr.getGia_ban());
             
            sttm.setInt(3, pr.getSo_luong());
            sttm.setInt(4, pr.getMaloai());
             sttm.setInt(5, pr.getMa_sp());
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
     public int getmasp(String ma){
        Connection conn=null;
       PreparedStatement ps =null;
          
         try {
             String sql="select ma_hang from hang_hoa where ten_hang='"+ma+"'";
             conn= databaseUtils.getDBConnect();
              ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                return rs.getInt("ma_hang");
            }
        } catch (Exception e) {
        }
          
         return 0;
    }
     //xóa theo id
    
     //show tất cả
     
     public List<Product> getProduct(){
         List<Product>ls=new ArrayList<>();
        Connection conn=null;
        Statement sttm=null;
        try {
            String query="select ma_hang,ten_hang, gia_ban,so_luong,id from hang_hoa";
            conn = DriverManager.getConnection("jdbc:mysql://localhost/minimarket", "root", "");
            sttm=conn.createStatement();
            ResultSet rs=sttm.executeQuery(query);
            while(rs.next()){
                Product pr=new Product();
                pr.setMa_sp(rs.getInt(1));
                pr.setTen_sp(rs.getString(2));
              
                pr.setGia_ban(rs.getInt(3));
                pr.setSo_luong(rs.getInt(4));
                pr.setMaloai(rs.getInt(5));
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
     public Product getProductById(int ma_hang) {
         Product pr=new Product();
         Connection conn = null;
        PreparedStatement sttm = null;
         try {
             String query="select ma_hang,ten_hang, gia_ban,so_luong,id from hang_hoa where ma_hang=?";
             conn=DriverManager.getConnection("jdbc:mysql://localhost/minimarket", "root", "");
           sttm=conn.prepareStatement(query); 
            sttm.setInt(1,ma_hang);
            ResultSet rs=sttm.executeQuery();
            while(rs.next()){
                pr.setMa_sp(rs.getInt(1));
                pr.setTen_sp(rs.getString(2));
                
                pr.setGia_ban(rs.getInt(3));
                pr.setSo_luong(rs.getInt(4));
                pr.setMaloai(rs.getInt(5));
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
     // tìm kiếm theo tên
     public Product getProductByName(String ten_hang) {
         Product pr=new Product();
         Connection conn = null;
        PreparedStatement sttm = null;
         try {
             String query="select ma_hang,ten_hang ,gia_ban,so_luong,id from hang_hoa where ten_hang=?";
             conn=DriverManager.getConnection("jdbc:mysql://localhost/minimarket", "root", "");
           sttm=conn.prepareStatement(query); 
            sttm.setString(1,ten_hang);
            ResultSet rs=sttm.executeQuery();
            while(rs.next()){
                pr.setMa_sp(rs.getInt(1));
                pr.setTen_sp(rs.getString(2));
                
                pr.setGia_ban(rs.getInt(3));
                 pr.setSo_luong(rs.getInt(4));
                  pr.setMaloai(rs.getInt(5));
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
      public ArrayList<Product> addlist(Product pr){
          ArrayList<Product> a= new ArrayList<>();
        a.add(pr);
        return a;
    }
      
    public List<Product> getProducts(){
         List<Product> ls=new ArrayList<>();
        Connection conn=null;
        Statement sttm=null;
        try {// order by  so_luong asc
            String query="select ma_hang,ten_hang,so_luong,id from hang_hoa order by  so_luong asc";
           conn= databaseUtils.getDBConnect();
            sttm=conn.createStatement();
            ResultSet rs=sttm.executeQuery(query);
            while(rs.next()){
                 
                int sl= rs.getInt("so_luong");
                Product pr=new Product();
                if(sl>=0&&sl<=2){
                    pr.setMa_sp(rs.getInt(1));
                    pr.setTen_sp(rs.getString(2));
                    
                    pr.setSo_luong(rs.getInt(3));
                     pr.setMaloai(rs.getInt(4));
                    ls.add(pr);
                    System.out.println(sl +"sl ne");
                }
                else{
                   // System.out.println("that bai roi");
                }
                                   
            }
        } catch (Exception e) {
            System.out.println("Error hmmmm má ôi"+e.toString());
        }finally{
            try {
                sttm.close();conn.close();
            } catch (Exception e) {
            }
        }
         return ls;
     }
     public List<Product> getProductbyloai(int ma){
         List<Product> ls=new ArrayList<>();
        Connection conn=null;
        Statement sttm=null;
        try {// ma_hang,ten_hang, gia_ban,so_luong,id
            String query="select ma_hang,ten_hang,gia_ban,so_luong from hang_hoa where id='"+ma+"'";
           conn= databaseUtils.getDBConnect();
            sttm=conn.createStatement();
            ResultSet rs=sttm.executeQuery(query);
            while(rs.next()){
                
                Product pr=new Product();
                    pr.setMa_sp(rs.getInt(1));
                    pr.setTen_sp(rs.getString(2));  
                    pr.setSo_luong(rs.getInt(3));
                    pr.setGia_ban(rs.getInt(4));
                    ls.add(pr);
                                  
            }
        } catch (Exception e) {
            System.out.println("Error hmmmm má ôi"+e.toString());
        }finally{
            try {
                sttm.close();conn.close();
            } catch (Exception e) {
            }
        }
         return ls;
     }
   /*
    
    public ArrayList<Product> addlist(Product pr){
          ArrayList<Product> a= new ArrayList<>();
        a.add(pr);
        return a;
    }
    // thêm mới
    public int add(Product pr){
        Connection conn=null;
        PreparedStatement sttm=null;
        try {
           String query="insert hang_hoa(ten_hang ,gia_ban,so_luong) values(?,?,?,?)";
            conn= databaseUtils.getDBConnect();
            sttm=conn.prepareStatement(query);
            sttm.setString(1,pr.getTen_sp());
            
            sttm.setFloat(2, pr.getGia_ban());
            sttm.setInt(3, pr.getSoluong());
            
            if(sttm.executeUpdate()>0)
            {
                System.out.println("Thêm mới thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error nua ha"+e.toString());
        }finally{
            try {
                conn.close();
                sttm.close();
                       
            } catch (Exception e) {
            }
        }
        return -1;   //nếu thêm k thành công
    }
    //  sửa
    
     public int update(Product pr){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            //UPDATE hang_hoa h, chi_tiet_nhap_hang ct set h.ten_hang=?, h.gia_han=?, ct.so_luong=? where h.ma_hang=ct.ma_hang=?
      
           String query="update hang_hoa h, chi_tiet_nhap_hang ct set h.ten_hang=?, h.gia_ban=?, ct.so_luong=? where h.ma_hang=ct.ma_hang=?";
            conn= databaseUtils.getDBConnect();
            sttm=conn.prepareStatement(query);
            sttm.setString(1,pr.getTen_sp());

            sttm.setFloat(2, pr.getGia_ban());
            sttm.setInt(3, pr.getSoluong());
            sttm.setInt(4, pr.getMa_sp());
           // sttm.setInt(4, pr.getSoluong());
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
     public int delete(int ma_hang){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
           String query="delete from hang_hoa where ma_hang = ?";
           conn= databaseUtils.getDBConnect();
           sttm=conn.prepareStatement(query);
            sttm.setInt(1,ma_hang);
            
            if(sttm.executeUpdate()>0)
            {
                System.out.println("Xóa thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error aygu"+e.toString());
        }
        return -1;   
    }
     public List<Product> getProduct(){
         List<Product> ls=new ArrayList<>();
        Connection conn=null;
        Statement sttm=null;
        try {
            String query="select hang_hoa.ma_hang,hang_hoa.ten_hang,hang_hoa.gia_ban, chi_tiet_nhap.so_luong_nhap from hang_hoa INNER JOIN chi_tiet_nhap ON hang_hoa.ma_hang=chi_tiet_nhap.ma_hang order by chi_tiet_nhap.so_luong_nhap asc";
           conn= databaseUtils.getDBConnect();
            sttm=conn.createStatement();
            ResultSet rs=sttm.executeQuery(query);
            while(rs.next()){
                 
                int sl= rs.getInt("chi_tiet_nhap.so_luong_nhap");
                Product pr=new Product();
                if(sl>=0&&sl<=2){
                    pr.setMa_sp(rs.getInt(1));
                    pr.setTen_sp(rs.getString(2));
                    pr.setGia_ban(rs.getInt(3));
                    pr.setSoluong(rs.getInt(4));
                    ls.add(pr);
                    System.out.println(sl +"sl ne");
                }
                else{
                    System.out.println("that bai roi");
                }
                                   
            }
        } catch (Exception e) {
            System.out.println("Error hmmmm má ôi"+e.toString());
        }finally{
            try {
                sttm.close();conn.close();
            } catch (Exception e) {
            }
        }
         return ls;
     }
     //show tất cả
     public List<Product> getAllProduct(){
         List<Product> ls=new ArrayList<>();
        Connection conn=null;
        Statement sttm=null;
        try {
             String query="select hang_hoa.ma_hang,hang_hoa.ten_hang,hang_hoa.gia_ban, chi_tiet_nhap.so_luong_nhap from hang_hoa INNER JOIN chi_tiet_nhap ON hang_hoa.ma_hang=chi_tiet_nhap.ma_hang ";
           // String query="select ma_hang,ten_hang,gia_ban, so_luong from hang_hoa";
           conn= databaseUtils.getDBConnect();
            sttm=conn.createStatement();
            ResultSet rs=sttm.executeQuery(query);
            while(rs.next()){
                Product pr=new Product();
                pr.setMa_sp(rs.getInt(1));
                pr.setTen_sp(rs.getString(2));
                
                pr.setGia_ban(rs.getInt(3));
                pr.setSoluong(rs.getInt(4));
                ls.add(pr);                  
            }
        } catch (Exception e) {
            System.out.println("Error hm troi ôii"+e.toString());
        }finally{
            try {
                sttm.close();conn.close();
            } catch (Exception e) {
            }
        }
         return ls;
     }
     // tìm theo id 
     public Product getProductById(int ma_hang) {
         Product pr=new Product();
         Connection conn = null;
        PreparedStatement sttm = null;
         try {
             //SELECT a.id, a.name, a.num, b.date, b.roll
            // FROM a
            // INNER JOIN b ON a.id=b.id;
             String query="select hang_hoa.ma_hang,hang_hoa.ten_hang,hang_hoa.gia_ban,"
               + " chi_tiet_nhap.so_luong_nhap from hang_hoa INNER JOIN chi_tiet_nhap ON hang_hoa.ma_hang=chi_tiet_nhap.ma_hang "
                     + "where hang_hoa.ma_hang=?";
            conn= databaseUtils.getDBConnect();
           sttm=conn.prepareStatement(query); 
            sttm.setInt(1,ma_hang);
            ResultSet rs=sttm.executeQuery();
            while(rs.next()){
                pr.setMa_sp(rs.getInt(1));
                pr.setTen_sp(rs.getString(2));
               
                pr.setGia_ban(rs.getInt(3));
                 pr.setSoluong(rs.getInt(4));
                return pr;
            }
                
         } catch (Exception e) {
                 System.out.println("Error roi ne condi"+e.toString());      
         }finally{
            try {
                sttm.close();
                conn.close();
            } catch (Exception e) {
            }
         }
         return null;
     }
     // tìm kiếm theo tên
     public Product getProductByName(String ten_hang) {
         Product pr=new Product();
         Connection conn = null;
        PreparedStatement sttm = null;
         try {
             String query="select ma_hang,ten_hang,gia_nhap,gia_ban from hang_hoa where ten_hang=?";
             conn= databaseUtils.getDBConnect();
           sttm=conn.prepareStatement(query); 
            sttm.setString(1,ten_hang);
            ResultSet rs=sttm.executeQuery();
            while(rs.next()){
                pr.setMa_sp(rs.getInt(1));
                pr.setTen_sp(rs.getString(2));
               
                pr.setGia_ban(rs.getInt(3));
                 pr.setSoluong(rs.getInt(4));
                return pr;
            }
                
         } catch (Exception e) {
                 System.out.println("Error roi ne"+e.toString());      
         }finally{
            try {
                sttm.close();
                conn.close();
            } catch (Exception e) {
               
            }
         }
         return null;// nếu k tìm thấy thì trả về null
     }

   */

    public int getmasp(int h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
