
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DangNhap {
    private static List<TaiKhoan> danhSachTaiKhoanDaDangNhap = new ArrayList<>();

    public static void DangNhaptaikhoan() {
        DanhSachTK ds = new DanhSachTK();
        Scanner sc = new Scanner(System.in);

        System.out.println("[0] de dang ky");
        System.out.println("[1] de dang nhap");
        int tieptuc;
        do {
            while (!sc.hasNextInt()) {
                System.out.println("GIA TRI KHONG HOP LE. VUI LONG NHAP LAI");
                System.out.println("[0] de dang ky");
                System.out.println("[1] de dang nhap");
                sc.next();
            }
            tieptuc = sc.nextInt();
            sc.nextLine();

            if (tieptuc != 0 && tieptuc != 1) {
                System.out.println("GIA TRI KHONG HOP LE. VUI LONG NHAP LAI");
            }
        } while (tieptuc != 0 && tieptuc != 1);
        if (tieptuc == 0) {
            QuyenUser.TaiKhoanUser(ds);
            DangNhap.DangNhaptaikhoan();
        } else {
            System.out.println("Ten tai khoan: ");
            String TenTK = sc.nextLine();   
            System.out.println("Mat khau la: ");
            String Mk = sc.nextLine();

            boolean DangNhapThanhCong = false;
            
        List<Sach> danhSachSach = new ArrayList<>();
        
        List<HoaDonItem> hoaDonItems = new ArrayList<>();
        List<NhanVien> dNhanViens = new ArrayList<>();
        // List<List<HoaDonItem>> danhSachHoaDon = new ArrayList<>();
        ds.docDuLieuTuFile("DanhSachTaiKhoan.txt");

            if (ds.timKiem(TenTK)) {
                String tenFile = "Sach.txt";

                TaiKhoan taiKhoanTimThay = ds.layTaiKhoan(TenTK);
                if (taiKhoanTimThay.getPassword().equals(Mk)) {
                    DangNhapThanhCong = true;
                    System.out.println("Dang nhap thanh cong");
                    System.out.println("Quyen truy cap la quyen " + taiKhoanTimThay.getRole());
                    danhSachTaiKhoanDaDangNhap.add(taiKhoanTimThay); // Lưu thông tin tài khoản đã đăng nhập
                    // Gọi hàm hiển thị menu hoặc thực hiện các công việc liên quan đến đăng nhập thành công

                    if (taiKhoanTimThay.getRole().equals("user")) {
                        User.MenuUser(danhSachSach, hoaDonItems,ds,tenFile);
                    } else if (taiKhoanTimThay.getRole().equals("admin")) {
                        Admin.MenuAdmin(danhSachSach,hoaDonItems,ds);
                    } else if (taiKhoanTimThay.getRole().equals("QuanLy")) {
                         QuanLy.MenuQuanly(danhSachSach, hoaDonItems,ds, dNhanViens, tenFile);
                    } else if (taiKhoanTimThay.getRole().equals("NhanVien")) {
                        NhanVien.MenuNhanVien(danhSachSach, hoaDonItems, ds,tenFile);
                    }
                } else {
                    System.out.println("Mat khau khong chinh xac");
                    DangNhap.DangNhaptaikhoan();
                }
            } else {
                System.out.println("Tai khoan khong ton tai");
                DangNhap.DangNhaptaikhoan();
            }
        }
    }

    public static List<TaiKhoan> getDanhSachTaiKhoanDaDangNhap() {
        return danhSachTaiKhoanDaDangNhap;
    }

    public static void main(String[] args) {
        DangNhap.DangNhaptaikhoan();
    }
}
