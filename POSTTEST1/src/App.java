import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<PaketLayanan> paketLayanan = new ArrayList<>();
    private static Admin admin = new Admin("admin", "admin123", "admin", "admin@laundry.com", "08123456789");

    public static void main(String[] args) throws Exception {
        users.add(admin);
        users.add(new Pegawai("pegawai1", "pegawai123", "octa", "octa@laundry.com", "08111111111"));
        users.add(new Pegawai("pegawai2", "pegawai123", "nay", "via@laundry.com", "08222222222"));
        users.add(new Pelanggan("pelanggan1", "pelanggan123", "iim", "iim@gmail.com", "08333333333333"));
        users.add(new Pelanggan("pelanggan2", "pelanggan123", "jasmine", "jsm@gmail.com", "083456789012"));
        paketLayanan.add(new PaketLayanan("Regular", "Cuci + Setrika", 7000));
        paketLayanan.add(new PaketLayanan("Express", "Cuci + Setrika (Selesai 1 Hari)", 10000));
        paketLayanan.add(new PaketLayanan("Super Express", "Cuci + Setrika (Selesai 6 Jam)", 15000));

        menuAdmin();
    }

    private static void menuAdmin() {
        boolean looping = true;
        while (looping) {
            System.out.println("\n+======= Menu Admin =======+");
            System.out.println("|--------------------------|");
            System.out.println("|1. Manajemen Pegawai      |");
            System.out.println("|--------------------------|");
            System.out.println("|2. Manajemen Pelanggan    |");
            System.out.println("|--------------------------|");
            System.out.println("|3. Manajemen Paket Layanan|");
            System.out.println("|--------------------------|");
            System.out.println("|4. Keluar                 |");
            System.out.println("+--------------------------+");
            System.out.print("Pilih menu: ");
            int pilihan = inputInteger();
            switch (pilihan) {
                case 1:
                    manajemenPegawai();
                    break;
                case 2:
                    manajemenPelanggan();
                    break;
                case 3:
                    manajemenPaketLayanan();
                    break;
                case 4:
                    looping = false;
                    break;
                default:
                    System.out.println("Menu tidak valid!");
            }
        }
    }

    private static void manajemenPegawai() {
        boolean looping = true;
        while (looping) {
            System.out.println("\n+========= Manajemen Pegawai =========+");
            System.out.println("|--------------------------------------|");
            System.out.println("|1. Lihat Semua Pegawai                |");
            System.out.println("|--------------------------------------|");
            System.out.println("|2. Tambah Pegawai                     |");
            System.out.println("|--------------------------------------|");
            System.out.println("|3. Edit Pegawai                       |");
            System.out.println("|--------------------------------------|");
            System.out.println("|4. Hapus Pegawai                      |");
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
                    looping = false;
                    break;
                default:
                    System.out.println("Menu tidak valid!");
            }
        }
    }

    private static void manajemenPelanggan() {
        boolean looping = true;
        while (looping) {
            System.out.println("\n+========= Manajemen Pelanggan =========+");
            System.out.println("|----------------------------------------|");
            System.out.println("|1. Lihat Semua Pelanggan                |");
            System.out.println("|----------------------------------------|");
            System.out.println("|2. Tambah Pelanggan                     |");
            System.out.println("|----------------------------------------|");
            System.out.println("|3. Edit Pelanggan                       |");
            System.out.println("|----------------------------------------|");
            System.out.println("|4. Hapus Pelanggan                      |");
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
                    looping = false;
                    break;
                default:
                    System.out.println("Menu tidak valid!");
            }
        }
    }

    private static void manajemenPaketLayanan() {
        boolean looping = true;
        while (looping) {
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
                    looping = false;
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
            System.out.println("Input harus berupa angka bulat!");
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