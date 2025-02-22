**Janji**

Saya Armelia Zahrah Mumtaz dengan NIM 2300801 berjanji mengerjakan TP1 DPBO dengan keberkahan-Nya, maka saya tidak akan melakukan kecurangan sesuai yang telah di spesifikasikan, Aamiin

**Dokumentasi cpp**
![WhatsApp Image 2025-02-15 at 21 13 45_83957230](https://github.com/user-attachments/assets/189a925f-c9ce-49f6-a17a-e290b0878b2c)
![WhatsApp Image 2025-02-15 at 21 16 32_e5a76919](https://github.com/user-attachments/assets/05974656-2691-41fb-9e7b-72797e3b447e)

**Alur Program**

Program PetShop ini dibuat untuk mengelola data produk yang dijual. Di awal, program menampilkan menu utama yang berisi opsi seperti Tambah Produk, Tampilkan Produk, Cari Produk, Ubah Produk, Hapus Produk, dan Keluar. User bisa memilih salah satu menu sesuai kebutuhan.

Saat menambah produk, user diminta memasukkan ID, Nama, Kategori, dan Harga produk. Ada validasi supaya ID dan Harga hanya menerima input berupa angka. Kalau semua data valid, produk akan disimpan ke dalam array dan program menampilkan konfirmasi bahwa produk berhasil ditambahkan.

Kalau mau lihat semua produk, user bisa memilih menu Tampilkan Produk. Kalau ada produk, program akan menampilkan daftar lengkap berisi ID, Nama, Kategori, dan Harga. Kalau belum ada produk, program akan memberi tahu bahwa daftar masih kosong.

Untuk mencari produk, user cukup memasukkan nama produk yang dicari. Kalau ketemu, detail produk akan ditampilkan. Kalau nggak, program kasih tahu kalau produk tersebut nggak ditemukan.

Kalau mau mengubah data produk, user harus memasukkan ID produk yang mau diubah. Kalau ID ditemukan, program minta data baru seperti Nama, Kategori, dan Harga. Setelah data diperbarui, program kasih konfirmasi. Kalau ID nggak ditemukan, program akan memberi tahu.

Untuk menghapus produk, user juga cukup memasukkan ID produk yang mau dihapus. Kalau ID ditemukan, produk dihapus dari daftar dan program kasih konfirmasi. Kalau ID nggak ada, program kasih tahu kalau produk tersebut nggak ditemukan.

Program ini berakhir kalau user memilih opsi Keluar.

**Design**

 desain : displayProducts(), searchProduct(), updateProduct(), deleteProduct()

 atribut : id, name, category, price, products[], productCount

 metode : Konstruktor, Getter, Setter, addProduct(), Pastikan ID & harga angka

struktur : Menu pakai switch-case, navigasi mudah dan terstruktur.
