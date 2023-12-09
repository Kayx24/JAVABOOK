public class Sach implements danhSachSach {
    private int MaSach;
    private String TenSach;
    private String TenLinhVuc; // thuộc lĩnh vực nào
    private String TenLoaiSach; // thuộc loại sách nào
    private int GiaBia; // Gía bán sách
    private int TaiBan; // số lần tái bản
    private String TenNhaXuatBan;
    private int NamXuatBan;
    private int SoLuongSach;

    // Constructor
    public Sach() {
    }

    public Sach(int maSach, String tenSach, String tenLinhVuc, String tenLoaiSach, int giaBia,
            int taiBan, String tenNhaXuatBan, int namXuatBan,int soLuongSach) {
        MaSach = maSach;
        TenSach = tenSach;
        TenLinhVuc = tenLinhVuc;
        TenLoaiSach = tenLoaiSach;
        GiaBia = giaBia;
        TaiBan = taiBan;
        TenNhaXuatBan = tenNhaXuatBan;
        NamXuatBan = namXuatBan;
        SoLuongSach=soLuongSach;
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
    public int getGiaBia() {
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
    
    @Override
    public int getSoLuongSach(){
        return SoLuongSach;
    }
    
    @Override
    public void setSoLuongSach(int soluong){
        SoLuongSach=soluong;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getMaSach())
        .append(",").append(getTenSach())
        .append(",").append(getTenLinhVuc())
        .append(",").append(getTenLoaiSach())
        .append(",").append(getGiaBia())
        .append(",").append(getTaiBan())
        .append(",").append(getTenNhaXuatBan())
        .append(",").append(getNamXuatBan())
        .append(",").append(getSoLuongSach());

        return sb.toString();
    }
        public String toStringFirstTime() {
        StringBuilder sb = new StringBuilder();
        sb.append(getMaSach())
        .append(",").append(getTenSach())
        .append(",Linh vuc").append(getTenLinhVuc())
        .append(",").append(getTenLoaiSach())
        .append(",").append(getGiaBia())
        .append(",").append(getTaiBan())
        .append(",").append(getTenNhaXuatBan())
        .append(",").append(getNamXuatBan())
        .append(",").append(getSoLuongSach());

        return sb.toString();
    }
}