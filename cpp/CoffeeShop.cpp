#include <iostream>
#include <string>
#include <vector>
#include <iomanip>

#include "MenuItem.cpp"
#include "Beverage.cpp"
#include "Food.cpp"
#include "Order.cpp"

using namespace std;

class CoffeeShop {
private:
    // Nama coffee shop
    string shopName;
    // Lokasi coffee shop
    string location;
    // Menyimpan MenuItem dalam bentuk pointer
    vector<MenuItem*> menu;
    // Menyimpan daftar customer
    vector<Customer> customers;
    // Menyimpan daftar order
    vector<Order> orders;

public:
    // CONSTRUCTOR KOSONG
    CoffeeShop() {
        shopName = "";
        location = "";
    }

    // CONSTRUCTOR BERPATAMETER
    CoffeeShop(string name, string loc) {
        // Mengisi nama coffee shop
        shopName = name;
        // Mengisi lokasi
        location = loc;
    }

    // DESTRUCTOR
    ~CoffeeShop() {
        // Menghapus data order terlebih dahulu
        orders.clear();
        // Menghapus object menu
        for (auto item : menu) {
            delete item;
        }
        // Mengosongkan vector menu
        menu.clear();
    }

    // GETTER SHOP NAME
    string getShopName() const {
        return shopName;
    }
    // SETTER SHOP NAME
    void setShopName(string shopName) {
        this->shopName = shopName;
    }

    // GETTER LOCATION
    string getLocation() const {
        return location;
    }
    // SETTER LOCATION
    void setLocation(string location) {
        this->location = location;
    }

    // MENAMBAHKAN MENU
    void addMenuItem(MenuItem* item) {
        menu.push_back(item);
    }

    // MENAMBAHKAN CUSTOMER
    void addCustomer(const Customer& customer) {
        customers.push_back(customer);
    }

    // MENAMBAHKAN ORDER
    void addOrder(const Order& order) {
        orders.push_back(order);
    }

    // MENAMPILKAN SELURUH DATA
    void displayAllData() const {
        cout << endl;
        cout << "==========================================================" << endl;
        cout << "INFO COFFEE SHOP : " << shopName << endl;
        cout << "Lokasi           : " << location << endl;
        cout << "==========================================================" << endl;

        // ==================================================
        // DAFTAR MENU
        // ==================================================
        cout << endl;
        cout << "--- DAFTAR MENU KAFE ---" << endl;

        if (menu.empty()) {
            cout << "(Belum ada menu tersedia)" << endl;
        } else {
            vector<string> header = {
                "ID",
                "Nama Menu",
                "Jenis",
                "Ukuran",
                "Keterangan",
                "Harga"
            };

            vector<vector<string>> data;
            for (const auto& item : menu) {
                data.push_back(item->getTableRow());
            }
            tampilkanTabel(header, data);
        }

        // DAFTAR CUSTOMER
        cout << endl;
        cout << "--- DAFTAR PELANGGAN ---" << endl;

        if (customers.empty()) {
            cout << "(Belum ada pelanggan terdaftar)" << endl;
        } else {
            vector<string> header = {
                "ID Pelanggan",
                "Nama",
                "Telepon"
            };

            vector<vector<string>> data;
            for (const auto& customer : customers) {
                data.push_back(customer.getTableRow());
            }
            tampilkanTabel(header, data);
        }

        // ==================================================
        // DAFTAR ORDER
        // ==================================================
        cout << endl;
        cout << "--- DAFTAR TRANSAKSI PESANAN ---" << endl;

        if (orders.empty()) {
            cout << "(Belum ada pesanan)" << endl;
        } else {
            vector<string> header = {
                "Order ID",
                "Tanggal",
                "Customer",
                "Total Harga"
            };

            vector<vector<string>> data;
            for (const auto& order : orders) {
                data.push_back(order.getTableRow());
            }
            tampilkanTabel(header, data);

            // Menampilkan detail masing-masing order
            cout << endl;
            for (size_t i = 0; i < orders.size(); ++i) {
                cout << "DETAIL PESANAN " << i + 1 << endl;
                orders[i].displayOrder();
                cout << endl;
            }
        }
    }
};