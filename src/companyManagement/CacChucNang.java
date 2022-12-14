package companyManagement;

import java.util.*;

import static java.util.Collections.*;
import static support.constant.*;
import static support.support.*;

public class CacChucNang {
    /**
     * Đăng kí thêm nhân viên
     * @param dsNhanSu
     * @return
     */
    public static NhanSu addNewbie(List<NhanSu> dsNhanSu) {
        var nhanSu = userType();
        do {
            nhanSu.nhapMaNhanVien();
        } while (isRegist(dsNhanSu, nhanSu.getMaNhanVien()));
        nhanSu.nhapNhanSu();
        return nhanSu;
    }

    /**
     * Chọn chức vụ
     * @return
     */
    public static NhanSu userType() {
        printlnAdv(RESET, "Vị trí trong công ty");
        printlnAdv("1. Nhân viên   ");
        printlnAdv("2. Trưởng phòng");
        printlnAdv("3. Giám đốc    ");
        printAdv("Chọn 1 trong các phương án trên: ");
        switch (numLimit(1, 3)) {
            case 1: {
                return new NhanVien();
            }
            case 2: {
                return new TruongPhong();
            }
            case 3: {
                return new GiamDoc();
            }
            default: {
                return new NhanSu();
            }
        }
    }

    /**
     * Kiem tra xem da dang ki nhan vien nay chua
     * @param dsNhanSu
     * @param maNhanVien
     * @return
     */
    public static boolean isRegist(List<NhanSu> dsNhanSu, String maNhanVien) {
        var isSuccess = false;
        for (var nhanSu : dsNhanSu) {
            if (nhanSu.getMaNhanVien().equals(maNhanVien)) {
                printlnAdv(RED, "Mã nhân viên đã tồn tại!");
                isSuccess = true;
                break;
            }
        }
        return isSuccess;
    }

    /**
     * Kiem tra xem co phai truong phong khong
     * @param dsNhanSu
     */
    public static void checkTeamLead(List<NhanSu> dsNhanSu) {
        for (var nhanSu : dsNhanSu) {
            if (nhanSu instanceof NhanVien) {
                var nhanVien = (NhanVien) nhanSu;
                var isSuccess = false;
                for (var truongPhong : dsNhanSu) {
                    if (truongPhong instanceof TruongPhong
                            && nhanVien.getTenTruongPhong().equals(truongPhong.getHoTen())) {
                        isSuccess = true;
                        break;
                    }
                }
                if (!isSuccess) {
                    nhanVien.setTenTruongPhong("");
                }
            }
        }
    }

    public static void memberEachTeam(List<NhanSu> dsNhanSu) {
        for (var nhanSu : dsNhanSu) {
            if (nhanSu instanceof TruongPhong) {
                var truongPhong = ((TruongPhong) nhanSu);
                var count = 0;
                for (var nhanVien : dsNhanSu) {
                    if (nhanVien instanceof NhanVien
                            && ((NhanVien) nhanVien).getTenTruongPhong().equals(truongPhong.getHoTen())) {
                        count++;
                    }
                }
                truongPhong.setSoThanhVien(count);
                truongPhong.tinhLuong();
            }
        }
    }

    /**
     * Tim nhan su
     * @param dsNhanSu
     * @param maNhanVien
     * @return
     */
    public static int findIndexByCode(List<NhanSu> dsNhanSu, String maNhanVien) {
        var index = -1;
        for (var i = 0; i < dsNhanSu.size(); i++) {
            if (dsNhanSu.get(i).getMaNhanVien().equals(maNhanVien)) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Cho nhan vien thanh truong phong
     * @param nhanSu
     * @return
     */
    public static TruongPhong nhanVienTransToTruongPhong(NhanSu nhanSu) {
        var truongPhong = new TruongPhong();
        truongPhong.setMaNhanVien(nhanSu.getMaNhanVien());
        truongPhong.setHoTen(nhanSu.getHoTen());
        truongPhong.setSoDienThoai(nhanSu.getSoDienThoai());
        truongPhong.setSoNgayLamViec(nhanSu.getSoNgayLamViec());
        truongPhong.setSoThanhVien(0);
        truongPhong.tinhLuong();
        return truongPhong;
    }

    /**
     * Tinh tong luong
     * @param dsNhanSu
     * @return
     */
    public static double sumSalary(List<NhanSu> dsNhanSu) {
        var sum = 0d;
        for (var nhanSu : dsNhanSu) {
            sum += nhanSu.getLuongThang();
        }
        return sum;
    }

    /**
     * Tim luong cao
     * @param dsNhanSu
     * @return
     */
    public static List<NhanSu> topSalary(List<NhanSu> dsNhanSu) {
        var dsTopSalary = new ArrayList<NhanSu>();
        var maxSalary = dsNhanSu.get(0).getLuongThang();
        for (var nhanSu : dsNhanSu) {
            if (nhanSu.getLuongThang() > maxSalary) {
                maxSalary = nhanSu.getLuongThang();
            }
        }
        for (var nhanSu : dsNhanSu) {
            if (nhanSu.getLuongThang() == maxSalary) {
                dsTopSalary.add(nhanSu);
            }
        }
        return dsTopSalary;
    }

    /**
     * Tim truong phong nhieu nhan su nhat
     * @param dsNhanSu
     * @return
     */
    public static List<TruongPhong> topTeam(List<NhanSu> dsNhanSu) {
        var dsTopTeam = new ArrayList<TruongPhong>();
        var maxTeam = 0;
        for (var nhanSu : dsNhanSu) {
            if (nhanSu instanceof TruongPhong) {
                var truongPhong = (TruongPhong) nhanSu;
                if (truongPhong.getSoThanhVien() > maxTeam) {
                    maxTeam = truongPhong.getSoThanhVien();
                }
            }
        }
        for (var nhanSu : dsNhanSu) {
            if (nhanSu instanceof TruongPhong) {
                var truongPhong = (TruongPhong) nhanSu;
                if (truongPhong.getSoThanhVien() == maxTeam) {
                    dsTopTeam.add(truongPhong);
                }
            }
        }
        return dsTopTeam;
    }

    /**
     * Sap xep theo ten
     * @param dsNhanSu
     */
    public static void sortByName(List<NhanSu> dsNhanSu) {
        sort(dsNhanSu, new Comparator<NhanSu>() {
            @Override
            public int compare(NhanSu o1, NhanSu o2) {
                return o1.getHoTen().compareTo(o2.getHoTen());
            }
        });
    }

    /**
     * Sap xem theo ma nhan vien
     * @param dsNhanSu
     */
    public static void sortByCode(List<NhanSu> dsNhanSu) {
        sort(dsNhanSu, new Comparator<NhanSu>() {
            @Override
            public int compare(NhanSu o1, NhanSu o2) {
                return o1.getMaNhanVien().compareTo(o2.getMaNhanVien());
            }
        });
    }

    /**
     *
     * @param dsNhanSu
     * @return
     */
    public static List<GiamDoc> topShare(List<NhanSu> dsNhanSu) {
        // find max
        var dsTopShare = new ArrayList<GiamDoc>();
        var maxShare = 0d;
        for (var nhanSu : dsNhanSu) {
            if (nhanSu instanceof GiamDoc) {
                var giamDoc = (GiamDoc) nhanSu;
                if (giamDoc.getCoPhan() > maxShare) {
                    maxShare = giamDoc.getCoPhan();
                }
            }
        }
        for (var nhanSu : dsNhanSu) {
            if (nhanSu instanceof GiamDoc) {
                var giamDoc = (GiamDoc) nhanSu;
                if (giamDoc.getCoPhan() == maxShare) {
                    dsTopShare.add(giamDoc);
                }
            }
        }
        return dsTopShare;
    }

    /**
     * Tinh thu nhap cua Giam doc
     * @param dsNhanSu
     * @param doanhThuThang
     * @return
     */
    public static List<GiamDoc> allInGiamDoc(List<NhanSu> dsNhanSu, double doanhThuThang) {
        var dsAllIn = new ArrayList<GiamDoc>();
        var loiNhuan = doanhThuThang - sumSalary(dsNhanSu);
        for (var nhanSu : dsNhanSu) {
            if (nhanSu instanceof GiamDoc) {
                var giamDoc = (GiamDoc) nhanSu;
                giamDoc.setThuNhap(
                        giamDoc.getLuongThang() + giamDoc.getCoPhan() * loiNhuan / 100);
                dsAllIn.add(giamDoc);
            }
        }
        return dsAllIn;
    }
}
