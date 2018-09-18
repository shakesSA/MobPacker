package com.mobiquityinc.process;
/**
* The class defines the methods to validate an input record
* @author Shakes
*/
import java.util.ArrayList;
import java.util.Stack;

import com.mobiquityinc.data.PackageRecord;
import com.mobiquityinc.data.PackageUnit;
import com.mobiquityinc.exceptions.APIException;

public class RecordValidator {

	/**
	 * Constructor
	 */
	public RecordValidator() {
	}
	
	/**
	 * @param record The Input Record Containing Packages Details
	 * @return PackageRecord The Validate Package Record
	 * @exception APIException
	**/
	public PackageRecord validateRecord(String record) throws APIException {
		
		PackageRecord packageRecord = new PackageRecord();
		
		ArrayList<PackageUnit> packages = new ArrayList<PackageUnit>();
		
		int totalWeight = 0;
		
		String inputs[] = record.split("\\s+");
		int params = inputs.length;
		
		try{
			//Ensure that the first parameter is a valid int as the total package weight
			totalWeight = Integer.valueOf(inputs[0]);
			
			if (totalWeight > 100) {
				throw new Exception("Error: Input contains a Total Weight > 100");
			}
			
			//Ensure that the record contains a : in the correct place
			if (!inputs[1].equals(":")) {
				throw new Exception("Error: Input format is incorrect, please check");
			}
			
			if (params - 2 > 15) {
				throw new Exception("Error: Number of Packages are greater than 15");
			}
			
			//Check each package data to ensure that the parameters are correct
			for (int i = 2; i < params; i++) {
				
				PackageUnit singlePackage = new PackageUnit();
				
				String singlePackageInput = inputs[i];   
				//Check for parenthesis
				if (!isParenthesisMatch(singlePackageInput)) {
					throw new Exception("Error: Input format is incorrect, please check");
				}
				
				//Remove parenthesis
				singlePackageInput = singlePackageInput.replaceAll("\\(", "");
				singlePackageInput = singlePackageInput.replaceAll("\\)", "");
				
				String packageDetails[] = singlePackageInput.split("\\,");
				
				//Ensure that package contains 3 parameters
				if (packageDetails.length != 3) {
					throw new Exception();
				}
				
				//Check if index is a valid integer
				int index = Integer.valueOf(packageDetails[0]);
				
				//Check order of packages
				if(index != i-1) {
					throw new Exception("Error: Package Indexes are not in order");
				}
				
				float packageWeight = Float.valueOf(packageDetails[1]);
				
				int packageCost = Integer.valueOf(packageDetails[2].substring(1));
				
				singlePackage.setIndex(index);
				singlePackage.setPackageWeight(packageWeight);
				singlePackage.setPackageCost(packageCost);
				
				if (packageWeight > 100) {
					throw new Exception("Error: Input contains a Package Weight > 100");
				}
				
				if (packageCost > 100) {
					throw new Exception("Error: Input contains a Package Cost > 100");
				}
				
				packages.add(singlePackage);
				
			}
		} catch(Exception e) {
			if (e.getMessage() != null) {
				 throw new APIException("Error: File validation error: " + e.getMessage());
			} else {
				throw new APIException("Error: Please check the input file");
			}
		}
		
		packageRecord.setTotalPackageWeight(totalWeight);
		packageRecord.setPackages(packages);
		
		return packageRecord;
	}
	
	/**
	 * @param record The Input Record Containing Packages Details
	 * @return boolean True If Parenthesis Matched
	**/
	private boolean isParenthesisMatch(String record) {
	    Stack<Character> stack = new Stack<Character>();

	    char c;
	    for(int i=0; i < record.length(); i++) {
	        c = record.charAt(i);

	        if(c == '(')
	            stack.push(c);

	        if(c == ')')
	            if(stack.empty())
	                return false;
	            else if(stack.peek() == '(')
	                    stack.pop();
	                else
	                    return false;
	        }
	        return stack.empty();
	}

}
