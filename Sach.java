public class Sach{
    private int MaSach;
    private String TenSach;
    private String TenLinhVuc; //thuộc lĩnh vực nào
    private String TenLoaiSach; //thuộc loại sách nào
    private int GiaBia;   //Gía bán sách
    private int TaiBan;   //số lần tái bản
    private String TenNhaXuatBan; 
    private int NamXuatBan;
    private int MaTg;
    //Constructor
    public Sach() {
    }
    public Sach(int maSach, String tenSach, int giaBia) {
        this.MaSach = maSach;
        this.TenSach = tenSach;
        this.GiaBia = giaBia;
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
    }

    //GETTER,SETTER
    public int getMaSach() {
        return MaSach;
    }
    public void setMaSach(int maSach) {
        MaSach = maSach;
    }
    public String getTenSach() {
        return TenSach;
    }
    public void setTenSach(String tenSach) {
        TenSach = tenSach;
    }
    public String getTenLinhVuc() {
        return TenLinhVuc;
    }
    public void setTenLinhVuc(String tenLinhVuc) {
        TenLinhVuc = tenLinhVuc;
    }
    public String getTenLoaiSach() {
        return TenLoaiSach;
    }
    public void setTenLoaiSach(String tenLoaiSach) {
        TenLoaiSach = tenLoaiSach;
    }
    public double getGiaBia() {
        return GiaBia;
    }
    public void setGiaBia(double giaBia) {
        GiaBia = (int) giaBia;
    }
    public int getTaiBan() {
        return TaiBan;
    }
    public void setTaiBan(int taiBan) {
        TaiBan = taiBan;
    }
    public String getTenNhaXuatBan() {
        return TenNhaXuatBan;
    }
    public void setTenNhaXuatBan(String tenNhaXuatBan) {
        TenNhaXuatBan = tenNhaXuatBan;
    }
    public int getNamXuatBan() {
        return NamXuatBan;
    }
    public void setNamXuatBan(int namXuatBan) {
        NamXuatBan = namXuatBan;
    }
    public int getMaTg() {
        return MaTg;
    }
    public void setMaTg(int maTg) {
        MaTg = maTg;
    }
    @Override
    public String toString() {
        return "Ten sach: "+getTenSach()+" Gia: "+getGiaBia()+" Nha xuat ban:"+getTenNhaXuatBan()+" Nam xuat ban:"+getNamXuatBan();
    }
}