<?php
session_start();

if (!isset($_SESSION['products'])) {
    $_SESSION['products'] = [];
}

class PetShop {
    public static function addProduct($id, $name, $category, $price, $photo) {
        if (count($_SESSION['products']) >= 5) {
            $_SESSION['notification'] = "Maksimal 5 produk dapat ditambahkan!";
            return;
        }

        // Simpan foto
        $target_dir = "uploads/";
        $target_file = $target_dir . basename($photo['name']);
        if (move_uploaded_file($photo['tmp_name'], $target_file)) {
            $_SESSION['products'][] = [
                'id' => $id,
                'name' => $name,
                'category' => $category,
                'price' => number_format($price, 2, ',', '.'),
                'photo' => $photo['name']
            ];
            $_SESSION['notification'] = "Produk berhasil ditambahkan!";
        } else {
            $_SESSION['notification'] = "Gagal mengupload gambar!";
        }
    }

    public static function displayProducts() {
        echo "<h3>Daftar Produk:</h3>";
        if (empty($_SESSION['products'])) {
            echo "<p style='color: red;'>Tidak ada produk dalam daftar.</p>";
            return;
        }
        echo "<table border='1' style='width:100%; text-align:left; border-collapse: collapse;'>";
        echo "<tr style='background-color: blue; color: white;'>
                <th>ID</th><th>Nama</th><th>Kategori</th><th>Harga</th><th>Foto</th>
              </tr>";
        foreach ($_SESSION['products'] as $product) {
            echo "<tr>";
            echo "<td>{$product['id']}</td>";
            echo "<td>{$product['name']}</td>";
            echo "<td>{$product['category']}</td>";
            echo "<td>Rp {$product['price']}</td>";
            echo "<td><img src='uploads/{$product['photo']}' width='100'></td>";
            echo "</tr>";
        }
        echo "</table>";
    }

    public static function deleteProduct($id) {
        foreach ($_SESSION['products'] as $key => $product) {
            if ($product['id'] == $id) {
                unset($_SESSION['products'][$key]);
                $_SESSION['products'] = array_values($_SESSION['products']);
                $_SESSION['notification'] = "Produk berhasil dihapus.";
                return;
            }
        }
        $_SESSION['notification'] = "Produk dengan ID $id tidak ditemukan.";
    }

    public static function updateProduct($id, $name, $category, $price, $photo) {
        foreach ($_SESSION['products'] as &$product) {
            if ($product['id'] == $id) {
                $product['name'] = $name;
                $product['category'] = $category;
                $product['price'] = number_format($price, 2, ',', '.');
                
                if ($photo['name'] != "") { 
                    $target_dir = "uploads/";
                    $target_file = $target_dir . basename($photo['name']);
                    if (move_uploaded_file($photo['tmp_name'], $target_file)) {
                        $product['photo'] = $photo['name'];
                    }
                }
                
                $_SESSION['notification'] = "Produk berhasil diubah!";
                return;
            }
        }
        $_SESSION['notification'] = "Produk dengan ID $id tidak ditemukan.";
    }

    public static function searchProduct($keyword) {
        echo "<h3>Hasil Pencarian untuk: '$keyword'</h3>";
        $found = false;
        echo "<table border='1' style='width:100%; text-align:left; border-collapse: collapse;'>";
        echo "<tr style='background-color: blue; color: white;'><th>ID</th><th>Nama</th><th>Kategori</th><th>Harga</th><th>Foto</th></tr>";
        foreach ($_SESSION['products'] as $product) {
            if (stripos($product['name'], $keyword) !== false || stripos($product['category'], $keyword) !== false) {
                $found = true;
                echo "<tr>";
                echo "<td>{$product['id']}</td>";
                echo "<td>{$product['name']}</td>";
                echo "<td>{$product['category']}</td>";
                echo "<td>Rp {$product['price']}</td>";
                echo "<td><img src='uploads/{$product['photo']}' width='100'></td>";
                echo "</tr>";
            }
        }
        echo "</table>";
        if (!$found) echo "<p style='color: red;'>Produk tidak ditemukan.</p>";
    }
}
?>
