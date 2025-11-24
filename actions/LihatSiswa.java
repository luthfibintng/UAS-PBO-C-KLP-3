package actions;

import main.Aplikasi;
import model.Siswa;
import model.User;

public class LihatSiswa {
    public void eksekusi() {
        Aplikasi.cls();
        System.out.println("--- DATA SISWA ---");
        int no = 1;
        for (User u : Aplikasi.userList) {
            if (u instanceof Siswa) {
                System.out.println(no + ". " + u.toString());
                no++;
            }
        }
        if (no == 1) System.out.println("Belum ada data.");
        // Kita tidak pakai pressEnter disini agar bisa dipakai oleh HapusSiswa tanpa pause
    }
}
