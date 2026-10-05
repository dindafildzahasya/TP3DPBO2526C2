# Mengimpor class MenuItem.
from menu_item import MenuItem
# Mengimpor class Beverage.
from beverage import Beverage
# Mengimpor class Food.
from food import Food
# Mengimpor class Customer.
from customer import Customer
# Mengimpor class Order dan fungsi tabel dinamis.
from order import Order, tampilkan_tabel

# Membuat class CoffeeShop.
class CoffeeShop:
    # Constructor class CoffeeShop.
    def __init__(self, shop_name="", location=""):
        # Menyimpan nama coffee shop.
        self.shop_name = shop_name
        # Menyimpan lokasi coffee shop.
        self.location = location

        # ====================================================
        # ARRAY OF OBJECT
        # ====================================================

        # List untuk menyimpan object MenuItem.
        # List ini dapat berisi Beverage dan Food.
        self.menu = []
        # List untuk menyimpan object Customer.
        self.customers = []
        # List untuk menyimpan object Order.
        self.orders = []

    # Getter nama coffee shop.
    def get_shop_name(self):
        # Mengembalikan nama coffee shop.
        return self.shop_name
    # Setter nama coffee shop.
    def set_shop_name(self, shop_name):
        # Mengubah nama coffee shop.
        self.shop_name = shop_name

    # Getter lokasi coffee shop.
    def get_location(self):
        # Mengembalikan lokasi coffee shop.
        return self.location
    # Setter lokasi coffee shop.
    def set_location(self, location):
        # Mengubah lokasi coffee shop.
        self.location = location

    # Method untuk menambahkan menu baru.
    def add_menu_item(self, item):
        # Menambahkan object MenuItem ke dalam list menu.
        self.menu.append(item)

    # Method untuk menambahkan customer baru.
    def add_customer(self, customer):
        # Menambahkan object Customer ke dalam list customers.
        self.customers.append(customer)

    # Method untuk menambahkan order baru.
    def add_order(self, order):
        # Menambahkan object Order ke dalam list orders.
        self.orders.append(order)

    # ========================================================
    # MENAMPILKAN SELURUH DATA
    # ========================================================

    # Method untuk menampilkan semua data coffee shop.
    def display_all_data(self):
        # Menampilkan nama coffee shop.
        print(f"INFO COFFEE SHOP : " f"{self.shop_name}")
        # Menampilkan lokasi coffee shop.
        print(f"Lokasi           : " f"{self.location}")
        # Menampilkan garis pembatas.
        print("=" * 60)

        # ====================================================
        # TABEL MENU
        # ====================================================

        # Menampilkan judul daftar menu.
        print("\n--- DAFTAR MENU KAFE ---")

        # Memeriksa apakah menu masih kosong.
        if not self.menu:
            # Menampilkan pesan jika belum ada menu.
            print("(Belum ada menu tersedia)")

        # Jika menu tidak kosong.
        else:
            # Membuat header tabel menu.
            header = ["ID", "Nama Menu", "Jenis", "Ukuran / Kategori", "Suhu", "Harga"]
            # Membuat list untuk menyimpan data menu.
            data = []

            # Mengambil setiap object menu.
            for item in self.menu:
                # Menggunakan polymorphism.
                # Method yang dipanggil menyesuaikan object sebenarnya.
                data.append(item.get_table_row())

            # Menampilkan tabel menu.
            tampilkan_tabel(header, data)

        # ====================================================
        # TABEL CUSTOMER
        # ====================================================

        # Menampilkan judul daftar customer.
        print("\n--- DAFTAR PELANGGAN ---")

        # Memeriksa apakah customer kosong.
        if not self.customers:
            # Menampilkan pesan jika belum ada customer.
            print("(Belum ada pelanggan terdaftar)")

        # Jika customer tidak kosong.
        else:
            # Membuat header tabel customer.
            header = ["ID Pelanggan", "Nama", "Telepon"]
            # Membuat list data customer.
            data = []

            # Mengambil setiap customer.
            for customer in self.customers:
                # Memasukkan data customer ke tabel.
                data.append(customer.get_table_row())
            # Menampilkan tabel customer.
            tampilkan_tabel(header, data)

        # ====================================================
        # TABEL ORDER
        # ====================================================

        # Menampilkan judul daftar order.
        print("\n--- DAFTAR TRANSAKSI PESANAN ---")

        # Memeriksa apakah order kosong.
        if not self.orders:
            # Menampilkan pesan jika belum ada order.
            print("(Belum ada pesanan)")

        # Jika order tidak kosong.
        else:
            # Membuat header tabel order.
            header = ["Order ID", "Tanggal", "Customer", "Total Harga"]
            # Membuat list data order.
            data = []

            # Mengambil setiap order.
            for order in self.orders:
                # Memasukkan data order ke tabel.
                data.append(order.get_table_row())

            # Menampilkan tabel order.
            tampilkan_tabel(header, data)
            # Memberikan jarak.
            print()

            # ====================================================
            # DETAIL SETIAP ORDER
            # ====================================================

            # Menggunakan enumerate agar mendapatkan nomor order.
            for i, order in enumerate(self.orders, start=1):
                # Menampilkan nomor detail order.
                print(f"DETAIL PESANAN {i}")
                # Menampilkan detail order.
                order.display_order()
                # Memberikan jarak antar order.
                print()