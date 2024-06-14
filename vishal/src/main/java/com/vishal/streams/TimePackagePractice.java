package com.vishal.streams;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class TimePackagePractice {
	public static void main(String[] args) {
		method();
	}
	
	public static void method() {
		System.out.println(LocalDate.now());
		System.out.println(LocalDateTime.now());
		System.out.println(LocalTime.now());
		
		//1 Age of a person in years
		LocalDate date = LocalDate.of(1998, 6, 22);
		LocalDate date1 = LocalDate.of(1998, Month.JUNE, 22);
		LocalDate today = LocalDate.now();
		long age = ChronoUnit.YEARS.between(date, today);
		System.out.println(age);
		
		//custom time creation
		LocalTime time1 = LocalTime.of(5, 10);
		LocalTime time2 = LocalTime.of(5, 10,15);
		LocalTime time3 = LocalTime.of(15, 10,15,200);
		System.out.println(time1);
		System.out.println(time2);
		System.out.println(time3);
		
		//custom localdatetime
		LocalDateTime dt1 = LocalDateTime.of(date1, time3);
		LocalDateTime dt2 = LocalDateTime.of(2021,5,2,5,5,5);
		System.out.println(dt1);
		System.out.println(dt2);
		
		//Period adding inside date
		Period p = Period.ofDays(15);
		dt1=dt1.plus(p);
		System.out.println(dt1);
		
		Duration d = Duration.ofMillis(15);
		
	}
}
