#include <iostream> //do wypisywana na ekran
#include <mutex> //do synchronizacjii wielowoątkowej

class Singleton {

private:
    static Singleton* instance; //wskaźnik do jednej instancji singletona
    static std::mutex mutex; //bezpieczny dotęp do wielu wątków

    //konstruktor prywatny
    Singleton() {
        std::cout << "Singleton constructor" << std::endl;
    }
    //zabronienie kopiowania
    Singleton(const Singleton&) = delete;
    Singleton& operator=(const Singleton&) = delete;

public:
    static Singleton* getInstance() {
        std::lock_guard<std::mutex> lock(mutex);
        if (instance == nullptr) {
            instance = new Singleton();
        }
        return instance;
    }

    void doSomething() {
        std::cout << "Singleton doSomething" << std::endl;
    }
};

//inicjalizacja pól statycznych
Singleton* Singleton::instance = nullptr;
std::mutex Singleton::mutex;
int main() {
    Singleton* s1 = Singleton::getInstance();
    s1->doSomething();

    Singleton* s2 = Singleton::getInstance();
    s2->doSomething();
    if (s1 ==s2) {
        std::cout << "ta sama instancja" << std::endl;
    }
    else {
        std::cout << "rożne instancje" << std::endl;
    }
    return 0;
}
