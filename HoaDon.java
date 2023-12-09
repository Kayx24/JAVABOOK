import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.xml.sax.SAXException;

public class HoaDon {

    public static void hoaDon(HoaDonItem[] hoaDonItems) {
        Sach[] danhSachSach = docDanhSachSachTuFile("Sach.txt");
        Scanner sc = new Scanner(System.in);
        boolean checkBuy = false;
        int hoaDonItemCount = 0;

        while (true) {
            System.out.println("[1] Thanh toan: ");
            System.out.println("[0] Thoat: ");
            System.out.println("Nhap ten sach can mua: ");

            String tenSachMua = sc.nextLine();
            if (tenSachMua.equals("0"))
                break;
            if (tenSachMua.equals("1")) {
                if (checkBuy) {
                    thucHienThanhToan(hoaDonItems, hoaDonItemCount);
                } else {
                    System.out.println("Ban khong the thanh toan neu chua mua sach.");
                }
                break;
            }

            Sach sachDaChon = null;

            for (Sach sach : danhSachSach) {
                if (sach.getTenSach().equalsIgnoreCase(tenSachMua)) {
                    sachDaChon = sach;
                    checkBuy = true; // Đặt biến này thành true nếu khách hàng mua sách
                    break;
                }
            }

            if (sachDaChon != null) {
                // Kiểm tra số lượng sách còn đủ hay không
                while (true) {
                    System.out.print("Nhap so luong sach can mua: ");
                    if (sc.hasNextInt()) {
                        int soLuongMua = sc.nextInt();
                        if (soLuongMua > 0 && sachDaChon.getSoLuongSach() >= soLuongMua) {
                            double giaSach = sachDaChon.getGiaBia();
                            double tongTienSach = giaSach * soLuongMua;
                            sc.nextLine();

                            // Cập nhật số lượng sách còn lại
                            sachDaChon.setSoLuongSach(sachDaChon.getSoLuongSach() - soLuongMua);

                            Date ngayDatSach = new Date();

                            // Lấy danh sách tài khoản đã đăng nhập từ class DangNhap
                            TaiKhoan[] danhSachTaiKhoanDaDangNhap = DangNhap.getDanhSachTaiKhoanDaDangNhapArray();

                            if (danhSachTaiKhoanDaDangNhap.length > 0) {
                                TaiKhoan taiKhoanDaDangNhap = danhSachTaiKhoanDaDangNhap[0]; // Lấy tài khoản đầu tiên (có thể điều chỉnh)
                                String maKhachHang = taiKhoanDaDangNhap.getUserName();
                                hoaDonItems[hoaDonItemCount++] = new HoaDonItem(maKhachHang, ngayDatSach, tenSachMua, soLuongMua, giaSach, tongTienSach);

                                hienThiTatCaHoaDon(hoaDonItems, hoaDonItemCount);
                            }
                            break;

                        } else {
                            System.out.println("Xin loi so luong sach khong du!");
                        }
                    } else {
                        System.out.println("Xin loi, nhap so luong sach la mot so nguyen!");
                        sc.next(); // Consume the invalid input
                    }
                }
            } else {
                System.out.println("Khong tim thay sach trong he thong.");
            }
        }
        //======nho kt lai======
        // luuHoaDonVaoTep(hoaDonItems, hoaDonItemCount);
    }

public static double tinhTongTien(HoaDonItem[] hoaDonItems, int hoaDonItemCount) {
    double tongTien = 0;
    for (int i = 0; i < hoaDonItemCount; i++) {
        tongTien += hoaDonItems[i].getTongTien();
    }
    return tongTien;
}

public static Sach[] docDanhSachSachTuFile(String File) {
    Sach[] danhSachSach = new Sach[1000]; // Assuming a maximum size of 1000
    int count = 0;
    try {
        BufferedReader br = new BufferedReader(new FileReader(File));
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
                danhSachSach[count++] = sach;
            }
        }
        br.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return Arrays.copyOf(danhSachSach, count);
}

public static void luuHoaDonVaoTep(HoaDonItem[] hoaDonItems, int hoaDonItemCount) {
    try {
        BufferedWriter bw = new BufferedWriter(new FileWriter("hoadon.txt", true));
        // bw.newLine();
        for (int i = 0; i < hoaDonItemCount; i++) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String ngayDatSachStr = dateFormat.format(hoaDonItems[i].getNgayDatSach());
            bw.write(hoaDonItems[i].getMaKhachHang() + "," + ngayDatSachStr + "," + hoaDonItems[i].getTenSach() + ","
                    + hoaDonItems[i].getSoLuongMua() + "," + hoaDonItems[i].getGiaSach() + "," + hoaDonItems[i].getTongTien());
            bw.newLine();
        }
        bw.newLine();
        bw.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public static void hienThiTatCaHoaDon(HoaDonItem[] hoaDonItems, int hoaDonItemCount) {
    if (hoaDonItemCount == 0) {
        System.out.println("Khong co hoa don!.");
        return;
    }

    SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
    double tongTien = 0;

    System.out.println("hoa don tong cua khach hang la:");
    System.out.println("+------------------+------------------+-------------------+---------------+----------+---------------+");
    System.out.println("| Ma khach hang    | Ngay dat sach    | Ten sach          | So luong      | Gia tien | Tong tien     |");
    System.out.println("+------------------+------------------+-------------------+---------------+----------+---------------+");

    for (int i = 0; i < hoaDonItemCount; i++) {
        String ngayDatSachStr = date.format(hoaDonItems[i].getNgayDatSach());
        System.out.printf("| %-16s | %-16s | %-17s | %-13d | %-8.1f | %-13.1f |\n", hoaDonItems[i].getMaKhachHang(),
                ngayDatSachStr, hoaDonItems[i].getTenSach(), hoaDonItems[i].getSoLuongMua(), hoaDonItems[i].getGiaSach(),
                hoaDonItems[i].getTongTien());
        tongTien += hoaDonItems[i].getTongTien();
    }

    System.out.println("+------------------+------------------+-------------------+---------------+----------+---------------+");
    System.out.printf("| %98s |\n", "Tong so tien can thanh toan: " + tongTien + " VND");
    System.out.println("+----------------------------------------------------------------------------------------------------+");
}

public static void thucHienThanhToan(HoaDonItem[] hoaDonItems, int hoaDonItemCount) {
    // Hiển thị tổng hóa đơn
    hienThiTatCaHoaDon(hoaDonItems, hoaDonItemCount);
    Scanner sc = new Scanner(System.in);
    int choice;

    while (true) {
        System.out.println("Chon hinh thuc thanh toan:");
        System.out.println("[1] Thanh toan bang ngan hang");
        System.out.println("[2] Thanh toan bang Momo");

        while (!sc.hasNextInt()) {
            System.out.println("GIA TRI KHONG HOP LE. VUI LONG NHAP LAI");
            sc.next(); // consume the non-integer input
        }

        choice = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                thanhToanNganHang(hoaDonItems, hoaDonItemCount);
                // After successful payment, update the quantity in the file
                for (HoaDonItem item : hoaDonItems) {
                    if(item!=null){
                        capNhatSoLuongSachTrongFile(item.getTenSach(), item.getSoLuongMua());
                    }
                }
                break;
            case 2:
                thanhToanMomo(hoaDonItems, hoaDonItemCount);
                // After successful payment, update the quantity in the file
                for (HoaDonItem item : hoaDonItems) {
                    if(item!=null){
                        capNhatSoLuongSachTrongFile(item.getTenSach(), item.getSoLuongMua());
                    }
                }
                break;
            default:
                System.out.println("Lua chon khong hop le.");
                continue;
        }
        break;
    }
}


public static void thanhToanNganHang(HoaDonItem[] hoaDonItems,int hoaDonItemCount) {
    Scanner sc = new Scanner(System.in);

    if (hoaDonItems.length == 0) {
        System.out.println("Khong co hoa don de thanh toan.");
        return;
    }
    hienThiTatCaHoaDon(hoaDonItems,hoaDonItemCount);

    // Chọn ngân hàng thanh toán
    String tenNganHang = "";
    int bankChoice;
    
    while (true) {
        System.out.println("Chon ngan hang thanh toan:");
        System.out.println("[1] BIDV");
        System.out.println("[2] Agribank");
        System.out.println("[3] MB Bank");
        System.out.println("[4] Viettinbank");
        System.out.println("[5] Vietcombank");

        if (sc.hasNextInt()) {
            bankChoice = sc.nextInt();
            sc.nextLine();

            if (bankChoice >= 1 && bankChoice <= 5) {
                switch (bankChoice) {
                    case 1:
                        tenNganHang = "BIDV";
                        break;
                    case 2:
                        tenNganHang = "Agribank";
                        break;
                    case 3:
                        tenNganHang = "MB Bank";
                        break;
                    case 4:
                        tenNganHang = "Viettinbank";
                        break;
                    case 5:
                        tenNganHang = "Vietcombank";
                        break;
                }
                break; // exit the loop if a valid choice is made
            } else {
                System.out.println("Lua chon ngan hang khong hop le.");
            }
        } else {
            System.out.println("GIA TRI KHONG HOP LE. VUI LONG NHAP LAI");
            sc.next(); // consume the invalid input
        }
    }

    String soTaiKhoan;

    do {
        System.out.print("Nhap so tai khoan (9 so): ");
        soTaiKhoan = sc.nextLine();
        if (soTaiKhoan.matches("\\d{9}") && !soTaiKhoan.matches(".*[a-zA-Z].*")) {
            break;
        } else {
            System.out.println("So tai khoan khong hop le. Vui long nhap lai.");
        }
    } while (true);

    double tongTienHoaDon = tinhTongTien(hoaDonItems,hoaDonItemCount);
    System.out.println("Tong tien hoa don: " + tongTienHoaDon + " VND");

    double money;
    do {
        System.out.print("Nhap so tien thanh toan: ");
        money = sc.nextDouble();
        sc.nextLine();

        // Kiểm tra số tiền thanh toán
        if (money != tongTienHoaDon) {
            System.out.println("So tien thanh toan khong dung. Vui long nhap lai.");
        }
    } while (money != tongTienHoaDon);

    System.out.println("Thanh toan thanh cong " + money + "vnd voi ngan hang " + tenNganHang + " tai khoan " + soTaiKhoan);

    luuHoaDonVaoTep(hoaDonItems,hoaDonItemCount);
    Arrays.fill(hoaDonItems, null); // Clear the array
}

public static void thanhToanMomo(HoaDonItem[] hoaDonItems,int hoaDonItemCount) {
    Scanner sc = new Scanner(System.in);

    if (hoaDonItems.length == 0) {
        System.out.println("Khong co hoa don de thanh toan.");
        return;
    }

    hienThiTatCaHoaDon(hoaDonItems,hoaDonItemCount);
    boolean isValidPhoneNumber = false;

    do {
        System.out.print("Nhap so dien thoai Momo: ");
        String soDienThoai = sc.nextLine();

        // Kiểm tra số điện thoại Momo
        if (soDienThoai.matches("\\d{10}")) {

            double tongTienHoaDon = tinhTongTien(hoaDonItems,hoaDonItemCount);
            System.out.println("Tong tien hoa don: " + tongTienHoaDon + " VND");

            double money;
            do {
                System.out.print("Nhap so tien thanh toan: ");
                money = sc.nextDouble();
                sc.nextLine();

                // Kiểm tra số tiền thanh toán
                if (money == tongTienHoaDon) {
                    System.out.println("Thanh toan thanh cong " + money + "đ qua Momo voi so dien thoai " + soDienThoai);
                    luuHoaDonVaoTep(hoaDonItems,hoaDonItemCount);
                    Arrays.fill(hoaDonItems, null); // Clear the array
                    isValidPhoneNumber = true;
                } else {
                    System.out.println("So tien thanh toan khong dung. Vui long nhap lai.");
                }
            } while (money != tongTienHoaDon);
        } else {
            System.out.println("So dien thoai Momo khong hop le. Vui long nhap lai.");
        }
    } while (!isValidPhoneNumber);
}

    public static void capNhatSoLuongSachTrongFile(String tenSach, int soLuongMua) {
        Sach[] danhSachSach = docDanhSachSachTuFile("Sach.txt");
        for (Sach sach : danhSachSach) {
            if (sach.getTenSach().equalsIgnoreCase(tenSach)) {
                // Cập nhật số lượng sách còn lại
                sach.setSoLuongSach(sach.getSoLuongSach() - soLuongMua);
                break;
            }
        }
        luuDanhSachSachVaoFile(danhSachSach, "Sach.txt");
    }

    public static void luuDanhSachSachVaoFile(Sach[] danhSachSach, String file) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (Sach sach : danhSachSach) {
                String line = sach.getMaSach() + "," + sach.getTenSach() + "," + sach.getTenLinhVuc() + "," + sach.getTenLoaiSach() + ","
                        + (int) sach.getGiaBia() + "," + sach.getTaiBan() + "," + sach.getTenNhaXuatBan() + "," + sach.getNamXuatBan() + ","
                        + sach.getSoLuongSach();
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
