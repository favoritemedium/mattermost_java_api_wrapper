package com.favoritemedium.mattermost.models.team;

import java.lang.reflect.Type;
import java.util.Map;

import com.favoritemedium.mattermost.models.common.BaseComplexModel;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

public class Team extends BaseComplexModel {

	@SerializedName("display_name")
	private String displayName;
	
	@SerializedName("name")
	private String name;
	
	@SerializedName("email")
	private String email;
	
	@SerializedName("type")
	private String type;
	
	@SerializedName("company_name")
	private String companyName;
	
	@SerializedName("allowed_domains")
	private String allowedDomains;
	
	@SerializedName("invite_id")
	private String inviteId;
	
	@SerializedName("allow_open_invite")
	private boolean allowOpenInvite;
	
	@SerializedName("allow_team_listing")
	private boolean allowTeamListing;

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getName() {
		return displayName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAllowedDomains() {
		return allowedDomains;
	}

	public void setAllowedDomains(String allowedDomains) {
		this.allowedDomains = allowedDomains;
	}

	public String getInviteId() {
		return inviteId;
	}

	public void setInviteId(String inviteId) {
		this.inviteId = inviteId;
	}

	public boolean isAllowOpenInvite() {
		return allowOpenInvite;
	}

	public void setAllowOpenInvite(boolean allowOpenInvite) {
		this.allowOpenInvite = allowOpenInvite;
	}

	public boolean isAllowTeamListing() {
		return allowTeamListing;
	}

	public void setAllowTeamListing(boolean allowTeamListing) {
		this.allowTeamListing = allowTeamListing;
	}
	
	public static Team buildFromJson(String json) {
		return buildFromJson(json, Team.class);
	}
	
	public static Map<String, Team> buildFromJsonMap(String json) {
		Type type = new TypeToken<Map<String, Team>>(){}.getType();
		return gson.fromJson(json, type);
	}
	
}
