import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhanLoai {
    public static List<Sach> phanLoaiTheoGiaBia(List<Sach> danhSachSach, int giaMin, int giaMax) {
        List<Sach> sachTheoGiaBia = new ArrayList<>();
        for (Sach sach : danhSachSach) {
            if (sach.getGiaBia() >= giaMin && sach.getGiaBia() <= giaMax) {
                sachTheoGiaBia.add(sach);
            }
        }
        return sachTheoGiaBia;
    }

    public static List<Sach> phanLoaiTheoLinhVuc(List<Sach> danhSachSach, String linhVuc) {
        List<Sach> sachTheoLinhVuc = new ArrayList<>();
        for (Sach sach : danhSachSach) {
            if (sach.getTenLinhVuc() != null && sach.getTenLinhVuc().equals(linhVuc)) {
                sachTheoLinhVuc.add(sach);
            }
        }
        return sachTheoLinhVuc;
    }

    public static List<Sach> phanLoaiTheoLoaiSach(List<Sach> danhSachSach, String loaiSach) {
        List<Sach> sachTheoLoaiSach = new ArrayList<>();
        for (Sach sach : danhSachSach) {
            if (sach.getTenLoaiSach() != null && sach.getTenLoaiSach().equals(loaiSach)) {
                sachTheoLoaiSach.add(sach);
            }
        }
        return sachTheoLoaiSach;
    }

    public static List<Sach> phanLoaiNhaXuatBan(List<Sach> danhSachSach, String nhaxuatban) {
            List<Sach> sachTheoNhaXuatBan = new ArrayList<>();
            for (Sach sach : danhSachSach) {
                if (sach.getTenNhaXuatBan() != null && sach.getTenNhaXuatBan().equals(nhaxuatban)) {
                    sachTheoNhaXuatBan.add(sach);
                }
            }
            return sachTheoNhaXuatBan;
        }    

    
    public static void MenuPhanLoai(List<Sach> danhSachSach) {
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            System.out.println("Phan loai sach theo: ");
            System.out.println("[0] Thoat phan loai sach.");
            System.out.println("[1] Gia bia.");
            System.out.println("[2] Linh vuc.");
            System.out.println("[3] The loai.");
            System.out.println("[4] Nha xuat ban.");
            System.out.print("Chon de phan loai: ");
            boolean shouldExit = false;
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("------------------------------------------------------------------------------------------------------------------");
                    int min, max;
                    do {
                        System.out.print("Nhap gia toi thieu: ");
                        min = sc.nextInt();
                        System.out.print("Nhap gia toi da: ");
                        max = sc.nextInt();
                    }while (min > max); 
                    List<Sach> sachTheoGiaBia = PhanLoai.phanLoaiTheoGiaBia(danhSachSach, min, max);
                    PhanLoai.inDanhSachSach(sachTheoGiaBia); // In danh sách sách đã phân loại
                    break;
    
                case 2:
                    System.out.println("------------------------------------------------------------------------------------------------------------------");                    
                    System.out.println("Cac linh vuc: ");
                    System.out.println("[1] Linh vuc A ");
                    System.out.println("[2] Linh vuc B ");
                    System.out.println("[3] Linh vuc C ");
                    System.out.println("[4] Linh vuc D ");
                    System.out.print("Chon linh vu muon phan loai: ");
                    int choice1 = sc.nextInt();
                    switch (choice1) {
                        case 1:
                            List<Sach> sachTheoLinhVuc = PhanLoai.phanLoaiTheoLinhVuc(danhSachSach, "Linh vuc A");
                            PhanLoai.inDanhSachSach(sachTheoLinhVuc); // In danh sách sách đã phân loại
                            break;
                        case 2:
                            List<Sach> sachTheoLinhVuc1 = PhanLoai.phanLoaiTheoLinhVuc(danhSachSach, "Linh vuc B");
                            PhanLoai.inDanhSachSach(sachTheoLinhVuc1); // In danh sách sách đã phân loại
                            break;
                        case 3:
                            List<Sach> sachTheoLinhVuc2 = PhanLoai.phanLoaiTheoLinhVuc(danhSachSach, "Linh vuc C");
                            PhanLoai.inDanhSachSach(sachTheoLinhVuc2); // In danh sách sách đã phân loại
                            break;
                        case 4:
                            List<Sach> sachTheoLinhVuc3 = PhanLoai.phanLoaiTheoLinhVuc(danhSachSach, "Linh vuc D");
                            PhanLoai.inDanhSachSach(sachTheoLinhVuc3); // In danh sách sách đã phân loại
                            break;
                        default:
                            shouldExit = true;
                            break;
                    }
                    break;
    
                case 3:
                    System.out.println("------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Sach theo loai: ");
                    System.out.println("[1] Trinh tham ");
                    System.out.println("[2] Vui ve ");
                    System.out.println("[3] Gia tuong ");
                    System.out.print("Chon linh vu muon phan loai: ");
                    int choice2 = sc.nextInt();
                    switch (choice2) {
                        case 1:
                            List<Sach> sachTheoLoaiSach = PhanLoai.phanLoaiTheoLoaiSach(danhSachSach, "Trinh tham");
                            PhanLoai.inDanhSachSach(sachTheoLoaiSach); // In danh sách sách đã phân loại
                            break;
                        case 2:
                            List<Sach> sachTheoLoaiSach1 = PhanLoai.phanLoaiTheoLoaiSach(danhSachSach, "Vui ve");
                            PhanLoai.inDanhSachSach(sachTheoLoaiSach1); // In danh sách sách đã phân loại
                            break;
                        case 3:
                            List<Sach> sachTheoLoaiSach2 = PhanLoai.phanLoaiTheoLoaiSach(danhSachSach, "Gia tuong");
                            PhanLoai.inDanhSachSach(sachTheoLoaiSach2); // In danh sách sách đã phân loại
                            break;
                        default:
                            shouldExit = true;
                            break;
                    }
                    break;
                case 4:
                    System.out.println("------------------------------------------------------------------------------------------------------------------");
                    System.out.println("[1] Nha xuat ban A");
                    System.out.println("[2] Nha xuat ban B");
                    System.out.println("[3] Nha xuat ban C");
                    System.out.println("[4] Nha xuat ban Kim Dong");
                    System.out.print("Phan loai theo nha xuat ban: ");
                    int choice3 = sc.nextInt();
                    switch (choice3) {
                        case 1:
                            List<Sach> sachTheoNhaXuatBan = PhanLoai.phanLoaiNhaXuatBan(danhSachSach, "Nha xuat ban A");
                            PhanLoai.inDanhSachSach(sachTheoNhaXuatBan);
                            break;
                        case 2:
                            List<Sach> sachTheoNhaXuatBan1 = PhanLoai.phanLoaiNhaXuatBan(danhSachSach, "Nha xuat ban B");
                            PhanLoai.inDanhSachSach(sachTheoNhaXuatBan1);
                            break;
                        case 3:
                            List<Sach> sachTheoNhaXuatBan2 = PhanLoai.phanLoaiNhaXuatBan(danhSachSach, "Nha xuat ban C");
                            PhanLoai.inDanhSachSach(sachTheoNhaXuatBan2);
                            break;
                        case 4:
                            List<Sach> sachTheoNhaXuatBan3 = PhanLoai.phanLoaiNhaXuatBan(danhSachSach, "Nha xuat ban Kim Dong");
                            PhanLoai.inDanhSachSach(sachTheoNhaXuatBan3);
                            break;
                        default:
                            shouldExit = true;
                            break;
                    }
                    break;
                case 0:
                // tạm thời để MenuUser
                    User.MenuUser(danhSachSach);
                    break;
            }
        }
    }
    
    public static void inDanhSachSach(List<Sach> danhSachSach) {
        if (danhSachSach.isEmpty()) {
            System.out.println("Khong co sach phu hop.");
        } else {
            System.out.println("Danh sach sach:");
            for (Sach sach : danhSachSach) {
                System.out.println(sach);
            }
        }
    }

    public static void main(String[] args) {
        List<Sach> danhSachSach = new ArrayList<>();
        danhSachSach.add(new Sach(1, "Conan", 123, "Linh vuc A", "Trinh tham", 100, 2, "Nha xuat ban A", 2023));
        danhSachSach.add(new Sach(2, "Doraemon", 456, "Linh vuc B", "Vui ve", 150, 3, "Nha xuat ban B", 2022));
        danhSachSach.add(new Sach(3, "One Piece", 789, "Linh vuc C", "Gia tuong", 200, 4, "Nha xuat ban C", 2021));
        danhSachSach.add(new Sach(4,"Sharelock Homes tap 1",101,"Linh vuc D","Trinh tham",300,5,"Nha xuat ban Kim Dong",2022));        
        danhSachSach.add(new Sach(4,"Sharelock Homes tap 2",101,"Linh vuc D","Trinh tham",300,5,"Nha xuat ban Kim Dong",2022));
        danhSachSach.add(new Sach(4,"Sharelock Homes tap 3",101,"Linh vuc D","Trinh tham",300,5,"Nha xuat ban Kim Dong",2022));
        danhSachSach.add(new Sach(4,"Sharelock Homes tap 4",101,"Linh vuc D","Trinh tham",300,5,"Nha xuat ban Kim Dong",2022));
        danhSachSach.add(new Sach(4,"Sharelock Homes tap 5",101,"Linh vuc D","Trinh tham",300,5,"Nha xuat ban Kim Dong",2022));
        danhSachSach.add(new Sach(7,"Sach day tieng dopng vat",101));

        MenuPhanLoai(danhSachSach);
    }
}
