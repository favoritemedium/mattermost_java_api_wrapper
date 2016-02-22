package com.favoritemedium.mattermost.models.user;

import java.util.Map;

public class Profiles {

	private Map<String, User> profiles;
	
	public Profiles(Map<String, User> profiles) {
		this.profiles = profiles;
	}
	
	public Map<String, User> getProfiles() {
		return profiles;
	}
}
