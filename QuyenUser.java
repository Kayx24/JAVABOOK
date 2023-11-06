// mua sách đi vào hóa đơn,phân loại  cái này bên phân loại sẽ làm
//(tìm kiếm),
// thêm user và những thằng user (arraylist) 

import java.util.List;
import java.util.Scanner;

public class QuyenUser {
    // ...
    public static void xemThongTinSach(List<Sach> danhSachSach) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap ten sach muon tim: ");
        String tenSach=sc.nextLine();
        // Tìm kiếm cuốn sách có tên là tenSach
        Sach sach = null;
        for (Sach sach1 : danhSachSach) {
            if (sach1.getTenSach().equals(tenSach)) {
                sach = sach1;
                break;
            }
        }

        // Nếu tìm thấy cuốn sách
        if (sach != null) {
            // Xem thông tin của cuốn sách
            System.out.println("Thong tin sach:");
            System.out.println("Ma sach: " + sach.getMaSach());
            System.out.println("Ten sach: " + sach.getTenSach());
            System.out.println("Ma tac gia: " + sach.getMaTg());
            System.out.println("Ten linh vuc: " + sach.getTenLinhVuc());
            System.out.println("Ten loai sach: " + sach.getTenLoaiSach());
            System.out.println("Gia sach: " + sach.getGiaBia());
            System.out.println("So lan tai ban: " + sach.getTaiBan());
            System.out.println("Ten nha xuat ban: " + sach.getTenNhaXuatBan());
            System.out.println("Nam xuat ban: " + sach.getNamXuatBan());
        } else {
            // Không tìm thấy cuốn sách
            System.out.println("Không tìm thấy sách có tên " + tenSach);
        }
    }
}

