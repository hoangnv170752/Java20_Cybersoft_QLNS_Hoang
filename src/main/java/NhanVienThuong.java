import java.util.*;
import static java.lang.String.*;
import static java.lang.System.*;
public class NhanVienThuong extends NhanSu {
    private String tenTruongPhong;
    private final double luongNgay = 100;
    private final Scanner mScan = new Scanner(in);

    @Override
    public void tinhLuong() {
        luongThang = soNgayDiLam * luongNgay;
    }

    public void nhapTenTruongPhong() {
        out.println("Ten truong phong: ");
        tenTruongPhong = mScan.nextLine();
    }

    @Override
    public void nhapNhanSu() {
        super.nhapNhanSu();
        nhapTenTruongPhong();
        tinhLuong();
    }

    public void xuatTenTruongPhong() {
        out.println("Ten truong phong: " + tenTruongPhong);
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
