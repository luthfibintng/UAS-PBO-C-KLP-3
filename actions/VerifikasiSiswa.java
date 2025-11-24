package actions;

import main.Aplikasi;
import model.Siswa;
import model.User;
import util.DataManager;

public class VerifikasiSiswa {
    public void eksekusi() {
        Aplikasi.cls();
        System.out.println("--- VERIFIKASI ---");
        boolean adaPending = false;
        
        // Tampilkan yang pending saja
        for (User u : Aplikasi.userList) {
            if (u instanceof Siswa s && s.getStatusPendaftaran().equals("PENDING")) {
                System.out.println("- " + s.getUsername() + " | NISN: " + s.getNisn());
                adaPending = true;
            }
        }

        if (!adaPending) {
            System.out.println("Tidak ada antrian.");
            Aplikasi.pressEnter();
            return;
        }

        System.out.print("Username siswa: ");
        String targetName = Aplikasi.scanner.nextLine();
        
        Siswa found = null;
        for (User u : Aplikasi.userList) {
            if (u instanceof Siswa s && s.getUsername().equals(targetName) && s.getStatusPendaftaran().equals("PENDING")) {
                found = s;
                break;
            }
        }

        if (found != null) {
            System.out.print("1. TERIMA | 2. TOLAK : ");
            String pil = Aplikasi.scanner.nextLine();
            if (pil.equals("1")) found.setStatusPendaftaran("DITERIMA");
            else if (pil.equals("2")) found.setStatusPendaftaran("DITOLAK");
            
            DataManager.saveToFile(Aplikasi.userList);
            System.out.println("Status diperbarui.");
        } else {
            System.out.println("Tidak ditemukan / Bukan status pending.");
        }
        Aplikasi.pressEnter();
    }
}
