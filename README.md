# Exercise Extra Class 1 – Web Automation with Katalon

Studi kasus:
- Website: https://katalon-demo-cura.herokuapp.com/
- Membuat test case **Appointment**
- Menggabungkan **Manual Mode** dan **Script Mode**
- Menggunakan **variabel** dan **kondisi if–else**

## Project Info

- Tool     : Katalon Studio 10.4.2
- Platform : Web UI (Chrome / Firefox)
- Site     : CURA Healthcare Service Demo

## Test Case

**Nama test case:** `TC01_Appointment_Success`

Flow singkat:
1. Open browser dan buka halaman utama CURA.
2. Klik **Make Appointment**.
3. Login dengan user demo (`John Doe` / `ThisIsNotAPassword`).
4. Mengisi form appointment:
   - Memilih facility (Tokyo / Hongkong / Seoul) berdasarkan **variabel** `facility` dengan `if–else`.
   - Mengatur **Apply for hospital readmission** berdasarkan variabel boolean `needReadmission` dengan `if–else`.
   - Memilih healthcare program (Medicaid / Medicare / None) berdasarkan variabel `program` dengan `if–else`.
   - Mengisi visit date dan comment.
5. Klik **Book Appointment**.
6. Melakukan **assertion** pada halaman *Appointment Confirmation*:
   - `Facility` tampil.
   - `Hospital Readmission` tampil.
   - Teks konfirmasi muncul:
     `Please be informed that your appointment has been booked as following:`

## Browser Requirement

### 🔹 Firefox

Untuk menjalankan test di **Firefox**, test case dapat dijalankan **tanpa konfigurasi tambahan** (langsung Run dari Katalon).

### 🔹 Chrome

Untuk **Chrome**, nonaktifkan password manager langsung di Chrome (`chrome://settings/passwords`).