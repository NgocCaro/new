/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import model.chitietnhaphang;
import model.nhanvien;

/**
 *
 * @author trant
 */
public class chitietnhaphangDAO {
    
    public ArrayList<chitietnhaphang> getListSP(){
         Connection conn=null;
       PreparedStatement ps =null;
         
        ArrayList<chitietnhaphang> list=new ArrayList<>();
        String sql="select   ma_nhap,ma_hang,so_luong_nhap,gia_nhap,tong_tien_nhap from chi_tiet_nhap";
        try {
             conn= databaseUtils.getDBConnect();
             ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                chitietnhaphang s= new chitietnhaphang();
              
                s.setMa_nhap(rs.getInt("ma_nhap"));
                s.setMa_hang(rs.getInt("ma_hang"));
                s.setSoluong(rs.getInt("so_luong_nhap"));
                s.setGianhap(rs.getInt("gia_nhap"));
                s.setTongtien(rs.getInt("tong_tien_nhap"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public void addSP(chitietnhaphang s, int k, int h){
        Connection conn=null;
       PreparedStatement ps =null;
 
        try {
             String sql="insert chi_tiet_nhap(ma_nhap,ma_hang,so_luong_nhap, gia_nhap,tong_tien_nhap) values(?,?,?,?,?)";                
             conn= databaseUtils.getDBConnect();
             ps=conn.prepareStatement(sql);
/*
            ps.setInt(1, k);
            ps.setInt(2, s.getMasp());
            ps.setInt(3, s.getSo_luong());
            ps.setInt(4, s.getGia());
            
            ps.executeUpdate();*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
     public int getmanhap(int mahang){
          Connection conn = null;
        PreparedStatement sttm = null;
          try {

              String sql= "Select ma_nhap from chi_tiet_nhap where ma_hang='"+mahang+"'";
             conn= databaseUtils.getDBConnect();
            sttm=conn.prepareStatement(sql);
            ResultSet rs=sttm.executeQuery();
  
           if(rs.next())
            {
                System.out.println("hi");
                 int k= rs.getInt("ma_nhap");
                 System.out.println(k+ "day a");
                return k;
            }
          } catch (Exception e) {
              System.out.println("day ne: "+e);
          }
           
          return -1;
      }
      public int getmancc(int manhap){
          Connection conn = null;
        PreparedStatement sttm = null;
          try {

              String sql= "Select ma_ncc from nhap_hang where ma_nhap='"+manhap+"'";
             conn= databaseUtils.getDBConnect();
            sttm=conn.prepareStatement(sql);
            ResultSet rs=sttm.executeQuery();
  
           if(rs.next())
            {
                System.out.println("hi");
                 int k= rs.getInt("ma_ncc");
                 System.out.println(k+ "day a");
                return k;
            }
          } catch (Exception e) {
              System.out.println("day ne: "+e);
          }
           
          return -1;
      }
     
    //Select ma_nhap from chi_tiet_nhap where ma_hang=
     public int getgianhap(int mahang){
          Connection conn = null;
        PreparedStatement sttm = null;
          try {

              String sql= "Select gia_nhap from chi_tiet_nhap where ma_hang='"+mahang+"'";
             conn= databaseUtils.getDBConnect();
            sttm=conn.prepareStatement(sql);
            ResultSet rs=sttm.executeQuery();
  
           if(rs.next())
            {
                System.out.println("hi");
                 int k= rs.getInt("gia_nhap");
                 System.out.println(k+ "day a");
                return k;
            }
          } catch (Exception e) {
              System.out.println("day ne: "+e);
          }
           
          return -1;
      }
    
     
    
      public int getsoluong(int mahang){
          Connection conn = null;
        PreparedStatement sttm = null;
          try {

              String sql= "Select so_luong from hang_hoa where ma_hang='"+mahang+"'";
             conn= databaseUtils.getDBConnect();
            sttm=conn.prepareStatement(sql);
            ResultSet rs=sttm.executeQuery();
  
           if(rs.next())
            {
                System.out.println("hi");
                 int k= rs.getInt("so_luong");
                 System.out.println(k+ "day a");
                return k;
            }
          } catch (Exception e) {
              System.out.println("day ne: "+e);
          }
           
          return -1;
      }
      /*
      public ArrayList<chitietnhaphang> getchi_tiet_nhByMa_nh(int ma_nh) {
         ArrayList<chitietnhaphang> list=new ArrayList<>();        
         Connection conn = null;
        PreparedStatement sttm = null;
         try {              
             String query="SELECT * FROM chi_tiet_nhap WHERE  ma_nhap=?";
             conn=DriverManager.getConnection("jdbc:mysql://localhost/minimarket", "root", "");                 // ma_chi_tiet_hd,ma_hang,so_luong,tong_tien
           sttm=conn.prepareStatement(query); 
            sttm.setInt(1,ma_nh);
            ResultSet rs=sttm.executeQuery();
            while(rs.next()){
                //int machitiet_nh, int ma_nhap, int ma_hang, int gianhap, int soluong, int tongtien
                chitietnhaphang pr=new chitietnhaphang(rs.getInt("ma_chi_tiet_nhap"),rs.getInt("ma_nhap"),rs.getInt("ma_hang"),rs.getInt("gia_nhap"),rs.getInt("so_luong_nhap"),rs.getInt("tong_tien_nhap"));
               list.add(pr);
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
         return list;
     }*/
      public int addnh(chitietnhaphang hd){
         Connection conn = null;
        PreparedStatement ps = null;
        try {
            String sql="insert chi_tiet_nhap(ma_nhap,ma_hang,so_luong_nhap,gia_nhap,tong_tien_nhap) values(?,?,?,?,?)";
             conn= databaseUtils.getDBConnect();
              ps=conn.prepareStatement(sql);
            ps.setInt(1,hd.getMa_nhap());
            ps.setInt(2, hd.getMa_hang());
            ps.setInt(3, hd.getSoluong());
            ps.setInt(4, hd.getGianhap());
            ps.setInt(5, hd.getTongtien());
             
             if(ps.executeUpdate()>0){
                 System.out.println("ok ok");
               return 1;
           }
        } catch (Exception e) {
            System.out.println("loi ne"+ e);
        }
        
       return -1; 
       
    }
    public int updat(chitietnhaphang pr){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
             String query="update chi_tiet_nhap set so_luong_nhap=? where ma_hang=?";
          // String query="update hang_hoa set ten_hang=?,gia_nhap=?,gia_ban=? where ma_hang=?";
            conn= databaseUtils.getDBConnect();
            sttm=conn.prepareStatement(query);
             sttm.setInt(1, pr.getSoluong());
            sttm.setInt(2, pr.getMa_hang());
             
            if(sttm.executeUpdate()>0)
            {
                System.out.println("thêm thành công");
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
     /*
     public List<chitietnhaphang> getAllProduct(){
         List<chitietnhaphang> ls=new ArrayList<>();
        Connection conn=null;
        Statement sttm=null;
        try {
            String query="select ma_hang,so_luong_nhap from chi_tiet_nhap";
           conn= databaseUtils.getDBConnect();
            sttm=conn.createStatement();
            ResultSet rs=sttm.executeQuery(query);
            while(rs.next()){
                Product pr=new Product();
                pr.setMa_sp(rs.getInt(1));
                pr.setTen_sp(rs.getString(2));
                
                pr.setGia_ban(rs.getFloat(3));
                pr.setSoluong(rs.getInt(4));
                ls.add(pr);                  
            }
        } catch (Exception e) {
            System.out.println("Error hmmmmmmm"+e.toString());
        }finally{
            try {
                sttm.close();conn.close();
            } catch (Exception e) {
            }
        }
         return ls;
     }*/
     
    public int add(chitietnhaphang nv){
       Connection conn=null;
       PreparedStatement sttm =null;
       try {
           String sql="insert nhanvien(ma_nhap, ma_hang,gia_nhap so_luong_nhap, tong_tien_nhap)"+" values(?,?,?,?,?)";
           conn= databaseUtils.getDBConnect();
           sttm= conn.prepareStatement(sql);
           sttm.setInt(1, nv.getMa_nhap());
           sttm.setInt(2, nv.getMa_hang());
           sttm.setInt(3, nv.getGianhap());
           sttm.setInt(3, nv.getSoluong());
           sttm.setInt(4, nv.getTongtien());
         
           if(sttm.executeUpdate()>0){
               System.out.println("add thanh cong");
               return 1;
           }
           else{
               System.out.println("sao zi?");
           }
       } catch (Exception e) {
           System.out.println(e.toString());
       }
       finally{
           try {
               conn.close();
               sttm.close();
           } catch (Exception e) {
           }
       }
       return -1; //neu them k thanh cong
   }
    
 public int addTMP(chitietnhaphang nv){
       Connection conn=null;
       PreparedStatement sttm =null;
       try {
           String sql="insert nhanvien(ma_nhap, ma_hang,gia_nhap, so_luong_nhap, tong_tien_nhap)"+" values(?,?,?,?,?)";
           conn= databaseUtils.getDBConnect();
           sttm= conn.prepareStatement(sql);
           sttm.setInt(1, nv.getMa_nhap());
           sttm.setInt(2, nv.getMa_hang());
           sttm.setInt(3, nv.getSoluong());
           sttm.setInt(4, nv.getTongtien());
         
           if(sttm.executeUpdate()>0){
               System.out.println("add thanh cong");
               return 1;
           }
           else{
               System.out.println("sao zi?");
           }
       } catch (Exception e) {
           System.out.println(e.toString());
       }
       finally{
           try {
               conn.close();
               sttm.close();
           } catch (Exception e) {
           }
       }
       return -1; //neu them k thanh cong
   }
      public int del(int ma){
       Connection conn=null;
       PreparedStatement sttm =null;
       try {
           String sql="DELETE FROM nhanvien WHERE nhanvien.ma_nv = ?";
           conn= databaseUtils.getDBConnect();
           sttm= conn.prepareStatement(sql);
          sttm.setInt(1, ma);
           if(sttm.executeUpdate()>0){
               System.out.println("xoa thanh cong");
               return 1;
           }
           else{
               System.out.println("sao zi?");
           }
       } catch (Exception e) {
           System.out.println(e.toString());
       }
       finally{
           try {
               conn.close();
               sttm.close();
           } catch (Exception e) {
           }
       }
       return -1; //neu them k thanh cong
   }
     
       public List<nhanvien> getAllNhanvien(){
        List<nhanvien> ls = new ArrayList<>();
       Connection conn= null;
       Statement sttm= null;
       ResultSet rs=null;
       //ma_nv, ten_nv, ngay_sinh, gioi_tinh, dia_chi, sdt_nv, username,password, phan_quyen from nhanvien order by ma_nv desc
       try {
           String sql = "select ma_nv, ten_nv, ngay_sinh, gioi_tinh, dia_chi, sdt_nv, username,password, phan_quyen from nhanvien  ";
           conn= databaseUtils.getDBConnect();
           sttm= conn.createStatement();
           rs= sttm.executeQuery(sql);
           while(rs.next()){
               nhanvien nv= new nhanvien();
               nv.setMa_nv(rs.getInt(1));
               nv.setTen_nv(rs.getString(2));
               nv.setNgay_sinh(rs.getString(3));
                nv.setGioi_tinh(rs.getString(4));
                 
               nv.setDia_chi(rs.getString(5));
              nv.setSđt_nv(rs.getString(6));
             
              nv.setUsername(rs.getString(7));
              nv.setPassword(rs.getString(8));
              nv.setPhan_quyen(rs.getInt(9));
              ls.add(nv);
           }
       } catch (Exception e) {
           System.out.println(e.toString());
       }
       finally{
           try {
               rs.close();
               sttm.close();
               conn.close();
           } catch (Exception e) {
           }
       }
       return ls;
   }

    public int update(chitietnhaphang prNew) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void main(String[] args) {
        chitietnhaphangDAO dao= new chitietnhaphangDAO();
        System.out.println("ahihih ngu thoi   "+dao.getsoluong(2));
    }
}
