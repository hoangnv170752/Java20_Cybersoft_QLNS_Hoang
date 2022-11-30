package companyManagement;

import companyManagement.NhanSu;

import static java.lang.String.*;
import static support.support.*;

public class TruongPhong extends NhanSu {
    private int soThanhVien;
    private final String chucVu = "trưởng phòng";
    private final double luongNgay = 200;
    @Override
    public void tinhLuong() {
        luongThang = soNgayLamViec * luongNgay + 100 * soThanhVien;
    }

    public void xuatSoThanhVien() {
        printlnAdv(format("Số thành viên: %d", soThanhVien));
    }

    @Override
    public void xuatChucVu() {
        printlnAdv(format("Chức vụ: %s", chucVu));
    }

    @Override
    public void xuatLuongThang() {
        printlnAdv(format("Lương tháng: %,.0f", luongThang));
    }

    @Override
    public void xuatNhanSu() {
        super.xuatMaNhanVien();
        super.xuatHoTen();
        super.xuatSoDienThoai();
        xuatChucVu();
        xuatSoThanhVien();
        super.xuatSoNgayLamViec();
        xuatLuongThang();
    }

    public int getSoThanhVien() {
        return soThanhVien;
    }

    public void setSoThanhVien(int soThanhVien) {
        this.soThanhVien = soThanhVien;
    }
}
