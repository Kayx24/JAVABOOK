import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class QuyenQuanLy extends QuyenNhanVien {
    List<Sach> danhSachSach = new ArrayList<>();

    public abstract String getRole();

    public void QuanLyThemTaiKhoan(DanhSachTK ds) {
        Scanner sc = new Scanner(System.in);
        // ds.docDuLieuTuFile("DanhSachTaiKhoan.txt");
    
        System.out.println("Nhập tên tài khoản muốn tạo: ");
        String userName = sc.nextLine();
    
        while (ds.timKiem(userName)) {
            System.out.println("Tên tài khoản đã tồn tại. Vui lòng nhập tên khác: ");
            userName = sc.nextLine();
        }
    
        System.out.println("Nhập mật khẩu muốn tạo: ");
        String password = sc.nextLine();
    
        String role = getRole();
    
        // Thêm tài khoản mới vào danh sách
        ds.themTaiKhoan(userName, password, role);
    
        // Lưu dữ liệu vào tệp
        ds.luuDuLieuVaoFile("DanhSachTaiKhoan.txt");
    }
    public abstract boolean CoTheXoa(String tenTaiKhoan,DanhSachTK ds);
    public  void QuanLyXoaTaiKhoan(DanhSachTK ds) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên tài khoản cần xóa: ");
        String tenTaiKhoan = sc.nextLine();
        if(CoTheXoa(tenTaiKhoan,ds)==true){
            ds.xoaTaiKhoan(tenTaiKhoan);
            ds.luuDuLieuVaoFile("DanhSachTaiKhoan.txt");
        }
        else{
            System.out.println("TAI KHOAN ADMIN KHONG DUOC PHEP XOA");
        }
    }

    public static void QuanLyInTaiKhoan(DanhSachTK ds) {
        ds.inTaiKhoan();
    }
}