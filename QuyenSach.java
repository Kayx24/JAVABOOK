import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class QuyenSach {
    private List<Sach> danhSachSach = new ArrayList<>();
    private Scanner sc;
    private boolean isAdmin;

    public void kiemtraDangNhap() {
        System.out.print("Nhap ten dang nhap: ");
        String tenDangNhap = sc.nextLine();
        System.out.print("Nhap mat khau: ");
        String matKhau = sc.nextLine();

        if (tenDangNhap.equals("admin") && matKhau.equals("121")) {
            isAdmin = true;
            System.out.println("Dang nhap thanh cong vao tai khoan admin ");
        } else {
            isAdmin = false;
            System.out.println("Dang nhap vao quyen khac ");
        }
    }

    public QuyenSach() {
        this.sc = new Scanner(System.in);
        this.isAdmin = false;
    }

    public void themSach(int maSach, String tenSach,String tenLinhVuc, String tenLoaiSach, int giaBia, int taiBan,
                         String tenNhaXuatBan, int namXuatBan,int soLuongSach) {
        Sach sach = new Sach(maSach, tenSach, tenLinhVuc, tenLoaiSach, giaBia, taiBan, tenNhaXuatBan, namXuatBan,soLuongSach);
        danhSachSach.add(sach);
        ghiSachVaoFile(sach);
    }

    public void nhapThongTinSachMoi() {
        System.out.println("Nhap thong tin sach moi:");
        int maSach ;
        do {
            System.out.print("Ma sach: ");
            if (sc.hasNextInt()) {
                maSach = sc.nextInt();
                break; // Thoát khỏi vòng lặp nếu giá trị là số
            } else {
                System.out.println("Ma sach khong hop le, vui long nhap lai.");
                sc.next(); // Đọc bỏ giá trị không hợp lệ khỏi bộ đệm đầu vào
            }
        } while (true);
        sc.nextLine();
        System.out.print("Ten sach: ");
        String tenSach = sc.nextLine();
        System.out.print("Linh vuc: ");
        String tenLinhVuc = sc.nextLine();
        System.out.print("Ten loai sach: ");
        String tenLoaiSach = sc.nextLine();
        System.out.print("Gia bia: ");
        int giaBia;
                do {
            System.out.print("Gia bia: ");
            if (sc.hasNextInt()) {
                giaBia = sc.nextInt();
                break;
            } else {
                System.out.println("Gia bia khong hop le, vui long nhap lai.");
                sc.next();
            }
        } while (true);
        sc.nextLine();
        System.out.print("So lan tai ban: ");
        int taiBan;
                    do {
            System.out.print("So lan tai ban: ");
            if (sc.hasNextInt()) {
                taiBan = sc.nextInt();
                break;
            } else {
                System.out.println("Tai ban khong hop le, vui long nhap lai.");
                sc.next();
            }
        } while (true);
        sc.nextLine();
        System.out.print("Ten nha xuat ban: ");
        String tenNhaXuatBan = sc.nextLine();
        System.out.print("Nam xuat ban: ");
        int namXuatBan;
            do {
            System.out.print("Nam tai ban: ");
            if (sc.hasNextInt()) {
                namXuatBan = sc.nextInt();
                break;
            } else {
                System.out.println("Nam tai ban khong hop le, vui long nhap lai.");
                sc.next();
            }
        } while (true);   
        sc.nextLine();
        System.out.print("So luong sach: ");
        int soLuongSach = sc.nextInt();
        sc.nextLine();

        themSach(maSach, tenSach, tenLinhVuc, tenLoaiSach, giaBia, taiBan, tenNhaXuatBan, namXuatBan,soLuongSach);
    }

    private static void ghiSachVaoFile(Sach sach) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("sach.txt", true))) {
            writer.write(sach.toStringFirstTime());
            writer.newLine(); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void ghiDanhSachSachVaoFile(String tenFile, List<Sach> danhSachSach) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tenFile))) {
            for (Sach sach : danhSachSach) {
                writer.write(sach.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    

    public void chinhSuaThongTinSach() {
        System.out.print("Nhap ma sach can sua: ");
        int maSach = sc.nextInt();
        sc.nextLine();

        for (Sach sach : danhSachSach) {
            if (sach.getMaSach() == maSach) {
                System.out.println("Thong tin sach can sua:");
                System.out.println("Ten sach hien tai: " + sach.getTenSach());
                System.out.print("Nhap ten sach moi: ");
                String tenSach = sc.nextLine();
                sach.setTenSach(tenSach);

                System.out.println("Ten loai sach hien tai: " + sach.getTenLoaiSach());
                System.out.print("Nhap ten loai sach moi: ");
                String tenLoaiSach = sc.nextLine();
                sach.setTenLoaiSach(tenLoaiSach);

                System.out.println("Gia sach hien tai: " + sach.getGiaBia());
                System.out.print("Nhap gia sach moi: ");
                int giaBia = sc.nextInt();
                sc.nextLine();
                sach.setGiaBia(giaBia);

                System.out.println("So lan tai ban hien tai: " + sach.getTaiBan());
                System.out.print("Nhap so lan tai ban moi: ");
                int taiBan = sc.nextInt();
                sc.nextLine();
                sach.setTaiBan(taiBan);

                System.out.println("Ten nha xuat ban hien tai: " + sach.getTenNhaXuatBan());
                System.out.print("Nhap ten nha xuat ban moi: ");
                String tenNhaXuatBan = sc.nextLine();
                sach.setTenNhaXuatBan(tenNhaXuatBan);

                System.out.println("Nam xuat ban hien tai: " + sach.getNamXuatBan());
                System.out.print("Nhap nam xuat ban moi: ");
                int namXuatBan = sc.nextInt();
                sc.nextLine();
                sach.setNamXuatBan(namXuatBan);

                System.out.println("Nam xuat ban hien tai: " + sach.getNamXuatBan());
                System.out.print("Nhap nam xuat ban moi: ");
                int soluongsach = sc.nextInt();
                sc.nextLine();
                sach.setSoLuongSach(soluongsach);

                System.out.println("Da sua thong tin sach.");
                return;
            }
        }
        System.out.println("Khong tim thay sach co ma " + maSach);
    }

    public void xoaSach(int maSach) {
        Iterator<Sach> iterator = danhSachSach.iterator();
        while (iterator.hasNext()) {
            Sach sach = iterator.next();
            if (sach.getMaSach() == maSach) {
                iterator.remove();
                System.out.println("Da xoa sach co ma " + maSach);
                return;
            }
        }
        System.out.println("Khong tim thay sach co ma " + maSach);
    }

    public List<Sach> getDanhSachSach() {
        return danhSachSach;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
