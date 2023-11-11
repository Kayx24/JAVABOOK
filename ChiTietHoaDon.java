

    // import java.io.*;
    // import java.util.ArrayList;
    // import java.util.List;
    // import java.util.Scanner;

    // public class ChiTietHoaDon {
    
    //     public static void ChiTietHoaDon(List<Sach> danhSachSach, List<HoaDonItem> hoaDonItems) {
    //         Scanner sc = new Scanner(System.in);
    //         int choice;
    //         while (true) {
    //             System.out.println("Menu Chi Tiet Hoa Don:");
    //             System.out.println("[1] Xem chi tiet hoa don");
    //             System.out.println("[2] Them sach vao hoa don");
    //             System.out.println("[3] Xoa sach khoi hoa don");
    //             System.out.println("[4] Sua thong tin sach trong hoa don");
    //             System.out.println("[0] luu thong tin");
    //             System.out.print("Chon: ");
    //             choice = sc.nextInt();
    //             sc.nextLine(); // Consume the newline character

    //             switch (choice) {
    //                 case 1:
    //                     displayHoaDon(hoaDonItems);
    //                     break;
    //                 case 2:
    //                     addSachToHoaDon(danhSachSach,hoaDonItems);
    //                     break;
    //                 case 3:
    //                     deleteSachFromHoaDon(hoaDonItems);
    //                     break;
    //                 case 4:
    //                     editSachInHoaDon(hoaDonItems);
    //                     break;
    //                 case 0:
    //                     saveHoaDonToFile(hoaDonItems);
    //                     return;
    //                 default:
    //                     System.out.println("Lua chon khong hop le. Vui long chon lai.");
    //                     break;
    //             }
    //         }
    //     }
     
    //     public static void displayHoaDon(List<HoaDonItem> hoaDonItems) {
    //         hoaDonItems.clear();
    //         try {
    //             BufferedReader br = new BufferedReader(new FileReader("hoadon.txt"));
    //             String line;
    //             while ((line = br.readLine()) != null) {
    //                 String[] data = line.split(",");
    //                 if (data.length == 4) {
    //                 String tenSach = data[0];
    //                 int soLuongMua = Integer.parseInt(data[1]);
    //                 double giaSach = Double.parseDouble(data[2]);
    //                 double tongTien = Double.parseDouble(data[3]);
    //                 hoaDonItems.add(new HoaDonItem(tenSach, soLuongMua, giaSach, tongTien));
    //                 }
    //             }
    //             br.close();
    //             System.out.println("Thong tin hoa don:");
    //             System.out.println("+-------------------+---------------+----------+---------------+");
    //             System.out.println("| Ten sach          | So luong      | Gia tien | Tong tien     |");
    //             System.out.println("+-------------------+---------------+----------+---------------+");
    //             for (HoaDonItem item : hoaDonItems) {
    //                 System.out.printf("| %-17s | %-13d | %-8.1f | %-13.1f |\n", item.tenSach, item.soLuongMua, item.giaSach, item.tongTien);
    //             }
    //             System.out.println("+-------------------+---------------+----------+---------------+");
    //             System.out.printf("| %60s |\n", "So tien can thanh toan: " + tinhTongTien(hoaDonItems) + " VND");
    //             System.out.println("+--------------------------------------------------------------+");
    //         } catch (IOException e) {
    //             e.printStackTrace();
    //         }
    //     }
        

    //         public static void addSachToHoaDon(List<Sach> danhSachSach, List<HoaDonItem> hoaDonItems) {
    //             Scanner sc = new Scanner(System.in);
    //             System.out.print("Nhap ten sach can them vao hoa don: ");
    //             String tenSach = sc.nextLine();
    //             boolean found = false;
            
    //             for (Sach sach : danhSachSach) {
    //                 if (sach.getTenSach().equalsIgnoreCase(tenSach)) {
    //                     found = true;
    //                     System.out.print("Nhap so luong can them: ");
    //                     int soLuongThem = sc.nextInt();
            
    //                     double giaSach = sach.getGiaBia();
    //                     double tongTienSach = giaSach * soLuongThem;
            
    //                     HoaDonItem item = new HoaDonItem(tenSach, soLuongThem, giaSach, tongTienSach);
    //                     hoaDonItems.add(item);
    //                     System.out.println("Da them sach vao hoa don.");
    //                     saveHoaDonToFile(hoaDonItems);
    //                     break;
    //                 }
    //             }
            
    //             if (!found) {
    //                 System.out.println("Khong tim thay sach trong danh sach sach.");
    //             }
    //         }
            

    //     public static void deleteSachFromHoaDon(List<HoaDonItem> hoaDonItems) {
    //             Scanner sc = new Scanner(System.in);
    //             System.out.print("Nhap ten sach can xoa khoi hoa don: ");
    //             String tenSach = sc.nextLine();
    //             HoaDonItem itemToRemove = null;
    //             for (HoaDonItem item : hoaDonItems) {
    //                 if (item.tenSach.equalsIgnoreCase(tenSach)) {
    //                     itemToRemove = item;
    //                     break;
    //                 }
    //             }
    //             if (itemToRemove != null) {
    //                 hoaDonItems.remove(itemToRemove);
    //                 saveHoaDonToFile(hoaDonItems);
    //                 System.out.println("Da xoa sach khoi hoa don.");
            
    //             } else {
    //                 System.out.println("Khong tim thay sach trong hoa don.");
               
    //             }
    //     }            

    //     public static void editSachInHoaDon(List<HoaDonItem> hoaDonItems) {
    //         Scanner sc = new Scanner(System.in);
    //         System.out.print("Nhap ten sach can sua thong tin: ");
    //         String tenSach = sc.nextLine();
    //         boolean found = false;
    //         for (HoaDonItem item : hoaDonItems) {
    //             if (item.tenSach.equalsIgnoreCase(tenSach)) {
    //                 found = true;
    //                 System.out.println("Chon thong tin can sua:");
    //                 System.out.println("[1] Sua so luong");
    //                 System.out.println("[2] Sua gia");
    //                 System.out.print("Chon: ");
    //                 int choice = sc.nextInt();
    //                 if (choice == 1) {
    //                     System.out.print("Nhap so luong moi: ");
    //                     int soLuongMoi = sc.nextInt();
    //                     item.soLuongMua = soLuongMoi;
    //                     item.tongTien = item.soLuongMua * item.giaSach;
                   
    //                     System.out.println("Da cap nhat so luong sach trong hoa don.");
    //                 } else if (choice == 2) {
    //                     System.out.print("Nhap gia moi: ");
    //                     double giaMoi = sc.nextDouble();
    //                     item.giaSach = giaMoi;
    //                     item.tongTien = item.soLuongMua * item.giaSach;
                      
    //                     System.out.println("Da cap nhat gia cua sach trong hoa don.");
    //                 } else {
    //                     System.out.println("Lua chon khong hop le.");
    //                 }
    //                 break;
    //             }
    //         }
    //         if (!found) {
    //             System.out.println("Khong tim thay sach trong hoa don.");
    //         }
    //     }

    //     public static double tinhTongTien(List<HoaDonItem> hoaDonItems) {
    //         double tongTien = 0;
    //         for (HoaDonItem item : hoaDonItems) {
    //             tongTien += item.tongTien;
    //         }
    //         return tongTien;
    //     }

    //     public static void saveHoaDonToFile(List<HoaDonItem> hoaDonItems) {
    //         // Save hoaDonItems to hoadon.txt
    //         try {
    //             BufferedWriter bw = new BufferedWriter(new FileWriter("hoadon.txt", false)); // "false" for overwriting the file
    //             for (HoaDonItem item : hoaDonItems) {
    //                 bw.write(item.tenSach + "," + item.soLuongMua + "," + item.giaSach + "," + item.tongTien);
    //                 bw.newLine();
    //             }
    //             bw.close();
    //             System.out.println("Da luu hoa don vao file hoadon.txt.");
    //         } catch (IOException e) {
    //             e.printStackTrace();
    //         }
    //     }
    // }
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChiTietHoaDon {
    
    private static int idCounter = 1;

    public static void ChiTietHoaDon(List<Sach> danhSachSach, List<HoaDonItem> hoaDonItems) {
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("Menu Chi Tiet Hoa Don:");
            System.out.println("[1] Xem chi tiet hoa don");
            System.out.println("[2] Them sach vao hoa don");
            System.out.println("[3] Xoa sach khoi hoa don");
            System.out.println("[4] Sua thong tin sach trong hoa don");
            System.out.println("[0] Thoat");
            System.out.print("Chon: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    displayHoaDon(hoaDonItems);
                    break;
                case 2:
                    addSachToHoaDon(danhSachSach, hoaDonItems);
                    break;
                case 3:
                    deleteSachFromHoaDon(hoaDonItems);
                    break;
                case 4:
                    editSachInHoaDon(hoaDonItems);
                    break;
                case 0:
                    saveHoaDonToFile(hoaDonItems);
                    return;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
                    break;
            }
        }
    }

    public static void displayHoaDon(List<HoaDonItem> hoaDonItems) {
        hoaDonItems.clear();
            try {
                BufferedReader br = new BufferedReader(new FileReader("hoadon.txt"));
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data.length == 4) {
                    String tenSach = data[0];
                    int soLuongMua = Integer.parseInt(data[1]);
                    double giaSach = Double.parseDouble(data[2]);
                    double tongTien = Double.parseDouble(data[3]);
                    hoaDonItems.add(new HoaDonItem(tenSach, soLuongMua, giaSach, tongTien));
                    }
                }
                br.close();
                System.out.println("Thong tin hoa don:");
                System.out.println("+----+-------------------+---------------+----------+---------------+");
                System.out.println("| ID | Ten sach          | So luong      | Gia tien | Tong tien     |");
                System.out.println("+----+-------------------+---------------+----------+---------------+");
                for (int i = 0; i < hoaDonItems.size(); i++) {
                    HoaDonItem item = hoaDonItems.get(i);
                    System.out.printf("| %-2d | %-17s | %-13d | %-8.1f | %-13.1f |\n", i + 1, item.tenSach, item.soLuongMua, item.giaSach, item.tongTien);
                }
                System.out.println("+----+-------------------+---------------+----------+---------------+");
                System.out.printf("| %65s |\n", "tong tien cac hoa don: " + tinhTongTien(hoaDonItems) + " VND");
                System.out.println("+-------------------------------------------------------------------+");
            } catch (IOException e) {
                e.printStackTrace();
            }
        
    }

    public static void addSachToHoaDon(List<Sach> danhSachSach, List<HoaDonItem> hoaDonItems) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten sach can them vao hoa don: ");
        String tenSach = sc.nextLine();
        boolean found = false;

        for (Sach sach : danhSachSach) {
            if (sach.getTenSach().equalsIgnoreCase(tenSach)) {
                found = true;
                System.out.print("Nhap so luong can them: ");
                int soLuongThem = sc.nextInt();

                double giaSach = sach.getGiaBia();
                double tongTienSach = giaSach * soLuongThem;

                HoaDonItem item = new HoaDonItem(tenSach, soLuongThem, giaSach, tongTienSach);
                hoaDonItems.add(item);
                System.out.println("Da them sach vao hoa don.");
                saveHoaDonToFile(hoaDonItems);
                break;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay sach trong danh sach sach.");
        }
    }

    public static void deleteSachFromHoaDon(List<HoaDonItem> hoaDonItems) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ID sach can xoa khoi hoa don: ");
        int idToRemove = sc.nextInt();

        if (idToRemove >= 1 && idToRemove <= hoaDonItems.size()) {
            hoaDonItems.remove(idToRemove - 1);
            saveHoaDonToFile(hoaDonItems);
            System.out.println("Da xoa sach khoi hoa don.");
        } else {
            System.out.println("ID khong hop le.");
        }
    }

    public static void editSachInHoaDon(List<HoaDonItem> hoaDonItems) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ID sach can sua thong tin: ");
        int idToEdit = sc.nextInt();

        if (idToEdit >= 1 && idToEdit <= hoaDonItems.size()) {
            HoaDonItem item = hoaDonItems.get(idToEdit - 1);
            System.out.println("Chon thong tin can sua:");
            System.out.println("[1] Sua so luong");
            System.out.println("[2] Sua gia");
            System.out.print("Chon: ");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.print("Nhap so luong moi: ");
                int soLuongMoi = sc.nextInt();
                item.soLuongMua = soLuongMoi;
                item.tongTien = item.soLuongMua * item.giaSach;
                saveHoaDonToFile(hoaDonItems);
                System.out.println("Da cap nhat so luong sach trong hoa don.");
            } else if (choice == 2) {
                System.out.print("Nhap gia moi: ");
                double giaMoi = sc.nextDouble();
                item.giaSach = giaMoi;
                item.tongTien = item.soLuongMua * item.giaSach;
                saveHoaDonToFile(hoaDonItems);
                System.out.println("Da cap nhat gia cua sach trong hoa don.");
            } else {
                System.out.println("Lua chon khong hop le.");
            }
        } else {
            System.out.println("ID khong hop le.");
        }
    }

    public static double tinhTongTien(List<HoaDonItem> hoaDonItems) {
        double tongTien = 0;
        for (HoaDonItem item : hoaDonItems) {
            tongTien += item.tongTien;
        }
        return tongTien;
    }

    public static void saveHoaDonToFile(List<HoaDonItem> hoaDonItems) {
        // Save hoaDonItems to hoadon.txt
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("hoadon.txt", false)); // "false" for overwriting the file
            for (HoaDonItem item : hoaDonItems) {
                bw.write(item.tenSach + "," + item.soLuongMua + "," + item.giaSach + "," + item.tongTien);
                bw.newLine();
            }
            bw.close();
            System.out.println("Da luu hoa don vao file hoadon.txt.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
