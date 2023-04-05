/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import bus.HoaDonBUS;
import bus.SanPhamBUS;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import model.HoaDonModel;

/**
 *
 * @author HungPhanPC
 */
public class QLHDJFrame extends javax.swing.JFrame {

    private HoaDonBUS hoaDonBUS = new HoaDonBUS();
    DefaultTableModel dtmHoaDon;

    /**
     * Creates new form QLHDJFrame
     */
    public QLHDJFrame() throws Exception {
        initComponents();
        setExtendedState(QLHDJFrame.MAXIMIZED_BOTH);
        loadDataListHoaDon();
        addEvents();
        fmfMaHD.setEnabled(false);
        fmfMaKH.setEnabled(false);
        fmfMaNV.setEnabled(false);
        txtGhiChu.setEnabled(false);
        fmfTongTien.setEnabled(false);
        txtNgayLap.setEnabled(false);
        setTitle("Phần mềm bán Pizza mang về");
        ImageIcon image = new ImageIcon("D:\\NetBeansProjects\\qlpizzamvc\\src\\Main\\Resources\\Images\\Icon\\sanpham-pizza.png");
        setIconImage(image.getImage());

    }
    DecimalFormat dcf = new DecimalFormat("###,###");

    private void loadDataListHoaDon() throws Exception {
        ArrayList<HoaDonModel> dshd = hoaDonBUS.getListHoaDon();
        addDataListHoaDon(dshd);
    }

    private void addDataListHoaDon(ArrayList<HoaDonModel> dshd) {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        if (dshd != null) {
            for (HoaDonModel hd : dshd) {
                listModel.addElement(hd.getMahd() + " | " + hd.getNgaylap() + " | Thành tiền là : " + dcf.format(hd.getTongtien()) + " VND");
            }
            lstHoaDon.setModel(listModel);
        }
    }

    private void xuLyTimTheoKhoangNgay() throws Exception {
        ArrayList<HoaDonModel> lstHoaDon = hoaDonBUS.getListHoaDonTheoNgay(txtMinNgayLap.getText(), txtMaxNgayLap.getText());

        addDataListHoaDon(lstHoaDon);
    }

    private void xuLyTimTheoKhoangGia() throws Exception {
        ArrayList<HoaDonModel> listHoaDon = hoaDonBUS.getListHoaDonTheoGia(fmfMinSearch.getText(), fmfMaxSearch.getText());
        addDataListHoaDon(listHoaDon);
    }

    private void xuLyResetData() throws Exception {
        loadDataListHoaDon();
        txtMaxNgayLap.setText("");
        txtMinNgayLap.setText("");
        fmfMaxSearch.setText("");
        fmfMinSearch.setText("");
    }

    private void addEvents() {
        fmfMinSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fmfMaxSearch.requestFocus();
            }
        });

        fmfMaxSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    xuLyTimTheoKhoangGia();
                } catch (Exception ex) {
                    Logger.getLogger(QLHDJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        txtMinNgayLap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtMaxNgayLap.requestFocus();
            }
        });

        txtMaxNgayLap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    xuLyTimTheoKhoangNgay();
                } catch (Exception ex) {
                    Logger.getLogger(QLHDJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private void xuLyHienlstHoaDon() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String hoaDon = lstHoaDon.getSelectedValue();
        String[] stMaHD = hoaDon.split(" | ");

        HoaDonModel hd = hoaDonBUS.getHoaDon(stMaHD[0]);
        fmfMaHD.setText(hd.getMahd() + "");
        fmfMaKH.setText(hd.getMakh() + "");
        fmfMaNV.setText(hd.getManv() + "");

        txtNgayLap.setText(sdf.format(hd.getNgaylap()));
        fmfTongTien.setText(dcf.format(hd.getTongtien()));
        txtGhiChu.setText(hd.getGhichu());

        // Gọi hiển thị data trên tblCTHoaDon
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtNgayLap = new javax.swing.JTextField();
        txtGhiChu = new javax.swing.JTextField();
        fmfMaHD = new javax.swing.JFormattedTextField();
        fmfMaKH = new javax.swing.JFormattedTextField();
        fmfMaNV = new javax.swing.JFormattedTextField();
        fmfTongTien = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        txtMinNgayLap = new javax.swing.JTextField();
        txtMaxNgayLap = new javax.swing.JTextField();
        fmfMinSearch = new javax.swing.JFormattedTextField();
        fmfMaxSearch = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstHoaDon = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.CardLayout());

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(985, 700));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("đến :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(23, 5, 23, 5);
        jPanel2.add(jLabel2, gridBagConstraints);

        jLabel3.setBackground(new java.awt.Color(255, 102, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mã hóa đơn :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(23, 18, 23, 18);
        jPanel2.add(jLabel3, gridBagConstraints);

        jLabel4.setBackground(new java.awt.Color(255, 102, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mã khách hàng :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(23, 18, 23, 18);
        jPanel2.add(jLabel4, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Ngày lập :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(23, 18, 23, 18);
        jPanel2.add(jLabel5, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nhân viên lập :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(23, 18, 23, 18);
        jPanel2.add(jLabel6, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tổng tiền :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(23, 18, 23, 18);
        jPanel2.add(jLabel7, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Ghi chú :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(23, 18, 23, 18);
        jPanel2.add(jLabel8, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Giá từ :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(23, 5, 23, 5);
        jPanel2.add(jLabel9, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("THÔNG TIN HÓA ĐƠN ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(23, 18, 23, 18);
        jPanel2.add(jLabel10, gridBagConstraints);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Ngày lập từ :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(23, 5, 23, 5);
        jPanel2.add(jLabel11, gridBagConstraints);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("đến :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(23, 5, 23, 5);
        jPanel2.add(jLabel12, gridBagConstraints);

        txtNgayLap.setColumns(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(23, 18, 23, 18);
        jPanel2.add(txtNgayLap, gridBagConstraints);

        txtGhiChu.setColumns(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(23, 18, 23, 18);
        jPanel2.add(txtGhiChu, gridBagConstraints);

        fmfMaHD.setColumns(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(23, 6, 23, 6);
        jPanel2.add(fmfMaHD, gridBagConstraints);

        fmfMaKH.setColumns(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(23, 18, 23, 18);
        jPanel2.add(fmfMaKH, gridBagConstraints);

        fmfMaNV.setColumns(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(23, 18, 23, 18);
        jPanel2.add(fmfMaNV, gridBagConstraints);

        fmfTongTien.setColumns(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(23, 18, 23, 18);
        jPanel2.add(fmfTongTien, gridBagConstraints);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/Resources/Images/Icon/Refresh-icon.png"))); // NOI18N
        jButton1.setText("Đặt lại");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.insets = new java.awt.Insets(23, 5, 23, 5);
        jPanel2.add(jButton1, gridBagConstraints);

        txtMinNgayLap.setColumns(15);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(23, 5, 23, 5);
        jPanel2.add(txtMinNgayLap, gridBagConstraints);

        txtMaxNgayLap.setColumns(15);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(23, 5, 23, 5);
        jPanel2.add(txtMaxNgayLap, gridBagConstraints);

        fmfMinSearch.setColumns(15);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(23, 5, 23, 5);
        jPanel2.add(fmfMinSearch, gridBagConstraints);

        fmfMaxSearch.setColumns(15);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(23, 5, 23, 5);
        jPanel2.add(fmfMaxSearch, gridBagConstraints);

        jPanel1.add(jPanel2, "card2");

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        lstHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lstHoaDon.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(lstHoaDon);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setBackground(new java.awt.Color(255, 102, 0));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("QUẢN LÝ HÓA ĐƠN");
        jPanel3.add(jLabel13);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            xuLyResetData();
        } catch (Exception ex) {
            Logger.getLogger(QLHDJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lstHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstHoaDonMouseClicked
        try {
            // TODO add your handling code here:
            xuLyHienlstHoaDon();
        } catch (Exception ex) {
            Logger.getLogger(QLHDJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lstHoaDonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QLHDJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLHDJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLHDJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLHDJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new QLHDJFrame().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(QLHDJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField fmfMaHD;
    private javax.swing.JFormattedTextField fmfMaKH;
    private javax.swing.JFormattedTextField fmfMaNV;
    private javax.swing.JFormattedTextField fmfMaxSearch;
    private javax.swing.JFormattedTextField fmfMinSearch;
    private javax.swing.JFormattedTextField fmfTongTien;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lstHoaDon;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtMaxNgayLap;
    private javax.swing.JTextField txtMinNgayLap;
    private javax.swing.JTextField txtNgayLap;
    // End of variables declaration//GEN-END:variables
}