package com.mobiquityinc.process;
import com.mobiquityinc.data.PackageRecord;
import com.mobiquityinc.exceptions.APIException;

public interface PackageProcesser {
	
	int[] processPackages(String record) throws APIException;
	
	PackageRecord extractPackages(String inputRec) throws APIException;
	
	int[] findPackageCombination(PackageRecord packageRecord);

}
