package com.bhoomiputra.vendor_dto;

import com.bhoomiputra.farmer_dto.BPSharedFarmer;

public class BPSharedVendor {

	static BPSharedVendor bpSharedVendor = null;
	Vendor vendor; 
	private BPSharedVendor() {
		super();
		vendor=new Vendor();
	}
public static BPSharedVendor sharedBPSharedVendor() {
	
		if(bpSharedVendor == null)
		{
			bpSharedVendor=new BPSharedVendor();
		}
		
		return bpSharedVendor;
	
}
public Vendor getVendor() {
	return vendor;
}
public void setVendor(Vendor vendor) {
	this.vendor = vendor;
}
	
	
}
