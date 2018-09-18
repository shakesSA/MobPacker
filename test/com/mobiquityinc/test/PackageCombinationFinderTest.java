package com.mobiquityinc.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.mobiquityinc.data.PackageRecord;
import com.mobiquityinc.data.PackageUnit;
import com.mobiquityinc.process.PackageCombinationFinder;

public class PackageCombinationFinderTest {
	
	PackageRecord packageRecord;
	PackageCombinationFinder packageCombinationFinder;

	@Before
	public void setUp() throws Exception {
		
		packageCombinationFinder = new PackageCombinationFinder();
		
		packageRecord = new PackageRecord();
		packageRecord.setTotalPackageWeight(81);
		
		PackageUnit packageUnit1 = new PackageUnit();
		packageUnit1.setIndex(1);
		packageUnit1.setPackageWeight(53.38);
		packageUnit1.setPackageCost(45);
		
		PackageUnit packageUnit2 = new PackageUnit();
		packageUnit2.setIndex(2);
		packageUnit2.setPackageWeight(88.62);
		packageUnit2.setPackageCost(98);
		
		PackageUnit packageUnit3 = new PackageUnit();
		packageUnit3.setIndex(3);
		packageUnit3.setPackageWeight(78.48);
		packageUnit3.setPackageCost(3);
		
		PackageUnit packageUnit4 = new PackageUnit();
		packageUnit4.setIndex(4);
		packageUnit4.setPackageWeight(72.30);
		packageUnit4.setPackageCost(76);
		
		PackageUnit packageUnit5 = new PackageUnit();
		packageUnit5.setIndex(5);
		packageUnit5.setPackageWeight(30.18);
		packageUnit5.setPackageCost(9);
		
		PackageUnit packageUnit6 = new PackageUnit();
		packageUnit6.setIndex(6);
		packageUnit6.setPackageWeight(46.34);
		packageUnit6.setPackageCost(48);
		
		ArrayList<PackageUnit> packages = new ArrayList<>();
		packages.add(packageUnit1);
		packages.add(packageUnit2);
		packages.add(packageUnit3);
		packages.add(packageUnit4);
		packages.add(packageUnit5);
		packages.add(packageUnit6);

		packageRecord.setPackages(packages);
		
	}

	@Test
	public void testFillPackage() {
		int[] result = packageCombinationFinder.FindBestCombo(packageRecord);
		assertTrue(result != null);
		assertTrue(result[0] == 4);
		
	}

}
