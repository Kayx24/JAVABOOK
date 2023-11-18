import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
     public static List<HoaDonItem> readHoaDonItemsFromFile(String fileName) {
        List<HoaDonItem> hoaDonItems = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String maKhachHang = parts[0];
                    Date ngayDatSach = dateFormat.parse(parts[1]);
                    String tenSach = parts[2];
                    int soLuongMua = Integer.parseInt(parts[3]);
                    double giaSach = Double.parseDouble(parts[4]);
                    double tongTien = Double.parseDouble(parts[5]);

                    HoaDonItem hoaDonItem = new HoaDonItem(maKhachHang, ngayDatSach, tenSach, soLuongMua, giaSach, tongTien);
                    hoaDonItems.add(hoaDonItem);
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return hoaDonItems;
    }
        
   

}
