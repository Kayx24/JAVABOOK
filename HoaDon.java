
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HoaDon {
    public static void hoaDon(List<HoaDonItem> hoaDonItems) {
        List<Sach> danhSachSach = docDanhSachSachTuFile("Sach.txt");
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("Nhap ten sach can mua: ");
            System.out.println("[1] Thanh toan: ");
            System.out.println("[0] Thoat: ");

            String tenSachMua = sc.nextLine();
            if(tenSachMua.equalsIgnoreCase("0"))
                break;
            if(tenSachMua.equalsIgnoreCase("1")) {
                thucHienThanhToan(hoaDonItems);
                break;
            }
            Sach sachDaChon = null;

            for (Sach sach : danhSachSach) {
                if (sach.getTenSach().equalsIgnoreCase(tenSachMua)) {
                    sachDaChon = sach;
                    break;
                }
            }

            if (sachDaChon != null) {
                System.out.print("Nhap so luong sach can mua: ");
                int soLuongMua = sc.nextInt();
                double giaSach = sachDaChon.getGiaBia();
                double tongTienSach = giaSach * soLuongMua;
                sc.nextLine();

                Date ngayDatSach = new Date(); // Lấy ngày hiện tại

                // Lấy danh sách tài khoản đã đăng nhập từ class DangNhap
                List<TaiKhoan> danhSachTaiKhoanDaDangNhap = DangNhap.getDanhSachTaiKhoanDaDangNhap();

                if (!danhSachTaiKhoanDaDangNhap.isEmpty()) {
                    TaiKhoan taiKhoanDaDangNhap = danhSachTaiKhoanDaDangNhap.get(0); // Lấy tài khoản đầu tiên (có thể cần điều chỉnh)
                    String maKhachHang = taiKhoanDaDangNhap.getUserName();
                    hoaDonItems.add(new HoaDonItem(maKhachHang, ngayDatSach, tenSachMua, soLuongMua, giaSach, tongTienSach));
                    hienThiHoaDon(hoaDonItems, maKhachHang);
                }
            } else {
                System.out.println("Khong tim thay sach trong he thong.");
            }
        }
        //======nho kt lai====
        // luuHoaDonVaoTep(hoaDonItems);
    }

    public static double tinhTongTien(List<HoaDonItem> hoaDonItems) {
        double tongTien = 0;
        for (HoaDonItem item : hoaDonItems) {
            tongTien += item.getTongTien();
        }
        return tongTien;
    }

    public static List<Sach> docDanhSachSachTuFile(String File) {
        List<Sach> danhSachSach = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(File));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 8) {
                    int maSach = Integer.parseInt(parts[0]);
                    String tenSach = parts[1];
                    String tenLinhVuc = parts[2];
                    String tenLoaiSach = parts[3];
                    int giaBia = Integer.parseInt(parts[4]);
                    int taiBan = Integer.parseInt(parts[5]);
                    String tenNhaXuatBan = parts[6];
                    int namXuatBan = Integer.parseInt(parts[7]);
                    Sach sach = new Sach(maSach, tenSach, tenLinhVuc, tenLoaiSach, giaBia, taiBan, tenNhaXuatBan, namXuatBan);
                    danhSachSach.add(sach);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return danhSachSach;
    }

    public static void luuHoaDonVaoTep(List<HoaDonItem> hoaDonItems) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("hoadon.txt", true));
            bw.newLine();
            for (HoaDonItem item : hoaDonItems) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String ngayDatSachStr = dateFormat.format(item.getNgayDatSach());
                bw.write(item.getMaKhachHang() + "," + ngayDatSachStr + "," + item.getTenSach() + "," + item.getSoLuongMua() + "," + item.getGiaSach() + "," + item.getTongTien());
                bw.newLine();                
                
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void hienThiHoaDon(List<HoaDonItem> hoaDonItems, String maKhachHang) {
        System.out.println("Hoa don cua ban:");
        System.out.println("+------------------+------------------+-------------------+---------------+----------+---------------+");
        System.out.println("| Ma khach hang    | Ngay dat sach    | Ten sach          | So luong      | Gia tien | Tong tien     |");
        System.out.println("+------------------+------------------+-------------------+---------------+----------+---------------+");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        double tongTien = 0;

        for (HoaDonItem item : hoaDonItems) {
            if (item.getMaKhachHang().equals(maKhachHang)) {
                String ngayDatSachStr = dateFormat.format(item.getNgayDatSach());
                System.out.printf("| %-16s | %-16s | %-17s | %-13d | %-8.1f | %-13.1f |\n", item.getMaKhachHang(), ngayDatSachStr, item.getTenSach(), item.getSoLuongMua(), item.getGiaSach(), item.getTongTien());
                tongTien += item.getTongTien();
            }
        }

        System.out.println("+------------------+------------------+-------------------+---------------+----------+---------------+");
        System.out.printf("| %98s |\n", "So tien can thanh toan: " + tongTien + " VND");
        System.out.println("+----------------------------------------------------------------------------------------------------+");
    }
    public static void hienThiTatCaHoaDon(List<HoaDonItem> hoaDonItems) {
        if (hoaDonItems.isEmpty()) {
            System.out.println("Khong co hoa don!.");
            return;
        }
    
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        double tongTien = 0;
    
        System.out.println("hoa don tong cua khach hang la:");
        System.out.println("+------------------+------------------+-------------------+---------------+----------+---------------+");
        System.out.println("| Ma khach hang    | Ngay dat sach    | Ten sach          | So luong      | Gia tien | Tong tien     |");
        System.out.println("+------------------+------------------+-------------------+---------------+----------+---------------+");
    
        for (HoaDonItem item : hoaDonItems) {
            String ngayDatSachStr = dateFormat.format(item.getNgayDatSach());
            System.out.printf("| %-16s | %-16s | %-17s | %-13d | %-8.1f | %-13.1f |\n", item.getMaKhachHang(), ngayDatSachStr, item.getTenSach(), item.getSoLuongMua(), item.getGiaSach(), item.getTongTien());
            tongTien += item.getTongTien();
        }
    
        System.out.println("+------------------+------------------+-------------------+---------------+----------+---------------+");
        System.out.printf("| %98s |\n", "Tong so tien can thanh toan: " + tongTien + " VND");
        System.out.println("+----------------------------------------------------------------------------------------------------+");
    }

    public static void thucHienThanhToan(List<HoaDonItem> hoaDonItems) {
        // Hiển thị tổng hóa đơn
        hienThiTatCaHoaDon(hoaDonItems);
        Scanner sc = new Scanner(System.in);
        // Xử lý thanh toán
        System.out.println("Chon hinh thuc thanh toan:");
        System.out.println("[1] Thanh toan bang ngan hang");
        System.out.println("[2] Thanh toan bang Momo");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                thanhToanNganHang(hoaDonItems);
                break;
            case 2:
                thanhToanMomo(hoaDonItems);
                break;
            default:
                System.out.println("Lua chon khong hop le.");
                break;
        }
    }

    public static void thanhToanNganHang(List<HoaDonItem> hoaDonItems) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Chon ngan hang thanh toan:");
        System.out.println("[1] BIDV");
        System.out.println("[2] Agribank");
        System.out.println("[3] MB Bank");
        System.out.println("[4] Viettinbank");
        System.out.println("[5] Vietcombank");
        int bankChoice = sc.nextInt();
        sc.nextLine();

        String tenNganHang = "";
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
            default:
                System.out.println("Lua chon ngan hang khong hop le.");
                return;
        }

        System.out.print("Nhap so tai khoan ngan hang: ");
        String soTaiKhoan = sc.nextLine();
        System.out.println("Thanh toan thanh cong voi ngan hang " + tenNganHang + " tai khoan " + soTaiKhoan);
        luuHoaDonVaoTep(hoaDonItems);
    }

    public static void thanhToanMomo(List<HoaDonItem> hoaDonItems) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so dien thoai Momo: ");
        String soDienThoai = sc.nextLine();
        System.out.println("Thanh toan thanh cong qua Momo voi so dien thoai " + soDienThoai);
        luuHoaDonVaoTep(hoaDonItems);
    }
}





// import java.util.Date;
// import java.text.SimpleDateFormat;
// import java.io.*;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;

// public class HoaDon {

//     public static void hoaDon(List<HoaDonItem> hoaDonItems) {
//         List<Sach> danhSachSach = docDanhSachSachTuFile("Sach.txt");
//         Scanner sc = new Scanner(System.in);
//         while (true) {
//             System.out.print("Nhap ten sach can mua (Nhap '0' de ket thuc): ");
//             String tenSachMua = sc.nextLine();

//             if (tenSachMua.equalsIgnoreCase("0")) {
//                 break;
//             }

//             Sach sachDaChon = null;

//             for (Sach sach : danhSachSach) {
//                 if (sach.getTenSach().equalsIgnoreCase(tenSachMua)) {
//                     sachDaChon = sach;
//                     break;
//                 }
//             }

//             if (sachDaChon != null) {
//                 System.out.print("Nhap so luong sach can mua: ");
//                 int soLuongMua = sc.nextInt();
//                 double giaSach = sachDaChon.getGiaBia();
//                 double tongTienSach = giaSach * soLuongMua;
//                 sc.nextLine(); // Đọc dòng trống sau số lượng

//                 Date ngayDatSach = new Date(); // Lấy ngày hiện tại

//                 System.out.print("Nhap ma khach hang: ");
//                 String maKhachHang = sc.nextLine();

//                 hoaDonItems.add(new HoaDonItem(maKhachHang, tenSachMua, soLuongMua, giaSach, tongTienSach, ngayDatSach));

//                 System.out.println("Hoa don cua ban:");
//                 System.out.println("+------------------+------------------+-------------------+---------------+----------+---------------+");
//                 System.out.println("| Ma khach hang    | Ngay dat sach    | Ten sach          | So luong      | Gia tien | Tong tien     |");
//                 System.out.println("+------------------+------------------+-------------------+---------------+----------+---------------+");
//                 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//                 String ngayDatSachStr = dateFormat.format(ngayDatSach);
//                 System.out.printf("| %-16s | %-16s | %-17s | %-13d | %-8.1f | %-13.1f |\n", maKhachHang, ngayDatSachStr, tenSachMua, soLuongMua, giaSach, tongTienSach);
//                 System.out.println("+------------------+------------------+-------------------+---------------+----------+---------------+");
//                 System.out.printf("| %98s |\n", "So tien can thanh toan: " + tinhTongTien(hoaDonItems) + " VND");
//                 System.out.println("+----------------------------------------------------------------------------------------------------+");
//             } else {
//                 System.out.println("Khong tim thay sach ban can.");
//             }
//         }
        
//         hienThiDanhSachSachMua(hoaDonItems);
//         luuHoaDonVaoTep(hoaDonItems);
//     }

//     public static double tinhTongTien(List<HoaDonItem> hoaDonItems) {
//         double tongTien = 0;
//         for (HoaDonItem item : hoaDonItems) {
//             tongTien += item.tongTien;
//         }
//         return tongTien;
//     }

//     public static List<Sach> docDanhSachSachTuFile(String File) {
//         List<Sach> danhSachSach = new ArrayList<>();
//         try {
//             BufferedReader br = new BufferedReader(new FileReader(File));
//             String line;
//             while ((line = br.readLine()) != null) {
//                 String[] parts = line.split(",");
//                 if (parts.length == 8) {
//                     int maSach = Integer.parseInt(parts[0]);
//                     String tenSach = parts[1];
//                     String tenLinhVuc = parts[2];
//                     String tenLoaiSach = parts[3];
//                     int giaBia = Integer.parseInt(parts[4]);
//                     int taiBan = Integer.parseInt(parts[5]);
//                     String tenNhaXuatBan = parts[6];
//                     int namXuatBan = Integer.parseInt(parts[7]);
//                     Sach sach = new Sach(maSach, tenSach, tenLinhVuc, tenLoaiSach, giaBia, taiBan, tenNhaXuatBan, namXuatBan);
//                     danhSachSach.add(sach);
//                 }
//             }
//             br.close();
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//         return danhSachSach;
//     }

//     public static void luuHoaDonVaoTep(List<HoaDonItem> hoaDonItems) {
//         try {
//             BufferedWriter bw = new BufferedWriter(new FileWriter("hoadon.txt", false));
//             for (HoaDonItem item : hoaDonItems) {
//                 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//                 String ngayDatSachStr = dateFormat.format(item.getNgayDatSach());
//                 bw.write(item.getMaKhachHang() + "," + ngayDatSachStr + "," + item.getTenSach() + "," + item.getSoLuongMua() + "," + item.getGiaSach() + "," + item.getTongTien());
//                 bw.newLine();
//             }
//             bw.close();
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     public static void hienThiDanhSachSachMua(List<HoaDonItem> hoaDonItems) {
//         System.out.println("Danh sach sach da mua:");
//         System.out.println("+------------------+------------------+-------------------+---------------+----------+---------------+");
//         System.out.println("| Ma khach hang    | Ngay dat sach    | Ten sach          | So luong      | Gia tien | Tong tien     |");
//         System.out.println("+------------------+------------------+-------------------+---------------+----------+---------------+");
//         SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//         for (HoaDonItem item : hoaDonItems) {
//             String ngayDatSachStr = dateFormat.format(item.getNgayDatSach());
//             System.out.printf("| %-16s | %-16s | %-17s | %-13d | %-8.1f | %-13.1f |\n", item.getMaKhachHang(), ngayDatSachStr, item.getTenSach(), item.getSoLuongMua(), item.getGiaSach(), item.getTongTien());
//         }
//         System.out.println("+----------------------------------------------------------------------------------------------------+");
//     }
// }


