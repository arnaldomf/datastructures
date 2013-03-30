package com.datastructures.unittests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class TestJUnit {

	@Before
	public void executeBeforeEachTest() {
		System.out.println("before");
		return;
	}
	
	@After
	public void executeAfterEachTest() {
		System.out.println("after");
		return;
	}
	
	@BeforeClass
	public static void runOnceBeforeAllTestsBegin() {
		System.out.println("Before Class");
		return;
	}
	
	@AfterClass
	public static void runOnceAfterAllTestsFinish() {
		System.out.println("After Class");
		return;
	}
	
	@Test
	public void testMultiply() {
		assertEquals("10 x 5 must be 50", 10 * 5, 25 *2);
	}
	
	@Ignore
	@Test
	public void thisIsWrongAndShouldBeIgnored() {
		assertEquals("2 + 2 must be 4", 2 + 2, 10);
	}
	
	@Test(timeout=100)
	public void willFailIfTakesMoreThan100ms() {
		assertEquals("10 x 5 must be 50", 10 * 5, 25 *2);
	}
	
	@Test(expected = Exception.class)
	public void exceptionTest() {
		int a = 10/0;
	}

}
