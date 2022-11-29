import java.util.*;

import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static java.util.Collections.reverse;

public class QuanLi {
    public static void main(String args[]) {
        out.println("Bai tap Quan li nhan su Cong ty");
        run();
    }

    private static final Scanner mScan = new Scanner(in);
    private static String mTenCongTy;
    private static String mMaSoThue;
    private static double mDoanhThuThang;
    private static List<NhanSu> mDSNhanSu;

    private static void run() {
        out.println(" 1. Bổ nhiệm nhân viên làm trưởng phòng");
        out.println(" 2. Thêm nhân sự                       ");
        out.println(" 3. Xóa nhân sự                        ");
        out.println(" 4. Xuất thông tin toàn bộ công ty     ");
        out.println(" 5. Tính tổng lương toàn công ty       ");
        out.println(" 6. Tìm thành viên có lương cao nhất   ");
        out.println(" 7. Tìm trưởng phòng quản lý nhiều nhất");
        out.println(" 8. Sắp xếp nhân sự theo tên           ");
        out.println(" 9. Sắp xếp nhân sự giảm dần           ");
        out.println("10. Tìm giám đốc có cổ phần nhiều nhất ");
        out.println("11. Tính tổng thu nhập của mỗi giám đốc");
        out.println("Chọn 1 trong các phương án trên: ");
        int n;
        n = mScan.nextInt();
        switch (n) {
            case 1: {
                unitA();
                break;
            }
//            case 2: {
//                unitB();
//                break;
//            }
//            case 3: {
//                unitC();
//                break;
//            }
//            case 4: {
//                unitD();
//                break;
//            }
//            case 5: {
//                unitE();
//                break;
//            }
//            case 6: {
//                unitF();
//                break;
//            }
//            case 7: {
//                unitG();
//                break;
//            }
//            case 8: {
//                unitH();
//                break;
//            }
//            case 9: {
//                unitI();
//                break;
//            }
//            case 10: {
//                unitJ();
//                break;
//            }
//            case 11: {
//                unitK();
//                break;
//            }
        }
        // ctrl
//        checkOut();
    }

    private static void unitA() {
        ArrayList<NhanVienThuong> dsNhanVien = new ArrayList<NhanVienThuong>();
        for (NhanSu nhanSu : mDSNhanSu) {
            if (nhanSu instanceof NhanVienThuong) {
                dsNhanVien.add((NhanVienThuong) nhanSu);
            }
        }
        int max = dsNhanVien.size();
        if (max > 0) {
            out.println("Danh sách nhân viên");
            for (int i = 0; i < max; i++) {
                NhanVienThuong nhanVien = dsNhanVien.get(i);
                out.println(format("%d. %s (%s)", i + 1, nhanVien.getHoTen(), nhanVien.getMaNhanVien()));
            }
            out.println("Chọn 1 trong các phương án trên: ");
//            int index = findIndexByCode(mDSNhanSu, dsNhanVien.get(numLimit(1, max) - 1).getMaNhanVien());
//            mDSNhanSu.add(index, nhanVienThanhTruongPhong(mDSNhanSu.get(index)));
//            mDSNhanSu.remove(index + 1);
//            // finish
//            memberEachTeam(mDSNhanSu);
//            unitD();
//        } else {
//            checkIn();
//            printlnAdv("Công ty không có nhân viên nào!");
//            out.println();
//        }
        }
    }

//    private static void checkOut() {
//        if (credit() == 1) {
//            run();
//        }
//    }
}
