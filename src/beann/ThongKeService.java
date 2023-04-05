/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beann;
import java.util.List;

/**
 *
 * @author HungPhanPC
 */
public interface ThongKeService {
    
    public List<SanPhamBean> getListBySanPham();
    public List<KhachHangBean> getListByKhachHang();
    
}
