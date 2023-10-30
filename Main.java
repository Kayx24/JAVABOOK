import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DanhSachTK ds = new DanhSachTK();
        List<Sach> danhSachSach = new ArrayList<>();
        ds.themTaiKhoan("helo1", "121", "admin");
        ds.themTaiKhoan("helo2", "122", "user");
        ds.themTaiKhoan("helo3", "123", "cc");
        DangNhap dangNhap = new DangNhap();
        QuyenSach QS = new QuyenSach();
        // Thực hiện đăng nhập
        dangNhap.DangNhaptaikhoan();
        // Kiểm tra đăng nhập và quyền admin
        if (QS.isAdmin()) {
            QS.nhapThongTinSachMoi();
        }
        danhSachSach.add(new Sach(1, "Conan", 123, "Linh vuc A", "Loai sach A", 100, 2, "Nha xuat ban A", 2023));
        danhSachSach.add(new Sach(2, "Doraemon", 456, "Linh vuc B", "Loai sach B", 150, 3, "Nha xuat ban B", 2022));
        danhSachSach.add(new Sach(3, "One Piece", 789, "Linh vuc C", "Loai sach C", 200, 4, "Nha xuat ban C", 2021));
        for (Sach sach : danhSachSach) {
            System.out.println(sach);
        }
        
    }
}