# Membuat class MenuItem sebagai class induk untuk semua item menu.
class MenuItem:

    # Constructor class MenuItem.
    # Parameter diberi nilai default agar constructor ini
    # dapat digunakan seperti constructor kosong maupun berparameter.
    def __init__(self, id="", name="", price=0.0):
        # Menyimpan ID menu ke dalam atribut id.
        self.id = id
        # Menyimpan nama menu ke dalam atribut name.
        self.name = name
        # Menyimpan harga menu ke dalam atribut price.
        self.price = price

    # Getter untuk mendapatkan ID menu.
    def get_id(self):
        # Mengembalikan nilai ID menu.
        return self.id

    # Setter untuk mengubah ID menu.
    def set_id(self, id):
        # Mengubah atribut id dengan nilai yang diberikan.
        self.id = id

    # Getter untuk mendapatkan nama menu.
    def get_name(self):
        # Mengembalikan nama menu.
        return self.name

    # Setter untuk mengubah nama menu.
    def set_name(self, name):
        # Mengubah atribut name.
        self.name = name

    # Getter untuk mendapatkan harga menu.
    def get_price(self):
        # Mengembalikan harga menu.
        return self.price

    # Setter untuk mengubah harga menu.
    def set_price(self, price):
        # Mengubah atribut price.
        self.price = price

    # Method display_info digunakan untuk menampilkan informasi menu.
    # Method ini dapat dioverride oleh class turunan.
    def display_info(self):
        # Menampilkan informasi dasar menu.
        print(f"ID: {self.id} | " f"Nama: {self.name} | " f"Harga: Rp{int(self.price)}")

    # Method get_table_row digunakan untuk mengambil data
    # dalam bentuk list agar mudah dimasukkan ke tabel.
    def get_table_row(self):
        # Mengembalikan satu baris data menu.
        return [self.id, self.name, "Menu Item", "-", "-", f"Rp{int(self.price)}"]