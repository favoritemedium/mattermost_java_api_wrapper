package com.favoritemedium.mattermost.api.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import com.favoritemedium.mattermost.api.common.F.Callback;
import com.favoritemedium.mattermost.api.exception.CookiesDisabledException;

abstract public class Request<T> implements API<T> {

	public enum HttpMethod {
		GET,
		POST
	}
	
	private final static String COOKIES_HEADER = "Set-Cookie";
	protected final static CookieManager cookieManager = new java.net.CookieManager();
	private final String baseUrl = "http://mattermost.favoritemedium.net/api/v1/";
	private final int connectTimeOut = 30 * 60 * 1000; // 30 seconds
	private final int readTimeOut = 2 * 60 * 60 * 1000; // 2 minutes
	private String apiPath = null;
	
	protected Request(String apiPath) {
		this.apiPath = apiPath;
	}
	
	protected Response doGet() {
		String url = baseUrl + apiPath;
		InputStream is;
		StringBuffer sb = new StringBuffer();
		int respCode = 500;
		HttpURLConnection con = null;
		String errorMsg = null;
		
		try {
			con = openConnection(url, HttpMethod.GET, true);
			is = con.getInputStream();
			respCode = con.getResponseCode();
			if (is == null) {
				throw new RuntimeException("Could not get InputStream while invoking: " + url);
			}
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String line = null;
			while ((line = reader.readLine()) != null) {
			    sb.append(line);
			}
			is.close();
		} catch (IOException e) {
			errorMsg = e.getMessage();
		} catch (CookiesDisabledException e) {
			errorMsg = e.getMessage();
		}
		

		if (con != null && errorMsg == null) {
			Map<String, List<String>> headerFields = con.getHeaderFields();
			List<String> cookiesHeader = headerFields.get(COOKIES_HEADER);
	
			if(cookiesHeader != null) {
			    for (String cookie : cookiesHeader) {
			      cookieManager.getCookieStore().add(null,HttpCookie.parse(cookie).get(0));
			    }               
			}
			
			closeConnection(con);
		}
		
		Response apiResponse = new Response();
		apiResponse.setResponseCode(respCode);
		if (respCode == HttpURLConnection.HTTP_OK) {
			apiResponse.setData(sb.toString());
		}
		else {
			apiResponse.setError(true);
			apiResponse.setErrorMessage(errorMsg);
			apiResponse.setErrorCode(respCode);
		}
		
		return apiResponse;
	}
	
	protected Response doPost(String payload, boolean sendCookies) {
		String url = baseUrl + apiPath;
		OutputStream os = null;
		StringBuffer sb = new StringBuffer();
		int respCode = 500;
		HttpURLConnection con = null;
		String errorMsg = null;
		
		try {
			con = openConnection(url, HttpMethod.POST, sendCookies);
			os = con.getOutputStream();
		} catch (IOException e) {
			errorMsg = e.getMessage();
		} catch (CookiesDisabledException e) {
			errorMsg = e.getMessage();
		}
		
		if (con != null && errorMsg == null) {
			if (os == null) {
				throw new RuntimeException("Could not get OutputStream while invoking: " + url);
			}
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));
			pw.write(payload);
			pw.close();
			
			InputStream is;
			
			try {
				is = con.getInputStream();
				respCode = con.getResponseCode();
				if (is == null) {
					throw new RuntimeException("Could not get InputStream while invoking: " + url);
				}
				BufferedReader reader = new BufferedReader(new InputStreamReader(is));
				String line = null;
				while ((line = reader.readLine()) != null) {
				    sb.append(line);
				}
				is.close();
			} catch (IOException e) {
				errorMsg = e.getMessage();
			}
			
			List<String> cookiesHeader = con.getHeaderFields().get(COOKIES_HEADER);
			if(cookiesHeader != null) {
			    for (String cookie : cookiesHeader) {
			      cookieManager.getCookieStore().add(null,HttpCookie.parse(cookie).get(0));
			    }               
			}
			
			closeConnection(con);
		}
		
		Response apiResponse = new Response();
		apiResponse.setResponseCode(respCode);
		if (respCode == HttpURLConnection.HTTP_OK) {
			apiResponse.setData(sb.toString());
		}
		else {
			apiResponse.setError(true);
			apiResponse.setErrorMessage(errorMsg);
			apiResponse.setErrorCode(respCode);
		}
		
		return apiResponse;
	}
		
	private HttpURLConnection openConnection(String url, HttpMethod method, boolean sendCookies) throws IOException, CookiesDisabledException {
		URL obj;
		HttpURLConnection con = null;
		obj = new URL(url);
		con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod(method.toString());
		con.setRequestProperty("Content-Type", "application/json");
		con.setConnectTimeout(connectTimeOut);
		con.setReadTimeout(readTimeOut);
		con.setUseCaches(false);
		con.setDoInput(true);
		con.setDoOutput(true);
		if (sendCookies) {
			List<HttpCookie> cookies = cookieManager.getCookieStore().getCookies();
			if (cookies.isEmpty()) {
				throw new CookiesDisabledException("Need to send cookies but none found stored");
			}
			else {
				for (HttpCookie cookie : cookies) {
					String cookieStr = cookie.getName() + "=" + cookie.getValue();
					con.addRequestProperty("Cookie", cookieStr);
				}
			}
		}
		con.connect();		
		return con;
	}
	
	private void closeConnection(HttpURLConnection con) {
		con.disconnect();
	}
	
	protected abstract Response processRequest(String... params);
	protected abstract T getObjectFromJson(String json);
	
	@Override
	public void makeRequest(Callback<T> callback, String... params) {
		Response resp = processRequest(params);
		if (resp != null && !resp.isError()) {
			T object = getObjectFromJson(resp.getData());
			callback.success(object);
		}
		else {
			callback.failure(resp.getErrorCode(), resp.getErrorMessage());
		}
	}
}
