package ru.sber.internship.comporator;

import ru.sber.internship.catalog.City;

import java.util.Comparator;

public class CityDistrictComparator implements Comparator<City> {
    @Override
    public int compare(City o1, City o2) {
        return o1.getDistrict().compareTo(o2.getDistrict());
    }
}
