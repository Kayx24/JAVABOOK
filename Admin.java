import java.util.List;
import java.util.Scanner;

public class Admin {
 


    public static void MenuAdmin(Sach[] danhSachSach, HoaDonItem[] hoaDonItems, DanhSachTK ds, NhanVien[] dsNhanViens) {
         QuyenQuanLy qql=new QuyenQuanLy() {
            @Override
            public String getRole() {
                Scanner sc = new Scanner(System.in);
                System.out.println("Chon vai tro cho tai khoan");
                System.out.println("[1]: user");
                System.out.println("[2] NhanVien");
                System.out.println("[3] QuanLy");
                System.out.println("[0] Thoat");
                int choose = sc.nextInt();
                switch (choose) {
                    case 1:
                        return "user";
                    case 2:
                        return "NhanVien";
                    case 3:
                        return "QuanLy";
                    default:
                        return "";
                }
            };
            @Override
            public boolean CoTheXoa(String tenTaiKhoan, DanhSachTK ds) {
                TaiKhoan tk = ds.layTaiKhoan(tenTaiKhoan);
                if (tk != null && tk.getRole().equals("admin")) {
                    return false; // Account with role "Admin" cannot be deleted
                }
                return true; // Allow deletion for other roles
            }
        };
       
            System.out.println("Chao mung ban den voi quyen cua Admin!");
            Scanner sc = new Scanner(System.in);
            DanhSachTK danhSachTK = new DanhSachTK();
            int choice;
            while (true) {
                System.out.println("[0] Thoat");
                System.out.println("[1] Quan ly sach");
                System.out.println("[2] Quan ly tai khoan");
                System.out.println("[3] Quan ly ");

                System.out.print("Nhap lua chon cua ban: ");
                String input = sc.next();
        
        if (isNumeric(input)) {
            choice = Integer.parseInt(input);
            switch (choice) {
                    case 1:
                        QuyenSach.quanLySachMenu(danhSachTK,danhSachSach, hoaDonItems, ds,dsNhanViens);
                        break;
                    case 2:
                        qql.MenuQuyenQuanLy(danhSachSach, ds);
                        break;
                    case 3:
                        MenuQuanly(danhSachSach, hoaDonItems, ds, dsNhanViens, input);
                        break;
                    case 0:
                    DangNhap.DangNhaptaikhoan();
                    break;
                    default:
                        System.out.println("Lua chon khong hop le. Vui long nhap lai.");
                        break;
                }
            } else {
                System.out.println("Vui long nhap mot so.");
            }
        }
    }
    
public static void MenuQuanly(Sach[] danhSachSach,HoaDonItem[] hoaDonItems,DanhSachTK ds,NhanVien[] dNhanViens,String tenFile){
    Scanner sc = new Scanner(System.in);
    int choice;
    QuyenSach quyenSach = new QuyenSach();
    QuyenUser qus =new QuyenUser();
    List<List<HoaDonItem>> danhSachHoaDon = ChiTietHoaDon.HoaDonFromFile("hoadon.txt");
    QuyenQuanLy qql=new QuyenQuanLy() {
        @Override
        public String getRole() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Chon vai tro cho tai khoan");
            System.out.println("[1]: user");
            System.out.println("[2] NhanVien");
            System.out.println("[3] Quan ly");
            System.out.println("[0] Thoat");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    return "user";
                case 2:
                    return "NhanVien";
                case 3:
                    return "QuanLy";
                default:
                    return "";
            }
        };
        @Override
        public boolean CoTheXoa(String tenTaiKhoan, DanhSachTK ds) {
            TaiKhoan tk = ds.layTaiKhoan(tenTaiKhoan);
            if (tk != null && tk.getRole().equals("admin")) {
                return false; 
            }
            return true; 
        }
    };
     while (true) {
    System.out.println("------------------------------------------------------------------------------------------------------------------");
    System.out.println("Chuc nang: ");
    System.out.println("[0] THOAT MENU");
    System.out.println("[1] Xem danh sach sach.");
    System.out.println("[2] Phan loai sach.");
    System.out.println("[3] Xem thong tin quyen sach.");
    System.out.println("[4] Them sach");
    System.out.println("[5] Sua Thong tin sach");
    System.out.println("[6] Quan ly tai khoan");
    System.out.println("[7] Mua sach");
    System.out.println("[8] Xuat hoa don");
    System.out.println("[9] Thong ke");
    System.out.print("Chon: ");

    String input = sc.next();
    if (isNumeric(input)) {
        choice = Integer.parseInt(input);
        switch (choice) {
            case 0:
                MenuAdmin(danhSachSach, hoaDonItems, ds, dNhanViens);
                break;
                case 1:
                    System.out.println(
                            "------------------------------------------------------------------------------------------------------------------");
                    qus.Docsach();
                    break;
                case 2:
                    PhanLoai.MenuPhanLoai(danhSachSach, hoaDonItems, ds);
                    break;
                case 3:
                    QuyenUser.xemThongTinSach(danhSachSach, tenFile);
                    break;
                case 4:
                    quyenSach.nhapThongTinSachMoi();
                    break;
                case 5:
                    quyenSach.chinhSuaThongTinSach();
                    break;
                case 6:
                    qql.MenuQuyenQuanLy(danhSachSach, ds);
                    break;
                case 7:
                    HoaDon.hoaDon(hoaDonItems);
                    break;
                case 8:
                    ChiTietHoaDon.runChiTietHoaDon();
                    break;
                case 9:
                    THONGKE.MenuThongKe(danhSachHoaDon);
                    break;
                default:
                    System.out.println("Vui long nhap lua chon hop le.");
                    break;
                }
            } else {
                System.out.println("Vui long nhap mot so.");
            }
        }
    }
    
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}