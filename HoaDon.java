// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;

// public class HoaDon {
//     public static void hoaDonSach(List<Sach> danhSachSach) {
//         // List<Sach> danhSachSach = new ArrayList<>();
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Nhap ten sach can mua: ");
//         String tenSachMua = sc.nextLine();
//         double tongBill = 0;

//         boolean timThaySach = false;

//         for (Sach sach : danhSachSach) {
//             if (sach.getTenSach().equalsIgnoreCase(tenSachMua)) {
//                 timThaySach = true;

//                 System.out.print("Nhap so luong sach can mua: ");
//                 int soLuongMua = sc.nextInt();

//                 double giaSach = sach.getGiaBia();

//                 double tongTienSach = giaSach * soLuongMua;

//                 System.out.println("Hoa don cua ban:");
//                 System.out.println("+-------------------+---------------+----------+---------------+");
//                 System.out.println("| Ten sach          | So luong      | Gia tien | Tong tien     |");
//                 System.out.println("+-------------------+---------------+----------+---------------+");
//                 System.out.printf("| %-17s | %-13d | %-8.1f | %-13.1f |\n", tenSachMua, soLuongMua, giaSach, tongTienSach);
//                 tongBill += tongTienSach;
//                 System.out.println("+-------------------+---------------+----------+---------------+");
//                 System.out.printf("| %60s |\n", "So tien can thanh toan: " + tongBill+" VND");
//                 System.out.println("+--------------------------------------------------------------+");
//                 break;
//             }
//         }

//         if (!timThaySach) {
//             System.out.println("Khong tim thay sach ban can.");
//         }
//     }
//     public static void main(String[] args) {
//         List<Sach> danhSachSach = new ArrayList<>();
//         danhSachSach.add(new Sach(1, "Conan", 123, "Linh vuc A", "Trinh tham", 100, 2, "Nha xuat ban A", 2023));
//         danhSachSach.add(new Sach(2, "Doraemon", 456, "Linh vuc B", "Vui ve", 150, 3, "Nha xuat ban B", 2022));
//         danhSachSach.add(new Sach(3, "One Piece", 789, "Linh vuc C", "Gia tuong", 200, 4, "Nha xuat ban C", 2021));
//         danhSachSach.add(new Sach(4,"Sharelock Homes tap 1",101,"Linh vuc D","Trinh tham",300,5,"Nha xuat ban Kim Dong",2022));        
//         danhSachSach.add(new Sach(4,"Sharelock Homes tap 2",101,"Linh vuc D","Trinh tham",300,5,"Nha xuat ban Kim Dong",2022));
//         danhSachSach.add(new Sach(4,"Sharelock Homes tap 3",101,"Linh vuc D","Trinh tham",300,5,"Nha xuat ban Kim Dong",2022));
//         danhSachSach.add(new Sach(4,"Sharelock Homes tap 4",101,"Linh vuc D","Trinh tham",300,5,"Nha xuat ban Kim Dong",2022));
//         danhSachSach.add(new Sach(4,"Sharelock Homes tap 5",101,"Linh vuc D","Trinh tham",300,5,"Nha xuat ban Kim Dong",2022));
//         danhSachSach.add(new Sach(7,"Sach day tieng dong vat",101));

//         hoaDonSach(danhSachSach);
//     }
// }




import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HoaDon {
    public static void hoaDonSach(List<Sach> danhSachSach) {
        // List<Sach> danhSachSach = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten sach can mua: ");
        String tenSachMua = sc.nextLine();
        double tongBill = 0;

        boolean timThaySach = false;

        for (Sach sach : danhSachSach) {
            if (sach.getTenSach().equalsIgnoreCase(tenSachMua)) {
                timThaySach = true;

                System.out.print("Nhap so luong sach can mua: ");
                int soLuongMua = sc.nextInt();

                double giaSach = sach.getGiaBia();

                double tongTienSach = giaSach * soLuongMua;

                System.out.println("Hoa don cua ban:");
                System.out.println("+------------------------------+---------------+----------+---------------+");
                System.out.println("| Ten sach                     | So luong      | Gia tien | Tong tien     |");
                System.out.println("+------------------------------+---------------+----------+---------------+");
                System.out.printf("| %-17s | %-13d | %-8.1f | %-13.1f |\n", tenSachMua, soLuongMua, giaSach, tongTienSach);
                tongBill += tongTienSach;
                System.out.println("+------------------------------+---------------+----------+---------------+");
                System.out.printf("| %60s |\n", "So tien can thanh toan: " + tongBill+" VND");
                System.out.println("+--------------------------------------------------------------+");
            }
        }
    }
    public static void hoaDon(List<Sach> danhSachSach, List<HoaDonItem> hoaDonItems) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhap ten sach can mua (Nhap 'exit' de ket thuc): ");
            String tenSachMua = sc.nextLine();

            if (tenSachMua.equalsIgnoreCase("exit")) {
                break;
            }

            boolean timThaySach = false;

            for (Sach sach : danhSachSach) {
                if (sach.getTenSach().equalsIgnoreCase(tenSachMua)) {
                    timThaySach = true;

                    System.out.print("Nhap so luong sach can mua: ");
                    int soLuongMua = sc.nextInt();

                    double giaSach = sach.getGiaBia();

                    double tongTienSach = giaSach * soLuongMua;

                    hoaDonItems.add(new HoaDonItem(tenSachMua, soLuongMua, giaSach, tongTienSach));

                    System.out.println("Hoa don cua ban:");
                    System.out.println("+-------------------+---------------+----------+---------------+");
                    System.out.println("| Ten sach          | So luong      | Gia tien | Tong tien     |");
                    System.out.println("+-------------------+---------------+----------+---------------+");
                    System.out.printf("| %-17s | %-13d | %-8.1f | %-13.1f |\n", tenSachMua, soLuongMua, giaSach, tongTienSach);
                    System.out.println("+-------------------+---------------+----------+---------------+");
                    System.out.printf("| %60s |\n", "So tien can thanh toan: " + tinhTongTien(hoaDonItems) + " VND");
                    System.out.println("+--------------------------------------------------------------+");
                    break;
                }
            }

            if (!timThaySach) {
                System.out.println("Khong tim thay sach ban can.");
            }
        }

      
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("hoadon.txt", true));
            for (HoaDonItem item : hoaDonItems) {
                bw.write(item.tenSach + "," + item.soLuongMua + "," + item.giaSach + "," + item.tongTien);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double tinhTongTien(List<HoaDonItem> hoaDonItems) {
        double tongTien = 0;
        for (HoaDonItem item : hoaDonItems) {
            tongTien += item.tongTien;
        }
        return tongTien;
    }



      public static void main(String[] args) {
        List<HoaDonItem> hoaDonItems = new ArrayList<>();
        List<Sach> danhSachSach = new ArrayList<>();
        danhSachSach.add(new Sach(1, "conan", 123, "Linh vuc A", "Trinh tham", 100, 2, "Nha xuat ban A", 2023));
        danhSachSach.add(new Sach(2, "Doraemon", 456, "Linh vuc B", "Vui ve", 150, 3, "Nha xuat ban B", 2022));
        

        hoaDon(danhSachSach, hoaDonItems);
    }

}
