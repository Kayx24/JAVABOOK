import java.util.List;
import java.util.Scanner;

public class User extends TaiKhoan {
    private int msUser;

    public User() {
       
    }

    public User(String userName, String password, String role, int msUser) {
        super(userName, password, role);
        this.msUser = msUser;
    }

    public int getMsUser() {
        return msUser;
    }

    public static void MenuUser(Sach[] danhSachSach,HoaDonItem[] hoaDonItems, DanhSachTK ds, String tenFile) {
        Scanner sc = new Scanner(System.in);
        QuyenUser qus = new QuyenUser();
        int choice;

        while (true) {
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Chuc nang User");
            System.out.println("[0] THOAT MENU");
            System.out.println("[1] Xem danh sach sach");
            System.out.println("[2] Xem thong tin sach can tim");
            System.out.println("[3] Phan loai Sach");
            System.out.println("[4] Mua");
            System.out.print("Chon: ");

            String input = sc.next();

            if (isNumeric(input)) {
                choice = Integer.parseInt(input);

                switch (choice) {
                    case 0:
                        DangNhap.DangNhaptaikhoan();
                        break;
                    case 1:
                        qus.Docsach();
                        break;
                    case 2:
                        QuyenUser.xemThongTinSach(danhSachSach, tenFile);
                        break;
                    case 3:
                        PhanLoai.MenuPhanLoai(danhSachSach, hoaDonItems, ds);
                        break;
                    case 4:
                        HoaDon.hoaDon(hoaDonItems);
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
        return str.matches("-?\\d+");
    }
}
