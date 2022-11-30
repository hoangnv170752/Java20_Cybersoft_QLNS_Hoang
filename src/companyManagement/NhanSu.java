package companyManagement;

import java.util.*;

import static java.lang.String.*;
import static java.lang.System.*;
import static support.constant.*;
import static support.support.*;

public class NhanSu {
    private String maNhanVien;
    private String hoTen;
    private String soDienThoai;
    protected double soNgayLamViec;
    protected double luongThang;
    private final String chucVu = "nhân viên";
    private final Scanner mScan = new Scanner(in);

    public void tinhLuong() {
        luongThang = 0;
    }

    public void nhapMaNhanVien() {
        printAdv(GREEN, "Mã nhân viên: ", RESET);
        maNhanVien = mScan.nextLine();
    }

    public void nhapHoTen() {
        printAdv(GREEN, "Họ tên: ", RESET);
        hoTen = mScan.nextLine();
    }

    public void nhapSoDienThoai() {
        printAdv(GREEN, "Số điện thoại: ", RESET);
        soDienThoai = mScan.nextLine();
    }

    public void nhapSoNgayLamViec() {
        printAdv(GREEN, "Số ngày làm việc: ", RESET);
        soNgayLamViec = numLimit(0d, 31d);
    }

    public void nhapNhanSu() {
        nhapHoTen();
        nhapSoDienThoai();
        nhapSoNgayLamViec();
    }

    public void xuatMaNhanVien() {
        printlnAdv(format("Mã nhân viên: %s", maNhanVien));
    }

    public void xuatHoTen() {
        printlnAdv(format("Họ tên: %s", hoTen));
    }

    public void xuatSoDienThoai() {
        printlnAdv(format("Số điện thoại: %s", soDienThoai));
    }

    public void xuatChucVu() {
        printlnAdv(format("Chức vụ: %s", chucVu));
    }

    public void xuatSoNgayLamViec() {
        printlnAdv(format("Số ngày làm việc: %s", writePerfectDub(soNgayLamViec)));
    }

    public void xuatLuongThang() {
        printlnAdv(format("Lương tháng: %,.0f", luongThang));
    }

    public void xuatNhanSu() {
        xuatMaNhanVien();
        xuatHoTen();
        xuatSoDienThoai();
        xuatChucVu();
        xuatSoNgayLamViec();
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public double getSoNgayLamViec() {
        return soNgayLamViec;
    }

    public void setSoNgayLamViec(double soNgayLamViec) {
        this.soNgayLamViec = soNgayLamViec;
    }

    public double getLuongThang() {
        return luongThang;
    }

}
