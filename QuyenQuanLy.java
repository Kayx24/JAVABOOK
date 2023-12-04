import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class QuyenQuanLy extends QuyenNhanVien {

    List<Sach> danhSachSach = new ArrayList<>();

    public abstract String getRole();

    public void QuanLyThemTaiKhoan(DanhSachTK ds) {
        List<NhanVien> dNhanViens = new ArrayList<>();
        NhanVien nv = new NhanVien();
        Scanner sc = new Scanner(System.in);
        // ds.docDuLieuTuFile("DanhSachTaiKhoan.txt");

        System.out.println("Nhap ten tai khoan muon tao:");
        String userName = sc.nextLine();

        while (ds.timKiem(userName)) {
            System.out.println("Ten tai khoan da ton tai, vui long nhap ten khac ");
            userName = sc.nextLine();
        }

        System.out.println("Nhap mat khau muon tao: ");
        String password = sc.nextLine();

        String role = getRole();
        if(role.equals("NhanVien")){
            nv.setUserName(userName);
            nv.setPassword(password);
            nv.setRole(role);
            QuyenNhanVien qnn = new QuyenNhanVien();
            qnn.ThemNhanVien(ds, dNhanViens);
        }
        TaiKhoan tk = new TaiKhoan(userName, password, role);
        ds.themTaiKhoan(userName, password, role);
        ds.luuDuLieuVaoFile("DanhSachTaiKhoan.txt", tk);
    }

    public abstract boolean CoTheXoa(String tenTaiKhoan, DanhSachTK ds);

    public void QuanLyXoaTaiKhoan(DanhSachTK ds) {
        List<NhanVien> dsNhanViens = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten tai khoan can xoa: ");
        String tenTaiKhoan = sc.nextLine();
        QuyenNhanVien qnn = new QuyenNhanVien();
        if (CoTheXoa(tenTaiKhoan, ds) == true) {
            qnn.XoaNhanVien(ds, dsNhanViens, tenTaiKhoan);
            //TaiKhoan tkToDelete = ds.layTaiKhoan(tenTaiKhoan);
            ds.xoaTaiKhoan(tenTaiKhoan);
            //ds.xoaTaiKhoan(tenTaiKhoan);
            ds.luuDuLieuVaoFileForDel("DanhSachTaiKhoan.txt");
        } else {
            System.out.println("TAI KHOAN ADMIN KHONG DUOC PHEP XOA");
        }
    }

    public static void QuanLyInTaiKhoan(DanhSachTK ds) {
        ds.inTaiKhoan();
    }

    public void MenuQuyenQuanLy(List<Sach> danhSachSach, DanhSachTK ds) {
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("----------------------------------------------------------");
            System.out.println("Quyen cua Quan ly: ");
            System.out.println("[0] Thoat phan loai sach.");
            System.out.println("[1] Quan li them tai khoan.");
            System.out.println("[2] Kiem tra xem tai khoan co the xoa hay khong.");
            System.out.println("[3] Xoa tai khoan da chon.");
            System.out.println("[4] Lay thong tin tai khoan.");
            System.out.print("Chon de phan loai: ");
            boolean shouldExit = false;
            String input = sc.next();
            if (isNumeric(input)) {
                choice = Integer.parseInt(input);
                switch (choice) {
                    case 1:
                        QuanLyThemTaiKhoan(ds);
                        break;

                    case 2:
                        System.out.print("Nhap ten tai khoan can kiem tra: ");
                        String tenTaiKhoanKT = sc.nextLine();
                        boolean coTheXoa = CoTheXoa(tenTaiKhoanKT, ds);
                        if (coTheXoa) {
                            System.out.println("Tai khoan co the xoa.");
                        } else {
                            System.out.println("TAI KHOAN ADMIN KHONG DUOC PHEP XOA");
                        }
                        break;

                    case 3:
                        QuanLyXoaTaiKhoan(ds);
                        break;

                    case 4:
                        QuanLyInTaiKhoan(ds);
                        break;

                    case 0:
                        shouldExit = true;
                        break;
                }
            }
            if (shouldExit) {
                break; // Exit the loop only if shouldExit is true
            }
        }
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+");
    }
}