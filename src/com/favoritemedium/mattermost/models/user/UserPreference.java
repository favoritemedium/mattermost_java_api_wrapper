package com.favoritemedium.mattermost.models.user;

import com.favoritemedium.mattermost.models.common.BaseSimpleModel;
import com.google.gson.annotations.SerializedName;

public class UserPreference extends BaseSimpleModel {

	@SerializedName("user_id")
	private String userId;
	
	@SerializedName("category")
	private String category;
	
	@SerializedName("name")
	private String name;
	
	@SerializedName("value")
	private String value;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static UserPreference[] buildFromJson(String json) {
		return buildFromJsonArray(json, UserPreference[].class);
	}
}
