package com.vishal.streams;

import java.util.Optional;

public class OptionalPractice {

	public static void main(String[] args) {
		m();
	}
	
	public static void m() {
		//1 instantiation
		Optional<House> house = Optional.empty();
		Optional<House> house1 = Optional.of(new House());
		Optional<House> house2 = Optional.ofNullable(new House());
		Optional<House> house3 = Optional.ofNullable(null);
		System.out.println(house3.isPresent());
		
		//extraction
		Optional<House> hous1 = Optional.of(new House());
		System.out.println(hous1.get());
		
		Optional<House> hous2 = Optional.ofNullable(null);
		System.out.println(hous2.orElse(new House()));
		
		Optional<House> optionalHouse = Optional.of(new House());
		optionalHouse.ifPresent(System.out::println);
		System.out.println(optionalHouse.isPresent());
		System.out.println(optionalHouse.isEmpty());
		
		Optional<House> hous3 = Optional.ofNullable(null);
		  House h = hous3.orElseGet(()->new House());
		System.out.println(h);
		
		
	}
	
	
	
}

class Person
{
     
    Optional<House> house;     
     
    public Optional<House> getHouse() 
    {
        return house;
    }
}
 
class House
{
     
    Optional<HouseLoan> houseLoan;
     
    public Optional<HouseLoan> getHouseLoan() 
    {
        return houseLoan;
    }
}
 
class HouseLoan
{
    String houseLoanDetails;
     
    public String getHouseLoanDetails() 
    {
        return houseLoanDetails;
    }
}