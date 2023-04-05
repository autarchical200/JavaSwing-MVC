package bus;



import MyCustom.MyDialog;
import dao.HoaDonDAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.HoaDonModel;

public class HoaDonBUS {

    private ArrayList<HoaDonModel> listHoaDon;
    private HoaDonDAO hoaDonDAO = new HoaDonDAO();

    public ArrayList<HoaDonModel> getListHoaDon() throws Exception {
        listHoaDon = hoaDonDAO.getListHoaDon();
        return listHoaDon;
    }

    public void luuHoaDon(int maKH, String nhanVien, int tongTien, String ghiChu) throws Exception {
        HoaDonModel hd = new HoaDonModel();
        String[] arrNV = nhanVien.split(" - ");
        int maNV = Integer.parseInt(arrNV[0]);
        hd.setManv(maNV);
        hd.setMakh(maKH);
        hd.setGhichu(ghiChu);
        hd.setTongtien(tongTien);

        hoaDonDAO.addHoaDon(hd);
    }

    public int getMaHoaDonMoiNhat() {
        return hoaDonDAO.getMaHoaDonMoiNhat();
    }

    public HoaDonModel getHoaDon(String maHD) {
        int ma = Integer.parseInt(maHD);
        for (HoaDonModel hd : listHoaDon) {
            if (hd.getMahd() == ma)
                return hd;
        }
        return null;
    }

    public ArrayList<HoaDonModel> getListHoaDonTheoGia(String min, String max) {
        try {
            int minPrice = Integer.parseInt(min);
            int maxPrice = Integer.parseInt(max);
            ArrayList<HoaDonModel> dshd = new ArrayList<>();
            for (HoaDonModel hd : listHoaDon) {
                if (hd.getTongtien() > minPrice && hd.getTongtien() < maxPrice)
                    dshd.add(hd);
            }
            return dshd;
        } catch (Exception e) {
            new MyDialog("Hãy nhập khoảng giá hợp lệ", MyDialog.ERROR_DIALOG);
        }
        return null;
    }

    public ArrayList<HoaDonModel> getListHoaDonTheoNgay(String min, String max) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date minDate = sdf.parse(min);
            Date maxDate = sdf.parse(max);

            java.sql.Date dateMin = new java.sql.Date(minDate.getTime());
            java.sql.Date dateMax = new java.sql.Date(maxDate.getTime());

            ArrayList<HoaDonModel> dshd = hoaDonDAO.getListHoaDon(dateMin, dateMax);
            return dshd;
        } catch (Exception e) {
            new MyDialog("Hãy nhập khoảng ngày hợp lệ!", MyDialog.ERROR_DIALOG);
        }
        return null;
    }
}
