package com.harshalmayee.services;

import com.harshalmayee.models.Country;

import java.util.List;

public interface CountryService {

    public List<Country> getAllCountries();

    public void addNewCountry(Country country);

    public Country getCountryById(int id);

    void delete(int id);
}
