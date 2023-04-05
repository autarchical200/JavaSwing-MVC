/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;


import MyCustom.MyDialog;
import dao.SanPhamDAO;
import java.util.ArrayList;
import model.SanPhamModel;

/**
 *
 * @author Hung
 */
public class SanPhamBUS {

    private ArrayList<SanPhamModel> listSanPham = null;
    private SanPhamDAO spDAO = new SanPhamDAO();

    public SanPhamBUS() throws Exception {
        docListSanPham();
    }

    public void docListSanPham() throws Exception {
        listSanPham = spDAO.getListSanPham();
    }

    public ArrayList<SanPhamModel> getListSanPham() throws Exception {
        if (listSanPham == null) {
            docListSanPham();
        }
        return listSanPham;
    }

    public ArrayList<SanPhamModel> getSanPhamTheoLoai(String ma) {
        if (!ma.trim().equals("")) {
            ArrayList<SanPhamModel> dssp = new ArrayList<>();
            try {
                int maLoai = Integer.parseInt(ma);
                for (SanPhamModel sp : listSanPham) {
                    if (sp.getMaloai() == maLoai) {
                        dssp.add(sp);
                    }
                }
                return dssp;
            } catch (Exception e) {
            }
        }
        return null;
    }

    public SanPhamModel getSanPham(String ma) {
        if (!ma.trim().equals("")) {
            try {
                int maSP = Integer.parseInt(ma);
                for (SanPhamModel sp : listSanPham) {
                    if (sp.getMasp() == maSP) {
                        return sp;
                    }
                }
            } catch (Exception e) {
            }
        }
        return null;
    }

    public ArrayList<SanPhamModel> getSanPhamTheoTen(String ten) {
        ArrayList<SanPhamModel> dssp = new ArrayList<>();
        for (SanPhamModel sp : listSanPham) {
            String tenSP = sp.getTensp().toLowerCase();
            if (tenSP.toLowerCase().contains(ten.toLowerCase())) {
                dssp.add(sp);
            }

        }
        return dssp;
    }

    public String getAnh(String ma) throws Exception {
        int maSP = Integer.parseInt(ma);
        return spDAO.getAnh(maSP);
    }

    public void capNhatSoLuongSP(int ma, int soLuongMat) throws Exception {
        spDAO.capNhatSoLuongSP(ma, soLuongMat);
    }

    public boolean xoaSanPham(String ma) throws Exception {
//        if (ma.trim().equals("")) {
//            new MyDialog("Chưa chọn sản phẩm để xoá!", MyDialog.ERROR_DIALOG);
//            return false;
//        }

        int maSP = Integer.parseInt(ma);
        if (spDAO.xoaSanPham(maSP)) {
//            new MyDialog("Xoá thành công!", MyDialog.SUCCESS_DIALOG);
            return true;
        }

        new MyDialog("Xoá thành công!", MyDialog.SUCCESS_DIALOG);
        return false;
    }

    public boolean themSanPham(String masp, String ten,
            String loai,
            String soLuong,
            String donViTinh,
            String anh,
            String donGia) throws Exception {

        if (masp.trim().equals("")) {
            new MyDialog("Mã SP không được để rỗng!", MyDialog.ERROR_DIALOG);
            return false;
        }

        if (ten.trim().equals("")) {
            new MyDialog("Tên SP không được để rỗng!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (loai.trim().equals("")) {
            new MyDialog("Vui lòng điền Mã loại!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (soLuong.trim().equals("")) {
            new MyDialog("Vui lòng điền Số lượng sp!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (donViTinh.trim().equals("")) {
            new MyDialog("Vui lòng điền Đơn vị tính!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (donGia.trim().equals("")) {
            new MyDialog("Vui lòng điền giá!", MyDialog.ERROR_DIALOG);
            return false;
        }
        int maSp = Integer.parseInt(masp);
        int maLoai = Integer.parseInt(loai);
        int soLuongSP = Integer.parseInt(soLuong);
        donGia = donGia.replace(",", "").replace(".", "");
        float donGiaSP = Float.parseFloat(donGia);
        SanPhamModel sp = new SanPhamModel();
        sp.setMasp(maSp);
        sp.setTensp(ten);
        sp.setMaloai(maLoai);
        sp.setSoluong(soLuongSP);
        sp.setDonvitinh(donViTinh);
        sp.setHinhanh(anh);
        sp.setDongia(donGiaSP);

        if (spDAO.insert(sp)) {
            new MyDialog("Thêm thành công!", MyDialog.SUCCESS_DIALOG);
            return true;
        } else {
            new MyDialog("Thêm thất bại!", MyDialog.ERROR_DIALOG);
            return false;
        }

    }

    public boolean suaSanPham(String ma,
            String ten,
            String loai,
            String soLuong,
            String donViTinh,
            String anh,
            String donGia) {

        try {
            if (ma.trim().equals("")) {
                new MyDialog("Chưa chọn sản phẩm để sửa!", MyDialog.ERROR_DIALOG);
                return false;
            }
            int maSP = Integer.parseInt(ma);
            int maLoai = Integer.parseInt(loai);
            int soLuongSP = Integer.parseInt(soLuong);

            if (maLoai == 0) {
                new MyDialog("Vui lòng chọn Loại sản phẩm!", MyDialog.ERROR_DIALOG);
                return false;
            }

            if (ten.trim().equals("")) {
                new MyDialog("Tên SP không được để rỗng!", MyDialog.ERROR_DIALOG);
                return false;
            }

            if (donViTinh.trim().equals("")) {
                new MyDialog("Vui lòng điền Đơn vị tính!", MyDialog.ERROR_DIALOG);
                return false;
            }

            SanPhamModel sp = new SanPhamModel();
            sp.setMasp(maSP);
            sp.setTensp(ten);
            sp.setMaloai(maLoai);
            sp.setSoluong(soLuongSP);
            sp.setDonvitinh(donViTinh);
            sp.setHinhanh(anh);
            donGia = donGia.replace(".", "");
            float donGiaSP = Float.parseFloat(donGia);
            sp.setDongia(donGiaSP);

            if (spDAO.suaSanPham(sp)) {
                new MyDialog("Sửa thành công!", MyDialog.SUCCESS_DIALOG);
                return true;
            } else {
                new MyDialog("Sửa thất bại!", MyDialog.ERROR_DIALOG);
                return false;
            }
        } catch (Exception e) {
            new MyDialog("Nhập số hợp lệ cho Đơn giá và Số lượng!", MyDialog.ERROR_DIALOG);
        }
        return false;
    }

    public boolean nhapSanPhamTuExcel(String masp, String ten,
            String loai,
            String soLuong,
            String donViTinh,
            String anh,
            String donGia) {

        try {
            int maSP = Integer.parseInt(masp);
            int maLoai = Integer.parseInt(loai);
            int soLuongSP = Integer.parseInt(soLuong);
            donGia = donGia.replace(",", "");
            int donGiaSP = Integer.parseInt(donGia);

            SanPhamModel sp = new SanPhamModel();
            sp.setMasp(maSP);
            sp.setTensp(ten);
            sp.setMaloai(maLoai);
            sp.setSoluong(soLuongSP);
            sp.setDonvitinh(donViTinh);
            sp.setHinhanh(anh);
            sp.setDongia(donGiaSP);

            spDAO.nhapSanPhamTuExcel(sp);
        } catch (Exception e) {
        }
        return false;
    }

    public String getTenSP(int maSP) {
        for (SanPhamModel sp : listSanPham) {
            if (sp.getMasp() == maSP) {
                return sp.getTensp();
            }
        }
        return "";
    }
}
