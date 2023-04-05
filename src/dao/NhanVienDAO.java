/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connect.Connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.NhanVienModel;
import model.SanPhamModel;

/**
 *
 * @author HungPhanPC
 */
public class NhanVienDAO {

    public ArrayList<NhanVienModel> getListNhanVien() throws Exception {
        try {
            String sql = "SELECT * FROM nhanvien";
            Connection conn = Connect.getConnection();
            PreparedStatement prst = conn.prepareStatement(sql);
            ResultSet rs = prst.executeQuery();
            ArrayList<NhanVienModel> lst = new ArrayList<>();
            while (rs.next()) {
                NhanVienModel nv = new NhanVienModel();
                nv.setManv(rs.getInt(1));
                nv.setHo(rs.getString(2));
                nv.setTen(rs.getString(3));
                nv.setGioitinh(rs.getString(4));
                nv.setSdt(rs.getString(5));
                nv.setTendangnhap(rs.getString(6));
                nv.setMatkhau(rs.getString(7));
                nv.setVaitro(rs.getString(8));

                lst.add(nv);
            }
            return lst;
        } catch (SQLException e) {
        }

        return null;
    }

    public NhanVienModel getNhanVien(int manv) throws Exception {
        try {
            String sql = "SELECT *FROM nhanvien WHERE MaNV=?";
            Connection conn = Connect.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, manv);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                NhanVienModel nv = new NhanVienModel();
                nv.setManv(rs.getInt(1));
                nv.setHo(rs.getString(2));
                nv.setTen(rs.getString(3));
                nv.setGioitinh(rs.getString(4));
                nv.setSdt(rs.getString(5));
                nv.setTendangnhap(rs.getString(6));
                nv.setMatkhau(rs.getString(7));
                nv.setVaitro(rs.getString(8));

                return nv;
            }
        } catch (SQLException e) {
        }

        return null;
    }

  public boolean phanQuyen(int manv, String vaitro) throws Exception {
    NhanVienModel nv = getNhanVien(manv);
    String vaiTro = nv.getVaitro();

    try {
        String sql = "UPDATE nhanvien SET vaitro=? WHERE MaNV=?";
        Connection conn = Connect.getConnection();
        PreparedStatement pre = conn.prepareStatement(sql);
        pre.setString(1, vaitro);
        pre.setInt(2, manv);
        pre.executeUpdate();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}
}
