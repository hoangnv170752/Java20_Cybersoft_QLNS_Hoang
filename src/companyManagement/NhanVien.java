package companyManagement;

import companyManagement.NhanSu;

import java.util.*;

import static java.lang.String.*;
import static java.lang.System.*;
import static support.constant.*;
import static support.support.*;

public class NhanVien extends NhanSu {
    private String tenTruongPhong;
    private final double luongNgay = 100;
    private final Scanner mScan = new Scanner(in);
    // #endregion

    // #region Methods
    @Override
    public void tinhLuong() {
        luongThang = soNgayLamViec * luongNgay;
    }

    public void nhapTenTruongPhong() {
        printAdv(GREEN, "Tên trưởng phòng: ", RESET);
        tenTruongPhong = mScan.nextLine();
    }

    @Override
    public void nhapNhanSu() {
        super.nhapNhanSu();
        nhapTenTruongPhong();
        tinhLuong();
    }

    public void xuatTenTruongPhong() {
        printlnAdv(format("Tên trưởng phòng: %s", tenTruongPhong));
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
        super.xuatChucVu();
        xuatTenTruongPhong();
        super.xuatSoNgayLamViec();
        xuatLuongThang();
    }

    public String getTenTruongPhong() {
        return tenTruongPhong;
    }

    public void setTenTruongPhong(String tenTruongPhong) {
        this.tenTruongPhong = tenTruongPhong;
    }
}
