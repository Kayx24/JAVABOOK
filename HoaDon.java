import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HoaDon {
    public static void main(String[] args) {
        List<Sach> danhSachSach = new ArrayList<>();
        danhSachSach.add(new Sach(1, "conan", 123));
        danhSachSach.add(new Sach(2, "Doraemon", 456));
        danhSachSach.add(new Sach(3, "One Piece", 789));

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
                System.out.println("+-------------------+---------------+----------+---------------+");
                System.out.println("| Ten sach          | So luong      | Gia tien | Tong tien     |");
                System.out.println("+-------------------+---------------+----------+---------------+");
                System.out.printf("| %-17s | %-13d | %-8.1f | %-13.1f |\n", tenSachMua, soLuongMua, giaSach, tongTienSach);
                tongBill += tongTienSach;
                System.out.println("+-------------------+---------------+----------+---------------+");
                System.out.printf("| %60s |\n", "So tien can thanh toan: " + tongBill+" VND");
                System.out.println("+--------------------------------------------------------------+");
                break;
            }
        }

        if (!timThaySach) {
            System.out.println("Khong tim thay sach ban can.");
        }
    }
}
