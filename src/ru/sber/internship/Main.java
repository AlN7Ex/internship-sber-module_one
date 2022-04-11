package ru.sber.internship;

import ru.sber.internship.catalog.City;
import ru.sber.internship.catalog.ReferenceBook;

import java.util.List;

/**
 * Необходимо реализовать класс Main, используя java.util.Scanner, прочесть информацию из текстового представления
 * справочника и разложить данные в модель City с полями:
 * <p>
 * name – наименование города
 * region - регион
 * district – федеральный округ
 * population – количество жителей города
 * foundation – дата основания или первое упоминание
 * Полученный список объектов City нужно вывести в консоль.
 * <p>
 * Пример полученного результата:
 * <p>
 * City{name='Адыгейск', region='Адыгея', district='Южный', population=12248, foundation='1973'}
 * <p>
 * City{name='Майкоп', region='Адыгея', district='Южный', population=144246, foundation='1857'}
 * <p>
 * City{name='Горно-Алтайск', region='Алтай', district='Сибирский', population=56928, foundation='1830'}
 */


public class Main {

    public static void main(String[] args) {

        ReferenceBook referenceBook = new ReferenceBook();

        List<City> cityList;
        // Case 1
        cityList = referenceBook.loadCity();
        cityList = referenceBook.sortByCityName(cityList);
        referenceBook.showCityList(cityList);

        // Case 2
        cityList = referenceBook.loadCity();
        cityList = referenceBook.sortByCityNameAndDistrict(cityList);
        referenceBook.showCityList(cityList);


    }
}
