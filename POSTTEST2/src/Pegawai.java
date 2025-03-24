import java.util.ArrayList;
import java.util.Scanner;

public class Pegawai extends User{
    private ArrayList<Transaksi> transaksiList;

    public Pegawai(String username, String password, String nama, String email, String telepon) {
        super(username, password, nama, email, telepon);
        this.role = "pegawai";
        this.transaksiList = new ArrayList<>();
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Pegawai: " + nama + " (" + username + ")");
        System.out.println("Email: " + email);
        System.out.println("Telepon: " + telepon);
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

    public void inputTransaksi(ArrayList<User> users, ArrayList<PaketLayanan> paketLayanan, Scanner scanner) {
        if (paketLayanan.isEmpty()) {
            System.out.println("Belum ada paket layanan terdaftar.");
            return;
        }
        System.out.print("Username pelanggan: ");
        String username = scanner.nextLine();
        Pelanggan pelanggan = null;
        for (User user : users) {
            if (user instanceof Pelanggan && user.getUsername().equals(username)) {
                pelanggan = (Pelanggan) user;
                break;
            }
        }
        if (pelanggan == null) {
            System.out.println("Pelanggan dengan username tersebut tidak ditemukan!");
            return;
        }
        lihatPaketLayanan(paketLayanan);
        System.out.print("Pilih nomor paket layanan (1-" + paketLayanan.size() + "): ");
        int noPaket = -1;
        try {
            noPaket = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Input harus berupa angka!");
            return;
        }
        if (noPaket < 1 || noPaket > paketLayanan.size()) {
            System.out.println("Nomor paket tidak valid!");
            return;
        }
        PaketLayanan paket = paketLayanan.get(noPaket - 1);
        System.out.print("Berat cucian (kg): ");
        double berat = -1;
        try {
            berat = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Input harus berupa angka!");
            return;
        }
        if (berat <= 0) {
            System.out.println("Berat harus lebih dari 0!");
            return;
        }
        double totalHarga = berat * paket.getHargaPerKg();
        Transaksi transaksi = new Transaksi(pelanggan, paket, berat, totalHarga);
        transaksiList.add(transaksi);
        pelanggan.tambahTransaksi(transaksi);
        System.out.println("Transaksi berhasil ditambahkan!");
        System.out.println("ID Transaksi: " + transaksi.getId());
        System.out.println("Total harga: Rp" + String.format("%,.2f", totalHarga));
    }

    public void updateStatusLaundry(Scanner scanner) {
        if (transaksiList.isEmpty()) {
            System.out.println("Belum ada transaksi terdaftar.");
            return;
        }
        System.out.println("\n=== Daftar Transaksi ===");
        for (Transaksi transaksi : transaksiList) {
            System.out.println("ID: " + transaksi.getId());
            System.out.println("Pelanggan: " + transaksi.getPelanggan().getNama());
            System.out.println("Paket: " + transaksi.getPaketLayanan().getNama());
            System.out.println("Status: " + transaksi.getStatus());
            System.out.println("-----------------");
        }
        System.out.print("Masukkan ID transaksi yang akan diupdate: ");
        String id = scanner.nextLine();
        Transaksi targetTransaksi = null;
        for (Transaksi transaksi : transaksiList) {
            if (transaksi.getId().equals(id)) {
                targetTransaksi = transaksi;
                break;
            }
        }
        if (targetTransaksi == null) {
            System.out.println("Transaksi dengan ID tersebut tidak ditemukan!");
            return;
        }
        System.out.println("Status saat ini: " + targetTransaksi.getStatus());
        System.out.println("Pilih status baru:");
        System.out.println("1. Diterima");
        System.out.println("2. Dicuci");
        System.out.println("3. Dikeringkan");
        System.out.println("4. Disetrika");
        System.out.println("5. Selesai");
        System.out.println("6. Diambil");
        System.out.print("Pilih status (1-6): ");
        int pilihan = -1;
        try {
            pilihan = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Input harus berupa angka!");
            return;
        }
        String status;
        switch (pilihan) {
            case 1:
                status = "Diterima";
                break;
            case 2:
                status = "Dicuci";
                break;
            case 3:
                status = "Dikeringkan";
                break;
            case 4:
                status = "Disetrika";
                break;
            case 5:
                status = "Selesai";
                break;
            case 6:
                status = "Diambil";
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                return;
        }
        targetTransaksi.setStatus(status);
        System.out.println("Status transaksi berhasil diupdate menjadi: " + status);
    }
}
