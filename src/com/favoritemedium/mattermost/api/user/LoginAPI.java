package com.favoritemedium.mattermost.api.user;

import com.favoritemedium.mattermost.api.common.Request;
import com.favoritemedium.mattermost.api.common.Response;
import com.favoritemedium.mattermost.models.user.User;
import com.google.gson.JsonObject;

public class LoginAPI extends Request<User> {

	private static final String path = "users/login";
	
	public LoginAPI() {
		super(path);
	}
	
	private JsonObject getPayload(String teamName, String email, String password) {
		JsonObject req = new JsonObject();
		req.addProperty("name", teamName);
		req.addProperty("email", email);
		req.addProperty("password", password);
		return req;
	}

	@Override
	protected Response processRequest(String... params) {
		if (params == null || params.length < 1) {
			return new Response(-1, "Missing parameter: teamName");
		}
		String teamName = params[0];
		if (params.length < 2) {
			return new Response(-1, "Missing parameter: email");
		}
		String email = params[1];
		if (params.length < 3) {
			return new Response(-1, "Missing parameter: password");
		}
		String password = params[2];
		
		JsonObject payload = getPayload(teamName, email, password);
		Response resp = doPost(payload.toString(), false);
		return resp;
	}

	@Override
	protected User getObjectFromJson(String json) {
		return User.buildFromJson(json);
	}
}
