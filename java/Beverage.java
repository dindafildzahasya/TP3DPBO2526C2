// Mengimpor ArrayList untuk membuat list data tabel.
import java.util.ArrayList;
// Mengimpor List sebagai tipe data list.
import java.util.List;

// Membuat class Beverage yang mewarisi MenuItem.
public class Beverage extends MenuItem {
    // Menyimpan ukuran minuman.
    private String size;
    // Menyimpan suhu penyajian minuman.
    private String temperature;

    // ====================================================
    // CONSTRUCTOR KOSONG
    // ====================================================

    // Constructor kosong Beverage.
    public Beverage() {
        // Memanggil constructor kosong MenuItem.
        super();
        // Mengosongkan ukuran.
        size = "";
        // Mengosongkan suhu.
        temperature = "";
    }

    // ====================================================
    // CONSTRUCTOR BERPATAMETER
    // ====================================================

    // Constructor Beverage dengan parameter lengkap.
    public Beverage(String id, String name, double price, String size, String temperature) {
        // Memanggil constructor MenuItem.
        super(id, name, price);
        // Mengisi ukuran minuman.
        this.size = size;
        // Mengisi suhu minuman.
        this.temperature = temperature;
    }

    // ====================================================
    // GETTER DAN SETTER SIZE
    // ====================================================

    // Getter ukuran.
    public String getSize() {
        // Mengembalikan ukuran.
        return size;
    }
    // Setter ukuran.
    public void setSize(String size) {
        // Mengubah ukuran.
        this.size = size;
    }

    // ====================================================
    // GETTER DAN SETTER TEMPERATURE
    // ====================================================

    // Getter suhu.
    public String getTemperature() {
        // Mengembalikan suhu.
        return temperature;
    }
    // Setter suhu.
    public void setTemperature(String temperature) {
        // Mengubah suhu.
        this.temperature = temperature;
    }

    // ====================================================
    // OVERRIDE DISPLAY INFO
    // ====================================================

    // Override method displayInfo dari MenuItem.
    @Override
    public void displayInfo() {
        // Menampilkan informasi khusus minuman.
        System.out.print(
            "[Minuman] " +
            "ID: " + id +
            " | Nama: " + name +
            " | Harga: Rp" + (int) price +
            " | Ukuran: " + size +
            " | Suhu: " + temperature
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
        row.add("Minuman");
        // Memasukkan ukuran.
        row.add(size);
        // Memasukkan suhu.
        row.add(temperature);
        // Memasukkan harga.
        row.add("Rp" + (int) price);

        // Mengembalikan data.
        return row;
    }
}