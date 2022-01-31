package com.example.Country_MVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.Country_MVC.entity.Country;
import com.example.Country_MVC.services.CountryService;

import java.util.*;


@Controller

public class HomeController
{
	@Autowired
	CountryService countryService;
	@RequestMapping("/")  // what request methdo here, its get
	public String welcome(Model model)
	{
		// not invoking any services.
		// get some data from Service Layer
		// make some data here.
		// share that data to the thymleaf/html
		
		return "redirect:/list_countries";
	}
	@RequestMapping("/new")
	public String showCountryForm(Model model)
	{
		Country e = new Country();
		model.addAttribute(e);
		return "new_country";
	}
	@RequestMapping("/list_countries") // here its get 
	public String listCountries(Model model)
	{
		List<Country> listCountry=countryService.getCountryList();
		model.addAttribute("countries",listCountry); // scopes req,session,app,
		
		return "countries";
	}
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String saveCountry(@ModelAttribute("country") Country country)
	{
		System.out.println(country.getCountry1());
		System.out.println(country.getCapital());
		countryService.saveCountry(country);
		return "redirect:/list_countries";
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditCountryPage(@PathVariable(name="id") long id)
	{
		ModelAndView mav = new ModelAndView("edit_country");
		Country e = countryService.get(id);
		mav.addObject("country",e);
		return mav;
		
		
	}
	@RequestMapping("/view/{id}")
	public ModelAndView showCountryPage(@PathVariable(name="id") long id)
	{
		ModelAndView mav = new ModelAndView("view_country");
		Country e = countryService.get(id);
		List<Country> listCountry = new ArrayList<Country>();
		listCountry.add(e);
		mav.addObject("countries",listCountry);
		return mav;
		
		
	}
	@RequestMapping("/delete/{id}")
	public String deleteCountry(@PathVariable(name="id") long id)
	{
		countryService.delete(id);
		// you create a new theymeleaf.
		return "redirect:/list_countries";
		
	}
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public String updateCountry(@ModelAttribute("country") Country country)
	{
		System.out.println(country.getCountry1());
		System.out.println(country.getCapital());
		System.out.println(country.getId());
		System.out.println(country.getPopulation());
		countryService.saveCountry(country);
		// you create a new theymeleaf.
		return "redirect:/list_countries";
		
	}
	
}
