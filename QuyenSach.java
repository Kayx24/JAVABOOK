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
        this.danhSachSach = docDanhSachSachTuFile("Sach.txt");
        this.soLuongSach = danhSachSach.length;
    }

    public void themSach(int maSach, String tenSach, String tenLinhVuc, String tenLoaiSach, int giaBia, int taiBan,
                     String tenNhaXuatBan, int namXuatBan, int soSach) {
    if (soLuongSach < 1000) {
        Sach sach = new Sach(maSach, tenSach, tenLinhVuc, tenLoaiSach, giaBia, taiBan, tenNhaXuatBan, namXuatBan, soSach);
        
        if (soLuongSach == danhSachSach.length) {
            danhSachSach = Arrays.copyOf(danhSachSach, danhSachSach.length + 100);
        }
        danhSachSach[soLuongSach] = sach;
        soLuongSach++;
        ghiSachVaoFile(sach);
    }
}


    private boolean kiemTraMaSachTonTai(int maSach) {
        for (int i = 0; i < soLuongSach; i++) {
            if (danhSachSach[i] != null && danhSachSach[i].getMaSach() == maSach) {
                return true;
            }
        }
        return false;
    }

    public void nhapThongTinSachMoi() {
        System.out.println("Nhap thong tin sach moi:");
        int maSach;
        do {
            System.out.print("Ma sach: ");
            if (sc.hasNextInt()) {
                maSach = sc.nextInt();
                if (kiemTraMaSachTonTai(maSach)) {
                    System.out.println("Ma sach da ton tai. Vui long nhap lai.");
                } else {
                    break;
                }
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
        
        int soSach;
            do {
            System.out.print("So luong sach: ");
            if (sc.hasNextInt()) {
                soSach = sc.nextInt();
                break;
            } else {
                System.out.println("so luong khong hop le, vui long nhap lai.");
                sc.next();
            }
        } while (true);
        themSach(maSach, tenSach, tenLinhVuc, tenLoaiSach, giaBia, taiBan, tenNhaXuatBan, namXuatBan,soSach);
    }

    private static void ghiSachVaoFile(Sach sach) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Sach.txt", true))) {
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
        danhSachSach = docDanhSachSachTuFile("Sach.txt");
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
                    int giaBia;
                    do {
                        if (sc.hasNextInt()) {
                            giaBia = sc.nextInt();
                            break;
                        } else {
                            System.out.println("Gia bia khong hop le, vui long nhap lai.");
                    sc.next();
}
                    } while (true);
                    sach.setGiaBia(giaBia);
    
                    System.out.println("So lan tai ban hien tai: " + sach.getTaiBan());
                    System.out.print("Nhap so lan tai ban moi: ");
                    int taiBan;
                    do {
                        if (sc.hasNextInt()) {
                            taiBan = sc.nextInt();
                            break;
                        } else {
                            System.out.println("Tai ban khong hop le, vui long nhap lai.");
                    sc.next();
}
                    } while (true);
                    sach.setTaiBan(taiBan);
    
                    System.out.println("Ten nha xuat ban hien tai: " + sach.getTenNhaXuatBan());
                    System.out.print("Nhap ten nha xuat ban moi: ");
                    String tenNhaXuatBan = sc.nextLine();
                    sach.setTenNhaXuatBan(tenNhaXuatBan);
    
                    System.out.println("Nam xuat ban hien tai: " + sach.getNamXuatBan());
                    System.out.print("Nhap nam xuat ban moi: ");
                    int namXuatBan;
                    do {
                        if (sc.hasNextInt()) {
                            namXuatBan = sc.nextInt();
break;
                        } else {
                            System.out.println("Gia bia khong hop le, vui long nhap lai.");
                            sc.next();
                        }
                    } while (true);
                    sc.nextLine();
                    sach.setNamXuatBan(namXuatBan);
    
                    System.out.println("So luong sach hien tai: " + sach.getSoLuongSach());
                    System.out.print("So luong sach moi: ");
                    int sosach;
                    do {
                        if (sc.hasNextInt()) {
                            sosach = sc.nextInt();
                            break;
                        } else {
                            System.out.println("Gia bia khong hop le, vui long nhap lai.");
                    sc.next();
}
                    } while (true);
                    sach.setSoLuongSach(sosach);
    
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
        public static void quanLySachMenu(DanhSachTK danhSachTK,Sach[] danhSachSach, HoaDonItem[] hoaDonItems, DanhSachTK ds, NhanVien[] dsNhanViens) {
            int choice;
            Scanner sc = new Scanner(System.in);
            Admin adm= new Admin();
            QuyenSach quyenSach = new QuyenSach();
            while (true) {
        
                System.out.println("[1] Them sach moi");
                System.out.println("[2] Chinh sua thong tin sach");
                System.out.println("[3] Xoa sach");
                System.out.println("[0] Quay lai");
    
                System.out.print("Nhap lua chon cua ban: ");
                String input = sc.next();
    
                if (isNumeric(input)) {
                    choice = Integer.parseInt(input);
                    switch (choice) {
                    case 1:
                        quyenSach.nhapThongTinSachMoi();
                        break;
                    case 2:
                        quyenSach.chinhSuaThongTinSach();
                        break;
                    case 3:
                        System.out.print("Nhap ma sach can xoa: ");
                        int maSachXoa = sc.nextInt();
                        quyenSach.xoaSach(maSachXoa);
                        break;
                    case 0:
                        Admin.MenuAdmin(danhSachSach, hoaDonItems, ds, dsNhanViens);
                        break;
                    default:
                        System.out.println("Lua chon khong hop le. Vui long nhap lai.");
                        break;
                }
            } else {
                System.out.println("Vui long nhap mot so.");
            }
        }
        
    }
    

        public Sach[] docDanhSachSachTuFile(String file) {
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
                        int soSach = Integer.parseInt(parts[8].trim());
                        Sach sach = new Sach(maSach, tenSach, tenLinhVuc, tenLoaiSach, giaBia, taiBan, tenNhaXuatBan, namXuatBan, soSach);
    
                        if (soLuong < 1000) {
                            danhSachSach[soLuong] = sach;
                            soLuong++;
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
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
