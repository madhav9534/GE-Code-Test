package com.ge.exercise1;

import java.util.Collection;
import java.util.List;

public class MyApplication extends Application {

	public MyApplication(String id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}
	
	public List<User> user;
	public List<Group> group;

	@Override
	public Collection<User> getUsers() {
		// TODO Auto-generated method stub
		return user;
	}

	@Override
	public User getUser(String userId) {
		for(User u:user){
			if(u.getId().equals(userId)){
				return u;
			}
		}
		return null;
	}

	@Override
	public Collection<Group> getGroups() {
		// TODO Auto-generated method stub
		return group;
	}

	@Override
	public Group getGroup(String groupId) {
		for(Group g:group){
			if(g.getId().equals(groupId) ){
				return g;
			}
		}
		return null;
	}

}
