/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HungPhanPC
 */
public class KhachHangModel {
    private int makh;
    private String ho;
    private String ten;
    private String gioitinh;
    private double tongchitieu;

    public KhachHangModel() {
    }

    public KhachHangModel(int makh, String ho, String ten, String gioitinh, double tongchitieu) {
        this.makh = makh;
        this.ho = ho;
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.tongchitieu = tongchitieu;
    }

    public int getMakh() {
        return makh;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public double getTongchitieu() {
        return tongchitieu;
    }

    public void setTongchitieu(double tongchitieu) {
        this.tongchitieu = tongchitieu;
    }

    @Override
    public String toString() {
        return "KhachHangModel{" + "makh=" + makh + ", ho=" + ho + ", ten=" + ten + ", gioitinh=" + gioitinh + ", tongchitieu=" + tongchitieu + '}';
    }
    
}
