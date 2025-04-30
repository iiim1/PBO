import java.util.ArrayList;
public final class Pelanggan extends User {
    private final ArrayList<Transaksi> riwayatTransaksi;

    public Pelanggan(String username, String password, String nama, String email, String telepon) {
        super("pelanggan", username);
        this.password = password;
        this.nama = nama;
        this.email = email;
        this.telepon = telepon;
        this.riwayatTransaksi = new ArrayList<>();
    }

    // --- Method Overriding ---
    @Override
    public void displayUserInfo() {
        System.out.println("\n=== Pelanggan Information ===");
        System.out.println("Username: " + username);
        System.out.println("Name: " + nama);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + telepon);
        System.out.println("Role: " + role);
    }

    // --- Method Overloading: Menambahkan transaksi ---
    // Versi pertama dengan objek Transaksi langsung
    public void tambahTransaksi(Transaksi transaksi) {
        riwayatTransaksi.add(transaksi);
    }

    // Versi kedua: membuat transaksi dari paket dan berat
    public void tambahTransaksi(PaketLayanan paket, double berat) {
        double totalHarga = paket.getHargaPerKg() * berat;
        Transaksi transaksi = new Transaksi(this, paket, berat, totalHarga);
        riwayatTransaksi.add(transaksi);
        System.out.println("Transaksi berhasil ditambahkan.");
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
        boolean adaProses = false;
        for (Transaksi transaksi : riwayatTransaksi) {
            if (!transaksi.getStatus().equals("Diambil")) {
                System.out.println("ID: " + transaksi.getId());
                System.out.println("Tanggal: " + transaksi.getTanggal());
                System.out.println("Paket: " + transaksi.getPaketLayanan().getNama());
                System.out.println("Status: " + transaksi.getStatus());
                System.out.println("-----------------");
                adaProses = true;
            }
        }
        if (!adaProses) {
            System.out.println("Tidak ada laundry yang sedang diproses.");
        }
    }
}
