package dao;



import connect.Connect;
import java.sql.*;
import java.util.ArrayList;
import model.HoaDonModel;

public class HoaDonDAO {
    public ArrayList<HoaDonModel> getListHoaDon() throws Exception {
        ArrayList<HoaDonModel> dshd = new ArrayList<>();
        try {
            String sql = "SELECT * FROM hoadon";
            Connection conn = Connect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                HoaDonModel hd = new HoaDonModel();
                hd.setMahd(rs.getInt(1));
                hd.setMakh(rs.getInt(2));
                hd.setManv(rs.getInt(3));
                hd.setNgaylap(rs.getDate(4));
                hd.setTongtien(rs.getInt(5));
                hd.setGhichu(rs.getString(6));
                dshd.add(hd);
            }
        } catch (SQLException ex) {
            return null;
        }
        return dshd;
    }

    public boolean addHoaDon(HoaDonModel hd) throws Exception {
        boolean result = false;
        try {
            String sql1 = "UPDATE KhachHang SET TongChiTieu=TongChiTieu+" + hd.getTongtien() + " WHERE MaKH=" + hd.getMakh();
            Connection conn = Connect.getConnection();
            Statement st = conn.createStatement();
            st.executeUpdate(sql1);
            String sql = "INSERT INTO hoadon(MaKH, MaNV, NgayLap, TongTien, GhiChu) VALUES(?, ?, ?, ?, ?)";
            
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setInt(1, hd.getMakh());
            prep.setInt(2, hd.getManv());
            prep.setTimestamp(3, new java.sql.Timestamp(new java.util.Date().getTime()));
            prep.setDouble(4, hd.getTongtien());
            prep.setString(5, hd.getGhichu());
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return result;
    }

    public int getMaHoaDonMoiNhat() {
        try {
            String sql = "SELECT MAX(maHD) FROM hoadon";
            Connection conn = Connect.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next())
                return rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public ArrayList<HoaDonModel> getListHoaDon(Date dateMin, Date dateMax) {
        try {
            String sql = "SELECT * FROM hoadon WHERE NgayLap BETWEEN CAST(? AS DATE) AND CAST(? AS DATE)";
           Connection conn = Connect.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setDate(1, dateMin);
            pre.setDate(2, dateMax);
            ResultSet rs = pre.executeQuery();

            ArrayList<HoaDonModel> dshd = new ArrayList<>();

            while (rs.next()) {
                HoaDonModel hd = new HoaDonModel();
                hd.setMahd(rs.getInt(1));
                hd.setMakh(rs.getInt(2));
                hd.setManv(rs.getInt(3));
                hd.setNgaylap(rs.getDate(4));
                hd.setTongtien(rs.getInt(5));
                hd.setGhichu(rs.getString(6));
                dshd.add(hd);
            }
            return dshd;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
