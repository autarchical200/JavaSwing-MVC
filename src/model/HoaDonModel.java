/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author HungPhanPC
 */
public class HoaDonModel {
    private int mahd;
    private int makh;
    private int manv;
    private Date ngaylap;
    private double tongtien;
    private String ghichu;

    public HoaDonModel() {
    }

    public HoaDonModel(int mahd, int makh, int manv, Date ngaylap, double tongtien, String ghichu) {
        this.mahd = mahd;
        this.makh = makh;
        this.manv = manv;
        this.ngaylap = ngaylap;
        this.tongtien = tongtien;
        this.ghichu = ghichu;
    }

    public int getMahd() {
        return mahd;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    public int getMakh() {
        return makh;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public Date getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(Date ngaylap) {
        this.ngaylap = ngaylap;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    @Override
    public String toString() {
        return "HoaDonModel{" + "mahd=" + mahd + ", makh=" + makh + ", manv=" + manv + ", ngaylap=" + ngaylap + ", tongtien=" + tongtien + ", ghichu=" + ghichu + '}';
    }
    
}
