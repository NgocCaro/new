/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author trant
 */
public class nhanvien {
     private int ma_nv;
     private String ten_nv;
    private String ngay_sinh;
    private String gioi_tinh;
    private String dia_chi;
    
    private String sđt_nv;
    private String username;
    private String password;
    private int phan_quyen;
 private int luong;
 private long thoigian;

    public long getThoigian() {
        return thoigian;
    }

    public void setThoigian(long thoigian) {
        this.thoigian = thoigian;
    }

    public nhanvien(int ma_nv, String ten_nv, String ngay_sinh, String gioi_tinh, String dia_chi, String sđt_nv, String username, String password, int phan_quyen, int luong, long thoigian) {
        this.ma_nv = ma_nv;
        this.ten_nv = ten_nv;
        this.ngay_sinh = ngay_sinh;
        this.gioi_tinh = gioi_tinh;
        this.dia_chi = dia_chi;
        this.sđt_nv = sđt_nv;
        this.username = username;
        this.password = password;
        this.phan_quyen = phan_quyen;
        this.luong = luong;
        this.thoigian = thoigian;
    }
 public nhanvien() {
    }

    public nhanvien(int ma_nv, String ten_nv, String ngay_sinh, String gioi_tinh, String dia_chi, String sđt_nv, String username, String password, int phan_quyen, int luong) {
        this.ma_nv = ma_nv;
        this.ten_nv = ten_nv;
        this.ngay_sinh = ngay_sinh;
        this.gioi_tinh = gioi_tinh;
        this.dia_chi = dia_chi;
        this.sđt_nv = sđt_nv;
        this.username = username;
        this.password = password;
        this.phan_quyen = phan_quyen;
        this.luong = luong;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }
    
     
    public int getMa_nv() {
        return ma_nv;
    }

    public void setMa_nv(int ma_nv) {
        this.ma_nv = ma_nv;
    }
    public String getTen_nv() {
        return ten_nv;
    }

    public void setTen_nv(String ten_nv) {
        this.ten_nv = ten_nv;
    }


   
 
        
    public String getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(String ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public String getGioi_tinh() {
        return gioi_tinh;
    }

    public void setGioi_tinh(String gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    

    public String getSđt_nv() {
        return sđt_nv;
    }

    public void setSđt_nv(String sđt_nv) {
        this.sđt_nv = sđt_nv;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhan_quyen() {
        return phan_quyen;
    }

    public void setPhan_quyen(int phan_quyen) {
        this.phan_quyen = phan_quyen;
    }

    @Override
    public String toString() {
        return "nhanvien{" + "ma_nv=" + ma_nv + ", ten_nv=" + ten_nv + ", ngay_sinh=" + ngay_sinh + ", gioi_tinh=" + gioi_tinh + ", dia_chi=" + dia_chi + ", s\u0111t_nv=" + sđt_nv + ", username=" + username + ", password=" + password + ", phan_quyen=" + phan_quyen + '}';
    }

 

    
    
}
