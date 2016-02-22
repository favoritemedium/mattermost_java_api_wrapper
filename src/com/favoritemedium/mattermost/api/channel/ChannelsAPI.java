package com.favoritemedium.mattermost.api.channel;

import com.favoritemedium.mattermost.api.common.Request;
import com.favoritemedium.mattermost.api.common.Response;
import com.favoritemedium.mattermost.models.channel.ChannelDetails;

public class ChannelsAPI extends Request<ChannelDetails> {

	private static final String path = "channels/?_=%s";
	
	public ChannelsAPI() {
		super(String.format(path, System.currentTimeMillis()));
	}

	@Override
	protected Response processRequest(String... params) {
		return doGet();
	}

	@Override
	protected ChannelDetails getObjectFromJson(String json) {
		return ChannelDetails.buildFromJson(json);
	}
}
