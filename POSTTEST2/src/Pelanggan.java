import java.util.ArrayList;
import java.util.Scanner;

public class Pelanggan extends User{
    private ArrayList<Transaksi> riwayatTransaksi;
    public Pelanggan(String username, String password, String nama, String email, String telepon) {
        super(username, password, nama, email, telepon);
        this.role = "pelanggan";
        this.riwayatTransaksi = new ArrayList<>();
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Pelanggan: " + nama + " (" + username + ")");
        System.out.println("Email: " + email);
        System.out.println("Telepon: " + telepon);
    }

    public void tambahTransaksi(Transaksi transaksi) {
        riwayatTransaksi.add(transaksi);
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

    public void lihatRiwayatTransaksi() {
        System.out.println("\n=== Riwayat Transaksi ===");
        if (riwayatTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi.");
            return;
        }
        for (Transaksi transaksi : riwayatTransaksi) {
            System.out.println("ID: " + transaksi.getId());
            System.out.println("Tanggal: " + transaksi.getTanggal());
            System.out.println("Paket: " + transaksi.getPaketLayanan().getNama());
            System.out.println("Berat: " + transaksi.getBerat() + " kg");
            System.out.println("Total Harga: Rp" + String.format("%,.2f", transaksi.getTotalHarga()));
            System.out.println("Status: " + transaksi.getStatus());
            System.out.println("-----------------");
        }
    }

    public void cekStatusLaundry() {
        System.out.println("\n=== Status Laundry ===");
        if (riwayatTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi.");
            return;
        }
        for (Transaksi transaksi : riwayatTransaksi) {
            if (!transaksi.getStatus().equals("Diambil")) {
                System.out.println("ID: " + transaksi.getId());
                System.out.println("Tanggal: " + transaksi.getTanggal());
                System.out.println("Paket: " + transaksi.getPaketLayanan().getNama());
                System.out.println("Status: " + transaksi.getStatus());
                System.out.println("-----------------");
            }
        }
    }

    public void editProfil(Scanner scanner) {
        System.out.println("Data Profil Saat Ini:");
        tampilkanInfo();
        System.out.println("\nMasukkan data yang baru:");
        System.out.print("Nama baru: ");
        String nama = scanner.nextLine();
        if (!nama.isEmpty()) {
            setNama(nama);
        }
        System.out.print("Email baru: ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) {
            setEmail(email);
        }
        System.out.print("Telepon baru: ");
        String telepon = scanner.nextLine();
        if (!telepon.isEmpty()) {
            setTelepon(telepon);
        }
        System.out.print("Password baru (kosongkan jika tidak ingin mengubah): ");
        String password = scanner.nextLine();
        if (!password.isEmpty()) {
            setPassword(password);
        }
        System.out.println("Profil berhasil diperbarui!");
    }
}
