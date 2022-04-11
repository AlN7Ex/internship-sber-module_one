package ru.sber.internship.catalog;

import ru.sber.internship.comporator.CityDistrictComparator;
import ru.sber.internship.comporator.CityNameComparator;
import ru.sber.internship.exception.InvalidDataStructureException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ReferenceBook {

    public List<City> loadCity() {

        File file = new File("city_ru.csv");
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        } catch (IOException exc) {
            exc.printStackTrace();
        }

        List<City> cityList = new ArrayList<>();
        String[] splitStr;

        if (scanner != null) {
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
            scanner.close();

            return cityList;
        }
        return cityList;
    }

    public List<City> sortByCityName(List<City> cityList) {

//        cityList.sort(new CityNameComparator());

        cityList.sort((Comparator.comparing(City::getName)));

        return cityList;
    }

    public List<City> sortByCityNameAndDistrict(List<City> cityList) {
//        cityList.sort((Comparator.comparing(City::getName)));
//        cityList.sort((Comparator.comparing(City::getDistrict)));

        cityList.sort(new CityNameComparator());
        cityList.sort(new CityDistrictComparator());

        return cityList;
    }

    public void showCityList(List<City> cityList) {
        int counter = 1;
        for (City myCity : cityList) {
            System.out.println("#" + counter++ + ": " + myCity);
        }
    }
}
