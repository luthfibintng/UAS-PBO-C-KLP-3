package actions;

import main.Aplikasi;
import model.Siswa;
import model.User;
import util.DataManager;

public class EditSiswa {
    public void eksekusi() {
        // Tampilkan daftar dulu biar gampang milih
        new LihatSiswa().eksekusi(); 
        
        System.out.println("\n--- EDIT DATA SISWA ---");
        System.out.print("Masukkan Username siswa yang akan diedit: ");
        String targetUser = Aplikasi.scanner.nextLine();
        
        Siswa found = null;
        for (User u : Aplikasi.userList) {
            if (u instanceof Siswa && u.getUsername().equals(targetUser)) {
                found = (Siswa) u;
                break;
            }
        }

        if (found != null) {
            boolean editing = true;
            while (editing) {
                Aplikasi.cls();
                System.out.println("Data saat ini: " + found.toString());
                System.out.println("--------------------------------");
                System.out.println("Apa yang ingin diubah?");
                System.out.println("1. Nama Lengkap");
                System.out.println("2. NISN");
                System.out.println("3. Tanggal Lahir");
                System.out.println("4. Password"); 
                System.out.println("0. Selesai & Simpan");
                System.out.print("Pilih > ");

                String editChoice = Aplikasi.scanner.nextLine();
                switch (editChoice) {
                    case "1" -> {
                        System.out.print("Nama Baru: ");
                        found.setNamaLengkap(Aplikasi.scanner.nextLine());
                        System.out.println("Nama diubah.");
                    }
                    case "2" -> {
                        String newNisn = "";
                        while (true) {
                            System.out.print("NISN Baru (8 Karakter): ");
                            newNisn = Aplikasi.scanner.nextLine();
                            if (newNisn.length() == 8) break;
                            System.out.println("NISN harus 8 karakter.");
                        }
                        found.setNisn(newNisn);
                        System.out.println("NISN diubah.");
                    }
                    case "3" -> {
                        System.out.print("Tanggal Lahir Baru (DD-MM-YYYY): ");
                        found.setTanggalLahir(Aplikasi.scanner.nextLine());
                        System.out.println("Tanggal lahir diubah.");
                    }
                    case "4" -> {
                        System.out.print("Password Baru: ");
                        found.setPassword(Aplikasi.scanner.nextLine()); 
                        System.out.println("Password diubah.");
                    }
                    case "0" -> editing = false;
                    default -> System.out.println("Pilihan salah.");
                }
                if (!editChoice.equals("0")) Aplikasi.pressEnter();
            }
            
            // Simpan perubahan ke file setelah selesai edit
            DataManager.saveToFile(Aplikasi.userList);
            System.out.println("Data berhasil disimpan!");
            
        } else {
            System.out.println("Siswa tidak ditemukan.");
        }
        Aplikasi.pressEnter();
    }
}
      
