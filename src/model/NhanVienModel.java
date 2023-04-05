/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HungPhanPC
 */
public class NhanVienModel {
    private int manv;
    private String ho;
    private String ten;
    private String gioitinh;
    private String sdt;
    private String tendangnhap;
    private String matkhau;
    private String vaitro;

    public NhanVienModel() {
    }

    public NhanVienModel(int manv, String ho, String ten, String gioitinh, String sdt, String tendangnhap, String matkhau, String vaitro) {
        this.manv = manv;
        this.ho = ho;
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.sdt = sdt;
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
        this.vaitro = vaitro;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getVaitro() {
        return vaitro;
    }

    public void setVaitro(String vaitro) {
        this.vaitro = vaitro;
    }

    @Override
    public String toString() {
        return "NhanVienModel{" + "manv=" + manv + ", ho=" + ho + ", ten=" + ten + ", gioitinh=" + gioitinh + ", sdt=" + sdt + ", tendangnhap=" + tendangnhap + ", matkhau=" + matkhau + ", vaitro=" + vaitro + '}';
    }
    
}
