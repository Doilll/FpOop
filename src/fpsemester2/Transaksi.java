package fpsemester2;

import java.util.ArrayList;

public class Transaksi {

    private ArrayList<Barang> daftarBarang;
    private int totalHarga;
    private ArrayList<Integer> jumlah;

    public Transaksi() {
        this.daftarBarang = new ArrayList<>();
        this.totalHarga = 0;
        this.jumlah = new ArrayList<>();
    }

    public void tambahBarang(Barang barang, int jumlah) {
        this.daftarBarang.add(barang);
        this.jumlah.add(jumlah);
        barang.setStok(barang.getStok() - jumlah);
    }

    public void gantiBarang(int index, Barang barang, int jumlah) {
        this.daftarBarang.set(index, barang);
        this.jumlah.set(index, jumlah);
    }

    public void hapusBarang(Barang barang) {
        this.daftarBarang.remove(barang);
        this.jumlah.remove(this.daftarBarang.indexOf(barang));
    }

    public void setTotalHarga() {
        for (int i = 0; i < daftarBarang.size(); i++) {
            this.totalHarga = +daftarBarang.get(i).getHarga() * jumlah.get(i);
        }
    }

    public ArrayList<Barang> getDaftarBarang() {
        return daftarBarang;
    }

    public ArrayList<Integer> getJumlah() {
        return jumlah;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

}
