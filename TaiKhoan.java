import java.util.ArrayList;
import java.util.Iterator;


public class TaiKhoan {
    //check tài khoản role nào
    private  String UserName;
    private  String Password;
    private  String role;
    //CONSTRUCTOR
    public TaiKhoan(String userName, String password, String role) {
        this.UserName = userName;
        this.Password = password;
        this.role = role;
    }
    //GETTER,SETTER

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    @Override
    public String toString(){
        return "UserName: "+getUserName()+" Password: "+getPassword();
    }
}

class DanhSachTK {
    private  ArrayList<TaiKhoan> dstaikhoans;
    

    public DanhSachTK() {
        dstaikhoans = new ArrayList<>();
        
    }

    public TaiKhoan layTaiKhoan(String tenTK) {
        for (TaiKhoan tk : dstaikhoans) {
            if (tk.getUserName().equals(tenTK)) {
                return tk;
            }
        }
        return null; // Trả về null nếu không tìm thấy tài khoản
    }

    public  void themTaiKhoan(String maSV, String tenSV, String lop) {
        TaiKhoan tk = new TaiKhoan(maSV, tenSV, lop);
        dstaikhoans.add(tk);
    }

    public  void inTaiKhoan() {
        for (TaiKhoan tk : dstaikhoans) {
            System.out.println(tk.toString());
        }
    }

    public void xoaTaiKhaon(String UserName) {
        Iterator<TaiKhoan> iterator = dstaikhoans.iterator();
        while (iterator.hasNext()) {
            TaiKhoan tk = iterator.next();
            if (tk.getUserName().equals(UserName)) {
                iterator.remove();
                System.out.println("Da xoa tai khoan co ten: " + UserName);
            }
        }
    }

    public boolean timKiem(String UserName) {
        for (TaiKhoan tk : dstaikhoans) {
            if (tk.getUserName().equals(UserName) ) {
                return true;
            }
        }
        return false;
    }
    }

    //có các hàm check,sửa,xóa ,thêm NẾU RẢNH