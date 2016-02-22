package com.favoritemedium.mattermost.models.channel;

import java.util.List;
import java.util.Map;

import com.favoritemedium.mattermost.models.common.BaseSimpleModel;
import com.google.gson.annotations.SerializedName;

public class ChannelDetails extends BaseSimpleModel {

	@SerializedName("channels")
	private List<Channel> channels;
	
	@SerializedName("members")
	private Map<String, Member> members;

	public List<Channel> getChannels() {
		return channels;
	}

	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}

	public Map<String, Member> getMembers() {
		return members;
	}

	public void setMembers(Map<String, Member> members) {
		this.members = members;
	}
	
	public static ChannelDetails buildFromJson(String json) {
		return buildFromJson(json, ChannelDetails.class);
	}
}
