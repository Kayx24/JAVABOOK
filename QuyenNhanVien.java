
import java.util.Scanner;

public class QuyenNhanVien {

    public QuyenNhanVien() {
    }

    public void ThemNhanVien(DanhSachTK ds, NhanVien[] dsNhanViens) {
        int index=0;
        NhanVien nv = new NhanVien();
        nv.NhapNhanVien();
        nv.docDuLieuTuFileTaiKhoan();
        dsNhanViens[index]=nv;
        nv.LuuNhanVienVaoFile(nv);
        index++;
    }

    public void XoaNhanVien(DanhSachTK ds, NhanVien[] dsNhanViens, String userName) {
        Scanner sc = new Scanner(System.in);
    
        NhanVien[] nhanVienArray = dsNhanViens;
        for (int i = 0; i < nhanVienArray.length; i++) {
            NhanVien nvItem = nhanVienArray[i];
            if(nvItem!=null){
                if (nvItem.getUserName().equals(userName)) {
                    NhanVien[] newArray = new NhanVien[nhanVienArray.length - 1];
                    System.arraycopy(nhanVienArray, 0, newArray, 0, i);
                    System.arraycopy(nhanVienArray, i + 1, newArray, i, nhanVienArray.length - i - 1);
                    nhanVienArray = newArray;
                    break;
                }
            }
        }
    
        NhanVien nv = new NhanVien();
        nv.XoaNhanVienTuFile(userName, ds);
        System.out.println("Nhan vien da duoc xoa.");
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+");
    }
}
