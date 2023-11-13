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

        if(tenDangNhap.equals("admin") && matKhau.equals("121")){
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
        Sach sach = new Sach(maSach, tenSach, tenLoaiSach, tenNhaXuatBan, giaBia, taiBan, tenNhaXuatBan, namXuatBan);
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
    


public void chinhSuaThongTinSach() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Nhap ma sach can sua: ");
    int maSach = sc.nextInt();
    sc.nextLine();
    
    for (Sach sach : danhSachSach) {
        if (sach.getMaSach() == maSach) {
            System.out.println("Thong tin sach can sua:");
            System.out.println("Ten sach hien tai: " + sach.getTenSach());
            System.out.print("Nhap ten sach moi: ");
            String tenSach = sc.nextLine();
            sach.setTenSach(tenSach);
            
            System.out.println("Ma tac gia hien tai: " + sach.getMaTg());
            System.out.print("Nhap ma tac gia moi: ");
            int maTg = sc.nextInt();
            sc.nextLine();
            sach.setMaTg(maTg);
            
            System.out.println("Ten loai sach hien tai: " + sach.getTenLoaiSach());
            System.out.print("Nhap ten loai sach moi: ");
            String tenLoaiSach = sc.nextLine();
            sach.setTenLoaiSach(tenLoaiSach);
            
            System.out.println("Gia sach hien tai: " + sach.getGiaBia());
            System.out.print("Nhap gia sach moi: ");
            int giaBia = sc.nextInt();
            sc.nextLine();
            sach.setGiaBia(giaBia);
            
            System.out.println("So lan tai ban hien tai: " + sach.getTaiBan());
            System.out.print("Nhap so lan tai ban moi: ");
            int taiBan = sc.nextInt();
            sc.nextLine();
            sach.setTaiBan(taiBan);
            
            System.out.println("Ten nha xuat ban hien tai: " + sach.getTenNhaXuatBan());
            System.out.print("Nhap ten nha xuat ban moi: ");
            String tenNhaXuatBan = sc.nextLine();
            sach.setTenNhaXuatBan(tenNhaXuatBan);
            
            System.out.println("Nam xuat ban hien tai: " + sach.getNamXuatBan());
            System.out.print("Nhap nam xuat ban moi: ");
            int namXuatBan = sc.nextInt();
            sc.nextLine();
            sach.setNamXuatBan(namXuatBan);
            
            System.out.println("Da sua thong tin sach.");
            break;
        }
    }
}

    public List<Sach> getDanhSachSach() {
        return danhSachSach;
    }
    
    public boolean isAdmin() {
        return false;
    }

    public void nhapthongtinsach(String string) {
    }
}