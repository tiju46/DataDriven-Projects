package com.testcases;

import org.testng.annotations.Test;

import com.utility.WriteExcel;

public class writeexceltest {

	WriteExcel obj = new WriteExcel();
	
	
	@Test
	public void writetest() throws Exception {
		obj.writeExcel("writeData", "First Column1", 0,0);
	}
}
