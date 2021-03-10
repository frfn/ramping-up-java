package PP5_DemographicInformationCOULDHAVEHADBETTERAPPROACHBUTCOMPLETED;

import java.util.ArrayList;

public class Main {
	
	/**
	 * Could have made this program ran a little smoother
	 * 	- Utilizing more array or ArrayLists to keep the information from getter methods
	 * 
	 * By using an ArrayList at the bottom of this page
	 * 	- Able to get what I want
	 *  - Visually pleasing
	 *  - Used the getter methods
	 */
	
	public static void main(String[] args) {  
		
		ArrayList<Data> dataList = new ArrayList<Data>();
		
		/**
		 * Testing out Data
		 */
		
		//Data data = new Data();
		Data data2 = new Data("Flexer");
		//System.out.println(data2);
		
		//dataList.add(data);  //add null
		dataList.add(data2);
		
		/**
		 * Testing out Nationality
		 */
		
		Nationality race1 = new Nationality("Satish", "Indian");
		Nationality race2 = new Nationality("Maru", "Puerto Rican-Filipino");
		
		dataList.add(race1);
		dataList.add(race2);
		
		/**
		 * Testing out Occupation
		 */
		
		Occupation job1 = new Occupation("Nicole", "TJX");
		Occupation job2 = new Occupation("Flexer", "Microsoft");
		
		dataList.add(job1);
		dataList.add(job2);
		
		/**
		 * Testing out Income
		 */
		
		Income pay1 = new Income("Jonah", 50000);
		Income pay2 = new Income("Mama", 85000);
		
		dataList.add(pay1);
		dataList.add(pay2);
		
		/**
		 * Testing out Age
		 */
		
		Age person1 = new Age("Nanay", 89);
		Age person2 = new Age("Dad", 67);
		
		dataList.add(person1);
		dataList.add(person2);
		
		
		System.out.println(dataList);
		System.out.println();
		
		dataList.remove(pay1);
		
		System.out.println(dataList);
		System.out.println();
		
		dataList.remove(0);
		
		System.out.println(dataList);
		System.out.println();
		
		/**
		 * Implementation of other getter methods here!
		 */
		
	
		
		Data flexer = new Data("Flexer");
		Nationality flexerNationality = new Nationality("Filipino");
		Occupation flexerJob = new Occupation("Microsoft");
		Age flexerAge = new Age(22);
		Income flexerIncome = new Income(15.75);
		
		ArrayList<String> person = new ArrayList<String>();
		
		person.add(flexer.getName());
		person.add(flexerNationality.getNationality());
		person.add(flexerJob.getOccupation());
		
		String age = Integer.toString(flexerAge.getAge());
		String pay = Double.toString(flexerIncome.getIncome());
		
		person.add(age);
		person.add(pay);
		
		System.out.println(person);
		
		
		
		
		/*
		
		Data flexerName = new Data("Flexer");
		Nationality flexerNationality = new Nationality("Filipino");
		Occupation flexerJob = new Occupation("Microsoft");
		Age flexerAge = new Age(22);
		Income flexerIncome = new Income(15.75);
		
		person.add(flexerName);
		person.add(flexerNationality);
		person.add(flexerJob);
		person.add(flexerAge);
		person.add(flexerIncome);
		
		System.out.println();
		System.out.println(person);
		
		*/
	}

}
