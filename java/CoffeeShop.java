// Mengimpor ArrayList.
import java.util.ArrayList;
// Mengimpor List.
import java.util.List;

// Membuat class CoffeeShop.
public class CoffeeShop {
    // Menyimpan nama coffee shop.
    private String shopName;
    // Menyimpan lokasi coffee shop.
    private String location;
    // Menyimpan berbagai MenuItem.
    private ArrayList<MenuItem> menu;
    // Menyimpan berbagai Customer.
    private ArrayList<Customer> customers;
    // Menyimpan berbagai Order.
    private ArrayList<Order> orders;

    // Constructor kosong.
    public CoffeeShop() {
        // Mengosongkan nama coffee shop.
        shopName = "";
        // Mengosongkan lokasi.
        location = "";
        // Membuat ArrayList menu.
        menu = new ArrayList<>();
        // Membuat ArrayList customer.
        customers = new ArrayList<>();
        // Membuat ArrayList order.
        orders = new ArrayList<>();
    }

    // Constructor dengan nama dan lokasi.
    public CoffeeShop(String shopName, String location) {
        // Mengisi nama coffee shop.
        this.shopName = shopName;
        // Mengisi lokasi.
        this.location = location;
        // Membuat ArrayList menu.
        this.menu = new ArrayList<>();
        // Membuat ArrayList customer.
        this.customers = new ArrayList<>();
        // Membuat ArrayList order.
        this.orders = new ArrayList<>();
    }

    // Getter nama coffee shop.
    public String getShopName() {
        // Mengembalikan nama.
        return shopName;
    }
    // Setter nama.
    public void setShopName(String shopName) {
        // Mengubah nama coffee shop.
        this.shopName = shopName;
    }

    // Getter lokasi.
    public String getLocation() {
        // Mengembalikan lokasi.
        return location;
    }
    // Setter lokasi.
    public void setLocation(String location) {
        // Mengubah lokasi.
        this.location = location;
    }

    // ====================================================
    // MENAMBAHKAN MENU
    // ====================================================

    // Method untuk menambahkan MenuItem.
    public void addMenuItem(MenuItem item) {
        // Menambahkan object ke ArrayList menu.
        menu.add(item);
    }

    // ====================================================
    // MENAMBAHKAN CUSTOMER
    // ====================================================

    // Method untuk menambahkan Customer.
    public void addCustomer(Customer customer) {
        // Menambahkan object customer ke list.
        customers.add(customer);
    }

    // ====================================================
    // MENAMBAHKAN ORDER
    // ====================================================

    // Method untuk menambahkan Order.
    public void addOrder(Order order) {
        // Menambahkan order ke ArrayList.
        orders.add(order);
    }

    // ====================================================
    // DISPLAY SEMUA DATA
    // ====================================================

    // Method untuk menampilkan seluruh data coffee shop.
    public void displayAllData() {
        // Menampilkan nama coffee shop.
        System.out.println("INFO COFFEE SHOP : " + shopName);
        // Menampilkan lokasi.
        System.out.println("Lokasi           : " + location);
        // Menampilkan garis.
        System.out.println("============================================================");

        // ==================================================
        // TABEL MENU
        // ==================================================

        // Menampilkan judul daftar menu.
        System.out.println("\n--- DAFTAR MENU KAFE ---");

        // Memeriksa apakah menu kosong.
        if (menu.isEmpty()) {
            // Menampilkan pesan kosong.
            System.out.println("(Belum ada menu tersedia)");
        }
        // Jika menu tidak kosong.
        else {
            // Membuat header tabel menu.
            List<String> header = new ArrayList<>();
            // Menambahkan kolom ID.
            header.add("ID");
            // Menambahkan kolom nama.
            header.add("Nama Menu");
            // Menambahkan kolom jenis.
            header.add("Jenis");
            // Menambahkan kolom ukuran/kategori.
            header.add("Ukuran / Kategori");
            // Menambahkan kolom suhu.
            header.add("Suhu");
            // Menambahkan kolom harga.
            header.add("Harga");

            // Membuat data tabel menu.
            List<List<String>> data = new ArrayList<>();

            // Mengambil seluruh object menu.
            for (MenuItem item : menu) {
                // Polymorphism dijalankan di sini.
                // getTableRow() mengikuti jenis object sebenarnya.
                data.add(item.getTableRow());
            }
            // Menampilkan tabel menu.
            Order.tampilkanTabel(header, data);
        }

        // ==================================================
        // TABEL CUSTOMER
        // ==================================================

        // Menampilkan judul customer.
        System.out.println("\n--- DAFTAR PELANGGAN ---");

        // Memeriksa apakah customer kosong.
        if (customers.isEmpty()) {
            // Menampilkan pesan kosong.
            System.out.println("(Belum ada pelanggan terdaftar)");
        }

        // Jika customer tidak kosong.
        else {
            // Membuat header customer.
            List<String> header = new ArrayList<>();
            // Menambahkan ID.
            header.add("ID Pelanggan");
            // Menambahkan nama.
            header.add("Nama");
            // Menambahkan telepon.
            header.add("Telepon");

            // Membuat list data.
            List<List<String>> data = new ArrayList<>();

            // Mengambil seluruh customer.
            for (Customer customer : customers) {
                // Memasukkan data customer.
                data.add( customer.getTableRow());
            }

            // Menampilkan tabel customer.
            Order.tampilkanTabel(header, data);
        }

        // ==================================================
        // TABEL ORDER
        // ==================================================

        // Menampilkan judul order.
        System.out.println("\n--- DAFTAR TRANSAKSI PESANAN ---");
        // Memeriksa apakah order kosong.
        if (orders.isEmpty()) {
            // Menampilkan pesan jika kosong.
            System.out.println("(Belum ada pesanan)");
        }

        // Jika order tersedia.
        else {
            // Membuat header order.
            List<String> header = new ArrayList<>();
            // Menambahkan ID order.
            header.add("Order ID");
            // Menambahkan tanggal.
            header.add("Tanggal");
            // Menambahkan customer.
            header.add("Customer");
            // Menambahkan total.
            header.add("Total Harga");

            // Membuat data order.
            List<List<String>> data = new ArrayList<>();
            // Mengambil seluruh order.
            for (Order order : orders) {
                // Memasukkan data order.
                data.add(order.getTableRow());
            }

            // Menampilkan tabel order.
            Order.tampilkanTabel(header, data);
            // Memberikan jarak.
            System.out.println();

            // Menampilkan detail masing-masing order.
            for (int i = 0; i < orders.size(); i++) {
                // Menampilkan nomor order.
                System.out.println("DETAIL PESANAN " + (i + 1));
                // Menampilkan detail order.
                orders.get(i).displayOrder();
                // Memberikan jarak.
                System.out.println();
            }
        }
        // Menampilkan garis akhir.
        System.out.println("============================================================");
    }
}