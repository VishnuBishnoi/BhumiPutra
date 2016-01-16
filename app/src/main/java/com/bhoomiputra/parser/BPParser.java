package com.bhoomiputra.parser;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.bhoomiputra.farmer_dto.Farmer;
import com.bhoomiputra.tool_dto.ToolsProvider;
import com.bhoomiputra.vendor_dto.Vendor;
import com.bhoomiputra.vendor_dto.VendorAddress;
import com.bhoomiputra.vendor_dto.VendorBuyer;
import com.bhoomiputra.vendor_dto.VendorSeller;
import com.google.gson.Gson;

public class BPParser {


	public static Farmer parseFarmer(String json) {
		Gson gson=new Gson();
		Farmer farmer=gson.fromJson(json, Farmer.class);
		Log.d("farmer parser",""+farmer);
	return farmer;
	
	}
	
	public static ToolsProvider parseToolProvider(String json){
		
		
		Gson gson=new Gson();
		ToolsProvider toolsProvider=gson.fromJson(json,ToolsProvider.class);
		Log.d("ToolsProvider parser",""+toolsProvider);
		return toolsProvider;
	}

	public static Vendor parseVendor(String json) {
		
		Gson gson=new Gson();
		Vendor vendor=gson.fromJson(json,Vendor.class);
		Log.d("Vendor  parser",""+vendor);
	return vendor;
  }
	

}
