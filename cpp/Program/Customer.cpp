#include <iostream>
#include <string>
#include <vector>

using namespace std;

// Membuat class Customer
class Customer {

private:
    // ID pelanggan
    string customerId;
    // Nama pelanggan
    string name;
    // Nomor telepon
    string phone;

public:
    // ====================================================
    // CONSTRUCTOR KOSONG
    // ====================================================
    Customer() {
        customerId = "";
        name = "";
        phone = "";
    }

    // ====================================================
    // CONSTRUCTOR BERPATAMETER
    // ====================================================
    Customer(string id, string n, string p) {
        customerId = id;
        name = n;
        phone = p;
    }

    // ====================================================
    // GETTER CUSTOMER ID
    // ====================================================
    string getCustomerId() const {
        return customerId;
    }

    // ====================================================
    // SETTER CUSTOMER ID
    // ====================================================
    void setCustomerId(string customerId) {
        this->customerId = customerId;
    }

    // ====================================================
    // GETTER NAME
    // ====================================================
    string getName() const {
        return name;
    }

    // ====================================================
    // SETTER NAME
    // ====================================================
    void setName(string name) {
        this->name = name;
    }

    // ====================================================
    // GETTER PHONE
    // ====================================================
    string getPhone() const {
        return phone;
    }

    // ====================================================
    // SETTER PHONE
    // ====================================================
    void setPhone(string phone) {
        this->phone = phone;
    }

    // ====================================================
    // DISPLAY INFO
    // ====================================================
    void displayInfo() const {
        cout << "ID Pelanggan: " << customerId << " | Nama: " << name << " | Telepon: " << phone << endl;
    }

    // ====================================================
    // DATA UNTUK TABEL
    // ====================================================
    vector<string> getTableRow() const {
        return {
            customerId,
            name,
            phone
        };
    }
};