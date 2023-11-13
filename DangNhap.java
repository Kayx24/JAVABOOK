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
        Scanner sc=new Scanner(System.in);
        System.out.println("Ten tai khoan: ");
        String TenTK=sc.nextLine();
        System.out.println("Mat khau la: ");
        String Mk=sc.nextLine();
        boolean DangNhapThanhCong =false;
        DanhSachTK ds=new DanhSachTK();
        ds.themTaiKhoan("admin", "121", "admin");
        ds.themTaiKhoan("helo2", "122", "user");
        ds.themTaiKhoan("helo3", "123", "NhanVien");
        ds.themTaiKhoan("helo4","124" ,"QuanLy");

        List<Sach> danhSachSach = new ArrayList<>();
        danhSachSach.add(new Sach(1, "Conan","Linh vuc A", "Trinh tham", 10000, 2, "Nha xuat ban A", 2023));
        danhSachSach.add(new Sach(2, "Doraemon","Linh vuc B", "Vui ve", 15000, 3, "Nha xuat ban B", 2022));
        danhSachSach.add(new Sach(3, "One Piece","Linh vuc C", "Gia tuong", 20000, 4, "Nha xuat ban C", 2021));
        danhSachSach.add(new Sach(4,"Sharelock Homes tap 1","Linh vuc D","Trinh tham",25000,5,"Nha xuat ban Kim Dong",2022));        
        danhSachSach.add(new Sach(4,"Sharelock Homes tap 2","Linh vuc D","Trinh tham",30000,5,"Nha xuat ban Kim Dong",2022));
        danhSachSach.add(new Sach(4,"Sharelock Homes tap 3","Linh vuc D","Trinh tham",30000,5,"Nha xuat ban Kim Dong",2022));
        danhSachSach.add(new Sach(4,"Sharelock Homes tap 4","Linh vuc D","Trinh tham",30000,5,"Nha xuat ban Kim Dong",2022));
        danhSachSach.add(new Sach(4,"Sharelock Homes ngoai truyen","Linh vuc D","Trinh tham",30000,5,"Nha xuat ban Kim Dong",2022));
        danhSachSach.add(new Sach(1, "Conan","Linh vuc A", "Trinh tham", 100, 2, "Nha xuat ban A", 2023));
        danhSachSach.add(new Sach(2, "Doraemon","Linh vuc B", "Vui ve", 150, 3, "Nha xuat ban B", 2022));
        danhSachSach.add(new Sach(3, "One Piece","Linh vuc C", "Gia tuong", 200, 4, "Nha xuat ban C", 2021));
        danhSachSach.add(new Sach(4,"Sharelock Homes tap 1","Linh vuc D","Trinh tham",300,5,"Nha xuat ban Kim Dong",2022));        
        danhSachSach.add(new Sach(4,"Sharelock Homes tap 2","Linh vuc D","Trinh tham",300,5,"Nha xuat ban Kim Dong",2022));
        danhSachSach.add(new Sach(4,"Sharelock Homes tap 3","Linh vuc D","Trinh tham",300,5,"Nha xuat ban Kim Dong",2022));
        danhSachSach.add(new Sach(4,"Sharelock Homes tap 4","Linh vuc D","Trinh tham",300,5,"Nha xuat ban Kim Dong",2022));
        danhSachSach.add(new Sach(4,"Sharelock Homes tap 5","Linh vuc D","Trinh tham",300,5,"Nha xuat ban Kim Dong",2022));
        danhSachSach.add(new Sach(7,"Sach day tieng dong vat","Linh vuc E","khoa hoc",101,7,"Nha xuat ban Kim Khanh",2023));

        List<HoaDonItem> hoaDonItems = new ArrayList<>();

        if (ds.timKiem(TenTK)) {
            TaiKhoan taiKhoanTimThay = ds.layTaiKhoan(TenTK);
            if (taiKhoanTimThay.getPassword().equals(Mk)) {
                DangNhapThanhCong = true;
                System.out.println("Dang nhap thanh cong");
                System.out.println("Quyen truy cap la quyen " + taiKhoanTimThay.getRole());
                String ROLE=taiKhoanTimThay.getRole();
                if(ROLE=="user"){
                    User.MenuUser(danhSachSach, hoaDonItems);
                }
                else if(ROLE=="admin"){
                    // menu admin;
                }
                else if(ROLE=="QuanLy"){
                    // menu quản lý
                }
                else if(ROLE=="NhanVien"){
                    QuyenNhanVien.MenuNhanVien(danhSachSach, hoaDonItems);
                }
            } else {
                System.out.println("Mat khau khong chinh xac");
            }
        } else {
            System.out.println("Tai khoan khong ton tai");
        } 
        
        // BỎ VÀO MENU ADMIN
        QuyenSach QS = new QuyenSach();
        // Thực hiện đăng nhập
        // Kiểm tra đăng nhập và quyền admin
        if (QS.isAdmin()) {
            QS.nhapThongTinSachMoi();
        }
        // KẾT THÚC
    }

    public static void main(String[] args) {
        DangNhap.DangNhaptaikhoan();
    }
}
