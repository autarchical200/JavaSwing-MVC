/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connect.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.ThongKeModel;

/**
 *
 * @author HungPhanPC
 */
public class ThongKeDAO {
     public ThongKe getThongKe(int nam) throws Exception {
         ThongKeModel thongKe = new ThongKeModel();
        thongKe.setSoLuongSP(getTongSoLuongSP());
        thongKe.setSoLuongKH(getSoLuongKhachHang());
        thongKe.setSoLuongNV(getSoLuongNhanVien());
        return (ThongKe) thongKe;
    }

    public int getTongSoLuongSP() throws Exception {
        try {
            Connection conn = Connect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM sanpham");
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            return -1;
        }
        return 0;
    }

    public int getSoLuongNhanVien() throws Exception {
        try {
            Connection conn = Connect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM nhanvien");
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            return -1;
        }
        return 0;
    }
        public double getDoanhThu() throws Exception {
        try {
            String sql = "SELECT SUM(TongTien) FROM HoaDon";
            Connection conn = Connect.getConnection();
            PreparedStatement pre =conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                return Double.parseDouble(rs.getInt(1) + "");
            }
        } catch (SQLException ex) {
            return -1;
        }
        return 0;
    }

    public int getSoLuongKhachHang() throws Exception {
        try {
            Connection conn = Connect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM khachhang");
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            return -1;
        }
        return 0;
    }
}
