# Membuat class Customer untuk menyimpan data pelanggan.
class Customer:

    # Constructor class Customer.
    # Nilai default digunakan agar dapat membuat object kosong.
    def __init__(self, customer_id="", name="", phone=""):
        # Menyimpan ID pelanggan.
        self.customer_id = customer_id
        # Menyimpan nama pelanggan.
        self.name = name
        # Menyimpan nomor telepon pelanggan.
        self.phone = phone

    # Getter untuk mendapatkan ID pelanggan.
    def get_customer_id(self):
        # Mengembalikan ID pelanggan.
        return self.customer_id
    # Setter untuk mengubah ID pelanggan.
    def set_customer_id(self, customer_id):
        # Mengubah atribut customer_id.
        self.customer_id = customer_id

    # Getter untuk mendapatkan nama pelanggan.
    def get_name(self):
        # Mengembalikan nama pelanggan.
        return self.name
    # Setter untuk mengubah nama pelanggan.
    def set_name(self, name):
        # Mengubah atribut name.
        self.name = name

    # Getter untuk mendapatkan nomor telepon.
    def get_phone(self):
        # Mengembalikan nomor telepon.
        return self.phone
    # Setter untuk mengubah nomor telepon.
    def set_phone(self, phone):
        # Mengubah atribut phone.
        self.phone = phone

    # Method untuk menampilkan informasi pelanggan.
    def display_info(self):
        # Menampilkan seluruh data pelanggan.
        print(f"ID Pelanggan: {self.customer_id} | " f"Nama: {self.name} | " f"Telepon: {self.phone}")

    # Method untuk mengambil data pelanggan sebagai baris tabel.
    def get_table_row(self):
        # Mengembalikan data pelanggan dalam bentuk list.
        return [self.customer_id, self.name,self.phone]