package com.favoritemedium.mattermost.api.post;

import com.favoritemedium.mattermost.api.common.Request;
import com.favoritemedium.mattermost.api.common.Response;
import com.favoritemedium.mattermost.models.post.Post;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class CreateAPI extends Request<Post> {

	private final static String path = "channels/%s/create";
	private String channelId;
	
	public CreateAPI(String channelId) {
		super(String.format(path, channelId));
		this.channelId = channelId;
	}
	
	private JsonObject getPayload(String userId, String message) {
		long now = System.currentTimeMillis();
		String postId = userId + ":" + now;
		JsonObject payload = new JsonObject();
		
		payload.addProperty("user_id", userId);
		payload.addProperty("channel_id", this.channelId);
		payload.addProperty("create_at", now);
		payload.addProperty("pending_post_id", postId);
		payload.addProperty("state", "loading");
		payload.addProperty("message", message);
		payload.add("filenames", new JsonArray());
		
		return payload;
	}

	@Override
	protected Response processRequest(String... params) {
		String userId = params[0];
		if (params == null || params.length < 1) {
			return new Response(-1, "Missing parameter: userId");
		}
		String message = params[1];
		if (params.length < 2) {
			return new Response(-1, "Missing parameter: message");
		}
		JsonObject payload = getPayload(userId, message);
		Response resp = doPost(payload.toString(), true);
		return resp;
	}

	@Override
	protected Post getObjectFromJson(String json) {
		return Post.buildFromJson(json);
	}

	
}
