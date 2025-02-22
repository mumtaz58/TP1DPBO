import java.util.ArrayList;
import java.util.Scanner;

class PetShop {
    private int id;
    private String name;
    private String category;
    private double price;
    private static ArrayList<PetShop> products = new ArrayList<>();

    public PetShop(int id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        products.add(this);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }

    public void setName(String newName) { this.name = newName; }
    public void setCategory(String newCategory) { this.category = newCategory; }
    public void setPrice(double newPrice) { this.price = newPrice; }

    public static void addProduct(int id, String name, String category, double price) {
        new PetShop(id, name, category, price);
        System.out.println("Produk berhasil ditambahkan!");
    }

    public static void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Tidak ada produk dalam daftar.");
            return;
        }
        System.out.println("\nDaftar Produk:");
        for (PetShop product : products) {
            System.out.println("ID: " + product.getId() + ", Nama: " + product.getName() +
                               ", Kategori: " + product.getCategory() + ", Harga: " + product.getPrice());
        }
    }

    public static void searchProduct(String name) {
        boolean found = false;
        for (PetShop product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                System.out.println("Ditemukan: ID: " + product.getId() + ", Nama: " + product.getName() +
                                   ", Kategori: " + product.getCategory() + ", Harga: " + product.getPrice());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Produk dengan nama " + name + " tidak ditemukan.");
        }
    }

    public static void updateProduct(int id, String newName, String newCategory, double newPrice) {
        for (PetShop product : products) {
            if (product.getId() == id) {
                product.setName(newName);
                product.setCategory(newCategory);
                product.setPrice(newPrice);
                System.out.println("Produk berhasil diperbarui.");
                return;
            }
        }
        System.out.println("Produk dengan ID " + id + " tidak ditemukan.");
    }

    public static void deleteProduct(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
                System.out.println("Produk berhasil dihapus.");
                return;
            }
        }
        System.out.println("Produk dengan ID " + id + " tidak ditemukan.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Produk");
            System.out.println("3. Cari Produk");
            System.out.println("4. Ubah Produk");
            System.out.println("5. Hapus Produk");
            System.out.println("6. Keluar");
            System.out.print("Pilihan: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Buang newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan ID Produk: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan Nama Produk: ");
                    String name = scanner.nextLine();
                    System.out.print("Masukkan Kategori: ");
                    String category = scanner.nextLine();
                    System.out.print("Masukkan Harga: ");
                    double price = scanner.nextDouble();
                    addProduct(id, name, category, price);
                    break;
                case 2:
                    displayProducts();
                    break;
                case 3:
                    System.out.print("Masukkan Nama produk yang dicari: ");
                    String searchName = scanner.nextLine();
                    searchProduct(searchName);
                    break;
                case 4:
                    System.out.print("Masukkan ID produk yang ingin diubah: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan Nama Baru: ");
                    String newName = scanner.nextLine();
                    System.out.print("Masukkan Kategori Baru: ");
                    String newCategory = scanner.nextLine();
                    System.out.print("Masukkan Harga Baru: ");
                    double newPrice = scanner.nextDouble();
                    updateProduct(updateId, newName, newCategory, newPrice);
                    break;
                case 5:
                    System.out.print("Masukkan ID produk yang ingin dihapus: ");
                    int deleteId = scanner.nextInt();
                    deleteProduct(deleteId);
                    break;
                case 6:
                    System.out.println("Keluar dari program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}
