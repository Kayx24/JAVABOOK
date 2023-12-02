
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
        boolean checkBuy = false; // Biến để kiểm tra xem khách hàng có mua sách hay không

        while (true) {
            
            System.out.println("[1] Thanh toan: ");
            System.out.println("[0] Thoat: ");
            System.out.println("Nhap ten sach can mua: ");

            String tenSachMua = sc.nextLine();
            if (tenSachMua.equals("0"))
                break;
            if (tenSachMua.equals("1")) {
                if (checkBuy) {
                    thucHienThanhToan(hoaDonItems);
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
                System.out.print("Nhap so luong sach can mua: ");
                int soLuongMua = sc.nextInt();
                double giaSach = sachDaChon.getGiaBia();
                double tongTienSach = giaSach * soLuongMua;
                sc.nextLine();

                Date ngayDatSach = new Date();  

                // Lấy danh sách tài khoản đã đăng nhập từ class DangNhap
                List<TaiKhoan> danhSachTaiKhoanDaDangNhap = DangNhap.getDanhSachTaiKhoanDaDangNhap();

                if (!danhSachTaiKhoanDaDangNhap.isEmpty()) {
                    TaiKhoan taiKhoanDaDangNhap = danhSachTaiKhoanDaDangNhap.get(0); // Lấy tài khoản đầu tiên (có thể điều chỉnh)
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
                if (parts.length == 9) {
                    int maSach = Integer.parseInt(parts[0]);
                    String tenSach = parts[1];
                    String tenLinhVuc = parts[2];
                    String tenLoaiSach = parts[3];
                    int giaBia = Integer.parseInt(parts[4]);
                    int taiBan = Integer.parseInt(parts[5]);
                    String tenNhaXuatBan = parts[6];
                    int namXuatBan = Integer.parseInt(parts[7]);
                    int soLuongSach = Integer.parseInt(parts[8]);
                    Sach sach = new Sach(maSach, tenSach, tenLinhVuc, tenLoaiSach, giaBia, taiBan, tenNhaXuatBan, namXuatBan,soLuongSach);
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
    
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        double tongTien = 0;
    
        System.out.println("hoa don tong cua khach hang la:");
        System.out.println("+------------------+------------------+-------------------+---------------+----------+---------------+");
        System.out.println("| Ma khach hang    | Ngay dat sach    | Ten sach          | So luong      | Gia tien | Tong tien     |");
        System.out.println("+------------------+------------------+-------------------+---------------+----------+---------------+");
    
        for (HoaDonItem item : hoaDonItems) {
            String ngayDatSachStr = date.format(item.getNgayDatSach());
            System.out.printf("| %-16s | %-16s | %-17s | %-13d | %-8.1f | %-13.1f |\n", item.getMaKhachHang(), ngayDatSachStr, item.getTenSach(), item.getSoLuongMua(), item.getGiaSach(), item.getTongTien());
            tongTien += item.getTongTien();
        }
    
        System.out.println("+------------------+------------------+-------------------+---------------+----------+---------------+");
        System.out.printf("| %98s |\n", "Tong so tien can thanh toan: " + tongTien + " VND");
        System.out.println("+----------------------------------------------------------------------------------------------------+");
    }
// trong hàm thực hiện thanh toán , sẽ tiến hành trừ số sách còn lại với số sách nếu số sách còn lại =0 thì System.out là hết sách
//còn nếu còn sách nhưng số sách mua > số sách còn lại thì System.out không đủ
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
