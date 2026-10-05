// Mengimpor ArrayList untuk membuat data dalam bentuk list.
import java.util.ArrayList;
// Mengimpor List sebagai tipe data list.
import java.util.List;

// Membuat class MenuItem sebagai class induk.
public class MenuItem {
    // Menyimpan ID menu.
    protected String id;
    // Menyimpan nama menu.
    protected String name;
    // Menyimpan harga menu.
    protected double price;

    // ====================================================
    // CONSTRUCTOR KOSONG
    // ====================================================

    // Constructor kosong untuk membuat object dengan nilai awal.
    public MenuItem() {
        // Mengosongkan ID.
        id = "";
        // Mengosongkan nama.
        name = "";
        // Mengatur harga awal menjadi nol.
        price = 0.0;
    }

    // ====================================================
    // CONSTRUCTOR BERPATAMETER
    // ====================================================

    // Constructor untuk mengisi data MenuItem saat object dibuat.
    public MenuItem(String id, String name, double price) {
        // Mengisi atribut ID.
        this.id = id;
        // Mengisi atribut nama.
        this.name = name;
        // Mengisi atribut harga.
        this.price = price;
    }

    // ====================================================
    // GETTER DAN SETTER ID
    // ====================================================

    // Getter untuk mendapatkan ID menu.
    public String getId() {
        // Mengembalikan ID menu.
        return id;
    }
    // Setter untuk mengubah ID menu.
    public void setId(String id) {
        // Mengubah nilai ID.
        this.id = id;
    }

    // ====================================================
    // GETTER DAN SETTER NAME
    // ====================================================

    // Getter untuk mendapatkan nama menu.
    public String getName() {
        // Mengembalikan nama menu.
        return name;
    }
    // Setter untuk mengubah nama menu.
    public void setName(String name) {
        // Mengubah nama menu.
        this.name = name;
    }

    // ====================================================
    // GETTER DAN SETTER PRICE
    // ====================================================

    // Getter untuk mendapatkan harga.
    public double getPrice() {
        // Mengembalikan harga.
        return price;
    }
    // Setter untuk mengubah harga.
    public void setPrice(double price) {
        // Mengubah harga.
        this.price = price;
    }

    // ====================================================
    // DISPLAY INFO
    // ====================================================

    // Method untuk menampilkan informasi dasar menu.
    public void displayInfo() {
        // Menampilkan ID, nama, dan harga.
        System.out.print(
            "ID: " + id +
            " | Nama: " + name +
            " | Harga: Rp" + (int) price
        );
    }

    // ====================================================
    // DATA UNTUK TABEL
    // ====================================================

    // Method untuk menghasilkan satu baris data tabel.
    public List<String> getTableRow() {
        // Membuat list baru untuk menyimpan satu baris data.
        List<String> row = new ArrayList<>();

        // Memasukkan ID ke dalam baris.
        row.add(id);
        // Memasukkan nama menu.
        row.add(name);
        // Menunjukkan jenis object.
        row.add("Menu Item");
        // Tidak ada informasi ukuran/kategori.
        row.add("-");
        // Tidak ada informasi suhu.
        row.add("-");
        // Memasukkan harga.
        row.add("Rp" + (int) price);

        // Mengembalikan baris data.
        return row;
    }
}