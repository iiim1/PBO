public class Transaksi {
    private String id;
    private Pelanggan pelanggan;
    private PaketLayanan paketLayanan;
    private double berat;
    private double totalHarga;
    private String tanggal;
    private String status;

    public Transaksi(Pelanggan pelanggan, PaketLayanan paketLayanan, double berat, double totalHarga) {
        this.id = generateId();
        this.pelanggan = pelanggan;
        this.paketLayanan = paketLayanan;
        this.berat = berat;
        this.totalHarga = totalHarga;
        this.tanggal = java.time.LocalDate.now().toString();
        this.status = "Diterima";
    }

    private String generateId() {
        return "058" + System.currentTimeMillis();
    }

    public String getId() {
        return id;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public PaketLayanan getPaketLayanan() {
        return paketLayanan;
    }

    public double getBerat() {
        return berat;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
