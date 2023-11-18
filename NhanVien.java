import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class NhanVien extends TaiKhoan {
    private String UserName;
    private String Password;
    private String Role;
    private String TenNhanVien;
    private String MaNV;
    private Date NgaySinh;
    private String GioiTinh;
    private Date NgayBatDauLam;
    private boolean TrangThaiCongViec; // 1 dang lam, 0 dang nghi

    public NhanVien(String tenNhanVien, String maNV, String sDT, Date ngaySinh, String gioiTinh,
            Date ngayBatDauLam, boolean trangThaiCongViec, String UserName, String Password, String Role) {
        super(UserName, Password, Role);
        this.TenNhanVien = tenNhanVien;
        this.MaNV = maNV;
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

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String maNV) {
        MaNV = maNV;
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

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public void NhapNhanVien() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten nhan vien: ");
        TenNhanVien = sc.nextLine();
        System.out.print("Nhap ma nhan vien: ");
        MaNV = sc.nextLine();
        System.out.print("Nhap Ngay Sinh: ");
        setNgaySinh(NgaySinh);
        System.out.print("Gioi tinh: ");
        GioiTinh = sc.nextLine();
        setNgayBatDauLam(NgayBatDauLam);
        System.out.println("Trang thai cong viec: ");
        System.out.println("[false] Nghi viec");
        System.out.println("[true] dang lam");
        System.out.print("Nhap trang thai");
        TrangThaiCongViec = sc.nextBoolean();
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String ngaySinhStr = dateFormat.format(NgaySinh);
        String ngayBatDauLamStr = dateFormat.format(NgayBatDauLam);

        return "NhanVien [TenNhanVien=" + TenNhanVien + ", MaNV=" + MaNV
                + ", NgaySinh=" + ngaySinhStr + ", NgayBatDauLam=" + ngayBatDauLamStr
                + ", TrangThaiCongViec=" + TrangThaiCongViec + "]";
    }

    public static void MenuNhanVien(List<Sach> danhSachSach, List<HoaDonItem> hoaDonItems, DanhSachTK ds) {
        PhanLoai.DocDuLieuTuFileSach("Sach.txt", danhSachSach);
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println(
                    "------------------------------------------------------------------------------------------------------------------");
            System.out.println("Chuc nang cua nhan vien: ");
            System.out.println("[0] Thoat Menu.");
            System.out.println("[1] Xem danh sach sach.");
            System.out.println("[2] Phan loai sach.");
            System.out.println("[3] Xem thong tin quyen sach.");
            System.out.println("[4] Xuat hoa don sach.");
            System.out.print("Chon de thuc hien chuc nang: ");
            // boolean shouldExit = false;
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(
                            "------------------------------------------------------------------------------------------------------------------");
                    for (Sach sach : danhSachSach) {
                        System.out.println("=====" + sach.getTenSach() + "=====");
                    }
                    break;
                case 2:
                    PhanLoai.MenuPhanLoai(danhSachSach, hoaDonItems, ds);
                    break;

                case 3:
                    QuyenUser.xemThongTinSach(danhSachSach);
                    break;

                case 4:
                    ChiTietHoaDon.runChiTietHoaDon();
                    break;

                case 0:
                    DangNhap.DangNhaptaikhoan();
                    break;
            }
        }
    }

    // public static void main(String[] args) {
    // NhanVien a = new NhanVien();
    // System.out.print(a.toString());
    // }
}
