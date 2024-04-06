package fpsemester2;

public class Barang {

    private String nama;
    private int harga;
    private int stok;
    private int totalPemasukan;

    public Barang(String nama, int harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public int getTotalPemasukan() {
        return totalPemasukan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public void setTotalPemasukan(int totalPemasukan) {
        this.totalPemasukan = totalPemasukan;
    }

    public String lihatPendapatan() {
        return this.nama + ": Rp." + this.totalPemasukan;
    }

    public String toString() {
        return getNama() + " harga: " + this.harga + " stok: " + this.stok;
    }

}
