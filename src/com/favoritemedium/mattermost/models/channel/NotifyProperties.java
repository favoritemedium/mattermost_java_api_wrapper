package com.favoritemedium.mattermost.models.channel;

import com.google.gson.annotations.SerializedName;

public class NotifyProperties {

	@SerializedName("desktop")
	private String desktop;
	
	@SerializedName("mark_unread")
	private String markUnread;
	
	public String getDesktop() {
		return desktop;
	}
	public void setDesktop(String desktop) {
		this.desktop = desktop;
	}
	public String getMarkUnread() {
		return markUnread;
	}
	public void setMarkUnread(String markUnread) {
		this.markUnread = markUnread;
	}
	
	
}
