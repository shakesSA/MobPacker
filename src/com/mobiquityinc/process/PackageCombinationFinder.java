package com.mobiquityinc.process;
/**
* The class contains the methods required to find the best combination of packages
* @author Shakes
*/
import java.util.ArrayList;
import java.util.List;

import com.mobiquityinc.data.PackageRecord;
import com.mobiquityinc.data.PackageUnit;
import com.mobiquityinc.exceptions.APIException;

public class PackageCombinationFinder {
	
	static List<PackageUnit> packageUnits;

	/**
	 * Constructor
	**/
	public PackageCombinationFinder() {
	}

	/**
	 * @param packageRecord The Package Record Containing Packages Details
	 * @return int[] List of selected package
	 * @exception APIException
	**/
	public int[] FindBestCombo(PackageRecord packageRecord) {
		
		packageUnits = new ArrayList<>();
		
		ArrayList<PackageUnit> packages = packageRecord.getPackages();
		
		fillPackage(packageRecord.getTotalPackageWeight(), packages, packageUnits, packages.size());
		
		int[] packageIndexes = new int[packageUnits.size()];
		int i = 0;
		for (PackageUnit packageUnit : packageUnits) {
			packageIndexes[i] = packageUnit.getIndex();
			i++;
		}
		return packageIndexes;
	}
	
	/**
	 * @param weight The Max Weight Of The Total Package
	 * @param item The List Of Packages
	 * @param selectedPackage The List Of Selected Packages
	 * @param noOfPackages The Total Number of Input Packages
	 * @return int[] List of selected package
	 * @exception APIException
	**/
	public static int fillPackage(double weight, ArrayList<PackageUnit> item, List<PackageUnit> selectedPackage, int noOfPackages){
        //base case
        if(noOfPackages == 0 || weight == 0)
            return 0;

        //check if last item > total weight
        if(item.get(noOfPackages-1).getPackageWeight() > weight) {
            List<PackageUnit> unselectedPackage = new ArrayList<>();
            int optimalCost =fillPackage(weight, item, unselectedPackage, noOfPackages-1);
            selectedPackage.addAll(unselectedPackage);
            return optimalCost;
        }
        else{
            List<PackageUnit> includeOptimalChoice = new ArrayList<>();
            List<PackageUnit> excludeOptimalChoice = new ArrayList<>();
            int include_cost = item.get(noOfPackages-1).getPackageCost() + fillPackage((weight-item.get(noOfPackages-1).getPackageWeight()), item, includeOptimalChoice, noOfPackages-1);
            int exclude_cost = fillPackage(weight, item, excludeOptimalChoice, noOfPackages-1);
            if(include_cost > exclude_cost){
                selectedPackage.addAll(includeOptimalChoice);
                selectedPackage.add(item.get(noOfPackages - 1));
                return include_cost;
            }
            else{
                selectedPackage.addAll(excludeOptimalChoice);
                return exclude_cost;
            }
        }
    }
}
