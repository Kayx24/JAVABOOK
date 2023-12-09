// ko có xóa sửa, chỉ có hủy hóa đơn
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ChiTietHoaDon {
    public static Scanner sc = new Scanner(System.in);
    public static void runChiTietHoaDon() {

        List<List<HoaDonItem>> danhSachHoaDon = HoaDonFromFile("hoadon.txt");

        int choice;
        while (true) {
        do {
            System.out.println("Menu:");
            System.out.println("[1] In toan bo hoa don");
            System.out.println("[2] Tim hoa don theo ma khach hang");
            System.out.println("[3] Xoa hoa don theo so hoa don");
            System.out.println("[0] Thoat");
            System.out.print("Nhap lua chon cua ban: ");
            choice = nextIntWithErrorCheck();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    inDanhSachHoaDon(danhSachHoaDon);
                    break;
                case 2:
                    System.out.print("Nhap ma khach hang can tim kiem: ");
                    String maKhachHang = sc.nextLine();
                    timHoaDonTheoMaKhachHang(danhSachHoaDon, maKhachHang);
                    break;
                case 3:
                    int soHoaDon;
                    do {
                        System.out.print("Nhap so hoa don can xoa: ");
                        if (sc.hasNextInt()) {
                            soHoaDon = sc.nextInt();
                            break;
                        } else {
                            System.out.println("So hoa don khong hop le, vui long nhap lai so.");
                            sc.next();
                        }
                    } while (true);
                    xoaHoaDonTheoSoHoaDon(danhSachHoaDon, soHoaDon,"hoadon.txt");
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long nhap lai.");
            }
        } while (choice != 0);
    }
}


    public static List<List<HoaDonItem>> HoaDonFromFile(String File) {
        List<String> lines = docDuLieuTuFile(File);
        return parseLinesToDanhSachHoaDon(lines);
    }

    public static List<String> docDuLieuTuFile(String tenTep) {
        List<String> lines = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(tenTep));
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static List<List<HoaDonItem>> parseLinesToDanhSachHoaDon(List<String> lines) {
        List<List<HoaDonItem>> danhSachHoaDon = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        List<HoaDonItem> currentInvoice = new ArrayList<>();
        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                currentInvoice.addAll(parseLineToHoaDonItem(line, dateFormat));
            } else {
                danhSachHoaDon.add(new ArrayList<>(currentInvoice));
                currentInvoice.clear();
            }
        }

        // Xử lý trường hợp cuối cùng nếu có dữ liệu
        if (!currentInvoice.isEmpty()) {
            danhSachHoaDon.add(new ArrayList<>(currentInvoice));
        }
        return danhSachHoaDon;
    }

    private static List<HoaDonItem> parseLineToHoaDonItem(String line, SimpleDateFormat dateFormat) {
        List<HoaDonItem> hoaDonItems = new ArrayList<>();
        String[] parts = line.split(",");
        if (parts.length == 6) {
            try {
                String maKhachHang = parts[0];
                Date ngayDatSach = dateFormat.parse(parts[1]);
                String tenSach = parts[2];
                int soLuongMua = Integer.parseInt(parts[3]);
                double giaSach = Double.parseDouble(parts[4]);
                double tongTien = Double.parseDouble(parts[5]);

                HoaDonItem hoaDonItem = new HoaDonItem(maKhachHang, ngayDatSach, tenSach, soLuongMua, giaSach, tongTien);
                hoaDonItems.add(hoaDonItem);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return hoaDonItems;
    }

    public static void inDanhSachHoaDon(List<List<HoaDonItem>> danhSachHoaDon) {
        for (int i = 0; i < danhSachHoaDon.size(); i++) {
            List<HoaDonItem> hoaDonItems = danhSachHoaDon.get(i);
            System.out.println("Hoa don " + (i + 1) + ":");
            inHoaDonTuList(hoaDonItems);
            System.out.println();
        }
    }

    public static void inHoaDonTuList(List<HoaDonItem> hoaDonItems) {
        System.out.println("+------------------+------------------+-------------------+---------------+----------+---------------+");
        System.out.println("| Ma khach hang    | Ngay dat sach    | Ten sach          | So luong      | Gia tien | Tong tien     |");
        System.out.println("+------------------+------------------+-------------------+---------------+----------+---------------+");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        double tongTienHoaDon = 0;
        for (HoaDonItem item : hoaDonItems) {
            String ngayDatSachStr = dateFormat.format(item.getNgayDatSach());
            System.out.printf("| %-16s | %-16s | %-17s | %-13d | %-8.1f | %-13.1f |\n", item.getMaKhachHang(), ngayDatSachStr, item.getTenSach(), item.getSoLuongMua(), item.getGiaSach(), item.getTongTien());
            tongTienHoaDon += item.getTongTien();
        }

        System.out.println("+------------------+------------------+-------------------+---------------+----------+---------------+");
        System.out.printf("| %82s | %-13.1f |\n", "Tong tien hoa don: ", tongTienHoaDon);
        System.out.println("+----------------------------------------------------------------------------------------------------+");
    }

    public static void timHoaDonTheoMaKhachHang(List<List<HoaDonItem>> danhSachHoaDon, String maKhachHang) {
        boolean found = false;
        for (int i = 0; i < danhSachHoaDon.size(); i++) {
            List<HoaDonItem> hoaDonItems = danhSachHoaDon.get(i);
            for (HoaDonItem item : hoaDonItems) {
                if (item.getMaKhachHang().equalsIgnoreCase(maKhachHang)) {
                    if (!found) {
                        System.out.println("Cac hoa don cua khach hang " + maKhachHang + ":");
                        found = true;
                    }
                    System.out.println("So hoa don: " + (i + 1));
                    inHoaDonTuList(hoaDonItems);
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("Khong tim thay hoa don cho khach hang " + maKhachHang + ".");
        }
    }


    public static void xoaHoaDonTheoSoHoaDon(List<List<HoaDonItem>> danhSachHoaDon, int soHoaDon, String File) {
        boolean found = false;
        for (int i = 0; i < danhSachHoaDon.size(); i++) {
            List<HoaDonItem> hoaDonItems = danhSachHoaDon.get(i);
            if (i + 1 == soHoaDon) {
                found = true;
                danhSachHoaDon.remove(i);
                ghiDuLieuVaoFile(danhSachHoaDon, File);
                System.out.println("Da xoa hoa don so " + soHoaDon + ".");
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay hoa don so " + soHoaDon + ".");
        }
        
    }

    public static void ghiDuLieuVaoFile(List<List<HoaDonItem>> danhSachHoaDon, String File) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(File));
            for (List<HoaDonItem> hoaDonItems : danhSachHoaDon) {
                for (HoaDonItem item : hoaDonItems) {
                    String ngayDatSachStr = dateFormat.format(item.getNgayDatSach());
                    String line = item.getMaKhachHang() + "," + ngayDatSachStr + "," + item.getTenSach() + "," + item.getSoLuongMua() + "," + item.getGiaSach() + "," + item.getTongTien();
                    bw.write(line);
                    // bw.newLine();
                }
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int nextIntWithErrorCheck() {
        while (true) {
            try {
                return sc.nextInt();
            } catch (Exception e) {
                System.out.println("Nhap khong hop le. Vui long nhap lai mot so.");
                sc.nextLine();
            }
        }
    }
    
}


