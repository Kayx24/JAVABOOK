import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class NhanVien extends TaiKhoan {
    private String UserName;
    private String Password;
    private String Role;
    private String TenNhanVien;
    private int MaNV;
    private String ChucVu;
    private String SDT;
    private Date NgaySinh;
    private String GioiTinh;
    private Date NgayBatDauLam;
    private boolean TrangThaiCongViec; // 1 dang lam, 0 dang nghi

    public NhanVien() {
        super();
        UserName = super.getUserName();
        Password = super.getPassword();
        Role = super.getRole();
        NhapNhanVien();
    }

    public NhanVien(String tenNhanVien, int maNV, String chucVu, String sDT, Date ngaySinh, String gioiTinh,
            Date ngayBatDauLam, boolean trangThaiCongViec, String UserName, String Password, String Role) {
        super(UserName, Password, Role);
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
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Định dạng ngày
        boolean validDate = false;
        while (!validDate) {
            try {
                System.out.print("Ngay sinh (dd/MM/yyyy): ");
                String ngaySinhStr = sc.nextLine();
                NgaySinh = dateFormat.parse(ngaySinhStr);
                validDate = true; // Nếu ngày tháng năm hợp lệ, thoát khỏi vòng lặp
            } catch (ParseException e) {
                System.out.println("Ngay sinh khong hop le. Vui long nhap lai.");
            }
        }
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
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Định dạng ngày
        boolean validDate = false;
        while (!validDate) {
            try {
                System.out.print("Ngay bat dau lam (dd/MM/yyyy): ");
                String ngayBatDauLamStr = sc.nextLine();
                NgayBatDauLam = dateFormat.parse(ngayBatDauLamStr);
                validDate = true; // Nếu ngày tháng năm hợp lệ, thoát khỏi vòng lặp
            } catch (ParseException e) {
                System.out.println("Ngay bat dau lam khong hop le. Vui long nhap lai.");
            }
        }
    }

    public boolean getTrangThaiCongViec() {
        return TrangThaiCongViec;
    }

    public void setTrangThaiCongViec(boolean trangThaiCongViec) {
        TrangThaiCongViec = trangThaiCongViec;
    }

    public void NhapNhanVien() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten nhan vien: ");
        TenNhanVien = sc.nextLine();
        System.out.print("Chuc vu: ");
        ChucVu = sc.nextLine();
        System.out.print("So dien thoai: ");
        SDT = sc.nextLine();
        setNgaySinh(NgaySinh);
        System.out.print("Gioi tinh: ");
        GioiTinh = sc.nextLine();
        setNgayBatDauLam(NgayBatDauLam);
        System.out.println("Trang thai cong viec: ");
        System.out.println("[false] Nghi viec");
        System.out.println("[true] dang lam");
        System.out.print("Nhap trang thai");
        TrangThaiCongViec = sc.nextBoolean();
        //System.out.println();
        System.out.print("Nhap ma nhan vien: ");
        MaNV = sc.nextInt(); 
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String ngaySinhStr = dateFormat.format(NgaySinh);
        String ngayBatDauLamStr = dateFormat.format(NgayBatDauLam);

        return "NhanVien [TenNhanVien=" + TenNhanVien + ", MaNV=" + MaNV
                + ", ChucVu=" + ChucVu + ", NgaySinh=" + ngaySinhStr + ", NgayBatDauLam=" + ngayBatDauLamStr
                + ", TrangThaiCongViec=" + TrangThaiCongViec + "]";
    }

    public static void main(String[] args) {
    NhanVien a = new NhanVien();
    System.out.print(a.toString());
    }
}
