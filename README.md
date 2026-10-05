# Coffee Shop Management System

## a. Janji

Saya Adinda Fildzah Hasya dengan NIM 2501218 mengerjakan Tugas Praktikum 2 dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

---

## Deskripsi Program

**Coffee Shop Management System** digunakan untuk mengelola data sederhana pada sebuah coffee shop, yaitu:

- Data menu makanan dan minuman
- Data pelanggan
- Data pesanan
- Detail item pada setiap pesanan
- Perhitungan subtotal dan total pembayaran

Data awal ditentukan langsung di dalam source code (**penambahan data statis**), kemudian dimasukkan ke dalam collection yang dapat bertambah selama program berjalan.

Program menampilkan **kondisi sebelum penambahan data** dan **kondisi setelah penambahan data** sehingga perubahan data dapat terlihat dengan jelas.

---

# b. Desain Diagram Program

Class diagram yang digunakan dalam program:

<img width="1057" height="742" alt="Desain_Diagram" src="https://github.com/user-attachments/assets/78882095-12d7-4ead-9edc-8034bd51e6e5" />


### Struktur hubungan utama

```text
                         MenuItem
                        /        \
                       /          \
                Beverage          Food
                       \
                    Hierarchical
                     Inheritance

Customer ─────────── Order
                       │
                       ◆
                       │ Composition
                       ▼
                   OrderItem
                       │
                       │ Association
                       ▼
                    MenuItem

                 CoffeeShop
                /    |     \
               /     |      \
              ▼      ▼       ▼
          MenuItem Customer Order
```

### Keterangan hubungan

- **Hierarchical Inheritance:** `MenuItem` menjadi parent class dari `Beverage` dan `Food`.
- **Composition:** `Order` memiliki kumpulan `OrderItem`.
- **Association:** `OrderItem` menggunakan/menyimpan referensi terhadap `MenuItem`, sedangkan `Customer` berhubungan dengan `Order`.
- **Array of Object:** `CoffeeShop` menyimpan kumpulan object menu, customer, dan order menggunakan collection.

---

# c. Atribut dan Methods Setiap Class

## 1. MenuItem

Class dasar/parent untuk semua item menu.

### Atribut

| Atribut | Tipe | Keterangan |
|---|---|---|
| `id` | `string` / `String` | ID unik menu |
| `name` | `string` / `String` | Nama menu |
| `price` | `double` | Harga menu |

### Methods utama

| Method | Fungsi |
|---|---|
| `displayInfo()` | Menampilkan informasi dasar menu |
| `getTableRow()` | Mengambil data object untuk ditampilkan dalam tabel |
| `getId()` / `setId()` | Mengambil dan mengubah ID |
| `getName()` / `setName()` | Mengambil dan mengubah nama |
| `getPrice()` / `setPrice()` | Mengambil dan mengubah harga |

---

## 2. Beverage

Class turunan dari `MenuItem` untuk menu minuman.

### Atribut tambahan

| Atribut | Tipe | Keterangan |
|---|---|---|
| `size` | `string` / `String` | Ukuran minuman, misalnya Medium atau Large |
| `temperature` | `string` / `String` | Suhu minuman, misalnya Hot atau Iced |

### Methods utama

| Method | Fungsi |
|---|---|
| `displayInfo()` | Override untuk menampilkan informasi minuman |
| `getTableRow()` | Override untuk membentuk data tabel minuman |
| `getSize()` / `setSize()` | Mengambil dan mengubah ukuran |
| `getTemperature()` / `setTemperature()` | Mengambil dan mengubah suhu |

---

## 3. Food

Class turunan dari `MenuItem` untuk menu makanan.

### Atribut tambahan

| Atribut | Tipe | Keterangan |
|---|---|---|
| `category` | `string` / `String` | Kategori makanan, misalnya Pastry atau Main Course |

### Methods utama

| Method | Fungsi |
|---|---|
| `displayInfo()` | Override untuk menampilkan informasi makanan |
| `getTableRow()` | Override untuk membentuk data tabel makanan |
| `getCategory()` / `setCategory()` | Mengambil dan mengubah kategori |

---

## 4. Customer

Class yang merepresentasikan pelanggan coffee shop.

### Atribut

| Atribut | Tipe | Keterangan |
|---|---|---|
| `customerId` | `string` / `String` | ID pelanggan |
| `name` | `string` / `String` | Nama pelanggan |
| `phone` | `string` / `String` | Nomor telepon pelanggan |

### Methods utama

| Method | Fungsi |
|---|---|
| `displayInfo()` | Menampilkan informasi pelanggan |
| `getTableRow()` | Mengambil data pelanggan untuk tabel |
| Getter/Setter | Mengambil dan mengubah atribut customer |

---

## 5. OrderItem

Class yang merepresentasikan satu jenis item dalam sebuah pesanan.

### Atribut

| Atribut | Tipe | Keterangan |
|---|---|---|
| `menuItem` | `MenuItem*` / `MenuItem` | Menu yang dipesan |
| `quantity` | `int` | Jumlah item yang dipesan |
| `subtotal` | `double` | Harga item dikalikan jumlah |

### Methods utama

| Method | Fungsi |
|---|---|
| `calculateSubTotal()` | Menghitung subtotal item |
| `displayInfo()` | Menampilkan detail item |
| `getTableRow()` | Mengambil data item untuk tabel |
| `getSubtotal()` | Mengambil subtotal |
| Getter/Setter | Mengambil dan mengubah data item |

---

## 6. Order

Class yang merepresentasikan sebuah transaksi/pesanan.

### Atribut

| Atribut | Tipe | Keterangan |
|---|---|---|
| `orderId` | `string` / `String` | ID pesanan |
| `orderDate` | `string` / `String` | Tanggal pesanan |
| `customer` | `Customer` | Customer yang melakukan pesanan |
| `items` | `vector<OrderItem>` / `ArrayList<OrderItem>` / `list` | Kumpulan item pesanan |
| `total` | `double` | Total pembayaran |

### Methods utama

| Method | Fungsi |
|---|---|
| `addItem()` | Menambahkan item ke pesanan |
| `calculateTotal()` | Menghitung total semua item |
| `displayOrder()` | Menampilkan detail transaksi |
| `getTableRow()` | Mengambil data order untuk tabel |
| Getter/Setter | Mengambil dan mengubah data order |

---

## 7. CoffeeShop

Class utama yang mengelola keseluruhan data coffee shop.

### Atribut

| Atribut | Tipe | Keterangan |
|---|---|---|
| `shopName` | `string` / `String` | Nama coffee shop |
| `location` | `string` / `String` | Lokasi coffee shop |
| `menu` | `vector<MenuItem*>` / `ArrayList<MenuItem>` / `list` | Kumpulan menu |
| `customers` | `vector<Customer>` / `ArrayList<Customer>` / `list` | Kumpulan customer |
| `orders` | `vector<Order>` / `ArrayList<Order>` / `list` | Kumpulan order |

### Methods utama

| Method | Fungsi |
|---|---|
| `addMenuItem()` | Menambahkan menu |
| `addCustomer()` | Menambahkan customer |
| `addOrder()` | Menambahkan order |
| `displayAllData()` | Menampilkan seluruh data coffee shop |
| Getter/Setter | Mengambil dan mengubah informasi coffee shop |

---

# d. Penjelasan Desain Program

## 1. Hierarchical Inheritance

Konsep **Hierarchical Inheritance** digunakan pada class `MenuItem`.

```text
             MenuItem
             /      \
            /        \
       Beverage      Food
```

`MenuItem` berisi atribut umum seperti ID, nama, dan harga. `Beverage` dan `Food` mewarisi atribut tersebut lalu menambahkan atribut khusus masing-masing.

Contoh:

- `Beverage` menambahkan `size` dan `temperature`.
- `Food` menambahkan `category`.

Dengan cara ini, program tidak perlu mendefinisikan kembali atribut dasar yang sama pada setiap jenis menu.

Selain inheritance, implementasi menggunakan **polymorphism**. Method `displayInfo()` dan `getTableRow()` pada `Beverage` dan `Food` meng-override method pada `MenuItem`.

---

## 2. Composition

Konsep **Composition** digunakan antara `Order` dan `OrderItem`.

```text
Order ◆────── OrderItem
```

Sebuah `Order` terdiri dari satu atau beberapa `OrderItem`. Setiap `OrderItem` menyimpan menu yang dipesan, jumlah, dan subtotal.

Contoh:

```text
ORD-002
├── Americano Ice × 1
└── Spaghetti Carbonara × 1
```

Pada program, konsep ini direpresentasikan dengan collection `items` di dalam class `Order`.

C++:

```cpp
vector<OrderItem> items;
```

Python:

```python
self.items = []
```

Java:

```java
ArrayList<OrderItem> items;
```

---

## 3. Array of Object

Program menggunakan collection untuk menyimpan banyak object.

### C++

```cpp
vector<MenuItem*> menu;
vector<Customer> customers;
vector<Order> orders;
```

### Python

```python
self.menu = []
self.customers = []
self.orders = []
```

### Java

```java
ArrayList<MenuItem> menu;
ArrayList<Customer> customers;
ArrayList<Order> orders;
```

Collection tersebut memungkinkan data bertambah selama program berjalan.

---

## 4. Penambahan Data

Penambahan data dilakukan secara **statis pada source code**. Artinya, data baru sudah ditentukan oleh programmer di dalam `main` / `main.py` dan kemudian dimasukkan ke collection menggunakan method penambahan data.

Contoh konsep:

```text
Data awal
   ↓
Ditampilkan
   ↓
Object baru dibuat
   ↓
addMenuItem() / addCustomer() / addOrder()
   ↓
Data ditampilkan kembali
```

Walaupun inputnya statis, collection yang digunakan bersifat dinamis karena ukurannya dapat bertambah selama program berjalan.

---

# e. Penjelasan Alur Program

Alur berikut berlaku untuk **C++, Python, dan Java** karena ketiganya menggunakan desain class yang sama.

```text
START
  │
  ▼
Membuat object CoffeeShop
  │
  ▼
Menampilkan kondisi awal
  │
  ├── Menu kosong
  ├── Customer kosong
  └── Order kosong
  │
  ▼
Membuat data tahap pertama
  │
  ├── Beverage
  ├── Food
  └── Customer
  │
  ▼
Menambahkan data ke CoffeeShop
  │
  ▼
Membuat Order
  │
  ▼
Membuat OrderItem
  │
  ▼
Menambahkan Order ke CoffeeShop
  │
  ▼
Menampilkan data setelah tahap pertama
  │
  ▼
Membuat data tahap kedua
  │
  ▼
Menambahkan data baru
  │
  ▼
Membuat Order kedua
  │
  ▼
Menampilkan seluruh data setelah tahap kedua
  │
  ▼
END
```

## Contoh perubahan data

### Sebelum penambahan

```text
Menu      : 0
Customer  : 0
Order     : 0
```

### Setelah tahap pertama

```text
Menu      : 2
Customer  : 1
Order     : 1
```

### Setelah tahap kedua

```text
Menu      : 4
Customer  : 2
Order     : 2
```

---

# f. Dokumentasi

Dokumentasi berisi screenshot/screenrecord hasil eksekusi program untuk setiap bahasa.

## C++



File program:

```text
CPP/Program/
├── main.cpp
├── MenuItem.cpp
├── Beverage.cpp
├── Food.cpp
├── Customer.cpp
├── OrderItem.cpp
├── Order.cpp
└── CoffeeShop.cpp
```

## Python

![Dokumentasi Python](Python/Dokumentasi/screenshot_python.png)

File program:

```text
Python/Program/
├── main.py
├── menu_item.py
├── beverage.py
├── food.py
├── customer.py
├── order_item.py
├── order.py
└── coffee_shop.py
```

## Java — Bonus

![Dokumentasi Java](Java/Dokumentasi/screenshot_java.png)

File program:

```text
Java/Program/
├── Main.java
├── MenuItem.java
├── Beverage.java
├── Food.java
├── Customer.java
├── OrderItem.java
├── Order.java
└── CoffeeShop.java
```

> **Catatan:** Ganti nama file screenshot di atas dengan nama file dokumentasi yang benar-benar kamu masukkan ke repository.

---
