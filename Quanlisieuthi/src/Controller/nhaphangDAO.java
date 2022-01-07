/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Views.Login;
import database.databaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.nhaphang;

/**
 *
 * @author trant
 */
public class nhaphangDAO {
    Login lg= new Login();
    public int getmanh(String ma){
        Connection conn=null;
       PreparedStatement ps =null;
          
         try {
             String sql="select ma_nhap from nhap_hang where ngay_nhap='"+ma+"'";
             conn= databaseUtils.getDBConnect();
              ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                return rs.getInt("ma_nhap");
            }
        } catch (Exception e) {
        }
          
         return 0;
    }
    
    public int getctnh(int mah){
        Connection conn=null;
       PreparedStatement ps =null;
          
         try {
             String sql="select ma_nhap from chi_tiet_nhap where ma_hang='"+mah+"'";
             conn= databaseUtils.getDBConnect();
              ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                return getncc( rs.getInt("ma_nhap"));
            }
        } catch (Exception e) {
             System.out.println(e);
        }
        return -1;
    }
    public int getncc(int ma_nhap){
        Connection conn=null;
       PreparedStatement ps =null;
          
         try {
             String sql="select ma_ncc from nhap_hang where ma_nhap='"+ma_nhap+"'";
             conn= databaseUtils.getDBConnect();
              ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                return rs.getInt("ma_ncc");
            }
        } catch (Exception e) {
        }
          
         return 0;
    }
    public int getgianhap(int mah){
        Connection conn=null;
       PreparedStatement ps =null;
          
         try {
             String sql="select gia_nhap from chi_tiet_nhap where ma_hang='"+mah+"'";
             conn= databaseUtils.getDBConnect();
              ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                System.out.println("hmmm");
                 return rs.getInt("gia_nhap");
               // return getncc( rs.getInt("gia_nhap"));
            }
        } catch (Exception e) {
        }
        return 0;
    }
    
    public int add(nhaphang nv){
       Connection conn=null;
       PreparedStatement sttm =null;
       try {
           String sql="insert nhap_hang(ma_ncc, ma_nv, ngay_nhap, thanh_tien)"+" values(?,?,?,?)";
           conn= databaseUtils.getDBConnect();
           sttm= conn.prepareStatement(sql);
           
           sttm.setInt(1, nv.getMancc());     
           sttm.setInt(2, nv.getManv());
           sttm.setString(3, nv.getNgaynhap());
            sttm.setInt(4, nv.getThanhtien());
           
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
    
    public void getdata(){
        
    }
    
       public ArrayList<nhaphang> getListNH(){
    
           
    ArrayList<nhaphang> list=new ArrayList<>();
      Connection conn= null;
       Statement sttm= null;
       ResultSet rs=null;
     
        try {
           
            
        String sql="select ma_nhap,ma_ncc,ma_nv,ngay_nhap,thanh_tien from nhap_hang";
        conn= databaseUtils.getDBConnect();
           sttm= conn.createStatement();
           rs= sttm.executeQuery(sql);
            
            while(rs.next()){
               nhaphang s=new nhaphang();
                s.setManhap(rs.getInt("ma_nhap"));
                s.setMancc(rs.getInt("ma_ncc"));
                s.setManv(rs.getInt("ma_nv"));
                s.setNgaynhap(rs.getString("ngay_nhap"));
                s.setThanhtien(rs.getInt("thanh_tien"));
                list.add(s);
            }
        } catch (Exception e) {
            System.out.println("loi gi k biet: "+e.toString());
        }
        return list;
    }
       
    
     public List<nhaphang> getttNhap(int mancc, int manhap){
         List<nhaphang> ls= new ArrayList<>();
         
           nhaphang nv= new nhaphang();
           nv.setManhap(manhap);
           nv.setMancc(mancc);
           nv.setManv(lg.returnma()); 
         return ls;
     }
}
