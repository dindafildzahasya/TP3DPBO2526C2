// Mengimpor ArrayList untuk membuat list data tabel.
import java.util.ArrayList;
// Mengimpor List sebagai tipe data list.
import java.util.List;

// Membuat class OrderItem.
public class OrderItem {
    // Menyimpan object MenuItem yang dipesan.
    private MenuItem menuItem;
    // Menyimpan jumlah item.
    private int quantity;
    // Menyimpan subtotal harga.
    private double subtotal;

    // ====================================================
    // CONSTRUCTOR KOSONG
    // ====================================================

    // Constructor kosong.
    public OrderItem() {
        // Tidak ada menu yang dipilih.
        menuItem = null;
        // Jumlah awal nol.
        quantity = 0;
        // Subtotal awal nol.
        subtotal = 0.0;
    }

    // ====================================================
    // CONSTRUCTOR BERPATAMETER
    // ====================================================

    // Constructor dengan menu dan jumlah.
    public OrderItem(
        MenuItem menuItem,
        int quantity
    ) {
        // Menyimpan menu yang dipesan.
        this.menuItem = menuItem;
        // Menyimpan jumlah.
        this.quantity = quantity;
        // Menghitung subtotal.
        this.subtotal = calculateSubTotal();
    }

    // ====================================================
    // GETTER DAN SETTER MENU ITEM
    // ====================================================

    // Getter MenuItem.
    public MenuItem getMenuItem() {
        // Mengembalikan object MenuItem.
        return menuItem;
    }
    // Setter MenuItem.
    public void setMenuItem(MenuItem menuItem) {
        // Mengubah menu item.
        this.menuItem = menuItem;
        // Menghitung ulang subtotal.
        this.subtotal = calculateSubTotal();
    }

    // ====================================================
    // GETTER DAN SETTER QUANTITY
    // ====================================================

    // Getter quantity.
    public int getQuantity() {
        // Mengembalikan jumlah.
        return quantity;
    }
    // Setter quantity.
    public void setQuantity(int quantity) {
        // Mengubah quantity.
        this.quantity = quantity;
        // Menghitung ulang subtotal.
        this.subtotal = calculateSubTotal();
    }

    // ====================================================
    // GETTER SUBTOTAL
    // ====================================================

    // Getter subtotal.
    public double getSubtotal() {
        // Mengembalikan subtotal.
        return subtotal;
    }

    // ====================================================
    // MENGHITUNG SUBTOTAL
    // ====================================================

    // Method untuk menghitung subtotal.
    public double calculateSubTotal() {
        // Memeriksa apakah MenuItem tersedia.
        if (menuItem != null) {
            // Harga dikali quantity.
            return menuItem.getPrice() * quantity;
        }

        // Mengembalikan nol jika tidak ada menu.
        return 0.0;
    }

    // ====================================================
    // DISPLAY INFO
    // ====================================================

    // Method untuk menampilkan detail item.
    public void displayInfo() {
        // Memeriksa apakah MenuItem tersedia.
        if (menuItem != null) {
            // Menampilkan nama, quantity, dan subtotal.
            System.out.println(menuItem.getName() + " x " + quantity + " = Rp" + (int) subtotal);
        }
    }

    // ====================================================
    // DATA UNTUK TABEL
    // ====================================================

    // Method untuk mengambil data item dalam tabel.
    public List<String> getTableRow() {
        // Membuat list untuk menyimpan satu baris.
        List<String> row = new ArrayList<>();

        // Memeriksa apakah MenuItem tersedia.
        if (menuItem != null) {
            // Memasukkan nama menu.
            row.add(menuItem.getName());
            // Memasukkan jumlah.
            row.add(String.valueOf(quantity));
            // Memasukkan harga satuan.
            row.add("Rp" + (int) menuItem.getPrice());
            // Memasukkan subtotal.
            row.add("Rp" + (int) subtotal);

            // Mengembalikan data.
            return row;
        }

        // Data kosong jika menu tidak tersedia.
        row.add("-");
        // Quantity nol.
        row.add("0");
        // Harga nol.
        row.add("Rp0");
        // Subtotal nol.
        row.add("Rp0");

        // Mengembalikan data kosong.
        return row;
    }
}
