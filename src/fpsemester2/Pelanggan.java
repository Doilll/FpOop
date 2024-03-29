package fpsemester2;

public class Pelanggan {

    private String nama;
    private String email;
    private Transaksi transaksi;

    public Pelanggan(String nama, String email) {
        this.nama = nama;
        this.email = email;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public void setTransaksi(Transaksi transaksi) {
        this.transaksi = transaksi;
    }

    public Transaksi getTransaksi() {
        return transaksi;
    }

}
