package companyManagement;

import companyManagement.NhanSu;
import companyManagement.NhanVien;

import java.util.*;

import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static java.util.Collections.reverse;
import static companyManagement.CacChucNang.*;
import static support.constant.*;
import static support.support.*;

public class QuanLiCongTy {
    public static void main(String[] args) {
        out.println(BLUE_BOLD);
        printlnAdv("Bài Tập Quản Lý Nhân Sự cho công ty ");
        out.println();
        printAdv(GREEN, "Nhập vào số thành viên: ", RESET);
        var n = numLimit(1, MAX_VALUE);
        printAdv(GREEN, "Tên công ty: ", RESET);
        mTenCongTy = mScan.nextLine();
        printAdv(GREEN, "Mã số thuế: ", RESET);
        mMaSoThue = mScan.nextLine();
        printAdv(GREEN, "Doanh thu tháng: ", RESET);
        mDoanhThuThang = numLimit(Double.MIN_VALUE, Double.MAX_VALUE);
        mDSNhanSu = new ArrayList<NhanSu>();
        for (var i = 0; i < n; i++) {
            out.println();
            printlnAdv(CYAN, format("Thành viên thứ %d", i + 1));
            mDSNhanSu.add(addNewbie(mDSNhanSu));
        }
        checkTeamLead(mDSNhanSu);
        memberEachTeam(mDSNhanSu);
        run();
    }

    private static final Scanner mScan = new Scanner(in);
    private static String mTenCongTy;
    private static String mMaSoThue;
    private static double mDoanhThuThang;
    private static List<NhanSu> mDSNhanSu;

    private static void run() {
        out.println(CYAN);
        printlnAdv(" 1. Bổ nhiệm nhân viên làm trưởng phòng");
        printlnAdv(" 2. Thêm nhân sự                       ");
        printlnAdv(" 3. Xóa nhân sự                        ");
        printlnAdv(" 4. Xuất thông tin toàn bộ công ty     ");
        printlnAdv(" 5. Tính tổng lương toàn công ty       ");
        printlnAdv(" 6. Tìm thành viên có lương cao nhất   ");
        printlnAdv(" 7. Tìm trưởng phòng quản lý nhiều nhất");
        printlnAdv(" 8. Sắp xếp nhân sự theo tên           ");
        printlnAdv(" 9. Sắp xếp nhân sự giảm dần           ");
        printlnAdv("10. Tìm giám đốc có cổ phần nhiều nhất ");
        printlnAdv("11. Tính tổng thu nhập của mỗi giám đốc");
        printAdv("Chọn 1 trong các phương án trên: ");
        out.print(RESET);
        switch (numLimit(1, 11)) {
            case 1: {
                option1();
                break;
            }
            case 2: {
                option2();
                break;
            }
            case 3: {
                option3();
                break;
            }
            case 4: {
                option4();
                break;
            }
            case 5: {
                option5();
                break;
            }
            case 6: {
                option6();
                break;
            }
            case 7: {
                option7();
                break;
            }
            case 8: {
                option8();
                break;
            }
            case 9: {
                option9();
                break;
            }
            case 10: {
                option10();
                break;
            }
            case 11: {
                option11();
                break;
            }
        }
        checkOut();
    }

    /**
     * Bo nhiem nhan vien
     */
    private static void option1() {
        var dsNhanVien = new ArrayList<NhanVien>();
        for (var nhanSu : mDSNhanSu) {
            if (nhanSu instanceof NhanVien) {
                dsNhanVien.add((NhanVien) nhanSu);
            }
        }
        var max = dsNhanVien.size();
        if (max > 0) {
            out.println(RESET);
            printlnAdv("Danh sách nhân viên");
            for (var i = 0; i < max; i++) {
                var nhanVien = dsNhanVien.get(i);
                printlnAdv(format("%d. %s (%s)", i + 1, nhanVien.getHoTen(), nhanVien.getMaNhanVien()));
            }
            printAdv("Chọn 1 trong các phương án trên: ");
            var index = findIndexByCode(mDSNhanSu, dsNhanVien.get(numLimit(1, max) - 1).getMaNhanVien());
            mDSNhanSu.add(index, nhanVienTransToTruongPhong(mDSNhanSu.get(index)));
            mDSNhanSu.remove(index + 1);
            memberEachTeam(mDSNhanSu);
            option4();
        } else {
            checkIn();
            printlnAdv("Công ty không có nhân viên nào!");
            out.println();
        }
    }

    /**
     * Them thanh vien
     */
    private static void option2() {
        out.println(CYAN);
        printlnAdv("Thêm thành viên mới");
        mDSNhanSu.add(addNewbie(mDSNhanSu));
        memberEachTeam(mDSNhanSu);
        option4();
    }

    /**
     * Xoa thanh vien
     */
    private static void option3() {
        printlnAdv(RESET, "Danh sách nhân viên");
        var max = mDSNhanSu.size();
        for (var i = 0; i < max; i++) {
            var nhanSu = mDSNhanSu.get(i);
            printlnAdv(format("%d. %s (%s)", i + 1, nhanSu.getHoTen(), nhanSu.getMaNhanVien()));
        }
        printAdv("Chọn 1 trong các phương án trên: ");
        var index = findIndexByCode(mDSNhanSu, mDSNhanSu.get(numLimit(1, max) - 1).getMaNhanVien());
        mDSNhanSu.remove(index);
        checkTeamLead(mDSNhanSu);
        memberEachTeam(mDSNhanSu);
        option4();
    }

    /**
     * Xuat danh sach nhan su
     */
    private static void option4() {
        checkIn();
        for (var nhanSu : mDSNhanSu) {
            nhanSu.xuatNhanSu();
            out.println();
        }
    }

    /**
     * Tinh va xuat tong luong cho toan cong ty
     */
    private static void option5() {
        option4();
        printlnAdv(format("Tổng lương toàn công ty: %,.0f", sumSalary(mDSNhanSu)));
        out.println();
    }

    /**
     * Tim nhan vien thuong co luong cao nhat
     */
    private static void option6() {
        // cap
        checkIn();
        printlnAdv("Thành viên lương cao nhất");
        out.println();
        // main
        var dsTopSalary = topSalary(mDSNhanSu);
        // shown
        for (var topNhanSu : dsTopSalary) {
            topNhanSu.xuatHoTen();
            topNhanSu.xuatChucVu();
            topNhanSu.xuatLuongThang();
            out.println();
        }
    }

    /**
     * Tim truong phong co nhieu nhan vien duoi quyen nhat
     */
    private static void option7() {
        // cap
        checkIn();
        printlnAdv("Trưởng phòng quản lý nhiều thành viên nhât");
        out.println();
        // main
        var dsTopTeam = topTeam(mDSNhanSu);
        // shown
        for (var topTruongPhong : dsTopTeam) {
            topTruongPhong.xuatHoTen();
            topTruongPhong.xuatSoThanhVien();
            out.println();
        }
    }

    /**
     * Sap xep nhan vien theo thu tu abc
     */
    private static void option8() {
        checkIn();
        printlnAdv("Sắp xếp nhân sự theo tên");
        out.println();
        var dsNhanSu = new ArrayList<NhanSu>(mDSNhanSu);
        sortByName(dsNhanSu);
        for (var nhanSu : dsNhanSu) {
            nhanSu.xuatNhanSu();
            out.println();
        }
    }

    /**
     * Sap xep nhan su theo thu tu giam dan
     */
    private static void option9() {
        checkIn();
        printlnAdv("Sắp xếp nhân sự giảm dần");
        out.println();
        var dsNhanSu = new ArrayList<NhanSu>(mDSNhanSu);
        sortByCode(dsNhanSu);
        reverse(dsNhanSu);
        for (var nhanSu : dsNhanSu) {
            nhanSu.xuatNhanSu();
            out.println();
        }
    }

    /**
     * Giam doc co nhieu co phan nhat
     */
    private static void option10() {
        checkIn();
        printlnAdv("Giám đốc có nhiều cổ phần nhất");
        out.println();
        var dsTopShare = topShare(mDSNhanSu);
        for (var topGiamDoc : dsTopShare) {
            topGiamDoc.xuatHoTen();
            topGiamDoc.xuatCoPhan();
            out.println();
        }
    }

    /**
     * Tinh thu nhap cua giam doc
     */
    private static void option11() {
        checkIn();
        printlnAdv("Thu nhập giám đốc");
        out.println();
        var dsGiamDoc = allInGiamDoc(mDSNhanSu, mDoanhThuThang);
        for (var topGiamDoc : dsGiamDoc) {
            topGiamDoc.xuatHoTen();
            topGiamDoc.xuatThuNhap();
            out.println();
        }
    }

    /**
     * Nhap thong tin cong ty
     */
    private static void checkIn() {
        out.println(YELLOW);
        printlnAdv(format("Công ty %s", toTitleCaseAdv(mTenCongTy)));
        printlnAdv(format("MST %s", mMaSoThue));
        printlnAdv(format("Doanh Thu Tháng %s", writePerfectDub(mDoanhThuThang)));
        out.println();
    }

    private static void checkOut() {
        if (credit() == 1) {
            run();
        }
    }
}
