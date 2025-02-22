<?php
require_once "Petshop.php";

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    if (isset($_POST['add'])) {
        PetShop::addProduct($_POST['id'], $_POST['name'], $_POST['category'], $_POST['price'], $_FILES['photo']);
    } elseif (isset($_POST['delete'])) {
        PetShop::deleteProduct($_POST['delete_id']);
    } elseif (isset($_POST['update'])) {
        PetShop::updateProduct($_POST['id'], $_POST['name'], $_POST['category'], $_POST['price'], $_FILES['photo']);
    } elseif (isset($_POST['search'])) {
        $search_keyword = $_POST['search'];
    }
}

if (isset($_SESSION['notification'])) {
    echo "<p style='color: green;'>" . $_SESSION['notification'] . "</p>";
    unset($_SESSION['notification']);
}

echo "<h2>Menu:</h2>";
echo "<a href='?menu=1'>Tambah Produk</a> | ";
echo "<a href='?menu=2'>Tampilkan Produk</a> | ";
echo "<a href='?menu=3'>Hapus Produk</a> | ";
echo "<a href='?menu=4'>Ubah Produk</a> | ";
echo "<a href='?menu=5'>Cari Produk</a> | ";
echo "<a href='?menu=6' style='color: red;'>Keluar</a><br><hr>";

if (isset($_GET['menu'])) {
    switch ($_GET['menu']) {
        case 1:
            echo "<h3>Tambah Produk</h3>";
            echo "<form method='post' enctype='multipart/form-data'>";
            echo "ID: <input type='number' name='id' required><br>";
            echo "Nama: <input type='text' name='name' required><br>";
            echo "Kategori: <input type='text' name='category' required><br>";
            echo "Harga: <input type='number' step='0.01' name='price' required><br>";
            echo "Foto Produk: <input type='file' name='photo' accept='image/*' required><br>";
            echo "<input type='submit' name='add' value='Tambah Produk'>";
            echo "</form>";
            break;
        case 2:
            PetShop::displayProducts();
            break;
        case 3:
            echo "<h3>Hapus Produk</h3>";
            echo "<form method='post'>";
            echo "ID Produk: <input type='number' name='delete_id' required>";
            echo "<input type='submit' name='delete' value='Hapus'>";
            echo "</form>";
            break;
        case 4:
            case 4:
                echo "<h3>Ubah Produk</h3>";
                echo "<form method='post' enctype='multipart/form-data'>";
                echo "ID Produk: <input type='number' name='id' required><br>";
                echo "Nama Baru: <input type='text' name='name' required><br>";
                echo "Kategori Baru: <input type='text' name='category' required><br>";
                echo "Harga Baru: <input type='number' step='0.01' name='price' required><br>";
                echo "Foto Baru (Opsional): <input type='file' name='photo' accept='image/*'><br>";
                echo "<input type='submit' name='update' value='Ubah Produk'>";
                echo "</form>";
                break;            
        case 5:
            echo "<h3>Cari Produk</h3>";
            echo "<form method='post'>";
            echo "Kata kunci: <input type='text' name='search' required>";
            echo "<input type='submit' value='Cari'>";
            echo "</form>";
            if (isset($search_keyword)) {
                PetShop::searchProduct($search_keyword);
            }
            break;
        case 6:
            session_destroy();
            header("Location: index.php");
            exit();
    }
}

?>
