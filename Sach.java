public class Sach implements danhSachSach {
    private int MaSach;
    private String TenSach;
    private String TenLinhVuc; // thuộc lĩnh vực nào
    private String TenLoaiSach; // thuộc loại sách nào
    private int GiaBia; // Gía bán sách
    private int TaiBan; // số lần tái bản
    private String TenNhaXuatBan;
    private int NamXuatBan;
    private static int soLuongSach;

    // Constructor
    public Sach() {
    }

    public Sach(int maSach, String tenSach, String tenLinhVuc, String tenLoaiSach, int giaBia,
            int taiBan, String tenNhaXuatBan, int namXuatBan) {
        MaSach = maSach;
        TenSach = tenSach;
        TenLinhVuc = tenLinhVuc;
        TenLoaiSach = tenLoaiSach;
        GiaBia = giaBia;
        TaiBan = taiBan;
        TenNhaXuatBan = tenNhaXuatBan;
        NamXuatBan = namXuatBan;
        soLuongSach++;
    }

    // GETTER,SETTER
    @Override
    public int getMaSach() {
        return MaSach;
    }
    
    @Override
    public void setMaSach(int maSach) {
        MaSach = maSach;
    }

    @Override
    public String getTenSach() {
        return TenSach;
    }

    @Override
    public void setTenSach(String tenSach) {
        TenSach = tenSach;
    }

    @Override
    public String getTenLinhVuc() {
        return TenLinhVuc;
    }

    @Override
    public void setTenLinhVuc(String tenLinhVuc) {
        TenLinhVuc = tenLinhVuc;
    }

    @Override
    public String getTenLoaiSach() {
        return TenLoaiSach;
    }

    @Override
    public void setTenLoaiSach(String tenLoaiSach) {
        TenLoaiSach = tenLoaiSach;
    }

    @Override
    public double getGiaBia() {
        return GiaBia;
    }

    @Override
    public void setGiaBia(double giaBia) {
        GiaBia = (int) giaBia;
    }

    @Override
    public int getTaiBan() {
        return TaiBan;
    }

    @Override
    public void setTaiBan(int taiBan) {
        TaiBan = taiBan;
    }

    @Override
    public String getTenNhaXuatBan() {
        return TenNhaXuatBan;
    }

    @Override
    public void setTenNhaXuatBan(String tenNhaXuatBan) {
        TenNhaXuatBan = tenNhaXuatBan;
    }

    @Override
    public int getNamXuatBan() {
        return NamXuatBan;
    }

    @Override
    public void setNamXuatBan(int namXuatBan) {
        NamXuatBan = namXuatBan;
    }

    public static int getSoLuongSach(){
        return soLuongSach;
    }
    
    public static void setSoLuongSach(int soluong){
        soLuongSach=soluong;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ten sach: ").append(getTenSach())
          .append(" Gia: ").append(getGiaBia())
          .append(" Nha xuat ban:").append(getTenNhaXuatBan())
          .append(" Nam xuat ban:").append(getNamXuatBan());
        return sb.toString();
    }
}