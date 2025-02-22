import java.util.ArrayList;

public class Petshop {
    private int id;
    private String name;
    private String category;
    private double price;
    private static ArrayList<Petshop> products = new ArrayList<>();

    public Petshop(int id, String name, String category, double price) {
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
        new Petshop(id, name, category, price);
        System.out.println("Produk berhasil ditambahkan!");
    }

    public static void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Tidak ada produk dalam daftar.");
            return;
        }
        System.out.println("\nDaftar Produk:");
        for (Petshop product : products) {
            System.out.println("ID: " + product.getId() + ", Nama: " + product.getName() +
                               ", Kategori: " + product.getCategory() + ", Harga: " + product.getPrice());
        }
    }

    public static void searchProduct(String name) {
        boolean found = false;
        for (Petshop product : products) {
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
        for (Petshop product : products) {
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
}
