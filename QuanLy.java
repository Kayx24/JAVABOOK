
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class QuanLy extends TaiKhoan {
    private  String UserName;
    private  String Password;
    private  String role;
    private String MaQL;
    private String TenQL;
    private String Duoi;
  
    public QuanLy(String MaQL, String userName, String password, String role){
    super(userName,password,role);
    this.MaQL=MaQL;
}

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMaQL() {
        return MaQL;
    }

    public void setMaQL(String maQL) {
        MaQL = maQL;
    }

    public String getTenQL() {
        return TenQL;
    }

    public void setTenQL(String tenQL) {
        TenQL = tenQL;
    }

    public String getDuoi() {
        return Duoi;
    }

    public void setDuoi(String duoi) {
        Duoi = duoi;
    }


 public static void MenuQuanly(List<Sach> danhSachSach,List<HoaDonItem> hoaDonItems){
        Scanner sc = new Scanner(System.in);
        int choice;
        QuyenSach quyenSach = new QuyenSach();
        while (true) {
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            System.out.println("Chuc nang Quanly");
            System.out.println("[0] THOAT MENU");
            System.out.println("[1] Xem danh sach sach");
            System.out.println("[2] Xem thong tin sach can tim");
            System.out.println("[3] Phan loai Sach");
            System.out.println("[4] Mua");
            System.out.println("[5] Chi tiet hoa don");
            System.out.println("[6] Sua hoa don");
            System.out.println("[7] Xoa hoa don ");
            System.out.println("[8] Them sach");
            System.out.println("[9] Sua Thong tin sach");
            System.out.println("[10] Duoi nhan vien");
            System.out.print("Chon: ");
            boolean shouldExit = false;
            choice = sc.nextInt();
            switch (choice) {
                case 0:
                    DangNhap.DangNhaptaikhoan();
                    break;
                case 1:
                for (Sach sach : danhSachSach) {
                    System.out.println("======"+sach.getTenSach()+"======");
                    }
                    break;
                case 2:
                    QuyenUser.xemThongTinSach(danhSachSach);
                    break;
                // case 3:
                //     PhanLoai.MenuPhanLoai(danhSachSach);
                //     break;
                // case 4:
                //     HoaDon.hoaDon(danhSachSach,hoaDonItems);
                //     break;
                // case 5:
                //     ChiTietHoaDon.ChiTietHoaDon(danhSachSach,hoaDonItems);
                //     break;
                // case 6:
                //     ChiTietHoaDon.editSachInHoaDon(hoaDonItems);
                //     break;
                // case 7:
                //     ChiTietHoaDon.deleteSachFromHoaDon(hoaDonItems);
                //     break;
                // case 8:
                //     quyenSach.nhapThongTinSachMoi();
                //     break;
                // case 9:
                //     quyenSach.chinhSuaThongTinSach();
                //     break;
                // case 10:
                //     ChiTietHoaDon.ChiTietHoaDon(danhSachSach,hoaDonItems);
                //     break;
                

            }
        }
    }
}


