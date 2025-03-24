public class PaketLayanan {
    private String nama;
    private String deskripsi;
    private double hargaPerKg;

    public PaketLayanan(String nama, String deskripsi, double hargaPerKg) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.hargaPerKg = hargaPerKg;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public double getHargaPerKg() {
        return hargaPerKg;
    }

    public void setHargaPerKg(double hargaPerKg) {
        this.hargaPerKg = hargaPerKg;
    }

    public void tampilkanInfo() {
        System.out.println("Paket: " + nama);
        System.out.println("Deskripsi: " + deskripsi);
        System.out.println("Harga per kg: Rp" + String.format("%,.2f", hargaPerKg));
    }
}