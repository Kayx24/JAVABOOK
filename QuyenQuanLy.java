import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class QuyenQuanLy {
    List<Sach> danhSachSach = new ArrayList<>();

    public abstract String getRole();

    public void QuanLyThemTaiKhoan(DanhSachTK ds) {
        Scanner sc = new Scanner(System.in);
        ds.docDuLieuTuFile("DanhSachTaiKhoan.txt");
        System.out.println("Nhap ten tai khoan muon tao: ");
        String UserName = sc.nextLine();
        while (ds.timKiem(UserName)) {
            System.out.println("Da co UserName nay, hay nhap UserName khac:");
            UserName = sc.nextLine();
        }
        System.out.println("Nhap mat khau muon tao: ");
        String Password = sc.nextLine();
        String role = getRole();
        ds.themTaiKhoan(UserName, Password, role);
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
    }

    public static void QuanLyInTaiKhoan(DanhSachTK ds) {
        ds.inTaiKhoan();
    }
}