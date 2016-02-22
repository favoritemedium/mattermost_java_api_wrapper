package com.favoritemedium.mattermost.api.common;

public interface API<T> {

	public void makeRequest(F.Callback<T> callback, String... params);
}
