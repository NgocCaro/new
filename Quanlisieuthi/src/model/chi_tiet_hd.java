/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class chi_tiet_hd {
   private int ma_chi_tiet_hd;
    private int masp;
    private int mahd;
    private int so_luong;
    private int giaban;
    private String ten_sp;
    public int getGiaban() {
        return giaban;
    }

    public String getTen_sp() {
        return ten_sp;
    }

    public void setTen_sp(String ten_sp) {
        this.ten_sp = ten_sp;
    }

    public void setGiaban(int giaban) {
        this.giaban = giaban;
    }

    public chi_tiet_hd(int masp,String ten_sp, int so_luong, int giaban,  int gia) {
        
        this.masp = masp;
        this.ten_sp = ten_sp;
        this.so_luong = so_luong;
        this.giaban = giaban;
        
        this.gia = gia;
    }

    public chi_tiet_hd(String ten_sp,int so_luong, int giaban,  int gia) {
        this.ten_sp = ten_sp;
        this.so_luong = so_luong;
        this.giaban = giaban;
        this.gia = gia;
    }

    public chi_tiet_hd(int masp,  int so_luong  , int giaban, int gia) {
        this.masp = masp;
        
        this.so_luong = so_luong;
        this.giaban = giaban;
        this.gia = gia;
    }
    private int gia;
    //private int ma_hd;

    public chi_tiet_hd() {
    }

 public chi_tiet_hd(int masp, int so_luong, int gia) {
        this.masp = masp;
        this.so_luong = so_luong;
        this.gia = gia;
    }
    public int getMa_chi_tiet_hd() {
        return ma_chi_tiet_hd;
    }

    public void setMa_chi_tiet_hd(int ma_chi_tiet_hd) {
        this.ma_chi_tiet_hd = ma_chi_tiet_hd;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public int getMahd() {
        return mahd;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
    
}
