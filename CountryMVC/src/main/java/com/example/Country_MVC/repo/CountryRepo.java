package com.example.Country_MVC.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Country_MVC.entity.Country;



public interface CountryRepo extends JpaRepository<Country, Long>
{

}
