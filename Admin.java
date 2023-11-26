import java.util.Scanner;

public class Admin {
    public static void MenuAdmin(String[] args) {
        
        QuyenSach quyenSach = new QuyenSach();
        quyenSach.kiemtraDangNhap();

        if (quyenSach.isAdmin()) {
            System.out.println("Chào mừng bạn đến với quyền của Admin!");

            Scanner sc = new Scanner(System.in);
            DanhSachTK danhSachTK = new DanhSachTK(); // Tạo một đối tượng DanhSachTK

            int choice;

            do {
                System.out.println("1. Thêm sách mới");
                System.out.println("2. Chỉnh sửa thông tin sách");
                System.out.println("3. Xóa sách");
                System.out.println("4. Xóa tài khoản");
                System.out.println("5. Kiem soat nhan vien");
                System.out.println("0. Thoát");

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
                    case 4:
                        System.out.print("Nhập tên tài khoản cần xóa: ");
                        String taiKhoanXoa = sc.next();
                        danhSachTK.xoaTaiKhoan(taiKhoanXoa);
                        break;
                    case 5:
                        // chuabiet
                        break;
                    case 0:
                        System.out.println("Đã thoát chương trình.");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                        break;
                }
            } while (choice != 0);
        } else {
            System.out.println("Bạn không có quyền truy cập vào quyền của Admin.");
        }
    }
}
