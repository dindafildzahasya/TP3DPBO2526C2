# Mengimpor class MenuItem karena OrderItem menggunakan object MenuItem.
from menu_item import MenuItem

# Membuat class OrderItem.
class OrderItem:

    # Constructor class OrderItem.
    def __init__(self, menu_item=None, quantity=0):
        # Menyimpan object MenuItem yang dipesan.
        self.menu_item = menu_item
        # Menyimpan jumlah item yang dipesan.
        self.quantity = quantity
        # Menghitung subtotal berdasarkan harga dan jumlah.
        self.subtotal = self.calculate_sub_total()

    # Getter untuk mendapatkan object MenuItem.
    def get_menu_item(self):
        # Mengembalikan object MenuItem.
        return self.menu_item
    # Setter untuk mengubah MenuItem.
    def set_menu_item(self, menu_item):
        # Mengubah object MenuItem.
        self.menu_item = menu_item
        # Menghitung ulang subtotal.
        self.subtotal = self.calculate_sub_total()

    # Getter untuk mendapatkan quantity.
    def get_quantity(self):
        # Mengembalikan jumlah item.
        return self.quantity
    # Setter untuk mengubah quantity.
    def set_quantity(self, quantity):
        # Mengubah jumlah item.
        self.quantity = quantity
        # Menghitung ulang subtotal.
        self.subtotal = self.calculate_sub_total()

    # Getter untuk mendapatkan subtotal.
    def get_subtotal(self):
        # Mengembalikan nilai subtotal.
        return self.subtotal

    # Method untuk menghitung subtotal.
    def calculate_sub_total(self):
        # Memeriksa apakah menu_item tidak kosong.
        if self.menu_item is not None:
            # Mengalikan harga menu dengan jumlah yang dipesan.
            return (self.menu_item.get_price() * self.quantity)
        # Mengembalikan nol jika tidak ada menu.
        return 0.0

    # Method untuk menampilkan detail OrderItem.
    def display_info(self):
        # Memeriksa apakah menu_item tersedia.
        if self.menu_item is not None:
            # Menampilkan nama, jumlah, dan subtotal.
            print(f"{self.menu_item.get_name()} " f"x {self.quantity} " f"= Rp{int(self.subtotal)}")

    # Method untuk mengambil data sebagai baris tabel.
    def get_table_row(self):
        # Memeriksa apakah menu_item tersedia.
        if self.menu_item is not None:
            # Mengembalikan data OrderItem.
            return [self.menu_item.get_name(), str(self.quantity), f"Rp{int(self.menu_item.get_price())}", f"Rp{int(self.subtotal)}"]

        # Mengembalikan data kosong jika menu tidak tersedia.
        return ["-", "0", "Rp0", "Rp0"]