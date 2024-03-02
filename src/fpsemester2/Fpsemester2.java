package fpsemester2;

import java.util.*;

public class Fpsemester2 {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        // membuat array list untuk menyimpan objek dari class barang
        ArrayList<Barang> barang = new ArrayList<>();
        // membuat objek dan menyimpan objek di ArrayList
        Barang ayam = new Barang("Ayam goreng", 5000, 20);
        barang.add(ayam);
        Barang nasi = new Barang("nasi", 3000, 67);
        barang.add(nasi);
        Barang rendang = new Barang("Rendang", 10000, 25);
        barang.add(rendang);
        Barang esTeh = new Barang("es teh", 2000, 50);
        barang.add(esTeh);
        Barang ikan = new Barang("Mujaer", 7000, 20);
        barang.add(ikan);
        int pilih = 0;
        do {
            System.out.println("====================================");
            System.out.println("|       CAFE ANGOP SURABAYA      |");
            System.out.println("====================================");
            System.out.println("");
            System.out.println("1. data makanan");
            System.out.println("2. data pelanggan");
            System.out.println("3. data transaksi");
            System.out.println("4. exit");
            System.out.print("input pilihan: ");
            pilih = s.nextInt();
            switch (pilih) {
                case 1:
                    Scanner sc = new Scanner(System.in);
                    System.out.println("data barang");
                    System.out.println("1. tambah\n2. ubah\n3. hapus\n4. lihat");
                    System.out.print("Input pilihan: ");
                    int pilihan = sc.nextInt();
                    switch (pilihan) {
                        case 1:
                            // membuat objek untuk disimpan langsung ke ArrayList
                            Scanner inp = new Scanner(System.in);
                            System.out.print("Nama barang: ");
                            String n = inp.nextLine();
                            System.out.print("harga:");
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
                                }
                            } else {
                                System.out.println("Perubahan dibatalkan");
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
                                System.out.println(i + ". " + barang.get(i).toString());
                            }
                            break;
                        default:
                            System.out.println("Input tidak valid");
                            break;
                    }
                    break;
                case 2:

                    break;

                default:

                    break;
            }
        } while (pilih != 4);

    }

}
