package com.favoritemedium.mattermost.models.common;

import com.favoritemedium.mattermost.models.channel.Channel;
import com.favoritemedium.mattermost.models.post.Post;
import com.favoritemedium.mattermost.models.team.Team;
import com.favoritemedium.mattermost.models.user.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public abstract class BaseComplexModel extends AbstractModel {
	
	@SerializedName("id")
	protected String id;
	
	@SerializedName("create_at")
	protected long createdAt;
	
	@SerializedName("update_at")
	protected long updatedAt;
	
	@SerializedName("delete_at")
	protected long deletedAt;
	
	@SerializedName("team_id")
	protected String teamId;
	
	protected final static Gson gson;
	private final static RuntimeTypeAdapterFactory<BaseComplexModel> factory;
	
	static {
		factory = RuntimeTypeAdapterFactory.of(BaseComplexModel.class)
				.registerSubtype(User.class)
				.registerSubtype(Post.class)
				.registerSubtype(Team.class)
				.registerSubtype(Channel.class);
		
		gson = new GsonBuilder().registerTypeAdapterFactory(factory)
								.serializeNulls()
								.create();
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}
	public long getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(long updatedAt) {
		this.updatedAt = updatedAt;
	}
	public long getDeletedAt() {
		return deletedAt;
	}
	public void setDeletedAt(long deletedAt) {
		this.deletedAt = deletedAt;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	protected static <T extends BaseComplexModel> T buildFromJson(String json, Class<? extends BaseComplexModel> classOfT) {
		return gson.fromJson(json, classOfT);
	}
	
	public String toJson() {
		return gson.toJson(this);
	}
}
