public class User extends TaiKhoan{
    private  String UserName;
    private  String Password;
    private  String role;
    private  int msUser;
    // check ma user nhằm tránh sai sót khi có 2 user trở lên với database
    // thêm menu user

    public User(String userName, String password, String role,int msUser) {
        super(userName, password, role);
        this.msUser=msUser;
    }

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

    public int getMsUser() {
        return msUser;
    }

    public void setMsUser(int msUser) {
        this.msUser = msUser;
    }
    
    
}
