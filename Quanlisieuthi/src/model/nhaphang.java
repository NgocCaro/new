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
public class nhaphang {
    private int manhap;
    private int mancc;
    private int manv;
    private String ngaynhap;
    private int thanhtien;

    public nhaphang() {
    }

    public nhaphang(int mancc, int manv, String ngaynhap, int thanhtien) {
        this.mancc = mancc;
        this.manv = manv;
        this.ngaynhap = ngaynhap;
        this.thanhtien = thanhtien;
    }

    public nhaphang(int manhap, int mancc, int manv, String ngaynhap, int thanhtien) {
        this.manhap = manhap;
        this.mancc = mancc;
        this.manv = manv;
        this.ngaynhap = ngaynhap;
        this.thanhtien = thanhtien;
    }

    public int getManhap() {
        return manhap;
    }

    public void setManhap(int manhap) {
        this.manhap = manhap;
    }

    public int getMancc() {
        return mancc;
    }

    public void setMancc(int mancc) {
        this.mancc = mancc;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }

    @Override
    public String toString() {
        return "nhaphang{" + "manhap=" + manhap + ", mancc=" + mancc + ", manv=" + manv + ", ngaynhap=" + ngaynhap + ", thanhtien=" + thanhtien + '}';
    }
    
    
}
