cmake_minimum_required(VERSION 3.10)
project(pogodynka_cpp)

set(CMAKE_CXX_STANDARD 17)

# Dodaj katalogi z plikami nagłówkowymi
include_directories(model view presenter)

# Dodaj pliki źródłowe
add_executable(pogodynka_cpp
        main.cpp
        model/WeatherModel.cpp
        view/ConsoleWeatherView.cpp
        presenter/WeatherPresenter.cpp
)
