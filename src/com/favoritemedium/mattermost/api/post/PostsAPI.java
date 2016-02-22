package com.favoritemedium.mattermost.api.post;

import com.favoritemedium.mattermost.api.common.Request;
import com.favoritemedium.mattermost.api.common.Response;
import com.favoritemedium.mattermost.models.channel.ChannelPosts;

public class PostsAPI extends Request<ChannelPosts> {

	private final static String pathSelectedPosts = "channels/%s/posts/%s/%s";
	private final static String pathAllPosts 	  = "channels/%s/posts/%s";
	
	public PostsAPI(String channelId, int start, int end) {
		super(String.format(pathSelectedPosts, channelId, start, end));
	}
	
	public PostsAPI(String channelId, int start) {
		super(String.format(pathAllPosts, channelId, start));
	}
	
	@Override
	protected Response processRequest(String... params) {
		return doGet();
	}

	@Override
	protected ChannelPosts getObjectFromJson(String json) {
		return ChannelPosts.buildFromJson(json);
	}

}
