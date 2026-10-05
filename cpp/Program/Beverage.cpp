#include <iostream>
#include <string>
#include <vector>

using namespace std;

// Class Beverage mewarisi MenuItem
class Beverage : public MenuItem {

private:
    // Ukuran minuman
    string size;
    // Suhu minuman
    string temperature;

public:
    // ====================================================
    // CONSTRUCTOR KOSONG
    // ====================================================
    Beverage() : MenuItem() {
        size = "";
        temperature = "";
    }

    // ====================================================
    // CONSTRUCTOR BERPATAMETER
    // ====================================================
    Beverage(string id, string name, double price, string size, string temperature) : 
    MenuItem(id, name, price) {
        this->size = size;
        this->temperature = temperature;
    }

    // ====================================================
    // GETTER DAN SETTER SIZE
    // ====================================================
    string getSize() const {
        return size;
    }
    void setSize(string size) {
        this->size = size;
    }

    // ====================================================
    // GETTER DAN SETTER TEMPERATURE
    // ====================================================
    string getTemperature() const {
        return temperature;
    }
    void setTemperature(string temperature) {
        this->temperature = temperature;
    }

    // ====================================================
    // OVERRIDE DISPLAY INFO
    // ====================================================
    void displayInfo() const override {
        cout
            << "[Minuman] "
            << "ID: " << id
            << " | Nama: " << name
            << " | Harga: Rp"
            << static_cast<int>(price)
            << " | Ukuran: " << size
            << " | Suhu: " << temperature
            << endl;
    }

    // ====================================================
    // DATA UNTUK TABEL
    // ====================================================
    vector<string> getTableRow() const override {
        return {
            id,
            name,
            "Minuman",
            size,
            temperature,
            "Rp" +
            to_string(static_cast<int>(price))
        };
    }
};