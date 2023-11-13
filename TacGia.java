public class TacGia {
    private String ten;
    private String ngaysinh;
    private String quequan;
    private String tieusu;
public TacGia(){
    this.ten=ten;
    this.ngaysinh=ngaysinh;
    this.quequan=quequan;
    this.tieusu=tieusu; 
}

    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public String getNgaysinh() {
        return ngaysinh;
    }
    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }
    public String getQuequan() {
        return quequan;
    }
    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }
    public String getTieusu() {
        return tieusu;
    }
    public void setTieusu(String tieusu) {
        this.tieusu = tieusu;
    }
    @Override
    public String toString(){
        return 
         ten +' '+ ngaysinh+ ' ' + quequan+ ' '+ tieusu;
    }
}
