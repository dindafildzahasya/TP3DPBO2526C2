# Mengimpor class MenuItem dari file menu_item.py.
from menu_item import MenuItem

# Membuat class Beverage yang mewarisi class MenuItem.
# Ini merupakan bagian dari Hierarchical Inheritance.
class Beverage(MenuItem):

    # Constructor class Beverage.
    def __init__(self, id="", name="", price=0.0, size="", temperature=""):
        # Memanggil constructor dari parent class MenuItem.
        super().__init__(id, name, price)
        # Menyimpan ukuran minuman.
        self.size = size
        # Menyimpan suhu minuman.
        self.temperature = temperature

    # Getter untuk mendapatkan ukuran minuman.
    def get_size(self):
        # Mengembalikan ukuran minuman.
        return self.size
    # Setter untuk mengubah ukuran minuman.
    def set_size(self, size):
        # Mengubah atribut size.
        self.size = size

    # Getter untuk mendapatkan suhu minuman.
    def get_temperature(self):
        # Mengembalikan suhu minuman.
        return self.temperature
    # Setter untuk mengubah suhu minuman.
    def set_temperature(self, temperature):
        # Mengubah atribut temperature.
        self.temperature = temperature

    # Override method display_info milik MenuItem.
    def display_info(self):
        # Menampilkan informasi khusus untuk minuman.
        print(f"[Minuman] " f"ID: {self.id} | " f"Nama: {self.name} | " f"Harga: Rp{int(self.price)} | " f"Ukuran: {self.size} | " f"Suhu: {self.temperature}")

    # Override method get_table_row milik MenuItem.
    def get_table_row(self):
        # Mengembalikan data minuman dalam bentuk list.
        return [self.id, self.name, "Minuman", self.size, self.temperature, f"Rp{int(self.price)}"]