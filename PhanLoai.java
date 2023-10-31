import java.util.ArrayList;
import java.util.List;

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
            if (sach.getTenLinhVuc().equals(linhVuc)) {
                sachTheoLinhVuc.add(sach);
            }
        }
        return sachTheoLinhVuc;
    }

    public static List<Sach> phanLoaiTheoLoaiSach(List<Sach> danhSachSach, String loaiSach) {
        List<Sach> sachTheoLoaiSach = new ArrayList<>();
        for (Sach sach : danhSachSach) {
            if (sach.getTenLoaiSach().equals(loaiSach)) {
                sachTheoLoaiSach.add(sach);
            }
        }
        return sachTheoLoaiSach;
    }

    // public static void main(String[] args) {
    //     List<Sach> danhSachSach = new ArrayList<>();
    //     danhSachSach.add(new Sach(1, "Sach 1", 1, "LinhVuc1", "LoaiSach1", 100, 2, "NXB1", 2022));
    //     danhSachSach.add(new Sach(2, "Sach 2", 2, "LinhVuc2", "LoaiSach2", 100, 3, "NXB2", 2020));
    //     danhSachSach.add(new Sach(3, "Sach 3", 3, "LinhVuc1", "LoaiSach2", 120, 3, "NXB1", 2021));

    //     // Phân loại sách theo giá bìa
    //     int giaBiaCanPhanLoai = 100;
    //     List<Sach> sachTheoGiaBia = phanLoaiTheoGiaBia(danhSachSach, giaBiaCanPhanLoai);
    //     System.out.println("Cac sach co gia bia " + giaBiaCanPhanLoai + ":");
    //     for (Sach sach : sachTheoGiaBia) {
    //         System.out.println(sach);
    //     }

    //     // Phân loại sách theo lĩnh vực
    //     String linhVucCanPhanLoai = "LinhVuc1";
    //     List<Sach> sachTheoLinhVuc = phanLoaiTheoLinhVuc(danhSachSach, linhVucCanPhanLoai);
    //     System.out.println("Cac sach thuoc linh vuc " + linhVucCanPhanLoai + ":");
    //     for (Sach sach : sachTheoLinhVuc) {
    //         System.out.println(sach);
    //     }

    //     // Phân loại sách theo loại sách
    //     String loaiSachCanPhanLoai = "LoaiSach2";
    //     List<Sach> sachTheoLoaiSach = phanLoaiTheoLoaiSach(danhSachSach, loaiSachCanPhanLoai);
    //     System.out.println("Cac sach thuoc loai " + loaiSachCanPhanLoai + ":");
    //     for (Sach sach : sachTheoLoaiSach) {
    //         System.out.println(sach);
    //     }
    // }
}
