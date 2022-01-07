/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class quanlyhoadon {
    private int mahd;
    private String Date_Buy;
    private int thanhTien;
    private int manv;
   private String sdt;
   private String tennv;
     
    public quanlyhoadon() {
    }

    public quanlyhoadon(int mahd, String Date_Buy, int thanhTien, String sdt, String tennv) {
        this.mahd = mahd;
        this.Date_Buy = Date_Buy;
        this.thanhTien = thanhTien;
        this.sdt = sdt;
        this.tennv = tennv;
    }

    public quanlyhoadon(int mahd, String Date_Buy, int thanhTien, int manv, String sdt) {
        this.mahd = mahd;
        this.Date_Buy = Date_Buy;
        this.thanhTien = thanhTien;
        this.manv = manv;
        this.sdt = sdt;
    }

    public quanlyhoadon(int mahd, String Date_Buy, int thanhTien, int manv) {
        this.mahd = mahd;
        this.Date_Buy = Date_Buy;
        this.thanhTien = thanhTien;
        this.manv = manv;
    }

    public quanlyhoadon(String Date_Buy, int thanhTien, int manv) {
        this.Date_Buy = Date_Buy;
        this.thanhTien = thanhTien;
        this.manv = manv;
    }

    
    public quanlyhoadon(String Date_Buy, int thanhTien, int manv, String sdt) {
        this.Date_Buy = Date_Buy;
        this.thanhTien = thanhTien;
        this.manv = manv;
        this.sdt = sdt;
    }

    
    public int getMahd() {
        return mahd;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    public String getDate_Buy() {
        return Date_Buy;
    }

    public void setDate_Buy(String Date_Buy) {
        this.Date_Buy = Date_Buy;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    @Override
    public String toString() {
        return "quanlyhoadon{" + "mahd=" + mahd + ", Date_Buy=" + Date_Buy + ", thanhTien=" + thanhTien + ", manv=" + manv + '}';
    }

    public void getSdt(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    

    
    
}
