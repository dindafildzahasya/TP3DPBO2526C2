// Mengimpor ArrayList untuk membuat list data tabel.
import java.util.ArrayList;
// Mengimpor List sebagai tipe data list.
import java.util.List;

// Membuat class Customer.
public class Customer {
    // Menyimpan ID customer.
    private String customerId;
    // Menyimpan nama customer.
    private String name;
    // Menyimpan nomor telepon customer.
    private String phone;

    // ====================================================
    // CONSTRUCTOR KOSONG
    // ====================================================

    // Constructor kosong Customer.
    public Customer() {
        // Mengosongkan ID customer.
        customerId = "";
        // Mengosongkan nama.
        name = "";
        // Mengosongkan nomor telepon.
        phone = "";
    }

    // ====================================================
    // CONSTRUCTOR BERPATAMETER
    // ====================================================

    // Constructor dengan parameter lengkap.
    public Customer(String customerId, String name, String phone) {
        // Mengisi ID customer.
        this.customerId = customerId;
        // Mengisi nama customer.
        this.name = name;
        // Mengisi nomor telepon.
        this.phone = phone;
    }

    // ====================================================
    // GETTER DAN SETTER CUSTOMER ID
    // ====================================================

    // Getter ID customer.
    public String getCustomerId() {
        // Mengembalikan ID customer.
        return customerId;
    }
    // Setter ID customer.
    public void setCustomerId(String customerId) {
        // Mengubah ID customer.
        this.customerId = customerId;
    }

    // ====================================================
    // GETTER DAN SETTER NAME
    // ====================================================

    // Getter nama customer.
    public String getName() {
        // Mengembalikan nama customer.
        return name;
    }
    // Setter nama customer.
    public void setName(String name) {
        // Mengubah nama customer.
        this.name = name;
    }

    // ====================================================
    // GETTER DAN SETTER PHONE
    // ====================================================

    // Getter nomor telepon.
    public String getPhone() {
        // Mengembalikan nomor telepon.
        return phone;
    }
    // Setter nomor telepon.
    public void setPhone(String phone) {
        // Mengubah nomor telepon.
        this.phone = phone;
    }

    // ====================================================
    // DISPLAY INFO
    // ====================================================

    // Method untuk menampilkan data customer.
    public void displayInfo() {
        // Menampilkan seluruh informasi customer.
        System.out.println(
            "ID Pelanggan: " + customerId +
            " | Nama: " + name +
            " | Telepon: " + phone
        );
    }

    // ====================================================
    // DATA UNTUK TABEL
    // ====================================================

    // Method untuk mengambil data customer sebagai baris tabel.
    public List<String> getTableRow() {
        // Membuat list untuk menyimpan data.
        List<String> row = new ArrayList<>();

        // Memasukkan ID customer.
        row.add(customerId);
        // Memasukkan nama.
        row.add(name);
        // Memasukkan nomor telepon.
        row.add(phone);

        // Mengembalikan baris data.
        return row;
    }
}
