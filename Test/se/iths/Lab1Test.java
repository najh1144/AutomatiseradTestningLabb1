package se.iths;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

public class Lab1Test {
	
	Lab1 lab1;
	
	public interface MathTests{
		
	}
	
	@Before 
	public void createLab1(){
		lab1 = new Lab1();
	}
	
	/*
	@After
	public void getCounter(){
		if (lab1.getCounter()>0){
			System.out.println("callCounter: " + lab1.getCounter() + "\n");
		}
	}
	*/
	
	@Category(MathTests.class)
	@Test
	public void addNotNull(){
		int result = lab1.add(20, 20);
		
		//System.out.println("addNotNull:");
		assertNotNull(result);
	}
	
	@Category(MathTests.class)
	@Test
	public void addValid(){
		int a = 45;
		int b = 55;
		int result = lab1.add(a, b);
		
		//System.out.println("addValid:");
		assertEquals(result, 100);
	}
	
	@Category(MathTests.class)
	@Test
	public void addNegatives(){
		int a = -45;
		int b = -55;
		int result = lab1.add(a, b);
		//Av någon anledning ökas inte callCounter med den här metoden
		//System.out.println("addNegatives:");
		
		assertEquals(result, -100);
	}
	
	@Category(MathTests.class)
	@Test
	public void addToMaxValue(){
		int result = lab1.add(Integer.MAX_VALUE, 1);
		
		//System.out.println("addToMaxValue:");
		assertEquals(result, Integer.MAX_VALUE+1);
	}
	
	@Category(MathTests.class)
	@Test
	public void addMaxToMinValue(){
		int result = lab1.add(Integer.MIN_VALUE, Integer.MAX_VALUE);
		
		//System.out.println("addMaxToMinValue:");
		assertTrue(result == -1);
	}
	
	@Category(MathTests.class)
	@Test
	public void subtractNotNull(){
		int result = lab1.subtract(2, 1);
		
		//System.out.println("subtractNotNull:");
		assertNotNull(result);
	}
	
	@Category(MathTests.class)
	@Test
	public void subtractValid(){
		int result = lab1.subtract(100, 60);
		
		//System.out.println("subtractValid:");
		assertEquals(result, 40);
	}
	
	@Category(MathTests.class)
	@Test
	public void subtractNegatives(){
		int result = lab1.subtract(-100, -40);
		
		//System.out.println("subtractNegatives:");
		assertEquals(-60, result);
	}
	
	@Category(MathTests.class)
	@Test
	public void subtractFromMinValue(){
		int result = lab1.subtract(Integer.MIN_VALUE, 1);
		
		//System.out.println("subtractFromMinValue:");
		assertEquals(result, Integer.MIN_VALUE-1);
	}
	
	@Category(MathTests.class)
	@Test
	public void multiplyNotNull(){
		int result = lab1.multiply(5, 5);
		
		//System.out.println("multiplyNotNull:");
		assertNotNull(result);
	}
	
	@Category(MathTests.class)
	@Test
	public void multiplyValid(){
		int result = lab1.multiply(2, 60);
		
		//System.out.println("multiplyValid:");
		assertEquals(result, 120);
	}
	
	@Category(MathTests.class)
	@Test
	public void multiplyNegatives(){
		int result = lab1.multiply(-10, 5);
		
		//System.out.println("multiplyNegatives:");
		assertEquals(result, -50);
	}
	
	@Category(MathTests.class)
	@Test
	public void divideValid(){
		int a = 10;
		int b = 2;
		int result = lab1.divide(a, b);
		
		//System.out.println("divideValid:");
		assertEquals(result, 5);
	}
	
	@Category(MathTests.class)
	@Test
	public void divideMaxValue(){
		int a = Integer.MAX_VALUE;
		int b = 2;
		int result = lab1.divide(a, b);
		
		//System.out.println("divideMaxValue:");
		assertEquals(result, (Integer.MAX_VALUE / 2));
	}
	
	@Category(MathTests.class)
	@Test
	public void divideMaxValuePlusOne(){
		int a = Integer.MAX_VALUE + 1;
		int b = 2;
		int result = lab1.divide(a, b);
		
		//System.out.println("divideMaxValuePlusOne:");
		assertEquals(result, ((Integer.MAX_VALUE + 1) / 2));
	}
	
	@Category(MathTests.class)
	@Test(expected=ArithmeticException.class)
	public void divideByZero(){
		int result = lab1.divide(100, 0);
	}
	
	@Test
	public void reverseNotNull(){
		String returnString = "testing";
		
		//System.out.println("reverseNotNull:");
		assertNotNull(lab1.reverse(returnString));
	}
	
	@Test
	public void reverseValid(){
		String testString = "9876543210";
		
		//System.out.println("reverseValid:");
		assertEquals(lab1.reverse(testString), "0123456789");
	}
	
	@Test
	public void reverseNullParameter(){
		String testString = null;
		
		//System.out.println("reverseNullParameter:");
		assertNull(testString);
	}

	@Test
	public void quoteNotNull(){
		String returnQuote = lab1.quote();
		
		//System.out.println("quoteNotNull:");
		assertNotNull(returnQuote);
	}
	
	@Test
	public void quoteAllQuotes(){
		String quote_einstein = "We cannot solve our problems with the same thinking we used when we created them. - Albert Einstein";
		String quote_shakespeare = "A fool thinks himself to be wise, but a wise man knows himself to be a fool. - William Shakespeare";
		String quote_gandhi = "You must be the change you wish to see in the world. - Mahatma Gandhi";
		String quote_mlk = "In the End, we will remember not the words of our enemies, but the silence of our friends. - Martin Luther King, Jr.";
		String quote_confucius = "Choose a job you love, and you will never have to work a day in your life. - Confucius";
		String quote_wilde = "To expect the unexpected shows a thoroughly modern intellect. - Oscar Wilde";
		String quote_nietzsche = "Without music, life would be a mistake. - Friedrich Nietzsche";
		String quote_adams = "I love deadlines. I like the whooshing sound they make as they fly by. - Douglas Adams";
		
		boolean found_quote_einstein, found_quote_shakespeare, found_quote_gandhi, found_quote_mlk,
				found_quote_confucius, found_quote_wilde, found_quote_nietzsche, found_quote_adams;
				found_quote_einstein = false; found_quote_shakespeare = false; found_quote_gandhi = false;
				found_quote_mlk = false; found_quote_confucius = false; found_quote_wilde = false;
				found_quote_nietzsche = false; found_quote_adams = false;
		boolean found_all_quotes = false;
		
		for (int i = 0; i<1000; i++){
			String test_quote = lab1.quote();
			if (test_quote.equals(quote_einstein)){
				found_quote_einstein = true;
			}
			else if (test_quote.equals(quote_gandhi)){
				found_quote_gandhi = true;
			}
			else if (test_quote.equals(quote_shakespeare)){
				found_quote_shakespeare = true;
			}
			else if (test_quote.equals(quote_mlk)){
				found_quote_mlk = true;
			}
			else if (test_quote.equals(quote_confucius)){
				found_quote_confucius = true;
			}
			else if (test_quote.equals(quote_wilde)){
				found_quote_wilde = true;
			}
			else if (test_quote.equals(quote_nietzsche)){
				found_quote_nietzsche = true;
			}
			else if (test_quote.equals(quote_adams)){
				found_quote_adams = true;
			}
			if (found_quote_einstein && found_quote_shakespeare && found_quote_gandhi && found_quote_mlk &&
					found_quote_confucius && found_quote_wilde && found_quote_nietzsche && found_quote_adams){
				found_all_quotes = true;
			}
		}
		
		//System.out.println("quoteAllQuotes:");
		assertTrue(found_all_quotes);
	}
	
	@Test
	public void getCounterNotNull(){
		assertNotNull(lab1.getCounter());
	}
	
	@Test
	public void testCounter(){
		int counter_test = lab1.getCounter();
		
		int result1 = lab1.add(10, 90);
		int result2 = lab1.subtract(100, 50);
		int result3 = lab1.divide(100, 50);
		int result4 = lab1.multiply(2, 10);
		String result5 = lab1.quote();
		String result6 = lab1.reverse("12345");
		
		assertEquals(lab1.getCounter(), (counter_test+6));
	}
	
	@RunWith(Categories.class)
	@IncludeCategory(MathTests.class)
	@SuiteClasses({
		Lab1Test.class
	})
	
	public static class TestSuite {

	}
	
}
