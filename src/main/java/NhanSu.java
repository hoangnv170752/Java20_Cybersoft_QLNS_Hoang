import java.util.Scanner;
import static java.lang.String.*;
import static java.lang.System.*;

public class NhanSu {
    private String maNhanVien;
    private String hoTen;
    private String soDienThoai;
    protected double soNgayDiLam;
    protected double luongThang;
    private final String chucVu = "Nhan vien";
    private final Scanner mScan = new Scanner(in);

    public void tinhLuong() {
        luongThang = 0;
    }

    public void nhapMaNhanVien() {
        out.println("Nhap ma nhan vien: ");
        maNhanVien = mScan.nextLine();
    }

    public void nhapHoTen() {
        out.println("Nhap ho va ten: ");
        hoTen = mScan.nextLine();
    }

    public void nhapSoDienThoai() {
        out.println("Nhap so dien thoai: ");
        soDienThoai = mScan.nextLine();
    }

    public void nhapSoNgayLamViec() {
        out.println("So ngay lam viec: ");
        soNgayDiLam = mScan.nextInt();
    }

    public void nhapNhanSu() {
        nhapHoTen();
        nhapSoDienThoai();
        nhapSoNgayLamViec();
    }

    public void xuatMaNhanVien() {
        out.println("Ma nhan vien: " + maNhanVien);
    }

    public void xuatHoTen() {
        out.println("Ho ten: " + hoTen);
    }

    public void xuatSoDienThoai() {
        out.println("So dien thoai: " + soDienThoai);
    }

    public void xuatChucVu() {
        out.println("Chuc vu: " + chucVu);
    }

    public void xuatSoNgayLamViec() {
        out.println("So ngay lam viec: " + soNgayDiLam);
    }

    public void xuatLuongThang() {
        out.println("Luong thang: " + luongThang);
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
        return soNgayDiLam;
    }

    public void setSoNgayLamViec(double soNgayDiLam) {
        this.soNgayDiLam = soNgayDiLam;
    }

    public double getLuongThang() {
        return luongThang;
    }
}
