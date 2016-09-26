package com.tcs.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tcs.model.*;

@Controller
public class CountryController {
	
	public List<Country> createCountryList()
	{
		Country india = new Country(1, "India");
		Country china = new Country(2, "China");
		Country america = new Country(3, "America");
		Country australia = new Country(4, "Australia");
		
		List<Country> list = new ArrayList<Country>();
		list.add(india);
		list.add(china);
		list.add(america);
		list.add(australia);
		
		return list;
	}
	
	@RequestMapping(value = "/country/{id}.spring", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Country getCountryById(@PathVariable int id)
	{
		List<Country> list = null;
		list = createCountryList();
		
		Iterator<Country> itr = list.iterator();
		while(itr.hasNext())
		{
			Country country = itr.next();
			if(country.getId() == id)
			{
				return country;
			}
		}
		
		return null;
	}
	
	@RequestMapping(value = "/countries.spring", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Country> getCountries()
	{
		List<Country> list = null;
		list = createCountryList();
		
		return list;
	}

}
