package com.favoritemedium.mattermost.models.user;

import java.lang.reflect.Type;
import java.util.Map;

import com.favoritemedium.mattermost.models.common.BaseComplexModel;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

public class User extends BaseComplexModel {
		
	@SerializedName("username")
	private String username;
	
	@SerializedName("auth_service")
	private String authService;
	
	@SerializedName("email")
	private String email;
	
	@SerializedName("email_verified")
	private boolean emailVerified;
	
	@SerializedName("nickname")
	private String nickname;
	
	@SerializedName("first_name")
	private String firstName;
	
	@SerializedName("last_name")
	private String lastName;
	
	@SerializedName("last_activity_at")
	private long lastActivityAt;
	
	@SerializedName("last_ping_at")
	private long lastPingAt;
	
	@SerializedName("allow_marketing")
	private boolean allowMarketing;
	
	@SerializedName("last_password_update")
	private long lastPasswordUpdatedAt;
	
	@SerializedName("last_picture_update")
	private long lastPictureUpdatedAt;
	
	@SerializedName("locale")
	private String locale;
	
	@SerializedName("roles")
	private String roles;
	
	@SerializedName("notify_props")
	private NotifyProperties notifyProps;
	
	@SerializedName("theme_props")
	private ThemeProperties themeProps;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAuthService() {
		return authService;
	}
	public void setAuthService(String authService) {
		this.authService = authService;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isEmailVerified() {
		return emailVerified;
	}
	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getLastActivityAt() {
		return lastActivityAt;
	}
	public void setLastActivityAt(long lastActivityAt) {
		this.lastActivityAt = lastActivityAt;
	}
	public long getLastPingAt() {
		return lastPingAt;
	}
	public void setLastPingAt(long lastPingAt) {
		this.lastPingAt = lastPingAt;
	}
	public boolean isAllowMarketing() {
		return allowMarketing;
	}
	public void setAllowMarketing(boolean allowMarketing) {
		this.allowMarketing = allowMarketing;
	}
	public long getLastPasswordUpdatedAt() {
		return lastPasswordUpdatedAt;
	}
	public void setLastPasswordUpdatedAt(long lastPasswordUpdatedAt) {
		this.lastPasswordUpdatedAt = lastPasswordUpdatedAt;
	}
	public long getLastPictureUpdatedAt() {
		return lastPictureUpdatedAt;
	}
	public void setLastPictureUpdatedAt(long lastPictureUpdatedAt) {
		this.lastPictureUpdatedAt = lastPictureUpdatedAt;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public NotifyProperties getNotifyProps() {
		return notifyProps;
	}
	public void setNotifyProps(NotifyProperties notifyProps) {
		this.notifyProps = notifyProps;
	}
	public ThemeProperties getThemeProps() {
		return themeProps;
	}
	public void setThemeProps(ThemeProperties themeProps) {
		this.themeProps = themeProps;
	}
	
	public static User buildFromJson(String json) {
		return buildFromJson(json, User.class);
	}
	
	public static Map<String, User> buildFromJsonMap(String json) {
		Type type = new TypeToken<Map<String, User>>(){}.getType();
		return gson.fromJson(json, type);
	}
}
