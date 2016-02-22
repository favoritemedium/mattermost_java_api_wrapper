package com.favoritemedium.mattermost.api;

import java.util.List;
import java.util.Map;

import com.favoritemedium.mattermost.api.channel.ChannelExtraInfoAPI;
import com.favoritemedium.mattermost.api.channel.ChannelsAPI;
import com.favoritemedium.mattermost.api.common.F;
import com.favoritemedium.mattermost.api.post.CreateAPI;
import com.favoritemedium.mattermost.api.post.PostsAPI;
import com.favoritemedium.mattermost.api.team.FindTeamsAPI;
import com.favoritemedium.mattermost.api.team.TeamAPI;
import com.favoritemedium.mattermost.api.user.LoginAPI;
import com.favoritemedium.mattermost.api.user.PreferencesAPI;
import com.favoritemedium.mattermost.api.user.ProfilesAPI;
import com.favoritemedium.mattermost.models.channel.ChannelDetails;
import com.favoritemedium.mattermost.models.channel.ChannelPosts;
import com.favoritemedium.mattermost.models.channel.ChannelUserDetails;
import com.favoritemedium.mattermost.models.channel.Member;
import com.favoritemedium.mattermost.models.post.Post;
import com.favoritemedium.mattermost.models.team.Team;
import com.favoritemedium.mattermost.models.team.UserTeams;
import com.favoritemedium.mattermost.models.user.Preferences;
import com.favoritemedium.mattermost.models.user.Profiles;
import com.favoritemedium.mattermost.models.user.User;
import com.favoritemedium.mattermost.models.user.UserPreference;

public class ApiTest {

	private User user = null;
	
	public User getUser() { return user; }
	
	public static void main(String[] args) {
		
		final String teamName = "favorite-medium";
		final String email = "washaq@gmail.com";
		final String password = "qwertyu8";
		
		ApiTest apiTest = new ApiTest();
		
		apiTest.login(teamName, email, password);
		
		apiTest.getChannelsInfo();
		
		apiTest.getPreferences();
		
		apiTest.getTeam();
		
		apiTest.findTeams();
		
		apiTest.getProfiles();
		
		apiTest.sendMessage();
	}
	
	private void login(String teamName, String email, String password) {
		LoginAPI login = new LoginAPI();
		login.makeRequest(new F.Callback<User>() {

			@Override
			public void success(User result) {
				System.out.println("Successfully logged in! id = " + result.getId());
				user = result;
			}

			@Override
			public void failure(int errorCode, String errorMessage) {
				System.err.println("Failed to login: [" + errorCode + "] - " + errorMessage);
			}
		}, teamName, email, password);
	}
	
	private void getChannelsInfo() {
		ChannelsAPI channels = new ChannelsAPI();
		channels.makeRequest(new F.Callback<ChannelDetails>() {

			@Override
			public void success(ChannelDetails result) {
				
				Map<String, Member> members = result.getMembers();
				
				for (String key : members.keySet()) {
					Member member = members.get(key);
					String channelId = member.getChanneId();
					System.out.println("Processing Channel, id = " + channelId);
					
					getChannelExtraInfo(channelId);
					getPosts(channelId, 0, 3);
				}
			}

			@Override
			public void failure(int errorCode, String errorMessage) {
				System.err.println("Failed to get channels: [" + errorCode + "] - " + errorMessage);				
			}
		});
	}
	
	private void getChannelExtraInfo(String channelId) {
		ChannelExtraInfoAPI extraInfo = new ChannelExtraInfoAPI(channelId);
		extraInfo.makeRequest(new F.Callback<ChannelUserDetails>() {
			@Override
			public void success(ChannelUserDetails result) {
				System.out.println("Channel Extra Info, member count = " + result.getMemberCount());
			}

			@Override
			public void failure(int errorCode, String errorMessage) {
				System.err.println("Failed to get channel extra info: [" + errorCode + "] - " + errorMessage);
			}
		});
	}
	
	private void getPosts(String channelId, int start, int end) {
		PostsAPI postsApi = new PostsAPI(channelId, start, end);
		postsApi.makeRequest(new F.Callback<ChannelPosts>() {

			@Override
			public void success(ChannelPosts result) {
				Map<String, Post> posts = result.getPosts();
				for (String postKey : posts.keySet()) {
					Post post = posts.get(postKey);
					System.out.println(post.getMessage());
				}
			}

			@Override
			public void failure(int errorCode, String errorMessage) {
				System.err.println("Failed to get posts: [" + errorCode + "] - " + errorMessage);
			}
		});
	}
	
	private void getPreferences() {
		PreferencesAPI prefApi = new PreferencesAPI();
		prefApi.makeRequest(new F.Callback<Preferences>() {

			@Override
			public void success(Preferences result) {
				List<UserPreference> preferences = result.getPreferences();
				System.out.println("Preference: " + preferences.get(0).getName() + " = " + preferences.get(0).getValue());
			}

			@Override
			public void failure(int errorCode, String errorMessage) {
				System.err.println("Failed to get preferences: [" + errorCode + "] - " + errorMessage);
			}
		});
	}
	
	private void getTeam() {
		TeamAPI teamApi = new TeamAPI();
		teamApi.makeRequest(new F.Callback<Team>() {
			@Override
			public void success(Team result) {
				System.out.println("Team = " + result.getDisplayName());
			}

			@Override
			public void failure(int errorCode, String errorMessage) {
				System.err.println("Failed to get team: [" + errorCode + "] - " + errorMessage);
			}
		});
	}
	
	private void findTeams() {
		FindTeamsAPI findTeams = new FindTeamsAPI();
		findTeams.makeRequest(new F.Callback<UserTeams>() {
			
			@Override
			public void success(UserTeams result) {
				Map<String, Team> userTeams = result.getTeams();
				for (String key : userTeams.keySet()) {
					System.out.println(key + " = " + userTeams.get(key).getDisplayName());
				}
			}

			@Override
			public void failure(int errorCode, String errorMessage) {
				System.err.println("Failed to find teams: [" + errorCode + "] - " + errorMessage);
			}
		},this.user.getEmail());
	}
	
	private void getProfiles() {
		ProfilesAPI profileApi = new ProfilesAPI();
		profileApi.makeRequest(new F.Callback<Profiles>() {
			@Override
			public void success(Profiles result) {
				Map<String, User> profiles = result.getProfiles();
				System.out.println(profiles.get(user.getId()).getEmail());
			}

			@Override
			public void failure(int errorCode, String errorMessage) {
				System.err.println("Failed to get profiles: [" + errorCode + "] - " + errorMessage);
			}
		});
	}
	
	private void sendMessage() {
		String message = "this is a test message from the java api wrapper";
		CreateAPI createApi = new CreateAPI("t97b5h7cspypuycukj6fse5cyy");
		createApi.makeRequest(new F.Callback<Post>() {
			@Override
			public void success(Post result) {
				System.out.println("New post created: " + result.getId());
			}

			@Override
			public void failure(int errorCode, String errorMessage) {
				System.err.println("Failed to create new post: [" + errorCode + "] - " + errorMessage);
			}
		}, user.getId(), message);
	}
}
