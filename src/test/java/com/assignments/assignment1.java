package com.assignments;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.calculator.tests.dataProviders.calculatorData;
import com.internetapp.tests.Calculator;
//import com.maveric.core.utils.reporter.Report;

public class assignment1 {
	
	@DataProvider(name="additionData")
	public Object[][] getAdditionData() {
		return new Object[][] {
			//{number1 , number2 , Result}
			{1, 2, 3},
			{3, 4, 7},
			{5, 6, 11}
		};
	}
	
	@DataProvider(name="subractionData")
	public Object[][] getSubractionData() {
		return new Object[][] {
			//{number1 , number2 , Result}
			{1, 2, -1},
			{3, 2, 1},
			{6, 6, 0}
		};
	}
	
	@DataProvider(name="multiplyData")
	public Object[][] getMultiplyData() {
		return new Object[][] {
			//{number1 , number2 , Result}
			{1, 2, 2},
			{3, 2, 6},
			{6, 6, 36}
		};
	}
	
	@DataProvider(name="divIntData")
	public Object[][] getcalcDivInt() {
		return new Object[][] {
			//{number1 , number2 , Result}
			{4, 2, 2},
			{3, 3, 1},
			{15, 5, 3}
		};
	}
	
	@DataProvider(name="divRealData")
	public Object[][] getcalcDivReal() {
		return new Object[][] {
			//{number1 , number2 , Result}
			{4, 2, 22.0},
			{3, 3, 221.0},
			{15, 5, 23.0}
		};
	}
	
	@DataProvider(name="exponentData")
	public Object[][] getcalcExponent() {
		return new Object[][] {
			//{number1 , number2 , Result}
			{4, 2, 16},
			{3, 3, 27},
			{5, 2, 25}
		};
	}
	
	@DataProvider(name="modulusData")
	public Object[][] getcalcModulus() {
		return new Object[][] {
			//{number1 , number2 , Result}
			{4, 2, 0},
			{3, 3, 0},
			{10, 2, 0}
		};
	}
	
	@DataProvider(name="inverseData")
	public Object[][] getcalcInverse() {
		return new Object[][] {
			//{number1 , Result}
			{4, 32},
			{3, 33},
			{5, 32}
		};
	}
	
	@DataProvider(name="negateData")
	public Object[][] getcalcNegate() {
		return new Object[][] {
			//{number1 , Result}
			{4, -4},
			{3, -3},
			{5, -5}
		};
	}

	
	@Test (groups= { "basic_calculation"})
	@Parameters({"number1","number2","number3"})
	public void calcAddition(int number1,int number2, int expected_result) {
		System.out.println("\nRunning Test -> calcAddition");
		Calculator obj = new Calculator();
		int result = obj.add(number1, number2);
		Assert.assertEquals(result, expected_result);
		Reporter.log(String.format("Actual - "+ result + " Expected - "+expected_result));
	}
	
	@Test (dataProvider="subractionData", 
			groups= "Basic")
	public void calcSubraction(int number1,int number2, int expected_result) {
		System.out.println("\nRunning Test -> calcSubraction");
		Calculator obj = new Calculator();
		int result = obj.sub(number1, number2);
		Assert.assertEquals(result, expected_result);
		Reporter.log("Actual - "+ result + " Expected - "+expected_result);
	}
	
	@Test (dataProvider="multiplyData", 
			groups= "Basic")
	public void calcMultiplication(int number1,int number2, int expected_result) {
		System.out.println("\nRunning Test -> calcMultiplication");
		Calculator obj = new Calculator();
		int result = obj.mul(number1, number2);
		Assert.assertEquals(result, expected_result);
		Reporter.log("Actual - "+ result + " Expected - "+expected_result);
	
	}
	
	
	@Test (dataProvider="divRealData", 
			groups= "Basic")
	public void calcDivReal(int number1,int number2, double expected_result) {
		System.out.println("\nRunning Test -> calcDivReal");
		Calculator obj = new Calculator();
		double result = obj.divReal(number1, number2);
		Assert.assertFalse(result == expected_result, "False | Output success");
		Reporter.log("Actual - "+ result + " Expected - "+expected_result);
	
	}
	
	@Test (dataProvider="exponentData",  
			groups= "Scientific")
	public void calcExponent(double number1,double number2, double expected_result) {
		System.out.println("\nRunning Test -> calcExponent");
		Calculator obj = new Calculator();
		double result = obj.exp(number1, number2);
		Assert.assertTrue(result == expected_result, "True | Output success");
		Reporter.log("Actual - "+ result + " Expected - "+expected_result);
		
	}
	
	@Test (dataProvider="modulusData", 
			groups= "Scientific")
	public void calcModulus(int number1,int number2, int expected_result) {
		System.out.println("\nRunning Test -> calcModulus");
		Calculator obj = new Calculator();
		int result = obj.mod(number1, number2);
		Assert.assertEquals(result, expected_result);
		Reporter.log("Actual - "+ result + " Expected - "+expected_result);
	
	}
	
	@Test (dataProvider="inverseData",
			groups= "Scientific")
	public void calcInverse(int number1, double expected_result) {
		System.out.println("\nRunning Test -> calcInverse");
		Calculator obj = new Calculator();
		double result = obj.inverse(number1);
		Assert.assertNotEquals(result,expected_result);
		Reporter.log("Actual - "+ result + " Expected - "+expected_result);
	
	}
	
	@Test (dataProvider="negateData", 
			groups= "intermittent_calculation")
	public void calcNegate(int number1, int expected_result) {
		System.out.println("\nRunning Test -> calcNegate");
		Calculator obj = new Calculator();
		int result = obj.negate(number1);
		Assert.assertEquals(result, expected_result);
		Reporter.log("Actual - "+ result + " Expected - "+expected_result);
	}
}
