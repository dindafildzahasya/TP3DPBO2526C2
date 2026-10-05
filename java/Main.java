// Membuat class Main sebagai class utama program.
public class Main {
    // Method main merupakan titik awal program Java.
    public static void main(String[] args) {
        // Membuat object CoffeeShop.
        CoffeeShop myCoffeeShop = new CoffeeShop("Senja Coffee & Space", "Jl. Ir. H. Djuanda No. 100, Bandung");

        // Memberikan jarak.
        System.out.println();
        // Menampilkan judul kondisi awal.
        System.out.println("=== KONDISI COFFEE SHOP "
            + "SEBELUM DATA DITAMBAHKAN ===");

        // Menampilkan seluruh data awal.
        myCoffeeShop.displayAllData();

        // Membuat object Beverage pertama.
        MenuItem kopi1 = new Beverage("B001", "Caffe Latte", 28000.0, "Medium", "Hot");
        // Membuat object Food pertama.
        MenuItem makanan1 = new Food("F001", "Croissant Butter", 22000.0, "Pastry");
        // Membuat customer pertama.
        Customer cust1 = new Customer( "C050", "Budi Santoso", "081234567890");

        // Menambahkan minuman ke coffee shop.
        myCoffeeShop.addMenuItem(kopi1);
        // Menambahkan makanan ke coffee shop.
        myCoffeeShop.addMenuItem(makanan1);
        // Menambahkan customer.
        myCoffeeShop.addCustomer(cust1);

        // Membuat order pertama.
        Order order1 = new Order("ORD-001", "2026-10-03", cust1);
        // Menambahkan 2 Caffe Latte.
        order1.addItem(kopi1, 2);
        // Menambahkan order ke coffee shop.
        myCoffeeShop.addOrder(order1);

        // ====================================================
        // KONDISI SETELAH TAHAP 1
        // ====================================================

        // Memberikan jarak.
        System.out.println();
        // Menampilkan judul.
        System.out.println("=== KONDISI SETELAH DATA " + "TAHAP 1 DITAMBAHKAN ===");
        // Menampilkan kondisi terbaru.
        myCoffeeShop.displayAllData();

        // ====================================================
        // DATA TAHAP KEDUA
        // ====================================================

        // Menampilkan keterangan.
        System.out.println();
        System.out.println(">>> MENAMBAHKAN DATA TAHAP 2 <<<");

        // Membuat Beverage kedua.
        MenuItem kopi2 = new Beverage("B002", "Americano Ice", 25000.0, "Large", "Iced");
        // Membuat Food kedua.
        MenuItem makanan2 = new Food( "F002", "Spaghetti Carbonara", 45000.0, "Main Course");
        // Membuat customer kedua.
        Customer cust2 = new Customer( "C051", "Siti Rahma", "089876543210");

        // ====================================================
        // MENAMBAHKAN DATA TAHAP KEDUA
        // ====================================================

        // Menambahkan minuman kedua.
        myCoffeeShop.addMenuItem(kopi2);
        // Menambahkan makanan kedua.
        myCoffeeShop.addMenuItem(makanan2);
        // Menambahkan customer kedua.
        myCoffeeShop.addCustomer(cust2);

        // ====================================================
        // ORDER KEDUA
        // ====================================================

        // Membuat order kedua.
        Order order2 = new Order( "ORD-002", "2026-10-03", cust2);
        // Menambahkan 1 Americano Ice.
        order2.addItem(kopi2, 1);
        // Menambahkan 1 Spaghetti Carbonara.
        order2.addItem(makanan2, 1);

        // Menambahkan order kedua.
        myCoffeeShop.addOrder(order2);
        // Memberikan jarak.
        System.out.println();
        // Menampilkan judul kondisi akhir.
        System.out.println(
            "=== KONDISI COFFEE SHOP "
            + "SETELAH DATA TAHAP 2 DITAMBAHKAN ===");

        // Menampilkan seluruh data.
        myCoffeeShop.displayAllData();
    }
}