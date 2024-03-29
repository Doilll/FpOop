package fpsemester2;

public class Barang extends Menu {

    private int harga;
    public int stok;

    public Barang(String nama, int harga, int stok) {
        super(nama);
        this.harga = harga;
        this.stok = stok;
    }

    public int getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String toString() {
        return getNama() + " harga: " + this.harga + " stok: " + this.stok;
    }

}
