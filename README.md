# TUGAS PROJEK PBO

Member
1. Lutfi Bintang Adrianto
2. Ar-Raudhatul Putri Muhida
3. Najiya Irawan
4. Muhammad Faruq Rais
5. Muhammad Alfi
6. Muhammad Sultan Shadiq

Study case
Aplikasi Pengelolaan Data Siswa

---

## Deskripsi Proyek

Proyek ini adalah **Aplikasi Pengelolaan Data Siswa** berbasis konsol yang dikembangkan menggunakan konsep **Pemrograman Berorientasi Objek (PBO)** dalam bahasa Java. Aplikasi ini dirancang untuk memfasilitasi proses pendaftaran dan manajemen data siswa baru dengan memisahkan peran akses antara **Admin** dan **Siswa**.

Data pengguna (Admin dan Siswa) disimpan secara persisten dalam file terpisah (`admin.txt` dan `siswa.txt`) dan dimuat ke dalam memori (`Aplikasi.userList`) saat aplikasi dimulai.

## Struktur Kode (PBO)

Aplikasi ini mengadopsi struktur modular dengan pembagian tanggung jawab berdasarkan *package* sebagai berikut:

| Package | Deskripsi Tanggung Jawab | Kelas Penting |
| :--- | :--- | :--- |
| **`Main`** | Titik masuk aplikasi, inisialisasi, dan variabel global. | `Aplikasi.java` |
| **`model`** | Kelas-kelas objek data (konsep *Inheritance*). | `User.java` (Abstract Class), `Admin.java`, `Siswa.java` |
| **`menu`** | Kelas yang mengatur navigasi dan tampilan menu antarmuka. | `MenuUtama`, `MenuAdmin`, `MenuSiswa` |
| **`actions`** | Kelas-kelas yang berisi logika bisnis dan manipulasi data. | `LoginSystem`, `RegisterSiswa`, `VerifikasiSiswa`, dll. |
| **`util`** | Kelas utilitas untuk manajemen data (I/O File). | `DataManager.java` |

### Detail Model Kelas

* **`User`**: Kelas abstrak yang menyediakan properti dasar (`username`, `password`) dan metode abstrak (`displayRole()`, `toFileString()`).
* **`Admin`**: Turunan dari `User`. Digunakan untuk autentikasi dan akses ke fitur manajemen.
* **`Siswa`**: Turunan dari `User`. Memiliki properti tambahan seperti `namaLengkap`, `nisn`, `tanggalLahir`, dan `statusPendaftaran` (bisa **PENDING**, **DITERIMA**, atau **DITOLAK**).

## ⚙️ Fitur Utama Aplikasi

### 1. Akses Siswa (`MenuSiswa`)

Fitur bagi calon siswa atau siswa yang sudah terdaftar:
* **Daftar Baru (`RegisterSiswa`)**: Siswa dapat membuat akun, dan secara otomatis status pendaftaran akan menjadi **PENDING**.
* **Login**: Siswa dapat masuk untuk melihat status pendaftaran saat ini (PENDING/DITERIMA/DITOLAK).

### 2. Dashboard Admin (`MenuAdmin`)

Admin memiliki hak akses penuh untuk mengelola data siswa:
* **Tambah Siswa Manual (`TambahSiswa`)**: Menambahkan data siswa baru secara langsung dengan status **DITERIMA**.
* **Hapus Siswa (`HapusSiswa`)**: Menghapus data siswa berdasarkan *username*.
* **Edit Data Siswa (`EditSiswa`)**: Mengubah detail siswa seperti Nama Lengkap, NISN, Tanggal Lahir, atau Password.
* **Lihat Data Siswa (`LihatSiswa`)**: Menampilkan seluruh data siswa yang terdaftar.
* **Verifikasi Pendaftaran (`VerifikasiSiswa`)**: Memproses pendaftaran siswa yang berstatus **PENDING** menjadi **DITERIMA** atau **DITOLAK**.

### 3. Persistensi Data

* Data Admin dan Siswa disimpan ke file terpisah (`admin.txt` dan `siswa.txt`) menggunakan kelas `DataManager`.
* Jika file `admin.txt` belum ada, sistem akan otomatis membuat akun **Admin *default***: `Username: admin`, `Password: admin123`.
