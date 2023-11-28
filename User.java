import java.util.List;
import java.util.Scanner;

public class User extends TaiKhoan{
    private  String UserName;
    private  String Password;
    private  String role;
    private  int msUser;
    // check ma user nhằm tránh sai sót khi có 2 user trở lên với database
    // thêm menu user
    public User () {

    }

    public User(String userName, String password, String role,int msUser) {
        super(userName, password, role);
        this.msUser=msUser;
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

    public int getMsUser() {
        return msUser;
    }
   

    public static void MenuUser(List<Sach> danhSachSach,List<HoaDonItem> hoaDonItems,DanhSachTK ds,String tenFile){
        Scanner sc = new Scanner(System.in);
        QuyenUser qus = new QuyenUser();
        int choice;
        while (true) {
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            System.out.println("Chuc nang User");
            System.out.println("[0] THOAT MENU");
            System.out.println("[1] Xem danh sach sach");
            System.out.println("[2] Xem thong tin sach can tim");
            System.out.println("[3] Phan loai Sach");
            System.out.println("[4] Mua");
            System.out.print("Chon: ");
            boolean shouldExit = false;
            choice = sc.nextInt();
            switch (choice) {
                case 0:
                    DangNhap.DangNhaptaikhoan();
                    break;
                case 1:
                qus.Docsach();
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
            }
        }
    }
}
