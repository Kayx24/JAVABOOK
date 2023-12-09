import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class QuyenNhanVien {

    public QuyenNhanVien() {
    }

    public void ThemNhanVien(DanhSachTK ds, NhanVien[] dsNhanViens) {
        int index=0;
        NhanVien nv = new NhanVien();
        Scanner sc = new Scanner(System.in);
        //ds.docDuLieuTuFile("DanhSachTaiKhoan.txt");
        // Prompt for unique username
        // System.out.print("Nhap Username cho tai khoan nhan vien: ");
        // String userName = sc.nextLine();
        // while (ds.timKiem(userName)) {
        //     System.out.println("Tai khoan nay da duoc su dung.");
        //     System.out.print("Nhap lai Username khac: ");
        //     userName = sc.nextLine();
        // }

        // // Set password and role
        // System.out.print("Nhap Password cho tai khoan nhan vien: ");
        // String password = sc.nextLine();
        // String role = "NhanVien";

        // Set other information for NhanVien
        nv.NhapNhanVien();
        // nv.setUserName(userName);
        // nv.setPassword(password);
        // nv.setRole(role);
        // Add tai khoan to danh sach tai khoan
        //ds.themTaiKhoan(userName, password, role);
        //TaiKhoan tk = new TaiKhoan(userName, password, role);
        //ds.luuDuLieuVaoFile("DanhSachTaiKhoan.txt", tk);
        nv.docDuLieuTuFileTaiKhoan();
        // Add NhanVien to danh sach nhan vien
        dsNhanViens[index++]=nv;
        //nv.LuuNhanVienVaoFile(dsNhanViens);
        nv.LuuNhanVienVaoFile(nv);
        //dsNhanViens.add(nv);
    }

    public void XoaNhanVien(DanhSachTK ds, NhanVien[] dsNhanViens, String userName) {
        Scanner sc = new Scanner(System.in);
    
        // Remove the corresponding NhanVien from dsNhanViens
        NhanVien[] nhanVienArray = dsNhanViens;
        for (int i = 0; i < nhanVienArray.length; i++) {
            NhanVien nvItem = nhanVienArray[i];
            if(nvItem!=null){
                if (nvItem.getUserName().equals(userName)) {
                    // Create a new array and copy elements excluding the one to be removed
                    NhanVien[] newArray = new NhanVien[nhanVienArray.length - 1];
                    System.arraycopy(nhanVienArray, 0, newArray, 0, i);
                    System.arraycopy(nhanVienArray, i + 1, newArray, i, nhanVienArray.length - i - 1);
                    
                    // Update reference to the new array
                    nhanVienArray = newArray;
                    break;
                }
            }
        }
    
        // At this point, nhanVienArray contains the updated array without the removed NhanVien
    
        // Remove the username from DanhSachNhanVien.txt
        NhanVien nv = new NhanVien();
        nv.XoaNhanVienTuFile(userName, ds);
    
        System.out.println("Nhan vien da duoc xoa.");
    }
    

    // public void runQuyenNhanVien(DanhSachTK ds, List<NhanVien> dsNhanViens) {
    //     Scanner sc = new Scanner(System.in);
    //     int choice;
    //     while (true) {
    //         System.out.println("Chuc nang cua nhan vien: ");
    //         System.out.println("[0] Thoat.");
    //         System.out.println("[1] Them Nhan Vien.");
    //         System.out.println("[2] Xoa Nhan Vien.");

    //         System.out.print("Chon de thuc hien chuc nang: ");
    //         boolean shouldExit = false;
    //         // choice = sc.nextInt();
    //         String input = sc.next();

    //         if (isNumeric(input)) {
    //             choice = Integer.parseInt(input);
    //             switch (choice) {
    //                 case 0:
    //                     shouldExit = true;
    //                     break;
    //                 case 1:
    //                     ThemNhanVien(ds, dsNhanViens);
    //                     break;

    //                 case 2:
    //                     XoaNhanVien(ds, dsNhanViens);
    //                     break;

    //             }
    //         }
    //         if (shouldExit) {
    //             break; // Exit the loop only if shouldExit is true
    //         }
    //     }
    // }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+");
    }
}
