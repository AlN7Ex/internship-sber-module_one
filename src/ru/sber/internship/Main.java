package ru.sber.internship;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        File file = new File("city_ru.csv");
        String[] splitStr;
        Scanner scanner = null;
        List<City> cityList = new ArrayList<>();

        try {
            scanner = new Scanner(file);
        } catch (IOException exc) {
            exc.printStackTrace();
        }

        while (scanner.hasNextLine()) {
            City city = new City();
            splitStr = scanner.nextLine().split(";");

            try {
                if (splitStr.length != 6) {
                    throw new InvalidDataStructureException(splitStr[0]);
                }
                city.setName(splitStr[1]);
                city.setRegion(splitStr[2]);
                city.setDistrict(splitStr[3]);
                city.setPopulation(splitStr[4]);
                city.setFoundation(splitStr[5]);

                cityList.add(city);

            } catch (InvalidDataStructureException exc) {
                exc.printStackTrace();
            }
        }
        for (City myCity : cityList) {
            System.out.println(myCity);
        }
    }
}
