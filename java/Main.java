import java.util.Scanner;

public class Main {
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
            scanner.nextLine();

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
                    Petshop.addProduct(id, name, category, price);
                    break;
                case 2:
                    Petshop.displayProducts();
                    break;
                case 3:
                    System.out.print("Masukkan Nama produk yang dicari: ");
                    String searchName = scanner.nextLine();
                    Petshop.searchProduct(searchName);
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
                    Petshop.updateProduct(updateId, newName, newCategory, newPrice);
                    break;
                case 5:
                    System.out.print("Masukkan ID produk yang ingin dihapus: ");
                    int deleteId = scanner.nextInt();
                    Petshop.deleteProduct(deleteId);
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
