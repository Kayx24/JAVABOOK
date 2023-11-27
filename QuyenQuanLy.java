import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuyenQuanLy {
    
 List<Sach> danhSachSach = new ArrayList<>();
String tenFile = "Sach.txt";


public void Docsach(){
danhSachSach = PhanLoai.DocDuLieuTuFileSach (tenFile,danhSachSach);
for (Sach sach : danhSachSach) {
        System.out.println(sach.toString());
    }
}
public void XemChiTietSach(String tenSach) {
    danhSachSach = PhanLoai.DocDuLieuTuFileSach (tenFile,danhSachSach);
        for (Sach sach : danhSachSach) {
            if (sach.getTenSach().equals(tenSach)) {
                System.out.println("Thong tin sach:");
                System.out.println(sach.toString());
                return;
            }
        }
        System.out.println("Khong tim thay sach co ten: " + tenSach);
    }

    public void TimKiemSach() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ten sach can tim: ");
        String tenSach = scanner.nextLine();
        XemChiTietSach(tenSach);
    }
}



