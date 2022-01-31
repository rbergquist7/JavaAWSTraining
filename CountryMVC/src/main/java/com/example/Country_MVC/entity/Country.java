package com.example.Country_MVC.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Country000")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
String country1;
String capital;
int population;
public Country() {
	// TODO Auto-generated constructor stub
}
public Country(long id,String country1,String capital,int population) {
	// TODO Auto-generated constructor stub
	this.id=id;
	this.capital=capital;
	this.country1=country1;
	this.population=population;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getCountry1() {
	return country1;
}
public void setCountry1(String country1) {
	this.country1 = country1;
}
public String getCapital() {
	return capital;
}
public void setCapital(String capital) {
	this.capital = capital;
}
public int getPopulation() {
	return population;
}
public void setPopulation(int population) {
	this.population = population;
}
@Override
public String toString() {
	return "ID: " + this.id +
			"Country: " + this.country1 +
			"Capital: " + this.capital +
			"Population: " + this.population;
}
}
