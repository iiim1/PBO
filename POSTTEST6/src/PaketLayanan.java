public class PaketLayanan {
    private String nama;
    private double hargaPerKg;

    public PaketLayanan(String nama, double hargaPerKg) {
        this.nama = nama;
        this.hargaPerKg = hargaPerKg;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHargaPerKg() {
        return hargaPerKg;
    }

    public void setHargaPerKg(double hargaPerKg) {
        if (hargaPerKg <= 0) {
            throw new IllegalArgumentException("Harga per kg harus lebih dari 0!");
        }
        this.hargaPerKg = hargaPerKg;
    }

    public void tampilkanInfo() {
        System.out.println("Nama Paket: " + nama);
        System.out.println("Harga per Kg: Rp" + String.format("%,.2f", hargaPerKg));
    }
}
