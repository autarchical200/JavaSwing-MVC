/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beann;

import dao.ThongKe;
import dao.ThongKeDaoImpl;
import java.util.List;

/**
 *
 * @author HungPhanPC
 */
public class ThongKeServiceImpl implements ThongKeService {
private ThongKe thongKe = null;
    @Override
    public List<SanPhamBean> getListBySanPham(){
        return thongKe.getListBySanPham();
    }

    @Override
    public List<KhachHangBean> getListByKhachHang() {
       return thongKe.getListKhachHang();
    }

   
    public ThongKeServiceImpl() {
        this.thongKe = new ThongKeDaoImpl();
    }

}
