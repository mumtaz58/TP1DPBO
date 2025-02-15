#include "Petshop.cpp"

int main() {
    int choice, id;
    string name, category;
    double price;
    
    while (true) {
        cout << "\nMenu:\n";
        cout << "1. Tambah Produk\n";
        cout << "2. Tampilkan Produk\n";
        cout << "3. Cari Produk\n";
        cout << "4. Ubah Produk\n";
        cout << "5. Hapus Produk\n";
        cout << "6. Keluar\n";
        cout << "Pilihan: ";
        cin >> choice;

        if (cin.fail()) { // Validasi input angka
            cin.clear();
            while (cin.get() != '\n'); // Buang karakter yang tersisa di buffer
            cout << "Input tidak valid! Harap masukkan angka.\n";
            continue;
        }
        
        switch (choice) {
            case 1:
                cout << "Masukkan ID Produk: ";
                cin >> id;
                if (cin.fail()) { // Validasi ID harus berupa angka
                    cin.clear();
                    while (cin.get() != '\n');
                    cout << "Input ID tidak valid! Harap masukkan angka.\n";
                    continue;
                }
                cout << "Masukkan Nama Produk: ";
                cin.ignore();
                getline(cin, name);
                cout << "Masukkan Kategori: ";
                getline(cin, category);
                cout << "Masukkan Harga: ";
                cin >> price;
                if (cin.fail()) { // Validasi Harga harus berupa angka
                    cin.clear();
                    while (cin.get() != '\n');
                    cout << "Input harga tidak valid! Harap masukkan angka.\n";
                    continue;
                }
                PetShop::addProduct(id, name, category, price);
                break;
            case 2:
                PetShop::displayProducts();
                break;
            case 3:
                cout << "Masukkan Nama produk yang dicari: ";
                cin.ignore();
                getline(cin, name);
                PetShop::searchProduct(name);
                break;
            case 4:
                cout << "Masukkan ID produk yang ingin diubah: ";
                cin >> id;
                if (cin.fail()) {
                    cin.clear();
                    while (cin.get() != '\n');
                    cout << "Input ID tidak valid! Harap masukkan angka.\n";
                    continue;
                }
                cout << "Masukkan Nama Baru: ";
                cin.ignore();
                getline(cin, name);
                cout << "Masukkan Kategori Baru: ";
                getline(cin, category);
                cout << "Masukkan Harga Baru: ";
                cin >> price;
                if (cin.fail()) {
                    cin.clear();
                    while (cin.get() != '\n');
                    cout << "Input harga tidak valid! Harap masukkan angka.\n";
                    continue;
                }
                PetShop::updateProduct(id, name, category, price);
                break;
            case 5:
                cout << "Masukkan ID produk yang ingin dihapus: ";
                cin >> id;
                if (cin.fail()) {
                    cin.clear();
                    while (cin.get() != '\n');
                    cout << "Input ID tidak valid! Harap masukkan angka.\n";
                    continue;
                }
                PetShop::deleteProduct(id);
                break;
            case 6:
                cout << "Keluar dari program.\n";
                return 0;
            default:
                cout << "Pilihan tidak valid. Silakan coba lagi.\n";
        }
    }
}