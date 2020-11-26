package com.harshalmayee.services.impl;


import com.harshalmayee.models.Country;
import com.harshalmayee.repositories.CountryRepository;
import com.harshalmayee.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    /*
      Return List Of Countries
     */
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    /*
    Save New Country
     */
    public void addNewCountry(Country country) {
        countryRepository.save(country);
    }

    @Override
    /*
    Get Country By Id
     */
    public Country getCountryById(int id) {
        Optional<Country> optional=countryRepository.findById(id);
        Country country=null;
        if(optional.isPresent()){
            country=optional.get();
        }else{
            throw new RuntimeException("Country Not Found :"+id);
        }
        return country;
    }

    @Override
    /*
    Delete Country
     */
    public void delete(int id) {
        countryRepository.deleteById(id);
    }
}
