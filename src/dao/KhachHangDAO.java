/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import connect.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.KhachHangModel;

/**
 * @author User
 */
public class KhachHangDAO {

    public ArrayList<KhachHangModel> getListKhachHang() throws Exception {
        try {
            String sql = "SELECT * FROM KhachHang";
            Connection conn = Connect.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            ArrayList<KhachHangModel> dskh = new ArrayList<>();
            while (rs.next()) {
                KhachHangModel kh = new KhachHangModel();
                kh.setMakh(rs.getInt(1));
                kh.setHo(rs.getString(2));
                kh.setTen(rs.getString(3));
                kh.setGioitinh(rs.getString(4));
                kh.setTongchitieu(rs.getInt(5));
                dskh.add(kh);
            }
            return dskh;
        } catch (SQLException ex) {
        }
        return null;
    }

    public static ArrayList<KhachHangModel> TimKhachHangTheoTen(String tukhoa) throws Exception {
        ArrayList<KhachHangModel> dskh = new ArrayList<>();
        Connection conn = Connect.getConnection();

        try {

            Statement st = conn.createStatement();
            String sql = "select * from khachhang WHERE Ten like'%" + tukhoa + "%'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                KhachHangModel kh = new KhachHangModel();
                kh.setMakh(rs.getInt(1));
                kh.setHo(rs.getString(2));
                kh.setTen(rs.getString(3));
                kh.setGioitinh(rs.getString(4));
                kh.setTongchitieu(rs.getInt(5));
                dskh.add(kh);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {

            e.printStackTrace();
        }

        return dskh;
    }

    public KhachHangModel getKhachHang(int maKH) throws Exception {
       KhachHangModel kh = null;
        try {
            String sql = "SELECT * FROM khachhang WHERE MaKH=?";
            Connection conn = Connect.getConnection();
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setInt(1, maKH);
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                kh = new KhachHangModel();
                kh.setMakh(rs.getInt(1));
                kh.setHo(rs.getString(2));
                kh.setTen(rs.getString(3));
                kh.setGioitinh(rs.getString(4));
                kh.setTongchitieu(rs.getInt(5));
            }
        } catch (SQLException ex) {
            return null;
        }
        return kh;
    }

    public boolean addKhachHang(KhachHangModel kh) throws SQLException, Exception {

        String sql = "INSERT INTO khachhang(MaKH,Ho,Ten,GioiTinh,TongChiTieu,TinhTrang) VALUES(?,?,?,?,?,1)";
        Connection conn = Connect.getConnection();
        PreparedStatement prep = conn.prepareStatement(sql);
        {
            prep.setInt(1, kh.getMakh());
            prep.setString(2, kh.getHo());
            prep.setString(3, kh.getTen());
            prep.setString(4, kh.getGioitinh());
            prep.setDouble(5, kh.getTongchitieu());
        }
        return prep.executeUpdate() > 0;
    }

    public boolean deleteKhachHang(int maKH) throws Exception {
        boolean result = false;
        try {
            String sql = "DELETE khachhang WHERE MaKH=?";
            Connection conn = Connect.getConnection();
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setInt(1, maKH);
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }

    public boolean updateKhachHang(int maKH, KhachHangModel kh) throws Exception {
        boolean result = false;
        try {
            String sql = "UPDATE khachhang SET Ho=?, Ten=?, GioiTinh=? WHERE MaKH=?";
            Connection conn = Connect.getConnection();
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, kh.getHo());
            prep.setString(2, kh.getTen());
            prep.setString(3, kh.getGioitinh());
            prep.setInt(4, maKH);
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }

    public boolean updateTongChiTieu(int maKH, int tongChiTieu) throws Exception {
        boolean result = false;
        try {
            String sql = "UPDATE khachhang SET TongChiTieu=" + tongChiTieu + " WHERE MaKH=" + maKH;
            Connection conn = Connect.getConnection();
            Statement st = conn.createStatement();
            result = st.executeUpdate(sql) > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }

   
}
