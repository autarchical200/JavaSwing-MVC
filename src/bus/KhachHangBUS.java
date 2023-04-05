package bus;

import MyCustom.MyDialog;
import dao.KhachHangDAO;

import java.util.ArrayList;
import java.util.Locale;
import model.KhachHangModel;

public class KhachHangBUS {

    private ArrayList<KhachHangModel> listKhachHang = null;
    private KhachHangDAO khachHangDAO = new KhachHangDAO();

    public void docDanhSach() throws Exception {
        this.listKhachHang = khachHangDAO.getListKhachHang();
    }

    public ArrayList<KhachHangModel> getListKhachHang() throws Exception {
        if (listKhachHang == null) {
            docDanhSach();
        }
        return listKhachHang;
    }

    public ArrayList<KhachHangModel> timKiemKhachHang(String txtMin, String txtMax) {
        if (txtMax.trim().equals("") && txtMin.trim().equals("")) {
            return listKhachHang;
        }
        try {
            ArrayList<KhachHangModel> dskh = new ArrayList<>();
            txtMin = txtMin.replace(",", "");
            txtMax = txtMax.replace(",", "");
            int min = Integer.parseInt(txtMin);
            int max = Integer.parseInt(txtMax);
            for (KhachHangModel kh : listKhachHang) {
                if (kh.getTongchitieu() >= min && kh.getTongchitieu() <= max) {
                    dskh.add(kh);
                }
            }
            return dskh;
        } catch (Exception e) {
            new MyDialog("Hãy nhập giá trị nguyên phù hợp!", MyDialog.ERROR_DIALOG);
        }
        return null;
    }

    public ArrayList<KhachHangModel> timKiemKhachHang(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<KhachHangModel> dskh = new ArrayList<>();
        for (KhachHangModel kh : listKhachHang) {
            String ho = kh.getHo().toLowerCase();
            String ten = kh.getTen().toLowerCase();
            String gioiTinh = kh.getGioitinh().toLowerCase();
            if (ho.contains(tuKhoa) || ten.contains(tuKhoa) || gioiTinh.contains(tuKhoa)) {
                dskh.add(kh);
            }
        }
        return dskh;
    }

        public boolean themKhachHang2(String ho, String ten, String gioiTinh) throws Exception {
        if (ten.trim().equals("")) {
            new MyDialog("Không được để trống tên!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (gioiTinh.equals("Chọn giới tính")) {
            new MyDialog("Hãy chọn giới tính!", MyDialog.ERROR_DIALOG);
            return false;
        }
        KhachHangModel kh = new KhachHangModel();
        kh.setHo(ho);
        kh.setTen(ten);
        kh.setGioitinh(gioiTinh);
        kh.setTongchitieu(0);
        boolean flag = khachHangDAO.addKhachHang(kh);
        if (flag) {
            new MyDialog("Thêm thành công!", MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Thêm thất bại!", MyDialog.ERROR_DIALOG);
        }
        return flag;
    }
    public boolean themKhachHang(String makh,String ho, String ten, String gioiTinh,String tongchitieu) throws Exception {
       
         if (makh.trim().equals("")) {
            new MyDialog("Không được để trống mã!", MyDialog.ERROR_DIALOG);
            return false;
        }
         if (ho.trim().equals("")) {
            new MyDialog("Không được để trống họ!", MyDialog.ERROR_DIALOG);
            return false;
        }
        
        
        if (ten.trim().equals("")) {
            new MyDialog("Không được để trống tên!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (gioiTinh.equals("Chọn giới tính")) {
            new MyDialog("Hãy chọn giới tính!", MyDialog.ERROR_DIALOG);
            return false;
        }
         if (tongchitieu.trim().equals("")) {
            new MyDialog("Không được để trống tổng chi tiêu!", MyDialog.ERROR_DIALOG);
            return false;
        }
        KhachHangModel kh = new KhachHangModel();
        int maKH = Integer.parseInt(makh);
        int tongChiTieu = Integer.parseInt(tongchitieu);
        kh.setMakh(maKH);
        kh.setHo(ho);
        kh.setTen(ten);
        kh.setGioitinh(gioiTinh);
        kh.setTongchitieu(tongChiTieu);
        boolean flag = khachHangDAO.addKhachHang(kh);
        if (flag) {
            new MyDialog("Thêm thành công!", MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Thêm thất bại!", MyDialog.ERROR_DIALOG);
        }
        return flag;
    }


    public boolean suaKhachHang(String ma, String ho, String ten, String gioiTinh) throws Exception {
        if (ten.trim().equals("")) {
            new MyDialog("Không được để trống tên!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (gioiTinh.equals("Chọn giới tính")) {
            new MyDialog("Hãy chọn giới tính!", MyDialog.ERROR_DIALOG);
            return false;
        }
        KhachHangModel kh = new KhachHangModel();
        kh.setHo(ho);
        kh.setTen(ten);
        kh.setGioitinh(gioiTinh);
        boolean flag = khachHangDAO.updateKhachHang(Integer.parseInt(ma), kh);
        if (flag) {
            new MyDialog("Sửa thành công!", MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Sửa thất bại!", MyDialog.ERROR_DIALOG);
        }
        return flag;
    }

    public boolean xoaKhachHang(String ma) {
        boolean flag = false;
        try {
            int maKH = Integer.parseInt(ma);
            MyDialog dlg = new MyDialog("Bạn có chắc chắn muốn xoá?", MyDialog.WARNING_DIALOG);
            if (dlg.getAction() == MyDialog.CANCEL_OPTION) {
                return false;
            }
            flag = khachHangDAO.deleteKhachHang(maKH);
        } catch (Exception e) {
            new MyDialog("Chưa chọn khách hàng!", MyDialog.ERROR_DIALOG);
        }
        if (flag) {
            new MyDialog("Xoá thành công!", MyDialog.SUCCESS_DIALOG);
        }
//        else {
//            new MyDialog("Xoá thất bại!", MyDialog.ERROR_DIALOG);
//        }
        return flag;
    }
}
