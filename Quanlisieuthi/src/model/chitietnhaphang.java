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
public class chitietnhaphang {
   
    private int ma_nhap;
    private int ma_hang;
    private int gianhap;
    private int soluong;
    private int tongtien;
    private String tenhang;
private int loai;

    public chitietnhaphang(int gianhap, int soluong, int tongtien, String tenhang, int loai) {
        this.gianhap = gianhap;
        this.soluong = soluong;
        this.tongtien = tongtien;
        this.tenhang = tenhang;
        this.loai = loai;
    }

    public chitietnhaphang(int ma_nhap, int ma_hang, int gianhap, int soluong, int tongtien) {
        this.ma_nhap = ma_nhap;
        this.ma_hang = ma_hang;
        this.gianhap = gianhap;
        this.soluong = soluong;
        this.tongtien = tongtien;
    }

    public int getLoai() {
        return loai;
    }

    public void setLoai(int loai) {
        this.loai = loai;
    }

    public String getTenhang() {
        return tenhang;
    }

    public void setTenhang(String tenhang) {
        this.tenhang = tenhang;
    }

    public chitietnhaphang(int ma_hang, int gianhap, int soluong, int tongtien) {
        this.ma_hang = ma_hang;
        this.gianhap = gianhap;
        this.soluong = soluong;
        this.tongtien = tongtien;
    }

    public chitietnhaphang(int gianhap, int soluong, int tongtien, String tenhang) {
        this.gianhap = gianhap;
        this.soluong = soluong;
        this.tongtien = tongtien;
        this.tenhang = tenhang;
    }
    
    public chitietnhaphang(int gianhap, int soluong, int tongtien) {
        this.gianhap = gianhap;
        this.soluong = soluong;
        this.tongtien = tongtien;
    }

    public chitietnhaphang() {
    }

    
 

    public int getMa_nhap() {
        return ma_nhap;
    }

    public void setMa_nhap(int ma_nhap) {
        this.ma_nhap = ma_nhap;
    }

    public int getMa_hang() {
        return ma_hang;
    }

    public void setMa_hang(int ma_hang) {
        this.ma_hang = ma_hang;
    }

    public int getGianhap() {
        return gianhap;
    }

    public void setGianhap(int gianhap) {
        this.gianhap = gianhap;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    
            
}
