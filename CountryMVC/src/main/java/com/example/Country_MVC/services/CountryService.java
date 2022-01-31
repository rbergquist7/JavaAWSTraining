package com.example.Country_MVC.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Country_MVC.entity.Country;
import com.example.Country_MVC.repo.CountryRepo;


@Service
public class CountryService {


@Autowired
CountryRepo countryRepo;
public List<Country> getCountryList()
{
return countryRepo.findAll();
}
public void delete(long id)
{
	countryRepo.deleteById(id);
}
public Country get(long i)
{
return countryRepo.findById(i).get();
}
public void saveCountry(Country c)
{
	countryRepo.save(c);
}

}
