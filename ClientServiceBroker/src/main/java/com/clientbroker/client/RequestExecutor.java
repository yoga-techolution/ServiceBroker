package com.clientbroker.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Component;

import com.clientbroker.util.Constants;

@Component
public class RequestExecutor {
	
	private String sendRequest(String urlParam, String requestMethod){
		String output = null;		
		try {

			URL url = new URL(Constants.URL+urlParam);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(requestMethod);

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			while ((output = br.readLine()) != null) {
				conn.disconnect();
				return output;
			}
			
		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		return output;

	}

	public String getRequest(String url){
		return sendRequest(url, Constants.GET);
	}

	public String doPostRequest(String url){
		return sendRequest(url, Constants.POST);
	}
}



