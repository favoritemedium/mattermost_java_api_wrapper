package com.favoritemedium.mattermost.api.user;

import com.favoritemedium.mattermost.api.common.Request;
import com.favoritemedium.mattermost.api.common.Response;
import com.favoritemedium.mattermost.models.user.Preferences;
import com.favoritemedium.mattermost.models.user.UserPreference;

public class PreferencesAPI extends Request<Preferences> {

	private final static String path = "preferences/";
	
	public PreferencesAPI() {
		super(path);
	}

	@Override
	protected Response processRequest(String... params) {
		return doGet();
	}

	@Override
	protected Preferences getObjectFromJson(String json) {
		UserPreference[] preferences = UserPreference.buildFromJson(json);
		return new Preferences(preferences);
	}
}
