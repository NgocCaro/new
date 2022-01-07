/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.chi_tiet_hd;

/**
 *
 * @author Admin
 */
public class Chitet_hdModify {
    private Connection conn;
    public Chitet_hdModify(){
        try {
            String url="jdbc:mysql://localhost/minimarket";
            String user="root";
            String password="";
            conn=DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public ArrayList<chi_tiet_hd> getchi_tiet_hdByMa_hd(int ma_hd) {
         ArrayList<chi_tiet_hd> list=new ArrayList<>();        
         Connection conn = null;
        PreparedStatement sttm = null;
         try {              
             String query="SELECT hang_hoa.ten_hang,chi_tiet_hd.so_luong,hang_hoa.gia_ban,chi_tiet_hd.tong_tien FROM chi_tiet_hd,hang_hoa WHERE chi_tiet_hd.ma_hang=hang_hoa.ma_hang and ma_hd=?";
             conn=DriverManager.getConnection("jdbc:mysql://localhost/minimarket", "root", "");                 // ma_chi_tiet_hd,ma_hang,so_luong,tong_tien
           sttm=conn.prepareStatement(query); 
            sttm.setInt(1,ma_hd);
            ResultSet rs=sttm.executeQuery();
            while(rs.next()){
                chi_tiet_hd pr=new chi_tiet_hd(rs.getString("ten_hang"),rs.getInt("so_luong"),rs.getInt("gia_ban"),rs.getInt("tong_tien"));
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
     }
    
    public void Dungtest(int k){
        System.out.println("====================="+k+"========================");
    }
    public ArrayList<chi_tiet_hd> getListSP(){
        ArrayList<chi_tiet_hd> list=new ArrayList<>();
        String sql="select ma_chi_tiet_hd,ma_hang,so_luong,tong_tien from chi_tiet_hd";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                chi_tiet_hd s=new chi_tiet_hd();
                s.setMa_chi_tiet_hd(rs.getInt("ma_chi_tiet_hd"));
                s.setMasp(rs.getInt("ma_hang"));
                s.setSo_luong(rs.getInt("so_luong"));
                s.setGia(rs.getInt("tong_tien"));
                
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    public void addSP(chi_tiet_hd s, int k ){
        String sql="insert chi_tiet_hd(ma_hd,ma_hang,so_luong,tong_tien) values(?,?,?,?)";                
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, k);
            ps.setInt(2, s.getMasp());
            ps.setInt(3, s.getSo_luong());
            ps.setInt(4, s.getGia());
            
            ps.executeUpdate();
            System.out.println("k ne: "+k);
        } catch (Exception e) {
            System.out.println("im here: "+e);
            e.printStackTrace();
        }
    }
   /* public void DeleteSP(int id ){
        String sql="delete from chi_tiet_hd where ma_chi_tiet_hd=?";
        try {
            PreparedStatement ps=conn.prepareCall(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    
    
    public static void main(String[] args) {
        new Chitet_hdModify();
        
    }
}
