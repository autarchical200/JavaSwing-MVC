/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beann.KhachHangBean;
import beann.SanPhamBean;
import connect.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HungPhanPC
 */
public class ThongKeDaoImpl implements ThongKe {

    public ThongKeDaoImpl() {
    }
    
    public List<SanPhamBean> getListBySanPham() {
        try {
            Connection conn = Connect.getConnection();
            String sql = "SELECT MaSP as ma_sp,SoLuong as so_luong FROM sanpham;";
            List<SanPhamBean> list = new ArrayList<>();
            try {
                PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    SanPhamBean sanPhamBean = new SanPhamBean();
                    sanPhamBean.setMaSP(rs.getString("ma_sp"));
                    sanPhamBean.setSoLuong(rs.getInt("so_luong"));
                    list.add(sanPhamBean);
                }
                ps.close();
                conn.close();
                return list;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        } catch (Exception e) {
        }
        return null;
    }

    public List<KhachHangBean> getListKhachHang() {
                try {
            Connection conn = Connect.getConnection();
            String sql = "SELECT Ten as ten_kh,TongChiTieu as tong_chi_tieu FROM khachhang;";
            List<KhachHangBean> list = new ArrayList<>();
            try {
                PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    KhachHangBean khachHangBean = new KhachHangBean();
                    khachHangBean.setTenKH(rs.getString("ten_kh"));
                    khachHangBean.setTongChiTieu(rs.getInt("tong_chi_tieu"));
                    list.add(khachHangBean);
                }
                ps.close();
                conn.close();
                return list;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        } catch (Exception e) {
        }
        return null;
    }
}
