import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User {
    public Admin(String username, String password, String nama, String email, String telepon) {
        super(username, password, nama, email, telepon);
        this.role = "admin";
    }

    // --- Method Overriding ---
    @Override
    public void tampilkanInfo() {
        System.out.println("Admin: " + nama + " (" + username + ")");
        System.out.println("Email: " + email);
        System.out.println("Telepon: " + telepon);
    }

    public void lihatPegawai(ArrayList<User> users) {
        System.out.println("\n=== Daftar Pegawai ===");
        boolean ditemukan = false;
        for (User user : users) {
            if (user instanceof Pegawai) {
                user.tampilkanInfo();
                System.out.println("-----------------");
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Belum ada pegawai terdaftar.");
        }
    }

    // --- Method Overloading: tambahPegawai ---
    // Versi dengan parameter detail
    public void tambahPegawai(ArrayList<User> users, String username, String password, String nama, String email,
            String telepon) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("Username sudah digunakan!");
                return;
            }
        }
        users.add(new Pegawai(username, password, nama, email, telepon));
        System.out.println("Pegawai berhasil ditambahkan!");
    }

    // Versi dengan objek Pegawai
    public void tambahPegawai(ArrayList<User> users, Pegawai pegawai) {
        for (User user : users) {
            if (user.getUsername().equals(pegawai.getUsername())) {
                System.out.println("Username sudah digunakan!");
                return;
            }
        }
        users.add(pegawai);
        System.out.println("Pegawai berhasil ditambahkan (via object)!");
    }

    public void editPegawai(ArrayList<User> users, String username, Scanner scanner) {
        for (User user : users) {
            if (user instanceof Pegawai && user.getUsername().equals(username)) {
                System.out.println("Data Pegawai Saat Ini:");
                user.tampilkanInfo();
                System.out.println("\nMasukkan data yang baru:");
                System.out.print("Nama baru: ");
                String nama = scanner.nextLine().trim();
                if (!nama.isEmpty()) {
                    user.setNama(nama);
                }
                System.out.print("Email baru: ");
                String email = scanner.nextLine().trim();
                if (!email.isEmpty()) {
                    user.setEmail(email);
                }
                System.out.print("Telepon baru: ");
                String telepon = scanner.nextLine().trim();
                if (!telepon.isEmpty()) {
                    user.setTelepon(telepon);
                }
                System.out.print("Password baru (kosongkan jika tidak ingin mengubah): ");
                String password = scanner.nextLine().trim();
                if (!password.isEmpty()) {
                    user.setPassword(password);
                }
                System.out.println("Data pegawai berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Pegawai dengan username tersebut tidak ditemukan!");
    }

    public void hapusPegawai(ArrayList<User> users, String username) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user instanceof Pegawai && user.getUsername().equals(username)) {
                users.remove(i);
                System.out.println("Pegawai berhasil dihapus!");
                return;
            }
        }
        System.out.println("Pegawai dengan username tersebut tidak ditemukan!");
    }

    public void lihatPelanggan(ArrayList<User> users) {
        System.out.println("\n=== Daftar Pelanggan ===");
        boolean ditemukan = false;
        for (User user : users) {
            if (user instanceof Pelanggan) {
                user.tampilkanInfo();
                System.out.println("-----------------");
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Belum ada pelanggan terdaftar.");
        }
    }

    // --- Method Overloading: tambahPelanggan ---
    // Versi dengan parameter detail
    public void tambahPelanggan(ArrayList<User> users, String username, String password, String nama, String email,
            String telepon) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("Username sudah digunakan!");
                return;
            }
        }
        users.add(new Pelanggan(username, password, nama, email, telepon));
        System.out.println("Pelanggan berhasil ditambahkan!");
    }

    // Versi dengan objek Pelanggan
    public void tambahPelanggan(ArrayList<User> users, Pelanggan pelanggan) {
        for (User user : users) {
            if (user.getUsername().equals(pelanggan.getUsername())) {
                System.out.println("Username sudah digunakan!");
                return;
            }
        }
        users.add(pelanggan);
        System.out.println("Pelanggan berhasil ditambahkan (via object)!");
    }

    public void editPelanggan(ArrayList<User> users, String username, Scanner scanner) {
        for (User user : users) {
            if (user instanceof Pelanggan && user.getUsername().equals(username)) {
                System.out.println("Data Pelanggan Saat Ini:");
                user.tampilkanInfo();
                System.out.println("\nMasukkan data yang baru:");
                System.out.print("Nama baru: ");
                String nama = scanner.nextLine().trim();
                if (!nama.isEmpty()) {
                    user.setNama(nama);
                }
                System.out.print("Email baru: ");
                String email = scanner.nextLine().trim();
                if (!email.isEmpty()) {
                    user.setEmail(email);
                }
                System.out.print("Telepon baru: ");
                String telepon = scanner.nextLine().trim();
                if (!telepon.isEmpty()) {
                    user.setTelepon(telepon);
                }
                System.out.print("Password baru (kosongkan jika tidak ingin mengubah): ");
                String password = scanner.nextLine().trim();
                if (!password.isEmpty()) {
                    user.setPassword(password);
                }
                System.out.println("Data pelanggan berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Pelanggan dengan username tersebut tidak ditemukan!");
    }

    public void hapusPelanggan(ArrayList<User> users, String username) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user instanceof Pelanggan && user.getUsername().equals(username)) {
                users.remove(i);
                System.out.println("Pelanggan berhasil dihapus!");
                return;
            }
        }
        System.out.println("Pelanggan dengan username tersebut tidak ditemukan!");
    }

    public void lihatPaketLayanan(ArrayList<PaketLayanan> paketLayanan) {
        System.out.println("\n=== Daftar Paket Layanan ===");
        if (paketLayanan.isEmpty()) {
            System.out.println("Belum ada paket layanan terdaftar.");
            return;
        }
        for (int i = 0; i < paketLayanan.size(); i++) {
            System.out.println("No. " + (i + 1));
            paketLayanan.get(i).tampilkanInfo();
            System.out.println("-----------------");
        }
    }

    // --- Method Overloading: tambahPaketLayanan ---
    // Versi dengan parameter detail
    public void tambahPaketLayanan(ArrayList<PaketLayanan> paketLayanan, String nama, String deskripsi,
            double hargaPerKg) {
        for (PaketLayanan paket : paketLayanan) {
            if (paket.getNama().equalsIgnoreCase(nama)) {
                System.out.println("Nama paket layanan sudah digunakan!");
                return;
            }
        }
        paketLayanan.add(new PaketLayanan(nama, hargaPerKg));
        System.out.println("Paket layanan berhasil ditambahkan!");
    }

    // Versi dengan objek PaketLayanan
    public void tambahPaketLayanan(ArrayList<PaketLayanan> paketLayanan, PaketLayanan paket) {
        for (PaketLayanan p : paketLayanan) {
            if (p.getNama().equalsIgnoreCase(paket.getNama())) {
                System.out.println("Nama paket layanan sudah digunakan!");
                return;
            }
        }
        paketLayanan.add(paket);
        System.out.println("Paket layanan berhasil ditambahkan (via object)!");
    }

    public void editPaketLayanan(ArrayList<PaketLayanan> paketLayanan, String nama, Scanner scanner) {
        for (PaketLayanan paket : paketLayanan) {
            if (paket.getNama().equalsIgnoreCase(nama)) {
                System.out.println("Data Paket Layanan Saat Ini:");
                paket.tampilkanInfo();
                System.out.println("\nMasukkan data yang baru:");
                System.out.print("Nama baru: ");
                String namaBaru = scanner.nextLine().trim();
                if (!namaBaru.isEmpty()) {
                    boolean nameExists = false;
                    for (PaketLayanan p : paketLayanan) {
                        if (p != paket && p.getNama().equalsIgnoreCase(namaBaru)) {
                            nameExists = true;
                            break;
                        }
                    }
                    if (nameExists) {
                        System.out.println("Nama paket layanan sudah digunakan!");
                    } else {
                        paket.setNama(namaBaru);
                    }
                }
                // Jika ada deskripsi, bisa diatur di sini (sesuai kebutuhan)
                System.out.print("Harga per kg baru: ");
                String hargaStr = scanner.nextLine().trim();
                if (!hargaStr.isEmpty()) {
                    try {
                        double harga = Double.parseDouble(hargaStr);
                        if (harga > 0) {
                            paket.setHargaPerKg(harga);
                        } else {
                            System.out.println("Harga harus lebih dari 0!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Format harga tidak valid!");
                    }
                }
                System.out.println("Data paket layanan berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Paket layanan dengan nama tersebut tidak ditemukan!");
    }

    public void hapusPaketLayanan(ArrayList<PaketLayanan> paketLayanan, String nama) {
        for (int i = 0; i < paketLayanan.size(); i++) {
            PaketLayanan paket = paketLayanan.get(i);
            if (paket.getNama().equalsIgnoreCase(nama)) {
                paketLayanan.remove(i);
                System.out.println("Paket layanan berhasil dihapus!");
                return;
            }
        }
        System.out.println("Paket layanan dengan nama tersebut tidak ditemukan!");
    }
}
