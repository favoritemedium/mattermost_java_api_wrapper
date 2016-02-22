package com.favoritemedium.mattermost.models.channel;

import com.favoritemedium.mattermost.models.common.BaseComplexModel;
import com.google.gson.annotations.SerializedName;

public class Channel extends BaseComplexModel {
	
	@SerializedName("type")
	private String type;
	
	@SerializedName("display_name")
	private String displayName;
	
	@SerializedName("name")
	private String name;
	
	@SerializedName("header")
	private String header;
	
	@SerializedName("purpose")
	private String purpose;
	
	@SerializedName("last_post_at")
	private long lastPostAt;
	
	@SerializedName("total_msg_count")
	private long totalMsgCount;
	
	@SerializedName("extra_update_at")
	private long extraUpdateAt;
	
	@SerializedName("creator_id")
	private String creatorId;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public long getLastPostAt() {
		return lastPostAt;
	}
	public void setLastPostAt(long lastPostAt) {
		this.lastPostAt = lastPostAt;
	}
	public long getTotalMsgCount() {
		return totalMsgCount;
	}
	public void setTotalMsgCount(long totalMsgCount) {
		this.totalMsgCount = totalMsgCount;
	}
	public long getExtraUpdateAt() {
		return extraUpdateAt;
	}
	public void setExtraUpdateAt(long extraUpdateAt) {
		this.extraUpdateAt = extraUpdateAt;
	}
	public String getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
}
