package com.favoritemedium.mattermost.models.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BaseSimpleModel extends AbstractModel {

	private final static Gson gson = new GsonBuilder().create();
	
	protected static <T extends BaseSimpleModel> T buildFromJson(String json, Class<? extends BaseSimpleModel> classOfT) {
		return gson.fromJson(json, classOfT);
	}
	
	protected static <T extends BaseSimpleModel> T[] buildFromJsonArray(String json, Class<? extends BaseSimpleModel[]> classOfT) {
		return gson.fromJson(json, classOfT);
	}
	
	public String toJson() {
		return gson.toJson(this);
	}
}
