/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import dao.ThongKeDAO;
import java.util.ArrayList;
import model.ThongKeModel;

/**
 *
 * @author HungPhanPC
 */
public class ThongKeBUS {

    public ThongKeDAO thongKeDAO = new ThongKeDAO();
    private ArrayList<Double> doanhThuThang;

    public ThongKeModel thongKe(int nam) throws Exception {
        return (ThongKeModel) thongKeDAO.getThongKe(nam);
    }
}
