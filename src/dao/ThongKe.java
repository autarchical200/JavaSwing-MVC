/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beann.KhachHangBean;
import beann.SanPhamBean;
import java.util.List;

/**
 *
 * @author HungPhanPC
 */
public interface ThongKe {
    public List<SanPhamBean> getListBySanPham();
    public List<KhachHangBean> getListKhachHang();
}
