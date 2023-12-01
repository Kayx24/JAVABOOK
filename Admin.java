import java.util.List;
import java.util.Scanner;

public class Admin {
    public static void MenuAdmin(List<Sach> danhSachSach, List<HoaDonItem> hoaDonItems, DanhSachTK ds, List<NhanVien> dsNhanViens) {
        QuyenSach quyenSach = new QuyenSach();
        quyenSach.kiemtraDangNhap();

        if (quyenSach.isAdmin()) {
            System.out.println("Chào mừng bạn đến với quyền của Admin!");
            Scanner sc = new Scanner(System.in);
            DanhSachTK danhSachTK = new DanhSachTK();
            int mainChoice;
            do {
                System.out.println("0. Thoát");
                System.out.println("1. Quản lý sách");
                System.out.println("2. Quản lý nhân viên");
                System.out.println("3. Quản lý tài khoản");

                System.out.print("Nhập lựa chọn của bạn: ");
                mainChoice = sc.nextInt();

                switch (mainChoice) {
                    case 1:
                        quanLySachMenu(sc, quyenSach, danhSachTK);
                        break;
                    case 2:
                        MenuNhanVien(sc, ds, dsNhanViens);
                        break;
                    case 3:
                        // quanLyTaiKhoanMenu(sc, quyenSach, danhSachTK);
                        break;
                    case 0:
                        System.out.println("Đã thoát chương trình.");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                        break;
                }
            } while (mainChoice != 0);
        } else {
            System.out.println("Bạn không có quyền truy cập vào quyền của Admin.");
        }
    }

    private static void quanLySachMenu(Scanner sc, QuyenSach quyenSach, DanhSachTK danhSachTK) {
        int choice;
        do {
            System.out.println("1. Thêm sách mới");
            System.out.println("2. Chỉnh sửa thông tin sách");
            System.out.println("3. Xóa sách");
            System.out.println("0. Quay lại");

            System.out.print("Nhập lựa chọn của bạn: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    quyenSach.nhapThongTinSachMoi();
                    break;
                case 2:
                    quyenSach.chinhSuaThongTinSach();
                    break;
                case 3:
                    System.out.print("Nhập mã sách cần xóa: ");
                    int maSachXoa = sc.nextInt();
                    quyenSach.xoaSach(maSachXoa);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                    break;
            }
        } while (choice != 0);
    }

    private static void MenuNhanVien(Scanner sc, DanhSachTK ds, List<NhanVien> dsNhanViens) {
        QuyenNhanVien qnv = new QuyenNhanVien();
        int choice;
        do {
            System.out.println("1. Them nhan vien");
            System.out.println("2. Xoa nhan vien");
            //System.out.println("3. Xem thong tin ");
            System.out.println("0. Quay lại");

            System.out.print("Nhập lựa chọn của bạn: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    qnv.ThemNhanVien(ds, dsNhanViens);
                    break;
                case 2:
                    qnv.XoaNhanVien(ds, dsNhanViens);
                    break;
                // case 3:
                //     System.out.print("Nhập mã sách cần xóa: ");
                //     int maSachXoa = sc.nextInt();
                //     quyenSach.xoaSach(maSachXoa);
                //     break;
                case 0:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                    break;
            }
        } while (choice != 0);
    }

    // private static void Men(Scanner sc, QuyenSach quyenSach, DanhSachTK
    // danhSachTK) {
    // Thêm code quản lý tài khoản ở đây
    // }
}
