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
        // Lấy danh sách sách
        QuyenSach qs=new QuyenSach();

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
            System.out.println("Thông tin sách:");
            System.out.println("Mã sách: " + sach.getMaSach());
            System.out.println("Tên sách: " + sach.getTenSach());
            System.out.println("Mã tác giả: " + sach.getMaTg());
            System.out.println("Tên lĩnh vực: " + sach.getTenLinhVuc());
            System.out.println("Tên loại sách: " + sach.getTenLoaiSach());
            System.out.println("Giá bìa: " + sach.getGiaBia());
            System.out.println("Số lần tái bản: " + sach.getTaiBan());
            System.out.println("Tên nhà xuất bản: " + sach.getTenNhaXuatBan());
            System.out.println("Năm xuất bản: " + sach.getNamXuatBan());
        } else {
            // Không tìm thấy cuốn sách
            System.out.println("Không tìm thấy sách có tên " + tenSach);
        }
    }
}

