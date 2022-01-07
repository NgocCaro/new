/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class quan_ly_ncc {
    private int ma_ncc;
    private String ten_ncc;
    private String sdt_ncc;

    public quan_ly_ncc() {
    }

    public quan_ly_ncc(int ma_ncc, String ten_ncc, String sdt_ncc) {
        this.ma_ncc = ma_ncc;
        this.ten_ncc = ten_ncc;
        this.sdt_ncc = sdt_ncc;
    }

    public int getMa_ncc() {
        return ma_ncc;
    }

    public void setMa_ncc(int ma_ncc) {
        this.ma_ncc = ma_ncc;
    }

    public String getTen_ncc() {
        return ten_ncc;
    }

    public void setTen_ncc(String ten_ncc) {
        this.ten_ncc = ten_ncc;
    }

    public String getSdt_ncc() {
        return sdt_ncc;
    }

    public void setSdt_ncc(String sdt_ncc) {
        this.sdt_ncc = sdt_ncc;
    }

    @Override
    public String toString() {
        return "quan_ly_ncc{" + "ma_ncc=" + ma_ncc + ", ten_ncc=" + ten_ncc + ", sdt_ncc=" + sdt_ncc + '}';
    }

    
    
    
}
