/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HungPhanPC
 */
public class CTHoaDonModel {
    private int mahd;
    private int masp;
    private int soluong;
    private double dongia;
    private double thanhtien;

    public CTHoaDonModel() {
    }

    public CTHoaDonModel(int mahd, int masp, int soluong, double dongia, double thanhtien) {
        this.mahd = mahd;
        this.masp = masp;
        this.soluong = soluong;
        this.dongia = dongia;
        this.thanhtien = thanhtien;
    }

    public int getMahd() {
        return mahd;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public double getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }

    @Override
    public String toString() {
        return "CTHoaDonModel{" + "mahd=" + mahd + ", masp=" + masp + ", soluong=" + soluong + ", dongia=" + dongia + ", thanhtien=" + thanhtien + '}';
    }
    
}
