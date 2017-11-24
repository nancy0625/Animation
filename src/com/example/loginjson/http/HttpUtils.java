package com.example.loginjson.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpUtils {

	public HttpUtils() {

	}

	/**
	 * 
	 * @param path
	 *            获取指定路径的json信息
	 * 
	 * @param encode指定编码格式
	 * @return
	 */
	public static String sendPostMethod(String path, String encode) {
		String result = "";
		HttpClient httpClient = new DefaultHttpClient();
		try {

			HttpPost post = new HttpPost(path);
			HttpResponse response = httpClient.execute(post);
			if (response.getStatusLine().getStatusCode() == 200) {
				result = EntityUtils.toString(response.getEntity());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
		return result;
	}

}
