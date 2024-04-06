package fpsemester2;

import java.util.*;

public class Fpsemester2 {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Barang> barang = new ArrayList<>();
        ArrayList<Pelanggan> daftarPelanggan = new ArrayList<>();
        ArrayList<Transaksi> tr = new ArrayList<>();
        int jumlahPel = 0;
        MartabakTelor sosis = new MartabakTelor("Matabak telor sosis", 25000, 100);
        barang.add(sosis);
        MartabakManis keju = new MartabakManis("Martabak manis toping keju", 22000, 100);
        barang.add(keju);
        int pilih = 0;
        while (true) {
            System.out.println("====================================");
            System.out.println("|       QIUQIU SURABAYA             |");
            System.out.println("====================================");
            System.out.println("");
            System.out.println("1. Data Menu");
            System.out.println("2. Pembayaran");
            System.out.println("3. Data Transaksi");
            System.out.println("4. data penjualan");
            System.out.println("5. Exit");
            System.out.print("Pilih: ");
            pilih = s.nextInt();
            switch (pilih) {
                case 1:
                    Scanner m = new Scanner(System.in);
                    System.out.print("Input username: ");
                    String usename = m.nextLine();
                    System.out.println("Input password: ");
                    String pw = m.nextLine();
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
                    // menu pembayaran
                    System.out.println("Menu pembayaran");
                    int uang = 0;
                    Scanner pem = new Scanner(System.in);
                    System.out.println("data pelanggan");
                    System.out.println("Pembayaran");
                    System.out.print("Input email anda: ");
                    boolean ketemuE = false;
                    try {
                        String pelang = pem.nextLine();
                        for (int i = 0; i < daftarPelanggan.size(); i++) {
                            if (daftarPelanggan.get(i).getEmail().equals(pelang)) {
                                ketemuE = true;
                                System.out.println("Total harga");
                                for (int j = 0; j < daftarPelanggan.get(i).getTransaksi().getDaftarBarang()
                                        .size(); j++) {
                                    System.out.print((j + 1) + "."
                                            + daftarPelanggan.get(i).getTransaksi().getDaftarBarang().get(j).getNama());
                                    System.out.println(": " + daftarPelanggan.get(i).getTransaksi().getJumlah().get(j));
                                }
                                System.out.println("total: " + daftarPelanggan.get(i).getTransaksi().getTotalHarga());
                                System.out.println("Input uang anda: ");
                                uang = pem.nextInt();
                                if (uang >= daftarPelanggan.get(i).getTransaksi().getTotalHarga()) {
                                    Owner.setPendapatan(daftarPelanggan.get(i).getTransaksi().getTotalHarga());
                                    System.out.println("Pembayaran berhasil");
                                    System.out.print("Kembalian: ");
                                    System.out.println(uang - daftarPelanggan.get(i).getTransaksi().getTotalHarga());
                                } else {
                                    System.out.println("Pembayaran dibatalkan uang anda tidak cukup");
                                }
                                break;
                            }
                        }
                        if (ketemuE == false) {
                            System.out.println("Email tidak ditemukan untuk pembayaran");
                        }
                    } catch (Exception e) {
                        System.out.println("Pembeli belum ada");
                    }
                    break;
                case 3:
                    Scanner g = new Scanner(System.in);
                    System.out.print("Input nama anda: ");
                    String n = g.nextLine();
                    System.out.print("input email anda: ");
                    String email = g.nextLine();
                    daftarPelanggan.add(new Pelanggan(n, email));
                    tr.add(new Transaksi());
                    daftarPelanggan.get(jumlahPel).setTransaksi(tr.get(jumlahPel));
                    int pilihT = 0;
                    do {
                        System.out.println("1.Tambah\n2. ubah\n3. hapus\n4. selesai");
                        System.out.print("Input pilihan: ");
                        pilihT = s.nextInt();
                        switch (pilihT) {
                            case 1:
                                Scanner t = new Scanner(System.in);
                                System.out.println("Daftar menu");
                                for (int i = 0; i < barang.size(); i++) {
                                    System.out.println(
                                            (i + 1) + " " + barang.get(i).getNama() + "   " + barang.get(i).getHarga());
                                }
                                System.out.print("Input menu: ");
                                int pil = t.nextInt();
                                try {
                                    if (barang.get(pil - 1).getStok() > 0) {
                                        System.out.print("input jumlah: ");
                                        int jum = t.nextInt();
                                        tr.get(tr.size() - 1).tambahBarang(barang.get(pil - 1), jum);
                                        System.out.println("berhasil");
                                    } else if (pil >= barang.size()) {
                                        System.out.println("Barang yang anda pilih tidak tersedia");
                                    } else if (pil > barang.get(pil - 1).getStok()) {
                                        System.out.println("Stok tersisa: " + barang.get(pil - 1).getStok());
                                        System.out.println("Input sesuai stok tersedia");
                                    }
                                } catch (Exception e) {
                                    System.out.println("Input tidak valid");
                                }
                                break;
                            case 2:
                                Scanner u = new Scanner(System.in);
                                System.out.print("cari menu yang akan diubah");
                                String cariUbah = u.nextLine();
                                boolean k = false;
                                for (int i = 0; i < tr.get(tr.size() - 1).getDaftarBarang().size(); i++) {
                                    if (cariUbah.equalsIgnoreCase(
                                            tr.get(tr.size() - 1).getDaftarBarang().get(i).getNama())) {
                                        k = true;
                                        for (int j = 0; j < barang.size(); j++) {
                                            System.out.println((j + 1) + barang.get(j).toString());
                                        }
                                        System.out.print("Input menu baru: ");
                                        int pilU = u.nextInt();
                                        try {
                                            if (barang.get(pilU - 1).getStok() > 0) {
                                                System.out.println("Input jumlah: ");
                                                int jumU = u.nextInt();
                                                tr.get(tr.size() - 1).gantiBarang(
                                                        tr.get(tr.size() - 1).getDaftarBarang().indexOf(barang.get(i)),
                                                        barang.get(pilU), jumU);
                                                System.out.println("ganti barang berhasil");
                                            }
                                        } catch (Exception e) {
                                            System.out.println("input tidak valid");
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
                                        kh = true;
                                        break;
                                    }
                                }
                                if (kh == false) {
                                    System.out.println("Barang tidak ditemukan untuk dihapus");
                                }
                                break;
                            case 4:
                                System.out.println("pesanan selesai");
                                break;
                            default:
                                System.out.println("Input tidak valid");
                                break;
                        }
                    } while (pilihT != 4);
                    for (int i = 0; i < tr.get(tr.size() - 1).getDaftarBarang().size(); i++) {
                        tr.get(tr.size() - 1).getDaftarBarang().get(i)
                                .setStok(tr.get(tr.size() - 1).getDaftarBarang().get(i).getStok()
                                        - tr.get(tr.size() - 1).getJumlah().get(i));
                    }
                    tr.get(tr.size() - 1).setTotalHarga();
                    tr.get(tr.size() - 1).applyDiscount(10);
                    tr.get(tr.size() - 1).setPendapatanPerMenu();
                    System.out.println("Anda dapat diskon 10% dari total harga");
                    jumlahPel += 1;
                    System.out.println("Transaksi berhasil disimpan harap bayar di menu data pelanggan");
                    break;
                case 4:
                    System.out.println("1. laporan data pelanggan");
                    System.out.println("2. laporan data penjualan");
                    System.out.println("pilih: ");
                    int pilihan = s.nextInt();
                    // poin bonus nomer 3
                    try {
                        if (pilihan == 1) {
                            for (int i = 0; i < daftarPelanggan.size() - 1; i++) {
                                for (int j = 1; j < daftarPelanggan.size(); j++) {
                                    if (daftarPelanggan.get(i).getTransaksi().getTotalHarga() > daftarPelanggan.get(j)
                                            .getTransaksi().getTotalHarga()) {
                                        Pelanggan temp = daftarPelanggan.get(i);
                                        daftarPelanggan.set(i, daftarPelanggan.get(j));
                                        daftarPelanggan.set(j, temp);
                                    }
                                }
                            }

                            for (Pelanggan p : daftarPelanggan) {
                                System.out.println(p.getNama() + ": " + p.getTransaksi().getTotalHarga());
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Data pelanggan belum ada");
                    }
                    // poin bonus nomer 2
                    if (pilihan == 2) {
                        System.out.println("Laporan terkini");
                        System.out.println("Total pendapatan: " + Owner.getPendapatan());
                        for (int i = 0; i < barang.size() - 1; i++) {
                            for (int j = 1; j < barang.size(); j++) {
                                if (barang.get(i).getTotalPemasukan() > barang.get(j).getTotalPemasukan()) {
                                    Barang temp = barang.get(i);
                                    barang.set(i, barang.get(j));
                                    barang.set(j, temp);
                                }
                            }
                        }
                        for (Barang item : barang) {
                            System.out.println(item.lihatPendapatan());
                        }
                    } else
                        System.out.println("Input tidak valid");
                    break;
                case 5:
                    System.out.println("Laporan akhir");
                    System.out.println("Total pendapatan: " + Owner.getPendapatan());
                    for (int i = 0; i < barang.size() - 1; i++) {
                        for (int j = 1; j < barang.size(); j++) {
                            if (barang.get(i).getTotalPemasukan() > barang.get(j).getTotalPemasukan()) {
                                Barang temp = barang.get(i);
                                barang.set(i, barang.get(j));
                                barang.set(j, temp);
                            }
                        }
                    }
                    for (Barang item : barang) {
                        System.out.println(item.lihatPendapatan());
                    }
                    System.out.println("Keluar dari apk");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Input tidak valid");
                    break;
            }
        }

    }

}
