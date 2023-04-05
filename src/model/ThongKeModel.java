/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author HungPhanPC
 */
public class ThongKeModel {
    public int soLuongSP;
    public int soLuongKH;
    public int soLuongNV;
    public int[] tongThuQuy;
    public ArrayList<SanPhamModel> topSanPhamBanChay;

    public ThongKeModel() {
    }

    public ThongKeModel(int soLuongSP, int soLuongKH, int soLuongNV, int[] tongThuQuy, ArrayList<SanPhamModel> topSanPhamBanChay) {
        this.soLuongSP = soLuongSP;
        this.soLuongKH = soLuongKH;
        this.soLuongNV = soLuongNV;
        this.tongThuQuy = tongThuQuy;
        this.topSanPhamBanChay = topSanPhamBanChay;
    }

    public int getSoLuongSP() {
        return soLuongSP;
    }

    public void setSoLuongSP(int soLuongSP) {
        this.soLuongSP = soLuongSP;
    }

    public int getSoLuongKH() {
        return soLuongKH;
    }

    public void setSoLuongKH(int soLuongKH) {
        this.soLuongKH = soLuongKH;
    }

    public int getSoLuongNV() {
        return soLuongNV;
    }

    public void setSoLuongNV(int soLuongNV) {
        this.soLuongNV = soLuongNV;
    }

    public int[] getTongThuQuy() {
        return tongThuQuy;
    }

    public int getTongThuQuy(int quy) {
        return tongThuQuy[quy - 1];
    }

    public void setTongThuQuy(int[] tongThuQuy) {
        this.tongThuQuy = tongThuQuy;
    }

    public int getTongDoanhThu() {
        int tong = 0;
        for (int i = 0; i < 4; i++) {
            tong += tongThuQuy[i];
        }
        return tong;
    }

    public ArrayList<SanPhamModel> getTopSanPhamBanChay() {
        return topSanPhamBanChay;
    }

    public void setTopSanPhamBanChay(ArrayList<SanPhamModel> topSanPhamBanChay) {
        this.topSanPhamBanChay = topSanPhamBanChay;
    }
}
