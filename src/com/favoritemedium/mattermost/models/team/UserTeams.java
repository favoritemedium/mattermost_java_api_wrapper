package com.favoritemedium.mattermost.models.team;

import java.util.Map;

public class UserTeams {

	private Map<String, Team> teams;
	
	public UserTeams(Map<String, Team> teams) {
		this.teams = teams;
	}
	
	public Map<String, Team> getTeams() {
		return teams;
	}
}
