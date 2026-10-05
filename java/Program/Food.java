// Mengimpor ArrayList untuk membuat list data tabel.
import java.util.ArrayList;
// Mengimpor List sebagai tipe data list.
import java.util.List;

// Membuat class Food yang mewarisi MenuItem.
public class Food extends MenuItem {
    // Menyimpan kategori makanan.
    private String category;

    // ====================================================
    // CONSTRUCTOR KOSONG
    // ====================================================

    // Constructor kosong Food.
    public Food() {
        // Memanggil constructor kosong MenuItem.
        super();
        // Mengosongkan kategori.
        category = "";
    }

    // ====================================================
    // CONSTRUCTOR BERPATAMETER
    // ====================================================

    // Constructor Food dengan parameter lengkap.
    public Food(String id, String name, double price, String category) {
        // Memanggil constructor MenuItem.
        super(id, name, price);
        // Mengisi kategori makanan.
        this.category = category;
    }

    // ====================================================
    // GETTER DAN SETTER CATEGORY
    // ====================================================

    // Getter kategori.
    public String getCategory() {
        // Mengembalikan kategori.
        return category;
    }
    // Setter kategori.
    public void setCategory(String category) {
        // Mengubah kategori.
        this.category = category;
    }

    // ====================================================
    // OVERRIDE DISPLAY INFO
    // ====================================================

    // Override method displayInfo dari MenuItem.
    @Override
    public void displayInfo() {
        // Menampilkan informasi khusus makanan.
        System.out.print(
            "[Makanan] " +
            "ID: " + id +
            " | Nama: " + name +
            " | Harga: Rp" + (int) price +
            " | Kategori: " + category
        );
    }

    // ====================================================
    // DATA UNTUK TABEL
    // ====================================================

    // Override method getTableRow dari MenuItem.
    @Override
    public List<String> getTableRow() {
        // Membuat list untuk satu baris data.
        List<String> row = new ArrayList<>();

        // Memasukkan ID.
        row.add(id);
        // Memasukkan nama menu.
        row.add(name);
        // Menentukan jenis menu.
        row.add("Makanan");
        // Menyimpan kategori pada kolom ukuran/kategori.
        row.add(category);
        // Makanan tidak mempunyai suhu.
        row.add("-");
        // Memasukkan harga.
        row.add("Rp" + (int) price);

        // Mengembalikan baris data.
        return row;
    }
}
