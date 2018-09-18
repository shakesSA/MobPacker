package com.mobiquityinc.packer;

/**
* The class is the entry point into the API
* The API accepts a file path and name as the 1st and only parameter
* @author Shakes
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import com.mobiquityinc.exceptions.APIException;
import com.mobiquityinc.process.PackageProcesserImpl;

public class Packer {

	public static void main(String[] args) throws APIException {
		Pack(args[0]);
	}
	
	private static void Pack(String fileName) throws APIException {
		File file = new File(fileName); 
		  
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			
			String input; 
			while ((input = br.readLine()) != null) {
			
			PackageProcesserImpl packageProcesser = new PackageProcesserImpl();
			
			int[] packageList = packageProcesser.processPackages(input);
			
			Arrays.sort(packageList);
			String output = "";
			if (packageList.length == 0) {
				output = "-";
			} else {
				for (int i = 0; i < packageList.length; i++) {
					if (i>0){
						output += ",";
					}
					output += packageList[i];
				}
			}
			System.out.println(output);
			
			}
		} catch (IOException e) {
			throw new APIException("Error: Unable to read input file: " + e.getMessage());
		} catch (APIException a) {
			throw a;
		}
		finally {
			try {
				br.close();
			} catch (IOException e) {
				throw new APIException("Error: Unable to close input file: " + e.getMessage());
			}
		} 
	}
}
