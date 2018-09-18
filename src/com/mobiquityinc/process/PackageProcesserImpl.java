package com.mobiquityinc.process;
import com.mobiquityinc.data.PackageRecord;
import com.mobiquityinc.exceptions.APIException;

public class PackageProcesserImpl implements PackageProcesser {
	
	PackageRecord packageRecord;
	
	RecordValidator recordValidator;
	
	PackageCombinationFinder packageCombinationFinder;

	/**
	 * Constructor
	**/
	public PackageProcesserImpl() {
	}

	/**
	 * @param inputRec The Input Record Containing Packages Details
	 * @return PackageRecord The Validate Package Record
	 * @exception APIException
	**/
	@Override
	public PackageRecord extractPackages(String inputRec) throws APIException {
		recordValidator = new RecordValidator();
		
		return recordValidator.validateRecord(inputRec);
	}

	/**
	 * @param packageRecord The Package Record Containing Packages Details
	 * @return int[] List of selected packages
	 * @exception APIException
	**/
	@Override
	public int[] findPackageCombination(PackageRecord packageRecord) {
		packageCombinationFinder = new PackageCombinationFinder();
		return packageCombinationFinder.FindBestCombo(packageRecord);
		
	}

	/**
	 * @param record The Package Record Containing Packages Details
	 * @return int[] List of selected packages
	 * @exception APIException
	**/
	@Override
	public int[] processPackages(String record) throws APIException {
		packageRecord = new PackageRecord();
		packageRecord = extractPackages(record);
		
		int[] packageItems = findPackageCombination(packageRecord);
		
		return packageItems;
	}
}
