package com.favoritemedium.mattermost.models.channel;

import com.favoritemedium.mattermost.models.common.BaseSimpleModel;
import com.google.gson.annotations.SerializedName;

public class ChannelUser extends BaseSimpleModel {

	@SerializedName("id")
	private String id;
	
	@SerializedName("nickname")
	private String nickname;
	
	@SerializedName("email")
	private String email;
	
	@SerializedName("roles")
	private String roles;
	
	@SerializedName("username")
	private String username;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
