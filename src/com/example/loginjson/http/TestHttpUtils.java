package com.example.loginjson.http;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class TestHttpUtils {

	public TestHttpUtils() {

	}

	/**
	 * 
	 * @param path
	 *            ��ȡָ��·����json��Ϣ
	 * 
	 * @param encodeָ�������ʽ
	 * @return
	 */
	public static String sendPostMethod(String path,JSONObject json) {
		
		String result = "";
		
		DefaultHttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(path);
		
		try{
		StringEntity s = new StringEntity(json.toString());
		s.setContentEncoding("UTF-8");
		s.setContentType("application/json");
		post.setEntity(s);
		HttpResponse res = client.execute(post)
;			if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity entity = res.getEntity();
				result = EntityUtils.toString(res.getEntity());//����json��ʽ
				//response = JSONObject.f
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.getConnectionManager().shutdown();
		}
		return result;
	
       }

}
