#include <iostream>
#include <string>
#include <vector>

using namespace std;

// Membuat class OrderItem
class OrderItem {

private:
    // Menyimpan pointer menu
    MenuItem* menuItem;
    // Jumlah item
    int quantity;
    // Subtotal item
    double subtotal;

public:
    // ====================================================
    // CONSTRUCTOR KOSONG
    // ====================================================
    OrderItem() {
        menuItem = nullptr;
        quantity = 0;
        subtotal = 0.0;
    }

    // ====================================================
    // CONSTRUCTOR BERPATAMETER
    // ====================================================
    OrderItem(MenuItem* item, int quantity) {
        menuItem = item;
        this->quantity = quantity;
        subtotal = calculateSubTotal();
    }

    // ====================================================
    // GETTER MENU ITEM
    // ====================================================
    MenuItem* getMenuItem() const {
        return menuItem;
    }

    // ====================================================
    // SETTER MENU ITEM
    // ====================================================
    void setMenuItem(MenuItem* menuItem) {
        this->menuItem = menuItem;
        subtotal = calculateSubTotal();
    }

    // ====================================================
    // GETTER QUANTITY
    // ====================================================
    int getQuantity() const {
        return quantity;
    }
    // ====================================================
    // SETTER QUANTITY
    // ====================================================
    void setQuantity(int quantity) {
        this->quantity = quantity;
        subtotal = calculateSubTotal();
    }

    // ====================================================
    // GETTER SUBTOTAL
    // ====================================================
    double getSubtotal() const {
        return subtotal;
    }

    // ====================================================
    // MENGHITUNG SUBTOTAL
    // ====================================================
    double calculateSubTotal() const {
        if (menuItem != nullptr) {
            return
                menuItem->getPrice()
                * quantity;
        }
        return 0.0;
    }

    // ====================================================
    // DISPLAY INFO
    // ====================================================
    void displayInfo() const {
        if (menuItem != nullptr) {
            cout
                << menuItem->getName()
                << " x "
                << quantity
                << " = Rp"
                << static_cast<int>(subtotal)
                << endl;
        }
    }

    // ====================================================
    // DATA UNTUK TABEL
    // ====================================================
    vector<string> getTableRow() const {
        if (menuItem != nullptr) {
            return {
                menuItem->getName(),
                to_string(quantity),
                "Rp" + to_string(static_cast<int>( menuItem->getPrice())),
                "Rp" + to_string(static_cast<int>(subtotal))
            };
        }

        return {
            "-",
            "0",
            "Rp0",
            "Rp0"
        };
    }
};