import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuyenNhanVien {
    public void ThemNhanVien(DanhSachTK ds) {
        //List<NhanVien> dsNhanViens = new ArrayList<>();
        //NhanVien nv = new NhanVien(null, null, null, null, null, null, false, null, null, null)
        Scanner sc = new Scanner(System.in);
        ds.docDuLieuTuFile("DanhSachTaiKhoan.txt");
        System.out.print("Nhap Username cho tai khoan nhan vien : ");
        String UserName = sc.nextLine();
        while (ds.timKiem(UserName) == true) {
            System.out.println("Tai khoan nay da duoc su dung.");
            System.out.print("Nhap lai Username khac: ");
            UserName = sc.nextLine();
        }
        System.out.print("Nhap Password cho tai khoan nhan vien: ");
        String Password = sc.nextLine();
        String Role = "NhanVien";
        ds.themTaiKhoan(UserName, Password, Role);
        ds.luuDuLieuVaoFile("DanhSachTaiKhoan.txt");
        //dsNhanViens.add(null)
    }

    public void XoaNhanVien(DanhSachTK ds) {
        Scanner sc = new Scanner(System.in);
        ds.docDuLieuTuFile("DanhSachTaiKhoan.txt");
        System.out.print("Ten tai khoan nhan vien muon xoa");
        String UserName = sc.nextLine();
        if (ds.timKiem(UserName) == true) {
            ds.xoaTaiKhoan(UserName);
            ds.luuDuLieuVaoFile("DanhSachTaiKhoan.txt");
            System.out.print("Tai khoan da duoc xoa");
        } else {
            System.out.println("Khong tim thay tai khoan nhan vien can xoa");
        }

    }

}
