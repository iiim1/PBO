import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<PaketLayanan> paketLayanan = new ArrayList<>();
    private static User userLogin = null;

    public static void main(String[] args) throws Exception {
        users.add(new Admin("admin", "admin123", "admin", "admin@laundry.com", "08123456789"));
        users.add(new Pegawai("pegawai1", "pegawai123", "octa", "octa@laundry.com", "08111111111"));
        users.add(new Pegawai("pegawai2", "pegawai123", "nay", "via@laundry.com", "08222222222"));
        users.add(new Pelanggan("pelanggan1", "pelanggan123", "iim", "iim@gmail.com", "08333333333333"));
        users.add(new Pelanggan("pelanggan2", "pelanggan123", "jasmine", "jsm@gmail.com", "083456789012"));
        paketLayanan.add(new PaketLayanan("Regular", "Cuci + Setrika", 7000));
        paketLayanan.add(new PaketLayanan("Express", "Cuci + Setrika (Selesai 1 Hari)", 10000));
        paketLayanan.add(new PaketLayanan("Super Express", "Cuci + Setrika (Selesai 6 Jam)", 15000));

        mulai();
    }

    public static void mulai() {
        boolean running = true;
        while (running) {
            if (userLogin == null) {
                System.out.println("\n+========== SISTEM LAUNDRY ==========+");
                System.out.println("|-----------------------------------|");
                System.out.println("|1. Login                           |");
                System.out.println("|-----------------------------------|");
                System.out.println("|2. Keluar Program                  |");
                System.out.println("+-----------------------------------+");
                System.out.print("Pilih menu: ");
                int pilihan = inputInteger();
                switch (pilihan) {
                    case 1:
                        login();
                        break;
                    case 2:
                        System.out.println("Terima kasih telah menggunakan Sistem Laundry!");
                        running = false;
                        break;
                    default:
                        System.out.println("Menu tidak valid!");
                }
            } else {
                switch (userLogin.getRole()) {
                    case "admin":
                        menuAdmin();
                        break;
                    case "pegawai":
                        menuPegawai();
                        break;
                    case "pelanggan":
                        menuPelanggan();
                        break;
                }
            }
        }
        scanner.close();
    }

    private static void login() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                userLogin = user;
                System.out.println("Login berhasil sebagai " + user.getRole());
                switch (user.getRole()) {
                    case "admin":
                        menuAdmin();
                        break;
                    case "pegawai":
                        menuPegawai();
                        break;
                    case "pelanggan":
                        menuPelanggan();
                        break;
                }
                return;
            }
        }
        System.out.println("Username atau password salah!");
    }

    private static void menuAdmin() {
        Admin admin = (Admin) userLogin;
        boolean running = true;
        while (running) {
            System.out.println("\n+======= Menu admin =======+");
            System.out.println("|--------------------------|");
            System.out.println("|1. Manajemen pegawai      |");
            System.out.println("|--------------------------|");
            System.out.println("|2. Manajemen pelanggan    |");
            System.out.println("|--------------------------|");
            System.out.println("|3. Manajemen Paket Layanan|");
            System.out.println("|--------------------------|");
            System.out.println("|4. Keluar                 |");
            System.out.println("+--------------------------+");
            System.out.print("Pilih menu: ");
            int pilihan = inputInteger();
            switch (pilihan) {
                case 1:
                    manajemenPegawai(admin);
                    break;
                case 2:
                    manajemenPelanggan(admin);
                    break;
                case 3:
                    manajemenPaketLayanan(admin);
                    break;
                case 4:
                    userLogin = null;
                    running = false;
                    break;
                default:
                    System.out.println("Menu tidak valid!");
            }
        }
    }

    private static void manajemenPegawai(Admin admin) {
        boolean running = true;
        while (running) {
            System.out.println("\n+========= Manajemen pegawai =========+");
            System.out.println("|--------------------------------------|");
            System.out.println("|1. Lihat Semua pegawai                |");
            System.out.println("|--------------------------------------|");
            System.out.println("|2. Tambah pegawai                     |");
            System.out.println("|--------------------------------------|");
            System.out.println("|3. Edit pegawai                       |");
            System.out.println("|--------------------------------------|");
            System.out.println("|4. Hapus pegawai                      |");
            System.out.println("|--------------------------------------|");
            System.out.println("|5. Kembali                            |");
            System.out.println("+--------------------------------------+");
            System.out.print("Pilih menu: ");
            int pilihan = inputInteger();
            switch (pilihan) {
                case 1:
                    admin.lihatPegawai(users);
                    break;
                case 2:
                    System.out.print("Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    System.out.print("Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("No. Telepon: ");
                    String telepon = scanner.nextLine();
                    admin.tambahPegawai(users, username, password, nama, email, telepon);
                    break;
                case 3:
                    System.out.print("Username pegawai yang akan diedit: ");
                    String editUsername = scanner.nextLine();
                    admin.editPegawai(users, editUsername, scanner);
                    break;
                case 4:
                    System.out.print("Username pegawai yang akan dihapus: ");
                    String hapusUsername = scanner.nextLine();
                    admin.hapusPegawai(users, hapusUsername);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Menu tidak valid!");
            }
        }
    }

    private static void manajemenPelanggan(Admin admin) {
        boolean running = true;
        while (running) {
            System.out.println("\n+========= Manajemen pelanggan =========+");
            System.out.println("|----------------------------------------|");
            System.out.println("|1. Lihat Semua pelanggan                |");
            System.out.println("|----------------------------------------|");
            System.out.println("|2. Tambah pelanggan                     |");
            System.out.println("|----------------------------------------|");
            System.out.println("|3. Edit pelanggan                       |");
            System.out.println("|----------------------------------------|");
            System.out.println("|4. Hapus pelanggan                      |");
            System.out.println("|----------------------------------------|");
            System.out.println("|5. Kembali                              |");
            System.out.println("+----------------------------------------+");
            System.out.print("Pilih menu: ");
            int pilihan = inputInteger();
            switch (pilihan) {
                case 1:
                    admin.lihatPelanggan(users);
                    break;
                case 2:
                    System.out.print("Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    System.out.print("Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("No. Telepon: ");
                    String telepon = scanner.nextLine();
                    admin.tambahPelanggan(users, username, password, nama, email, telepon);
                    break;
                case 3:
                    System.out.print("Username pelanggan yang akan diedit: ");
                    String editUsername = scanner.nextLine();
                    admin.editPelanggan(users, editUsername, scanner);
                    break;
                case 4:
                    System.out.print("Username pelanggan yang akan dihapus: ");
                    String hapusUsername = scanner.nextLine();
                    admin.hapusPelanggan(users, hapusUsername);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Menu tidak valid!");
            }
        }
    }

    private static void manajemenPaketLayanan(Admin admin) {
        boolean running = true;
        while (running) {
            System.out.println("\n+========= Manajemen Paket Layanan =========+");
            System.out.println("|--------------------------------------------|");
            System.out.println("|1. Lihat Semua Paket Layanan                |");
            System.out.println("|--------------------------------------------|");
            System.out.println("|2. Tambah Paket Layanan                     |");
            System.out.println("|--------------------------------------------|");
            System.out.println("|3. Edit Paket Layanan                       |");
            System.out.println("|--------------------------------------------|");
            System.out.println("|4. Hapus Paket Layanan                      |");
            System.out.println("|--------------------------------------------|");
            System.out.println("|5. Kembali                                  |");
            System.out.println("+--------------------------------------------+");
            System.out.print("Pilih menu: ");
            int pilihan = inputInteger();
            switch (pilihan) {
                case 1:
                    admin.lihatPaketLayanan(paketLayanan);
                    break;
                case 2:
                    System.out.print("Nama Paket: ");
                    String nama = scanner.nextLine();
                    System.out.print("Deskripsi: ");
                    String deskripsi = scanner.nextLine();
                    System.out.print("Harga per kg: ");
                    double harga = inputDouble();
                    admin.tambahPaketLayanan(paketLayanan, nama, deskripsi, harga);
                    break;
                case 3:
                    System.out.print("Nama paket yang akan diedit: ");
                    String editNama = scanner.nextLine();
                    admin.editPaketLayanan(paketLayanan, editNama, scanner);
                    break;
                case 4:
                    System.out.print("Nama paket yang akan dihapus: ");
                    String hapusNama = scanner.nextLine();
                    admin.hapusPaketLayanan(paketLayanan, hapusNama);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Menu tidak valid!");
            }
        }
    }

    private static void menuPegawai() {
        Pegawai pegawai = (Pegawai) userLogin;
        boolean running = true;
        while (running) {
            System.out.println("\n+======= Menu pegawai =======+");
            System.out.println("|---------------------------|");
            System.out.println("|1. Lihat pelanggan         |");
            System.out.println("|---------------------------|");
            System.out.println("|2. Lihat Paket Layanan     |");
            System.out.println("|---------------------------|");
            System.out.println("|3. Input Transaksi         |");
            System.out.println("|---------------------------|");
            System.out.println("|4. Update Status Laundry   |");
            System.out.println("|---------------------------|");
            System.out.println("|5. Keluar                  |");
            System.out.println("+---------------------------+");
            System.out.print("Pilih menu: ");
            int pilihan = inputInteger();
            switch (pilihan) {
                case 1:
                    pegawai.lihatPelanggan(users);
                    break;
                case 2:
                    pegawai.lihatPaketLayanan(paketLayanan);
                    break;
                case 3:
                    pegawai.inputTransaksi(users, paketLayanan, scanner);
                    break;
                case 4:
                    pegawai.updateStatusLaundry(scanner);
                    break;
                case 5:
                    userLogin = null;
                    running = false;
                    break;
                default:
                    System.out.println("Menu tidak valid!");
            }
        }
    }

    private static void menuPelanggan() {
        Pelanggan pelanggan = (Pelanggan) userLogin;
        boolean running = true;
        while (running) {
            System.out.println("\n+======= Menu pelanggan =======+");
            System.out.println("|------------------------------|");
            System.out.println("|1. Lihat Paket Layanan        |");
            System.out.println("|------------------------------|");
            System.out.println("|2. Lihat Riwayat Transaksi    |");
            System.out.println("|------------------------------|");
            System.out.println("|3. Cek Status Laundry         |");
            System.out.println("|------------------------------|");
            System.out.println("|4. Edit Profil                |");
            System.out.println("|------------------------------|");
            System.out.println("|5. Keluar                     |");
            System.out.println("+------------------------------+");
            System.out.print("Pilih menu: ");
            int pilihan = inputInteger();
            switch (pilihan) {
                case 1:
                    pelanggan.lihatPaketLayanan(paketLayanan);
                    break;
                case 2:
                    pelanggan.lihatRiwayatTransaksi();
                    break;
                case 3:
                    pelanggan.cekStatusLaundry();
                    break;
                case 4:
                    pelanggan.editProfil(scanner);
                    break;
                case 5:
                    userLogin = null;
                    running = false;
                    break;
                default:
                    System.out.println("Menu tidak valid!");
            }
        }
    }

    private static int inputInteger() {
        try {
            int input = Integer.parseInt(scanner.nextLine());
            return input;
        } catch (NumberFormatException e) {
            System.out.println("Input harus berupa angka!");
            return -1;
        }
    }

    private static double inputDouble() {
        try {
            double input = Double.parseDouble(scanner.nextLine());
            return input;
        } catch (NumberFormatException e) {
            System.out.println("Input harus berupa angka!");
            return -1;
        }
    }
}