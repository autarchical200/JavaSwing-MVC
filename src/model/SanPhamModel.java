/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HungPhanPC
 */
public class SanPhamModel {
    private int masp;
    private String tensp;
    private int maloai;
    private int  soluong;
    private String donvitinh;
    private String hinhanh;
    private float dongia;

    public SanPhamModel() {
    }

    public SanPhamModel(int masp, String tensp, int maloai, int soluong, String donvitinh, String hinhanh, float dongia) {
        this.masp = masp;
        this.tensp = tensp;
        this.maloai = maloai;
        this.soluong = soluong;
        this.donvitinh = donvitinh;
        this.hinhanh = hinhanh;
        this.dongia = dongia;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getMaloai() {
        return maloai;
    }

    public void setMaloai(int maloai) {
        this.maloai = maloai;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getDonvitinh() {
        return donvitinh;
    }

    public void setDonvitinh(String donvitinh) {
        this.donvitinh = donvitinh;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public float getDongia() {
        return dongia;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }

    @Override
    public String toString() {
        return "sanpham{" + "masp=" + masp + ", tensp=" + tensp + ", maloai=" + maloai + ", soluong=" + soluong + ", donvitinh=" + donvitinh + ", hinhanh=" + hinhanh + ", dongia=" + dongia + '}';
    }
    
}
