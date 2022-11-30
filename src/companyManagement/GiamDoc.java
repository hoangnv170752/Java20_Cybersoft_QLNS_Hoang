package companyManagement;

import static java.lang.Double.*;
import static java.lang.String.*;
import static support.constant.*;
import static support.support.*;

public class GiamDoc extends NhanSu {
    // #region Fields
    private double coPhan;
    private double thuNhap;
    private final String chucVu = "giám đốc";
    private final double luongNgay = 300;

    @Override
    public void tinhLuong() {
        luongThang = soNgayLamViec * luongNgay;
    }

    public void nhapCoPhan() {
        printAdv(GREEN, "Cổ phần: ", RESET);
        coPhan = numLimit(0, MAX_VALUE);
    }

    @Override
    public void nhapNhanSu() {
        super.nhapNhanSu();
        nhapCoPhan();
        tinhLuong();
    }

    public void xuatCoPhan() {
        printlnAdv(format("Cổ phần: %s%%", writePerfectDub(coPhan)));
    }

    public void xuatThuNhap() {
        printlnAdv(format("Thu nhập: %,.0f", thuNhap));
    }

    @Override
    public void xuatChucVu() {
        printlnAdv(format("Chức vụ: %s", chucVu));
    }

    @Override
    public void xuatLuongThang() {
        printlnAdv(String.format("Lương tháng: %,.0f", luongThang));
    }

    @Override
    public void xuatNhanSu() {
        super.xuatMaNhanVien();
        super.xuatHoTen();
        super.xuatSoDienThoai();
        xuatChucVu();
        xuatCoPhan();
        super.xuatSoNgayLamViec();
        xuatLuongThang();
    }

    public double getCoPhan() {
        return coPhan;
    }

    public void setCoPhan(double coPhan) {
        this.coPhan = coPhan;
    }

    public double getThuNhap() {
        return thuNhap;
    }

    public void setThuNhap(double thuNhap) {
        this.thuNhap = thuNhap;
    }
}
