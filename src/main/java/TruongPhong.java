import static java.lang.String.*;
public class TruongPhong extends NhanSu{
    private int soThanhVien;
    private final String chucVu = "Truong phong";
    private final double luongNgay = 200;

    @Override
    public void tinhLuong() {
        luongThang = soNgayDiLam * luongNgay + 100 * soThanhVien;
    }

    public void xuatSoThanhVien() {
        System.out.println("So thanh vien: " + soThanhVien);
    }

    public void xuatChucVu() {
        System.out.println("Chuc vu: " + chucVu);
    }

    @Override
    public void xuatLuongThang() {
        System.out.println("Luong thang: " + luongThang);
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
