package com.bhoomiputra.farmer_activities;

import android.R.string;


public class BhumiPutraApi {
	
	//String registerUrl="http://192.168.76.37:9292/BhumiPutraServer/UpdateVendorToolManpowerServlet";
	
	
	static final String BASE_URL="http://bhoomiputra-vishnubishnoi.rhcloud.com";
	static final String FARMER_REGESTER = BASE_URL+"/FarmerRegisterServlet";
	static final String TOOL_PROVIDER_REGESTER = BASE_URL+"/ToolRegisterServlet";
	static final String VENDOR_REGESTER = BASE_URL+"/VendorRegisterServlet";
	
	static final String FARMER_LOGIN = BASE_URL+"/FarmerLoginServlet";
	static final String TOOL_PROVIDER_LOGIN = BASE_URL+"/ToolLoginServlet";
	static final String VENDOR_LOGIN = BASE_URL+"/VendorLoginServlet";
	
	static final String GET_SUPPLIER_BASEDON_STATE = BASE_URL+"/getSupplierBasedOnStateServlet";
	static final String GET_SUPPLIER_BASEDON_DISTRICT = BASE_URL+"/getSupplierBasedOnDistrictServlet";
	static final String GET_SUPPLIER_BASEDON_VILLAGE = BASE_URL+"/getSuplierBasedOnVillageServlet";
	static final String GET_FARMER_BY_ID = BASE_URL+"/getFarmerServlet";
	static final String GET_TOOL_PROVIDER_BY_ID = BASE_URL+"/getToolServlet";
	static final String GET_VENDOR_BY_ID = BASE_URL+"/getVendorServlet";
	
	
	static final String GET_FARMER_PROFILE_PIC = BASE_URL+"/getFarmerProfilePicServlet";

	static final String GET_TOOL_PROVIDER_PROFILE_PIC = BASE_URL+"/getToolProfilePicServlet";

	static final String GET_VENDOR_PROFILE_PIC = BASE_URL+"/getVendorProfilePicServlet";
	
	static final String UPDATE_VENDOR_TOOL = BASE_URL+"/UpdateVendorToolServlet";
	static final String UPDATE_VENDOR_TOOL_MANPOWER = BASE_URL+"/UpdateVendorToolManpowerServlet";
	
	
	static final String UPDATE_VENDOR_BUYER = BASE_URL+"/UpdateVendorBuyerServlet";
	static final String UPDATE_VENDOR_SUPPLIER = BASE_URL+"/UpdateVendorSupplierServlet";
	
	
	
	
	static final String GET_MANPOWER_BASEDON_STATE = BASE_URL+"/getManpowerBasedOnStateServlet";
	static final String GET_MANPOWER_BASEDON_DISTRICT = BASE_URL+"/getManpowerBasedOnDistrictServlet";
	static final String GET_MANPOWER_BASEDON_VILLAGE = BASE_URL+"/getManpowerBasedOnVillageServlet";
	
	static final String GET_TOOL_BASEDON_STATE = BASE_URL+"/getToolBasedOnStateServlet";
	static final String GET_TOOL_BASEDON_DISTRICT = BASE_URL+"/getToolBasedOnDistrictServlet";
	static final String GET_TOOL_BASEDON_VILLAGE = BASE_URL+"/getToolBasedOnVillageServlet";
	
	
	static final String GET_BUYER_BASEDON_STATE = BASE_URL+"/getBuyerBasedOnStateServlet";
	static final String GET_BUYER_BASEDON_DISTRICT = BASE_URL+"/getBuyerBasedOnDistrictServlet";
	static final String GET_BUYER_BASEDON_VILLAGE = BASE_URL+"/getBuyerBasedOnVillageServlet";
	public static String getBaseUrl() {
		return BASE_URL;
	}
	public static String getFarmerRegester() {
		return FARMER_REGESTER;
	}
	public static String getToolProviderRegester() {
		return TOOL_PROVIDER_REGESTER;
	}
	public static String getVendorRegester() {
		return VENDOR_REGESTER;
	}
	public static String getFarmerLogin() {
		return FARMER_LOGIN;
	}
	public static String getToolProviderLogin() {
		return TOOL_PROVIDER_LOGIN;
	}
	public static String getVendorLogin() {
		return VENDOR_LOGIN;
	}
	public static String getGetSupplierBasedonState() {
		return GET_SUPPLIER_BASEDON_STATE;
	}
	public static String getGetSupplierBasedonDistrict() {
		return GET_SUPPLIER_BASEDON_DISTRICT;
	}
	public static String getGetSupplierBasedonVillage() {
		return GET_SUPPLIER_BASEDON_VILLAGE;
	}
	public static String getGetFarmerById() {
		return GET_FARMER_BY_ID;
	}
	public static String getGetToolProviderById() {
		return GET_TOOL_PROVIDER_BY_ID;
	}
	public static String getGetVendorById() {
		return GET_VENDOR_BY_ID;
	}
	public static String getGetFarmerProfilePic() {
		return GET_FARMER_PROFILE_PIC;
	}
	public static String getGetToolProviderProfilePic() {
		return GET_TOOL_PROVIDER_PROFILE_PIC;
	}
	public static String getGetVendorProfilePic() {
		return GET_VENDOR_PROFILE_PIC;
	}
	public static String getUpdateVendorTool() {
		return UPDATE_VENDOR_TOOL;
	}
	public static String getUpdateVendorToolManpower() {
		return UPDATE_VENDOR_TOOL_MANPOWER;
	}
	public static String getUpdateVendorBuyer() {
		return UPDATE_VENDOR_BUYER;
	}
	public static String getUpdateVendorSupplier() {
		return UPDATE_VENDOR_SUPPLIER;
	}
	public static String getGetManpowerBasedonState() {
		return GET_MANPOWER_BASEDON_STATE;
	}
	public static String getGetManpowerBasedonDistrict() {
		return GET_MANPOWER_BASEDON_DISTRICT;
	}
	public static String getGetManpowerBasedonVillage() {
		return GET_MANPOWER_BASEDON_VILLAGE;
	}
	public static String getGetToolBasedonState() {
		return GET_TOOL_BASEDON_STATE;
	}
	public static String getGetToolBasedonDistrict() {
		return GET_TOOL_BASEDON_DISTRICT;
	}
	public static String getGetToolBasedonVillage() {
		return GET_TOOL_BASEDON_VILLAGE;
	}
	public static String getGetBuyerBasedonState() {
		return GET_BUYER_BASEDON_STATE;
	}
	public static String getGetBuyerBasedonDistrict() {
		return GET_BUYER_BASEDON_DISTRICT;
	}
	public static String getGetBuyerBasedonVillage() {
		return GET_BUYER_BASEDON_VILLAGE;
	}
	

}
