package com.favoritemedium.mattermost.models.user;

import java.util.Arrays;
import java.util.List;

public class Preferences {

	private List<UserPreference> preferences;
	
	public Preferences(List<UserPreference> preferences) {
		this.preferences = preferences;
	}
	
	public Preferences(UserPreference[] preferences) {
		this.preferences = Arrays.asList(preferences);
	}
	
	public List<UserPreference> getPreferences() {
		return preferences;
	}
}
