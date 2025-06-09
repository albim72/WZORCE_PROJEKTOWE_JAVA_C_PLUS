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

        void set_ciasto(const std::string &ciasto) {
            this->ciasto = ciasto;
        }

        void set_sos(const std::string &sos) {
            this->sos = sos;
        }

        void set_dodatki(const std::string &dodatki) {
            this->dodatki = dodatki;
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

class PizzaBuilder {
    protected:
        std::string ciasto;
        std::string sos;
        std::string dodatki;
    public:
        virtual PizzaBuilder& setCiasto(const std::string& c) {
            ciasto = c;
            return *this;
        }
        virtual PizzaBuilder& setSos(const std::string& s) {
            sos = s;
            return *this;
        }
        virtual PizzaBuilder& setDodatki(const std::string& d) {
            dodatki = d;
            return *this;
        }
        virtual Pizza* build() {
            if (ciasto.empty() && sos.empty()) {
                throw std::runtime_error("PizzaBuilder: pizza musi mieć ciasto i sos!");
            }
            Pizza* p = new Pizza();
            p->set_ciasto(ciasto);
            p->set_sos(sos) ;
            p->set_dodatki(dodatki);
            return p;
        }
        virtual ~PizzaBuilder() = default;


};

class DeluxePizzaBuilder: public PizzaBuilder {
    private:
        std::string extraSer;
    public:
        DeluxePizzaBuilder& setExtraSer(const std::string& ser) {
            extraSer = ser;
            return *this;
        }
        Pizza* build() override {
            if (extraSer.empty()) {
                throw std::runtime_error("Pizza Deluxe musi mieć dodatkowy ser!");
            }
            DeluxePizza* p = new DeluxePizza();
            p->set_ciasto(ciasto);
            p->set_sos(sos);
            p->set_dodatki(dodatki);
            p->setExtraSer(extraSer);
            return p;
        }
};

int main() {
    try {
        DeluxePizzaBuilder builder;
        builder.setCiasto("grube")
            .setSos("pomidorowy")
            .setDodatki("szynka, pieczarki, cebula")
            .setExtraSer("parmezan");

        Pizza* pizza = builder.build();
        pizza->showPizza();
        delete pizza;
    } catch (std::exception& e) {
        std::cout << e.what() << std::endl;
    }
    return 0;
}
