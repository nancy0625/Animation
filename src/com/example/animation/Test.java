package com.example.animation;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.json.code.JsonTools;
import com.example.loginjson.http.HttpUtils;
import com.example.loginjson.http.TestHttpUtils;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Test extends Activity{
	private List<String> list;
	private Button btn;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
	
		btn = (Button)findViewById(R.id.btn);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Toast.makeText(Test.this, "woshi ", Toast.LENGTH_SHORT).show();
				new MyTask().execute("http://192.168.1.231:8080/transportservice/type/jason/action/GetTrafficLightConfigAciton.do");
			
				
			}
		});
		

	}
	class MyTask extends AsyncTask<String, Void, List<String>> {
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();

		}

		@Override
		protected List<String> doInBackground(String... params) {
			JSONObject param = new JSONObject();
			try {
				
				param.put("TrafficLightID",2);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String jsonString = TestHttpUtils.sendPostMethod(params[0],param);
			// ½âÎöjsonÊý¾Ý
			//list = JsonTools.paraseList(jsonString);
			Log.i("shuju ",jsonString);
			return list;
		}

		@Override
		protected void onPostExecute(List<String> result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);

			

		}

	}

	


}
