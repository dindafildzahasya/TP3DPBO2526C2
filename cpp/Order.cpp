#include <iostream>
#include <string>
#include <vector>
#include <iomanip>

#include "Customer.cpp"
#include "OrderItem.cpp"

using namespace std;

// ========================================================
// FUNGSI MENAMPILKAN TABEL DINAMIS
// ========================================================

void tampilkanTabel(const vector<string>& header, const vector<vector<string>>& data) {
    // Menyimpan panjang setiap kolom
    vector<int> panjangKolom;
    // Menentukan panjang awal berdasarkan header
    for (const auto& judul : header) {
        panjangKolom.push_back(static_cast<int>(judul.length()));
    }

    // Mencari isi terpanjang pada setiap kolom
    for (const auto& baris : data) {
        for (size_t i = 0; i < baris.size(); ++i) {
            if (static_cast<int>(baris[i].length()) > panjangKolom[i]) {
                panjangKolom[i] = static_cast<int>(baris[i].length());
            }
        }
    }

    // Membuat garis tabel
    string garis = "+";
    for (int panjang : panjangKolom) {
        garis += string(panjang + 2, '-');
        garis += "+";
    }

    // Menampilkan header
    cout << garis << endl;
    cout << "|";

    for (size_t i = 0; i < header.size(); ++i) {
        cout << " " << left << setw(panjangKolom[i]) << header[i] << " |";
    }

    cout << endl;
    cout << garis << endl;

    // Menampilkan data
    for (const auto& baris : data) {
        cout << "|";
        for (size_t i = 0; i < header.size(); ++i) {
            string isi = "";
            if (i < baris.size()) {
                isi = baris[i];
            }
            cout << " " << left << setw(panjangKolom[i]) << isi << " |";
        }
        cout << endl;
    }
    // Garis bawah
    cout << garis << endl;
}

// ========================================================
// CLASS ORDER
// ========================================================

class Order {
private:
    // ID unik pesanan
    string orderId;
    // Tanggal pesanan
    string orderDate;
    // Customer yang melakukan pesanan
    Customer customer;
    // Order memiliki kumpulan OrderItem
    vector<OrderItem> items;
    // Total pembayaran
    double total;

public:
    // CONSTRUCTOR KOSONG
    Order() {
        orderId = "";
        orderDate = "";
        customer = Customer();
        total = 0.0;
    }

    // CONSTRUCTOR BERPATAMETER
    Order(string id, string date, Customer cust) {
        orderId = id;
        orderDate = date;
        customer = cust;
        total = 0.0;
    }

    // GETTER ORDER ID
    string getOrderId() const {
        return orderId;
    }
    // SETTER ORDER ID
    void setOrderId(string orderId) {
        this->orderId = orderId;
    }

    // GETTER ORDER DATE
    string getOrderDate() const {
        return orderDate;
    }
    // SETTER ORDER DATE
    void setOrderDate(string orderDate) {
        this->orderDate = orderDate;
    }

    // GETTER CUSTOMER
    Customer getCustomer() const {
        return customer;
    }
    // SETTER CUSTOMER
    void setCustomer(Customer customer) {
        this->customer = customer;
    }

    // GETTER TOTAL
    double getTotal() const {
        return total;
    }

    void addItem(MenuItem* item, int quantity) {
        // Membuat object OrderItem
        OrderItem orderItem(item, quantity);
        // Memasukkan object ke vector
        items.push_back(orderItem);
        // Menghitung ulang total
        calculateTotal();
    }

    double calculateTotal() {
        // Mengosongkan total terlebih dahulu
        total = 0.0;
        // Menjumlahkan seluruh subtotal
        for (const auto& item : items) {
            total += item.getSubtotal();
        }
        // Mengembalikan total
        return total;
    }

    void displayOrder() const {
        cout << "ID Pesanan : " << orderId << endl;
        cout << "Tanggal    : " << orderDate << endl;
        cout << "Pelanggan  : " << customer.getName() << endl;
        cout << endl;

        // Header tabel
        vector<string> header = {
            "Menu",
            "Quantity",
            "Harga",
            "Subtotal"
        };

        // Data tabel
        vector<vector<string>> data;

        // Mengambil semua OrderItem
        for (const auto& item : items) {
            data.push_back(item.getTableRow());
        }
        // Menampilkan tabel
        tampilkanTabel(header, data);

        cout << "Total Pembayaran : Rp" << static_cast<int>(total) << endl;
        cout << "--------------------------------------------------" << endl;
    }

    vector<string> getTableRow() const {
        return {
            orderId,
            orderDate,
            customer.getName(),
            "Rp" + to_string(static_cast<int>(total))
        };
    }
};