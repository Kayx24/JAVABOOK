import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DanhSachTK ds = new DanhSachTK();
        ds.themTaiKhoan("helo1", "121", "admin");
        ds.themTaiKhoan("helo2", "122", "user");
        ds.themTaiKhoan("helo3", "123", "cc");

        DangNhap dangNhap = new DangNhap();
        dangNhap.DangNhaptaikhoan();

        // Thêm phần kiểm tra tài khoản ở đây
        Scanner scanner = new Scanner(System.in);
        String luaChon = scanner.nextLine();
        if (luaChon.equalsIgnoreCase("Y")) {
            System.out.println("Nhap ten tai khoan: ");
            String tenTK = scanner.nextLine();
            System.out.println("Nhap mat khau: ");
            String matKhau = scanner.nextLine();
            System.out.println("Nhap quyen truy cap: ");
            String quyenTruyCap = scanner.nextLine();

            ds.themTaiKhoan(tenTK, matKhau, quyenTruyCap);
            System.out.println("Tai khoan đã được thêm thành công.");
        }

        QuyenSach QS = new QuyenSach();
        kiemtraDangNhap(QS);
        if(QS.isAdmin()){
            QS.nhapThongTinSach();
        }
        System.out.println("Danh sach sach sau khi chinh sua: ");
        for (QuyenSach.Sach sach : QS.getDanhSachSach()) {
            System.out.println(sach.getMaSach() + " - " + sach.getTenSach() + " - " + sach.getGiaBia());
        }
    }

    public static void kiemtraDangNhap(QuyenSach QS){
        QS.kiemtraDangNhap();
        QS.nhapThongTinSach();
    }
}
