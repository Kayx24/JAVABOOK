
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


 public static void MenuQuanly(List<Sach> danhSachSach,List<HoaDonItem> hoaDonItems,DanhSachTK ds, List<NhanVien> dsNhanViens, String tenFile){
        Scanner sc = new Scanner(System.in);
        int choice;
        QuyenSach quyenSach = new QuyenSach();
        QuyenQuanLy qql = new QuyenQuanLy();
        QuyenNhanVien qnv = new QuyenNhanVien();
        ChiTietHoaDon cthd =new ChiTietHoaDon();

        while (true) {
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            System.out.println("Chuc nang Quanly");
            System.out.println("[0] THOAT MENU");
            System.out.println("[1] Xem danh sach sach");
            System.out.println("[2] Xem thong tin sach can tim");
            System.out.println("[3] Phan loai Sach");
            System.out.println("[4] Mua");
            System.out.println("[5] Lua chon cac chuc nang hoa don");
            System.out.println("[6] Them sach");
            System.out.println("[7] Sua Thong tin sach");
            System.out.println("[8] Duoi nhan vien");
            System.out.println("[9] Them nhan vien");
            System.out.print("Chon: ");
            choice = sc.nextInt();
            switch (choice) {
                case 0:
                DangNhap.DangNhaptaikhoan();
                break;
            case 1:
            qql.Docsach();
                break;
            case 2:
            QuyenUser.xemThongTinSach(danhSachSach,tenFile);
                break;
            case 3:
                PhanLoai.MenuPhanLoai(danhSachSach, hoaDonItems, ds);
            break;
            case 4:
                HoaDon.hoaDon(hoaDonItems);
                break;
                case 5:
                ChiTietHoaDon.runChiTietHoaDon();
                    break;
                case 6:
                    quyenSach.nhapThongTinSachMoi();
                    break;
                case 7:
                    quyenSach.chinhSuaThongTinSach();
                    break;
                case 8:
                    qnv.XoaNhanVien(ds, dsNhanViens);
                    break;
                case 9:
                    qnv.ThemNhanVien(ds, dsNhanViens);
                    break;
            }
        }
    }
}


