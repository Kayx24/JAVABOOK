import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
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
    private String TrangThaiCongViec; // 1 dang lam, 0 dang nghi

    public NhanVien(){
    }

    public NhanVien(String tenNhanVien, String maNV, String sDT, Date ngaySinh, String gioiTinh,
            Date ngayBatDauLam, String trangThaiCongViec) {
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
        this.TenNhanVien = tenNhanVien;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String maNV) {
        this.MaNV = maNV;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.NgaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.GioiTinh = gioiTinh;
    }

    public Date getNgayBatDauLam() {
        return NgayBatDauLam;
    }

    public void setNgayBatDauLam(Date ngayBatDauLam) {
        this.NgayBatDauLam = ngayBatDauLam;
    }

    public String getTrangThaiCongViec() {
        return TrangThaiCongViec;
    }

    public void setTrangThaiCongViec(String trangThaiCongViec) {
        this.TrangThaiCongViec = trangThaiCongViec;
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
        this.Password = password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        this.Role = role;
    }

    public void NhapNhanVien() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten nhan vien: ");
        TenNhanVien = sc.nextLine();
        boolean validMaNV = false;
        while (!validMaNV) {
            System.out.print("Nhap ma nhan vien (VD: NV001): ");
            MaNV = sc.nextLine();
            if (MaNV.matches("NV\\d{3}")) {
                validMaNV = true;
            } else {
                System.out.println("Ma nhan vien khong hop le. Vui long nhap lai.");
            }
        }
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
        boolean validGioiTinh = false;
        while (!validGioiTinh) {
            System.out.print("Gioi tinh (nam/nu): ");
            GioiTinh = sc.nextLine().toLowerCase(); // Convert to lowercase for case-insensitive comparison
            if (GioiTinh.equals("nam") || GioiTinh.equals("nu")) {
                validGioiTinh = true;
            } else {
                System.out.println("Gioi tinh khong hop le. Vui long nhap lai.");
            }
        }
        validDate = false;
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
        System.out.println("Trang thai cong viec: ");
        setTrangThaiCongViec("Dang lam");
    }

    public void docDuLieuTuFileTaiKhoan() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("DanhSachTaiKhoan.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3 && parts[2].equals("NhanVien")) {
                    String username = parts[0];
                    String password = parts[1];
                    String role = parts[2];

                    setUserName(username);
                    setPassword(password);
                    setRole(role);
                }
            }
            bufferedReader.close();
            // System.out.println("Doc du lieu tu file thanh cong!");
        } catch (IOException e) {
            System.out.println("Co loi xay ra khi doc du lieu tu file.");
            e.printStackTrace();
        }
    }

    // public void LuuNhanVienVaoFile(List<NhanVien> dsNhanViens) {
    //     try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("DanhSachNhanVien.txt", false))) {
    //         SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    //         for (NhanVien nv : dsNhanViens) {
    //             String ngaySinhStr = dateFormat.format(nv.getNgaySinh());
    //             String ngayBatDauLamStr = dateFormat.format(nv.getNgayBatDauLam());
    
    //             bufferedWriter.write(
    //                     nv.getUserName() + "," + nv.getTenNhanVien() + "," + nv.getMaNV() + ","
    //                             + ngaySinhStr + "," + nv.getGioiTinh() + "," + ngayBatDauLamStr + ","
    //                             + nv.getTrangThaiCongViec());
    //             bufferedWriter.newLine();
    //         }
    
    //         System.out.println("Luu du lieu nhan vien vao file thanh cong!");
    //     } catch (IOException e) {
    //         System.out.println("Co loi xay ra khi luu du lieu nhan vien vao file.");
    //         e.printStackTrace();
    //     }
    // }

    public void LuuNhanVienVaoFile(NhanVien vn) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("DanhSachNhanVien.txt", true))) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            String ngaySinhStr = dateFormat.format(vn.getNgaySinh());
            String ngayBatDauLamStr = dateFormat.format(vn.getNgayBatDauLam());

            bufferedWriter.write(
                    vn.getUserName() + "," + vn.getTenNhanVien() + "," + vn.getMaNV() + ","
                            + ngaySinhStr + "," + vn.getGioiTinh() + "," + ngayBatDauLamStr + ","
                            + vn.getTrangThaiCongViec());
            bufferedWriter.newLine();

            System.out.println("Luu du lieu nhan vien vao file thanh cong!");
        } catch (IOException e) {
            System.out.println("Co loi xay ra khi luu du lieu nhan vien vao file.");
            e.printStackTrace();
        }
    }

    public void DocDuNhanVienTuFile(List<NhanVien> dsNhanViens) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("DanhSachNhanVien.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    String username = parts[0].trim();
                    String tenNhanVien = parts[1].trim();
                    String maNV = parts[2].trim();

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date ngaySinh = dateFormat.parse(parts[3].trim());
                    String gioiTinh = parts[4].trim();
                    Date ngayBatDauLam = dateFormat.parse(parts[5].trim());
                    String trangThaiLamViec = parts[6].trim();

                    NhanVien nv = new NhanVien();
                    nv.setUserName(username);
                    nv.setTenNhanVien(tenNhanVien);
                    nv.setMaNV(maNV);
                    nv.setNgaySinh(ngaySinh);
                    nv.setGioiTinh(gioiTinh);
                    nv.setNgayBatDauLam(ngayBatDauLam);
                    nv.setTrangThaiCongViec(trangThaiLamViec);

                    dsNhanViens.add(nv);
                }
            }
            System.out.println("Doc du lieu tu file thanh cong!");
        } catch (IOException | ParseException e) {
            System.out.println("Co loi xay ra khi doc du lieu tu file.");
            e.printStackTrace();
        }
    }

    public void XoaNhanVienTuFile(String userName, DanhSachTK ds) {
        Path filePath = Paths.get("DanhSachNhanVien.txt");

        try {
            List<String> lines = Files.readAllLines(filePath);
            Iterator<String> iterator = lines.iterator();
            while (iterator.hasNext()) {
                String line = iterator.next();
                String[] parts = line.split(",");
                if (parts.length > 0 && parts[0].trim().equals(userName)) {
                    iterator.remove();
                    break;
                }
            }

            Files.write(filePath, lines);
            System.out.println("Tai khoan nhan vien da duoc xoa tu DanhSachNhanVien.");
        } catch (IOException e) {
            System.out.println("Co loi xay ra khi xoá nhân viên tu file DanhSachNhanVien.");
            e.printStackTrace();
        }
    }


    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String ngaySinhStr = dateFormat.format(NgaySinh);
        String ngayBatDauLamStr = dateFormat.format(NgayBatDauLam);

        return "NhanVien [TaiKhoanNhanVien=" + UserName  +", TenNhanVien=" + TenNhanVien + ", MaNV=" + MaNV
                + ", NgaySinh=" + ngaySinhStr + ", GioiTinh=" + GioiTinh +", NgayBatDauLam=" + ngayBatDauLamStr
                + ", TrangThaiCongViec=" + TrangThaiCongViec + "]";
    }

public static void MenuNhanVien(List<Sach> danhSachSach, List<HoaDonItem> hoaDonItems, DanhSachTK ds,
            String tenFile) {
        QuyenUser qus = new QuyenUser();
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

            String input = sc.next();

            if (isNumeric(input)) {
                choice = Integer.parseInt(input);

                switch (choice) {
                    case 1:
                        System.out.println(
                                "------------------------------------------------------------------------------------------------------------------");
                        qus.Docsach();
                        break;
                    case 2:
                        PhanLoai.MenuPhanLoai(danhSachSach, hoaDonItems, ds);
                        break;

                    case 3:
                        QuyenUser.xemThongTinSach(danhSachSach, tenFile);
                        break;

                    case 4:
                        ChiTietHoaDon.runChiTietHoaDon();
                        break;

                    case 0:
                        DangNhap.DangNhaptaikhoan();
                        break;

                    default:
                        System.out.println("Vui long nhap lua chon hop le.");
                        break;
                }
            } else {
                System.out.println("Vui long nhap mot so.");
            }
        }
    }
    
    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+");
    }
}
