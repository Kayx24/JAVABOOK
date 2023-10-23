import java.util.ArrayList;
import java.util.Scanner;


public class DangNhap {
    //menu cho từng quyền và ghi sẵn tài khoản trong main
    // private TaiKhoan tk;
    // public DangNhap(TaiKhoan tk){
    //     this.tk=tk;
    // }
    public static void DangNhaptaikhoan(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Ten tai khoan: ");
        String TenTK=sc.nextLine();
        System.out.println("Mat khau la: ");
        String Mk=sc.nextLine();
        boolean DangNhapThanhCong=false;
        DanhSachTK ds=new DanhSachTK();
        ds.themTaiKhoan("helo1", "121", "admin");
        ds.themTaiKhoan("helo2", "122", "user");
        ds.themTaiKhoan("helo3","123" ,"cc");
        ds.inTaiKhoan();
        if (ds.timKiem(TenTK)) {
            TaiKhoan taiKhoanTimThay = ds.layTaiKhoan(TenTK);
            if (taiKhoanTimThay.getPassword().equals(Mk)) {
                DangNhapThanhCong = true;
                System.out.println("Dang nhap thanh cong");
                System.out.println("Quyen truy cap la quyen " + taiKhoanTimThay.getRole());
            } else {
                System.out.println("Mat khau khong chinh xac");
            }
        } else {
            System.out.println("Tai khoan khong ton tai");
        }        
    }
    public static void main(String[] args) {
        DangNhap.DangNhaptaikhoan();
    }
}
