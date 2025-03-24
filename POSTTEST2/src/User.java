abstract class User {
    protected String username;
    protected String password;
    protected String nama;
    protected String email;
    protected String telepon;
    protected String role;

    public User(String username, String password, String nama, String email, String telepon) {
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.email = email;
        this.telepon = telepon;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String getNama() {
        return nama;
    }

    void setNama(String nama) {
        this.nama = nama;
    }

    String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getRole() {
        return role;
    }

    public abstract void tampilkanInfo();
}
