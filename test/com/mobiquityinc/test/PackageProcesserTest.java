/**
 * 
 */
package com.mobiquityinc.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.mobiquityinc.data.PackageRecord;
import com.mobiquityinc.exceptions.APIException;
import com.mobiquityinc.process.PackageProcesserImpl;

public class PackageProcesserTest {
	
	String validTest;
	String invalidParenthisisTest;
	
	PackageProcesserImpl packageProcesser;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		validTest = "81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)";
		invalidParenthisisTest = "81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3)) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)";
		
		packageProcesser = new PackageProcesserImpl();
		
	}

	/**
	 * Test method for {@link com.mobiquityinc.process.PackageProcesserImpl#extractPackages(java.lang.String)}.
	 * @throws APIException 
	 */
	@Test
	public void testExtractPackages() throws APIException {
		PackageRecord validPackageRecord = packageProcesser.extractPackages(validTest);
		assertEquals(validPackageRecord.getTotalPackageWeight(), 81, 0);
		assertEquals(validPackageRecord.getPackages().size(), 6);
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testInvalidRecordException() {
		try {
			PackageRecord invalidPackageRecord = packageProcesser.extractPackages(invalidParenthisisTest);
			fail("APIException Expected!!!");
		} catch (APIException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.mobiquityinc.process.PackageProcesserImpl#findPackageCombination(java.util.ArrayList)}.
	 * @throws APIException 
	 */
	@Test
	public void testFindPackageCombination() throws APIException {
		PackageRecord validPackageRecord = packageProcesser.extractPackages(validTest);
		int[] packageItems = packageProcesser.findPackageCombination(validPackageRecord);
		assertEquals(packageItems[0], 4, 0);
	}

}
