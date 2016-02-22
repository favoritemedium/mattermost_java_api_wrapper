package com.favoritemedium.mattermost.api.channel;

import com.favoritemedium.mattermost.api.common.Request;
import com.favoritemedium.mattermost.api.common.Response;
import com.favoritemedium.mattermost.models.channel.ChannelUserDetails;

public class ChannelExtraInfoAPI extends Request<ChannelUserDetails> {

	private static final String path = "channels/%s/extra_info";

	public ChannelExtraInfoAPI(String channelId) {
		super(String.format(path, channelId));
	}

	@Override
	protected Response processRequest(String... params) {
		return doGet();
	}

	@Override
	protected ChannelUserDetails getObjectFromJson(String json) {
		return ChannelUserDetails.buildFromJson(json);
	}

}
