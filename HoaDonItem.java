
import java.util.Date;
public class HoaDonItem {
  
    String tenSach;
    int soLuongMua;
    double giaSach;
    double tongTien;
    Date ngayDatSach;
    String maKhachHang;


    public  HoaDonItem(  String maKhachHang, Date ngayDatSach ,String tenSach, int soLuongMua, double giaSach, double tongTien) {
        this.tenSach = tenSach;
        this.soLuongMua = soLuongMua;
        this.giaSach = giaSach;
        this.tongTien = tongTien;
        this.ngayDatSach=ngayDatSach;
        this.maKhachHang=maKhachHang;
    }
    public String getTenSach() {
        return tenSach;
    }
    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }
    public int getSoLuongMua() {
        return soLuongMua;
    }
    public void setSoLuongMua(int soLuongMua) {
        this.soLuongMua = soLuongMua;
    }
    public double getGiaSach() {
        return giaSach;
    }
    public void setGiaSach(double giaSach) {
        this.giaSach = giaSach;
    }
    public double getTongTien() {
        return tongTien;
    }
    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    public Date getNgayDatSach() {
        return ngayDatSach;
    }

    public void setNgayDatSach(Date ngayDatSach) {
        this.ngayDatSach = ngayDatSach;
    }

    // Getter và Setter cho maKhachHang
    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }
    
   

}
