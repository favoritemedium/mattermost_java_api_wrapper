package com.favoritemedium.mattermost.models.channel;

import com.favoritemedium.mattermost.models.common.BaseSimpleModel;
import com.google.gson.annotations.SerializedName;

public class Member extends BaseSimpleModel {

	@SerializedName("channel_id")
	private String channeId;
	
	@SerializedName("user_id")
	private String userId;
	
	@SerializedName("roles")
	private String roles;
	
	@SerializedName("last_viewed_at")
	private long lastViewedAt;
	
	@SerializedName("msg_count")
	private long msgCount;
	
	@SerializedName("mention_count")
	private long mentionCount;
	
	@SerializedName("notify_props")
	private NotifyProperties notifyProps = new NotifyProperties();
	
	@SerializedName("last_update_at")
	private long lastUpdatedAt;
	
	public String getChanneId() {
		return channeId;
	}
	public void setChanneId(String channeId) {
		this.channeId = channeId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public long getLastViewedAt() {
		return lastViewedAt;
	}
	public void setLastViewedAt(long lastViewedAt) {
		this.lastViewedAt = lastViewedAt;
	}
	public long getMsgCount() {
		return msgCount;
	}
	public void setMsgCount(long msgCount) {
		this.msgCount = msgCount;
	}
	public long getMentionCount() {
		return mentionCount;
	}
	public void setMentionCount(long mentionCount) {
		this.mentionCount = mentionCount;
	}
	public NotifyProperties getNotifyProps() {
		return notifyProps;
	}
	public void setNotifyProps(NotifyProperties notifyProps) {
		this.notifyProps = notifyProps;
	}
	public long getLastUpdatedAt() {
		return lastUpdatedAt;
	}
	public void setLastUpdatedAt(long lastUpdatedAt) {
		this.lastUpdatedAt = lastUpdatedAt;
	}
}
