import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuyenNhanVien {
    public static void MenuNhanVien(List<Sach> danhSachSach, List<HoaDonItem> hoaDonItems) {
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            System.out.println("Chuc nang cua nhan vien: ");
            System.out.println("[0] Thoat Menu.");
            System.out.println("[1] Xem danh sach sach.");
            System.out.println("[2] Phan loai sach.");
            System.out.println("[3] Xem thong tin quyen sach.");
            System.out.println("[4] Xuat hoa don sach.");
            System.out.println("[5] Chi tiet hoa don.");
            System.out.print("Chon de thuc hien chuc nang: ");
            //boolean shouldExit = false;
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("------------------------------------------------------------------------------------------------------------------");
                    for(Sach sach: danhSachSach){
                        System.out.println("=====" + sach.getTenSach() + "=====") ;
                    }
                    break;
    
                case 2:
                    PhanLoai.MenuPhanLoai(danhSachSach);
                    break;
    
                case 3:
                    QuyenUser.xemThongTinSach(danhSachSach);
                    break;

                case 4:
                    HoaDon.hoaDon(danhSachSach, hoaDonItems);
                    break;

                case 5:
                    ChiTietHoaDon.ChiTietHoaDon(danhSachSach, hoaDonItems);
                    break;
                // case 0:
                //  tạm thời để MenuUser
                //     User.MenuUser(danhSachSach);
                //     break;
            }
        }
    }
}
