import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuyenSach {
    private List<Sach> danhSachSach = new ArrayList<>();
    private Scanner sc;
    private boolean isAdmin;

    public void kiemtraDangNhap(){
        System.out.print("Nhap ten dang nhap: ");
        String tenDangNhap = sc.nextLine();
        System.out.print("Nhap mat khau: ");
        String matKhau = sc.nextLine();

        if(tenDangNhap.equals("helo1") && matKhau.equals("121")){
            isAdmin= true;
            System.out.println("Dang nhap thanh cong vao tai khoan admin ");
        } else {
            isAdmin = false;
            System.out.println("Dang nhap vao quyen khac ");
        }
    }

    public QuyenSach() {
        this.danhSachSach = new ArrayList<>();
        this.sc =new Scanner(System.in);
        this.isAdmin=false;
    }

    public void themSach(int maSach, String tenSach, int maTg, String tenLoaiSach, int giaBia, int taiBan, String tenNhaXuatBan, int namXuatBan) {
        Sach sach = new Sach(maSach, tenSach, maTg, tenLoaiSach, giaBia, taiBan, tenNhaXuatBan, namXuatBan);
        danhSachSach.add(sach);
    }
    public void xoaSach(int maSach){
        for(Sach sach : danhSachSach){
            if(sach.getMaSach() == maSach){
                danhSachSach.remove(sach);
                break;
            }
        }
    }

    public void nhapThongTinSachMoi() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin sach moi:");
        System.out.print("Ma sach: ");
        int maSach = sc.nextInt();
        sc.nextLine();
        System.out.print("Ten sach: ");
        String tenSach = sc.nextLine();
        System.out.print("Ma tac gia: ");
        int maTg = sc.nextInt();
        sc.nextLine();
        System.out.print("Ten loai sach: ");
        String tenLoaiSach = sc.nextLine();
        System.out.print("Gia bia: ");
        int giaBia = sc.nextInt();
        System.out.print("So lan tai ban: ");
        int taiBan = sc.nextInt();
        sc.nextLine();
        System.out.print("Ten nha xuat ban: ");
        String tenNhaXuatBan = sc.nextLine();
        System.out.print("Nam xuat ban: ");
        int namXuatBan =sc.nextInt();
        sc.nextLine();

        themSach(maSach, tenSach, maTg, tenLoaiSach, giaBia, taiBan, tenNhaXuatBan, namXuatBan);
    }
    
    public void chinhSuaThongTinSach(int maSach,String tenSach,int maTg,String tenLinhVuc,String tenLoaiSach,int giaBia,int taiBan,String tenNhaXuatBan,int namXuatBan){
        for(Sach sach : danhSachSach){
            if(sach.getMaSach() == maSach){
                sach.setTenSach(tenSach);
                sach.setMaTg(maTg);
                sach.setTenLoaiSach(tenLoaiSach);
                sach.setGiaBia(giaBia);
                sach.setTaiBan(taiBan);
                sach.setTenNhaXuatBan(tenNhaXuatBan);
                sach.setNamXuatBan(namXuatBan);
                break;
            }
        }
    }
     public static class Sach {
        private int maSach;
        private String tenSach;
        private int maTg;
        private String tenLinhVuc;
        private String tenLoaiSach;
        private int giaBia;
        private int taiBan;
        private String tenNhaXuatBan;
        private int namXuatBan;

        public Sach(int maSach, String tenSach, int maTg,String tenLoaiSach, int giaBia, int taiBan, String tenNhaXuatBan, int namXuatBan) {
            this.maSach = maSach;
            this.tenSach = tenSach;
            this.maTg = maTg;
            this.tenLoaiSach = tenLoaiSach;
            this.giaBia = giaBia;
            this.taiBan = taiBan;
            this.tenNhaXuatBan = tenNhaXuatBan;
            this.namXuatBan = namXuatBan;
        }

        public int getMaSach() {
            return maSach;
        }
        public void setMaSach(int maSach) {
            this.maSach = maSach;
        }
        public String getTenSach() {
            return tenSach;
        }
        public void setTenSach(String tenSach) {
            this.tenSach = tenSach;
        }
        public int getMaTg() {
            return maTg;
        }
        public void setMaTg(int maTg) {
            this.maTg = maTg;
        }
        public String getTenLinhVuc() {
            return tenLinhVuc;
        }
        public String getTenLoaiSach() {
            return tenLoaiSach;
        }
        public void setTenLoaiSach(String tenLoaiSach) {
            this.tenLoaiSach = tenLoaiSach;
        }
        public int getGiaBia() {
            return giaBia;
        }
        public void setGiaBia(int giaBia) {
            this.giaBia = giaBia;
        }
        public int getTaiBan() {
            return taiBan;
        }
        public void setTaiBan(int taiBan) {
            this.taiBan = taiBan;
        }
        public String getTenNhaXuatBan() {
            return tenNhaXuatBan;
        }
        public void setTenNhaXuatBan(String tenNhaXuatBan) {
            this.tenNhaXuatBan = tenNhaXuatBan;
        }
        public int getNamXuatBan() {
            return namXuatBan;
        }
        public void setNamXuatBan(int namXuatBan) {
            this.namXuatBan = namXuatBan;
        }
    }
    public List<QuyenSach.Sach> getDanhSachSach() {
        return danhSachSach;
    }
    
    public boolean isAdmin() {
        return false;
    }

    public void nhapthongtinsach(String string) {
    }
}