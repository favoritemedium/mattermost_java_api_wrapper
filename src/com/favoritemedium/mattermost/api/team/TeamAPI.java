package com.favoritemedium.mattermost.api.team;

import com.favoritemedium.mattermost.api.common.Request;
import com.favoritemedium.mattermost.api.common.Response;
import com.favoritemedium.mattermost.models.team.Team;

public class TeamAPI extends Request<Team> {

	private final static String path = "teams/me";
	
	public TeamAPI() {
		super(path);
	}

	@Override
	protected Response processRequest(String... params) {
		return doGet();
	}

	@Override
	protected Team getObjectFromJson(String json) {
		return Team.buildFromJson(json);
	}

}
