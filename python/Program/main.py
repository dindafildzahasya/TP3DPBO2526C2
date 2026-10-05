# Mengimpor class Beverage.
from beverage import Beverage
# Mengimpor class Food.
from food import Food
# Mengimpor class Customer.
from customer import Customer
# Mengimpor class Order.
from order import Order
# Mengimpor class CoffeeShop.
from coffee_shop import CoffeeShop

# ========================================================
# FUNGSI UTAMA PROGRAM
# ========================================================

# Program Python dijalankan dari bagian ini.
if __name__ == "__main__":
    # ====================================================
    # MEMBUAT OBJECT COFFEE SHOP
    # ====================================================

    # Membuat object CoffeeShop.
    my_coffee_shop = CoffeeShop(
        "Senja Coffee & Space",
        "Jl. Ir. H. Djuanda No. 100, Bandung")

    # ====================================================
    # KONDISI AWAL
    # ====================================================

    # Menampilkan judul kondisi awal.
    print()
    print("=== KONDISI COFFEE SHOP "
        "SEBELUM DATA DITAMBAHKAN ===")

    # Menampilkan seluruh data awal.
    my_coffee_shop.display_all_data()

    # ====================================================
    # DATA TAHAP PERTAMA
    # ====================================================

    # Membuat object Beverage pertama.
    kopi1 = Beverage("B001", "Caffe Latte", 28000.0, "Medium", "Hot")
    # Membuat object Food pertama.
    makanan1 = Food("F001", "Croissant Butter", 22000.0, "Pastry")
    # Membuat object Customer pertama.
    cust1 = Customer("C050", "Budi Santoso", "081234567890")

    # ====================================================
    # MENAMBAHKAN DATA TAHAP PERTAMA
    # ====================================================

    # Menambahkan minuman ke coffee shop.
    my_coffee_shop.add_menu_item(kopi1)
    # Menambahkan makanan ke coffee shop.
    my_coffee_shop.add_menu_item(makanan1)
    # Menambahkan customer ke coffee shop.
    my_coffee_shop.add_customer(cust1)

    # ====================================================
    # MEMBUAT ORDER PERTAMA
    # ====================================================

    # Membuat object Order pertama.
    order1 = Order("ORD-001", "2026-10-03", cust1)
    # Menambahkan 2 Caffe Latte ke order pertama.
    order1.add_item(kopi1, 2)
    # Menambahkan order pertama ke coffee shop.
    my_coffee_shop.add_order(order1)

    # ====================================================
    # KONDISI SETELAH TAHAP PERTAMA
    # ====================================================

    # Menampilkan judul tahap pertama.
    print()
    print("=== KONDISI SETELAH DATA "
        "TAHAP 1 DITAMBAHKAN ===")

    # Menampilkan seluruh data setelah tahap pertama.
    my_coffee_shop.display_all_data()

    # ====================================================
    # DATA TAHAP KEDUA
    # ====================================================

    # Menampilkan keterangan penambahan data.
    print()
    print(">>> MENAMBAHKAN DATA TAHAP 2 <<<")

    # Membuat object Beverage kedua.
    kopi2 = Beverage("B002", "Americano Ice", 25000.0, "Large", "Iced")
    # Membuat object Food kedua.
    makanan2 = Food("F002", "Spaghetti Carbonara", 45000.0, "Main Course")
    # Membuat object Customer kedua.
    cust2 = Customer("C051", "Siti Rahma", "089876543210")

    # ====================================================
    # MENAMBAHKAN DATA TAHAP KEDUA
    # ====================================================

    # Menambahkan beverage kedua ke coffee shop.
    my_coffee_shop.add_menu_item(kopi2)
    # Menambahkan food kedua ke coffee shop.
    my_coffee_shop.add_menu_item(makanan2)
    # Menambahkan customer kedua ke coffee shop.
    my_coffee_shop.add_customer(cust2)

    # ====================================================
    # MEMBUAT ORDER KEDUA
    # ====================================================

    # Membuat object Order kedua.
    order2 = Order("ORD-002", "2026-10-03", cust2)
    # Menambahkan 1 Americano Ice.
    order2.add_item(kopi2, 1)
    # Menambahkan 1 Spaghetti Carbonara.
    order2.add_item(makanan2, 1)
    # Menambahkan order kedua ke coffee shop.
    my_coffee_shop.add_order(order2)

    # ====================================================
    # KONDISI AKHIR
    # ====================================================

    # Memberikan jarak sebelum output akhir.
    print()

    print("=== KONDISI COFFEE SHOP "
        "SETELAH DATA TAHAP 2 DITAMBAHKAN ===")

    # Menampilkan seluruh data akhir.
    my_coffee_shop.display_all_data()