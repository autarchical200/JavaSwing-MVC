/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
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
import model.SanPhamModel;

/**
 *
 * @author Hung
 */
public class SanPhamDAO {

    public ArrayList<SanPhamModel> getListSanPham() throws Exception {
        try {
            String sql = "SELECT * FROM sanpham";
            Connection conn = Connect.getConnection();
            PreparedStatement prst = conn.prepareStatement(sql);
            ResultSet rs = prst.executeQuery();
            ArrayList<SanPhamModel> lst = new ArrayList<>();
            while (rs.next()) {
                SanPhamModel sp = new SanPhamModel();

                sp.setMasp(rs.getInt(1));
                sp.setTensp(rs.getString(2));
                sp.setMaloai(rs.getInt(3));
                sp.setSoluong(rs.getInt(4));
                sp.setDonvitinh(rs.getString(5));
                sp.setHinhanh(rs.getString(6));
                sp.setDongia(rs.getFloat(7));

                lst.add(sp);
            }
            return lst;
        } catch (SQLException e) {
        }

        return null;
    }

    public static ArrayList<SanPhamModel> getALL() throws Exception {
        ArrayList<SanPhamModel> lst = new ArrayList<>();
        Connection conn = Connect.getConnection();

        try {

            Statement st = conn.createStatement();
            String sql = "select * from sanpham";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                SanPhamModel sp = new SanPhamModel();
                sp.setMasp(rs.getInt(1));
                sp.setTensp(rs.getString(2));
                sp.setMaloai(rs.getInt(3));
                sp.setSoluong(rs.getInt(4));
                sp.setDonvitinh(rs.getString(5));
                sp.setHinhanh(rs.getString(6));
                sp.setDongia(rs.getFloat(7));

                lst.add(sp);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {

            e.printStackTrace();
        }

        return lst;
    }

    public String getAnh(int ma) throws Exception {
        try {
            String sql = "SELECT hinhanh FROM SanPham WHERE masp=?";
            Connection conn = Connect.getConnection();
            PreparedStatement prst = conn.prepareStatement(sql);
            prst.setInt(1, ma);
            ResultSet rs = prst.executeQuery();
            if (rs.next()) {
                return rs.getString("HinhAnh");
            }
        } catch (SQLException e) {
        }
        return "";
    }

    public boolean insert(SanPhamModel spham) throws Exception {
        String sql = "insert into sanpham(MaSP,TenSP,MaLoai,SoLuong,DonViTinh,HinhAnh,DonGia) VALUES(?,?,?,?,?,?,?)";
        Connection conn = Connect.getConnection();
        PreparedStatement prst = conn.prepareStatement(sql);
        {
            prst.setString(1, String.valueOf(spham.getMasp()));
            prst.setString(2, spham.getTensp());
            prst.setString(3, String.valueOf(spham.getMaloai()));
            prst.setString(4, String.valueOf(spham.getSoluong()));
            prst.setString(5, spham.getDonvitinh());
            prst.setString(6, spham.getHinhanh());
            prst.setString(7, String.valueOf(spham.getDongia()));
        }
        return prst.executeUpdate() > 0;
    }

    public boolean xoaSanPham(int maSP) throws Exception {
        try {
            String sql = "DELETE FROM sanpham WHERE MaSP=" + maSP;
            Connection conn = Connect.getConnection();
            Statement st = conn.createStatement();
            st.execute(sql);
            return st.execute(sql);
        } catch (SQLException e) {
        }
        return false;
    }

public boolean suaSanPham(SanPhamModel spham) throws Exception {
    try {
        String sql = "UPDATE sanpham SET "
                + "TenSP=?, "
                + "MaLoai=?, SoLuong=?, DonViTinh=?, HinhAnh=?, DonGia=? "
                + "WHERE MaSP=?";
        Connection conn = Connect.getConnection();
        PreparedStatement prst = conn.prepareStatement(sql);
        prst.setString(1, spham.getTensp());
        prst.setInt(2, spham.getMaloai());
        prst.setInt(3, spham.getSoluong());
        prst.setString(4, spham.getDonvitinh());
        prst.setString(5, spham.getHinhanh());
        prst.setFloat(6, spham.getDongia());
        prst.setInt(7, spham.getMasp());
        prst.executeUpdate();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}
    public boolean nhapSanPhamTuExcel(SanPhamModel sp) throws Exception {
        try {
            String sql = "DELETE * FROM SanPham; "
                    + "INSERT INTO SanPham(TenSP, MaLoai, SoLuong, DonViTinh, HinhAnh, DonGia) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            Connection conn = Connect.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, sp.getTensp());
            pre.setInt(2, sp.getMaloai());
            pre.setInt(3, sp.getSoluong());
            pre.setString(4, sp.getDonvitinh());
            pre.setString(5, sp.getHinhanh());
            pre.setDouble(6, sp.getDongia());

            pre.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public SanPhamModel getSanPham(int ma) throws Exception {
        try {
            String sql = "SELECT *FROM SanPham WHERE MaSP=?";
            Connection conn = Connect.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, ma);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                SanPhamModel sp = new SanPhamModel();

                sp.setMasp(rs.getInt(1));
                sp.setTensp(rs.getString(2));
                sp.setMaloai(rs.getInt(3));
                sp.setSoluong(rs.getInt(4));
                sp.setDonvitinh(rs.getString(5));
                sp.setHinhanh(rs.getString(6));
                sp.setDongia(rs.getFloat(7));

                return sp;
            }
        } catch (SQLException e) {
        }

        return null;
    }

    public void capNhatSoLuongSP(int ma, int soLuongMat) throws Exception {
        SanPhamModel sp = getSanPham(ma);
        int soLuong = sp.getSoluong();
        sp.setSoluong(soLuong + soLuongMat);
        try {
            String sql = "UPDATE sanpham SET SoLuong=? WHERE MaSP=" + ma;
            Connection conn = Connect.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, sp.getSoluong());
            pre.executeUpdate();
        } catch (SQLException e) {
        }

    }

    public static ArrayList<SanPhamModel> TimSanPhamTheoTen(String ten) throws Exception {
        ArrayList<SanPhamModel> lst = new ArrayList<>();
        Connection conn = Connect.getConnection();

        try {

            Statement st = conn.createStatement();
            String sql = "select * from sanpham WHERE TenSP like'%" + ten + "%'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                SanPhamModel sp = new SanPhamModel();
                sp.setMasp(rs.getInt(1));
                sp.setTensp(rs.getString(2));
                sp.setMaloai(rs.getInt(3));
                sp.setSoluong(rs.getInt(4));
                sp.setDonvitinh(rs.getString(5));
                sp.setHinhanh(rs.getString(6));
                sp.setDongia(rs.getFloat(7));

                lst.add(sp);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst;
    }

}
