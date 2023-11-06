import java.util.List;
import java.util.Scanner;

public class User extends TaiKhoan{
    private  String UserName;
    private  String Password;
    private  String role;
    private  int msUser;
    // check ma user nhằm tránh sai sót khi có 2 user trở lên với database
    // thêm menu user

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

    public void setMsUser(int msUser) {
        this.msUser = msUser;
    }
    public static void MenuUser(List<Sach> danhSachSach){
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            System.out.println("Chuc nang User");
            System.out.println("[0] THOAT MENU");
            System.out.println("[1] Xem thong tin sach can tim");
            System.out.println("[2] Phan loai Sach");
            System.out.println("[3] The loai.");
            System.out.println("[4] Nha xuat ban.");
            System.out.print("Chon de phan loai: ");
            boolean shouldExit = false;
            choice = sc.nextInt();
            switch (choice) {
                case 0:
                    // nhay vao menu dang nhap;
                    break;
                case 1:
                    QuyenUser.xemThongTinSach(danhSachSach);
                    break;
                case 2:
                    PhanLoai.MenuPhanLoai(danhSachSach);
            }
        }
    }
}
