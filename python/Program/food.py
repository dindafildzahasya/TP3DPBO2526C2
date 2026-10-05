# Mengimpor class MenuItem dari file menu_item.py.
from menu_item import MenuItem

# Membuat class Food yang mewarisi class MenuItem.
# Ini merupakan child class kedua pada Hierarchical Inheritance.
class Food(MenuItem):

    # Constructor class Food.
    def __init__(self, id="", name="", price=0.0, category=""):
        # Memanggil constructor dari parent class MenuItem.
        super().__init__(id, name, price)
        # Menyimpan kategori makanan.
        self.category = category

    # Getter untuk mendapatkan kategori makanan.
    def get_category(self):
        # Mengembalikan kategori makanan.
        return self.category
    # Setter untuk mengubah kategori makanan.
    def set_category(self, category):
        # Mengubah atribut category.
        self.category = category

    # Override method display_info dari MenuItem.
    def display_info(self):
        # Menampilkan informasi khusus untuk makanan.
        print(f"[Makanan] " f"ID: {self.id} | " f"Nama: {self.name} | " f"Harga: Rp{int(self.price)} | " f"Kategori: {self.category}")

    # Override method get_table_row dari MenuItem.
    def get_table_row(self):
        # Mengembalikan data makanan dalam bentuk list.
        return [self.id, self.name, "Makanan", self.category, "-", f"Rp{int(self.price)}"]