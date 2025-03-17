// Kelas User
abstract class User {
    protected String username;
    protected String password;
    protected String nama;
    protected String email;
    protected String telepon;
    protected String role;

    public User(String username, String password, String nama, String email, String telepon, String role) {
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.email = email;
        this.telepon = telepon;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void tampilkanInfo() {
        System.out.println(role + ": " + nama + " (" + username + ")");
        System.out.println("Email: " + email);
        System.out.println("Telepon: " + telepon);
    }
}

class Pelanggan extends User {
    public Pelanggan(String username, String password, String nama, String email, String telepon) {
        super(username, password, nama, email, telepon, "Pelanggan");
    }
}

class Pegawai extends User {
    public Pegawai(String username, String password, String nama, String email, String telepon) {
        super(username, password, nama, email, telepon, "Pegawai");
    }
}