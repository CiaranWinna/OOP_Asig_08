/*
 * Assignment 8
 *
 * Student name: Ciaran
 * Student number: Winnan
 *
 */
import java.util.*;
public class Assignment8_2017 {
 public static void main(String[] args) {
   //Q1 Test =====================================
  	
  	if(Converter.getFahrenheit(24)==(75.2)){
   		System.out.println("75.2 fahrenheit");
   	}
  	else{
   		System.out.println("Error in fahrenheit converter");
   	}
   	if(Converter.getCelsius(75.2)==24){
   		System.out.println("24 celsius");
   	}
  	else{
   		System.out.println("Error in celsius converter");
   	}
   	if(Converter.getMiles(100)==62.15040397762586){
   		System.out.println("62.15040397762586 miles");
   	}
   	else{
   		System.out.println("Error in miles converter");
   	}
   	if(Converter.getKilometers(62.2)==100.0798){
   		System.out.println("100.0798 kilometers\n");
   	}
   	else{
   		System.out.println("Error in kilometers converter");
   	}
   
   
   

   //Q2 Test ======================================
   //Test array
    Module[] mlst = {
   	 new Module("Programming","Donal",36),
   	 new Module("Networks","Faheem",36),
   	 new Module("Graphics","Barry",36),
   	 new Module("Web","Ruairi",36),
   	 new Module("Hardware","Paddy",36),
   	 new Module("Algorithms","Eoin",36),
   	 new Module("OOP","Tony",36),
   	 new Module("Maths","Paddy",36),
   	 new Module("BigData","Osama",36)
   	};

   	if(mlst[1].compareTo(mlst[5]) == 0){
   		System.out.println("Are equal\n");
   	}
   	else{
   		System.out.println("Are not equal\n");
   	}
   	
   	for(int i = 0; i < mlst.length; i++){
   		System.out.println(mlst[i].lecturer());
   	}
   	System.out.println();
   	
   	for(int i = 0; i < mlst.length; i++){
   		System.out.println(mlst[i].title());
   	}
   	System.out.println();
   	
   	for(int i = 0; i < mlst.length; i++){
   		System.out.println(mlst[i].hours());
   	}
   	System.out.println();
   	
   	if(mlst[1].equals(mlst[5])==true){
   		System.out.println("True\n");}
   	else{
   		System.out.println("False\n");
   	}
   	
   	for(int i = 0; i < mlst.length; i++){
   		System.out.println(mlst[i].hashCode());
   	}
   	System.out.println();
   	
   
   //Array sort - ascending by lecturer name
   Arrays.sort(mlst, Module.lectCompare);
   for(int i = 0; i < mlst.length; i++){
   	System.out.println(mlst[i].toString());
   }
   System.out.println();
   
   //Array sort - ascending by title
   Arrays.sort(mlst, Module.titleCompare);
   for(int i = 0; i < mlst.length; i++){
   	System.out.println(mlst[i].toString());
   }
   System.out.println();
   
   
   //Q3 Test ======================================
   System.out.println(Season.WINTER.toString());
   System.out.println(Season.SUMMER.toString());
   System.out.println(Season.AUTUMN.toString());
   System.out.println(Season.SPRING.toString()+"\n");
   
   Month allMonths[] = {Month.JANUARY, Month.FEBRUARY, Month.MARCH, Month.APRIL, Month.MAY, Month.JUNE, Month.JULY, Month.AUGUST, Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER, Month.DECEMBER};
   for(int i = 0; i < allMonths.length; i++){
   		System.out.println(allMonths[i]);
   }
   
   Month m = Month.SEPTEMBER;
   System.out.println("\nThe equivalent season is: "+ m.season());
   Month m2 = Month.JULY;
   System.out.println("\nThe equivalent season is: "+ m2.season());
   Month m3 = Month.FEBRUARY;
   System.out.println("\nThe equivalent season is: "+ m3.season());
   Month m4 = Month.APRIL;
   System.out.println("\nThe equivalent season is: "+ m4.season());
 }
}

class Converter{
	public static double getFahrenheit(double c){
		double f = (c * 9.0/5.0) + 32;
		return f;
	}
	public static double getCelsius(double f){
		double c = (f - 32)*5.0/9.0;
		return c;
	}
	public static double getMiles(double k){
		double m = k /1.609;
		return m;
	}
	public static double getKilometers(double m){
		double k = 1.609*m;
		return k;
	}
}

class Module implements Comparable<Module>{
	private String title;
	private String lecturer;
	private int hours;
	Module(String t, String l, int h){
		title = t; lecturer = l; hours = h;
	}
	public String title(){return title;}
	public String lecturer(){return lecturer;}
  	int hours(){return hours;}
  public boolean equals(Object ob){
  	if(!(ob instanceof Module)) return false;
  	Module m = (Module)ob;
  	return title.equals(m.title);
  }
  public int hashCode(){return title.hashCode();}
  public String toString(){return title+" "+lecturer+" "+hours;}
  public int compareTo(Module m)throws ClassCastException {
  	if(m == null) return -1;
  	else{
  		return this.title().compareTo(m.title());
  	}
  }
  public static Comparator<Module> lectCompare = new Comparator<Module>() {
  	
  		public int compare(Module lec1, Module lec2) {
  			String firstLec = lec1.lecturer();
	    	String secondLec = lec2.lecturer();
	    	
	    	//ascending order
	      	return firstLec.compareTo(secondLec);
  		}
  };
  public static Comparator<Module> titleCompare = new Comparator<Module>() {
  	
  		public int compare(Module lec1, Module lec2) {
  			String firstLec = lec1.title();
	    	String secondLec = lec2.title();
	    	
	    	//ascending order
	      	return firstLec.compareTo(secondLec);
  		}
  };
  
}


enum Season{
	WINTER, SPRING, SUMMER, AUTUMN;
	
	public String toString(){
		switch(this){
			case WINTER:
					return "Winter";
			case SPRING:
					return "Spring";
			case SUMMER:
					return "Summer";
			case AUTUMN:
					return "Autumn";
			default:
					return "Winter";
		}
	}
}

enum Month{
	JANUARY,FEBRUARY,MARCH,APRIL,MAY,JUNE,JULY,AUGUST,SEPTEMBER,OCTOBER,NOVEMBER,DECEMBER;
	
	public String toString(){
		switch(this){
			case JANUARY:
					return "January";
			case FEBRUARY:
					return "February";
			case MARCH:
					return "March";
			case APRIL:
					return "April";
			case MAY:
					return "May";
			case JUNE:
					return "June";
			case JULY:
					return "July";
			case AUGUST:
					return "August";
			case SEPTEMBER:
					return "September";
			case OCTOBER:
					return "October";
			case NOVEMBER:
					return "November";
			case DECEMBER:
					return "December";
			default:
					return "January";
		}
	}
	
	public Season season(){
		if(this.equals(MARCH) || this.equals(APRIL)|| this.equals(MAY)){
			return Season.SPRING;
		}
		if(this.equals(JUNE) || this.equals(JULY)|| this.equals(AUGUST)){
			return Season.SUMMER;
		}
		if(this.equals(SEPTEMBER) || this.equals(OCTOBER)|| this.equals(NOVEMBER)){	
			return Season.AUTUMN;
		}
		else{
			return Season.WINTER;
		}
	}
	
}