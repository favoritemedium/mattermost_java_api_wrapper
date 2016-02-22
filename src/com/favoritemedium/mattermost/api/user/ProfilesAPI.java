package com.favoritemedium.mattermost.api.user;

import java.util.Map;

import com.favoritemedium.mattermost.api.common.Request;
import com.favoritemedium.mattermost.api.common.Response;
import com.favoritemedium.mattermost.models.user.Profiles;
import com.favoritemedium.mattermost.models.user.User;

public class ProfilesAPI extends Request<Profiles> {

	private final static String path = "users/profiles";
	
	public ProfilesAPI() {
		super(path);
	}
	
	@Override
	protected Response processRequest(String... params) {
		return doGet();
	}

	@Override
	protected Profiles getObjectFromJson(String json) {
		Map<String, User> profiles = User.buildFromJsonMap(json);
		return new Profiles(profiles);
	}
	
}
