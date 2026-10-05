#include <iostream>
#include <string>
#include <vector>

using namespace std;

// Class Food mewarisi MenuItem
class Food : public MenuItem {

private:
    // Kategori makanan
    string category;

public:
    // ====================================================
    // CONSTRUCTOR KOSONG
    // ====================================================
    Food() : MenuItem() {
        category = "";
    }

    // ====================================================
    // CONSTRUCTOR BERPATAMETER
    // ====================================================
    Food(string id, string name, double price, string category) : MenuItem(id, name, price) {
        this->category = category;
    }

    // ====================================================
    // GETTER DAN SETTER CATEGORY
    // ====================================================
    string getCategory() const {
        return category;
    }
    void setCategory(string category) {
        this->category = category;
    }

    // ====================================================
    // OVERRIDE DISPLAY INFO
    // ====================================================
    void displayInfo() const override {
        cout
            << "[Makanan] "
            << "ID: " << id
            << " | Nama: " << name
            << " | Harga: Rp"
            << static_cast<int>(price)
            << " | Kategori: " << category
            << endl;
    }

    // ====================================================
    // DATA UNTUK TABEL
    // ====================================================
    vector<string> getTableRow() const override {
        return {
            id, name, "Makanan", category, "-", "Rp" + to_string(static_cast<int>(price))
        };
    }
};