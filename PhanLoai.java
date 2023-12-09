import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class PhanLoai {

    public void docDuLieuTuFile(String TenFile, DanhSachTK dstaikhoans) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(TenFile));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String username = parts[0];
                    String password = parts[1];
                    String role = parts[2];
                    dstaikhoans.themTaiKhoan(username, password, role);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Co loi xay ra khi doc du lieu tu file.");
            e.printStackTrace();
        }
    }

    public static Sach[] DocDuLieuTuFileSach(String TenFile, Sach[] danhSachSach) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(TenFile));
            String line;
            int index = 0;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 9) {
                    int MaSach = Integer.parseInt(parts[0].trim());
                    String TenSach = parts[1];
                    String TenLinhVuc = parts[2];
                    String TenLoaiSach = parts[3];
                    int GiaBia = Integer.parseInt(parts[4].trim());
                    int TaiBan = Integer.parseInt(parts[5].trim());
                    String TenNhaXuatBan = parts[6];
                    int NamXuatBan = Integer.parseInt(parts[7].trim());
                    int soluongsach = Integer.parseInt(parts[8].trim());
                    Sach sach = new Sach(MaSach, TenSach, TenLinhVuc, TenLoaiSach, GiaBia, TaiBan, TenNhaXuatBan,
                            NamXuatBan, soluongsach);
                    danhSachSach[index++] = sach;
                }
            }
        } catch (IOException e) {
            System.out.println("Co loi trong qua trinh doc file");
            e.printStackTrace();
        }
        return danhSachSach;
    }

    public static Sach[] phanLoaiTheoGiaBia(Sach[] danhSachSach, int giaMin, int giaMax) {
        Sach[] sachTheoGiaBia = new Sach[danhSachSach.length];
        int index = 0;
        for (Sach sach : danhSachSach) {
            if (sach.getGiaBia() >= giaMin && sach.getGiaBia() <= giaMax) {
                sachTheoGiaBia[index++] = sach;
            }
        }
        return sachTheoGiaBia;
    }

    public static Sach[] phanLoaiTheoLinhVuc(Sach[] danhSachSach, String linhVuc) {
        Sach[] sachTheoLinhVuc = new Sach[danhSachSach.length];
        int index = 0;
        for (Sach sach : danhSachSach) {
            if (sach.getTenLinhVuc() != null && sach.getTenLinhVuc().equals(linhVuc)) {
                sachTheoLinhVuc[index++] = sach;
            }
        }
        return sachTheoLinhVuc;
    }

    public static Sach[] phanLoaiTheoLoaiSach(Sach[] danhSachSach, String loaiSach) {
        Sach[] sachTheoLoaiSach = new Sach[danhSachSach.length];
        int index = 0;
        for (Sach sach : danhSachSach) {
            if (sach.getTenLoaiSach() != null && sach.getTenLoaiSach().equals(loaiSach)) {
                sachTheoLoaiSach[index++] = sach;
            }
        }
        return sachTheoLoaiSach;
    }

    public static Sach[] phanLoaiNhaXuatBan(Sach[] danhSachSach, String nhaxuatban) {
        Sach[] sachTheoNhaXuatBan = new Sach[danhSachSach.length];
        int index = 0;
        for (Sach sach : danhSachSach) {
            if (sach.getTenNhaXuatBan() != null && sach.getTenNhaXuatBan().equals(nhaxuatban)) {
                sachTheoNhaXuatBan[index++] = sach;
            }
        }
        return sachTheoNhaXuatBan;
    }

    public static void MenuPhanLoai(Sach[] danhSachSach, HoaDonItem[] hoaDonItems, DanhSachTK ds) {
        ds.docDuLieuTuFile("DanhSachTaiKhoan.txt");
        DocDuLieuTuFileSach("Sach.txt", danhSachSach);
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println(
                    "------------------------------------------------------------------------------------------------------------------");
            System.out.println("Phan loai sach theo: ");
            System.out.println("[0] Thoat phan loai sach.");
            System.out.println("[1] Gia bia.");
            System.out.println("[2] Linh vuc.");
            System.out.println("[3] The loai.");
            System.out.println("[4] Nha xuat ban.");
            System.out.print("Chon de phan loai: ");
            boolean shouldExit = false;
            String input = sc.next();
            if (isNumeric(input)) {
                choice = Integer.parseInt(input);
                switch (choice) {
                    // ...
                }
            }
            if (shouldExit) {
                break;
            }
        }
    }

    public static void inDanhSachSach(Sach[] danhSachSach) {
        if (danhSachSach.length == 0 || danhSachSach[0] == null) {
            System.out.println("Khong co sach phu hop.");
        } else {
            System.out.println("Danh sach sach:");
            for (Sach sach : danhSachSach) {
                if (sach != null) {
                    System.out.println(sach);
                }
            }
        }
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+");
    }
}
