package com.bhoomiputra.vendor_activities;


import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import com.bhoomiputra.farmer_activities.BhumiPutraApi;
import com.bhoomiputra.vendor_activities.VendorSellerAssetsActivity.RegisterTask;
import com.bhoomiputra.vendor_dto.Vendor;
import com.bhoomiputra.vendor_dto.VendorSeller;
import com.example.bhumiputra.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class VendorSellFragmet extends Fragment {
	TextView tvSelect;
	Spinner spinnerVendor,spinnerItem;
	EditText etRate;
	Button btnAdd,btnSubmit;
	RadioButton rbbuyer,rbSeller,rbboth;

	int j=12123;
	ArrayAdapter<String> adapterVendor;
	ArrayAdapter<String> adapterItem;
	String[] vendorArray1;
	String[] vendorArray={"Seed","Manure","Pesticides","Tools"};
	String[] itemArray={"Paddy","Wheat","Vegetables","Pulse"};

	String[] itemManureArray={"Uria","Potash","Sulphur"};
	String[] itemPesticidesArray={"DDT","Nephthol","Diclofop"};
	String[] itemToolArray={"Cultivator","Tractor","Rotary Cultivator","Animal Drawn Cultivator","Bottom Plough","Chisel Plough","Reversible Plough","Disc Harrow","Puddler","Groundnut Threshe","Combine Harvester","Paddy Harvester","Sugar Cane Harvester","Wheat Harvester","Potato Digger","Seed Driller","Potato Planter","Hand Sprayer","Rocker Sprayer","Mini Power Sprayer"};
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView=inflater.inflate(R.layout.vendorsellerassets, container,false);
		
		SharedPreferences sp=getActivity().getSharedPreferences("settings",getActivity().MODE_PRIVATE);
		SharedPreferences.Editor editor=sp.edit();
	final	int id =sp.getInt("f_id", 0);
		Log.d("fid",""+id);
		
		
		etRate=(EditText)rootView.findViewById(R.id.editText1);
		
		btnAdd=(Button)rootView.findViewById(R.id.button1);
	
		spinnerVendor=(Spinner)rootView.findViewById(R.id.spinner1);
		spinnerItem=(Spinner)rootView.findViewById(R.id.spinner2);
		
		adapterVendor=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.vendor_array));
		spinnerVendor.setAdapter(adapterVendor);
		
		btnAdd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v)
			{  
				String productType=vendorArray[spinnerVendor.getSelectedItemPosition()];
				
				String itemname = null;
			switch (j) {
			case 0:
				itemname=itemArray[spinnerItem.getSelectedItemPosition()];
				
				break;
			case 1:
			 itemname=itemManureArray[spinnerItem.getSelectedItemPosition()];
				
				break;
				case 2:
				 itemname=itemPesticidesArray[spinnerItem.getSelectedItemPosition()];
					
					break;
					
				case 3:
						 itemname=itemToolArray[spinnerItem.getSelectedItemPosition()];
						
						break;
			default:
				break;
			}
				
				
				String itemType=itemname;
					
				double itemRate=Double.parseDouble(etRate.getText().toString());
				
				VendorSeller seller=new VendorSeller(productType, itemType, itemRate);
				
				Gson gson =new  GsonBuilder().create();
 				String json=gson.toJson(seller);
 				Toast.makeText(getActivity(),json, Toast.LENGTH_LONG).show();
 				String registerUrl=BhumiPutraApi.getUpdateVendorSupplier();
 				UpdateTask task=new UpdateTask();
 			
 				task.execute(json,registerUrl,id+"");
				
				
			
			}
		});
		
		
		
	
		
		spinnerVendor.setOnItemSelectedListener(new OnItemSelectedListener()
		{

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
			
				
				switch (arg2) {
				case 0:
					adapterItem=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.item_array));
					etRate.setHint(R.string.ratekg);
					j=0;
					break;
				case 1:
					adapterItem=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.itemmanure_array));
					etRate.setHint(R.string.ratekg);
					j=1;
					break;
				case 2:
					
					adapterItem=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.itempesticides_array));
					etRate.setHint(R.string.ratekg);
					j=2;
					break;
				case 3:
					adapterItem=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.tools_assets_array));
				
					etRate.setHint(R.string.rate);
					j=3;
					
					break;
				

				default:
					break;
				}
				
				spinnerItem.setAdapter(adapterItem);
				
			
				
				
				
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	
		
		
		return rootView;
		
	}
class UpdateTask extends AsyncTask<String, Void, String>
{

	@Override
	protected String doInBackground(String... params) {
		
		String json=params[0];
		String registerUrl=params[1];
		String imagepath=params[2];

		HttpPost postRequest=new HttpPost(registerUrl);
		
		//set parameter in post request
		BasicNameValuePair pair1=new BasicNameValuePair("json", json);
	
		BasicNameValuePair pair2=new BasicNameValuePair("id", imagepath);
		ArrayList<BasicNameValuePair> listParams=new ArrayList<BasicNameValuePair>();
		listParams.add(pair1);
		listParams.add(pair2);
		//int	result1 = 0;
		String temp="0";
		try {
		
			UrlEncodedFormEntity entity=new UrlEncodedFormEntity(listParams);
			
			postRequest.setEntity(entity);
			
			//send req to the server
			HttpClient client=new DefaultHttpClient();
			HttpResponse response=client.execute(postRequest);		
			InputStream input=response.getEntity().getContent();
			InputStreamReader read=new InputStreamReader(input);
			BufferedReader br=new BufferedReader(read);
			
			temp=br.readLine();
			
		//	int result=Integer.parseInt(temp);
	//		Log.e("RESULT-------->", "he -------"+temp);
			br.close();
			return temp;
		
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return temp;
	}//eof of doInBack
	@Override
	protected void onPostExecute(String rst) {
		// TODO Auto-generated method stub
		super.onPostExecute(rst);

		
		if(rst.equals("0"))
		{
		
			Toast.makeText(getActivity(), "Something went wrong !!", Toast.LENGTH_LONG).show();
			
		}
		else 
		{	
			
		Toast.makeText(getActivity(),"id"+rst, Toast.LENGTH_LONG).show();
		
			
		}
	}
	



}


}

