#include <iostream>
#include <string>
#include <stdexcept>
class Pizza {
    protected:
        std::string ciasto;
        std::string sos;
        std::string dodatki;
        //ctrl + D -> duplikacja linii lub bloku kodu
    public:
        virtual void showPizza() const {
            std::cout << "Pizza z " << ciasto << ", sosem " << sos << ", dodatkami: " << dodatki <<std::endl;
        }
};

class DeluxePizza: public Pizza {
    std::string extraSer;
    public:
        void setExtraSer(const std::string& ser) {
            extraSer = ser;
        }

    void showPizza() const override {
            Pizza::showPizza();
            std::cout << " + ekstra ser: " << extraSer << std::endl;
        }
};
