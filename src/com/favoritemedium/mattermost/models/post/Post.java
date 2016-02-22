package com.favoritemedium.mattermost.models.post;

import java.util.List;

import com.favoritemedium.mattermost.models.common.BaseComplexModel;
import com.google.gson.annotations.SerializedName;

public class Post extends BaseComplexModel {
	
	@SerializedName("user_id")
	private String userId;
	
	@SerializedName("channel_id")
	private String channelId;
	
	@SerializedName("root_id")
	private String rootId;
	
	@SerializedName("parent_id")
	private String parentId;
	
	@SerializedName("original_id")
	private String originalId;
	
	@SerializedName("message")
	private String message;
	
	@SerializedName("type")
	private String type;
	
	@SerializedName("hash_tags")
	private String hashTags;
	
	@SerializedName("filenames")
	private List<String> filenames;
	
	@SerializedName("pending_post_id")
	private String pendingPostId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public String getRootId() {
		return rootId;
	}
	public void setRootId(String rootId) {
		this.rootId = rootId;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getOriginalId() {
		return originalId;
	}
	public void setOriginalId(String originalId) {
		this.originalId = originalId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getHashTags() {
		return hashTags;
	}
	public void setHashTags(String hashTags) {
		this.hashTags = hashTags;
	}
	public List<String> getFilenames() {
		return filenames;
	}
	public void setFilenames(List<String> filenames) {
		this.filenames = filenames;
	}
	public String getPendingPostId() {
		return pendingPostId;
	}
	public void setPendingPostId(String pendingPostId) {
		this.pendingPostId = pendingPostId;
	}
	
	public static Post buildFromJson(String json) {
		return buildFromJson(json, Post.class);
	}
}
