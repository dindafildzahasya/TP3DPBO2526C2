# Mengimpor class Customer dari customer.py.
from customer import Customer

# Mengimpor class OrderItem dari order_item.py.
from order_item import OrderItem

# ========================================================
# FUNGSI TABEL DINAMIS
# ========================================================

# Fungsi ini digunakan untuk menampilkan data dalam bentuk tabel.
def tampilkan_tabel(header, data):
    # Membuat list untuk menyimpan panjang masing-masing kolom.
    panjang_kolom = []
    # Menghitung panjang awal berdasarkan header.
    for judul in header:
        # Menyimpan panjang karakter dari header.
        panjang_kolom.append(len(judul))

    # Mencari data terpanjang di setiap kolom.
    for baris in data:
        # Melakukan perulangan untuk setiap isi baris.
        for i in range(len(baris)):
            # Memeriksa apakah isi lebih panjang dari ukuran kolom.
            if len(baris[i]) > panjang_kolom[i]:
                # Mengubah ukuran kolom sesuai panjang data.
                panjang_kolom[i] = len(baris[i])

    # Membuat garis tabel menggunakan tanda + dan -.
    garis = "+"

    # Membuat garis untuk setiap kolom.
    for panjang in panjang_kolom:
        # Menambahkan garis sesuai lebar kolom.
        garis += "-" * (panjang + 2)
        # Menambahkan pemisah kolom.
        garis += "+"

    # Menampilkan garis bagian atas tabel.
    print(garis)

    # Menampilkan header tabel.
    print("|", end="")

    # Melakukan perulangan untuk setiap header.
    for i in range(len(header)):
        # Menampilkan nama kolom dengan lebar dinamis.
        print(f" {header[i]:<{panjang_kolom[i]}} |", end="")

    # Pindah ke baris berikutnya.
    print()
    # Menampilkan garis setelah header.
    print(garis)

    # Menampilkan seluruh data.
    for baris in data:
        # Menampilkan pembuka baris.
        print("|", end="")

        # Melakukan perulangan untuk setiap kolom.
        for i in range(len(header)):
            # Mengambil isi kolom.
            isi = baris[i] if i < len(baris) else ""
            # Menampilkan isi dengan lebar dinamis.
            print(f" {isi:<{panjang_kolom[i]}} |", end="")
        # Pindah ke baris berikutnya.
        print()
    # Menampilkan garis bawah tabel.
    print(garis)

# ========================================================
# CLASS ORDER
# ========================================================

# Membuat class Order untuk merepresentasikan pesanan.
class Order:

    # Constructor class Order.
    def __init__(self, order_id="", order_date="", customer=None):
        # Menyimpan ID order.
        self.order_id = order_id
        # Menyimpan tanggal order.
        self.order_date = order_date
        # Menyimpan object Customer.
        self.customer = customer

        # ====================================================
        # COMPOSITION
        # Order memiliki kumpulan OrderItem.
        # ====================================================

        # Membuat list untuk menyimpan object OrderItem.
        self.items = []
        # Menyimpan total pembayaran.
        self.total = 0.0

    # Getter untuk ID order.
    def get_order_id(self):
        # Mengembalikan ID order.
        return self.order_id
    # Setter untuk ID order.
    def set_order_id(self, order_id):
        # Mengubah ID order.
        self.order_id = order_id

    # Getter untuk tanggal order.
    def get_order_date(self):
        # Mengembalikan tanggal order.
        return self.order_date
    # Setter untuk tanggal order.
    def set_order_date(self, order_date):
        # Mengubah tanggal order.
        self.order_date = order_date

    # Getter untuk customer.
    def get_customer(self):
        # Mengembalikan object customer.
        return self.customer
    # Setter untuk customer.
    def set_customer(self, customer):
        # Mengubah object customer.
        self.customer = customer

    # Getter untuk total pembayaran.
    def get_total(self):
        # Mengembalikan total pembayaran.
        return self.total

    # Method untuk menambahkan item ke order.
    def add_item(self, menu_item, quantity):
        # Membuat object OrderItem baru.
        order_item = OrderItem( menu_item, quantity)
        # Menambahkan OrderItem ke dalam list items.
        self.items.append(order_item)
        # Menghitung ulang total order.
        self.calculate_total()

    # Method untuk menghitung total order.
    def calculate_total(self):
        # Mengosongkan total terlebih dahulu.
        self.total = 0.0
        # Melakukan perulangan pada seluruh OrderItem.
        for item in self.items:
            # Menambahkan subtotal setiap item.
            self.total += item.get_subtotal()
        # Mengembalikan total pembayaran.
        return self.total

    # Method untuk menampilkan detail order.
    def display_order(self):
        # Menampilkan ID order.
        print(f"ID Pesanan : {self.order_id}")
        # Menampilkan tanggal order.
        print(f"Tanggal    : {self.order_date}")

        # Memeriksa apakah customer tersedia.
        if self.customer is not None:
            # Menampilkan nama customer.
            print(f"Pelanggan  : " f"{self.customer.get_name()}")
        # Jika customer tidak tersedia.
        else:
            # Menampilkan keterangan kosong.
            print("Pelanggan  : -")

        # Memberikan jarak sebelum tabel.
        print()
        # Membuat header tabel item order.
        header = ["Menu", "Quantity", "Harga", "Subtotal"]
        # Membuat list untuk menyimpan data tabel.
        data = []

        # Mengambil seluruh OrderItem.
        for item in self.items:
            # Memasukkan data OrderItem ke tabel.
            data.append(item.get_table_row())

        # Menampilkan tabel detail order.
        tampilkan_tabel(header, data)

        # Menampilkan total pembayaran.
        print(f"Total Pembayaran : " f"Rp{int(self.total)}")
        # Menampilkan garis pemisah.
        print("-" * 60)

    # Method untuk mengambil data order dalam bentuk baris tabel.
    def get_table_row(self):
        # Mengambil nama customer jika tersedia.
        customer_name = (self.customer.get_name()
            if self.customer is not None
            else "-"
        )

        # Mengembalikan data order.
        return [self.order_id, self.order_date, customer_name, f"Rp{int(self.total)}"]