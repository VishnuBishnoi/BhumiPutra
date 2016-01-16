package com.bhoomiputra.farmer_dto;

import android.R.string;

public class BPSharedFarmer {
	Farmer farmer;
	 static BPSharedFarmer bpSharedFarmer = null;

	private BPSharedFarmer() {
		super();
		farmer=new Farmer();
		
	}
public static BPSharedFarmer sharedBPSharedFarmer(){
	if(bpSharedFarmer == null)
	{
		bpSharedFarmer=new BPSharedFarmer();
	}
	
	return bpSharedFarmer;
}
public Farmer getFarmer() {
	return farmer;
}
public void setFarmer(Farmer farmer) {
	this.farmer = farmer;
}

}
