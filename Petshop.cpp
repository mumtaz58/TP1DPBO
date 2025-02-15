#include <iostream>
#include <string>

using namespace std;

class PetShop {
private:
    int id;
    string name;
    string category;
    double price;
    static PetShop* products[100];
    static int productCount;

    public:
    PetShop(int id, const string& name, const string& category, double price) {
        this->id = id;
        this->name = name;
        this->category = category;
        this->price = price;
        products[productCount++] = this;
    }

    int getId() const { return id; }
    string getName() const { return name; }
    string getCategory() const { return category; }
    double getPrice() const { return price; }

    void setName(const string& newName) { name = newName; }
    void setCategory(const string& newCategory) { category = newCategory; }
    void setPrice(double newPrice) { price = newPrice; }

    static void addProduct(int id, const string& name, const string& category, double price) {
        new PetShop(id, name, category, price);
        cout << "Produk berhasil ditambahkan!\n";
    }

    static void displayProducts() {
        if (productCount == 0) {
            cout << "Tidak ada produk dalam daftar.\n";
            return;
        }
        cout << "\nDaftar Produk:\n";
        for (int i = 0; i < productCount; i++) {
            cout << "ID: " << products[i]->getId()
                 << ", Nama: " << products[i]->getName()
                 << ", Kategori: " << products[i]->getCategory()
                 << ", Harga: " << products[i]->getPrice() << "\n";
        }
    }

    static void searchProduct(const string& name) {
        bool found = false;
        for (int i = 0; i < productCount; i++) {
            if (products[i]->getName() == name) {
                cout << "Ditemukan: ID: " << products[i]->getId()
                     << ", Nama: " << products[i]->getName()
                     << ", Kategori: " << products[i]->getCategory()
                     << ", Harga: " << products[i]->getPrice() << "\n";
                found = true;
            }
        }
        if (!found) {
            cout << "Produk dengan nama " << name << " tidak ditemukan.\n";
        }
    }

    static void updateProduct(int id, const string& newName, const string& newCategory, double newPrice) {
        for (int i = 0; i < productCount; i++) {
            if (products[i]->getId() == id) {
                products[i]->setName(newName);
                products[i]->setCategory(newCategory);
                products[i]->setPrice(newPrice);
                cout << "Produk berhasil diperbarui.\n";
                return;
            }
        }
        cout << "Produk dengan ID " << id << " tidak ditemukan.\n";
    }

    static void deleteProduct(int id) {
        for (int i = 0; i < productCount; i++) {
            if (products[i]->getId() == id) {
                delete products[i];
                for (int j = i; j < productCount - 1; j++) {
                    products[j] = products[j + 1];
                }
                productCount--;
                cout << "Produk berhasil dihapus.\n";
                return;
            }
        }
        cout << "Produk dengan ID " << id << " tidak ditemukan.\n";
    }
};

PetShop* PetShop::products[100];
int PetShop::productCount = 0;