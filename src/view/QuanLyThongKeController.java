/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import beann.KhachHangBean;
import beann.SanPhamBean;
import beann.ThongKeService;
import beann.ThongKeServiceImpl;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author HungPhanPC
 */
public class QuanLyThongKeController {
       private ThongKeService thongKeService = null;

    public QuanLyThongKeController() {
        this.thongKeService = new ThongKeServiceImpl();
    }

    public void setDataToChart1(JPanel jpnItem) {
        List<SanPhamBean> listItem = thongKeService.getListBySanPham();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (listItem != null) {
            for (SanPhamBean item : listItem) {
                dataset.addValue(item.getSoLuong(), "Sản phẩm", item.getMaSP());
            }
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ thống kê số lượng sản phẩm".toUpperCase(),
                "Mã sản phẩm", "Số lượng (Sản phẩm)",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 250));

        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }
    
       public void setDataToChart2(JPanel jpnItem) {
        List<KhachHangBean> listItem = thongKeService.getListByKhachHang();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (listItem != null) {
            for (KhachHangBean item : listItem) {
                dataset.addValue(item.getTongChiTieu(), "Khách h", item.getTenKH());
            }
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ thống kê tổng chi tiêu khách hàng".toUpperCase(),
                "Tên khách hàng", "Tổng chi tiêu (VNĐ)",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 250));

        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }
}
