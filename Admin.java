import java.util.List;
import java.util.Scanner;

public class Admin extends TaiKhoan {
    private  String UserName;
    private  String Password;
    private  String role;
    private String MaAd;
    private String TenAd;

    public Admin(String MaQL, String userName, String password, String role){
        super(userName,password,role);
        this.MaAd=MaAd;
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



    public String getMaAd() {
        return MaAd;
    }



    public void setMaAd(String maAd) {
        MaAd = maAd;
    }



    public String getTenAd() {
        return TenAd;
    }



    public void setTenAd(String tenAd) {
        TenAd = tenAd;
    }



    public static void MenuAdmin(Sach[] danhSachSach, HoaDonItem[] hoaDonItems, DanhSachTK ds, NhanVien[] dsNhanViens) {
        QuyenSach quyenSach = new QuyenSach();
        QuanLy ql = new QuanLy();
         QuyenQuanLy qql=new QuyenQuanLy() {
            @Override
            public String getRole() {
                Scanner sc = new Scanner(System.in);
                System.out.println("Chon vai tro cho tai khoan");
                System.out.println("[1]: user");
                System.out.println("[2] NhanVien");
                System.out.println("[0] Thoat");
                int choose = sc.nextInt();
                switch (choose) {
                    case 1:
                        return "user";
                    case 2:
                        return "NhanVien";
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
                System.out.println("[2] Quan ly nhan vien");
                System.out.println("[3] Quan ly tai khoan");
                System.out.println("[4] Quan ly ");

                System.out.print("Nhap lua chon cua ban: ");
                String input = sc.next();
        
        if (isNumeric(input)) {
            choice = Integer.parseInt(input);
            switch (choice) {
                    case 1:
                        quanLySachMenu(sc, quyenSach, danhSachTK,danhSachSach, hoaDonItems, ds,dsNhanViens);
                        break;
                    case 2:
                        MenuNhanVien(sc, quyenSach, danhSachTK, danhSachSach, hoaDonItems, ds, dsNhanViens);
                        break;
                    case 3:
                        qql.MenuQuyenQuanLy(danhSachSach, ds);
                        break;
                    case 4:
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

    private static void quanLySachMenu(Scanner sc, QuyenSach quyenSach, DanhSachTK danhSachTK,Sach[] danhSachSach, HoaDonItem[] hoaDonItems, DanhSachTK ds, NhanVien[] dsNhanViens) {
        int choice;
        while (true) {
      
            System.out.println("[1] Them sach moi");
            System.out.println("[2] Chinh sua thong tin sach");
            System.out.println("[3] Xoa sach");
            System.out.println("[0] Quay lai");

            System.out.print("Nhap lua chon cua ban: ");
            String input = sc.next();
    
            if (isNumeric(input)) {
                choice = Integer.parseInt(input);
                switch (choice) {
                case 1:
                    quyenSach.nhapThongTinSachMoi();
                    break;
                case 2:
                    quyenSach.chinhSuaThongTinSach();
                    break;
                case 3:
                    System.out.print("Nhap ma sach can xoa: ");
                    int maSachXoa = sc.nextInt();
                    quyenSach.xoaSach(maSachXoa);
                    break;
                case 0:
               MenuAdmin(danhSachSach, hoaDonItems, ds, dsNhanViens);
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

    private static void MenuNhanVien(Scanner sc, QuyenSach quyenSach, DanhSachTK danhSachTK,Sach[] danhSachSach, HoaDonItem[] hoaDonItems, DanhSachTK ds, NhanVien[] dsNhanViens) {
        QuyenNhanVien qnv = new QuyenNhanVien();
         QuyenQuanLy qql=new QuyenQuanLy() {
            @Override
            public String getRole() {
                Scanner sc = new Scanner(System.in);
                System.out.println("Chon vai tro cho tai khoan");
                System.out.println("[1]: user");
                System.out.println("[2] NhanVien");
                System.out.println("[0] Thoat");
                int choose = sc.nextInt();
                switch (choose) {
                    case 1:
                        return "user";
                    case 2:
                        return "NhanVien";
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
        int choice;
        while (true) {
          
            System.out.println("[1] Them nhan vien");
            System.out.println("[2] Xoa nhan vien");
            System.out.println("[0] Quay lai");

            System.out.print("Nhap lua chon cua ban: ");
            String input = sc.next();
    
            if (isNumeric(input)) {
                choice = Integer.parseInt(input);
                switch (choice) {
                  case 0:
                    MenuAdmin(danhSachSach, hoaDonItems, ds, dsNhanViens);
                break;
                case 1:
                    qnv.ThemNhanVien(ds, dsNhanViens);
                    break;
                case 2:
                    qql.QuanLyXoaTaiKhoan(ds);
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
    QuyenNhanVien qnv = new QuyenNhanVien();
    NhanVien nv = new NhanVien();
    User us = new User();
    QuyenUser qus =new QuyenUser();
    ChiTietHoaDon cthd =new ChiTietHoaDon();
    List<List<HoaDonItem>> danhSachHoaDon = ChiTietHoaDon.HoaDonFromFile("hoadon.txt");
    QuyenQuanLy qql=new QuyenQuanLy() {
        @Override
        public String getRole() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Chon vai tro cho tai khoan");
            System.out.println("[1]: user");
            System.out.println("[2] NhanVien");
            System.out.println("[0] Thoat");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    return "user";
                case 2:
                    return "NhanVien";
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
     while (true) {
    System.out.println("------------------------------------------------------------------------------------------------------------------");
    System.out.println("Chuc nang Quanly");
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