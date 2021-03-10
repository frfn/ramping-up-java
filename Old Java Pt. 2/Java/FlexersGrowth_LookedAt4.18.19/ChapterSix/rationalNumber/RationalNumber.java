package rationalNumber;

public class RationalNumber {
	
	private int numerator, denominator;  // two fields
	
	public RationalNumber(int numerator, int denominator) {
		
		if(denominator == 0) {
			this.denominator = 1;
		}
		
		if(denominator < 0) {
			this.numerator = numerator * -1;
			this.denominator = denominator * -1;
		}
		
		this.numerator = numerator;
		this.denominator = denominator;
		
		reduce();  // a private method
	}
	
	//quick getters!
	public int getNumerator() {
		return numerator;
	}
	public int getDenominator() {
		return denominator;
	}
	
	//this is NEW, I'm returning AN OBJECT BACK! 
	//To use, you NEED to create an object with the same type,
	
	//RationalNumber r1 = RationalNumber(1, 2);
	//RationalNumber recip;
	//recip = r1.getReciprocal();
	//in main!
	
	public RationalNumber reciprocal() {
		return new RationalNumber(denominator, numerator);
	}
	
	public RationalNumber add(RationalNumber rn) {
		// you just need to understand how to add, subtract, multiply and divide fractions for you to understand and write the code.
		int commonDenominator = denominator * rn.getDenominator();
		int num1 = numerator * rn.getDenominator();
		int num2 = rn.numerator * denominator;
		int sum = num1 + num2;
		
		return new RationalNumber(sum, commonDenominator);
	}
	
	public RationalNumber subtract(RationalNumber rn) {
		int commonDenominator = denominator * rn.getDenominator();
		int num1 = numerator * rn.getDenominator();
		int num2 = rn.numerator * denominator;
		int dif = num1 - num2;
		
		return new RationalNumber(dif, commonDenominator);
	}
	
	public RationalNumber multiply(RationalNumber rn) {
		int numer = numerator * rn.getNumerator();
		int denom = denominator * rn.getDenominator();
		
		return new RationalNumber(numer, denom);
	}
	
	public RationalNumber divide(RationalNumber rn) {
		return multiply(rn.reciprocal());
	}
	
	public boolean equals(RationalNumber rn) {
		return (numerator == rn.getNumerator() &&
				denominator == rn.getDenominator());
	}
	
	public String toString() {
		
		String str;
		
		if(numerator == 0) {
			str = "0";
		}
		else if(denominator == 1) {
			str = numerator + ""; //"" is there so you can this as a string
		}
		else {
			str = numerator + "/" + denominator;
		}
		
		return str;
	}
	
	
	
	public void reduce() {
		if(numerator != 0) {
			int common = gcd (numerator, denominator);
			
			numerator = numerator / common;
			denominator = denominator / common;
		}
		
	}
	public int gcd(int num1, int num2) {
		//this is NOT related to the numerator and denominator
		//well it is, but it is just finding the GCD of it
		
		while(num1 != num2) {
			if(num1 > num2) {
				num1 = num1 - num2;
			}else {
				num2 = num2 - num1;
			}
		}
		return num1;
	}
	
	
	
	
}