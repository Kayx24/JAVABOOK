import java.util.ArrayList;
import java.util.Iterator;
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



    public static void MenuAdmin(List<Sach> danhSachSach, List<HoaDonItem> hoaDonItems, DanhSachTK ds, List<NhanVien> dsNhanViens) {
        QuyenSach quyenSach = new QuyenSach();
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
       
            System.out.println("Chao mung ban đen voi quyen cua Admin!");
            Scanner sc = new Scanner(System.in);
            DanhSachTK danhSachTK = new DanhSachTK();
            int mainChoice;
            do {
                System.out.println("0. Thoot");
                System.out.println("1. Quan ly sach");
                System.out.println("2. Quản ly nhan vien");
                System.out.println("3. Quản ly tai khoan");

                System.out.print("Nhap lua chon cua ban: ");
                mainChoice = sc.nextInt();

                switch (mainChoice) {
                    case 1:
                        quanLySachMenu(sc, quyenSach, danhSachTK);
                        break;
                    case 2:
                        MenuNhanVien(sc, ds, dsNhanViens);
                        break;
                    case 3:
                    qql.MenuQuyenQuanLy(danhSachSach, ds);
                        break;
                    case 0:
                        System.out.println("Đa thoat chuong trinh.");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le. Vui long nhap lai.");
                        break;
                }
            } while (mainChoice != 0);
    }

    private static void quanLySachMenu(Scanner sc, QuyenSach quyenSach, DanhSachTK danhSachTK) {
        int choice;
        do {
            System.out.println("1. Them sach moi");
            System.out.println("2. Chinh sua thong tin sach");
            System.out.println("3. Xoa sach");
            System.out.println("0. Quay lai");

            System.out.print("Nhap lua chon cua ban: ");
            choice = sc.nextInt();

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
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long nhap lai.");
                    break;
            }
        } while (choice != 0);
    }

    private static void MenuNhanVien(Scanner sc, DanhSachTK ds, List<NhanVien> dsNhanViens) {
        QuyenNhanVien qnv = new QuyenNhanVien();
        int choice;
        do {
            System.out.println("1. Them nhan vien");
            System.out.println("2. Xoa nhan vien");
            //System.out.println("3. Xem thong tin ");
            System.out.println("0. Quay lai");

            System.out.print("Nhap lua chon cua ban: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    qnv.ThemNhanVien(ds, dsNhanViens);
                    break;
                case 2:
                    qnv.XoaNhanVien(ds, dsNhanViens);
                    break;
                // case 3:
                //     System.out.print("Nhập mã sách cần xóa: ");
                //     int maSachXoa = sc.nextInt();
                //     quyenSach.xoaSach(maSachXoa);
                //     break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long nhap lai.");
                    break;
            }
        } while (choice != 0);
    }
    private static void Men(Scanner sc, QuyenSach quyenSach, DanhSachTK ds,List<Sach> danhSachSach) {
        int choice;
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
        
        do {
            System.out.println("[0] Thoat phan loai .");
            System.out.println("[1]lua chon cac quyen Tai khoan");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
               qql.MenuQuyenQuanLy(danhSachSach, ds);
                break;

                default:
                    System.out.println("Lua chon khong hop le. Vui long nhap lai.");
                    break;
            }
        } while (choice != 0);
    }

   
    
}
