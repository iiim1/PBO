import java.util.Scanner;

public abstract class User {
    protected final String role;
    protected final String username;
    protected String password;
    protected String nama;
    protected String email;
    protected String telepon;

    public User(final String role, final String username) {
        this.role = role;
        this.username = username;
    }

    public final String getRole() {
        return role;
    }

    public final String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    protected void login() {
        System.out.println("User " + username + " logged in");
    }

    public abstract void tampilkanInfo();
    public abstract void editProfil(Scanner scanner);
}