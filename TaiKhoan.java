import java.util.ArrayList;
import java.util.Iterator;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class TaiKhoan {
    // check tài khoản role nào
    private String UserName;
    private String Password;
    private String role;
    // CONSTRUCTOR

    public TaiKhoan() {

    }

    public TaiKhoan(String userName, String password, String role) {
        this.UserName = userName;
        this.Password = password;
        this.role = role;
    }
    // GETTER,SETTER

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
    public String toString() {
        return "UserName: " + getUserName() + " Password: " + getPassword();
    }
}

class DanhSachTK {
    private ArrayList<TaiKhoan> dstaikhoans;

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

    public void themTaiKhoan(String maSV, String tenSV, String lop) {
        TaiKhoan tk = new TaiKhoan(maSV, tenSV, lop);
        dstaikhoans.add(tk);
    }

    public void inTaiKhoan() {
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
            if (tk.getUserName().equals(UserName)) {
                return true;
            }
        }
        return false;
    }
    // thêm tài khoản

    public void luuDuLieuVaoFile(String tenTepTin) {
        try {
            FileWriter fileWriter = new FileWriter(tenTepTin);
            for (TaiKhoan taiKhoan : dstaikhoans) {
                String line = taiKhoan.getUserName() + "," + taiKhoan.getPassword() + "," + taiKhoan.getRole();
                fileWriter.write(line + "\n");
            }
            fileWriter.close();
            System.out.println("Luu du lieu thanh cong!");
        } catch (IOException e) {
            System.out.println("Co loi xay ra khi luu du lieu vao file.");
            e.printStackTrace();
        }
    }

    public void docDuLieuTuFile(String tenTepTin) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(tenTepTin));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String username = parts[0];
                    String password = parts[1];
                    String role = parts[2];
                    TaiKhoan taiKhoan = new TaiKhoan(username, password, role);
                    dstaikhoans.add(taiKhoan);
                }
            }
            bufferedReader.close();
            // System.out.println("Doc du lieu tu file thanh cong!");
        } catch (IOException e) {
            System.out.println("Co loi xay ra khi doc du lieu tu file.");
            e.printStackTrace();
        }
    }
}
// có các hàm check,sửa,xóa ,thêm NẾU RẢNH