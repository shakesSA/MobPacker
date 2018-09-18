package com.mobiquityinc.data;
/**
* The class defines the Package Record
* @author Shakes
*/

import java.util.ArrayList;

public class PackageRecord {

	private double totalPackageWeight;
	private ArrayList<PackageUnit> packages;
	
	public PackageRecord() {
	}

	public double getTotalPackageWeight() {
		return totalPackageWeight;
	}

	public void setTotalPackageWeight(double totalPackageWeight) {
		this.totalPackageWeight = totalPackageWeight;
	}

	public ArrayList<PackageUnit> getPackages() {
		return packages;
	}

	public void setPackages(ArrayList<PackageUnit> packages) {
		this.packages = packages;
	}
}
