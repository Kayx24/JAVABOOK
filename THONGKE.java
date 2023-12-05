import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class THONGKE {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<List<HoaDonItem>> danhSachHoaDon = ChiTietHoaDon.HoaDonFromFile("hoadon.txt");
        MenuThongKe(danhSachHoaDon);
    }

    public static void MenuThongKe(List<List<HoaDonItem>> danhSachHoaDon) {
        System.out.println("[1] Thong ke theo thoi gian");
        System.out.println("[2] Tim san pham ban chay nhat");
        System.out.println("[3] Tim san pham co thoi gian mua cu nhat");
        System.out.println("[4] Tìm san pham co thoi gian mua moi nhat");
        System.out.println("[0] Thoat");
        System.out.print("Chon: ");

        String input = sc.nextLine();

        if (isNumeric(input)) {
            int choice = Integer.parseInt(input);
            switch (choice) {
                case 1:
                    thongKeTheoThoiGian(danhSachHoaDon);
                    break;
                case 2:
                    timSanPhamBanChayNhat(danhSachHoaDon);
                    break;
                case 3:
                    timSanPhamCoThoiGianMuaCuNhat(danhSachHoaDon);
                    break;
                case 4:
                    timSanPhamCoThoiGianMuaMoiNhat(danhSachHoaDon);
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui long chon lua hop le");
                    break;
            }
        } else {
            System.out.println("Vui long nhap so");
        }
    }

    public static void thongKeTheoThoiGian(List<List<HoaDonItem>> danhSachHoaDon) {
        try {
            System.out.print("Nhap thoi gian bat dau (dd-MM-yyyy): ");
            String startStr = sc.nextLine();
            if (!isValidDateFormat(startStr)) {
                System.out.println("Ngay thang nhap khong hop le.");
                return;
            }
            Date startTime = new SimpleDateFormat("dd-MM-yyyy").parse(startStr);

            System.out.print("Nhap thoi gian ket thuc (dd-MM-yyyy): ");
            String endStr = sc.nextLine();
            if (!isValidDateFormat(endStr)) {
                System.out.println("Ngay thang nhap khong hop le.");
                return;
            }
            Date endTime = new SimpleDateFormat("dd-MM-yyyy").parse(endStr);

            for (List<HoaDonItem> hoaDonItems : danhSachHoaDon) {
                for (HoaDonItem item : hoaDonItems) {
                    Date ngayDatSach = item.getNgayDatSach();
                    if (ngayDatSach.after(startTime) && ngayDatSach.before(endTime)) {
                        System.out.println("Ten truyen: " + item.getTenSach() +
                                ", So luong: " + item.getSoLuongMua() +
                                ", Tong gia: " + item.getTongTien());
                    }
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static boolean isValidDateFormat(String str) {
        // Định dạng dd-MM-yyyy
        String regex = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-(\\d{4})$";
        return str.matches(regex);
    }

    public static void timSanPhamBanChayNhat(List<List<HoaDonItem>> danhSachHoaDon) {
        int maxQuantity = 0;
        String bestProductName = "";

        for (List<HoaDonItem> hoaDonItems : danhSachHoaDon) {
            for (HoaDonItem item : hoaDonItems) {
                int currentQuantity = item.getSoLuongMua();
                if (currentQuantity > maxQuantity) {
                    maxQuantity = currentQuantity;
                    bestProductName = item.getTenSach();
                } else if (currentQuantity == maxQuantity) {
                    // Nếu có sản phẩm trùng số lượng, cộng số lượng lại
                    maxQuantity += currentQuantity;
                }
            }
        }

        System.out.println("San pham ban chay nhat: " + bestProductName +
                ", Tong so luong da mua: " + maxQuantity);
    }

    public static void timSanPhamCoThoiGianMuaCuNhat(List<List<HoaDonItem>> danhSachHoaDon) {
        Date oldestDate = new Date();

        for (List<HoaDonItem> hoaDonItems : danhSachHoaDon) {
            for (HoaDonItem item : hoaDonItems) {
                Date ngayDatSach = item.getNgayDatSach();
                if (ngayDatSach.before(oldestDate)) {
                    oldestDate = ngayDatSach;
                }
            }
        }

        System.out.println("San pham co thoi gian mua cu nhat: " + oldestDate);
    }

    public static void timSanPhamCoThoiGianMuaMoiNhat(List<List<HoaDonItem>> danhSachHoaDon) {
        Date newestDate = new Date(0);

        for (List<HoaDonItem> hoaDonItems : danhSachHoaDon) {
            for (HoaDonItem item : hoaDonItems) {
                Date ngayDatSach = item.getNgayDatSach();
                if (ngayDatSach.after(newestDate)) {
                    newestDate = ngayDatSach;
                }
            }
        }

        System.out.println("San pham co thoi gian mua moi nhat: " + newestDate);
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
