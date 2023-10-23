public class Sach{
    private int MaSach;
    private String TenSach;
    private int MaTg; //mã tác giả
    private String TenLinhVuc; //thuộc lĩnh vực nào
    private String TenLoaiSach; //thuộc loại sách nào
    private int GiaBia;   //Gía bán sách
    private int TaiBan;   //số lần tái bản
    private String TenNhaXuatBan; 
    private int NamXuatBan;
    //Constructor
    public Sach() {
    }
    
    public Sach(int maSach, String tenSach, int maTg, String tenLinhVuc, String tenLoaiSach, int giaBia,
            int taiBan, String tenNhaXuatBan, int namXuatBan) {
        MaSach = maSach;
        TenSach = tenSach;
        MaTg = maTg;
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
    public int getMaTg() {
        return MaTg;
    }
    public void setMaTg(int maTg) {
        MaTg = maTg;
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
    public int getGiaBia() {
        return GiaBia;
    }
    public void setGiaBia(int giaBia) {
        GiaBia = giaBia;
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
    @Override
    public String toString() {
        return "Ten sach: "+getTenSach()+" Gia: "+getGiaBia()+" Nha xuat ban:"+getTenNhaXuatBan()+" Nam xuat ban:"+getNamXuatBan();
    }

    //hàm thêm,sửa,xóa sách thêm khi cho vào danh sách sách dựa trên get,set

}