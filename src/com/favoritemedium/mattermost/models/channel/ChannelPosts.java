package com.favoritemedium.mattermost.models.channel;

import java.util.List;
import java.util.Map;

import com.favoritemedium.mattermost.models.common.BaseSimpleModel;
import com.favoritemedium.mattermost.models.post.Post;
import com.google.gson.annotations.SerializedName;

public class ChannelPosts extends BaseSimpleModel {

	@SerializedName("order")
	private List<String> order;
	
	@SerializedName("posts")
	private Map<String, Post> posts;

	public List<String> getOrder() {
		return order;
	}

	public void setOrder(List<String> order) {
		this.order = order;
	}

	public Map<String, Post> getPosts() {
		return posts;
	}

	public void setPosts(Map<String, Post> posts) {
		this.posts = posts;
	}
	
	public static ChannelPosts buildFromJson(String json) {
		return buildFromJson(json, ChannelPosts.class);
	}
}
