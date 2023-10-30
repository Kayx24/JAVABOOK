import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class NhanVien {
    private String TenNhanVien;
    private int MaNV;
    private String ChucVu;
    private String SDT;
    private Date NgaySinh;
    private String GioiTinh;
    private Date NgayBatDauLam;
    private String TrangThaiCongViec;

    public NhanVien() {
        NhapNhanVien();
    }

    public NhanVien(String tenNhanVien, int maNV, String chucVu, String sDT, Date ngaySinh, String gioiTinh,
            Date ngayBatDauLam, String trangThaiCongViec) {
        this.TenNhanVien = tenNhanVien;
        this.MaNV = maNV;
        this.ChucVu = chucVu;
        this.SDT = sDT;
        this.NgaySinh = ngaySinh;
        this.GioiTinh = gioiTinh;
        this.NgayBatDauLam = ngayBatDauLam;
        this.TrangThaiCongViec = trangThaiCongViec;
    }

    public String getTenNhanVien() {
        return TenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        TenNhanVien = tenNhanVien;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int maNV) {
        MaNV = maNV;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String chucVu) {
        ChucVu = chucVu;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String sDT) {
        SDT = sDT;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public Date getNgayBatDauLam() {
        return NgayBatDauLam;
    }

    public void setNgayBatDauLam(Date ngayBatDauLam) {
        NgayBatDauLam = ngayBatDauLam;
    }

    public String getTrangThaiCongViec() {
        return TrangThaiCongViec;
    }

    public void setTrangThaiCongViec(String trangThaiCongViec) {
        TrangThaiCongViec = trangThaiCongViec;
    }

    public void NhapNhanVien() {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Định dạng ngày

        System.out.print("Nhap ten nhan vien: ");
        TenNhanVien = sc.nextLine();
        System.out.print("Nhap ma nhan vien: ");
        MaNV = sc.nextInt();
        System.out.print("Chuc vu: ");
        ChucVu = sc.nextLine();
        System.out.print("So dien thoai: ");
        SDT = sc.nextLine();
        try {
            System.out.print("Ngay sinh (dd/MM/yyyy): ");
            String ngaySinhStr = sc.nextLine();
            NgaySinh = dateFormat.parse(ngaySinhStr);
        } catch (ParseException e) {
            System.out.println("Ngay sinh khong hop le.");
        }
        System.out.print("Gioi tinh: ");
        GioiTinh = sc.nextLine();
        try {
            System.out.print("Ngay bat dau lam (dd/MM/yyyy): ");
            String ngayBatDauLamStr = sc.nextLine();
            NgayBatDauLam = dateFormat.parse(ngayBatDauLamStr);
        } catch (ParseException e) {
            System.out.println("Ngay bat dau lam khong hop le.");
        }
        System.out.print("Trang thai cong viec: ");
        TrangThaiCongViec = sc.nextLine();
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String ngaySinhStr = dateFormat.format(NgaySinh);
        String ngayBatDauLamStr = dateFormat.format(NgayBatDauLam);

        return "NhanVien [TenNhanVien=" + TenNhanVien + ", MaNV=" + MaNV + ", ChucVu=" + ChucVu + ", SDT=" + SDT
                + ", NgaySinh=" + ngaySinhStr + ", GioiTinh=" + GioiTinh + ", NgayBatDauLam=" + ngayBatDauLamStr
                + ", TrangThaiCongViec=" + TrangThaiCongViec + "]";
    }
}
