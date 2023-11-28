import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;



public class QuyenNhanVien {

    public QuyenNhanVien(){
    }

    public void ThemNhanVien(DanhSachTK ds, List<NhanVien> dsNhanViens) {
        NhanVien nv = new NhanVien();
        Scanner sc = new Scanner(System.in);
        ds.docDuLieuTuFile("DanhSachTaiKhoan.txt");
        // Prompt for unique username
        System.out.print("Nhap Username cho tai khoan nhan vien: ");
        String userName = sc.nextLine();
        while (ds.timKiem(userName)) {
            System.out.println("Tai khoan nay da duoc su dung.");
            System.out.print("Nhap lai Username khac: ");
            userName = sc.nextLine();
        }

        // Set password and role
        System.out.print("Nhap Password cho tai khoan nhan vien: ");
        String password = sc.nextLine();
        String role = "NhanVien";

        // Set other information for NhanVien
        nv.NhapNhanVien();

        // Add tai khoan to danh sach tai khoan
        ds.themTaiKhoan(userName, password, role);
        ds.luuDuLieuVaoFile("DanhSachTaiKhoan.txt");
        nv.docDuLieuTuFileTaiKhoan();
        // Add NhanVien to danh sach nhan vien
        dsNhanViens.add(nv);
        nv.LuuNhanVienVaoFile(dsNhanViens);
        dsNhanViens.add(nv);
    }

    // public void XoaNhanVien(DanhSachTK ds, List<NhanVien> dsNhanViens) {
    //     Scanner sc = new Scanner(System.in);
    //     ds.docDuLieuTuFile("DanhSachTaiKhoan.txt");

    //     System.out.print("Ten tai khoan nhan vien muon xoa: ");
    //     String userName = sc.nextLine();

    //     // Tìm nhân viên trong danh sách
    //     NhanVien nvToRemove = null;
    //     for (NhanVien nv : dsNhanViens) {
    //         if (nv.getUserName().equals(userName)) {
    //             nvToRemove = nv;
    //             break;
    //         }
    //     }

    //     if (nvToRemove != null) {
    //         // Xoá nhân viên từ DanhSachNhanVien.txt và DanhSachTaiKhoan.txt
    //         nvToRemove.XoaNhanVienTuFile(userName, ds);
    //         dsNhanViens.remove(nvToRemove);
    //         System.out.println("Nhân viên đã được xóa.");
    //     } else {
    //         System.out.println("Khong tim thay tai khoan nhan vien can xoa trong danh sach.");
    //     }
    // }

    public void XoaNhanVien(DanhSachTK ds, List<NhanVien> dsNhanViens) {
        Scanner sc = new Scanner(System.in);
        ds.docDuLieuTuFile("DanhSachTaiKhoan.txt");

        System.out.print("Ten tai khoan nhan vien muon xoa: ");
        String userName = sc.nextLine();

        // Remove the corresponding NhanVien from dsNhanViens
        Iterator<NhanVien> iterator = dsNhanViens.iterator();
        while (iterator.hasNext()) {
            NhanVien nvItem = iterator.next();
            if (nvItem.getUserName().equals(userName)) {
                iterator.remove();
                break;
            }
        }

        // Remove the username from DanhSachTaiKhoan.txt
        ds.xoaTaiKhoan(userName);
        ds.luuDuLieuVaoFile("DanhSachTaiKhoan.txt");

        // Remove the username from DanhSachNhanVien.txt
        NhanVien nv = new NhanVien();
        nv.XoaNhanVienTuFile(userName, ds);

        System.out.println("Nhan vien da duoc xoa.");
    }

    public void runQuyenNhanVien(DanhSachTK ds) {
        Scanner sc = new Scanner(System.in);
        int choice;
    
        while (true) {
            System.out.println("Chuc nang cua nhan vien: ");
            System.out.println("[1] Them Nhan Vien.");
            System.out.println("[2] Xoa Nhan Vien.");
            System.out.println("[3] Thoat.");
            System.out.print("Chon de thuc hien chuc nang: ");
            choice = sc.nextInt();
    
            switch (choice) {
                case 1:
                    //ThemNhanVien(ds);
                    break;
    
                case 2:
                    //XoaNhanVien(ds);
                    break;
    
                case 3:
                    System.exit(0);
    
                default:
                    System.out.println("Lua chon khong hop le. Vui long nhap lai.");
            }
        }
    }

    public static void main(String[] args) {
        DanhSachTK ds = new DanhSachTK();
        QuyenNhanVien qs = new QuyenNhanVien();
        List<NhanVien> dsNhanViens = new ArrayList<>();
        
        qs.ThemNhanVien(ds, dsNhanViens);
        qs.XoaNhanVien(ds, dsNhanViens);
    }

}
