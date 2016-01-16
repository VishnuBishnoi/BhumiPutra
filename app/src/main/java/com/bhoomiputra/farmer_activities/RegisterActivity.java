package com.bhoomiputra.farmer_activities;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.bhoomiputra.farmer_dto.Farmer;
import com.example.bhumiputra.R;
import com.bhoomiputra.farmer_dto.Address;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class RegisterActivity extends Activity {
	
	
	EditText etname,etpassword,etmobile;
	Button btncontinue;

	EditText etdistrict,ettehsil,etvillage,ethouseno,etpincode;

	Spinner spinnerstate,spinerUsersType;
	ImageView images;
	
	Farmer farmer=null;
	String name=null;
	long mobileno=0;
	String password=null;
	ArrayAdapter<String> adapterstates,adapterUsserType;

	String[] stateName={"Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chhattisgarh","Goa","Gujarat","Haryana","Himachal Pradesh","Jammu and Kashmir","Jharkhand","Karnataka","Kerala","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha","Puducherry","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttar Pradesh","Uttarakhand","West Bengal"};

	String imgDecodableString;
	  private static int RESULT_LOAD_IMG = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
	       etname=(EditText)findViewById(R.id.editText6);
	       etpassword=(EditText)findViewById(R.id.editText7);
	       etmobile=(EditText)findViewById(R.id.editText8);

			btncontinue=(Button)findViewById(R.id.button1);
	
			images=(ImageView)findViewById(R.id.imageView1);
			etdistrict=(EditText)findViewById(R.id.editText1);
			ettehsil=(EditText)findViewById(R.id.editText2);
			etvillage=(EditText)findViewById(R.id.editText3);
			ethouseno=(EditText)findViewById(R.id.editText4);
			etpincode=(EditText)findViewById(R.id.editText5);


		spinnerstate=(Spinner)findViewById(R.id.spinner2);
        spinerUsersType=(Spinner)findViewById(R.id.spinner1);
		//	btnGallary.setOnClickListener(new OnClickListener() {





		adapterstates=new ArrayAdapter<String>(RegisterActivity.this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.state_array));
		spinnerstate.setAdapter(adapterstates);
        adapterUsserType=new ArrayAdapter<String>(RegisterActivity.this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.user_names_array));
        spinerUsersType.setAdapter(adapterUsserType);



		btncontinue.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				name=etname.getText().toString();
				password=etpassword.getText().toString();
				mobileno=Long.parseLong(etmobile.getText().toString());
				farmer=new Farmer(name,password,mobileno);

				if(name.equals("")||password.equals("")||etmobile.getText().equals(""))
				{
					Toast.makeText(RegisterActivity.this,"Please fill all details", Toast.LENGTH_LONG).show();;
				}

				String district=etdistrict.getText().toString();
				String tehsil=ettehsil.getText().toString();
				String village=etvillage.getText().toString();
				String housenoAndBlock=ethouseno.getText().toString();
				int pincode=Integer.parseInt(etpincode.getText().toString());
				String state=stateName[ spinnerstate.getSelectedItemPosition()];

				Address address=new Address(village,housenoAndBlock, tehsil, district, state, pincode);

				farmer.setAddr(address);


                Gson gson =new GsonBuilder().create();
                String json=gson.toJson(farmer);
                Toast.makeText(RegisterActivity.this,json, Toast.LENGTH_LONG).show();
                String registerUrl=BhumiPutraApi.FARMER_REGESTER;
                RegisterTask task=new RegisterTask();


                String	_path = Environment.getExternalStorageDirectory().getAbsolutePath().toString();

                Log.e("path",_path);
                _path= _path + "/" + "temp"+".jpg";

                //	Bitmap bitmap = BitmapFactory.decodeFile(_path);

                task.execute(json, registerUrl, _path);



			}
		});



	}
			
			
	/*		@Override
			public void onClick(View v) {
				Intent galleryIntent = new Intent(Intent.ACTION_PICK,
				        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				// Start the Intent
				startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
			}
		});*/
		



	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK
                    && null != data) {
                // Get the Image from data
 
                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };
               
                // Get the cursor
                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();
 
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgDecodableString = cursor.getString(columnIndex);
                cursor.close();
               
                // Set the Image in ImageView after decoding the String
               
                Bitmap bm=Bitmap.createScaledBitmap(BitmapFactory.decodeFile(imgDecodableString), 150, 150, false);
                images.setImageBitmap(bm);
                saveBitmap(bm);
                
            } else {
                Toast.makeText(this, "You haven't picked Image",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }
 
	}
	

	private void saveBitmap(Bitmap image) throws FileNotFoundException{
		try {

					String path = Environment.getExternalStorageDirectory().getAbsolutePath().toString();
					OutputStream fOut = null;
					File file = new File(path,"temp"+".jpg"); // the File to save to
					fOut = new FileOutputStream(file);
					 Toast.makeText(this,path,
		                        Toast.LENGTH_LONG).show();
					Bitmap pictureBitmap =image; // obtaining the Bitmap
					pictureBitmap.compress(Bitmap.CompressFormat.JPEG, 85, fOut); // saving the Bitmap to a file compressed as a JPEG with 85% compression rate
					
					MediaStore.Images.Media.insertImage(getContentResolver(),file.getAbsolutePath(),file.getName(),file.getName());
					fOut.flush();
					fOut.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
		 }



class RegisterTask extends AsyncTask<String, Void, String>
{

    @Override
    protected String doInBackground(String... params) {

        String json=params[0];
        String registerUrl=params[1];
        String imagepath=params[2];
        Bitmap btmap=BitmapFactory.decodeFile(imagepath);
        ByteArrayOutputStream bt=new ByteArrayOutputStream();
        btmap.compress(Bitmap.CompressFormat.JPEG, 100, bt);
        byte[] btArray=bt.toByteArray();
        String img= Base64.encodeToString(btArray, Base64.DEFAULT);
        //Log.e("image path", img);

        //send values using post method
        HttpPost postRequest=new HttpPost(registerUrl);

        //set parameter in post request
        BasicNameValuePair pair1=new BasicNameValuePair("json", json);

        BasicNameValuePair pair2=new BasicNameValuePair("image", img);
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
        Log.e("Id",""+rst);

        if(rst.equals("0"))
        {

            Toast.makeText(RegisterActivity.this, "Something went wrong !!", Toast.LENGTH_LONG).show();

        }
        else
        {

			/*SharedPreferences sp=getSharedPreferences("settings",MODE_PRIVATE);
			SharedPreferences.Editor editor=sp.edit();
			editor.putInt("f_id",Integer.parseInt(rst));
			editor.commit();*/
            Toast.makeText(RegisterActivity.this,"id"+rst, Toast.LENGTH_LONG).show();
            Intent intent=new Intent(RegisterActivity.this, FarmerLoginActivity.class);
            startActivity(intent);

        }
    }

}
}
