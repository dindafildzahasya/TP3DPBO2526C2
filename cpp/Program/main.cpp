#include <iostream>

#include "CoffeeShop.cpp"

using namespace std;

// Fungsi utama program
int main() {
    // MEMBUAT OBJECT COFFEE SHOP
    CoffeeShop myCoffeeShop("Senja Coffee & Space", "Jl. Ir. H. Djuanda No. 100, Bandung");

    // KONDISI AWAL
    cout << endl;
    cout << "=== KONDISI COFFEE SHOP SEBELUM DATA DITAMBAHKAN ===" << endl;

    myCoffeeShop.displayAllData();

    // DATA TAHAP PERTAMA=
    MenuItem* kopi1 = new Beverage("B001", "Caffe Latte", 28000, "Medium", "Hot");
    MenuItem* makanan1 = new Food("F001", "Croissant Butter", 22000, "Pastry");
    Customer cust1("C050", "Budi Santoso", "081234567890");

    // MENAMBAHKAN DATA TAHAP PERTAMA
    myCoffeeShop.addMenuItem(kopi1);
    myCoffeeShop.addMenuItem(makanan1);
    myCoffeeShop.addCustomer(cust1);

    // ORDER PERTAMA
    Order order1("ORD-001", "2026-10-03", cust1);
    order1.addItem(kopi1, 2);
    myCoffeeShop.addOrder(order1);

    // KONDISI SETELAH TAHAP 1
    cout << endl;
    cout << "=== KONDISI SETELAH DATA TAHAP 1 DITAMBAHKAN ===" << endl;
    myCoffeeShop.displayAllData();

    // DATA TAHAP KEDUA
    cout << endl;
    cout << ">>> MENAMBAHKAN DATA TAHAP 2 <<<" << endl;

    MenuItem* kopi2 = new Beverage("B002", "Americano Ice", 25000, "Large", "Iced");
    MenuItem* makanan2 = new Food("F002", "Spaghetti Carbonara", 45000, "Main Course");
    Customer cust2("C051", "Siti Rahma", "089876543210");

    // MENAMBAHKAN DATA TAHAP KEDUA
    myCoffeeShop.addMenuItem(kopi2);
    myCoffeeShop.addMenuItem(makanan2);
    myCoffeeShop.addCustomer(cust2);

    // ORDER KEDUA
    Order order2("ORD-002", "2026-10-03", cust2);
    order2.addItem(kopi2, 1);
    order2.addItem(makanan2, 1);
    myCoffeeShop.addOrder(order2);

    // KONDISI AKHIR
    cout << endl;
    cout << "=== KONDISI COFFEE SHOP SETELAH DATA TAHAP 2 DITAMBAHKAN ===" << endl;
    myCoffeeShop.displayAllData();

    return 0;
}