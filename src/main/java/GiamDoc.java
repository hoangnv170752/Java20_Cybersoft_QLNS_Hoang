import java.util.Scanner;

import static java.lang.Double.*;
import static java.lang.String.*;
import static java.lang.System.*;

public class GiamDoc extends NhanSu {
    private double coPhan;
    private double thuNhap;
    private final String chucVu = "giám đốc";
    private final double luongNgay = 300;
    private final Scanner mScan = new Scanner(in);
    @Override
    public void tinhLuong() {
        luongThang = soNgayDiLam * luongNgay;
    }

    public void nhapCoPhan() {
        out.println("Co phan: ");
        coPhan = mScan.nextInt();
    }

    @Override
    public void nhapNhanSu() {
        super.nhapNhanSu();
        nhapCoPhan();
        tinhLuong();
    }

    public void xuatCoPhan() {
        out.println("Co phan: " + coPhan);
    }

    public void xuatThuNhap() {
        out.println("Thu nhap: " + thuNhap);
    }

    @Override
    public void xuatChucVu() {
        out.println("Chuc vu: " + chucVu );
    }

    @Override
    public void xuatLuongThang() {
        out.println("Luong thang: " + luongThang);
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
