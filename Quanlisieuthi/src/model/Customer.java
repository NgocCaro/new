/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Customer {
    private int ma_khach;
    private String ten_khach;
    private String sdt_khach;

    public Customer() {
    }

    public Customer(int ma_khach, String ten_khach, String sdt_khach) {
        this.ma_khach = ma_khach;
        this.ten_khach = ten_khach;
        this.sdt_khach = sdt_khach;
    }

    public int getMa_khach() {
        return ma_khach;
    }

    public void setMa_khach(int ma_khach) {
        this.ma_khach = ma_khach;
    }

    public String getTen_khach() {
        return ten_khach;
    }

    public void setTen_khach(String ten_khach) {
        this.ten_khach = ten_khach;
    }

    public String getSdt_khach() {
        return sdt_khach;
    }

    public void setSdt_khach(String sdt_khach) {
        this.sdt_khach = sdt_khach;
    }

    @Override
    public String toString() {
        return "Customer{" + "ma_khach=" + ma_khach + ", ten_khach=" + ten_khach + ", sdt_khach=" + sdt_khach + '}';
    }
    
}
