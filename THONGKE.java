import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class THONGKE {
    public static Scanner sc = new Scanner(System.in);

    // public static void main(String[] args) {
        List<List<HoaDonItem>> danhSachHoaDon = ChiTietHoaDon.HoaDonFromFile("hoadon.txt");
        // MenuThongKe(danhSachHoaDon);
    // }

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
                    MenuThongKe(danhSachHoaDon);
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
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap thoi gian bat dau (dd-MM-yyyy): ");
        String startStr = sc.nextLine();
        Date startTime = parseDate(startStr);

        System.out.print("Nhap thoi gian ket thuc (dd-MM-yyyy): ");
        String endStr = sc.nextLine();
        Date endTime = parseDate(endStr);

        int count = 0; // Biến đếm số sách được bán trong khoảng thời gian

        for (List<HoaDonItem> hoaDonItems : danhSachHoaDon) {
            for (HoaDonItem item : hoaDonItems) {
                Date ngayDatSach = item.getNgayDatSach();
                if (ngayDatSach.after(startTime) && ngayDatSach.before(endTime)) {
                    System.out.println("Ten truyen: " + item.getTenSach() +
                            ", So luong: " + item.getSoLuongMua() +
                            ", Tong gia: " + item.getTongTien());
                    count++;
                }
            }
        }

        if (count == 0) {
            System.out.println("Khong co sach nao duoc ban trong khoang thoi gian da nhap.");
            MenuThongKe(danhSachHoaDon);
        }else{
            MenuThongKe(danhSachHoaDon);
        }

    } catch (ParseException e) {
        e.printStackTrace();
    }
}

private static Date parseDate(String dateStr) throws ParseException {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    dateFormat.setLenient(false); // Tắt tính linh hoạt của định dạng ngày tháng
    Date date = null;

    while (date == null) {
        try {
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Ngay thang nhap khong hop le. Vui long nhap lai.");
            System.out.print("Nhap lai thoi gian (dd-MM-yyyy): ");
            dateStr = sc.nextLine();
        }
    }

    return date;
}
    public static boolean isValidDateFormat(String str) {
        // Định dạng dd-MM-yyyy
        String regex = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-(\\d{4})$";
        return str.matches(regex);
    }

   public static void timSanPhamBanChayNhat(List<List<HoaDonItem>> danhSachHoaDon) {
    System.out.println("San pham ban chay nhat la :");
    Map<String, Integer> sanPhamVaSoLuong = new HashMap<>();

    for (List<HoaDonItem> hoaDonItems : danhSachHoaDon) {
        for (HoaDonItem item : hoaDonItems) {
            String tenSanPham = item.getTenSach();
            int soLuong = item.getSoLuongMua();

            // Kiểm tra xem sản phẩm đã tồn tại trong Map hay chưa
            if (sanPhamVaSoLuong.containsKey(tenSanPham)) {
                // Nếu đã tồn tại, cộng số lượng đã bán vào số lượng hiện tại
                int tongSoLuong = sanPhamVaSoLuong.get(tenSanPham) + soLuong;
                sanPhamVaSoLuong.put(tenSanPham, tongSoLuong);
            } else {
                // Nếu chưa tồn tại, thêm sản phẩm vào Map
                sanPhamVaSoLuong.put(tenSanPham, soLuong);
                
            }
        }
    }

    List<Map.Entry<String, Integer>> danhSachSanPham = new ArrayList<>(sanPhamVaSoLuong.entrySet());

    // Sắp xếp danh sách sản phẩm theo số lượng đã bán từ cao đến thấp
    danhSachSanPham.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

    // In ra danh sách sản phẩm theo thứ tự từ bán chạy nhất đến thấp nhất
    for (Map.Entry<String, Integer> entry : danhSachSanPham) {
        System.out.println("San pham: " + entry.getKey() +
                ", Tong so luong da mua: " + entry.getValue());
    }
}
public static void timSanPhamCoThoiGianMuaCuNhat(List<List<HoaDonItem>> danhSachHoaDon) {
    Date oldestDate = new Date();
    String productName = "";

    for (List<HoaDonItem> hoaDonItems : danhSachHoaDon) {
        for (HoaDonItem item : hoaDonItems) {
            Date ngayDatSach = item.getNgayDatSach();
            if (ngayDatSach.before(oldestDate)) {
                oldestDate = ngayDatSach;
                productName = item.getTenSach();
            }
        }
    }

    System.out.println("San pham co thoi gian mua cu nhat: " + productName + ", Ngay mua: " + oldestDate);
}

public static void timSanPhamCoThoiGianMuaMoiNhat(List<List<HoaDonItem>> danhSachHoaDon) {
    Date newestDate = new Date(0);
    String productName = "";

    for (List<HoaDonItem> hoaDonItems : danhSachHoaDon) {
        for (HoaDonItem item : hoaDonItems) {
            Date ngayDatSach = item.getNgayDatSach();
            if (ngayDatSach.after(newestDate)) {
                newestDate = ngayDatSach;
                productName = item.getTenSach();
            }
        }
    }

    System.out.println("San pham co thoi gian mua moi nhat: " + productName + ", Ngay mua: " + newestDate);
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
