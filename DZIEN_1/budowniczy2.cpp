#include <iostream>
#include <string>
#include <stdexcept>

// === Klasa bazowa Pizza ===
class Pizza {
protected:
    std::string ciasto;
    std::string sos;
    std::string dodatki;

public:
    virtual void showPizza() const {
        std::cout << "Pizza z " << ciasto
                  << ", sosem " << sos
                  << ", dodatkami: " << dodatki << std::endl;
    }

    virtual ~Pizza() = default;

    void setCiasto(const std::string& s) { ciasto = s; }
    void setSos(const std::string& s) { sos = s; }
    void setDodatki(const std::string& d) { dodatki = d; }
};

// === Klasa pochodna DeluxePizza ===
class DeluxePizza : public Pizza {
private:
    std::string extraSer;

public:
    void setExtraSer(const std::string& ser) {
        extraSer = ser;
    }

    void showPizza() const override {
        Pizza::showPizza();
        std::cout << " + extra ser: " << extraSer << std::endl;
    }
};

// === Builder bazowy ===
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
        if (ciasto.empty() || sos.empty()) {
            throw std::runtime_error("Pizza musi mieć ciasto i sos.");
        }
        Pizza* p = new Pizza();
        p->setCiasto(ciasto);
        p->setSos(sos);
        p->setDodatki(dodatki);
        return p;
    }

    virtual ~PizzaBuilder() = default;
};

// === Builder deluxe ===
class DeluxePizzaBuilder : public PizzaBuilder {
private:
    std::string extraSer;

public:
    DeluxePizzaBuilder& setExtraSer(const std::string& ser) {
        extraSer = ser;
        return *this;
    }

    DeluxePizzaBuilder& setCiasto(const std::string& c) override {
        PizzaBuilder::setCiasto(c);
        return *this;
    }

    DeluxePizzaBuilder& setSos(const std::string& s) override {
        PizzaBuilder::setSos(s);
        return *this;
    }

    DeluxePizzaBuilder& setDodatki(const std::string& d) override {
        PizzaBuilder::setDodatki(d);
        return *this;
    }

    Pizza* build() override {
        if (ciasto.empty() || sos.empty() || extraSer.empty()) {
            throw std::runtime_error("DeluxePizza musi mieć ciasto, sos i extra ser.");
        }

        DeluxePizza* p = new DeluxePizza();
        p->setCiasto(ciasto);
        p->setSos(sos);
        p->setDodatki(dodatki);
        p->setExtraSer(extraSer);
        return p;
    }
};

// === main ===
int main() {
    try {
        DeluxePizzaBuilder builder;
        builder.setCiasto("grube")
               .setSos("czosnkowy")
               .setDodatki("salami, pieczarki")
               .setExtraSer("parmezan");

        Pizza* pizza = builder.build();
        pizza->showPizza();
        delete pizza;
    } catch (const std::exception& ex) {
        std::cerr << "Błąd: " << ex.what() << std::endl;
    }

    try {
        DeluxePizzaBuilder builder;
        builder.setCiasto("cienkie")
               .setSos("paprykowy")
               .setDodatki("salami, pieczarki, cebula")
               .setExtraSer("mozarella");

        Pizza* pizza = builder.build();
        pizza->showPizza();
        delete pizza;
    } catch (const std::exception& ex) {
        std::cerr << "Błąd: " << ex.what() << std::endl;
    }

    try {
        PizzaBuilder builder;
        builder.setCiasto("cienkie")
               .setSos("pomidorowy")
               .setDodatki("ser, cebula");

        Pizza* pizza = builder.build();
        pizza->showPizza();
        delete pizza;
    } catch (const std::exception& ex) {
        std::cerr << "Błąd: " << ex.what() << std::endl;
    }

    return 0;
}
