package com.mobiquityinc.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.mobiquityinc.data.PackageRecord;
import com.mobiquityinc.exceptions.APIException;
import com.mobiquityinc.process.RecordValidator;

public class RecordValidatorTest {
	String record;
	RecordValidator recordValidator;

	@Before
	public void setUp() throws Exception {
		record = "81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)";
		recordValidator = new RecordValidator();
	}

	@Test
	public void testValidateRecord() throws APIException {
		PackageRecord packageRecord = recordValidator.validateRecord(record);
		assertTrue(packageRecord != null);
		assertTrue(packageRecord.getTotalPackageWeight() == 81);
		assertTrue(packageRecord.getPackages().size() == 6);
	}

}
