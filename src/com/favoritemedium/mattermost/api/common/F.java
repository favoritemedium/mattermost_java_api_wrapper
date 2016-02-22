package com.favoritemedium.mattermost.api.common;

public class F {
	
	public static interface Callback<T> {
		public void success(T result);
		public void failure(int errorCode, String errorMessage);
	}
	
}
