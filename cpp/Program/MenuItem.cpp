#include <iostream>
#include <string>
#include <vector>

using namespace std;

// Membuat class MenuItem sebagai class induk
class MenuItem {

protected:
    // ID menu
    string id;
    // Nama menu
    string name;
    // Harga menu
    double price;

public:
    // ====================================================
    // CONSTRUCTOR KOSONG
    // ====================================================
    MenuItem() {
        id = "";
        name = "";
        price = 0.0;
    }

    // ====================================================
    // CONSTRUCTOR BERPATAMETER
    // ====================================================
    MenuItem(string id, string name, double price) {
        this->id = id;
        this->name = name;
        this->price = price;
    }

    // ====================================================
    // DESTRUCTOR
    // ====================================================
    virtual ~MenuItem() {
    }

    // ====================================================
    // GETTER DAN SETTER ID
    // ====================================================
    string getId() const {
        return id;
    }
    void setId(string id) {
        this->id = id;
    }

    // ====================================================
    // GETTER DAN SETTER NAME
    // ====================================================
    string getName() const {
        return name;
    }
    void setName(string name) {
        this->name = name;
    }

    // ====================================================
    // GETTER DAN SETTER PRICE
    // ====================================================
    double getPrice() const {
        return price;
    }
    void setPrice(double price) {
        this->price = price;
    }

    // ====================================================
    // DISPLAY INFO
    // ====================================================
    virtual void displayInfo() const {
        cout << "ID: " << id << " | Nama: " << name << " | Harga: Rp" << static_cast<int>(price);
    }

    // ====================================================
    // DATA UNTUK TABEL
    // ====================================================
    virtual vector<string> getTableRow() const {
        return {
            id, name, "Menu Item", "-", "-", "Rp" + to_string(static_cast<int>(price))
        };
    }
};