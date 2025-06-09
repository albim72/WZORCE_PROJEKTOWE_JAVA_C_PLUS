#include <iostream>
#include <string>

int main() {
    std::string name;
    int age;
    std::cout << "Podaj swoje imię: ";
    std:std::getline(std::cin, name);

    std::cout << "Ile masz lat?" << "\n";
    std::cin >> age;

    //wypisanie informacjii
    std::cout << "Witaj, " << name << "!" << std::endl;
    std::cout << age << std::endl;
    return 0;
}
