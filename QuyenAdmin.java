import java.util.Scanner;

abstract class QuyenAdmin extends QuyenQuanLy {

    @Override
        public String getRole() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Chon vai tro cho tai khoan");
            System.out.println("[1]: user");
            System.out.println("[2] NhanVien");
            System.out.println("[3] Quan ly");
            System.out.println("[0] Thoat");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    return "user";
                case 2:
                    return "NhanVien";
                case 3:
                    return "QuanLy";
                default:
                    return "";
            }
        };
        @Override
        public boolean CoTheXoa(String tenTaiKhoan, DanhSachTK ds) {
            TaiKhoan tk = ds.layTaiKhoan(tenTaiKhoan);
            if (tk != null && tk.getRole().equals("admin")) {
                return false; 
            }
            return true; 
        }
    public void MenuQuyenAdmin(Sach[] danhSachSach, DanhSachTK ds) {
        Scanner sc = new Scanner(System.in);
        NhanVien[]  dsNhanViens = new NhanVien[1000];
        int choice;
        while (true) {
            System.out.println("----------------------------------------------------------");
            System.out.println("Quyen cua Quan ly: ");
            System.out.println("[0] Thoat phan loai sach.");
            System.out.println("[1] Quan li them tai khoan.");
            System.out.println("[2] Kiem tra xem tai khoan co the xoa hay khong.");
            System.out.println("[3] Xoa tai khoan da chon.");
            System.out.println("[4] Lay thong tin tai khoan.");
            System.out.println("[5] Hien thi thong tin nhan vien");
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
                        sc.nextLine();
                        System.out.print("Nhap ten tai khoan can kiem tra: ");
                        String tenTaiKhoanKT = sc.nextLine();
                        boolean coTheXoa = CoTheXoa(tenTaiKhoanKT, ds);
                        if (coTheXoa) {
                            System.out.println("Tai khoan co the xoa.");
                        } else {
                            System.out.println("TAI KHOAN KHONG DUOC PHEP XOA");
                        }
                        break;

                    case 3:
                        AdminXoaTaiKhoan(ds);
                        break;

                    case 4:
                        QuanLyInTaiKhoan(ds);
                        break;
                    case 5:
                        NhanVien NV = new NhanVien();
                        NV.HienThiNhanVienTuFile(dsNhanViens);
                        break;
                    case 0:
                        shouldExit = true;
                        break;
                }
            }
            if (shouldExit) {
                break;
            }
        }
    }
    public void AdminXoaTaiKhoan(DanhSachTK ds) {
        NhanVien[] dsNhanViens = new NhanVien[1000];
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten tai khoan can xoa: ");
        String tenTaiKhoan = sc.nextLine();
        QuyenNhanVien qnn = new QuyenNhanVien();
        if (CoTheXoa(tenTaiKhoan, ds) == true) {
            TaiKhoan tk = ds.layTaiKhoan(tenTaiKhoan);
            if (tk != null && tk.getRole().equals("NhanVien")) {
                qnn.XoaNhanVien(ds, dsNhanViens, tenTaiKhoan);
            }
            // qnn.XoaNhanVien(ds, dsNhanViens, tenTaiKhoan);
            ds.xoaTaiKhoan(tenTaiKhoan);
            ds.luuDuLieuVaoFileForDel("DanhSachTaiKhoan.txt");


        } else {
            System.out.println("TAI KHOAN ADMIN KHONG DUOC PHEP XOA");
        }
    }
    public void ChinhSuaQuanLy(Sach[] danhSachSach, DanhSachTK ds) {
        Scanner sc = new Scanner(System.in);
        NhanVien[]  dsNhanViens = new NhanVien[1000];
        int choice;
        while (true) {
            System.out.println("----------------------------------------------------------");
            System.out.println("Quyen: ");
            System.out.println("[0] Thoat.");
            System.out.println("[1] Quan li them tai khoan.");
            System.out.println("[2] Kiem tra xem tai khoan co the xoa hay khong.");
            System.out.println("[3] Xoa tai khoan da chon.");
            System.out.println("[4] Lay thong tin tai khoan.");
            System.out.println("[5] Hien thi thong tin nhan vien");
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
                        sc.nextLine();
                        System.out.print("Nhap ten tai khoan can kiem tra: ");
                        String tenTaiKhoanKT = sc.nextLine();
                        boolean coTheXoa = CoTheXoa(tenTaiKhoanKT, ds);
                        if (coTheXoa) {
                            System.out.println("Tai khoan co the xoa.");
                        } else {
                            System.out.println("TAI KHOAN KHONG DUOC PHEP XOA");
                        }
                        break;

                    case 3:
                        QuanLyXoaTaiKhoan(ds);
                        break;

                    case 4:
                        QuanLyInTaiKhoan(ds);
                        break;
                    case 5:
                        NhanVien NV = new NhanVien();
                        NV.HienThiNhanVienTuFile(dsNhanViens);
                        break;
                    case 0:
                        shouldExit = true;
                        break;
                }
            }
            if (shouldExit) {
                break;
            }
        }
    }
}
