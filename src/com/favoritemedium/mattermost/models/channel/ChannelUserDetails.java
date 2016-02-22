package com.favoritemedium.mattermost.models.channel;

import java.util.List;

import com.favoritemedium.mattermost.models.common.BaseSimpleModel;
import com.google.gson.annotations.SerializedName;

public class ChannelUserDetails extends BaseSimpleModel {
	
	@SerializedName("members")
	private List<ChannelUser> channelUsers;
	
	@SerializedName("member_count")
	private int memberCount;

	public List<ChannelUser> getChannelUsers() {
		return channelUsers;
	}

	public void setChannelUsers(List<ChannelUser> channelUsers) {
		this.channelUsers = channelUsers;
	}

	public int getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}
	
	public static ChannelUserDetails buildFromJson(String json) {
		return buildFromJson(json, ChannelUserDetails.class);
	}
}
