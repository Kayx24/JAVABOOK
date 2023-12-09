import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class QuyenSach {
    private Sach[] danhSachSach = new Sach[1000];
    private int soLuongSach;
    private Scanner sc;
    private boolean isAdmin;

    public QuyenSach() {
        this.sc = new Scanner(System.in);
        this.isAdmin = false;
    }

    public void themSach(int maSach, String tenSach, String tenLinhVuc, String tenLoaiSach, int giaBia, int taiBan,
                         String tenNhaXuatBan, int namXuatBan, int soLuongSach) {
        if (soLuongSach < 1000) {
            Sach sach = new Sach(maSach, tenSach, tenLinhVuc, tenLoaiSach, giaBia, taiBan, tenNhaXuatBan, namXuatBan, soLuongSach);
            danhSachSach[soLuongSach] = sach;
            soLuongSach++;
            ghiSachVaoFile(sach);
        } else {
            System.out.println("Danh sach sach da dat toi gioi han (1000 phan tu). Khong the them moi.");
        }
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
        
        int soLuongSach;
            do {
            System.out.print("So luong sach: ");
            if (sc.hasNextInt()) {
                soLuongSach = sc.nextInt();
                break;
            } else {
                System.out.println("so luong khong hop le, vui long nhap lai.");
                sc.next();
            }
        } while (true);
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
    public void ghiDanhSachSachVaoFile(String tenFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tenFile))) {
            for (int i = 0; i < soLuongSach; i++) {
                writer.write(danhSachSach[i].toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    

    public void chinhSuaThongTinSach() {
        danhSachSach = docDanhSachSachTuFile("sach.txt");
        System.out.print("Nhap ma sach can sua: ");
        int maSach = sc.nextInt();
        sc.nextLine();

        for (Sach sach : danhSachSach) {
            if (sach != null && sach.getMaSach() == maSach) {
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
                    ghiDanhSachSachVaoFile("Sach.txt");
                    return;
                }
            }
            System.out.println("Khong tim thay sach co ma " + maSach);
        }

        public void xoaSach(int maSachXoa) {
danhSachSach = docDanhSachSachTuFile("Sach.txt");
    
            int index = -1;
    
            for (int i = 0; i < soLuongSach; i++) {
                Sach sach = danhSachSach[i];
                if (sach != null && sach.getMaSach() == maSachXoa) {
                    index = i;
System.out.println("Tim thay sach co ma " + maSachXoa);
                    break;
                }
            }
    
            if (index != -1) {
                for (int i = index; i < soLuongSach - 1; i++) {
                    danhSachSach[i] = danhSachSach[i + 1];
                }
                danhSachSach[soLuongSach - 1] = null;
                soLuongSach--;
                ghiDanhSachSachVaoFile("Sach.txt");
                System.out.println("Da xoa sach co ma " + maSachXoa);
            } else {
                System.out.println("Khong tim thay sach co ma " + maSachXoa);
            }
        }
    

    private Sach[] docDanhSachSachTuFile(String file) {
        Sach[] danhSachSach = new Sach[1000];
        int soLuong = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 9) {
                    int maSach = Integer.parseInt(parts[0].trim());
                    String tenSach = parts[1].trim();
                    String tenLinhVuc = parts[2].trim();
                    String tenLoaiSach = parts[3].trim();
                    int giaBia = Integer.parseInt(parts[4].trim());
                    int taiBan = Integer.parseInt(parts[5].trim());
                    String tenNhaXuatBan = parts[6].trim();
                    int namXuatBan = Integer.parseInt(parts[7].trim());
                    int soLuongSach = Integer.parseInt(parts[8].trim());
                    Sach sach = new Sach(maSach, tenSach, tenLinhVuc, tenLoaiSach, giaBia, taiBan, tenNhaXuatBan, namXuatBan, soLuongSach);
                    
                    if (soLuong < 1000) {
                        danhSachSach[soLuong] = sach;
                        soLuong++;
                    } else {
                        System.out.println("Danh sach sach da dat toi gioi han (1000 phan tu). Khong the doc them.");
                        break;
                    }
                }
            }
            br.close();
            this.soLuongSach = soLuong;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Arrays.copyOf(danhSachSach, soLuong);
    }


    public boolean isAdmin() {
        return isAdmin;
    }
}
