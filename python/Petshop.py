class PetShop:
    products = []

    def __init__(self, id, name, category, price):
        self.id = id
        self.name = name
        self.category = category
        self.price = price
        PetShop.products.append(self)

    @staticmethod
    def add_product(id, name, category, price):
        PetShop(id, name, category, price)
        print("Produk berhasil ditambahkan!")

    @staticmethod
    def display_products():
        if not PetShop.products:
            print("Tidak ada produk dalam daftar.")
            return
        print("\nDaftar Produk:")
        for product in PetShop.products:
            print(f"ID: {product.id}, Nama: {product.name}, Kategori: {product.category}, Harga: {product.price}")

    @staticmethod
    def search_product(name):
        found = False
        for product in PetShop.products:
            if product.name.lower() == name.lower():
                print(f"Ditemukan: ID: {product.id}, Nama: {product.name}, Kategori: {product.category}, Harga: {product.price}")
                found = True
        if not found:
            print(f"Produk dengan nama {name} tidak ditemukan.")

    @staticmethod
    def update_product(id, new_name, new_category, new_price):
        for product in PetShop.products:
            if product.id == id:
                product.name = new_name
                product.category = new_category
                product.price = new_price
                print("Produk berhasil diperbarui.")
                return
        print(f"Produk dengan ID {id} tidak ditemukan.")

    @staticmethod
    def delete_product(id):
        for product in PetShop.products:
            if product.id == id:
                PetShop.products.remove(product)
                print("Produk berhasil dihapus.")
                return
        print(f"Produk dengan ID {id} tidak ditemukan.")


def main():
    while True:
        print("\nMenu:")
        print("1. Tambah Produk")
        print("2. Tampilkan Produk")
        print("3. Cari Produk")
        print("4. Ubah Produk")
        print("5. Hapus Produk")
        print("6. Keluar")
        choice = input("Pilihan: ")

        if choice == '1':
            id = int(input("Masukkan ID Produk: "))
            name = input("Masukkan Nama Produk: ")
            category = input("Masukkan Kategori: ")
            price = float(input("Masukkan Harga: "))
            PetShop.add_product(id, name, category, price)
        elif choice == '2':
            PetShop.display_products()
        elif choice == '3':
            name = input("Masukkan Nama produk yang dicari: ")
            PetShop.search_product(name)
        elif choice == '4':
            id = int(input("Masukkan ID produk yang ingin diubah: "))
            new_name = input("Masukkan Nama Baru: ")
            new_category = input("Masukkan Kategori Baru: ")
            new_price = float(input("Masukkan Harga Baru: "))
            PetShop.update_product(id, new_name, new_category, new_price)
        elif choice == '5':
            id = int(input("Masukkan ID produk yang ingin dihapus: "))
            PetShop.delete_product(id)
        elif choice == '6':
            print("Keluar dari program.")
            break
        else:
            print("Pilihan tidak valid. Silakan coba lagi.")


if __name__ == "__main__":
    main()
