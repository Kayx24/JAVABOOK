import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class DangNhap {
    //menu cho từng quyền và ghi sẵn tài khoản trong main
    // private TaiKhoan tk;
    // public DangNhap(TaiKhoan tk){
    //     this.tk=tk;
    // }
    public static void DangNhaptaikhoan(){
        DanhSachTK ds=new DanhSachTK();
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Bam [0] de dang ky");
        System.out.println("Bam [1] de dang nhap");
        int tieptuc=sc.nextInt();
        if(tieptuc==0){
            QuyenUser.TaiKhoanUser(ds);
            DangNhap.DangNhaptaikhoan();
        }
        else{
            String bientam=sc.nextLine();
            System.out.println("Ten tai khoan: ");
            String TenTK=sc.nextLine();
            System.out.println("Mat khau la: ");
            String Mk=sc.nextLine();

        boolean DangNhapThanhCong =false;
        
        
        // ds.themTaiKhoan("helo2", "122", "user");
       // ds.themTaiKhoan("helo3", "123", "NhanVien");
       // ds.themTaiKhoan("helo4","124" ,"QuanLy");
        ds.docDuLieuTuFile("DanhSachTaiKhoan.txt");

        List<Sach> danhSachSach = new ArrayList<>();

        List<HoaDonItem> hoaDonItems = new ArrayList<>();

        if (ds.timKiem(TenTK)) {
            TaiKhoan taiKhoanTimThay = ds.layTaiKhoan(TenTK);
            if (taiKhoanTimThay.getPassword().equals(Mk)) {
                DangNhapThanhCong = true;
                System.out.println("Dang nhap thanh cong");
                System.out.println("Quyen truy cap la quyen " + taiKhoanTimThay.getRole());
                String ROLE=taiKhoanTimThay.getRole();
                if(ROLE.equals("user")){
                    User.MenuUser(danhSachSach, hoaDonItems,ds);
                }
                else if(ROLE.equals("admin")){
                    // menu admin;
                }
                else if(ROLE.equals("QuanLy")){
                   QuanLy.MenuQuanly(danhSachSach, hoaDonItems);
                }
                else if(ROLE.equals("NhanVien")){
                    NhanVien.MenuNhanVien(danhSachSach, hoaDonItems, ds);
                }
            } else {
                System.out.println("Mat khau khong chinh xac");
            }
        } else {
            System.out.println("Tai khoan khong ton tai");
        } 
        
    }
        // BỎ VÀO MENU ADMIN
        QuyenSach QS = new QuyenSach();
        // Thực hiện đăng nhập
        // Kiểm tra đăng nhập và quyền admin
        // if (QS.isAdmin()) {
           
        //     QS.nhapThongTinSachMoi();
        // }
        // KẾT THÚC
    }

    public static void main(String[] args) {
        DangNhap.DangNhaptaikhoan();
    }
}
