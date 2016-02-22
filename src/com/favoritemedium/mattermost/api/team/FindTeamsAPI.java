package com.favoritemedium.mattermost.api.team;

import java.util.Map;

import com.favoritemedium.mattermost.api.common.Request;
import com.favoritemedium.mattermost.api.common.Response;
import com.favoritemedium.mattermost.models.team.Team;
import com.favoritemedium.mattermost.models.team.UserTeams;
import com.google.gson.JsonObject;

public class FindTeamsAPI extends Request<UserTeams> {

	private final static String path = "teams/find_teams";
	
	public FindTeamsAPI() {
		super(path);
	}
	
	private JsonObject getPayload(String email) {
		JsonObject payload = new JsonObject();
		payload.addProperty("email", email);
		return payload;
	}

	@Override
	protected Response processRequest(String... params) {
		if (params == null || params.length == 0) {
			return new Response(-1, "Missing parameter: email");
		}
		String email = params[0];
		JsonObject payload = getPayload(email);
		Response resp = doPost(payload.toString(), false);
		return resp;
	}

	@Override
	protected UserTeams getObjectFromJson(String json) {
		Map<String, Team> teams = Team.buildFromJsonMap(json);
		return new UserTeams(teams);
	}
}
