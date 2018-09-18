package com.mobiquityinc.data;
/**
* The class defines Unit Package Record
* @author Shakes
*/

import java.util.Comparator;

public class PackageUnit {
	int index;
	Double packageWeight;
	Integer packageCost;
	
	public PackageUnit(int index, double packageWeight, int packageCost) {
		this.index = index;
		this.packageWeight = packageWeight;
		this.packageCost = packageCost; 
	}
	
	public PackageUnit() {
	}

	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public double getPackageWeight() {
		return packageWeight;
	}
	public void setPackageWeight(double packageWeight) {
		this.packageWeight = packageWeight;
	}
	public int getPackageCost() {
		return packageCost;
	}
	public void setPackageCost(int packageCost) {
		this.packageCost = packageCost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((packageCost == null) ? 0 : packageCost.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PackageUnit other = (PackageUnit) obj;
		if (packageCost == null) {
			if (other.packageCost != null)
				return false;
		} else if (!packageCost.equals(other.packageCost))
			return false;
		return true;
	}
	
	 public static Comparator<PackageUnit> COMPARE_BY_WEIGHT= new Comparator<PackageUnit>() {
	        public int compare(PackageUnit one, PackageUnit other) {
	            return one.packageWeight.compareTo(other.packageWeight);
	        }
	    };

	    public static Comparator<PackageUnit> COMPARE_BY_INDEX = new Comparator<PackageUnit>() {
	        public int compare(PackageUnit one, PackageUnit other) {
	            return String.valueOf(one.index).compareTo(String.valueOf(other.index));
	        }
	    };
	
	
}
