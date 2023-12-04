// mua sách đi vào hóa đơn,phân loại  cái này bên phân loại sẽ làm
//(tìm kiếm),
// thêm user và những thằng user (arraylist) 

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuyenUser {
    List<Sach> danhSachSach = new ArrayList<>();
    String tenFile = "Sach.txt";

   
    public static void xemThongTinSach(List<Sach> danhSachSach,String tenFile) {
        danhSachSach.clear();
        Scanner sc = new Scanner(System.in);
        danhSachSach = PhanLoai.DocDuLieuTuFileSach (tenFile,danhSachSach);
        System.out.println("Nhap ten sach muon tim: ");
        String tenSach = sc.nextLine();
        // Tim kiem cuon sach co ten gan dung la tenSach
        List<Sach> sachGanDung = new ArrayList<>();
        for (Sach sach : danhSachSach) {
            if (sach.getTenSach().contains(tenSach)) {
                sachGanDung.add(sach);
            }
        }

        // Kiem tra danh sach sach gan dung
        if (!sachGanDung.isEmpty()) {
            // In ra thong tin cac sach gan dung
            System.out.println("Thong tin sach:");
            for (Sach sach : sachGanDung) {
                System.out.println("Ma sach: " + sach.getMaSach());
                System.out.println("Ten sach: " + sach.getTenSach());
                System.out.println("Ten linh vuc: " + sach.getTenLinhVuc());
                System.out.println("Ten loai sach: " + sach.getTenLoaiSach());
                System.out.println("Gia sach: " + sach.getGiaBia());
                System.out.println("So lan tai ban: " + sach.getTaiBan());
                System.out.println("Ten nha xuat ban: " + sach.getTenNhaXuatBan());
                System.out.println("Nam xuat ban: " + sach.getNamXuatBan());
                System.out.println("So luong con lai:"+sach.getSoLuongSach());
                System.out.println("------------------------");
            }
        } else {
            // Khong tim thay sach gan dung
            System.out.println("Khong tim thay sach gan dung voi ten " + tenSach);
        }
    }

    public static void TaiKhoanUser(DanhSachTK ds) {
        Scanner sc = new Scanner(System.in);
        TaiKhoan tk = new TaiKhoan();
        ds.docDuLieuTuFile("DanhSachTaiKhoan.txt");
        System.out.println("Nhap ten tai khoan muon tao: ");
        String UserName = sc.nextLine();
        while (ds.timKiem(UserName) == true) {
            System.out.println("Da co UserName nay,hay nhap UserName khac:");
            UserName = sc.nextLine();
        }
        System.out.println("Nhap mat khau muon tao: ");
        String Password = sc.nextLine();
        ds.themTaiKhoan(UserName, Password, "user");
        tk.setUserName(UserName);
        tk.setPassword(Password);
        tk.setRole("user");
        ds.luuDuLieuVaoFile("DanhSachTaiKhoan.txt", tk);
    }
    public void Docsach(){
    danhSachSach = PhanLoai.DocDuLieuTuFileSach (tenFile,danhSachSach);
    for (Sach sach : danhSachSach) {
            System.out.println(sach.toString());
        }
    }
}
