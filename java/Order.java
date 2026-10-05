// Mengimpor ArrayList.
import java.util.ArrayList;
// Mengimpor List.
import java.util.List;

// Membuat class Order.
public class Order {
    // Menyimpan ID pesanan.
    private String orderId;
    // Menyimpan tanggal pesanan.
    private String orderDate;
    // Menyimpan customer yang melakukan pesanan.
    private Customer customer;
    // Array of Object untuk menyimpan OrderItem.
    private ArrayList<OrderItem> items;
    // Menyimpan total pembayaran.
    private double total;

    // ====================================================
    // CONSTRUCTOR KOSONG
    // ====================================================

    // Constructor kosong Order.
    public Order() {
        // Mengosongkan ID.
        orderId = "";
        // Mengosongkan tanggal.
        orderDate = "";
        // Customer belum tersedia.
        customer = null;
        // Membuat ArrayList OrderItem.
        items = new ArrayList<>();
        // Mengatur total menjadi nol.
        total = 0.0;
    }

    // ====================================================
    // CONSTRUCTOR BERPATAMETER
    // ====================================================

    // Constructor Order dengan parameter.
    public Order(String orderId, String orderDate, Customer customer) {
        // Mengisi ID order.
        this.orderId = orderId;
        // Mengisi tanggal.
        this.orderDate = orderDate;
        // Mengisi customer.
        this.customer = customer;
        // Membuat list OrderItem.
        this.items = new ArrayList<>();
        // Mengatur total awal.
        this.total = 0.0;
    }

    // ====================================================
    // GETTER DAN SETTER ORDER ID
    // ====================================================

    // Getter order ID.
    public String getOrderId() {
        // Mengembalikan order ID.
        return orderId;
    }
    // Setter order ID.
    public void setOrderId(String orderId) {
        // Mengubah order ID.
        this.orderId = orderId;
    }

    // ====================================================
    // GETTER DAN SETTER ORDER DATE
    // ====================================================

    // Getter tanggal.
    public String getOrderDate() {
        // Mengembalikan tanggal.
        return orderDate;
    }
    // Setter tanggal.
    public void setOrderDate(String orderDate) {
        // Mengubah tanggal.
        this.orderDate = orderDate;
    }

    // ====================================================
    // GETTER DAN SETTER CUSTOMER
    // ====================================================

    // Getter customer.
    public Customer getCustomer() {
        // Mengembalikan customer.
        return customer;
    }
    // Setter customer.
    public void setCustomer(Customer customer) {
        // Mengubah customer.
        this.customer = customer;
    }

    // ====================================================
    // GETTER TOTAL
    // ====================================================

    // Getter total.
    public double getTotal() {
        // Mengembalikan total pembayaran.
        return total;
    }

    // ====================================================
    // MENAMBAHKAN ITEM
    // ====================================================

    // Method untuk menambahkan item ke order.
    public void addItem(MenuItem menuItem, int quantity) {
        // Membuat object OrderItem.
        OrderItem orderItem = new OrderItem(menuItem, quantity);
        // Menambahkan object ke ArrayList.
        items.add(orderItem);
        // Menghitung ulang total.
        calculateTotal();
    }

    // ====================================================
    // MENGHITUNG TOTAL
    // ====================================================

    // Method untuk menghitung total seluruh item.
    public double calculateTotal() {
        // Mengatur total awal menjadi nol.
        total = 0.0;

        // Melakukan perulangan terhadap seluruh item.
        for (OrderItem item : items) {
            // Menambahkan subtotal setiap item.
            total += item.getSubtotal();
        }

        // Mengembalikan total.
        return total;
    }

    // ====================================================
    // METHOD TABEL DINAMIS
    // ====================================================

    // Method static untuk menampilkan tabel dinamis.
    public static void tampilkanTabel(List<String> header, List<List<String>> data) {
        // Membuat ArrayList untuk menyimpan lebar setiap kolom.
        ArrayList<Integer> panjangKolom = new ArrayList<>();

        // Menentukan panjang awal berdasarkan header.
        for (String judul : header) {
            // Menyimpan panjang setiap judul.
            panjangKolom.add(judul.length());
        }

        // Memeriksa seluruh data.
        for (List<String> baris : data) {
            // Memeriksa setiap kolom.
            for (int i = 0; i < baris.size(); i++) {
                // Jika data lebih panjang daripada header.
                if (baris.get(i).length() > panjangKolom.get(i)) {
                    // Mengubah ukuran kolom.
                    panjangKolom.set(i, baris.get(i).length());
                }
            }
        }

        // Membuat garis tabel.
        StringBuilder garis = new StringBuilder("+");

        // Membuat bagian garis untuk setiap kolom.
        for (int panjang : panjangKolom) {
            // Menambahkan karakter -.
            garis.append("-".repeat(panjang + 2));
            // Menambahkan pemisah kolom.
            garis.append("+");
        }

        // Menampilkan garis atas.
        System.out.println(garis);
        // Menampilkan header.
        System.out.print("|");

        // Melakukan perulangan header.
        for (int i = 0; i < header.size(); i++) {
            // Menampilkan header dengan lebar dinamis.
            System.out.printf(" %-" + panjangKolom.get(i) + "s |", header.get(i));
        }

        // Pindah baris.
        System.out.println();
        // Menampilkan garis setelah header.
        System.out.println(garis);

        // Menampilkan setiap baris data.
        for (List<String> baris : data) {
            // Membuka baris dengan tanda |.
            System.out.print("|");

            // Melakukan perulangan setiap kolom.
            for (int i = 0; i < header.size(); i++) {
                // Mengambil data jika tersedia.
                String isi = i < baris.size() ? baris.get(i) : "";
                // Menampilkan data.
                System.out.printf(" %-" + panjangKolom.get(i) + "s |", isi);
            }

            // Pindah baris.
            System.out.println();
        }
        // Menampilkan garis bawah.
        System.out.println(garis);
    }

    // ====================================================
    // DISPLAY ORDER
    // ====================================================

    // Method untuk menampilkan detail order.
    public void displayOrder() {
        // Menampilkan ID order.
        System.out.println("ID Pesanan : " + orderId);
        // Menampilkan tanggal order.
        System.out.println("Tanggal    : " + orderDate);

        // Memeriksa keberadaan customer.
        if (customer != null) {
            // Menampilkan nama customer.
            System.out.println("Pelanggan  : " + customer.getName());
        }

        // Jika customer tidak tersedia.
        else {
            // Menampilkan tanda kosong.
            System.out.println("Pelanggan  : -");
        }

        // Memberikan jarak.
        System.out.println();

        // Membuat header tabel order item.
        List<String> header = new ArrayList<>();
        // Menambahkan nama menu.
        header.add("Menu");
        // Menambahkan quantity.
        header.add("Quantity");
        // Menambahkan harga.
        header.add("Harga");
        // Menambahkan subtotal.
        header.add("Subtotal");

        // Membuat list data tabel.
        List<List<String>> data = new ArrayList<>();
        // Mengambil seluruh OrderItem.
        for (OrderItem item : items) {
            // Menambahkan baris data.
            data.add(item.getTableRow());
        }

        // Menampilkan tabel.
        tampilkanTabel(header, data);
        // Menampilkan total pembayaran.
        System.out.println( "Total Pembayaran : Rp" + (int) total);
        // Menampilkan garis pemisah.
        System.out.println("------------------------------------------------------------");
    }

    // ====================================================
    // DATA UNTUK TABEL ORDER
    // ====================================================

    // Method untuk mengambil satu baris data order.
    public List<String> getTableRow() {
        // Membuat list untuk satu baris.
        List<String> row = new ArrayList<>();

        // Menambahkan order ID.
        row.add(orderId);
        // Menambahkan tanggal.
        row.add(orderDate);

        // Memeriksa customer.
        if (customer != null) {
            // Menambahkan nama customer.
            row.add(customer.getName());
        }

        // Jika customer tidak tersedia.
        else {
            // Mengisi dengan tanda -.
            row.add("-");
        }
        // Menambahkan total harga.
        row.add( "Rp" + (int) total);

        // Mengembalikan data.
        return row;
    }
}