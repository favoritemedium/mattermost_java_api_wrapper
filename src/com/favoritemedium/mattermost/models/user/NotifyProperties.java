package com.favoritemedium.mattermost.models.user;

import com.favoritemedium.mattermost.models.common.BaseSimpleModel;
import com.google.gson.annotations.SerializedName;

public class NotifyProperties extends BaseSimpleModel {

	@SerializedName("all")
	private String all;
	
	@SerializedName("channel")
	private String channel;
	
	@SerializedName("desktop")
	private String desktop;
	
	@SerializedName("desktop_sound")
	private String desktopSound;
	
	@SerializedName("email")
	private String email;
	
	@SerializedName("first_name")
	private String firstName;
	
	@SerializedName("mention_keys")
	private String mentionKeys;
	
	public String getAll() {
		return all;
	}
	public void setAll(String all) {
		this.all = all;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getDesktop() {
		return desktop;
	}
	public void setDesktop(String desktop) {
		this.desktop = desktop;
	}
	public String getDesktopSound() {
		return desktopSound;
	}
	public void setDesktopSound(String desktopSound) {
		this.desktopSound = desktopSound;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMentionKeys() {
		return mentionKeys;
	}
	public void setMentionKeys(String mentionKeys) {
		this.mentionKeys = mentionKeys;
	}
	
	
}
