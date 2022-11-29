import java.util.*;

import static java.util.Collections.*;
public class CacChucNang {
    public static NhanSu addNewbie(List<NhanSu> dsNhanSu) {
        String nhanSu ;
        Scanner sc = new Scanner(System.in);
        nhanSu = sc.nextLine();
        NhanSu newbie = new NhanSu();
        do {
            newbie.nhapMaNhanVien();
        } while (isRegist(dsNhanSu, newbie.getMaNhanVien()));
        newbie.nhapNhanSu();
        return newbie;
    }

    public static boolean isRegist(List<NhanSu> dsNhanSu, String maNhanVien) {
        boolean isSuccess = false;
        for (NhanSu nhanSu : dsNhanSu) {
            if (nhanSu.getMaNhanVien().equals(maNhanVien)) {
                System.out.println("Ma nhan vien da ton tai");
                isSuccess = true;
                break;
            }
        }
        return isSuccess;
    }

    public static NhanSu userType() {
        System.out.println("Vi tri trong cong ty");
        System.out.println("1. Nhân viên   ");
        System.out.println("2. Trưởng phòng");
        System.out.println("3. Giám đốc ");
        System.out.println("Chọn 1 trong các phương án trên: ");
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        switch (n) {
            case 1: {
                return new NhanVienThuong();
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

    public static void checkTeamLead(List<NhanSu> dsNhanSu) {
        for (NhanSu nhanSu : dsNhanSu) {
            if (nhanSu instanceof NhanVienThuong) {
                String nhanVien = String.valueOf((NhanVienThuong) nhanSu);
                boolean isSuccess = false;
                for (NhanSu truongPhong : dsNhanSu) {
                    if (truongPhong instanceof TruongPhong
                            && ((NhanVienThuong) nhanSu).getTenTruongPhong().equals(truongPhong.getHoTen())) {
                        isSuccess = true;
                        break;
                    }
                }
                if (!isSuccess) {
                    ((NhanVienThuong) nhanSu).setTenTruongPhong("");
                }
            }
        }
    }

    public static void memberEachTeam(List<NhanSu> dsNhanSu) {
        for (NhanSu nhanSu : dsNhanSu) {
            if (nhanSu instanceof TruongPhong) {
                String truongPhong = String.valueOf(((TruongPhong) nhanSu));
                int count = 0;
                for (NhanSu nhanVien : dsNhanSu) {
                    if (nhanVien instanceof NhanVienThuong
                            && ((NhanVienThuong) nhanVien).getTenTruongPhong().equals(nhanSu.getHoTen())) {
                        count++;
                    }
                }
                ((TruongPhong) nhanSu).setSoThanhVien(count);
                nhanSu.tinhLuong();
            }
        }
    }

    public static int findIndexByCode(List<NhanSu> dsNhanSu, String maNhanVien) {
        int index = -1;
        for (int i = 0; i < dsNhanSu.size(); i++) {
            if (dsNhanSu.get(i).getMaNhanVien().equals(maNhanVien)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static TruongPhong nhanVienThanhTruongPhong(NhanSu nhanSu) {
        TruongPhong truongPhong = new TruongPhong();
        truongPhong.setMaNhanVien(nhanSu.getMaNhanVien());
        truongPhong.setHoTen(nhanSu.getHoTen());
        truongPhong.setSoDienThoai(nhanSu.getSoDienThoai());
        truongPhong.setSoNgayLamViec(nhanSu.getSoNgayLamViec());
        truongPhong.setSoThanhVien(0);
        truongPhong.tinhLuong();
        return truongPhong;
    }

    public static double sumSalary(List<NhanSu> dsNhanSu) {
        double sum = 0d;
        for (NhanSu nhanSu : dsNhanSu) {
            sum += nhanSu.getLuongThang();
        }
        return sum;
    }

    public static List<NhanSu> topSalary(List<NhanSu> dsNhanSu) {
        // find max
        ArrayList<NhanSu> dsTopSalary = new ArrayList<NhanSu>();
        float maxSalary = (float) dsNhanSu.get(0).getLuongThang();
        for (NhanSu nhanSu : dsNhanSu) {
            if (nhanSu.getLuongThang() > maxSalary) {
                maxSalary = (float) nhanSu.getLuongThang();
            }
        }
        // add to list
        for (NhanSu nhanSu : dsNhanSu) {
            if (nhanSu.getLuongThang() == maxSalary) {
                dsTopSalary.add(nhanSu);
            }
        }
        return dsTopSalary;
    }

    public static List<TruongPhong> topTeam(List<NhanSu> dsNhanSu) {
        ArrayList<TruongPhong> dsTopTeam = new ArrayList<TruongPhong>();
        int maxTeam = 0;
        for (NhanSu nhanSu : dsNhanSu) {
            if (nhanSu instanceof TruongPhong) {
                TruongPhong truongPhong = (TruongPhong) nhanSu;
                if (truongPhong.getSoThanhVien() > maxTeam) {
                    maxTeam = truongPhong.getSoThanhVien();
                }
            }
        }
        for (NhanSu nhanSu : dsNhanSu) {
            if (nhanSu instanceof TruongPhong) {
                TruongPhong truongPhong = (TruongPhong) nhanSu;
                if (truongPhong.getSoThanhVien() == maxTeam) {
                    dsTopTeam.add(truongPhong);
                }
            }
        }
        return dsTopTeam;
    }

    public static void sortByName(List<NhanSu> dsNhanSu) {
        sort(dsNhanSu, new Comparator<NhanSu>() {
            @Override
            public int compare(NhanSu o1, NhanSu o2) {
                return o1.getHoTen().compareTo(o2.getHoTen());
            }
        });
    }

    public static void sortByCode(List<NhanSu> dsNhanSu) {
        sort(dsNhanSu, new Comparator<NhanSu>() {
            @Override
            public int compare(NhanSu o1, NhanSu o2) {
                return o1.getMaNhanVien().compareTo(o2.getMaNhanVien());
            }
        });
    }

    public static List<GiamDoc> topShare(List<NhanSu> dsNhanSu) {
        ArrayList<GiamDoc> dsTopShare = new ArrayList<GiamDoc>();
        double maxShare = 0d;
        for (NhanSu nhanSu : dsNhanSu) {
            if (nhanSu instanceof GiamDoc) {
                GiamDoc giamDoc = (GiamDoc) nhanSu;
                if (giamDoc.getCoPhan() > maxShare) {
                    maxShare = giamDoc.getCoPhan();
                }
            }
        }
        for (NhanSu nhanSu : dsNhanSu) {
            if (nhanSu instanceof GiamDoc) {
                GiamDoc giamDoc = (GiamDoc) nhanSu;
                if (giamDoc.getCoPhan() == maxShare) {
                    dsTopShare.add(giamDoc);
                }
            }
        }
        return dsTopShare;
    }

    public static List<GiamDoc> allInGiamDoc(List<NhanSu> dsNhanSu, double doanhThuThang) {
        ArrayList dsAllIn = new ArrayList<GiamDoc>();
        float loiNhuan = (float) (doanhThuThang - sumSalary(dsNhanSu));
        for (NhanSu nhanSu : dsNhanSu) {
            if (nhanSu instanceof GiamDoc) {
                GiamDoc giamDoc = (GiamDoc) nhanSu;
                giamDoc.setThuNhap(
                        giamDoc.getLuongThang() + giamDoc.getCoPhan() * loiNhuan / 100);
                dsAllIn.add(giamDoc);
            }
        }
        return dsAllIn;
    }
}
