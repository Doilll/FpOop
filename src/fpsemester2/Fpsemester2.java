package fpsemester2;

import java.util.*;

public class Fpsemester2 {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Barang> barang = new ArrayList<>();
        ArrayList<Pelanggan> daftarPelanggan = new ArrayList<>();
        ArrayList<Transaksi> tr = new ArrayList<>();
        int jumlahPel = 0;
        Barang ayam = new Barang("Ayam goreng", 5000, 20);
        barang.add(ayam);
        Barang nasi = new Barang("Nasi", 3000, 67);
        barang.add(nasi);
        Barang rendang = new Barang("Rendang", 10000, 25);
        barang.add(rendang);
        Barang esTeh = new Barang("Es Teh", 2000, 50);
        barang.add(esTeh);
        Barang ikan = new Barang("Mujaer", 7000, 20);
        barang.add(ikan);
        int pilih = 0;
        do {
            System.out.println("====================================");
            System.out.println("|       CAFE ANGOP SURABAYA      |");
            System.out.println("====================================");
            System.out.println("");
            System.out.println("1. Data Menu");
            System.out.println("2. Data Pelanggan");
            System.out.println("3. Data Transaksi");
            System.out.println("4. Exit");
            System.out.print("Pilih: ");
            pilih = s.nextInt();
            switch (pilih) {
                case 1:
                    System.out.print("Input username: "+"\n");
                    String usename = s.nextLine();
                    System.out.println("Input password: ");
                    String pw = s.nextLine();
                    if (pw.equalsIgnoreCase(Owner.getPassword())) {
                        System.out.println("Data Menu");
                        System.out.println(" 1. Tambah\n 2. Ubah\n 3. Hapus\n 4. Lihat");
                        System.out.print("Pilih: ");
                        int pilihan = s.nextInt();
                        switch (pilihan) {
                            case 1:
                                // membuat objek untuk disimpan langsung ke ArrayList
                                Scanner inp = new Scanner(System.in);
                                System.out.print("Nama Menu: ");
                                String n = inp.nextLine();
                                System.out.print("Harga:");
                                int h = inp.nextInt();
                                System.out.print("Stok: ");
                                int s = inp.nextInt();
                                barang.add(new Barang(n, h, s));
                                System.out.println("Barang berhasil dibbuat....");
                                break;
                            case 2:
                                // mengubah salah satu menu objek yang udah disimpan
                                Scanner input = new Scanner(System.in);
                                System.out.print("Input nama menu yang akan diubah: ");
                                String name = input.nextLine();
                                boolean ketemu = false;
                                int idx = 0;
                                for (int i = 0; i < barang.size(); i++) {
                                    if (barang.get(i).getNama().equalsIgnoreCase(name)) {
                                        ketemu = true;
                                        idx = i;
                                        break;
                                    }
                                }
                                if (ketemu) {
                                    System.out.print("Input nama baru: ");
                                    String newName = input.nextLine();
                                    System.out.println("anda yakin ingin ubah");
                                    System.out.print("1. ya/2. tidak: ");
                                    int yakin = input.nextInt();
                                    if (yakin == 1) {
                                        barang.get(idx).setNama(newName);
                                        System.out.println("Nama berhasil diubah");
                                        System.out.println("Input harga dan stok baru");
                                        System.out.print("harga: ");
                                        int newHarga = input.nextInt();
                                        barang.get(idx).setHarga(newHarga);
                                        System.out.print("stok: ");
                                        int newStok = input.nextInt();
                                        barang.get(idx).setStok(newStok);
                                        System.out.println("Harga dan stok berhasil diubah");
                                    } else {
                                        System.out.println("perubahan dibatalkan");
                                    }
                                } else {
                                    System.out.println("menu tidak ditemukan untuk diubah");

                                }
                                break;
                            case 3:
                                // menghapus salah satu objek yang disimpan di arraylist
                                Scanner c = new Scanner(System.in);
                                System.out.print("input nama menu yang akan dihapus: ");
                                String newNama = c.nextLine();
                                boolean ketemuHapus = false;
                                for (int i = 0; i < barang.size(); i++) {
                                    if (barang.get(i).getNama().equalsIgnoreCase(newNama)) {
                                        ketemuHapus = true;
                                        System.out.println("Apakah anda yakin ingin menghapus barang");
                                        System.out.print("1. ya/2. tidak: ");
                                        int yakin = c.nextInt();
                                        if (yakin == 1) {
                                            barang.remove(i);
                                        } else {
                                            System.out.println("hapus barang dibatalkan");
                                        }
                                        break;
                                    }
                                }
                                if (ketemuHapus) {
                                    System.out.println("Barang berhasil dihapus");
                                } else {
                                    System.out.println("Barang tidak ditemukan untuk dihapus");
                                }
                                break;
                            case 4:
                                // menampilkan daftar menu
                                System.out.println("DAFTER MENU");
                                for (int i = 0; i < barang.size(); i++) {
                                    System.out.println(i + 1 + ". " + barang.get(i).toString());
                                }
                                break;
                            default:
                                System.out.println("Input tidak valid");
                                break;
                        }
                    } else
                        System.out.println("password atau username salah");
                    break;
                case 2:
                    System.out.println("data pelanggan");
                    break;
                case 3:
                    System.out.print("Input nama anda: "+"\n");
                    String n = s.nextLine();
                    System.out.print("input email anda");
                    String email = s.nextLine();
                    daftarPelanggan.add(new Pelanggan(n, email));
                    tr.add(new Transaksi());
                    daftarPelanggan.get(jumlahPel).setTransaksi(tr.get(jumlahPel));
                    int jumPesan = 0;
                    do {
                        System.out.println("1. Tambah\n2. ubah\n3. hapus\n4. selesai");
                        System.out.print("Pilih: ");
                        pilih = s.nextInt();
                        switch (pilih) {
                            case 1:
                                System.out.println("Daftar menu");
                                for (int i = 0; i < barang.size(); i++) {
                                    System.out.println(
                                            (i + 1) + " " + barang.get(i).getNama() + "   " + barang.get(i).getHarga());
                                }
                                System.out.print("Input menu: ");
                                int pil = s.nextInt();
                                if (barang.get(pil - 1).getStok() > 0) {
                                    System.out.print("input jumlah: ");
                                    int jum = s.nextInt();
                                    tr.get(tr.size() - 1).tambahBarang(barang.get(pil - 1), jum);
                                    System.out.println("berhasil");
                                } else if (pil >= barang.size()) {
                                    System.out.println("Barang yang anda pilih tidak tersedia");
                                } else if (pil > barang.get(pil - 1).getStok()) {
                                    System.out.println("Stok tersisa: " + barang.get(pil - 1).getStok());
                                    System.out.println("Input sesuai stok tersedia");
                                } else {
                                    System.out.println("menu yang anda pilih tidak tersedia");
                                }
                                break;
                            case 2:
                                System.out.print("cari menu yang akan diubah");
                                String cariUbah = s.nextLine();
                                boolean k = false;
                                for (int i = 0; i < tr.get(tr.size() - 1).getDaftarBarang().size(); i++) {
                                    if (cariUbah.equalsIgnoreCase(
                                            tr.get(tr.size() - 1).getDaftarBarang().get(i).getNama())) {
                                        k = true;
                                        for (int j = 0; j < barang.size(); j++) {
                                            System.out.println((j + 1) + barang.get(j).toString());
                                        }
                                        System.out.print("Input menu baru: ");
                                        int pilU = s.nextInt();
                                        if (barang.get(pilU - 1).getStok() > 0) {
                                            System.out.println("Input jumlah: ");
                                            int jumU = s.nextInt();
                                            tr.get(tr.size() - 1).gantiBarang(
                                                    tr.get(tr.size() - 1).getDaftarBarang().indexOf(barang.get(i)),
                                                    barang.get(pilU), jumU);
                                            System.out.println("ganti barang berhasil");
                                        }
                                        break;
                                    }
                                }
                                if (k == false) {
                                    System.out.println("barang tidak ditemukan untuk diganti");
                                }

                                break;
                            case 3:
                                System.out.println("Cari menu yang akan dihapus");
                                String cariHapus = s.nextLine();
                                boolean kh = false;
                                for (int i = 0; i < tr.get(tr.size() - 1).getDaftarBarang().size(); i++) {
                                    if (cariHapus.equalsIgnoreCase(
                                            tr.get(tr.size() - 1).getDaftarBarang().get(i).getNama())) {
                                        tr.get(tr.size() - 1)
                                                .hapusBarang(tr.get(tr.size() - 1).getDaftarBarang().get(i));
                                        System.out.println("Hapus barang selesai...");
                                        break;
                                    }
                                }
                                break;
                            default:
                                break;
                        }
                    } while (pilih != 4);
                    jumlahPel += 1;
                case 4:

                    break;
                default:

                    break;
            }
        } while (pilih != 4);

    }

}
