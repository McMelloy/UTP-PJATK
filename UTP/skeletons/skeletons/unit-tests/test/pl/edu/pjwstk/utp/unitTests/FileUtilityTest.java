package pl.edu.pjwstk.utp.unitTests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FileUtilityTest {
	
	//@Test
	public void test() {
	}
	
	@Test
	public void isReadableFilePath_SUCCESS() {
		// TEST DEFINITION
		final String existingFilePath = "data/input.txt";
		Assert.assertTrue(FileUtility.isReadableFilePath(existingFilePath));
	}
	
	@Test
	public void isReadableFilePath_FAILURE() {
		// TEST DEFINITION
		String notExistingFilePath = "not-existing-file.txt";
		Assert.assertFalse(FileUtility.isReadableFilePath(notExistingFilePath));
	}
	
	@Before
	public void initialize() {
		// INVOKED BEFORE EACH TEST
		System.out.println("before");
	}
	
	@After
	public void deinitialize() {
		// INVOKED AFTER EACH TEST
		System.out.println("after");
	}
	
	@BeforeClass
	public static void initializeTestClass() {
		// INVOKED ONCE WHEN A TEST CLASS IS LOADED
		System.out.println("before class");
	}
	
	@AfterClass
	public static void deinitializeTestClass() {
		// INVOKED ONCE WHEN A TEST CLASS IS UNLOADED
		System.out.println("after class");
	}
}