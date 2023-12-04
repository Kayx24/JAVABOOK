import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class QuyenNhanVien {

    public QuyenNhanVien() {
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
        nv.setUserName(userName);
        nv.setPassword(password);
        nv.setRole(role);
        // Add tai khoan to danh sach tai khoan
        ds.themTaiKhoan(userName, password, role);
        TaiKhoan tk = new TaiKhoan(userName, password, role);
        ds.luuDuLieuVaoFile("DanhSachTaiKhoan.txt", tk);
        nv.docDuLieuTuFileTaiKhoan();
        // Add NhanVien to danh sach nhan vien
        dsNhanViens.add(nv);
        //nv.LuuNhanVienVaoFile(dsNhanViens);
        nv.LuuNhanVienVaoFile(nv);
        dsNhanViens.add(nv);
    }

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

    public void runQuyenNhanVien(DanhSachTK ds, List<NhanVien> dsNhanViens) {
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("Chuc nang cua nhan vien: ");
            System.out.println("[0] Thoat.");
            System.out.println("[1] Them Nhan Vien.");
            System.out.println("[2] Xoa Nhan Vien.");

            System.out.print("Chon de thuc hien chuc nang: ");
            boolean shouldExit = false;
            // choice = sc.nextInt();
            String input = sc.next();

            if (isNumeric(input)) {
                choice = Integer.parseInt(input);
                switch (choice) {
                    case 0:
                        shouldExit = true;
                        break;
                    case 1:
                        ThemNhanVien(ds, dsNhanViens);
                        break;

                    case 2:
                        XoaNhanVien(ds, dsNhanViens);
                        break;

                }
            }
            if (shouldExit) {
                break; // Exit the loop only if shouldExit is true
            }
        }
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+");
    }
}
